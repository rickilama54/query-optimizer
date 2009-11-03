package queryopt.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "relations", schema = "public")
public class Relation {
	private int relationId;
	private String name;
	private int noOfRows;
	private List<Atribute> atributes;
	private List<Index> indexes;
	private int blockingFactor;

	public Relation() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "relation_id", unique = true, nullable = false)
	public int getRelationId() {
		return relationId;
	}

	public void setRelationId(int relationId) {
		this.relationId = relationId;
	}

	@Column(name = "name", unique = true, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "rows", nullable = false)
	public int getNoOfRows() {
		return noOfRows;
	}

	public void setNoOfRows(int noOfRows) {
		this.noOfRows = noOfRows;
	}

	@Column(name = "blocking_factor", nullable = false, columnDefinition = "bigint default 2")
	public int getBlockingFactor() {
		return blockingFactor;
	}

	public void setBlockingFactor(int blockingFactor) {
		this.blockingFactor = blockingFactor;
	}

	@OneToMany(mappedBy = "relation", fetch = FetchType.LAZY)
	@Cascade( { org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.REFRESH,
			org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
	public List<Atribute> getAtributes() {
		return atributes;
	}

	public void setAtributes(List<Atribute> atributes) {
		this.atributes = atributes;
	}

	@OneToMany(mappedBy = "relation", fetch = FetchType.LAZY)
	@Cascade( { org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
	public List<Index> getIndexes() {
		return indexes;
	}

	public void setIndexes(List<Index> indexes) {
		this.indexes = indexes;
	}

}
