package visa.SREIntern.init.domain;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class InputFactory {
    public Input getInput(String inputType, JSONObject obj) throws JSONException {
        if (inputType == null){
            return null;
        } else if(inputType.equalsIgnoreCase("GHOST INSPECTOR")){
            return new GIInput(obj);
        } else if (inputType.equalsIgnoreCase("RUNSCOPE")){
            System.out.println("Returning a Runscope object.");
            return new RSInput(obj);
        }

        return null;
    }
}
