import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Person;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class EntityReportGenerator implements ReportGenerator {

	@Override
	public void newReport() {
		try {
			NewEM nem = new NewEM();
			EntityManager em = nem.initEntityManager();
			
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

}
