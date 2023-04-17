# readingisgood
Online Books App

This application allows users to manage their favourite books.

Users are able to add, update, remove and fetch details of the orders.

##Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

## Prerequisites
For building and running the application you need:
- [OpenJDK 11](https://adoptopenjdk.net/?variant=openjdk11&jvmVariant=hotspot)
- [Maven 3.6](https://maven.apache.org)
- Mongodb Server

Or simply run the application with Docker.


## Run the Application Locally
Run the application on terminal as follows:
```
java -Dserver.port=9090 -jar target/demo-0.0.1-SNAPSHOT.jar
```
Or run the application with your preferred IDE, port must be added in VM options:
```
-Dserver.port=9090
```
Local profile will be used if you run the application without Docker.

``
spring.profiles.active=local
``

## Run the Application With Docker
Start in detached mode:
```
docker-compose up -d
```

Follow the application log:
```
docker logs -f demo-api_service_1
```

Stop:
```
docker-compose down
```

## Swagger UI
Swagger UI is accessible at http://localhost:9090/swagger-ui/index.html#/

##Postman Collections
You can find my postman collections under the resources->postman folder. You can easily import and test endpoints.
