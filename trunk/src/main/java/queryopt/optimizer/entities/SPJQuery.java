package queryopt.optimizer.entities;

import java.util.List;

import queryopt.entities.Atribute;

public class SPJQuery {
	private List<Term> projectionTerms;
	private List<Clause> selectionCnfClauses;
	private List<Atribute> groupingAtributes;
	private List<Clause> havingCnfClauses;

	public List<Term> getProjectionTerms() {
		return projectionTerms;
	}

	public void setProjectionTerms(List<Term> projectionTerms) {
		this.projectionTerms = projectionTerms;
	}

	public List<Clause> getSelectionCnfClauses() {
		return selectionCnfClauses;
	}

	public void setSelectionCnfClauses(List<Clause> selectionCnfClauses) {
		this.selectionCnfClauses = selectionCnfClauses;
	}

	public List<Atribute> getGroupingAtributes() {
		return groupingAtributes;
	}

	public void setGroupingAtributes(List<Atribute> groupingAtributes) {
		this.groupingAtributes = groupingAtributes;
	}

	public List<Clause> getHavingCnfClauses() {
		return havingCnfClauses;
	}

	public void setHavingCnfClauses(List<Clause> havingCnfClauses) {
		this.havingCnfClauses = havingCnfClauses;
	}

}
