package org.example.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestStep {

    public static WebDriver driver = null;

    @Given("Open browser and close")
    public void openBrowserAndClose() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
    }
}
