# spring-alert-relay

This project creates a server that takes webhook responses from alert services (such as Runscope, or Ghost Inspector) and consolidates them in a database (as for easier displaying and monitoring in Grafana).


### To Run:

Before running, set up a MySQL database using the script "sql-configure.sql" in the scripts directory. The server should be able to start smoothly from there.


### To add another input:

1. Add a new input class that extends the Input interface. The only requirement: a constructor that takes in the JSON object, parses the object for the necessary data fields, and puts them into the Input super constructor.
2. Add another if-else to the InputFactory class, to account for your new input.
3. Add a new PostMapping method to the RelayController interface that will map to your specific input class.
4. Implement the method in RelayController - just return the process() method call with the correct factory creation String in the method call.

And complete! You've added your own endpoint to this server. 
