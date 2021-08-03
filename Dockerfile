FROM openjdk:11.0.11-jdk
COPY target/construcao-0.0.1-SNAPSHOT.jar construcao-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java","-jar","/construcao-0.0.1-SNAPSHOT.jar"]
