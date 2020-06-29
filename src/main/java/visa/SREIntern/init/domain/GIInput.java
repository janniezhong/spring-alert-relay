package visa.SREIntern.init.domain;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import visa.SREIntern.init.generators.IdGenerator;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Represents a Ghost Inspector payload.
 * @author janniezhong
 */
public class GIInput extends Input{

    private int errorCount;

    /**
     * Creates an GIInput instance with the data given.
     * @param obj the JSON object created from the input String.
     * @throws JSONException when the JSON object does not contain the appropriate data fields or is formatted incorrectly.
     */
    public GIInput(JSONObject obj) throws JSONException{

        super();
        JSONObject data = obj.getJSONObject("data");

        //alert_id
        setAlert_id(IdGenerator.INSTANCE.generateNewId());

        //category + component - set in RelayControllerImpl

        //String priority
        Boolean result =  data.getBoolean("passing");
        if (result){
            setPriority("P5");
        } else {
            setPriority("P3");
        }

        //alert_source
        setAlert_source("Ghost Inspector");

        //alert_time
        String started = data.getString("dateExecutionStarted");
        Instant start_instant = Instant.parse(started);
        Timestamp startTime = Timestamp.from(start_instant);
        setAlert_time(startTime);

        //alert_title
        setAlert_title(data.getString("name"));

        //results_link
        JSONObject screenshot = data.getJSONObject("screenshot");
        JSONObject original = screenshot.getJSONObject("original");
        String results_link = original.getString("defaultUrl");
        setResults_link(results_link);

        //error_count
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
