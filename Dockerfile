# Use an OpenJDK image with Maven installed
FROM maven:3.8.6-openjdk-17-slim AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and the source code
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Create a new image for running the application
FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY --from=build /app/target/my-spring-boot-app-0.0.1-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
