FROM ubuntu:latest AS ubuntu

RUN apt-get update -y && \
    apt-get install openjdk-17-jdk -y

COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk AS java

EXPOSE 8080

RUN mkdir -p /app

COPY --from=ubuntu /app/CRUD/target/CRUD-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java", "-jar", "/app/CRUD-0.0.1-SNAPSHOT.jar"]