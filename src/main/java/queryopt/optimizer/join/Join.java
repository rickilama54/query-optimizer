package queryopt.optimizer.join;

import queryopt.entities.Relation;
import queryopt.optimizer.Plan;
import queryopt.optimizer.Utils;
import queryopt.optimizer.path.AccessPath;
import queryopt.optimizer.query.JoinQuery;

public abstract class Join extends Plan {

	private JoinQuery joinQuery;

	protected Relation outputRelation;

	public Join(JoinQuery joinQuery) throws Exception {
		super(joinQuery.getSystemInfo());
		this.joinQuery = joinQuery;
		this.cost = calcCost(joinQuery);
		this.outputRelation = Utils.getOutputRelation(joinQuery.getLeft(), joinQuery.getRight(), joinQuery
				.getJoinClauses());
	}

	public Relation getOutputRelation() {
		return this.outputRelation;
	}

	public JoinQuery getJoinQuery() {
		return joinQuery;
	}

	public Plan getLeft() {
		return joinQuery.getLeft();
	}

	public AccessPath getRight() {
		return joinQuery.getRight();
	}

	protected abstract long calcCost(JoinQuery joinquery) throws Exception;

	@Override
	protected String getPrefix() {
		return "";
	}

	@Override
	protected String getSufix() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("\t-> " + this.getLeft().getPlanAsTree().replace("\n", "\n\t   "));
		sb.append("\n");
		sb.append("\t-> " + this.getRight().getPlanAsTree().replace("\n", "\n\t   "));
		return sb.toString();
	}
}
