package visa.SREIntern.init.storage;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Represents a row of data in the MySQL database.
 */
@Component
public class InputRecord {
    private Integer id;
    private String test_name;
    private String test_run_id;
    private Boolean result;
    private Timestamp started_at;
    private Timestamp finished_at;
    private Integer response_time_ms;
    private Integer test_origin;

    public Integer getTest_origin() {
        return test_origin;
    }

    public void setTest_origin(Integer test_origin) {
        this.test_origin = test_origin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public String getTest_run_id() {
        return test_run_id;
    }

    public void setTest_run_id(String test_run_id) {
        this.test_run_id = test_run_id;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Timestamp getStarted_at() {
        return started_at;
    }

    public void setStarted_at(Timestamp started_at) {
        this.started_at = started_at;
    }

    public Timestamp getFinished_at() {
        return finished_at;
    }

    public void setFinished_at(Timestamp finished_at) {
        this.finished_at = finished_at;
    }

    public Integer getResponse_time_ms() {
        return response_time_ms;
    }

    public void setResponse_time_ms(Integer response_time_ms) {
        this.response_time_ms = response_time_ms;
    }
}
