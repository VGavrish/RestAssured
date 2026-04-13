package stepdefinitions;

import entities.CarModels;
import entities.InputCarWrapper;
import entities.OutputCar;
import io.cucumber.java.en.When;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

public class CarsStepdefs extends BaseStepdefs {
    @When("user gets car models and check status code")
    public void userGetsCarModels() {
        carModels = carsOperations
                .getCarModels()
                .then()
                .statusCode(SC_OK)
                .extract()
                .as(CarModels.class);
    }

    @When("user creates a new car model and check status code")
    public void userCreatesNewCarModel() {
        carModel = carModels.data().get(0);
        outputCar = new OutputCar(carModel.carBrandId(), carModel.id(), 0);
        inputCarWrapper = carsOperations
                .createNewCar(outputCar)
                .then()
                .statusCode(SC_CREATED)
                .extract()
                .as(InputCarWrapper.class);
    }

    @When("user updates a car and check status code")
    public void userUpdatesCar() {
        outputCar = new OutputCar(carModel.carBrandId(), carModel.id(), 100);
        carsOperations.updateCar(outputCar, inputCarWrapper).then().statusCode(SC_OK);
    }

    @When("user deletes a car and check status code")
    public void userDeletesCar() {
        carsOperations.deleteCar(inputCarWrapper).then().statusCode(SC_OK);
    }
}
