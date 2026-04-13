package operations.cars;

import entities.InputCarWrapper;
import io.restassured.response.Response;
import operations.BaseApi;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static utils.JsonUtils.convertToJson;

public class CarsOperations extends BaseApi {
    public Response getCarModels() {
        return applySessionCookie(given())
                .when()
                .get("/api/cars/models");
    }

    public Response createNewCar(Object body) {
        return applySessionCookie(given())
                .contentType(JSON)
                .body(convertToJson(body))
                .when()
                .post("/api/cars");
    }

    public Response updateCar(Object body, InputCarWrapper inputCarWrapper) {
        return applySessionCookie(given())
                .contentType(JSON)
                .body(convertToJson(body))
                .pathParam("carId", inputCarWrapper.data().id())
                .when()
                .put("/api/cars/{carId}");
    }

    public Response deleteCar(InputCarWrapper inputCarWrapper) {
        return applySessionCookie(given())
                .contentType(JSON)
                .pathParam("carId", inputCarWrapper.data().id())
                .when()
                .delete("/api/cars/{carId}");
    }
}
