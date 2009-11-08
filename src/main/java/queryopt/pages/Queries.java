package queryopt.pages;

import java.util.List;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.HibernateSessionManager;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.criterion.Order;

public class Queries {
	@SuppressWarnings("unused")
	@Property
	private queryopt.entities.Query query;

	@Inject
	private HibernateSessionManager hsm;

	@SuppressWarnings("unchecked")
	public List<Query> getQueries() {
		return hsm.getSession().createCriteria(queryopt.entities.Query.class).addOrder(Order.asc("name")).list();
	}
}
