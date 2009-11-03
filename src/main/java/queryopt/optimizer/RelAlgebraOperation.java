package queryopt.optimizer;

import queryopt.entities.Relation;

public interface RelAlgebraOperation {
	public Relation getOutputRelation();
	public long getCost();
}
