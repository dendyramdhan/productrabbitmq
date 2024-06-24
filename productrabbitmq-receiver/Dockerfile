# Use an official Maven image to build the application
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the parent pom.xml and module poms
COPY pom.xml .
COPY productrabbitmq-common/pom.xml productrabbitmq-common/
COPY productrabbitmq-sender/pom.xml productrabbitmq-sender/
COPY productrabbitmq-receiver/pom.xml productrabbitmq-receiver/

# Copy all modules source code
COPY productrabbitmq-common/src productrabbitmq-common/src
COPY productrabbitmq-receiver/src productrabbitmq-receiver/src
COPY productrabbitmq-sender/src productrabbitmq-sender/src

# Build and install the common module first
RUN mvn clean install -pl productrabbitmq-common -am -DskipTests

# Build the receiver module
RUN mvn clean package -DskipTests -pl productrabbitmq-receiver --debug

# Use an official OpenJDK image to run the application
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/productrabbitmq-receiver/target/productrabbitmq-receiver-0.0.1-SNAPSHOT.jar app.jar

# Specify the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]