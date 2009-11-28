package queryopt.optimizer.query;

import java.util.ArrayList;
import java.util.List;

import queryopt.entities.Atribute;
import queryopt.entities.Relation;
import queryopt.entities.SystemInfo;

public class SingleRelationQuery {
	private SystemInfo systemInfo;

	private Relation relation;

	private List<Atribute> projectionAtributes;
	private List<Clause> selectionCnfClauses;
	private List<JoinClause> joinClauses;
	private List<Atribute> groupingAtributes;

	public SingleRelationQuery(SystemInfo systemInfo, Relation relation) {
		super();
		this.systemInfo = systemInfo;
		this.relation = relation;
		projectionAtributes = new ArrayList<Atribute>();
		selectionCnfClauses = new ArrayList<Clause>();
		groupingAtributes = new ArrayList<Atribute>();
		joinClauses = new ArrayList<JoinClause>();
	}

	public SystemInfo getSystemInfo() {
		return systemInfo;
	}

	public Relation getRelation() {
		return relation;
	}

	public List<Atribute> getProjectionAtributes() {
		return projectionAtributes;
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

}
