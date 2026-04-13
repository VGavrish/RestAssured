package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static Properties properties = new Properties();

    static {
        String env = System.getProperty("env", "qa");
        String propertiesFile = env + ".properties";

        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(propertiesFile)) {
            if (input == null) {
                throw new RuntimeException("Sorry enable to find " + propertiesFile);
            }
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Failed to load properties file: " + propertiesFile, ex);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
