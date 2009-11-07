package queryopt.optimizer.path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import queryopt.entities.Index;
import queryopt.optimizer.Utils;
import queryopt.optimizer.query.Clause;
import queryopt.optimizer.query.SingleRelationQuery;

public class MultipleIndexAccessPath extends AccessPath {

	private List<Index> ridIndexes;

	public MultipleIndexAccessPath(SingleRelationQuery srquery) throws Exception {
		super(srquery);
	}

	@Override
	protected long calcCost(SingleRelationQuery srquery) throws Exception {
		List<Index> indexes = srquery.getRelation().getIndexes();
		if (indexes.size() == 0)
			throw new Exception("No indexes");

		HashMap<Clause, List<Index>> matchingSelectionIndexes = Utils.getMatchingIndexes(srquery, indexes);

		HashMap<Clause, Index> ridIndexesIntersection = new HashMap<Clause, Index>();

		double totalSelectivity = 1.0;

		ridIndexes = new ArrayList<Index>();
		for (Clause clause : matchingSelectionIndexes.keySet())
			if (matchingSelectionIndexes.get(clause).size() > 0) {
				Index index = matchingSelectionIndexes.get(clause).get(0);
				ridIndexesIntersection.put(clause, index);
				ridIndexes.add(index);
				totalSelectivity *= clause.getSelectivity();
			}

		long cost = 0;

		// Retrieve first Row
		for (Index index : ridIndexesIntersection.values())
			cost += index.getLevels();

		// Index Scans
		for (Clause clause : ridIndexesIntersection.keySet()) {
			Index index = ridIndexesIntersection.get(clause);
			cost += (long) Math.ceil(clause.getSelectivity()
					* Utils.getNoOfFirstLevelIndexPages(index, srquery.getSystemInfo()));
		}

		// One Table Scan
		long rows = srquery.getRelation().getNoOfRows();
		cost += (long) Math.ceil(totalSelectivity * rows);

		return cost;
	}

}
