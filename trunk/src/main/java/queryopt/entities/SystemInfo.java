package queryopt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "system_infos", schema = "public")
public class SystemInfo {
	private int systemInfoId;
	private long memorySizeInBytes;
	private int pageSizeInBytes;
	private int blockingFactorIndexFirstLevelRows;
	private int ridSizeInBytes;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "system_info_id", unique = true, nullable = false)
	public int getSystemInfoId() {
		return systemInfoId;
	}

	public void setSystemInfoId(int systemInfoId) {
		this.systemInfoId = systemInfoId;
	}

	@Transient
	public String getName() {
		return "mem: " + (double) this.getMemorySizeInBytes() / 1000000 + "MB, page:" + (double) this.pageSizeInBytes
				/ 1000 + "K, block:" + this.blockingFactorIndexFirstLevelRows + ", rid:" + this.ridSizeInBytes;
	}

	@Column(name = "memory_size_bytes", nullable = false)
	public long getMemorySizeInBytes() {
		return memorySizeInBytes;
	}

	public void setMemorySizeInBytes(long memorySizeInBytes) {
		this.memorySizeInBytes = memorySizeInBytes;
	}

	@Column(name = "page_size_bytes", nullable = false)
	public int getPageSizeInBytes() {
		return pageSizeInBytes;
	}

	public void setPageSizeInBytes(int pageSizeInBytes) {
		this.pageSizeInBytes = pageSizeInBytes;
	}

	@Column(name = "blocking_factor", nullable = false)
	public int getBlockingFactorIndexFirstLevelRows() {
		return blockingFactorIndexFirstLevelRows;
	}

	public void setBlockingFactorIndexFirstLevelRows(int blockingFactorIndexFirstLevelRows) {
		this.blockingFactorIndexFirstLevelRows = blockingFactorIndexFirstLevelRows;
	}

	@Column(name = "rid_size_bytes", nullable = false)
	public int getRidSizeInBytes() {
		return ridSizeInBytes;
	}

	public void setRidSizeInBytes(int ridSizeInBytes) {
		this.ridSizeInBytes = ridSizeInBytes;
	}

}
