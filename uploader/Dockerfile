# Use the official Spring Boot base image
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# build the application
# RUN ./gradlew build

# Copy the JAR file into the container
COPY target/your-application-name.jar app.jar

# Expose the port that the application runs on
EXPOSE 8080

# Define the entry point for the container
ENTRYPOINT ["java", "-jar", "app.jar"]
