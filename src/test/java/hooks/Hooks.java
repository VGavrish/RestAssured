package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import utils.ConfigLoader;

public class Hooks {

    @Before
    public void setUp() {
        RestAssured.baseURI = ConfigLoader.getProperty("api.url");
    }

    @After
    public void tearDown() {
        System.out.println("Cleanup after scenario");
    }
}
