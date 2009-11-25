package queryopt.optimizer.query;

import java.util.ArrayList;
import java.util.List;

import queryopt.entities.Atribute;
import queryopt.entities.SystemInfo;
import queryopt.optimizer.Plan;
import queryopt.optimizer.path.AccessPath;

public class JoinQuery {
	private SystemInfo systemInfo;

	private Plan left;
	private AccessPath right;

	private List<Atribute> projectionAtributes;

	private List<JoinClause> joinClauses;

	public JoinQuery(SystemInfo systemInfo, Plan left, AccessPath right, List<Atribute> projectionAtributes,
			List<JoinClause> joinClauses) {
		super();
		this.systemInfo = systemInfo;
		this.left = left;
		this.right = right;
		this.projectionAtributes = projectionAtributes;
		this.joinClauses = joinClauses;
	}

	public SystemInfo getSystemInfo() {
		return systemInfo;
	}

	public Plan getLeft() {
		return left;
	}

	public AccessPath getRight() {
		return right;
	}

	public List<Atribute> getProjectionAtributes() {
		return projectionAtributes;
	}

	public List<JoinClause> getJoinClauses() {
		return joinClauses;
	}

}
