package queryopt.optimizer.path;

import queryopt.entities.Relation;
import queryopt.optimizer.Plan;
import queryopt.optimizer.Utils;
import queryopt.optimizer.query.SingleRelationQuery;

public abstract class AccessPath implements Plan {
	private Relation outputRelation;
	private Relation inputRelation;
	private long cost;

	public AccessPath(SingleRelationQuery srquery) throws Exception {
		super();
		this.inputRelation = srquery.getRelation();
		cost = calcCost(srquery);
		this.outputRelation = Utils.getOutputRelation(srquery);
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
