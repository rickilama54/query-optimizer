package queryopt.optimizer.join;

import java.util.List;

import queryopt.entities.Relation;
import queryopt.optimizer.RelAlgebraOperation;
import queryopt.optimizer.entities.CompareSingleRowClause;
import queryopt.optimizer.path.AccessPath;

public abstract class Join implements RelAlgebraOperation {
	protected RelAlgebraOperation left;
	protected AccessPath right;
	protected Relation outputRelation;
	protected long cost;

	public Join(RelAlgebraOperation left, AccessPath right, List<CompareSingleRowClause> joinClauses) {
		super();
		this.left = left;
		this.right = right;
		this.cost = calcCost(joinClauses);
	}

	public Relation getOutputRelation() {
		return this.outputRelation;
	}

	public RelAlgebraOperation getLeft() {
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
