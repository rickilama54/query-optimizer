package queryopt.optimizer.join;

import queryopt.entities.Relation;
import queryopt.optimizer.RelAlgebraOperation;
import queryopt.optimizer.path.AccessPath;

public class Join implements RelAlgebraOperation {
	private RelAlgebraOperation left;
	private AccessPath right;
	private Relation outputRelation;

	public Join(RelAlgebraOperation left, AccessPath right) {
		super();
		this.left = left;
		this.right = right;
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

}
