package queryopt.optimizer.path;

import queryopt.optimizer.Utils;
import queryopt.optimizer.query.Clause;
import queryopt.optimizer.query.SingleRelationQuery;

public class FullTableScan extends AccessPath {

	private static final String NAME = "Full Table Scan";

	public FullTableScan(SingleRelationQuery srquery) throws Exception {
		super(srquery);
	}

	protected String getName() {
		return NAME;
	}

	@Override
	protected String getPrefix() {
		return "on " + this.getInputRelation().getName();
	}

	@Override
	protected String getSufix() {
		if (this.srquery.getSelectionCnfClauses().size() == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("Filter: ");
		sb.append("(");
		for (Clause c : srquery.getSelectionCnfClauses())
			sb.append(c.toString() + " AND ");
		sb.delete(sb.length() - 5, sb.length());
		sb.append(")");
		return sb.toString();
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
