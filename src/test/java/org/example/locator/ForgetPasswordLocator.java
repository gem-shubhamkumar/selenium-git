package org.example.locator;

import org.openqa.selenium.By;

public class ForgetPasswordLocator {
    public static By linkForgetPassword = By.xpath("//p[contains(@class,'orangehrm-login-forgot-header')]");
    public static By buttonResetPassword = By.xpath("//button[@type='submit']");
    public static By textSentSuccessfully = By.xpath("//div[@class='orangehrm-card-container']//h6");
}
