# Scala Interview Exercise

A minimal http4s application for live coding interviews.

## Prerequisites

- JDK 11+ 
- sbt 1.9+

## Quick Start

```bash
# Start the server
sbt run

# Test the existing endpoint
curl http://localhost:8080/health
curl http://localhost:8080/user/1
```

## Project Structure

```
src/main/scala/interview/
├── Main.scala                  # Server entry point
├── Models.scala                # Data models (User, Post)
├── JsonPlaceholderClient.scala # HTTP client for JSONPlaceholder API
└── Routes.scala                # HTTP routes
```

## The Task

See [TASK.md](./TASK.md) for the interview exercise.
