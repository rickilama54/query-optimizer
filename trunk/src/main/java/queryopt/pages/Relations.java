package queryopt.pages;

import java.util.List;

import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.HibernateSessionManager;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import queryopt.entities.Atribute;
import queryopt.entities.Index;
import queryopt.entities.IndexAtribute;
import queryopt.entities.Relation;

public class Relations {

	@Property
	@Persist
	private List<Relation> relations;

	@Property
	private Relation relation;

	@SuppressWarnings("unused")
	@Property
	private Atribute atribute;

	@Property
	private Index index;

	@Property
	private IndexAtribute indexAtribute;

	@Inject
	private HibernateSessionManager hsm;

	@InjectComponent
	private Form mainForm;

	@InjectComponent
	private Zone mainZone;

	private boolean saveAtributes;
	private boolean saveIndexes;

	@SuppressWarnings("unchecked")
	public void onPrepare() {
		relations = (List<Relation>) hsm.getSession().createCriteria(Relation.class).addOrder(Order.asc("relationId"))
				.list();
		for (Relation r : relations) {
			Hibernate.initialize(r.getAtributes());
			Hibernate.initialize(r.getIndexes());
		}

	}

	@SuppressWarnings("unchecked")
	public List<Atribute> getFkCandidates() {
		return (List<Atribute>) hsm.getSession().createCriteria(Atribute.class).add(
				Restrictions.not(Restrictions.eq("relation.relationId", relation.getRelationId()))).addOrder(
				Order.asc("relation.relationId")).addOrder(Order.asc("atributeId")).list();
	}

	@SuppressWarnings("unchecked")
	public List<Atribute> getAtributes() {
		return (List<Atribute>) hsm.getSession().createCriteria(Atribute.class).add(
				Restrictions.eq("relation.relationId", relation.getRelationId())).addOrder(Order.asc("atributeId"))
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<IndexAtribute> getIndexAtributes() {
		return (List<IndexAtribute>) hsm.getSession().createCriteria(IndexAtribute.class).add(
				Restrictions.eq("index.indexId", index.getIndexId())).addOrder(Order.asc("indexAtributeId")).list();
	}

	public boolean isLastAtributeInIndex() {
		return index.getIndexAtributes().indexOf(indexAtribute) == index.getIndexAtributes().size() - 1;
	}

	@CommitAfter
	Atribute onAddRowFromAtributesLoop(Relation relation) {
		Atribute newAtribute = new Atribute();
		newAtribute.setName("new atribute");
		newAtribute.setRelation(relation);
		newAtribute.setDistinct(10);
		newAtribute.setSizeInBytes(10);
		hsm.getSession().persist(newAtribute);
		relation.getAtributes().add(newAtribute);
		onPrepare();
		this.relation = relation;
		return newAtribute;
	}

	@CommitAfter
	void onRemoveRowFromAtributesLoop(Atribute atribute) {
		if (hsm.getSession().createCriteria(Atribute.class).add(
				Restrictions.eq("fkAtribute.atributeId", atribute.getAtributeId())).list().size() > 0)
			mainForm.recordError(atribute.getName() + " is referenced by another FK atribute");
		if (hsm.getSession().createCriteria(IndexAtribute.class).add(
				Restrictions.eq("atribute.atributeId", atribute.getAtributeId())).list().size() > 0)
			mainForm.recordError(atribute.getName() + " is referenced by an index");
		hsm.getSession().delete(atribute);
	}

	@CommitAfter
	Index onAddRowFromIndexesLoop(Relation relation) {
		Index newIndex = new Index();
		newIndex.setName("new index");
		newIndex.setRelation(relation);
		hsm.getSession().persist(newIndex);
		return newIndex;
	}

	@CommitAfter
	void onRemoveRowFromIndexesLoop(Index index) {
		hsm.getSession().delete(index);
	}

	@CommitAfter
	IndexAtribute onAddRowFromEditIndexLoop(Index index) {
		Atribute atribute = index.getRelation().getAtributes().get(0);
		IndexAtribute ia = new IndexAtribute(0, index, atribute);
		hsm.getSession().persist(ia);
		return ia;
	}

	@CommitAfter
	void onRemoveRowFromEditIndexLoop(IndexAtribute ia) {
		hsm.getSession().delete(ia);
	}

	void onSelectedFromSaveAtributes() {
		saveAtributes = true;
	}

	void onSelectedFromSaveIndexes() {
		saveIndexes = true;
	}

	@CommitAfter
	Object onSuccess() {
		for (Relation r : relations)
			for (Atribute a : r.getAtributes())
				if (a.getFkAtribute() != null) {
					System.out.println(a.getName() + " " + a.getFkAtribute().getName());
					a.setSizeInBytes(a.getFkAtribute().getSizeInBytes());
					a.setDistinct(a.getFkAtribute().getDistinct());
				}

		if (saveAtributes || saveIndexes) {
			return mainZone.getBody();
		} else {
			return this;
		}
	}

	public ValueEncoder<Relation> getRelationEncoder() {
		return new ValueEncoder<Relation>() {

			public Relation toValue(String key) {
				for (Relation r : relations)
					if (r.getRelationId() == Integer.parseInt(key))
						return r;
				return null;
			}

			public String toClient(Relation value) {
				return value.getRelationId() + "";
			}
		};
	}

	public ValueEncoder<Atribute> getAtributeEncoder() {
		return new ValueEncoder<Atribute>() {

			public Atribute toValue(String key) {
				for (Relation r : relations)
					for (Atribute a : r.getAtributes())
						if (a.getAtributeId() == Integer.parseInt(key))
							return a;
				return null;
			}

			public String toClient(Atribute value) {
				return value.getAtributeId() + "";
			}
		};
	}

	public ValueEncoder<Index> getIndexEncoder() {
		return new ValueEncoder<Index>() {

			public Index toValue(String key) {
				for (Relation r : relations)
					for (Index index : r.getIndexes())
						if (index.getIndexId() == Integer.parseInt(key))
							return index;
				return null;
			}

			public String toClient(Index value) {
				return value.getIndexId() + "";
			}
		};
	}
}
