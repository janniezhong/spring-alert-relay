package visa.SREIntern.init.controllers;

import org.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * Basic format of a controller
 * @author janniezhong
 */
public interface RelayController {

    /**
     * Posts the JSON payload to be processed as a Runscope input.
     * @param input the JSON payload as an input string
     * @return the String that links to a static html page to display.
     */
    @PostMapping("/runscope")
    String processRS(@RequestBody String input);

    /**
     * Posts the JSON payload to be processed as a Ghost Inspector input.
     * @param input the JSON payload as an input string
     * @return the String that links to a static html page to display.
     */
    @PostMapping("/ghostinspector")
    String processGI(@RequestBody String input);

}
