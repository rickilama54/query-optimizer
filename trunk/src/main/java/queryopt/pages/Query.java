package queryopt.pages;

import java.util.List;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import queryopt.components.ExecutionPlanView;
import queryopt.entities.ExecutionPlan;
import queryopt.entities.Relation;
import queryopt.entities.Schema;
import queryopt.model.SessionData;
import queryopt.optimizer.SPJQueryBuilder;

public class Query {
	@SuppressWarnings("unused")
	@Property
	@Inject
	private Request request;

	@Property
	@Persist
	private queryopt.entities.Query query;

	@SuppressWarnings("unused")
	@Property
	private String message;

	@SuppressWarnings("unused")
	@Property
	private boolean parseok;

	@Property
	@Inject
	private Block editBlock;
	@Property
	@Inject
	private Block viewBlock;
	@Property
	private Block activeBlock;

	@InjectComponent
	private Zone executionPlansZone;

	//@InjectComponent
	//private Layout layout;

	@InjectComponent
	private Form editForm;

	@Inject
	private Session session;

	@SessionState
	private SessionData sessionData;

	private boolean isSave;
	private boolean isParse;
	private boolean isEdit;
	private boolean isDelete;
	private boolean editExecutionPlan;

	@Persist
	private boolean isNew;

	void onActivate(EventContext e) {
		if (e.getCount() == 1) {
			Integer queryId = e.get(Integer.class, 0);
			if (queryId == 0) {
				query = new queryopt.entities.Query("new query", "Enter an SQL query.");
				query.setSchema(sessionData.getSelectedSchema());
				isNew = true;
				activeBlock = editBlock;
			} else if (queryId > 0) {
				isNew = false;
				query = (queryopt.entities.Query) session.createCriteria(queryopt.entities.Query.class).add(
						Restrictions.eq("queryId", queryId)).uniqueResult();
				activeBlock = viewBlock;
			}
		}

	}

	Integer onPassivate() {
		if (query == null)
			return 0;
		return query.getQueryId() > 0 ? query.getQueryId() : null;
	}

	void onSelectedFromSave() {
		isSave = true;
	}

	void onSelectedFromEdit() {
		isEdit = true;
	}

	void onSelectedFromParse() {
		isParse = true;
	}

	void onSelectedFromDelete() {
		isDelete = true;
	}

	void onSelectedFromExplainPlan() {
		editExecutionPlan = true;
	}

	void onSelectedFromEditExecutionPlan() {
		editExecutionPlan = true;
	}

	void onActionFromBack() {
		activeBlock = viewBlock;
	}

	Object onSuccessFromViewForm() {
		if (isEdit) {
			System.out.println("isEdit:" + isEdit);
			activeBlock = editBlock;
		}
		if (isDelete) {
			session.delete(query);
			save();
			return Index.class;
		}
		return activeBlock;
	}

	Object onSuccessFromEditForm() {
		if (isSave) {
			if (isNew
					&& session.createCriteria(queryopt.entities.Query.class).add(
							Restrictions.eq("name", query.getName())).list().size() > 0) {
				editForm.recordError("Query names must be unique!");
				activeBlock = editBlock;
				return activeBlock;
			} else {
				activeBlock = viewBlock;
				session.persist(query);
				save();
				return Query.class;
			}
			// return new MultiZoneUpdate("mainzone", activeBlock).add("queriesZone", layout.getQueriesZone().getBody());
		}
		if (isParse) {
			System.out.println("isParse:" + isParse);
			SPJQueryBuilder queryBuilder = new SPJQueryBuilder(getRelations());
			try {
				queryBuilder.parse(query.getText());
				parseok = true;
				message = "OK";
			} catch (Exception e) {
				message = e.getMessage();
				parseok = false;
			}
			activeBlock = editBlock;
		}
		return activeBlock;
	}

	Object onSuccessFromExecutionPlansForm() {
		if (editExecutionPlan) {
			executionPlansEdit = !executionPlansEdit;
			save();
		}
		return executionPlansZone.getBody();
	}

	@CommitAfter
	private void save() {
	}

	@SuppressWarnings("unchecked")
	private List<Relation> getRelations() {
		return session.createCriteria(Relation.class).list();
	}

	@SuppressWarnings("unused")
	@Property
	private ExecutionPlan executionPlan;

	@Property
	@Persist
	private boolean executionPlansEdit;

	@SuppressWarnings("unused")
	@Property
	@Persist
	private List<SystemInfos> systemInfos;

	@SuppressWarnings("unchecked")
	void setupRender() {
		executionPlansEdit = false;
		systemInfos = session.createCriteria(queryopt.entities.SystemInfo.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Schema> getExecutionPlans() {
		return session.createCriteria(ExecutionPlan.class).add(Restrictions.eq("query.queryId", query.getQueryId()))
				.list();
	}

	@CommitAfter
	public ExecutionPlan onAddRowFromExecutionPlansLoop() {
		ExecutionPlan ep = new ExecutionPlan();
		ep.setQuery(query);
		ep.setError(false);
		ep.setMessage("not yet executed");
		ep.setExecutionPlanText(" ");
		ep.setSystemInfo(query.getSchema().getDefaultSystemInfo());
		session.persist(ep);
		return ep;
	}

	@CommitAfter
	public void onRemoveRowFromExecutionPlansLoop(ExecutionPlan executionPlan) {
		session.delete(executionPlan);
	}

	public String getEditValue() {
		return executionPlansEdit ? "save" : "edit";
	}

	Object onActionFromExecutionPlanView() {
		return ExecutionPlanView.class;
	}

}
