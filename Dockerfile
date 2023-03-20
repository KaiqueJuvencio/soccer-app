FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/*.war /usr/local/lib/*.war
ENTRYPOINT ["java","-XX:MaxGCPauseMillis=500","-XX:+UseG1GC","-Xmx512m","-jar","/usr/local/lib/*.war"]
