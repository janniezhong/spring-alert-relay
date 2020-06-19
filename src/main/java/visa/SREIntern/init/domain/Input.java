package visa.SREIntern.init.domain;

import java.sql.Timestamp;
import java.util.Date;

public abstract class Input {

    Integer test_origin;
    String test_name;
    String test_run_id;
    Boolean result;
    Timestamp started_at;
    Timestamp finished_at;
    Integer response_time_ms;

    public void inputData(InputJDBCTemplate inputJDBCTemplate) {
        inputJDBCTemplate.create(test_name, test_run_id, result, started_at, finished_at, response_time_ms, test_origin);

    }
}
