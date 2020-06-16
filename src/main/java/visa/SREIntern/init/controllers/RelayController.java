package visa.SREIntern.init.controllers;

import org.json.JSONException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface RelayController {
    @PostMapping("/")
    String process(@RequestBody String input);

}
