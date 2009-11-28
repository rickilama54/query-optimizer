package queryopt.optimizer.query;

import java.util.List;

import queryopt.entities.Atribute;

public abstract class Clause {
	protected double selectivity;

	public double getSelectivity() {
		return selectivity;
	}

	protected abstract double calcSelectivity() throws Exception;
	
	public abstract List<Atribute> getAtributes();
	
	public abstract boolean isJoinClause();
}
