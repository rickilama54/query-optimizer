package queryopt.optimizer.query;

import queryopt.entities.Atribute;

public class JoinClause extends CompareSingleRowClause {

	public JoinClause(Operator operator, Atribute atribute1, Atribute atribute2) {
		super(operator, atribute1, atribute2);
	}

	public Atribute getAtribute1() {
		return (Atribute) this.getOperand1();

	}

	public Atribute getAtribute2() {
		return (Atribute) this.getOperand2();

	}
}
