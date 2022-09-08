FROM openjdk:8-jdk-alpine
COPY ./target/project_postgres-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "/project_postgres-0.0.1-SNAPSHOT.jar"]