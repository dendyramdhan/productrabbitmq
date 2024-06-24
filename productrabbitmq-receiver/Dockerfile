# Use the official image as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the build jar from target directory to the working directory in the container
COPY target/productrabbitmq-receiver-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which the app runs
EXPOSE 8082

# Command to run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
