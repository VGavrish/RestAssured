package stepdefinitions;

import com.google.inject.Inject;
import entities.*;
import io.restassured.response.Response;
import operations.CookieManager;
import operations.auth.AuthOperations;
import operations.cars.CarsOperations;
import setup.TestSetup;

public abstract class BaseStepdefs {
    protected User user;
    protected Response response;
    protected CarModels carModels;
    protected InputCarWrapper inputCarWrapper;
    protected CarModel carModel;
    protected OutputCar outputCar;

    @Inject
    protected CookieManager cookieManager;

    @Inject
    protected AuthOperations authOperations;

    @Inject
    protected CarsOperations carsOperations;

    public BaseStepdefs() {
        TestSetup.getInjector().injectMembers(this);
    }

    protected void verifyStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }
}
