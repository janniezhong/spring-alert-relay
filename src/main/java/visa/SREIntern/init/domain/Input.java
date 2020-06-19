package visa.SREIntern.init.domain;

import java.sql.Timestamp;
import java.util.Date;

public abstract class Input {

    String test_name;
    String test_run_id;
    Boolean result;
    Timestamp started_at;
    Timestamp finished_at;
    Integer response_time_ms;
    Integer test_origin;

    public Input(String test_name, String test_run_id, Boolean result, Timestamp started_at, Timestamp finished_at, Integer response_time_ms, Integer test_origin){
        this.test_name = test_name;
        this.test_run_id = test_run_id;
        this.result = result;
        this.started_at = started_at;
        this.finished_at = finished_at;
        this.response_time_ms = response_time_ms;
        this.test_origin = test_origin;
    }

    public void inputData(InputJDBCTemplate inputJDBCTemplate) {
        inputJDBCTemplate.create(test_name, test_run_id, result, started_at, finished_at, response_time_ms, test_origin);

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
