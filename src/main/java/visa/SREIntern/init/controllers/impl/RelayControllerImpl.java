package visa.SREIntern.init.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;
import visa.SREIntern.init.controllers.RelayController;
import visa.SREIntern.init.domain.*;
import org.json.*;
import visa.SREIntern.init.repositories.*;

@Controller
public class RelayControllerImpl implements RelayController {

    private InputRecord inputRepo;
    private InputFactory inputFactory;


    @Autowired
    public RelayControllerImpl(InputRecord inputRepo, InputFactory inputFactory) {
        this.inputRepo = inputRepo;
        this.inputFactory = inputFactory;
    }

    @Override
    public String process(String input){
        try{
            System.out.println("Server up and running.");

            JSONObject obj = new JSONObject(input);

            // Figure out which alert service this came from
            if (1 == 0){ // Ghost Inspector

            } else { //Runscope
                Input imp = inputFactory.getInput("RUNSCOPE",obj);
                if (imp == null){
                    System.out.println("Houston, we have a problem");
                } else {
                    imp.inputData();
                }

            }

            return ("success");
        } catch(Exception exc){
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Foo Not Found", exc);

        }

    }

//    @GetMapping("/")
//    public String init(Model model){
//        return ("input");
//    }


//    @PostMapping(path = "/", consumes = "application/json")
//    public String process(@RequestBody String input) throws JSONException {
//
//        System.out.println("Server up and running.");
//
//        JSONObject obj = new JSONObject(input);
//
//        // Figure out which alert service this came from
//
//        if (1 == 0){ // Ghost Inspector
//
//        } else { //Runscope
//
//        }
//
//
//
//        return ("success");
//    }







}