package queryopt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "indexes_atributes", schema = "public")
public class IndexAtribute {
	private int indexAtributeId;
	private Index index;
	private Atribute atribute;

	public IndexAtribute() {
	}

	public IndexAtribute(int indexAtributeId, Index index, Atribute atribute) {
		super();
		this.indexAtributeId = indexAtributeId;
		this.index = index;
		this.atribute = atribute;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "index_atribute_id")
	public int getIndexAtributeId() {
		return indexAtributeId;
	}

	public void setIndexAtributeId(int indexAtributeId) {
		this.indexAtributeId = indexAtributeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "indexes_index_id", nullable = false)
	public Index getIndex() {
		return index;
	}

	public void setIndex(Index index) {
		this.index = index;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "atributes_atribute_id", nullable = false)
	public Atribute getAtribute() {
		return atribute;
	}

	public void setAtribute(Atribute atribute) {
		this.atribute = atribute;
	}

}
