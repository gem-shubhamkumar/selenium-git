package org.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.locator.LoginLocator;
import org.example.utils.ConfigReader;
import org.junit.Assert;
import org.junit.Assume;
import org.openqa.selenium.By;

import static org.example.steps.Hooks.driver;
import static org.junit.Assert.assertEquals;

public class LoginStep {

    @Given("User login with empty password")
    public void userLoginWithEmptyPassword() {
        try{
        driver.findElement(LoginLocator.inputUsername).sendKeys(ConfigReader.getPropertyValue(
                "username"));
       driver.findElement(LoginLocator.buttonLogin).click();}
    catch (Exception e) {
        throw new RuntimeException("Fail to login with empty credentials\n" + e);
    }
    }

    @Then("Verify {string} message should be visible in field {string}")
    public void verifyMessageShouldBeVisible(String Message,String field) {
        try{
            String getMessage= driver.findElement(LoginLocator.errorMessage(field)).getText();
            assertEquals(getMessage, Message);
        }catch (Exception e){
            throw new RuntimeException("Fail to verify message should be visible\n" + e);
        }

    }


    @Given("User login with empty username")
    public void userLoginWithEmptyUsername() {
        driver.findElement(LoginLocator.inputPassword).sendKeys(ConfigReader.getPropertyValue(
                "username"));
        driver.findElement(LoginLocator.buttonLogin).click();
    }

    @Given("User login with empty username and password")
    public void userLoginWithEmptyUsernameAndPassword() {
        driver.findElement(LoginLocator.buttonLogin).click();
    }

    @Then("Verify {string} message should be visible in fields {string}")
    public void verifyMessageShouldBeVisibleInFields(String Message, String Fields) {
        String[] field = Fields.split(",");
        for (String element: field) {
            verifyMessageShouldBeVisible(Message,element);
        }
    }

    @Given("User login with invalid <password>")
    public void userLoginWithInvalidPassword() {

    }


}
