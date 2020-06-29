package visa.SREIntern.init.domain;

import org.json.*;
import visa.SREIntern.init.generators.*;
import java.sql.Timestamp;


/**
 * Represents a Runscope payload.
 * @author janniezhong
 */
public class RSInput extends Input{

//    //private Timestamp finished_at;
//    //private Variables variables;
//    private String agent;
//    private String team_id;
//    //private Boolean result;
//    private String team_name;
//    //private Timestamp started_at;
//    private String agent_expired;
//    private String environment_uuid;
//    private String environment_name;
//    private String test_run_url;
//    //private String test_run_id;
//    private String bucket_key;
//    private String region_name;
//    private String bucket_name;
//    //private String test_name;
//    private String test_id;
//    private String region;
//    //private InitVariables initial_variables;
//    private String test_url;
//    private String trigger_url;
//
//    private int requests_response_size_bytes;
//    private String requests_url;
//    private int variables_fail;
//    private int variables_total;
//    private int variables_pass;
//    private String requests_step_type;
//    private String requests_note;
//    private String requests_result;
//    private String requests_response_status_code;
//    private int scripts_fail;
//    private int scripts_total;
//    private int scripts_pass;
//    private String requests_method;
//    //private int response_time_ms;
//    private int assertions_fail;
//    private int assertions_total;
//    private int assertions_pass;

    private int totalNumTests;
    private int errorCount;

    /**
     * Creates an RSInput instance with the data given.
     * @param obj the JSON object created from the input String.
     * @throws JSONException when the JSON object does not contain the appropriate data fields or is formatted incorrectly.
     */
    public RSInput(JSONObject obj) throws JSONException{
        super();

        //alert_id
        setAlert_id(IdGenerator.INSTANCE.generateNewId());

        //category + component - set in RelayControllerImpl

        //String priority
        JSONArray requests = obj.getJSONArray("requests");
        JSONObject request_content = requests.getJSONObject(0);
        JSONObject requests_variables = request_content.getJSONObject("variables");
        JSONObject scripts = request_content.getJSONObject("scripts");
        JSONObject assertions = request_content.getJSONObject("assertions");
        totalNumTests = requests_variables.getInt("total") + scripts.getInt("total") + assertions.getInt("total");
        errorCount = requests_variables.getInt("fail") + scripts.getInt("fail") + assertions.getInt("fail");

        setPriority(calcPriority());

        //alert_source
        setAlert_source("Runscope");

        //alert_time
        long started = obj.getLong("started_at");
        setAlert_time(new Timestamp(started));

        //alert_title
        setAlert_title(obj.getString("test_name"));

        //results_link
        setResults_link(obj.getString("test_run_url"));

        //error_count
        setError_count((double)errorCount);



//        test_name = obj.getString("test_name");
//        test_run_id = obj.getString("test_run_id");
//        String result_String = obj.getString("result");
//        if (result_String.equalsIgnoreCase("pass")){
//            result = true;
//        } else {
//            result = false;
//        }
//        long started = obj.getLong("started_at");
//        long finished = obj.getLong("finished_at");
//
//        started_at = new Timestamp(started);
//        finished_at = new Timestamp(finished);
//
//        JSONArray requests = obj.getJSONArray("requests");
//        JSONObject request_content = requests.getJSONObject(0);
//        response_time_ms = request_content.getInt("response_time_ms");
//



//        //JSONObject variables = obj.getJSONObject("variables");
//        agent = obj.getString("agent");
//        team_id = obj.getString("team_id");
//        team_name = obj.getString("team_name");
//        agent_expired = obj.getString("agent_expired");
//        environment_uuid = obj.getString("environment_uuid");
//        environment_name = obj.getString("environment_name");
//        test_run_url = obj.getString("test_run_url");
//        test_run_id = obj.getString("test_run_id");
//        bucket_key = obj.getString("bucket_key");
//        region_name = obj.getString("region_name");
//        bucket_name = obj.getString("bucket_name");
//        test_name = obj.getString("test_name");
//        test_id = obj.getString("test_id");
//        region = obj.getString("region");
//        //JSONObject initial_variables = obj.getJSONObject("initial_variables");
//        test_url = obj.getString("test_url");
//        trigger_url = obj.getString("trigger_url");
//        requests_response_size_bytes = request_content.getInt("response_size_bytes");
//        requests_url = request_content.getString("url");
//        JSONObject requests_variables = request_content.getJSONObject("variables");
//        variables_fail = requests_variables.getInt("fail");
//        variables_total = requests_variables.getInt("total");
//        variables_pass = requests_variables.getInt("pass");
//        requests_step_type = request_content.getString("step_type");
//        requests_note = request_content.getString("note");
//        requests_result =request_content.getString("result");
//        requests_response_status_code =request_content.getString("response_status_code");
//        JSONObject scripts = request_content.getJSONObject("scripts");
//        scripts_fail = scripts.getInt("fail");
//        scripts_total = scripts.getInt("total");
//        scripts_pass = scripts.getInt("pass");
//        requests_method = request_content.getString("method");
//        JSONObject assertions = request_content.getJSONObject("assertions");
//        assertions_fail = assertions.getInt("fail");
//        assertions_total = assertions.getInt("total");
//        assertions_pass = assertions.getInt("pass");

    }

    /**
     * Converts a String into a boolean, dependent on the content of the String.
     * @param result String from the JSON payload to be evaluated.
     * @return a Boolean representing the input String.
     */
    private static Boolean evalResult(String result){
        if (result.equalsIgnoreCase("pass")){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Calculates the priority of the alert, based on the ratio of error count to total count.
     * @return a String representing the priority of the alert (P1 - P5)
     */
    private String calcPriority(){
        double ratio = (double)errorCount/(double)totalNumTests;

        if(totalNumTests == 0 || ratio == 0) {
            return "P5";
        }else if (ratio <= 0.2){
            return "P4";
        }else if (ratio <= 0.3){
            return "P3";
        }else if (ratio <= 0.6){
            return "P2";
        } else {
            return "P1";
        }

        // does not account for when error > total. Should be impossible.
    }


}
