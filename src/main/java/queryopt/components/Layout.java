package queryopt.components;

import java.util.List;

import org.apache.tapestry5.*;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.hibernate.HibernateSessionManager;
import org.apache.tapestry5.ioc.annotations.*;
import org.apache.tapestry5.BindingConstants;

import queryopt.entities.Query;

/**
 * Layout component for pages of application query_optimizer.
 */
@IncludeStylesheet("context:layout/style.css")
public class Layout {
	/** The page title, for the <title> element and the <h1>element. */
	@SuppressWarnings("unused")
	@Property
	@Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
	private String title;

	@Property
	private String pageName;

	@SuppressWarnings("unused")
	@Property
	private Query query;

	@Inject
	private HibernateSessionManager hsm;

	@Inject
	private ComponentResources resources;

	public String getClassForPageName() {
		return resources.getPageName().equalsIgnoreCase(pageName) ? "current_page_item" : null;
	}

	public String[] getPageNames() {
		return new String[] { "Index", "About", "Contact" };
	}

	@SuppressWarnings("unchecked")
	public List<Query> getQueries() {
		return (List<Query>) hsm.getSession().createCriteria(Query.class).list();
	}
}
