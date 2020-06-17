package visa.SREIntern.init.domain;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class InputRecord {
    private Integer id;
    private String test_name;
    private String test_run_id;
    private Boolean result;
    private Date started_at;
    private Date finished_at;
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

    public Date getStarted_at() {
        return started_at;
    }

    public void setStarted_at(Date started_at) {
        this.started_at = started_at;
    }

    public Date getFinished_at() {
        return finished_at;
    }

    public void setFinished_at(Date finished_at) {
        this.finished_at = finished_at;
    }

    public Integer getResponse_time_ms() {
        return response_time_ms;
    }

    public void setResponse_time_ms(Integer response_time_ms) {
        this.response_time_ms = response_time_ms;
    }
}
