package queryopt.optimizer.path;

import queryopt.entities.Relation;
import queryopt.optimizer.Plan;
import queryopt.optimizer.Utils;
import queryopt.optimizer.query.SingleRelationQuery;

public abstract class AccessPath extends Plan {
	private Relation outputRelation;
	private Relation inputRelation;
	
	protected SingleRelationQuery srquery;
	
	public AccessPath(SingleRelationQuery srquery) throws Exception {
		super(srquery.getSystemInfo());
		this.srquery = srquery;
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

	protected abstract long calcCost(SingleRelationQuery joinquery) throws Exception;
	
}
