package queryopt.pages;

import java.util.List;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import queryopt.entities.Schema;

public class Schemas {

	@SuppressWarnings("unused")
	@Property
	private Schema schema;

	@InjectComponent
	private Zone mainZone;

	@Inject
	private Session session;

	@Property
	@Persist
	private boolean schemasEdit;

	@SuppressWarnings("unused")
	@Property
	@Persist
	private List<SystemInfos> systemInfos;

	@SuppressWarnings("unchecked")
	void setupRender() {
		schemasEdit = false;
		systemInfos = session.createCriteria(queryopt.entities.SystemInfo.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Schema> getSchemas() {
		return session.createCriteria(Schema.class).addOrder(Order.asc("name")).list();
	}

	@CommitAfter
	public Schema onAddRowFromSchemasLoop() {
		int schemasCount = session.createCriteria(queryopt.entities.Schema.class).list().size();
		Schema schema = new Schema();
		schema.setName("new schema " + schemasCount);
		schema.setDefaultSystemInfo((queryopt.entities.SystemInfo) session.createCriteria(
				queryopt.entities.SystemInfo.class).list().get(0));
		session.persist(schema);
		return schema;
	}

	@CommitAfter
	public void onRemoveRowFromSchemasLoop(Schema schema) {
		session.delete(schema);
	}

	public String getEditValue() {
		return schemasEdit ? "save" : "edit";
	}

	@CommitAfter
	Object onSubmit() {
		schemasEdit = !schemasEdit;
		return mainZone.getBody();
	}
}
