# Technical Design  for RPN calculator

# 1. Description

This is a simple RPN calculator that support basic Mathematical operations of addition, subtraction
division, multiplication and square root. It is a web based solution able to
collect user input from a web form and deliver appropriate output to the user interface.

## 2. Environment Model

RPN Calculator is based on clean architecture to achieve louse coupling among the components
as well as easy extension of the calculator capabilities and operations.

## 3. Technology

### Chosen Technology

The RPN Calculator is developed using the following technologies

- [Springboot](https://spring.io/projects/spring-boot) Version 2.7.3 as the application framework
- [Java](https://www.java.com/en/) Version 17 as the application programming language.
- The backing data structure for the operands is java Deque because of asynchronous nature compare to stack in java that
  is synchronised
- [Clean architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) is the chosen
  architecture

### Reason for Technology Decision

**Springboot**: It is a matured web framework with dependency injection management and version control.
It provides:

- the possibility for writing web based application and provides necessary test APIs for both unit and integration tests
- dependency injection framework
- a wide range of supported plugins including best web, data, messaging, cloud and security open source projects
- regular security updates.

**Java**: Java is a high-level, class-based, object-oriented programming language that is designed to have as few
implementation dependencies as possible.
It provides:

- effective data structures for writing algorithm and putting data in memory
- object-oriented programming paradigm as well as functional interface for writing comprehensive algorithms
- robust and matured libraries for developing different kind of applications

**Clean architecture**: It is an architecture that provides separation of concerns and loose coupling among application
components
It produces systems that are:

- independent of frameworks
- independent of UI or presentation
- Business are testable without the need for database, UI, Web server and other external agency.

### 3rd Party Dependencies & Licenses

The application does not integrate with third-party dependencies.

## 4. Naming Conventions

All package names correspond java package naming conventions, base package name is:

```
com.test.rpn.reversepolishcalculator

```

## 5. Component Model

The RPN Calculator follows the clean code specifications, which composes of the following layers:

- Service Layer
    - The `RPN Service class` component contains calculate method that provides interface for
      interacting the RPN calculator business logic.
- Business Layer (Use Cases)
    - Includes the calculator usecase for evaluating the calculator notation.
    - Includes the port that contains the interfaces needed to perform the business logic
- Adapter Layer
    - The components in this layer provide pluggable implementations of interfaces defined in the
      use cases layers. They allow easy replacement of technologies which are dependencies for the
      Calculator.
    - It contains the controller which is the entry point to the backend services.
- Domain Layer
    - This layer contains the domain objects and logics needed for the calculator to operate.
- Web Layer
    - This layer contains the thumeleaf web templates for interacting with the calculator user.

## 6. Components Description

`RpnController`component receives calls from `thymeleaf` web client applications and uses
the `CalculatorUseCase` component in the business layer to retrieve the result of the calculation
from the interface implementation via `OperationImpl` component in the adapter layer. The use case
later aggregate the retrieved information into a single interface to be returned to the
web clients application.

#### Package Naming

```
com.test.rpn.reversepolishcalculator

```

## 7. Configuration

The overall configuration of the microservice is always located in a file
called `application.properties` under
`src/main/resources`

The configuration is based on the conventional configuration provided by springboot.

## 14. Technical limitations and Considerations

- When interacting with the application the User interface can be improved on to take multiple calculations
- Calculation precision is limited to java double precision
- The application considers user is familiar with RPN notation, more information could be displayed to the user to learn
  more about RPN

## 15. Outstanding Issues

- Improve user interface color theme

