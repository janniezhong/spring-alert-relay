package visa.SREIntern.init.domain;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

public class GIInput extends Input{

    public GIInput(JSONObject obj) throws JSONException{

        test_origin = 2;

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

}
