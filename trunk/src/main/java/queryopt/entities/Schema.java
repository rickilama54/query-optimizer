package queryopt.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "schemas", schema = "public")
public class Schema {
	private int schemaId;
	private String name;
	private String description;
	private SystemInfo defaultSystemInfo;
	private List<Relation> relations;

	public Schema() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shema_id", unique = true, nullable = false)
	public int getSchemaId() {
		return schemaId;
	}

	public void setSchemaId(int schemaId) {
		this.schemaId = schemaId;
	}

	@Column(name = "name", unique = true, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "default_system_info_id", nullable = false)
	public SystemInfo getDefaultSystemInfo() {
		return defaultSystemInfo;
	}

	public void setDefaultSystemInfo(SystemInfo defaultSystemInfo) {
		this.defaultSystemInfo = defaultSystemInfo;
	}

	@OneToMany(mappedBy = "schema", fetch = FetchType.LAZY)
	@Cascade( { org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.REFRESH,
			org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
	public List<Relation> getRelations() {
		return relations;
	}

	public void setRelations(List<Relation> relations) {
		this.relations = relations;
	}

}
