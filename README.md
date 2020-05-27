# ZurichApplication - Back End


#### Build Spring Boot Projects whit Maven, starting from parent project zurich-back-end:

`mvn clean install`


#### Run Spring Boot Config Server with Maven:

`java -jar config-server/target/config-server-0.0.1.jar`


#### Run Spring Boot Quotazione Microservice with Maven:

`java -jar -Dspring.profiles.active=svi quotazione/target/quotazione-0.0.1.jar` 


#### Run Spring Boot Anagrafica Microservice with Maven:

`java -jar -Dspring.profiles.active=svi anagrafica/target/anagrafica-0.0.1.jar` 

