package myBeans;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.*;

@Stateless
public class PersonBean {
	@PersistenceContext(unitName = "reporting")
	private EntityManager entityManager;
	
	public model.Person getPersonByID(int id){
		
		return entityManager.find(model.Person.class, id);
	}

}
