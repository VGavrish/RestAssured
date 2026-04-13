Feature: CRUD operations for Expenses

  Scenario: Create a user, add a car, add an expense, retrieve, update, and delete the expense
    Given I create a new user
    And I save the session cookie
    When I retrieve the available car models
    And I create a new car with a retrieved model
    Then I create a new expense for the car
    And I retrieve the list of expenses for the car
    And I update the created expense
    And I delete the updated expense