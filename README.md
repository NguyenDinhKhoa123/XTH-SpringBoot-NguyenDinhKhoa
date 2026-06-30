# XTH Spring Boot Project

## Technology

- Java 17
- Spring Boot 3.3.5
- Spring Web
- Spring Data JPA
- Spring Validation
- MySQL / H2
- Maven
- Docker

## Features

- REST API for products
- Controller - Service - Repository pattern
- DTO and validation
- Global exception handling
- Pagination
- Logging with SLF4J
- Spring profiles
- Unit testing

## Requirements

- Java 17+
- Maven 3.9+
- Docker (optional for containerization)

## Installation

```bash
./mvnw clean package
```

## Run Project

```bash
java -jar target/xth-0.0.1-SNAPSHOT.jar
```

Or with profile:

```bash
java -jar target/xth-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
```

## API Endpoints

### Product API

- GET /api/products
- GET /api/products/{id}
- POST /api/products
- DELETE /api/products/{id}

### Database-backed Product API

- GET /db/products
- GET /db/products/page
- POST /db/products

## Docker

Build image:

```bash
docker build -t xth-app .
```

Run container:

```bash
docker run -p 8081:8081 xth-app
```

## Author

Nguyen Dinh Khoa
