package queryopt.optimizer.path;

import java.util.HashMap;
import java.util.List;

import queryopt.entities.Index;
import queryopt.optimizer.Utils;
import queryopt.optimizer.query.Clause;
import queryopt.optimizer.query.SingleRelationQuery;

public class SingleIndexAccessPath extends AccessPath {
	private static final String NAME = "Index scan";

	private Index index;

	public SingleIndexAccessPath(SingleRelationQuery srquery) throws Exception {
		super(srquery);
	}

	@Override
	protected String getName() {
		return NAME;
	}

	public Index getIndex() {
		return index;
	}

	@Override
	protected String getClassSpecificOutput() {
		return "using " + this.getIndex().getName();
	}

	@Override
	protected long calcCost(SingleRelationQuery srquery) throws Exception {
		List<Index> indexes = srquery.getRelation().getIndexes();
		if (indexes.size() == 0)
			throw new Exception("No indexes");

		HashMap<Clause, List<Index>> matchingSelectionIndexes = Utils.getMatchingSelectionIndexes(srquery, indexes);

		long cost = Long.MAX_VALUE;

		// Search through index only scans
		for (Index index : indexes) {
			long costIndexOnlyScan = Long.MAX_VALUE;
			if (Utils.areAllAtributesInIndexAndSelectionClauseIsPrefix(index, srquery))
				costIndexOnlyScan = this.getCostSecondaryIndexOnlyAccess(true, index, srquery);
			else if (Utils.areAllAtributesInIndexAndSelectionClauseIsNotPrefix(index, srquery))
				costIndexOnlyScan = this.getCostSecondaryIndexOnlyAccess(false, index, srquery);

			if (costIndexOnlyScan < cost) {
				cost = costIndexOnlyScan;
				this.index = index;
			}
		}

		// Search through primary indexes and secondary indexes
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
	 * steps to retrieve first record.
	 */
	private long getCostPrimaryIndex(Clause clause, Index index, SingleRelationQuery srquery) {
		long relationPages = Utils.getRelationSizeInPages(srquery.getRelation(), srquery.getSystemInfo());
		long cost = index.getLevels();

		// Index Scan
		cost += (long) Math.ceil(clause.getSelectivity()
				* Utils.getNoOfFirstLevelIndexPages(index, srquery.getSystemInfo()));

		// Table scan
		cost += (long) Math.ceil(clause.getSelectivity() * relationPages);

		return cost;
	}

	/*
	 * B+ tree index. The table file is not clustered on the indexing attribute.
	 * Therefore at most selectivity * rows pages are read from disk.
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

	/*
	 * B+ tree index. The table file is not clustered on the indexing attribute.
	 * All the attributes are in the index and an index only scan is needed to
	 * retrieve resulting rows. If the selection (WHERE) clause is a prefix on
	 * the index attributes list than a search on the selection attributes is
	 * performed, else a whole index scan is done.
	 */
	private long getCostSecondaryIndexOnlyAccess(boolean isSelectionPrefixOfIndex, Index index,
			SingleRelationQuery srquery) {

		long cost = index.getLevels();

		double totalSelectivity = 1.0;
		for (Clause clause : srquery.getSelectionCnfClauses())
			totalSelectivity *= clause.getSelectivity();

		// Index Scan
		if (isSelectionPrefixOfIndex)
			// Scan on the search attributes
			cost += (long) Math.ceil(totalSelectivity
					* Utils.getNoOfFirstLevelIndexPages(index, srquery.getSystemInfo()));
		else
			// Scan the whole index
			cost += Utils.getNoOfFirstLevelIndexPages(index, srquery.getSystemInfo());

		return cost;
	}
}
