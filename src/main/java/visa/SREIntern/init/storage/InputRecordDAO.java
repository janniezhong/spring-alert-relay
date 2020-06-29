package visa.SREIntern.init.storage;


import javax.sql.DataSource;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

/**
 * Interface containing the methods to interact with a database.
 */
public interface InputRecordDAO {
    /**
     * Initialize database resources ie. connection.
     */
    void setDataSource(DataSource ds);

    /**
     * Creates a record in the Input table.
     * @param alert_id the id of the alert in the table. Also the primary key.
     * @param category the category to which this alert belongs to.
     * @param component the component that this alert came from.
     * @param priority the priority this alert holds.
     * @param alert_source the alert source.
     * @param alert_time the time this alert was triggered.
     * @param alert_title the name of this alert.
     * @param results_link the link to access alert results.
     * @param error_count the error count in this particular alert.
     */
    void create(BigInteger alert_id,
                String category,
                String component,
                String priority,
                String alert_source,
                Timestamp alert_time,
                String alert_title,
                String results_link,
                Double error_count
        );

}
