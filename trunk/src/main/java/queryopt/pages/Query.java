package queryopt.pages;

import java.util.List;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.ajax.MultiZoneUpdate;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.hibernate.HibernateSessionManager;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.criterion.Restrictions;

import queryopt.components.Layout;
import queryopt.entities.Relation;
import queryopt.optimizer.SPJQueryBuilder;

public class Query {
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
	private Layout layout;

	@InjectComponent
	private Form editForm;

	@Inject
	private HibernateSessionManager hsm;

	private boolean isSave;
	private boolean isParse;
	private boolean isEdit;
	private boolean isDelete;
	@Persist
	private boolean isNew;

	void onActivate(EventContext e) {
		System.out.println(e.getCount());
		if (e.getCount() == 1) {
			Integer queryId = (Integer) e.get(Integer.class, 0);
			if (queryId == 0) {
				query = new queryopt.entities.Query("new query", "Enter an SQL query.");
				isNew = true;
				activeBlock = editBlock;
			} else if (queryId > 0) {
				isNew = false;
				query = (queryopt.entities.Query) hsm.getSession().createCriteria(queryopt.entities.Query.class).add(
						Restrictions.eq("queryId", queryId)).uniqueResult();
				activeBlock = viewBlock;
			}
		}

	}

	Integer onPassivate() {
		System.out.println("onPassivate:" + query.getQueryId());
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

	void onActionFromBack() {
		activeBlock = viewBlock;
	}

	Object onSuccess() {
		if (isSave) {
			System.out.println(isNew);
			if (isNew
					&& hsm.getSession().createCriteria(queryopt.entities.Query.class).add(
							Restrictions.eq("name", query.getName())).list().size() > 0) {
				editForm.recordError("Query names must be unique!");
				activeBlock = editBlock;
				System.out.println("error");
				return activeBlock;
			} else {
				activeBlock = viewBlock;
				hsm.getSession().persist(query);
				save();
			}
			return new MultiZoneUpdate("mainzone", activeBlock).add("queriesZone", layout.getQueriesZone().getBody());
		}
		if (isEdit) {
			activeBlock = editBlock;
		}
		if (isParse) {
			SPJQueryBuilder queryBuilder = new SPJQueryBuilder(getRelations());
			try {
				queryBuilder.build(query.getText());
				parseok = true;
				message = "OK";
			} catch (Exception e) {
				message = e.getMessage();
				parseok = false;
			}
			activeBlock = editBlock;
		}
		if (isDelete) {
			hsm.getSession().delete(query);
			save();
			return Index.class;
		}
		return activeBlock;
	}

	@CommitAfter
	private void save() {
	}

	@SuppressWarnings("unchecked")
	private List<Relation> getRelations() {
		return hsm.getSession().createCriteria(Relation.class).list();
	}
}
