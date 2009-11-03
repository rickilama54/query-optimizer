package queryopt.optimizer.path;

import queryopt.optimizer.Utils;
import queryopt.optimizer.entities.Clause;
import queryopt.optimizer.entities.SingleRelationQuery;

public class FullTableScan extends AccessPath {

	public FullTableScan(SingleRelationQuery srquery) throws Exception {
		super(srquery);
	}

	@Override
	protected long calcCost(SingleRelationQuery srquery) throws Exception {
		long tablesize = Utils.getRelationSizeInPages(srquery.getRelation(), srquery.getSystemInfo());

		// Is there a group by clause in the query
		if (srquery.getGroupingAtributes().size() == 0)
			return tablesize;
		else {
			double selectivity = 1.0;
			for (Clause clause : srquery.getSelectionCnfClauses())
				selectivity *= clause.getSelectivity();

			long sizeOfTempRelation = (long) Math.ceil(tablesize * selectivity);
			long sortingCost = 3 * sizeOfTempRelation;

			return tablesize + sizeOfTempRelation + sortingCost;
		}
	}

}
