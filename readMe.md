# CML Programming Assignment - Backend Documentation

## Introduction
This document provides a comprehensive guide to setting up, running, and maintaining the backend of the 'cml programming assignment' project. The backend is build using Java, Spring Boot, and  Maven.

## Prerequisites
Ensure that the following are installed on your machine:
- JDK 21
- Apache Maven 3.8.4 or higher
- Docker and Docker Compose
- PostgreSQL

## Setup
Clone the Repository
```git clone "https://github.com/akashTharuka/cml-test-server.git"  ```
Navigate to the project directory
```cd cml-test-server```

## Configure Environment Variables
Ensure the following environment variables are set in your IDE or in your system:
- DB_URL
- DB_USERNAME
- DB_PASSWORD

## Database Setup
For local development, you can set up the PostgreSQL database using pgAdmin4 or any other PostgreSQL client:
- Create a new database named 'cml'
- Set the username to 'postgres' and password to 'postgres'

## Running the Application

### Using Maven
To run the application locally:
```mvn spring-boot:run```

### Using Docker
To run the application using Docker:
```docker-compose up```

## Configuration
The application uses environment variable for configuration. These can be set in the application.properties file or passed as environment variables.

**application.properties**
```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

## Building and Testing
To build the application:
```mvn clean install```

To run the tests:
```mvn test```

