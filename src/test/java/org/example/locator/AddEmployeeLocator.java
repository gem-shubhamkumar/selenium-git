package org.example.locator;

import org.openqa.selenium.By;

public class AddEmployeeLocator {

    public static By menuHomePage(String option) {
        return By.xpath("//a[@class='oxd-main-menu-item']//span[text()='" + option + "']");
    }

    public static By tabsPIM(String tab) {
        return By.xpath("//*[@class='oxd-topbar-body-nav-tab-item' and contains(text(),'"
                + tab + "')]");
    }

    public static By tabsActivePIM(String tab) {
        return By.xpath("//*[contains(@class,'oxd-topbar-body-nav-tab') and contains(text(),'" +
                tab + "')]/..");

    }

    public static By inputFirstName = By.xpath("//input[@name='firstName']");
    public static By inputMiddleName = By.xpath("//input[@name='middleName']");
    public static By inputLastName = By.xpath("//input[@name='lastName']");

}
