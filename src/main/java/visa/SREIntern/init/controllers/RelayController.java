package visa.SREIntern.init.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import visa.SREIntern.init.domain.*;
import org.json.*;
import visa.SREIntern.init.repositories.*;

@Controller
public class RelayController {

    private InputRepository inputRepo;

    @Autowired
    public RelayController(InputRepository inputRepo) {
        this.inputRepo = inputRepo;
    }

    @GetMapping("/")
    public String init(Model model){
        return ("input");
    }
    @PostMapping(path = "/", consumes = "application/json")
    public String process(@RequestBody String input) throws JSONException {

//        System.out.println(input.getTeam_id());
//        System.out.println(input.getVariables());
//        System.out.println(input.getStarted_at());
//        System.out.println(input.getRequests());

        System.out.println("hi!");

        JSONObject obj = new JSONObject(input);

        long finished_at = obj.getLong("finished_at");
        JSONObject variables = obj.getJSONObject("variables");
        //
        String agent = obj.getString("agent");
        String team_id = obj.getString("team_id");
        String result = obj.getString("result");
        String team_name = obj.getString("team_name");
        long started_at = obj.getLong("started_at");
        String agent_expired = obj.getString("agent_expired");
        String environment_uuid = obj.getString("environment_uuid");
        String environment_name = obj.getString("environment_name");
        String test_run_url = obj.getString("test_run_url");
        String test_run_id = obj.getString("test_run_id");
        String bucket_key = obj.getString("bucket_key");
        String region_name = obj.getString("region_name");
        String bucket_name = obj.getString("bucket_name");
        String test_name = obj.getString("test_name");
        String test_id = obj.getString("test_id");
        String region = obj.getString("region");
        JSONObject initial_variables = obj.getJSONObject("initial_variables");
        //
        String test_url = obj.getString("test_url");
        String trigger_url = obj.getString("trigger_url");


        JSONArray requests = obj.getJSONArray("requests");
        JSONObject request_content = requests.getJSONObject(0);
        int requests_response_size_bytes = request_content.getInt("response_size_bytes");
        String requests_url = request_content.getString("url");
        JSONObject requests_variables = request_content.getJSONObject("variables");
        int variables_fail = requests_variables.getInt("fail");
        int variables_total = requests_variables.getInt("total");
        int variables_pass = requests_variables.getInt("pass");
        String requests_step_type = request_content.getString("step_type");
        String requests_note = request_content.getString("note");
        String requests_result =request_content.getString("result");
        String requests_response_status_code =request_content.getString("response_status_code");
        JSONObject scripts = request_content.getJSONObject("scripts");
        int scripts_fail = scripts.getInt("fail");
        int scripts_total = scripts.getInt("total");
        int scripts_pass = scripts.getInt("pass");
        String requests_method = request_content.getString("method");
        int response_time_ms = request_content.getInt("response_time_ms");
        JSONObject assertions = request_content.getJSONObject("assertions");
        int assertions_fail = assertions.getInt("fail");
        int assertions_total = assertions.getInt("total");
        int assertions_pass = assertions.getInt("pass");

        Input data = new Input(finished_at, agent, team_id, result, team_name, started_at, agent_expired, environment_uuid, environment_name, test_run_url, test_run_id, bucket_key, region_name, bucket_name, test_name, test_id, region, test_url, trigger_url, requests_response_size_bytes, requests_url, variables_fail, variables_total, variables_pass, requests_step_type, requests_note, requests_result, requests_response_status_code, scripts_fail, scripts_total, scripts_pass, requests_method, response_time_ms, assertions_fail, assertions_total, assertions_pass);

        inputRepo.save(data);


        /*
        System.out.println(finished_at);
        System.out.println(variables);
        System.out.println(agent);
        System.out.println(team_id);
        System.out.println(result);
        System.out.println(team_name);
        System.out.println(started_at);
        System.out.println(agent_expired);
        System.out.println(environment_uuid);
        System.out.println(environment_name);
        System.out.println(test_run_url);
        System.out.println(test_run_id);
        System.out.println(bucket_key);
        System.out.println(region_name);
        System.out.println(bucket_name);
        System.out.println(test_name);
        System.out.println(test_id);
        System.out.println(region);
        System.out.println(initial_variables);
        System.out.println(test_url);
        System.out.println(trigger_url);
        System.out.println(request_content);
        System.out.println()
        */
        return ("success");
    }





}