# RestAssured Test Automation Framework

This project is a training API automation framework built with **Java 17**, **Rest Assured**, **Cucumber**, **JUnit 5 Platform**, and **Gradle**.

It demonstrates a simple but structured approach to API test automation using:
- request/response handling with Rest Assured
- BDD scenarios with Cucumber
- step definitions and operations layers
- JSON serialization/deserialization with Jackson
- dependency injection with Guice
- Gradle tasks for running tests in different environments

## Tech Stack

- Java 17
- Gradle 8.x
- Rest Assured 5.4.0
- Cucumber 7.18.0
- JUnit Platform Suite 1.10.2
- Jackson 2.17.0
- Guice 7.0.0

## Project Structure

```text
.
├── build.gradle
├── gradlew
├── gradlew.bat
├── settings.gradle.kts
├── src
│   ├── main
│   └── test
│       ├── java
│       │   ├── config
│       │   ├── entities
│       │   ├── factories
│       │   ├── hooks
│       │   ├── operations
│       │   ├── runners
│       │   ├── setup
│       │   ├── stepdefinitions
│       │   └── utils
│       └── resources
│           └── features
```text

Test Scenario

The project currently contains a full CRUD scenario for car-related API operations:

set base URI
register a new user
extract session cookie
get car models
create a new car
update car mileage
delete the created car

The main feature file is:
src/test/resources/features/restAssuredCrud.feature

Framework Design
Step Definitions

Cucumber step definitions contain the scenario flow and assertions.

Operations Layer

API requests are separated into operation classes, for example:

AuthOperations
CarsOperations

This keeps test logic cleaner and makes the framework easier to extend.

Base API

A shared base API class is used to keep common request logic, including session cookie handling.

Utilities

Utility classes are used for:

JSON serialization/deserialization
constants
test data helpers
How to Run Tests
Run QA tests
./gradlew qaTest

Run DEV tests
./gradlew devTest

Run default test task
./gradlew test

Runner
The framework uses a JUnit Platform Cucumber runner located in:
src/test/java/runners/TestRunner.java

It is configured to:

scan feature files from features
use step definitions from stepdefinitions
Environment

The framework is prepared for environment-based execution through Gradle system properties:

qa
dev
Current Status

At this stage, the project includes:

working Cucumber + Rest Assured integration
a complete CRUD scenario for cars
structured step definitions and operations
Gradle-based execution
Next Improvements

Possible next steps:

add Jenkins pipeline support with Jenkinsfile
publish reports in CI
add Allure integration for build reports
separate test data into JSON files
extend the framework with additional API modules
add GraphQL subproject support
Author

Vitalii Havrish
