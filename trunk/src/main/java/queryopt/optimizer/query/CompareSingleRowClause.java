package queryopt.optimizer.query;

import java.util.ArrayList;
import java.util.List;

import queryopt.entities.Atribute;

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

	@Override
	protected double calcSelectivity() {
		if (operand1 instanceof Literal && operand2 instanceof Literal)
			return calcSelectivityTwoLiterals((Literal) operand1, (Literal) operand2, operator);
		else if (operand1 instanceof Literal && operand2 instanceof Atribute)
			return calcSelectivityLiteralAtribute((Literal) operand1, (Atribute) operand2, operator);
		else if (operand1 instanceof Atribute && operand2 instanceof Literal)
			return calcSelectivityLiteralAtribute((Literal) operand2, (Atribute) operand1, operator);
		else if (operand1 instanceof Atribute && operand2 instanceof Atribute)
			return calcSelectivityAtributeAtribute((Atribute) operand1, (Atribute) operand2, operator);

		return 0.0;
	}

	/*
	 * Join
	 */
	private static double calcSelectivityAtributeAtribute(Atribute a1, Atribute a2, Operator operator) {
		return 0.0;
	}

	private static double calcSelectivityLiteralAtribute(Literal l1, Atribute atribute, Operator operator) {
		String high = atribute.getHigh();
		String low = atribute.getLow();
		String literal = l1.getValue();

		if (literal.compareTo(high) > 0)
			return 0.0;
		if (literal.compareTo(low) < 0)
			return 0.0;

		double selectivity = 1.0;
		switch (operator) {
		case EQ:
			selectivity = atribute.getDistinct() / atribute.getRelation().getNoOfRows();
			break;
		case DIFF:
			selectivity = 1 - atribute.getDistinct() / atribute.getRelation().getNoOfRows();
			break;
		case GT:
		case GT_EQ:
			double distanceLow = literal.compareTo(low);
			double distanceHigh = literal.compareTo(high);
			selectivity = distanceHigh / (distanceHigh + distanceLow);
			break;
		case LS:
		case LS_EQ:
			distanceLow = literal.compareTo(low);
			distanceHigh = literal.compareTo(high);
			selectivity = distanceLow / (distanceHigh + distanceLow);
			break;
		}
		return selectivity;
	}

	@SuppressWarnings("unchecked")
	private static double calcSelectivityTwoLiterals(Literal l1, Literal l2, Operator operator) {
		Comparable c1, c2;
		try {
			c1 = Double.valueOf(l1.getValue());
			c2 = Double.valueOf(l2.getValue());
		} catch (NumberFormatException e) {
			c1 = l1.getValue();
			c2 = l2.getValue();
		}
		boolean condition = false;
		switch (operator) {
		case EQ:
			condition = c1.compareTo(c2) == 0;
			break;
		case DIFF:
			condition = c1.compareTo(c2) != 0;
			break;
		case GT:
			condition = c1.compareTo(c2) > 0;
			break;
		case GT_EQ:
			condition = c1.compareTo(c2) >= 0;
			break;
		case LS:
			condition = c1.compareTo(c2) < 0;
			break;
		case LS_EQ:
			condition = c1.compareTo(c2) <= 0;
			break;
		}
		return condition ? 1.0 : 0.0;
	}

	@Override
	public List<Atribute> getAtributes() {
		List<Atribute> list = new ArrayList<Atribute>();
		if (operand1 instanceof Atribute)
			list.add((Atribute) operand1);
		if (operand2 instanceof Atribute)
			list.add((Atribute) operand2);
		return list;
	}
}
