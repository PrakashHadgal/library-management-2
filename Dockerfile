FROM openjdk:17-jdk-alpine
COPY target/docker-library-management-0.0.1-SNAPSHOT.jar library-management-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/library-management-0.0.1-SNAPSHOT.jar"]