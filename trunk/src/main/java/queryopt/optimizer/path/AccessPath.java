package queryopt.optimizer.path;

import queryopt.entities.Relation;
import queryopt.optimizer.Plan;
import queryopt.optimizer.Utils;
import queryopt.optimizer.query.SingleRelationQuery;

public abstract class AccessPath implements Plan {
	private Relation outputRelation;
	private Relation inputRelation;
	private long cost;
	private SingleRelationQuery srquery;

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

	protected abstract String getName();

	public String getPlanAsTree() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getName());
		sb.append(" on ");
		sb.append(this.getInputRelation().getName());
		sb.append(" (");
		sb.append("cost=" + cost);
		sb.append(" ");
		sb.append("rows=" + this.getOutputRelation().getNoOfRows());
		sb.append(" ");
		sb.append("width=" + Utils.getRelationSizeInBytes(this.getOutputRelation(), srquery.getSystemInfo()) + " b");
		sb.append(")");
		return null;
	}
}
