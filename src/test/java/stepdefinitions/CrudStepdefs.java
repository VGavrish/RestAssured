package stepdefinitions;

import entities.CarModels;
import entities.InputCar;
import entities.InputCarWrapper;
import entities.OutputCar;
import factories.UserFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import io.restassured.http.Cookie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CrudStepdefs extends BaseStepdefs {
    private InputCar createdCar;
    private InputCar updatedCar;
    private OutputCar carForCreate;
    private OutputCar carForUpdate;

    @Given("the base URI is {string}")
    public void theBaseUriIs(String baseUri) {
        RestAssured.baseURI = baseUri;
    }

    @Given("a new user")
    public void aNewUser() {
        user = UserFactory.createUser();
    }

    @When("I send a POST request to {string} with the user data")
    public void iSendAPostRequestToWithTheUserData(String endpoint) {
        response = authOperations.signUpPostRequest(user);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        verifyStatusCode(statusCode);
    }

    @And("I extract the session cookie")
    public void iExtractTheSessionCookie() {
        Cookie sessionCookie = cookieManager.getSessionCookieFromResponse(response);
        assertNotNull(sessionCookie, "Session cookie is null");

        carsOperations.setSessionCookie(sessionCookie.getValue());
    }

    @When("I send a GET request to {string}")
    public void iSendAGetRequestTo(String endpoint) {
        response = carsOperations.getCarModels();
    }

    @And("I extract the car models")
    public void iExtractTheCarModels() {
        carModels = response.as(CarModels.class);
        assertNotNull(carModels, "Car models response is null");
        assertNotNull(carModels.data(), "Car models data is null");
    }

    @Given("a car model from the list")
    public void aCarModelFromTheList() {
        carModel = carModels.data().get(0);
        carForCreate = new OutputCar(carModel.carBrandId(), carModel.id(), 0);
    }

    @When("I send a POST request to {string} with the car data")
    public void iSendAPostRequestToWithTheCarData(String endpoint) {
        response = carsOperations.createNewCar(carForCreate);
    }

    @And("I extract the created car information")
    public void iExtractTheCreatedCarInformation() {
        inputCarWrapper = response.as(InputCarWrapper.class);
        assertNotNull(inputCarWrapper, "Created car wrapper is null");
        assertNotNull(inputCarWrapper.data(), "Created car data is null");

        createdCar = inputCarWrapper.data();
    }

    @Given("an existing car with updated mileage")
    public void anExistingCarWithUpdatedMileage() {
        assertNotNull(createdCar, "Created car is null");

        carForUpdate = new OutputCar(
                createdCar.carBrandId(),
                createdCar.carModelId(),
                createdCar.mileage() + 100
        );
    }

    @When("I send a PUT request to {string} with updated car data")
    public void iSendAPutRequestToWithUpdatedCarData(String endpoint) {
        response = carsOperations.updateCar(carForUpdate, inputCarWrapper);
    }

    @And("the response should contain the updated mileage")
    public void theResponseShouldContainTheUpdatedMileage() {
        InputCarWrapper updatedWrapper = response.as(InputCarWrapper.class);
        assertNotNull(updatedWrapper, "Updated car wrapper is null");
        assertNotNull(updatedWrapper.data(), "Updated car data is null");

        updatedCar = updatedWrapper.data();
        assertEquals(carForUpdate.mileage(), updatedCar.mileage(), "Mileage was not updated");
    }

    @When("I send a DELETE request to {string}")
    public void iSendADeleteRequestTo(String endpoint) {
        response = carsOperations.deleteCar(inputCarWrapper);
    }

    @And("the response should contain the deleted car ID")
    public void theResponseShouldContainTheDeletedCarId() {
        Integer deletedCarId = response.jsonPath().getInt("data.carId");
        assertNotNull(deletedCarId, "Deleted car ID is null");
        assertEquals(createdCar.id(), deletedCarId, "Deleted car ID is incorrect");
    }
}
