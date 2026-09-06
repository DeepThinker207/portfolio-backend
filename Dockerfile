# Stage 1: Build the application
FROM amazoncorretto:25 AS builder
WORKDIR /app

# Copy the entire project into the container
COPY . .

# Give execution permission to the Maven wrapper and build the project
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Stage 2: Run the application
FROM amazoncorretto:25
WORKDIR /app

# Copy only the built JAR from the builder stage
COPY --from=builder /app/target/portfolio-0.0.1-SNAPSHOT.jar portfolio-app.jar

# Expose the port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "portfolio-app.jar"]