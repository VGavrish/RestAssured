Feature: Auth and cars

  Scenario: User registers and gets car models
    Given user registers in the system
    Then the response status code should be 201
    When user gets car models and check status code