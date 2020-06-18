package visa.SREIntern.init.domain;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

public class GIInput implements Input{

    private final Integer test_origin = 2;

    private String test_name;
    private String test_run_id;
    private Boolean result;
    private Timestamp started_at;
    private Timestamp finished_at;
    private Integer response_time_ms;



    public GIInput(JSONObject obj) throws JSONException{

        JSONObject data = obj.getJSONObject("data");
        test_name = data.getString("name");
        test_run_id = data.getString("_id");
        result =  data.getBoolean("passing");

        String started = data.getString("dateExecutionStarted");
        String finished = data.getString("dateExecutionFinished");

        Instant start_instant = Instant.parse(started);
        Instant end_instant = Instant.parse(finished);

        started_at = Timestamp.from(start_instant);
        finished_at = Timestamp.from(end_instant);

        response_time_ms = data.getInt("executionTime");

    }

    @Override
    public void inputData(InputJDBCTemplate inputJDBCTemplate) {
        inputJDBCTemplate.create(test_name, test_run_id, result, started_at, finished_at, response_time_ms, test_origin);

    }

    public Integer getTest_origin() {
        return test_origin;
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

    @Override
    public String toString() {
        return "GIInput{" +
                "test_origin=" + test_origin +
                ", test_name='" + test_name + '\'' +
                ", test_run_id='" + test_run_id + '\'' +
                ", result=" + result +
                ", started_at=" + started_at +
                ", finished_at=" + finished_at +
                ", response_time_ms=" + response_time_ms +
                '}';
    }
}
