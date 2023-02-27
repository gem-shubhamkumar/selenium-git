package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.locator.*;
import org.example.utils.ConfigReader;

import java.time.Duration;

import static org.example.steps.Hooks.driver;
import static org.junit.Assert.assertEquals;

public class ForgetPassword {

    @When("^User clicks on Forget your password link$")
    public void clicksOnForgetPassword() {

        driver.findElement(ForgetPasswordLocator.linkForgetPassword).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Then("^The user enters \"(.*?)\" to identify your account for password reset$")
    public void enterUsernameForResetPassword(String username) {
        driver.findElement(LoginLocator.inputUsername).sendKeys(username);
    }

    @Then("^User clicks on reset password button$")
    public void clicksOnResetPasswordButton() {
        driver.findElement(ForgetPasswordLocator.buttonResetPassword).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @And("^User verifies reset password links has been successfully sent$")
    public void verifySuccessMessage() {
        String message = driver.findElement(ForgetPasswordLocator.textSentSuccessfully).getText();
        assertEquals(ConfigReader.getPropertyValue("passwordResetVerifyMsg"), message);
    }
}