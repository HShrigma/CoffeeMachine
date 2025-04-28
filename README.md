# CoffeeMachine ☕

A Spring-powered coffee machine simulator demonstrating core Spring features and proper application architecture.

## Project Overview

This project implements a complete coffee ordering system with:

- Spring Dependency Injection
- Component-based architecture
- CLI interface
- Comprehensive unit testing
- Proper error handling

Key concepts demonstrated:
- Spring IoC container
- Annotation-based configuration (`@Component`, `@Autowired`)
- Java-based configuration (`@Configuration`, `@Bean`)
- Application context lifecycle
- JUnit 5 testing
- Dependency injection patterns

## Prerequisites

- Java 21 (JDK 21)
- Apache Maven 3.9+
- Spring Framework 6.1.6

## Project Structure
``` bash
coffeemachine/
├── src/
│ ├── main/
│ │ └── java/
│ │ └── coffeemachine/
│ │ ├── AppConfig.java # Spring configuration
│ │ ├── AppRunner.java # CLI interface
│ │ ├── CoffeeMachine.java # Brewing component
│ │ ├── Main.java # Entry point
│ │ ├── helpers/
│ │ │ └── OrderNameRegistry.java # Order type management
│ │ └── shoporderservice/
│ │ ├── CustomerService.java # Order handling
│ │ ├── MilkSteamer.java # Milk steaming
│ │ └── OrderService.java # Order processing
│ └── test/
│ └── java/
│ └── coffeemachine/
│ └── CoffeeMachineTestSuite.java # Test cases (10 tests)
└── pom.xml # Maven configuration
```

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/coffeemachine.git
   cd coffeemachine
   ```
2. Build the project
   ```bash
   mvn clean install
   ```
3. Run the application:
   ```bash
      mvn exec:java
   ```

## Features

- Interactive command-line interface
- Three coffee types: espresso, latte, cappuccino
- Proper milk steaming for milk-based drinks
- Comprehensive error handling
- Unit test coverage for all components

## Usage

When running, enter orders in format:

```bash
<CustomerName> <OrderType>
```

Example:
```bash
John Latte
```

## Testing

Run the complete test suite:

```bash
mvn test
```
Test coverage includes:

- Order type validation
- Order processing
- Customer service
- Error cases
- Enum conversion

## Dependencies

- Spring Context 6.1.6
- JUnit Jupiter 5.10.2

## Future Enhancements

- Payment processing
- Inventory management
- Temperature control
- Custom drink options
- Graphical interface

## License
This project is licensed under the MIT License.