package operations;

import io.restassured.specification.RequestSpecification;

public abstract class BaseApi {
    protected String sessionCookie;

    public void setSessionCookie(String sessionCookie) {
        this.sessionCookie = sessionCookie;
    }

    protected RequestSpecification applySessionCookie(RequestSpecification request) {
        if (sessionCookie != null) {
            return request.cookie("sid", sessionCookie);
        }
        return request;
    }
}
