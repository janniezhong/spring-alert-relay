package visa.SREIntern.init.domain;

import org.json.*;
import visa.SREIntern.init.generators.*;
import java.sql.Timestamp;


/**
 * Represents a Runscope payload.
 * @author janniezhong
 */
public class RSInput extends Input{

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
