import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
//import com.mysql.jdb.*;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.io.*;

/**
 * 
 */

/**
 * @author JoDan
 *
 */
public class EntityReport {
	
	public static void main(String[] args){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jpatutorial2","root","camelCase12");
			
			//load JR file
			InputStream inStream = new FileInputStream(new File("C:/Users/JoDan/Documents/GitHub/Bravo/Reporting/reporting/src/main/java/BravoReport.jrxml"));
			
			//compile JR file
			JasperDesign jDesign = JRXmlLoader.load(inStream);
			JasperReport jReport = JasperCompileManager.compileReport(jDesign);
			
			//create JR print object
			Map<String,String> map = new HashMap<String,String>();
			map.put("jasper report", "employee report");
			
			//fill report
			JasperPrint jPrint = JasperFillManager.fillReport(jReport, null,con);
			
			//export
			OutputStream outStream= new FileOutputStream(new File("C:/Users/JoDan/Documents/exp.pdf"));
			JasperExportManager.exportReportToPdfStream(jPrint, outStream);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
