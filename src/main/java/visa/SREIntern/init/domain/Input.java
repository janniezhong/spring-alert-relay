package visa.SREIntern.init.domain;

import visa.SREIntern.init.storage.InputJDBCTemplate;

import java.sql.Timestamp;

/**
 * Abstract class representing any input payload.
 * @author janniezhong
 */
public abstract class Input {

    String test_name;
    String test_run_id;
    Boolean result;
    Timestamp started_at;
    Timestamp finished_at;
    Integer response_time_ms;
    Integer test_origin;


    /**
     * Creates an Input instance with all of the given parameters.
     * @param test_name name of the test run.
     * @param test_run_id id of the test run.
     * @param result the result of the test run.
     * @param started_at timestamp at which the test run began.
     * @param finished_at timestamp at which the test run ended.
     * @param response_time_ms duration of the test, in milliseconds.
     * @param test_origin integer representing which alert service this input came from. (1 - Runscope, 2 - Ghost Inspector)
     */
    public Input(String test_name, String test_run_id, Boolean result, Timestamp started_at, Timestamp finished_at, Integer response_time_ms, Integer test_origin){
        this.test_name = test_name;
        this.test_run_id = test_run_id;
        this.result = result;
        this.started_at = started_at;
        this.finished_at = finished_at;
        this.response_time_ms = response_time_ms;
        this.test_origin = test_origin;
    }

    /**
     * Inputs given data into {@link InputJDBCTemplate}
     * @param inputJDBCTemplate template in which to insert this class' data.
     */
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
