package config;

import com.google.inject.AbstractModule;
import operations.CookieManager;
import operations.auth.AuthOperations;
import operations.cars.CarsOperations;


public class ApiTestModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AuthOperations.class).toInstance(new AuthOperations());
        bind(CarsOperations.class).toInstance(new CarsOperations());
        bind(CookieManager.class).toInstance(new CookieManager());
    }
}
