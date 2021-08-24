package visa.SREIntern.init.domain;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

/**
 * Class to create the necessary Input classes (as part of a factory pattern).
 */
@Component
public class InputFactory extends Input {

    /**
     * Initializes an input class given the inputType (i.e. Runscope, Ghost Inspector)
     * @param inputType String indicating from which alert service this JSON payload came from.
     * @param obj JSON object containing the payload.
     * @return the correct Input type.
     * @throws JSONException when the JSON object does not contain the appropriate data fields or is formatted incorrectly.
     */
    public Input getInput(String inputType, JSONObject obj) throws JSONException {
        if (inputType == null){
            return null;
        } else if(inputType.equalsIgnoreCase("GHOST INSPECTOR")){
            return new GIInput(obj);
        } else if (inputType.equalsIgnoreCase("RUNSCOPE")){
            return new RSInput(obj);
        }
        return null;
    }
}
