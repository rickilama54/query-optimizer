package queryopt.pages;

import java.util.List;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.HibernateSessionManager;
import org.apache.tapestry5.ioc.annotations.Inject;

import queryopt.entities.Atribute;
import queryopt.entities.Relation;

public class Atributes {
	
	@SuppressWarnings("unused")
	@Property
	private Relation relation;
	
	@SuppressWarnings("unused")
	@Property
	private Atribute atribute;
	
	@Inject
	private HibernateSessionManager hsm;
	
	@SuppressWarnings("unchecked")
	public List<Relations> getRelations(){
		return hsm.getSession().createCriteria(Relation.class).list();
	}
	
}
