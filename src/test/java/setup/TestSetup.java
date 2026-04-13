package setup;

import com.google.inject.Guice;
import com.google.inject.Injector;
import config.ApiTestModule;

public class TestSetup {
    private static final Injector injector = Guice.createInjector(new ApiTestModule());

    public static Injector getInjector() {
        return injector;
    }
}
