package visa.SREIntern.init.controllers;

import org.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface RelayController {

    @GetMapping("/")
    String test();

    @PostMapping("/runscope")
    String processRS(@RequestBody String input);

    @PostMapping("/ghostinspector")
    String processGI(@RequestBody String input);

}
