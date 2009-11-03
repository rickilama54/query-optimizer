package queryopt.optimizer.entities;

import java.util.List;

import queryopt.entities.Atribute;

public abstract class Clause {
	protected double selectivity;

	public double getSelectivity() {
		return selectivity;
	}

	protected abstract double calcSelectivity();
	
	public abstract List<Atribute> getAtributes();
}
