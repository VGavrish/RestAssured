package stepdefinitions;

import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

public class CookiesStepdefs extends BaseStepdefs {
    public CookiesStepdefs() {
        super();
    }

    public void setSessionCookie(Cookie sessionCookie) {
        carsOperations.setSessionCookie(sessionCookie.getValue());
    }

    public Cookie getSessionCookieFromResponse(Response response) {
        return cookieManager.getSessionCookieFromResponse(response);
    }
}
