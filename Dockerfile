# Use a base image with Maven and Java 17 installed
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the source code to the working directory
COPY . /app

# Build the application
RUN mvn clean package

# Create a new image with JRE for runtime (changed)
FROM eclipse-temurin:17-jre-focal

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the build image
COPY --from=build /app/target/tpg_soporte-0.0.1-SNAPSHOT.jar /app/tpg_soporte-0.0.1-SNAPSHOT.jar
COPY --from=build /app/resources /app/resources

# Set the command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "tpg_soporte-0.0.1-SNAPSHOT.jar"]