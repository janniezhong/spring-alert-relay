# spring-alert-relay

This project creates a server that takes webhook responses from alert services (such as Runscope, or Ghost Inspector) and consolidates them in a database (as for easier displaying and monitoring in Grafana).


### To Run:

Before running, set up a MySQL database using the script "sql-configure.sql" in the scripts directory. The server should be able to start smoothly from there.


### To add another input:

1. Add a new input class that extends the Input interface. For this, you can essentially copy paste from one of the other inputs and change the constructor to deal with the format of your specific input JSON.
2. Add another if-else to the InputFactory class, to account for your new input.
3. Add a new PostMapping method to the RelayController interface that will map to your specific input class.
4. Implement the method in RelayController - just copy paste one of the other methods and change the factory creation String in the method call.

And complete! You've added your own endpoint to this server. 
