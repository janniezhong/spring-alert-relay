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
     */
    void create(String test_name, String test_run_id, Boolean result, Timestamp started_at, Timestamp finished_at, Integer response_time_ms, Integer test_origin);

    /**
     * Lists a record from the Input table corresponding to a passed Input id.
     */
    InputRecord getRecord(Integer id);

    /**
     * Lists all the records from the Input table.
     */
    List<InputRecord> listRecords();
}
