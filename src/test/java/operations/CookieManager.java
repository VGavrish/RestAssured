package operations;

import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

public class CookieManager {
    private Cookies cookies;
//    public void setCookies(Cookies cookies) {
//        this.cookies = cookies;
//    }

    public Cookie getSessionCookieFromResponse(Response response) {
        return response.getDetailedCookie("sid");
    }
}
