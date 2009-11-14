package queryopt.optimizer.query;

import java.util.ArrayList;
import java.util.List;

import queryopt.entities.Atribute;

public class InClause extends Clause {
	private Atribute operand;
	private SPJQuery subQuery;

	public InClause(Atribute operand, SPJQuery subQuery) {
		super();
		this.operand = operand;
		this.subQuery = subQuery;
		this.selectivity = this.calcSelectivity();
	}

	public Atribute getOperand() {
		return operand;
	}

	public void setOperand(Atribute operand) {
		this.operand = operand;
	}

	public SPJQuery getSubQuery() {
		return subQuery;
	}

	public void setSubQuery(SPJQuery subQuery) {
		this.subQuery = subQuery;
	}

	@Override
	protected double calcSelectivity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Atribute> getAtributes() {
		List<Atribute> list = new ArrayList<Atribute>();
		list.add(operand);
		return list;
	}

	@Override
	public boolean isJoinClause() {
		return false;
	}

}
