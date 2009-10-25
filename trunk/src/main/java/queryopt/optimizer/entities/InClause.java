package queryopt.optimizer.entities;

public class InClause extends Clause {
	private Term operand;
	private SPJQuery subQuery;

	public Term getOperand() {
		return operand;
	}

	public void setOperand(Term operand) {
		this.operand = operand;
	}

	public SPJQuery getSubQuery() {
		return subQuery;
	}

	public void setSubQuery(SPJQuery subQuery) {
		this.subQuery = subQuery;
	}

}
