package visa.SREIntern.init.domain;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

public class GIInput extends Input{

    public GIInput(JSONObject obj) throws JSONException{

        super(obj.getJSONObject("data").getString("name"),
                obj.getJSONObject("data").getString("_id"),
                obj.getJSONObject("data").getBoolean("passing"),
                Timestamp.from(Instant.parse(obj.getJSONObject("data").getString("dateExecutionStarted"))),
                Timestamp.from(Instant.parse(obj.getJSONObject("data").getString("dateExecutionFinished"))),
                obj.getJSONObject("data").getInt("executionTime"),
                2);

//        test_origin = 2;
//
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

}
