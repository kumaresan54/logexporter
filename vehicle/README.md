# LogExporter Spring Boot Project

## Overview
LogExporter is a Spring Boot application designed to simulate and log various error scenarios for observability and Datadog integration. It features:
- Multiple REST endpoints to trigger different error types (DB, API, memory, runtime, null pointer, Spring exceptions, etc.)
- JSON logging using Logback and Logstash encoder, exportable to Datadog
- Swagger/OpenAPI UI for interactive API documentation

## Features
- **Error Simulation:** Endpoints for DB, API, memory, runtime, null pointer, illegal argument, index out of bounds, Spring JPA, HTTP errors, bean creation, and more.
- **JSON Logging:** All logs are formatted in JSON for easy ingestion by Datadog.
- **Swagger UI:** Interactive API documentation available at `/swagger-ui/index.html`.
- **H2 In-Memory Database:** Used for DB error simulation.
- **Datadog Agent Integration:** Docker Compose setup for Datadog agent with log collection.

## Getting Started

### Prerequisites
- Java 17+
- Gradle (wrapper included)
- Docker (for Datadog agent)

### Build & Run
1. **Install dependencies and build:**
   ```sh
   ./gradlew build
   ```
2. **Run the application:**
   ```sh
   ./gradlew bootRun
   ```

### Access Swagger UI
- Open [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) in your browser.

## API Endpoints
- `/log` - Simulate DB error
- `/log-api` - Simulate API error
- `/log-runtime` - Simulate runtime exception
- `/log-memory` - Simulate out-of-memory error
- `/log-null` - Simulate null pointer exception
- `/log-illegal-argument` - Simulate illegal argument exception
- `/log-arithmetic` - Simulate arithmetic exception
- `/log-index-out-of-bounds` - Simulate index out of bounds exception
- `/log-http-server-error` - Simulate HTTP server error
- `/log-http-client-error` - Simulate HTTP client error
- `/log-bean-creation-error` - Simulate bean creation error
- `/log-no-such-bean-definition-error` - Simulate no such bean definition error
- `/log-random-errors?count=3` - Generate multiple random errors (default 3)

## Logging & Datadog Integration
- Logs are output in JSON format via Logback and Logstash encoder.
- Logback writes logs to `./logs/logexporter.log`.
- Datadog agent is started via Docker Compose and collects logs from `./logs/logexporter.log`.
- Datadog log configuration (`datadog/conf.d/logexporter.d/conf.yaml`):
  ```yaml
  logs:
    - type: file
      path: /logs/logexporter.log
      service: logexporter
      source: java
      encoding: utf-8
      tags:
        - env:dev
  ```
- Replace `YOUR_DATADOG_API_KEY` in `docker-compose.yml` with your actual Datadog API key.
- Make sure the `logs` directory exists and is writable by both your app and Datadog agent.

## Configuration
- **Database:** Uses H2 in-memory DB for error simulation.
- **Logback:** Configured in `logback-spring.xml` for JSON output and file logging.
- **Swagger:** Enabled via `springdoc-openapi-starter-webmvc-ui` dependency.
- **Datadog Agent:** Configured via `docker-compose.yml` and `conf.yaml` for log collection.

---
For more details, see the source code and Swagger UI.
