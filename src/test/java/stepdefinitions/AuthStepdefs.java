package stepdefinitions;

import factories.UserFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

public class AuthStepdefs extends BaseStepdefs {
    private final CookiesStepdefs cookiesStepdefs;

    public AuthStepdefs() {
        super();
        cookiesStepdefs = new CookiesStepdefs();
    }

    @Given("^user registers in the system$")
    public void userRegistration() {
        user = UserFactory.createUser();
        response = authOperations.signUpPostRequest(user);
        handleSessionCookie(response);
    }

    @Then("^the response status code should be (\\d+)$")
    public void checkStatusCode(int statusCode) {
        verifyStatusCode(statusCode);
    }

    private void handleSessionCookie(Response response) {
        Cookie sessionCookie = cookiesStepdefs.getSessionCookieFromResponse(response);
        if (sessionCookie != null) {
            cookiesStepdefs.setSessionCookie(sessionCookie);
        } else {
            throw new RuntimeException("Session cookie is null");
        }
    }

}
