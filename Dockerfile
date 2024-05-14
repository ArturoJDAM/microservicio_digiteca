# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="arturo.jimenez.smr@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 12000 available to the world outside this container
EXPOSE 12000

# The application's jar file
ARG JAR_FILE=target/digiteca.jar

# Add the application's jar to the container
ADD ${JAR_FILE} digiteca.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/digiteca.jar"]
