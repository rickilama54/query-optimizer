package queryopt.pages;

import java.util.List;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.HibernateSessionManager;
import org.apache.tapestry5.ioc.annotations.Inject;

import queryopt.entities.Relation;
import queryopt.optimizer.SPJQueryBuilder;

public class QueryBuilder {
	@Property
	@Persist(PersistenceConstants.FLASH)
	private String queryText;

	@SuppressWarnings("unused")
	@Property
	private String message;

	@SuppressWarnings("unused")
	@Property
	private boolean parseok;

	@InjectComponent
	private Zone mainZone;
	@Inject
	private HibernateSessionManager hsm;

	@InjectPage
	private Query query;

	Object onSubmit() {
		SPJQueryBuilder queryBuilder = new SPJQueryBuilder(getRelations());
		try {
			queryBuilder.build(queryText);
			parseok = true;
			message = "OK";
		} catch (Exception e) {
			message = e.getMessage();
			parseok = false;
		}
		return mainZone.getBody();
	}

	@SuppressWarnings("unchecked")
	private List<Relation> getRelations() {
		return hsm.getSession().createCriteria(Relation.class).list();
	}

	Object onActionFromSaveQueryLink(String queryText) {
		query.setQueryText(queryText);
		return query;
	}
}
