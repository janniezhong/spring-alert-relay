package visa.SREIntern.init.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;
import visa.SREIntern.init.controllers.RelayController;
import visa.SREIntern.init.domain.*;
import org.json.*;
import org.springframework.context.*;
import visa.SREIntern.init.repositories.*;

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
        try{
            System.out.println("Server up and running.");

            System.out.println("It's a Runscope test!");

            JSONObject obj = new JSONObject(input);
            System.out.println("JSONObject created successfully.");
            Input imp = inputFactory.getInput("RUNSCOPE",obj);
            System.out.println("Runscope object returned.");

            if (imp == null){
                System.out.println("Houston, we have a problem");
            } else {
                System.out.println(imp.toString());
                imp.inputData(inputJDBCTemplate);
            }

            return ("success");
        } catch(Exception exc){
            System.out.println(exc.toString());
            return null;
        }
    }

    @Override
    public String processGI(String input){
        try{
            System.out.println("Server up and running.");

            System.out.println("It's a Ghost Inspector test!");

            JSONObject obj = new JSONObject(input);
            System.out.println("JSONObject created successfully.");
            Input imp = inputFactory.getInput("GHOST INSPECTOR",obj);
            System.out.println("Ghost Inspector object returned.");

            if (imp == null){
                System.out.println("Houston, we have a problem");
            } else {
                System.out.println(imp.toString());
                imp.inputData(inputJDBCTemplate);
            }

            return ("success");
        } catch(Exception exc){
            System.out.println(exc.toString());
            return null;
        }
    }

//    @GetMapping("/")
//    public String init(Model model){
//        return ("input");
//    }







}