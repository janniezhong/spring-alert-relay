# spring-alert-relay

This project creates a server that takes webhook responses from alert services (such as Runscope, or Ghost Inspector) and consolidates them in a database (i.e. for easier displaying and monitoring in Grafana).


### To Run:

Before running, set up a MySQL database using the script "sql-configure.sql" in the scripts directory. The server should be able to start smoothly from there.


### To add another input:

1. Add a new input class that extends the Input interface. The only requirement: a constructor that takes in the JSON object, calls the Input super constructor, parses the object for the necessary data fields, and sets the fields of the superclass.
2. Add another if-else to the InputFactory class, to account for your new input.
3. Add a new PostMapping method to the RelayController interface that will map to your specific input class.
4. Implement the method in RelayController - just return the process() method call with the correct factory creation String in the method call.

And complete! You've added your own endpoint to this server. 

### To Dockerize

Before containerizing, confirm that the "Beans.xml" file has the correct URL address for the MySQL database that you're running (localhost, 172.17.0.2). If the database is on another container in docker, run 
```
docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}’ [container_name]
```
to find the IP address.

Then run
```
mvn clean package
docker build -t spring-alert-relay .
docker run -p 8080:8080 spring-alert-relay
```
in command line, and you now have a container in Docker running this server!
