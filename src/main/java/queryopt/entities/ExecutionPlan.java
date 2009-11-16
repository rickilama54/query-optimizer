package queryopt.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "execution_plans", schema = "public")
public class ExecutionPlan {
	private int executionPlanId;
	private boolean error;
	private String message;
	private String executionPlanText;
	private SystemInfo systemInfo;
	private Query query;
	private List<Index> disabledIndexes;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "execution_plan_id", unique = true, nullable = false)
	public int getExecutionPlanId() {
		return executionPlanId;
	}

	public void setExecutionPlanId(int executionPlanId) {
		this.executionPlanId = executionPlanId;
	}

	@Column(name = "error", nullable = false)
	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	@Column(name = "message", nullable = false)
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "execution_plan_text", nullable = false)
	public String getExecutionPlanText() {
		return executionPlanText;
	}

	public void setExecutionPlanText(String executionPlanText) {
		this.executionPlanText = executionPlanText;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "system_info_id", nullable = false)
	public SystemInfo getSystemInfo() {
		return systemInfo;
	}

	public void setSystemInfo(SystemInfo systemInfo) {
		this.systemInfo = systemInfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "query_id", nullable = false)
	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

	@ManyToMany(targetEntity = Index.class, cascade = { CascadeType.ALL })
	public List<Index> getDisabledIndexes() {
		return disabledIndexes;
	}

	public void setDisabledIndexes(List<Index> disabledIndexes) {
		this.disabledIndexes = disabledIndexes;
	}

}
