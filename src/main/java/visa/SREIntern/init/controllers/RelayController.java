package visa.SREIntern.init.controllers;

import org.json.JSONException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface RelayController {
    @PostMapping("/runscope")
    String processRS(@RequestBody String input);

    @PostMapping("/ghostinspector")
    String processGI(@RequestBody String input);

}
