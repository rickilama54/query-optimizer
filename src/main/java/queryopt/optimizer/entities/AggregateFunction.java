package queryopt.optimizer.entities;

import queryopt.entities.Atribute;

enum AggregateFunctionType {
	SUM, MIN, MAX
}

public class AggregateFunction implements Term {
	private Atribute atribute;
	private AggregateFunctionType type;

	public AggregateFunction(Atribute atribute, AggregateFunctionType type) {
		super();
		this.atribute = atribute;
		this.type = type;
	}

	public Atribute getAtribute() {
		return atribute;
	}

	public void setAtribute(Atribute atribute) {
		this.atribute = atribute;
	}

	public AggregateFunctionType getType() {
		return type;
	}

	public void setType(AggregateFunctionType type) {
		this.type = type;
	}

}
