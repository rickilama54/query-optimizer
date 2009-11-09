package queryopt.optimizer;

import queryopt.entities.Relation;

public interface Plan {
	public Relation getOutputRelation();
	public long getCost();
}
