# CoffeeMachine ☕

A fun toy project to learn Spring Core fundamentals including IoC container, dependency injection, and bean configuration.

## Project Overview

This project simulates a simple coffee machine using Spring Framework's core features. It's designed as a learning exercise for understanding:

- Spring IoC container
- Bean configuration
- Dependency injection
- Application context
- Basic testing with JUnit 5

## Prerequisites

- Java 21 (JDK 21)
- Apache Maven 3.9+
- Spring Framework 6.1.6

## Project Structure

```bash
coffeemachine/
├── src/
│ ├── main/
│ │ └── java/
│ │ └── coffeemachine/
│ │ ├── AppConfig.java # Spring configuration
│ │ ├── CoffeeMachine.java # Main coffee machine logic
│ │ └── Main.java # Entry point
│ └── test/
│ └── java/
│ └── coffeemachine/
│ └── CoffeeMachineTestSuite.java # Test cases
└── pom.xml # Maven configuration
```


## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/coffeemachine.git
   cd coffeemachine
   ```bash
2. Build the project:
   ```bash 
   mvn clean install 
   ```
3. Run the application:
    ```bash 
    mvn exec:java 
    ```

## Configuration

The Spring application context is configured in ```AppConfig.java``` using Java-based configuration.

## Testing

Run tests with:
```bash
mvn test
```

## Dependencies
- Spring Context 6.1.6
- JUnit Jupiter 5.10.2

## Future Enhancements
- Add different coffee types
- Implement money handling
- Add inventory management
- Create a simple CLI interface

## License

This project is licensed under the MIT License. 