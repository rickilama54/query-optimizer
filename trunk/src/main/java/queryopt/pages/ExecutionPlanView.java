package queryopt.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import queryopt.entities.ExecutionPlan;

public class ExecutionPlanView {
	@Inject
	private Session session;

	@Property
	private ExecutionPlan executionPlan;

	void onActivate(int executionPlanId) {
		executionPlan = (ExecutionPlan) session.createCriteria(ExecutionPlan.class).add(
				Restrictions.eq("executionPlanId", executionPlanId)).uniqueResult();
	}

	public String getMemorySizeKilobytes() {
		return (double) executionPlan.getSystemInfo().getMemorySizeInBytes() / 1000 + " kB";
	}

	public String getPageSizeKilobytes() {
		return (double) executionPlan.getSystemInfo().getPageSizeInBytes() / 1000 + " kB";
	}

	public String getRIDSizeKilobytes() {
		return (double) executionPlan.getSystemInfo().getRidSizeInBytes() / 1000 + " kB";
	}
}
