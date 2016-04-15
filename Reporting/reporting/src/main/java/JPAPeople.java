//import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ejb.Stateless;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;
import model.*;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

 
//@Stateless
public class JPAPeople {
	//private static final Logger logger = Logger.getLogger("javahowto.greeting");
	private static final String PERSISTENCE_UNIT_NAME = "reporting";
	private static EntityManagerFactory emf;
	private static EntityManager em;
	 
	public static void main(String[] args) {
		//JPAPeople main = new JPAPeople();
		initEntityManager();
		printPeopleReport();
	}
	
	private static void printPeopleReport(){		
		try {
			Query p = em.createQuery("SELECT P FROM Person P");		

            /* User home directory location */
            String userHomeDirectory = System.getProperty("user.home");
            System.out.println("HOME: "+userHomeDirectory);
            /* Output file location */
            String outputFile = userHomeDirectory + File.separatorChar + "PersonsReport.pdf";
            
    		List<Person> pList = (List<Person>)p.getResultList();
    		
    		for(Person P : pList){
    			System.out.println(P.getFirstNames() + " " + P.getSurname());
    		}
            
            /* Convert List to JRBeanCollectionDataSource */
            JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(pList);

            /* Map to hold Jasper report Parameters */
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("PersonsDataSource", itemsJRBean);

            /* Using compiled version(.jasper) of Jasper report to generate PDF */
            JasperCompileManager.compileReportToFile("C:/Users/JoDan/Documents/GitHub/Bravo/Reporting/reporting/src/main/java/PersonsReport.jrxml","C:/Users/JoDan/Documents/GitHub/Bravo/Reporting/reporting/src/main/java/PersonsReport.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport("C:/Users/JoDan/Documents/GitHub/Bravo/Reporting/reporting/src/main/java/PersonsReport.jasper", parameters, new JREmptyDataSource());

            /* outputStream to create PDF */
            OutputStream outputStream = new FileOutputStream(new File(outputFile));
            /* Write content to PDF file */
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

            System.out.println("File Generated");
        } catch (JRException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
	 
	private void createAndRead() {
		/*model.Person g = new model.Person();
		g.setFirstNames("Test Guy");
		g.setSurname("Testacle");

		em.getTransaction().begin();
		em.persist(g);
		em.getTransaction().commit();
		 
		//g should be written to database now.
		//Read it from db (no transaction context needed for em.find method)
		model.Person g2 = em.find(model.Person.class, 1);
		System.out.println("Person ID: " + g2.getPersonID() + "\n Name: " + g2.getFirstNames() + " " + g2.getSurname() + "\n from db: " + g2);
	*/}
	 
	private static void initEntityManager() {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();
		//Query q;
		
		//q = em.createQuery("SELECT P FROM Publication P");
		
		//ArrayList<Publication> pList = (ArrayList<Publication>)q.getResultList();
		
		/*for(Publication P : pList){
			System.out.println(P.getPublicationID());
		}
		
		//PersonBean nB = new PersonBean();
		//nB.addPerson("Ted","Bundy",null,null,null);
		//System.out.println("Name: " + nB.getPersonByID(1).getFirstNames());
		 */
	}
}