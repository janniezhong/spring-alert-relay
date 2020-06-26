package visa.SREIntern.init.domain;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Represents a Ghost Inspector payload.
 * @author janniezhong
 */
public class GIInput extends Input{

    /**
     * Creates an GIInput instance with the data given.
     * @param obj the JSON object created from the input String.
     * @throws JSONException when the JSON object does not contain the appropriate data fields or is formatted incorrectly.
     */
    public GIInput(JSONObject obj) throws JSONException{

        super();
        JSONObject data = obj.getJSONObject("data");

        //alert_id
        setAlert_id((long)1234567890);

        //category + component - set in RelayControllerImpl

        //String priority
        setPriority("P3");

        //alert_source
        setAlert_source("Ghost Inspector");

        //alert_time
        String finished = data.getString("dateExecutionFinished");
        Instant end_instant = Instant.parse(finished);
        Timestamp endTime = Timestamp.from(end_instant);
        setAlert_time(endTime);

        //alert_title
        setAlert_title(data.getString("name"));

        //results_link
        setResults_link(data.getString("endUrl"));

        //error_count
        Boolean result =  data.getBoolean("passing");
        setError_count(evalResult(result));



//        JSONObject data = obj.getJSONObject("data");
//        String name = data.getString("name");
//        String id = data.getString("_id");
//        Boolean result =  data.getBoolean("passing");
//
//        String started = data.getString("dateExecutionStarted");
//        String finished = data.getString("dateExecutionFinished");
//
//        Instant start_instant = Instant.parse(started);
//        Instant end_instant = Instant.parse(finished);
//
//        Timestamp startTime = Timestamp.from(start_instant);
//        Timestamp endTime = Timestamp.from(end_instant);
//
//        Integer responseTime = data.getInt("executionTime");

    }
    private static Double evalResult(Boolean result){
        if (result){
            return 0.0;
        } else {
            return 1.0;
        }
    }

}
