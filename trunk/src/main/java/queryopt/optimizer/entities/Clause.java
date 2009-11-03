package queryopt.optimizer.entities;

public abstract class Clause {
	protected double selectivity;

	public double getSelectivity() {
		return selectivity;
	}

	protected abstract double calcSelectivity();
}
