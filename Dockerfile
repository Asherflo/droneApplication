FROM openjdk:17-jdk-alpine
WORKDIR /app
EXPOSE 8080
COPY target/drone-0.0.1-SNAPSHOT.jar /app/drone.jar
ENTRYPOINT ["java", "-jar", "/app/drone.jar"]