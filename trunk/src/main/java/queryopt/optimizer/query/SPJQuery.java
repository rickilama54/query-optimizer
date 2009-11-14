package queryopt.optimizer.query;

import java.util.List;

import queryopt.entities.Atribute;
import queryopt.entities.Index;
import queryopt.entities.SystemInfo;

public class SPJQuery implements Term {
	private List<Term> projectionTerms;
	private List<Clause> selectionCnfClauses;
	private List<Atribute> groupingAtributes;
	private List<Clause> havingCnfClauses;

	private SystemInfo systemInfo;
	private List<Index> disabledIndexes;

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

	public SystemInfo getSystemInfo() {
		return systemInfo;
	}

	public void setSystemInfo(SystemInfo systemInfo) {
		this.systemInfo = systemInfo;
	}

	public List<Index> getDisabledIndexes() {
		return disabledIndexes;
	}

	public void setDisabledIndexes(List<Index> disabledIndexes) {
		this.disabledIndexes = disabledIndexes;
	}

}
