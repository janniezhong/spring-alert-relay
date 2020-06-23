package visa.SREIntern.init.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import visa.SREIntern.init.controllers.RelayController;
import visa.SREIntern.init.domain.*;
import org.json.*;
import org.springframework.context.*;
import visa.SREIntern.init.exceptions.CustomException;
import visa.SREIntern.init.storage.InputJDBCTemplate;
import visa.SREIntern.init.storage.InputRecord;

@Controller
public class RelayControllerImpl implements RelayController {

    private InputRecord inputRepo;
    private InputFactory inputFactory;
    ApplicationContext context;
    InputJDBCTemplate inputJDBCTemplate;

    @Autowired
    public RelayControllerImpl(InputRecord inputRepo, InputFactory inputFactory) {
        this.inputRepo = inputRepo;
        this.inputFactory = inputFactory;
        context = new ClassPathXmlApplicationContext("Beans.xml");
        inputJDBCTemplate = (InputJDBCTemplate)context.getBean("inputJDBCTemplate");
    }

    @Override
    public String processRS(String input){
        return process(input,"RUNSCOPE");
    }

    @Override
    public String processGI(String input){
        return process(input,"GHOST INSPECTOR");
    }

    /**
     * Private method to convert input strings into their respective classes.
     * @param input the input String that was POSTed.
     * @param inputType the alert service the input came from (Runscope, Ghost Inspector, etc). Must match the strings in {@link visa.SREIntern.init.domain.InputFactory}
     * @return the String that links to a static html page to display.
     * @throws CustomException if input string is of the incorrect format.
     */
    private String process(String input, String inputType){
        try{
            System.out.println("Server up and running.");

            JSONObject obj = new JSONObject(input);
            System.out.println("JSONObject created successfully.");
            Input imp = inputFactory.getInput(inputType,obj);
            System.out.println("input object returned.");

            if (imp == null){
                System.out.println("Houston, we have a problem");
            } else {
                imp.inputData(inputJDBCTemplate);
            }

            return ("success");
        } catch(Exception exc){
            System.out.println("Message: " +exc.getMessage());
            throw new CustomException(exc.getMessage());
        }
    }







}