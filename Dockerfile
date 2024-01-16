FROM ubuntu:latest AS ubuntu

RUN apt-get update -y ; \
    apt-get install openjdk-17-jdk -y

RUN mdkir -p /app

COPY . /app

RUN apt-get install maven -y

RUN cd /app/CRUD;  \
    mvn clean install

FROM openjdk AS java

EXPOSE 8080

RUN mdkir -p /app

COPY --from:ubuntu /target/CRUD-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java", "-jar" , "/app/CRUD/CRUD-0.0.1-SNAPSHOT.jar"]



