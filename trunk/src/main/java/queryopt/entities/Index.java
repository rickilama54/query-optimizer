package queryopt.entities;

import java.util.ArrayList;
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
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "indexes", schema = "public")
public class Index {
	private int indexId;
	private String name;
	private boolean isBTree;
	private int levels;
	private Relation relation;
	private List<IndexAtribute> indexAtributes;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "index_id", unique = true, nullable = false)
	public int getIndexId() {
		return indexId;
	}

	public void setIndexId(int indexId) {
		this.indexId = indexId;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "is_btree", nullable = false)
	public boolean isBTree() {
		return isBTree;
	}

	public void setBTree(boolean isBTree) {
		this.isBTree = isBTree;
	}

	@Transient
	public boolean isHash() {
		return isBTree;
	}

	@Column(name = "levels", nullable = false)
	public int getLevels() {
		return levels;
	}

	public void setLevels(int levels) {
		this.levels = levels;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "relation_id", nullable = false)
	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

	@OneToMany(mappedBy = "index", fetch = FetchType.LAZY)
	@Cascade( { org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
	public List<IndexAtribute> getIndexAtributes() {
		return indexAtributes;
	}

	public void setIndexAtributes(List<IndexAtribute> indexAtributes) {
		this.indexAtributes = indexAtributes;
	}

	@Transient
	public List<Atribute> getAtributes() {
		List<Atribute> atributes = new ArrayList<Atribute>();
		for (IndexAtribute ia : getIndexAtributes())
			atributes.add(ia.getAtribute());
		return atributes;
	}

}
