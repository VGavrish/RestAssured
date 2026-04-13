package operations.auth;

import io.restassured.response.Response;
import operations.BaseApi;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static utils.JsonUtils.convertToJson;

public class AuthOperations extends BaseApi {
    public Response signUpPostRequest(Object body) {
        return given()
                .contentType(JSON)
                .body(convertToJson(body))
                .when()
                .post("/api/auth/signup");
    }
}
