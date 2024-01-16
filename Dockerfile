FROM ubuntu:latest AS ubuntu

RUN apt-get update -y &&  \
    apt-get install openjdk-17-jdk -y && \
    apt-get install maven -y

COPY . .

RUN echo "Current directory: $(pwd)" && ls -al
RUN mvn clean install -X
RUN echo "Contents after Maven build: $(pwd)" && ls -al

FROM openjdk:17 AS java

EXPOSE 8080

RUN mkdir -p app

COPY --from=ubuntu /target/CRUD-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java", "-jar", "/app/CRUD-0.0.1-SNAPSHOT.jar"]