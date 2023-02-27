package org.example.locator;

import org.openqa.selenium.By;

public class LoginLocator {
    public static By inputUsername = By.xpath("//input[@name='username']");
    public static By inputPassword = By.xpath("//input[@name='password']");
    public static By buttonLogin = By.xpath("//button[contains(@class,'login')]");
    public static By headerPage = By.xpath("//div[@class='oxd-topbar-header-title']//h6");

    public static By errorMessage(String field)

    {

      return   By.xpath("//label[text()='"+field+"']/../..//span");
    }
}
