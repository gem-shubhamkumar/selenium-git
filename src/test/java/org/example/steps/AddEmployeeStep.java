package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.locator.LoginLocator;
import org.example.utils.ConfigReader;
import org.openqa.selenium.By;

import static org.example.steps.Hooks.driver;
import static org.junit.Assert.assertEquals;

public class AddEmployeeStep {

//    public static WebDriver driver = null;

    @Given("User login with valid credentials")
    public void userLoginWithValidCredentials() {
        driver.findElement(LoginLocator.inputUsername).sendKeys(ConfigReader.getPropertyValue(
                "username"));
        driver.findElement(LoginLocator.inputPassword).sendKeys(ConfigReader.getPropertyValue(
                "password"));
        driver.findElement(LoginLocator.buttonLogin).click();
    }

    @And("User should navigate to dashboard page")
    public void userShouldNavigateToDashboardPage() {
        String expectedHeader = driver.findElement(LoginLocator.headerPage).getText();
        assertEquals(expectedHeader, ConfigReader.getPropertyValue("headerDashboard"));
    }

    @When("Click on PIM Section")
    public void clickOnPIMSection() {
    }

}
