# Use OpenJDK 17 as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/*.jar app.jar

# Expose the port (optional but good practice)
EXPOSE 8080

# Command to run your Spring Boot app
CMD ["java", "-jar", "app.jar"]
