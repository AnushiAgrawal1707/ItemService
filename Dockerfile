FROM openjdk:8-jdk-alpine

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 5050 available to the world outside this container
EXPOSE 5050

# The application's jar file
ARG JAR_FILE=target/mykart-user-service-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} userservice.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/userservice.jar"]
