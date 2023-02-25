package org.example.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties prop = null;

    public static Properties loadProperty() {
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(new File("src/test/resources/config.properties"));
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }

    public static String getPropertyValue(String key) {
        if (prop == null) {
            loadProperty();
        }
        return prop.getProperty(key);
    }
}
