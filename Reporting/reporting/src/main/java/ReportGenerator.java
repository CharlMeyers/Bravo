import javax.persistence.Query;

/**
 * 
 */

/**
 * @author JoDan
 *
 */
public interface ReportGenerator {
	public void newReport(Query q) throws NullEntryException;
}
