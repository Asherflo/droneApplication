# droneApplication

A drone application is a digital platform  that allow user to register a drone and a drone is capable of delivering 
small loads called medications.This project is created using springboot using mavens dependency and mySQL as database.


# Starting the database
To start the mysql database run the docker-compose command on the terminal

$ docker-compose up
this will start up the mysql db with the configurations in the application.yml file

# To check the database, run
$ docker-compose exec mysql -u user -p

# To Build
run form the application directory (Note: You must have maven installed)

$ mvn clean install
OR
$ ./mvnw clean install

# To Run
Java JDK or JRE must be installed.

$ java -jar ./target/drone.jar

