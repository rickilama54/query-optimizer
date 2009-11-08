package queryopt.components;

import java.util.HashMap;
import java.util.List;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.IncludeStylesheet;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.HibernateSessionManager;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Hibernate;

import queryopt.entities.Atribute;
import queryopt.entities.Query;
import queryopt.entities.Relation;

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

	@InjectComponent
	private Zone relationsZone;

	@Property
	private Relation relation;

	@Property
	@Persist
	private HashMap<Integer, Boolean> relationsExpanded;

	@Property
	@Persist
	private List<Relation> relations;

	@SuppressWarnings("unused")
	@Property
	private Atribute atribute;

	@SuppressWarnings("unused")
	@Property
	private queryopt.entities.Index index;

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

	@SuppressWarnings("unchecked")
	void setupRender() {
		relations = hsm.getSession().createCriteria(Relation.class).list();
		relationsExpanded = new HashMap<Integer, Boolean>();
		for (Relation r : relations) {
			relationsExpanded.put(r.getRelationId(), false);
			Hibernate.initialize(r.getAtributes());
			Hibernate.initialize(r.getIndexes());
		}
	}

	public Zone getQueriesZone() {
		return queriesZone;
	}

	public boolean isRelationExpanded() {
		return relationsExpanded.get(relation.getRelationId());
	}

	Object onActionFromExpandCollapseRelations(int relationId) {
		boolean expanded = relationsExpanded.get(relationId);
		relationsExpanded.remove(relationId);
		relationsExpanded.put(relationId, !expanded);
		return relationsZone;
	}
}
