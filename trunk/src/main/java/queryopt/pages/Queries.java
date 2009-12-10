package queryopt.pages;

import java.util.List;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import queryopt.model.SessionData;

public class Queries {
	@Property
	private queryopt.entities.Query query;

	@Inject
	private Session session;
	@SessionState
	private SessionData sessionData;

	@SuppressWarnings("unchecked")
	public List<Query> getQueries() {
		return session.createCriteria(queryopt.entities.Query.class).add(
				Restrictions.eq("schema.schemaId", sessionData.getSelectedSchema().getSchemaId())).addOrder(
				Order.asc("name")).list();
	}

	public String getQueryText() {
		return query.getText().replace("\n", "<br/>").replace("\t", "<span style=\"margin-left:20px;\"/>");
	}
}
