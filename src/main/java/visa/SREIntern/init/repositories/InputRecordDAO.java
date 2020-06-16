package visa.SREIntern.init.repositories;


import visa.SREIntern.init.domain.InputRecord;

import javax.sql.DataSource;
import java.util.List;

public interface InputRecordDAO {
    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    void setDataSource(DataSource ds);

    /**
     * This is the method to be used to create
     * a record in the Student table.
     */
    void create(String name, Integer age);

    /**
     * This is the method to be used to list down
     * a record from the Student table corresponding
     * to a passed student id.
     */
    InputRecord getRecord(Integer id);

    /**
     * This is the method to be used to list down
     * all the records from the Student table.
     */
    List<InputRecord> listRecords();
}
