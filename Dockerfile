FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/src
COPY pom.xml /home/
RUN mvn -f /home/pom.xml clean package -DskipTests

FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080