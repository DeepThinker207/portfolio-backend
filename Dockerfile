# Base image with Java 25
FROM amazoncorretto:25

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/portfolio-0.0.1-SNAPSHOT.jar portfolio-app.jar

# Expose port 8080
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "portfolio-app.jar"]