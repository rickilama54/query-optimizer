package queryopt.optimizer.path;

import queryopt.entities.Relation;
import queryopt.optimizer.RelAlgebraOperation;

public class AccessPath implements RelAlgebraOperation {
	private Relation outputRelation;
	private Relation inputRelation;

	public AccessPath(Relation inputRelation) {
		super();
		this.inputRelation = inputRelation;
	}

	public Relation getOutputRelation() {
		return this.outputRelation;
	}

	public Relation getInputRelation() {
		return inputRelation;
	}

}
