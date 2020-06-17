package visa.SREIntern.init.repositories;


import visa.SREIntern.init.domain.InputRecord;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

public interface InputRecordDAO {
    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    void setDataSource(DataSource ds);

    /**
     * This is the method to be used to create
     * a record in the Input table.
     */
    void create(String test_name, String test_run_id, Boolean result, Date started_at, Date finished_at, Integer response_time_ms, Integer test_origin);

    /**
     * This is the method to be used to list down
     * a record from the Input table corresponding
     * to a passed Input id.
     */
    InputRecord getRecord(Integer id);

    /**
     * This is the method to be used to list down
     * all the records from the Input table.
     */
    List<InputRecord> listRecords();
}
