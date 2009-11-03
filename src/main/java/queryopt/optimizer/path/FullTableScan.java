package queryopt.optimizer.path;

import queryopt.optimizer.entities.Clause;
import queryopt.optimizer.entities.SingleRelationQuery;

public class FullTableScan extends AccessPath {

	public FullTableScan(SingleRelationQuery srquery) throws Exception {
		super(srquery);
	}

	@Override
	protected long calcCost(SingleRelationQuery srquery) throws Exception {
		long filescan = srquery.getRelation().getTotalSizeInBytes();

		// Is there a group by clause in the query
		if (srquery.getGroupingAtributes().size() == 0)
			return filescan;
		else {
			double selectivity = 1.0;
			for (Clause clause : srquery.getSelectionCnfClauses())
				selectivity *= clause.getSelectivity();

			long sizeOfTempRelationBytes = (long) Math.ceil(filescan * selectivity);
			long sortingCost = 3 * sizeOfTempRelationBytes;

			return filescan + sizeOfTempRelationBytes + sortingCost;
		}
	}

}
