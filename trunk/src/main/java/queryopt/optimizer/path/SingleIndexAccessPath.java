package queryopt.optimizer.path;

import java.util.HashMap;
import java.util.List;

import queryopt.entities.Index;
import queryopt.optimizer.Utils;
import queryopt.optimizer.entities.Clause;
import queryopt.optimizer.entities.SingleRelationQuery;

public class SingleIndexAccessPath extends AccessPath {
	private Index index;

	public SingleIndexAccessPath(SingleRelationQuery srquery) throws Exception {
		super(srquery);
	}

	public Index getIndex() {
		return index;
	}

	@Override
	protected long calcCost(SingleRelationQuery srquery) throws Exception {
		List<Index> indexes = srquery.getRelation().getIndexes();
		if (indexes.size() == 0)
			throw new Exception("No indexes");

		HashMap<Clause, List<Index>> matchingSelectionIndexes = Utils.getMatchingIndexes(srquery, indexes);

		long cost = Long.MAX_VALUE;

		for (Clause clause : matchingSelectionIndexes.keySet()) {
			for (Index index : matchingSelectionIndexes.get(clause)) {
				long costIndexClause = 0;
				if (Utils.isPkIndex(index))
					costIndexClause = this.getCostPrimaryIndex(clause, index, srquery);
				else
					costIndexClause = this.getCostSecondaryIndex(clause, index, srquery);

				if (costIndexClause < cost) {
					cost = costIndexClause;
					this.index = index;
				}
			}
		}
		return cost;
	}

	/*
	 * The primary key index is always an ordered index. Only index.getLevels()
	 * steps to retrieve first record. TODO implement index.noOfPages();
	 */
	private long getCostPrimaryIndex(Clause clause, Index index, SingleRelationQuery srquery) {
		long relationPages = Utils.getRelationSizeInPages(srquery.getRelation(), srquery.getSystemInfo());
		long cost = index.getLevels();

		// Table scan
		cost += (long) Math.ceil(clause.getSelectivity() * relationPages);

		return cost;
	}

	/*
	 * The primary key index is always an ordered index. Only index.getLevels()
	 * steps to retrieve first record. TODO implement index.noOfPages();
	 */
	private long getCostSecondaryIndex(Clause clause, Index index, SingleRelationQuery srquery) {
		long rows = srquery.getRelation().getNoOfRows();
		long cost = index.getLevels();

		// Index Scan
		cost += (long) Math.ceil(clause.getSelectivity()
				* Utils.getNoOfFirstLevelIndexPages(index, srquery.getSystemInfo()));
		// Table Scan
		cost += (long) Math.ceil(clause.getSelectivity() * rows);
		return cost;
	}
}
