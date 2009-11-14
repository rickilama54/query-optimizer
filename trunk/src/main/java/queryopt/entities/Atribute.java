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

import queryopt.optimizer.query.Term;

@Entity
@Table(name = "atributes", schema = "public")
public class Atribute implements Term {
	private int atributeId;
	private String name;
	private boolean pk;
	private int sizeInBytes;
	private double distinctPercent;
	private Relation relation;
	private Atribute fkAtribute;
	private String highValue;
	private String lowValue;

	public Atribute() {

	}

	public Atribute(int atributeId, String name, boolean pk, int sizeInBytes, double distinctPercent, Relation relation) {
		super();
		this.atributeId = atributeId;
		this.name = name;
		this.pk = pk;
		this.sizeInBytes = sizeInBytes;
		this.distinctPercent = distinctPercent;
		this.relation = relation;
	}

	public Atribute(int atributeId, String name, boolean pk, int sizeInBytes, double distinctPercent,
			Relation relation, Atribute fkAtribute) {
		super();
		this.atributeId = atributeId;
		this.name = name;
		this.pk = pk;
		this.sizeInBytes = sizeInBytes;
		this.distinctPercent = distinctPercent;
		this.relation = relation;
		this.fkAtribute = fkAtribute;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "atribute_id", unique = true, nullable = false)
	public int getAtributeId() {
		return atributeId;
	}

	public void setAtributeId(int atributeId) {
		this.atributeId = atributeId;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "is_pk", nullable = false)
	public boolean isPk() {
		return pk;
	}

	public void setPk(boolean pk) {
		this.pk = pk;
	}

	@Column(name = "size_in_bytes", nullable = false)
	public int getSizeInBytes() {
		return sizeInBytes;
	}

	public void setSizeInBytes(int sizeInBytes) {
		this.sizeInBytes = sizeInBytes;
	}

	@Column(name = "distinct_percent", nullable = false)
	public double getDistinctPercent() {
		return distinctPercent;
	}

	public void setDistinctPercent(double distinctPercent) {
		this.distinctPercent = distinctPercent;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "relation_id", nullable = false)
	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_atribute_id")
	public Atribute getFkAtribute() {
		return fkAtribute;
	}

	public void setFkAtribute(Atribute fkAtribute) {
		this.fkAtribute = fkAtribute;
	}

	@Column(name = "high_value", nullable = false)
	public String getHighValue() {
		return highValue;
	}

	public void setHighValue(String highValue) {
		this.highValue = highValue;
	}

	@Column(name = "low_value", nullable = false)
	public String getLowValue() {
		return lowValue;
	}

	public void setLowValue(String lowValue) {
		this.lowValue = lowValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + atributeId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atribute other = (Atribute) obj;
		if (atributeId != other.atributeId)
			return false;
		return true;
	}

}
