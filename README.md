spring-action-monitor
=====================

This is a simple application that monitors database insert and update events and notifies clients connected to it through websockets.

It uses:
  * Spring
  * Mockito
  * H2 in-memory database

Building and running
--------------------
To run the application:

    mvn spring-boot:run

To build the application with tests and generate a jar containing all necessary dependencies:

    mvn clean package

To run the previously built jar:

    java -jar target/action-monitor-1.0-SNAPSHOT.jar

The UI is available at:

    http://localhost:8080

REST endpoints
--------------

To check if the application is running:

    http://localhost:8080/alive

To check the version of the application:

    http://localhost:8080/version