package queryopt.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "system_infos", schema = "public")
public class SystemInfo {
	private int systemInfoId;
	private String name;
	private BigDecimal memorySizeInBytes;
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

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "memory_size_bytes", nullable = false)
	public BigDecimal getMemorySizeInBytes() {
		return memorySizeInBytes;
	}

	public void setMemorySizeInBytes(BigDecimal memorySizeInBytes) {
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
