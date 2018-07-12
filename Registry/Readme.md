# README #

Registry Server's 

### Requirements ###

* Java 8
* Maven 3.3.x
* Docker host or Docker machine

### Building and executing application from command line ###

```
mvn clean package
java -jar target/registry.jar
or
java -Dspring.profiles.active=standalone -jar target/registry.jar
or
java -Dspring.profiles.active=standalone -DappPort=8001 -jar target/registry.jar
or multiple instances:
java -Dspring.profiles.active=docker -DhostName=localhost -DappPort=8001 -DdataCenter=local-dev -Denvironment=dev -DpeerUrls=http://localhost:8001/eureka/,http://localhost:8002/eureka/ -jar target/registry.jar
java -Dspring.profiles.active=docker -DhostName=localhost -DappPort=8002 -DdataCenter=local-dev -Denvironment=dev -DpeerUrls=http://localhost:8001/eureka/,http://localhost:8002/eureka/ -jar target/registry.jar
```

Open http://localhost:8001 or http://localhost:8002 in a browser

### How do I get set up using Docker? ###

```
sudo docker pull raziem/registry
```

Multiple containers:
```
sudo docker run -idt -p 8001:8001 -e appPort=8001 -e spring.profiles.active=docker -e hostName=localhost -e dataCenter=local-dev -e environment=dev -e peerUrls=http://localhost:8001/eureka/,http://localhost:8002/eureka/ raziem/registry:latest
sudo docker run -idt -p 8002:8002 -e appPort=8002 -e spring.profiles.active=docker -e hostName=localhost -e dataCenter=local-dev -e environment=dev -e peerUrls=http://localhost:8001/eureka/,http://localhost:8002/eureka/ raziem/registry:latest
```

Open http://localhost:8001 or http://localhost:8002 in a browser

### Who do I talk to? ###

* raziem1230@gmail.com
* https://www.linkedin.com/in/edgardo-cruz-sastre-21889941/