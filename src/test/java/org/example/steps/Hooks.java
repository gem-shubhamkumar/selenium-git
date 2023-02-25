package org.example.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.utils.Common;
import org.example.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {

    public static WebDriver driver = null;

    @Before(order = 0)
    public void loadProperties() {
        try {
            Common.prop = ConfigReader.loadProperty();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config properties.\n" + e);
        }
    }

    @Before(order = 1)
    public void setup() {
        try {
            driver = new ChromeDriver();
            driver.get(ConfigReader.getPropertyValue("baseURL"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize the driver.\n" + e);
        }
    }

    @After
    public void tearDown() {
        try {
            driver.close();
        } catch (Exception e) {
            throw new RuntimeException("Failed to close the driver.\n" + e);
        } finally {
            driver.quit();
        }
    }
}
