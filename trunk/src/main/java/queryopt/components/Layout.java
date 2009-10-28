package queryopt.components;

import java.util.List;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.IncludeStylesheet;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.HibernateSessionManager;
import org.apache.tapestry5.ioc.annotations.Inject;

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

	@InjectComponent
	private Zone queriesZone;

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

	public Zone getQueriesZone() {
		return queriesZone;
	}
}
