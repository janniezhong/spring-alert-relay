package visa.SREIntern.init.storage;


import javax.sql.DataSource;
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
     * @param alert_id
     * @param category
     * @param component
     * @param priority
     * @param alert_source
     * @param alert_time
     * @param alert_title
     * @param results_link
     * @param error_count
     */
    void create(Long alert_id,
                String category,
                String component,
                String priority,
                String alert_source,
                Timestamp alert_time,
                String alert_title,
                String results_link,
                Double error_count
        );

//    /**
//     * Lists a record from the Input table corresponding to a passed Input id.
//     */
//    InputRecord getRecord(Integer id);
//
//    /**
//     * Lists all the records from the Input table.
//     */
//    List<InputRecord> listRecords();
}
