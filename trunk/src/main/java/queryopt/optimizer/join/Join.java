package queryopt.optimizer.join;

import queryopt.entities.Relation;
import queryopt.optimizer.Plan;
import queryopt.optimizer.path.AccessPath;
import queryopt.optimizer.query.JoinQuery;

public abstract class Join implements Plan {

	private JoinQuery joinQuery;

	protected Relation outputRelation;
	protected long cost;

	public Join(JoinQuery joinQuery) {
		super();
		this.joinQuery = joinQuery;
		this.cost = calcCost(joinQuery);
		// outputrelation !!!
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
