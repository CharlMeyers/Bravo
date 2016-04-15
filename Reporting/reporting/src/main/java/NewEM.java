import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
public class NewEM {
	private static final String PERSISTENCE_UNIT_NAME = "reporting";
	private static EntityManagerFactory emf;
	
	public EntityManager initEntityManager() {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		return emf.createEntityManager();
	}
}