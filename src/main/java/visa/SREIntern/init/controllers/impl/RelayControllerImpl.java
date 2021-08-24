package visa.SREIntern.init.controllers.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import visa.SREIntern.init.AlertRelayApplication;
import visa.SREIntern.init.controllers.RelayController;
import visa.SREIntern.init.domain.*;
import org.json.*;
import org.springframework.context.*;
import visa.SREIntern.init.exceptions.CustomException;
import visa.SREIntern.init.storage.InputJDBCTemplate;
import visa.SREIntern.init.storage.InputRecord;

@RestController
public class RelayControllerImpl implements RelayController {
    private static final Logger LOGGER = LogManager.getLogger(RelayControllerImpl.class);

    private InputFactory inputFactory;
    ApplicationContext context;
    InputJDBCTemplate inputJDBCTemplate;

    @Autowired
    public RelayControllerImpl(InputFactory inputFactory) {
        this.inputFactory = inputFactory;
        context = new ClassPathXmlApplicationContext("Beans.xml");
        inputJDBCTemplate = (InputJDBCTemplate)context.getBean("inputJDBCTemplate");
    }

    @Override
    public ResponseEntity<String> processRS(String input, String category, String component) {
        return process(input, category, component, "RUNSCOPE");
    }

    @Override
    public ResponseEntity<String> processGI(String input, String category, String component) {
        return process(input, category, component, "GHOST INSPECTOR");
    }

    /**
     * Private method to convert input strings into their respective classes.
     * @param input the input String that was POSTed.
     * @param inputType the alert service the input came from (Runscope, Ghost Inspector, etc). Must match the strings in {@link visa.SREIntern.init.domain.InputFactory}
     * @return the String that links to a static html page to display.
     * @throws CustomException if input string is of the incorrect format.
     */
    private ResponseEntity<String> process(String input, String category, String component, String inputType){
        try{
            LOGGER.info("Server request received. The JSON Object as a string: "+ input);
            JSONObject obj = new JSONObject(input);
            LOGGER.info("JSONObject created successfully.");
            Input imp = inputFactory.getInput(inputType,obj);
            LOGGER.info("Input object returned. Content: " + imp.toString());

            if (imp == null){
                LOGGER.error("Something went wrong creating the input.");
            } else {
                imp.setCategory(category);
                imp.setComponent(component);
                imp.inputData(inputJDBCTemplate);
            }

            ResponseEntity<String> responseMsg = new ResponseEntity<>("Input success. " + imp.toString() + "\n", HttpStatus.OK);
            LOGGER.info("Server response: \"" + responseMsg.toString() + "\"");
            return responseMsg;
        } catch(Exception exc){
            LOGGER.error("JSON from webhook not formatted correctly, unable to create Input object. Exception message: "+ exc.getMessage());
            throw new CustomException(exc.getMessage());
        }
    }
}