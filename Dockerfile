# Use a base image with JDK
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY ./backend/demox/target/deomox.jar /app/deomox.jar

# Expose the Spring Boot port
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "deomox.jar"]
