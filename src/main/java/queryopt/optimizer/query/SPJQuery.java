package queryopt.optimizer.query;

import java.util.ArrayList;
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

	public SPJQuery() {
		projectionTerms = new ArrayList<Term>();
		selectionCnfClauses = new ArrayList<Clause>();
		groupingAtributes = new ArrayList<Atribute>();
		havingCnfClauses = new ArrayList<Clause>();
	}

	public List<Term> getProjectionTerms() {
		return projectionTerms;
	}

	public List<Clause> getSelectionCnfClauses() {
		return selectionCnfClauses;
	}

	public List<Atribute> getGroupingAtributes() {
		return groupingAtributes;
	}

	public List<Clause> getHavingCnfClauses() {
		return havingCnfClauses;
	}

	public SystemInfo getSystemInfo() {
		return systemInfo;
	}

	public List<Index> getDisabledIndexes() {
		return disabledIndexes;
	}

	public void setSystemInfo(SystemInfo systemInfo) {
		this.systemInfo = systemInfo;
	}

}
