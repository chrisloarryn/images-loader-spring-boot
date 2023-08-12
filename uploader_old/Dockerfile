# Use the official OpenJDK base image
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file into the container
COPY build/libs/*.jar app.jar

# Expose the port that the application runs on
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "app.jar"]
