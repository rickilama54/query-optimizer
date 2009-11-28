package queryopt.optimizer.path;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import queryopt.entities.Atribute;
import queryopt.entities.Index;
import queryopt.optimizer.Utils;
import queryopt.optimizer.query.Clause;
import queryopt.optimizer.query.SingleRelationQuery;

public class MultipleIndexAccessPath extends AccessPath {
	private static final String NAME = "Miltiple index RID intersection";

	private List<Index> ridIndexes;

	public MultipleIndexAccessPath(SingleRelationQuery srquery) throws Exception {
		super(srquery);
	}

	@Override
	protected String getName() {
		return NAME;
	}

	@Override
	protected String getPrefix() {
		StringBuilder specificOutput = new StringBuilder();
		specificOutput.append("on " + this.getInputRelation().getName() + " ");
		specificOutput.append("using indexes:");
		for (Index index : ridIndexes)
			specificOutput.append(index.getName() + ", ");
		specificOutput.replace(specificOutput.length() - 2, specificOutput.length() - 1, "");
		return specificOutput.toString();
	}

	@Override
	protected String getSufix() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("Index Cond: ");
		// TODO
		return sb.toString();
	}

	@Override
	protected long calcCost(SingleRelationQuery srquery) throws Exception {
		List<Index> indexes = srquery.getRelation().getIndexes();
		if (indexes.size() == 0)
			throw new Exception("No indexes");

		HashMap<Index, HashMap<Clause, Atribute>> ridIndexesIntersection = Utils.getMatchingSelectionIndexes(srquery,
				indexes);

		// Eliminate indexes with subsets attributes of each other
		List<Index> redundantIndexes = new ArrayList<Index>();
		for (Index index1 : ridIndexesIntersection.keySet())
			for (Index index2 : ridIndexesIntersection.keySet())
				if (ridIndexesIntersection.get(index1).values()
						.containsAll(ridIndexesIntersection.get(index2).values()))
					redundantIndexes.add(index2);

		for (Index index : redundantIndexes)
			ridIndexesIntersection.remove(index);

		long selectionIndexesScan = 0;

		// Retrieve first Row
		for (Index index : ridIndexesIntersection.keySet())
			selectionIndexesScan += index.getLevels();

		// Selection Index Scans
		for (Index index : ridIndexesIntersection.keySet()) {
			double clausesSelectivity = 1.0;
			Collection<Clause> clauses = ridIndexesIntersection.get(index).keySet();
			for (Clause clause : clauses)
				clausesSelectivity *= (long) Math.ceil(clause.getSelectivity());
			selectionIndexesScan += clausesSelectivity
					* Utils.getNoOfFirstLevelIndexPages(index, srquery.getSystemInfo());
		}

		List<Clause> indexedClauses = new ArrayList<Clause>();
		for (Index index : ridIndexesIntersection.keySet())
			indexedClauses.addAll(ridIndexesIntersection.get(index).keySet());

		// Eliminate duplicate clauses
		HashSet<Clause> hs = new HashSet<Clause>(indexedClauses);
		indexedClauses.clear();
		indexedClauses.addAll(hs);

		double totalSelectivity = 1.0;
		for (Clause clause : indexedClauses)
			totalSelectivity *= clause.getSelectivity();

		// One Table Scan
		long rows = srquery.getRelation().getNoOfRows();
		long tableScan = (long) Math.ceil(totalSelectivity * rows);

		long cost = selectionIndexesScan + tableScan;

		ridIndexes = new ArrayList<Index>();
		ridIndexes.addAll(ridIndexesIntersection.keySet());

		// Index Only Scans
		if (Utils.isIndexOnlyScanPossible(indexes, srquery)) {
			List<Atribute> remainingAtributes = new ArrayList<Atribute>();
			remainingAtributes.addAll(srquery.getGroupingAtributes());
			remainingAtributes.addAll(srquery.getProjectionAtributes());
			// Remove Duplicates
			HashSet<Atribute> hsa = new HashSet<Atribute>(remainingAtributes);
			remainingAtributes.clear();
			remainingAtributes.addAll(hsa);

			for (HashMap<Clause, Atribute> ca : ridIndexesIntersection.values())
				remainingAtributes.removeAll(ca.values());

			HashMap<Index, List<Atribute>> fullIndexScanIndexes = Utils.getMinimalSetOfIndexesForAtributes(
					remainingAtributes, indexes);

			List<Index> repeatingIndexes = new ArrayList<Index>();
			for (Index index : fullIndexScanIndexes.keySet())
				if (ridIndexesIntersection.containsKey(index))
					repeatingIndexes.add(index);
			for (Index index : repeatingIndexes)
				fullIndexScanIndexes.remove(index);

			long indexOnlyScanCost = 0;
			// Price to go to first leaf + price of retrieving all index pages
			for (Index index : fullIndexScanIndexes.keySet())
				indexOnlyScanCost += index.getLevels()
						+ Utils.getNoOfFirstLevelIndexPages(index, srquery.getSystemInfo());

			if (indexOnlyScanCost < tableScan) {
				cost = selectionIndexesScan + indexOnlyScanCost;
				ridIndexes.clear();
				ridIndexes.addAll(ridIndexesIntersection.keySet());
				ridIndexes.addAll(fullIndexScanIndexes.keySet());
			}
		}

		return cost;
	}
}
