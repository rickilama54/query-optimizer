package queryopt.optimizer.path;

import queryopt.entities.Relation;
import queryopt.optimizer.RelAlgebraOperation;
import queryopt.optimizer.query.SingleRelationQuery;

public abstract class AccessPath implements RelAlgebraOperation {
	private Relation outputRelation;
	private Relation inputRelation;
	private long cost;

	public AccessPath(SingleRelationQuery srquery) throws Exception {
		super();
		this.inputRelation = srquery.getRelation();
		cost = calcCost(srquery);
	}

	public Relation getOutputRelation() {
		return this.outputRelation;
	}

	public Relation getInputRelation() {
		return inputRelation;
	}

	public long getCost() {
		return cost;
	}

	protected abstract long calcCost(SingleRelationQuery srquery) throws Exception;
}
