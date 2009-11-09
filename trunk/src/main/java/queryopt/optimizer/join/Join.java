package queryopt.optimizer.join;

import java.util.List;

import queryopt.entities.Relation;
import queryopt.optimizer.Plan;
import queryopt.optimizer.path.AccessPath;
import queryopt.optimizer.query.CompareSingleRowClause;

public abstract class Join implements Plan {
	protected Plan left;
	protected AccessPath right;
	protected Relation outputRelation;
	protected long cost;

	public Join(Plan left, AccessPath right, List<CompareSingleRowClause> joinClauses) {
		super();
		this.left = left;
		this.right = right;
		this.cost = calcCost(joinClauses);
	}

	public Relation getOutputRelation() {
		return this.outputRelation;
	}

	public Plan getLeft() {
		return left;
	}

	public AccessPath getRight() {
		return right;
	}

	public long getCost() {
		return cost;
	}

	protected abstract long calcCost(List<CompareSingleRowClause> joinClauses);

}
