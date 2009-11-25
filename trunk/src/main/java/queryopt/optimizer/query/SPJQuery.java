package queryopt.optimizer.query;

import java.util.ArrayList;
import java.util.List;

import queryopt.entities.Atribute;
import queryopt.entities.Index;
import queryopt.entities.SystemInfo;

public class SPJQuery implements Term {
	private List<Term> projectionTerms;
	private List<Clause> selectionCnfClauses;
	private List<JoinClause> joinClauses;
	private List<Atribute> groupingAtributes;
	private List<Clause> havingCnfClauses;

	private SystemInfo systemInfo;
	private List<Index> disabledIndexes;

	public SPJQuery() {
		projectionTerms = new ArrayList<Term>();
		selectionCnfClauses = new ArrayList<Clause>();
		joinClauses = new ArrayList<JoinClause>();
		groupingAtributes = new ArrayList<Atribute>();
		havingCnfClauses = new ArrayList<Clause>();
		disabledIndexes = new ArrayList<Index>();
	}

	public List<Term> getProjectionTerms() {
		return projectionTerms;
	}

	public List<Clause> getSelectionCnfClauses() {
		return selectionCnfClauses;
	}

	public List<JoinClause> getJoinClauses() {
		return joinClauses;
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SPJQuery:");

		sb.append("\n\tProjectionTerms: ");
		for (Term t : this.projectionTerms)
			sb.append(t + ", ");
		if (this.projectionTerms.size() > 0)
			sb.setLength(sb.length() - 2);
		else
			sb.append("empty");

		sb.append("\n\tSelectionCnfClauses: ");
		for (Clause c : this.selectionCnfClauses)
			sb.append(c + ", ");
		if (this.selectionCnfClauses.size() > 0)
			sb.setLength(sb.length() - 2);
		else
			sb.append("empty");

		sb.append("\n\tJoinClauses: ");
		for (JoinClause jc : this.joinClauses)
			sb.append(jc + ", ");
		if (this.joinClauses.size() > 0)
			sb.setLength(sb.length() - 2);
		else
			sb.append("empty");
		return sb.toString();
	}

}
