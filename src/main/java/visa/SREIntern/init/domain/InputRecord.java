package visa.SREIntern.init.domain;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class InputRecord {
    private String test_name;
    private String test_run_id;
    private Boolean result;
    private Date started_at;
    private Date finished_at;
    private Integer execTime;

    public InputRecord() {
    }

    public InputRecord(String test_name, String test_run_id, Boolean result, Date started_at, Date finished_at, Integer execTime) {
        this.test_name = test_name;
        this.test_run_id = test_run_id;
        this.result = result;
        this.started_at = started_at;
        this.finished_at = finished_at;
        this.execTime = execTime;
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

    public Integer getExecTime() {
        return execTime;
    }

    public void setExecTime(Integer execTime) {
        this.execTime = execTime;
    }
}
