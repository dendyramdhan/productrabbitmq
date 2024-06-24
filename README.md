
# Product RabbitMQ

This repository contains a RabbitMQ sender and receiver application built with Spring Boot. The sender application sends messages to RabbitMQ, while the receiver application listens for messages and processes them.

## Prerequisites

- Docker
- Docker Compose
- Java 17 or higher
- Maven 3.6.0 or higher

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/dendyramdhan/productrabbitmq.git
cd productrabbitmq
```

### Build the Projects

Navigate to the root directory of each application (`productrabbitmq-sender` and `productrabbitmq-receiver`) and build the JAR files using Maven.

```bash
cd productrabbitmq-sender
mvn clean install
cd ..

cd productrabbitmq-receiver
mvn clean install
cd ..
```

### Configure Application Properties

Update the `application.properties` files in both `sender` and `receiver` applications to match your RabbitMQ setup. By default, they are located in:

- `productrabbitmq-sender/src/main/resources/application.properties`
- `productrabbitmq-receiver/src/main/resources/application.properties`

### Running the Applications with Docker Compose

A `docker-compose.yml` file is provided to set up and run the applications along with RabbitMQ.

### Running Docker Compose

Navigate to the directory containing the `docker-compose.yml` file and run the following command:

```bash
docker-compose up -d --build
```

This command will start RabbitMQ, the sender application, and the receiver application in separate containers.

## Project Structure

### Sender Application (`productrabbitmq-sender`)

- `src/main/java/com/dendyramdhan/productrabbitmq/sender`
  - `config`: Contains RabbitMQ configuration files
  - `controller`: Contains REST controllers
  - `entity`: Contains entity classes
  - `service`: Contains business logic

### Receiver Application (`productrabbitmq-receiver`)

- `src/main/java/com/dendyramdhan/productrabbitmq/receiver`
  - `config`: Contains RabbitMQ configuration files
  - `controller`: Contains REST controllers
  - `entity`: Contains entity classes
  - `service`: Contains business logic

## Usage

- The sender application sends messages to RabbitMQ.
- The receiver application listens for messages on the specified RabbitMQ queue and processes them.

## Contributing

Feel free to open issues or submit pull requests with improvements.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
