package queryopt.pages;

import java.util.List;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import queryopt.entities.Atribute;
import queryopt.entities.Index;
import queryopt.entities.IndexAtribute;
import queryopt.entities.Relation;
import queryopt.model.SessionData;

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
	private Session session;

	@InjectComponent
	private Form mainForm;

	@InjectComponent
	private Zone mainZone;

	@SessionState
	private SessionData sessionData;

	private boolean saveAtributes;
	private boolean saveIndexes;

	@SuppressWarnings("unchecked")
	void onActivate(EventContext e) throws Exception {
		if (e.getCount() == 0) {
			relations = session.createCriteria(Relation.class).add(
					Restrictions.eq("schema.schemaId", sessionData.getSelectedSchema().getSchemaId())).addOrder(
					Order.asc("name")).list();
		} else if (e.getCount() == 1) {
			relations = session.createCriteria(Relation.class).add(
					Restrictions.eq("relationId", e.get(Integer.class, 0))).addOrder(Order.asc("relationId")).list();
		} else
			throw new Exception("Invallid Number Of Arguments in Relations page");

		for (Relation r : relations) {
			Hibernate.initialize(r.getAtributes());
			Hibernate.initialize(r.getIndexes());
		}
	}

	@SuppressWarnings("unchecked")
	public List<Atribute> getFkCandidates() {
		return session.createCriteria(Atribute.class).add(
				Restrictions.not(Restrictions.eq("relation.relationId", relation.getRelationId()))).addOrder(
				Order.asc("relation.relationId")).addOrder(Order.asc("atributeId")).list();
	}

	@SuppressWarnings("unchecked")
	public List<Atribute> getAtributes() {
		return session.createCriteria(Atribute.class).add(
				Restrictions.eq("relation.relationId", relation.getRelationId())).addOrder(Order.asc("atributeId"))
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<IndexAtribute> getIndexAtributes() {
		return session.createCriteria(IndexAtribute.class).add(
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
		session.persist(newAtribute);
		relation.getAtributes().add(newAtribute);
		this.relation = relation;
		return newAtribute;
	}

	@CommitAfter
	void onRemoveRowFromAtributesLoop(Atribute atribute) {
		if (session.createCriteria(Atribute.class).add(
				Restrictions.eq("fkAtribute.atributeId", atribute.getAtributeId())).list().size() > 0)
			mainForm.recordError(atribute.getName() + " is referenced by another FK atribute");
		if (session.createCriteria(IndexAtribute.class).add(
				Restrictions.eq("atribute.atributeId", atribute.getAtributeId())).list().size() > 0)
			mainForm.recordError(atribute.getName() + " is referenced by an index");
		atribute.getRelation().getAtributes().remove(atribute);
	}

	@CommitAfter
	Index onAddRowFromIndexesLoop(Relation relation) {
		Index newIndex = new Index();
		newIndex.setName("new index");
		newIndex.setRelation(relation);
		session.persist(newIndex);
		return newIndex;
	}

	@CommitAfter
	void onRemoveRowFromIndexesLoop(Index index) {
		index.getRelation().getIndexes().remove(index);
	}

	@CommitAfter
	IndexAtribute onAddRowFromEditIndexLoop(Index index) {
		Atribute atribute = index.getRelation().getAtributes().get(0);
		IndexAtribute ia = new IndexAtribute(0, index, atribute);
		session.persist(ia);
		return ia;
	}

	@CommitAfter
	void onRemoveRowFromEditIndexLoop(IndexAtribute ia) {
		ia.getIndex().getIndexAtributes().remove(ia);
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
