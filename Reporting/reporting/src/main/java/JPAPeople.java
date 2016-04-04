//import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ejb.Stateless;

 
@Stateless
public class JPAPeople {
	//private static final Logger logger = Logger.getLogger("javahowto.greeting");
	private static final String PERSISTENCE_UNIT_NAME = "reporting";
	private EntityManagerFactory emf;
	private EntityManager em;
	 
	public static void main(String[] args) {
		JPAPeople main = new JPAPeople();
		main.initEntityManager();
		main.createAndRead();
	}
	 
	private void createAndRead() {
		model.Person g = new model.Person();
		g.setFirstNames("Test Guy");
		g.setSurname("Testacle");

		em.getTransaction().begin();
		em.persist(g);
		em.getTransaction().commit();
		 
		//g should be written to database now.
		//Read it from db (no transaction context needed for em.find method)
		model.Person g2 = em.find(model.Person.class, 1);
		System.out.println("Person ID: " + g2.getPersonID() + "\n Name: " + g2.getFirstNames() + " " + g2.getSurname() + "\n from db: " + g2);
	}
	 
	private void initEntityManager() {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();
		
		//PersonBean nB = new PersonBean();
		//nB.addPerson("Ted","Bundy",null,null,null);
		//System.out.println("Name: " + nB.getPersonByID(1).getFirstNames());
	}
}