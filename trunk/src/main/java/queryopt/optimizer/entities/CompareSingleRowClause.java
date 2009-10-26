package queryopt.optimizer.entities;

public class CompareSingleRowClause extends Clause {
	private Operator operator;
	private Term operand1;
	private Term operand2;

	public CompareSingleRowClause(Operator operator, Term operand1, Term operand2) {
		super();
		this.operator = operator;
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Term getOperand1() {
		return operand1;
	}

	public void setOperand1(Term operand1) {
		this.operand1 = operand1;
	}

	public Term getOperand2() {
		return operand2;
	}

	public void setOperand2(Term operand2) {
		this.operand2 = operand2;
	}

}
