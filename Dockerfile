FROM ubuntu:latest AS ubuntu

RUN apt-get update -y && \
    apt-get install openjdk-17-jdk maven -y

WORKDIR /CRUD

COPY . .

RUN cd CRUD && \
    mvn clean install

FROM openjdk:17 AS java

EXPOSE 8080

WORKDIR /app

COPY --from=ubuntu /app/CRUD/target/CRUD-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java", "-jar", "/app/CRUD-0.0.1-SNAPSHOT.jar"]