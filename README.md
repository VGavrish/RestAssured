# RestAssured Test Automation Framework

This project is a training API automation framework built with **Java 17**, **Rest Assured**, **Cucumber**, **JUnit 5 Platform**, and **Gradle**.

It demonstrates a clean and scalable approach to API test automation using modern tools and best practices.

---

## 🚀 Tech Stack

- Java 17
- Gradle 8.x
- Rest Assured 5.4.0
- Cucumber 7.18.0
- JUnit Platform Suite 1.10.2
- Jackson 2.17.0
- Google Guice 7.0.0
- Allure Report

---

## 📌 Features

- API testing with Rest Assured
- BDD approach using Cucumber (Gherkin)
- Clean layered architecture (steps → actions → requests)
- JSON serialization/deserialization with Jackson
- Dependency Injection with Guice
- Environment-based configuration
- Allure reporting
- Gradle task execution

---

## 🧱 Project Structure

src
├── main
│ ├── java
│ │ ├── config # Configuration classes (env, DI, etc.)
│ │ ├── models # POJOs for request/response
│ │ ├── requests # API request builders
│ │ ├── actions # Business logic layer
│ │ └── utils # Helpers and utilities
│ │
│ └── resources
│ ├── application.properties
│ └── environments
│
├── test
│ ├── java
│ │ ├── stepdefinitions # Cucumber steps
│ │ ├── runners # Test runners
│ │ └── hooks # Setup/teardown
│ │
│ └── resources
│ ├── features # Gherkin feature files
│ └── testdata # Test data


---

## 🧪 Implemented Scenario

### Example: Get User

```gherkin
Feature: User API

  Scenario: Get user by ID
    Given user with id 2 exists
    When I send GET request to "/users/2"
    Then response status should be 200
    And response should contain user data

⚙️ Configuration

You can configure environments using:

src/main/resources/environments/

Example:

dev.properties
qa.properties
prod.properties

▶️ How to Run Tests
Run all tests:
./gradlew clean test
Run specific tests (by tag):
./gradlew test -Dcucumber.filter.tags="@smoke"

📊 Allure Report
Generate report:
allure generate build/allure-results --clean -o allure-report
Open report:
allure serve build/allure-results

🧩 Architecture Overview
Feature → Step Definitions → Actions → Requests → API
Steps – describe behavior (Cucumber)
Actions – business logic
Requests – API layer (Rest Assured)
Models – request/response objects

📦 Example Request
given()
    .baseUri(BASE_URL)
    .pathParam("id", 2)
.when()
    .get("/users/{id}")
.then()
    .statusCode(200);
💡 Best Practices Used
Separation of concerns (clean architecture)
Reusable request builders
Centralized configuration
Dependency injection
BDD readable tests
Scalable structure

📬 Author

Vitalii Havrish
