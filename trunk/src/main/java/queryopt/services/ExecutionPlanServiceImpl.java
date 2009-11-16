package queryopt.services;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import queryopt.entities.ExecutionPlan;
import queryopt.entities.Query;
import queryopt.optimizer.Optimizer;
import queryopt.optimizer.Plan;
import queryopt.optimizer.SPJQueryBuilder;

public class ExecutionPlanServiceImpl implements ExecutionPlanService {
	@Inject
	private Session session;

	@CommitAfter
	public void calculateExecutionPlan(int executionPlanId) {
		session.beginTransaction();
		ExecutionPlan executionPlan = (ExecutionPlan) session.createCriteria(ExecutionPlan.class).add(
				Restrictions.eq("executionPlanId", executionPlanId)).uniqueResult();
		Query query = executionPlan.getQuery();
		SPJQueryBuilder queryBuilder = new SPJQueryBuilder(executionPlan.getQuery().getSchema().getRelations());
		try {
			queryBuilder.parse(query.getText());
			Optimizer optimizer = new Optimizer(queryBuilder.build(executionPlan));
			Plan plan = optimizer.generateBestPlan();
			System.out.println("plan.getPlanAsTree():" + plan.getPlanAsTree());
			executionPlan.setExecutionPlanText(plan.getPlanAsTree());
			executionPlan.setError(false);
			executionPlan.setMessage("OK");
			session.save(executionPlan);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			executionPlan.setMessage(e.getMessage());
			executionPlan.setError(true);
		}
	}
}
