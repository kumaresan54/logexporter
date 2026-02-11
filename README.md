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

## Getting Started

### Prerequisites
- Java 17+
- Gradle (wrapper included)

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
- Easily export logs to Datadog for error analysis and observability.

## Configuration
- **Database:** Uses H2 in-memory DB for error simulation.
- **Logback:** Configured in `logback-spring.xml` for JSON output.
- **Swagger:** Enabled via `springdoc-openapi-starter-webmvc-ui` dependency.

## License
This project is licensed under the Apache License 2.0.

---
For more details, see the source code and Swagger UI.
