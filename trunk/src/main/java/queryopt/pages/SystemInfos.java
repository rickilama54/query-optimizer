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

import queryopt.entities.SystemInfo;

public class SystemInfos {

	private static final long MEMORY_SIZE_BYTES = 4000000;
	private static final int BLOCKING_FACTOR_INDEX_FIRST_LEVEL_ROWS = 2;
	private static final int PAGE_SIZE_BYTES = 4000;
	private static final int RID_SIZE_BYTES = 4;

	@Property
	private SystemInfo systemInfo;

	@InjectComponent
	private Zone mainZone;

	@Inject
	private Session session;

	@Property
	@Persist
	private boolean systemInfosEdit;

	void setupRender() {
		systemInfosEdit = false;
	}

	@SuppressWarnings("unchecked")
	public List<SystemInfo> getSystemInfos() {
		return session.createCriteria(SystemInfo.class).addOrder(Order.asc("name")).list();
	}

	public String getMemorySize() {
		return systemInfo.getMemorySizeInBytes() / 1000000 + " MB";
	}

	@CommitAfter
	public SystemInfo onAddRowFromSchemasLoop() {
		int systemInfosCount = session.createCriteria(queryopt.entities.Schema.class).list().size();
		SystemInfo systemInfo = new SystemInfo();
		systemInfo.setMemorySizeInBytes(MEMORY_SIZE_BYTES);
		systemInfo.setBlockingFactorIndexFirstLevelRows(BLOCKING_FACTOR_INDEX_FIRST_LEVEL_ROWS);
		systemInfo.setPageSizeInBytes(PAGE_SIZE_BYTES);
		systemInfo.setRidSizeInBytes(RID_SIZE_BYTES);
		systemInfo.setName("new system info " + systemInfosCount);
		session.persist(systemInfo);
		return systemInfo;
	}

	@CommitAfter
	public void onRemoveRowFromSchemasLoop(SystemInfo systemInfo) {
		session.delete(systemInfo);
	}

	public String getEditValue() {
		return systemInfosEdit ? "save" : "edit";
	}

	@CommitAfter
	Object onSubmit() {
		systemInfosEdit = !systemInfosEdit;
		return mainZone.getBody();
	}
}
