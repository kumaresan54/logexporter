# LogExporter Microservices Suite

This repository contains a suite of Spring Boot microservices:
- **orchestrator**: Coordinates business logic by invoking other services via HTTP.
- **customer**: Provides customer-related endpoints.
- **pricing**: Provides pricing-related endpoints.
- **vehicle**: Provides vehicle-related endpoints.

## Project Structure

```
logexporter/
├── orchestrator/
├── customer/
├── pricing/
├── vehicle/
└── run (management script)
```

## Ports
- **customer**: 8081
- **pricing**: 8082
- **vehicle**: 8083
- **orchestrator**: 8080 (default)

## Prerequisites
- Java 17+
- Gradle (wrapper included)
- Zsh shell (for run script)

## How to Start All Services
Run the following command from the root directory:

```
./run start_apps
```
- Starts orchestrator, customer, pricing, and vehicle services.
- Each service runs in its own port.
- Services are not started if already running.

## How to Stop All Services
```
./run stop_apps
```
- Stops all running Spring Boot applications.

## How to Tail Logs
```
./run tail_logs
```
- Prompts for an app name (orchestrator, customer, pricing, vehicle).
- Tails the log file for the selected app.

## Error Simulation
- Each service supports a `simulateError` flag in its endpoint.
- When enabled, the service randomly returns a business error (e.g., not found, invalid data, external failure).
- The orchestrator can pass this flag to one service randomly.

## Orchestration Flow
- The orchestrator calls customer, pricing, and vehicle services via HTTP.
- Handles errors and logs each step.
- Exception handling is centralized in the orchestrator for robust error responses.

## Build & Test
To build any service:
```
cd <service-folder>
./gradlew build
```
To run tests:
```
cd <service-folder>
./gradlew test
```

## Customization
- Ports can be changed in each service's `application.properties`.
- Add new services by updating the `APPS` array in the `run` script.

## Troubleshooting
- If you see errors about handler dispatch or dependency failures, ensure all Spring Boot and Spring Framework versions are consistent.
- Run `./gradlew clean build` in each service if you encounter build issues.

## License
MIT
