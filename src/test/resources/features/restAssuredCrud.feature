Feature: RestAssured CRUD operations

  Background:
    Given the base URI is "https://qauto.forstudy.space"

  Scenario: Full CRUD flow for cars
    Given a new user
    When I send a POST request to "/api/auth/signup" with the user data
    Then the response status code should be 201
    And I extract the session cookie

    When I send a GET request to "/api/cars/models"
    Then the response status code should be 200
    And I extract the car models

    Given a car model from the list
    When I send a POST request to "/api/cars" with the car data
    Then the response status code should be 201
    And I extract the created car information

    Given an existing car with updated mileage
    When I send a PUT request to "/api/cars/{carId}" with updated car data
    Then the response status code should be 200
    And the response should contain the updated mileage

    When I send a DELETE request to "/api/cars/{carId}"
    Then the response status code should be 200
    And the response should contain the deleted car ID