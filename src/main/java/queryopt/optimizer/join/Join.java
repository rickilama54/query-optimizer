package queryopt.optimizer.join;

import queryopt.entities.Relation;
import queryopt.optimizer.Plan;
import queryopt.optimizer.Utils;
import queryopt.optimizer.path.AccessPath;
import queryopt.optimizer.query.JoinQuery;

public abstract class Join implements Plan {

	private JoinQuery joinQuery;

	protected Relation outputRelation;
	protected long cost;

	public Join(JoinQuery joinQuery) throws Exception {
		super();
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

	public long getCost() {
		return cost;
	}

	protected abstract long calcCost(JoinQuery joinQuery);

	public String getPlanAsTree() {
		// TODO Auto-generated method stub
		return null;
	}

}
