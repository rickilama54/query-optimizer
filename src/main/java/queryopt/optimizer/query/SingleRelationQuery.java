package queryopt.optimizer.query;

import java.util.List;

import queryopt.entities.Atribute;
import queryopt.entities.Relation;
import queryopt.entities.SystemInfo;

public class SingleRelationQuery {
	private SystemInfo systemInfo;

	private Relation relation;

	private List<Atribute> projectionAtributes;
	private List<Clause> selectionCnfClauses;
	private List<Atribute> groupingAtributes;

	public SystemInfo getSystemInfo() {
		return systemInfo;
	}

	public void setSystemInfo(SystemInfo systemInfo) {
		this.systemInfo = systemInfo;
	}

	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

	public List<Atribute> getProjectionAtributes() {
		return projectionAtributes;
	}

	public void setProjectionAtributes(List<Atribute> projectionAtributes) {
		this.projectionAtributes = projectionAtributes;
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

}
