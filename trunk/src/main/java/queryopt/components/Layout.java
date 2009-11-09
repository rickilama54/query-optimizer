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
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import queryopt.entities.Atribute;
import queryopt.entities.Query;
import queryopt.entities.Relation;
import queryopt.entities.Schema;
import queryopt.model.SessionData;

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
	private Session session;

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

	@SessionState
	private SessionData sessionData;

	public String getClassForPageName() {
		return resources.getPageName().equalsIgnoreCase(pageName) ? "current_page_item" : null;
	}

	@SuppressWarnings("unchecked")
	public List<Schema> getSchemas() {
		return session.createCriteria(Schema.class).addOrder(Order.asc("name")).list();
	}

	public String[] getPageNames() {
		return new String[] { "Index", "About", "Contact" };
	}

	@SuppressWarnings("unchecked")
	public List<Query> getQueries() {
		return session.createCriteria(Query.class).add(
				Restrictions.eq("schema.schemaId", sessionData.getSelectedSchema().getSchemaId())).addOrder(
				Order.asc("name")).list();
	}

	@SuppressWarnings("unchecked")
	void setupRender() {
		relations = session.createCriteria(Relation.class).add(
				Restrictions.eq("schema.schemaId", sessionData.getSelectedSchema().getSchemaId())).addOrder(
				Order.asc("name")).list();
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

	public Schema getSelectedSchema() {
		return sessionData.getSelectedSchema();
	}

	public void setSelectedSchema(Schema selectedSchema) {
		sessionData.setSelectedSchema(selectedSchema);
	}

	Object onSubmit() {
		return this;
	}

}
