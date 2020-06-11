package visa.SREIntern.init.domain;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Input {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long finished_at;
    //private Variables variables;
    private String agent;
    private String team_id;
    private String result;
    private String team_name;
    private Long started_at;
    private String agent_expired;
    private String environment_uuid;
    private String environment_name;
    private String test_run_url;
    private String test_run_id;
    private String bucket_key;
    private String region_name;
    private String bucket_name;
    private String test_name;
    private String test_id;
    private String region;
    //private InitVariables initial_variables;
    private String test_url;
    private String trigger_url;

    private int request_response_size_bytes;
    private String requests_url;
    private int variables_fail;
    private int variables_total;
    private int variables_pass;
    private String requests_step_type;
    private String requests_note;
    private String requests_result;
    private String requests_response_status_code;
    private int scripts_fail;
    private int scripts_total;
    private int scripts_pass;
    private String requests_method;
    private int response_time_ms;
    private int assertions_fail;
    private int assertions_total;
    private int assertions_pass;

    public Input() {
    }

    public Input(Long finished_at, String agent, String team_id, String result, String team_name, Long started_at, String agent_expired, String environment_uuid, String environment_name, String test_run_url, String test_run_id, String bucket_key, String region_name, String bucket_name, String test_name, String test_id, String region, String test_url, String trigger_url, int request_response_size_bytes, String requests_url, int variables_fail, int variables_total, int variables_pass, String requests_step_type, String requests_note, String requests_result, String requests_response_status_code, int scripts_fail, int scripts_total, int scripts_pass, String requests_method, int response_time_ms, int assertions_fail, int assertions_total, int assertions_pass) {
        this.finished_at = finished_at;
        this.agent = agent;
        this.team_id = team_id;
        this.result = result;
        this.team_name = team_name;
        this.started_at = started_at;
        this.agent_expired = agent_expired;
        this.environment_uuid = environment_uuid;
        this.environment_name = environment_name;
        this.test_run_url = test_run_url;
        this.test_run_id = test_run_id;
        this.bucket_key = bucket_key;
        this.region_name = region_name;
        this.bucket_name = bucket_name;
        this.test_name = test_name;
        this.test_id = test_id;
        this.region = region;
        this.test_url = test_url;
        this.trigger_url = trigger_url;


        this.request_response_size_bytes = request_response_size_bytes;
        this.requests_url = requests_url;
        this.variables_fail = variables_fail;
        this.variables_total = variables_total;
        this.variables_pass = variables_pass;
        this.requests_step_type = requests_step_type;
        this.requests_note = requests_note;
        this.requests_result = requests_result;
        this.requests_response_status_code = requests_response_status_code;
        this.scripts_fail = scripts_fail;
        this.scripts_total = scripts_total;
        this.scripts_pass = scripts_pass;
        this.requests_method = requests_method;
        this.response_time_ms = response_time_ms;
        this.assertions_fail = assertions_fail;
        this.assertions_total = assertions_total;
        this.assertions_pass = assertions_pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Input input = (Input) o;
        return Objects.equals(id, input.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFinished_at() {
        return finished_at;
    }

    public void setFinished_at(Long finished_at) {
        this.finished_at = finished_at;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public Long getStarted_at() {
        return started_at;
    }

    public void setStarted_at(Long started_at) {
        this.started_at = started_at;
    }

    public String getAgent_expired() {
        return agent_expired;
    }

    public void setAgent_expired(String agent_expired) {
        this.agent_expired = agent_expired;
    }

    public String getEnvironment_uuid() {
        return environment_uuid;
    }

    public void setEnvironment_uuid(String environment_uuid) {
        this.environment_uuid = environment_uuid;
    }

    public String getEnvironment_name() {
        return environment_name;
    }

    public void setEnvironment_name(String environment_name) {
        this.environment_name = environment_name;
    }

    public String getTest_run_url() {
        return test_run_url;
    }

    public void setTest_run_url(String test_run_url) {
        this.test_run_url = test_run_url;
    }

    public String getTest_run_id() {
        return test_run_id;
    }

    public void setTest_run_id(String test_run_id) {
        this.test_run_id = test_run_id;
    }

    public String getBucket_key() {
        return bucket_key;
    }

    public void setBucket_key(String bucket_key) {
        this.bucket_key = bucket_key;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public String getBucket_name() {
        return bucket_name;
    }

    public void setBucket_name(String bucket_name) {
        this.bucket_name = bucket_name;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public String getTest_id() {
        return test_id;
    }

    public void setTest_id(String test_id) {
        this.test_id = test_id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTest_url() {
        return test_url;
    }

    public void setTest_url(String test_url) {
        this.test_url = test_url;
    }

    public String getTrigger_url() {
        return trigger_url;
    }

    public void setTrigger_url(String trigger_url) {
        this.trigger_url = trigger_url;
    }

    public int getRequest_response_size_bytes() {
        return request_response_size_bytes;
    }

    public void setRequest_response_size_bytes(int request_response_size_bytes) {
        this.request_response_size_bytes = request_response_size_bytes;
    }

    public String getRequests_url() {
        return requests_url;
    }

    public void setRequests_url(String requests_url) {
        this.requests_url = requests_url;
    }

    public int getVariables_fail() {
        return variables_fail;
    }

    public void setVariables_fail(int variables_fail) {
        this.variables_fail = variables_fail;
    }

    public int getVariables_total() {
        return variables_total;
    }

    public void setVariables_total(int variables_total) {
        this.variables_total = variables_total;
    }

    public int getVariables_pass() {
        return variables_pass;
    }

    public void setVariables_pass(int variables_pass) {
        this.variables_pass = variables_pass;
    }

    public String getRequests_step_type() {
        return requests_step_type;
    }

    public void setRequests_step_type(String requests_step_type) {
        this.requests_step_type = requests_step_type;
    }

    public String getRequests_note() {
        return requests_note;
    }

    public void setRequests_note(String requests_note) {
        this.requests_note = requests_note;
    }

    public String getRequests_result() {
        return requests_result;
    }

    public void setRequests_result(String requests_result) {
        this.requests_result = requests_result;
    }

    public String getRequests_response_status_code() {
        return requests_response_status_code;
    }

    public void setRequests_response_status_code(String requests_response_status_code) {
        this.requests_response_status_code = requests_response_status_code;
    }

    public int getScripts_fail() {
        return scripts_fail;
    }

    public void setScripts_fail(int scripts_fail) {
        this.scripts_fail = scripts_fail;
    }

    public int getScripts_total() {
        return scripts_total;
    }

    public void setScripts_total(int scripts_total) {
        this.scripts_total = scripts_total;
    }

    public int getScripts_pass() {
        return scripts_pass;
    }

    public void setScripts_pass(int scripts_pass) {
        this.scripts_pass = scripts_pass;
    }

    public String getRequests_method() {
        return requests_method;
    }

    public void setRequests_method(String requests_method) {
        this.requests_method = requests_method;
    }

    public int getResponse_time_ms() {
        return response_time_ms;
    }

    public void setResponse_time_ms(int response_time_ms) {
        this.response_time_ms = response_time_ms;
    }

    public int getAssertions_fail() {
        return assertions_fail;
    }

    public void setAssertions_fail(int assertions_fail) {
        this.assertions_fail = assertions_fail;
    }

    public int getAssertions_total() {
        return assertions_total;
    }

    public void setAssertions_total(int assertions_total) {
        this.assertions_total = assertions_total;
    }

    public int getAssertions_pass() {
        return assertions_pass;
    }

    public void setAssertions_pass(int assertions_pass) {
        this.assertions_pass = assertions_pass;
    }

}
