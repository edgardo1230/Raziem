# README #

API Gateway Server's 

### Requirements ###

* Java 8
* Maven 3.3.x
* Docker host or Docker machine
* In case is desirable for Zuul Server maps routes to services from servicesIds, running instance(s) of Eureka Server as described at [https://github.com/edgardo1230/](https://github.com/edgardo1230/) would be needed.
* In case is desirable for Zuul Server to auto-reload routes as they are updated via `-Dspring.profiles.active=refreshable`, running instance(s) of Config Server (in **config-monitor** mode) and RabbitMQ as described at [https://github.com/edgardo1230/](https://github.com/edgardo1230/) would be needed.


### Building the artifact ###

```
mvn clean package
```

### Running Zuul service ###

Assumes two instances of Eureka Server.

```
java -Dspring.profiles.active=refreshable -DappPort=8281 -DhostName=localhost -Deureka.client.serviceUrl.defaultZone="http://localhost:8001/eureka/,http://localhost:8002/eureka/" -jar target/apiGateway.jar
```

### How do I get set up using Docker? ###

```
sudo docker pull raziem/apiGateway
```

Assumes two instances of Eureka Server as described at [https://github.com/edgardo1230/](https://github.com/edgardo1230/)
```
sudo docker run -idt -p 8281:8281 -e appPort=8281 -e spring.profiles.active=refreshable -e hostName=localhost -e eureka.client.serviceUrl.defaultZone=http://localhost:8001/eureka/,http://localhost:8002/eureka/ raziem/apiGateway:latest
```

### Available endpoints

`http://localhost:8201/apiGateway/actors/{id}`

### Who do I talk to? ###

* raziem1230@gmail.com
* https://www.linkedin.com/in/edgardo-cruz-sastre-21889941/