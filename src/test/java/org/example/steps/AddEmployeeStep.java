package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.locator.AddEmployeeLocator;
import org.example.locator.LoginLocator;
import org.example.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.steps.Hooks.driver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddEmployeeStep {

    @Given("User login with valid credentials")
    public void userLoginWithValidCredentials() {
        try {
            driver.findElement(LoginLocator.inputUsername).sendKeys(ConfigReader.getPropertyValue(
                    "username"));
            driver.findElement(LoginLocator.inputPassword).sendKeys(ConfigReader.getPropertyValue(
                    "password"));
            driver.findElement(LoginLocator.buttonLogin).click();
        } catch (Exception e) {
            throw new RuntimeException("Fail to login with valid credentials\n" + e);
        }
    }

    @And("User should navigate to dashboard page")
    public void userShouldNavigateToDashboardPage() {
        String expectedHeader = driver.findElement(LoginLocator.headerPage).getText();
        assertEquals(expectedHeader, ConfigReader.getPropertyValue("headerDashboard"));
    }

    @When("Click on {string} Section")
    public void clickOnSection(String option) {
        try {
            driver.findElement(AddEmployeeLocator.menuHomePage(option)).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.textToBe(LoginLocator.headerPage, "PIM"));
            String actualHeader = driver.findElement(LoginLocator.headerPage).getText();

            assertEquals("PIM", actualHeader);
        } catch (Exception e) {
            throw new RuntimeException("Fail to click on " + option + " Option\n" + e);
        }
    }

    @And("Click on {string} option")
    public void clickOnOption(String tab) {
        try {
            driver.findElement(AddEmployeeLocator.tabsPIM(tab)).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.attributeContains(AddEmployeeLocator.tabsActivePIM(tab), "class",
                    "visited"));
            String actualAttrValue = driver.findElement(AddEmployeeLocator.tabsActivePIM(tab)).getAttribute(
                    "class");

            assertTrue(actualAttrValue.contains("visited"));
        } catch (Exception e) {
            throw new RuntimeException("Fail to click on " + tab + " tab\n" + e);
        }
    }

    @Then("Enter employee details {string} {string} {string} and {string}")
    public void enterEmployeeDetailsAnd(String fName, String mName, String lName, String empId) {
        try {
            driver.findElement(AddEmployeeLocator.inputFirstName).sendKeys(fName);
            driver.findElement(AddEmployeeLocator.inputMiddleName).sendKeys(mName);
            driver.findElement(AddEmployeeLocator.inputLastName).sendKeys(lName);
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException("Fail to enter details\n" + e);
        }
    }

    @And("Click on save button")
    public void clickOnSaveButton() {
    }

    @And("Verify success notification {string}")
    public void verifySuccessNotification(String message) {
    }
}
