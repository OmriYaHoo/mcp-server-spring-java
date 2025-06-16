# MCP Server - Spring Boot Java

A Model Context Protocol (MCP) server implementation using Spring Boot and Spring AI.

## Overview

This project implements a Model Context Protocol server using Spring Boot and Spring AI framework. It enables AI models to understand and process contextual information, making them more effective for various applications.

## Prerequisites

- JDK 21
- Maven 3.9.9+
- IDE with Spring Boot support (IntelliJ IDEA recommended)

## Technologies

- Spring Boot 3.4.3
- Spring AI 1.0.0-M6
- Model Context Protocol SDK 0.7.0
- Lombok

## Getting Started

### Installation

1. Clone the repository

```bash
git clone https://github.com/yourusername/mcp-spring-java.git
cd mcp-spring-java
```

2. Build the project

```bash
mvn clean package
```

3. Run the application

```bash
java -jar target/mcp-spring-java-0.0.1-SNAPSHOT.jar
```

The server will start on http://localhost:8080

## Configuration

The MCP server is configured in `application.yml`:

- Server runs on port 8090
- Server name: my-dummy-users-server
- Synchronous communication mode
- Supports STDIO transport for terminal-based communication
- Exposes `/mcp/message` endpoint for SSE communication

## Available Tools

The server exposes the following user management tools:

- `getGraphQLSchema` - Get GraphQL schema
- `executeGraphQLQuery` - Execute a GraphQL query
