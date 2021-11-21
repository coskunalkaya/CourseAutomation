# CourseAutomation

This is a sample Java / Maven / Spring Boot.

### How to Run
This application is packaged as a war which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the java -jar command.

- Clone this repository
- Make sure you are using JDK 1.8, Maven and MongoDB 
- You can build the project and run the tests by running mvn clean package
- Once successfully built, you can run the service by one of these two methods:
<pre>
        java -jar -Dspring.profiles.active=test target/CourseAutomation-0.0.1-SNAPSHOT.jar
or
        mvn spring-boot:run -Drun.arguments="spring.profiles.active=test"
</pre>

- Check the stdout to make sure no exceptions are thrown
