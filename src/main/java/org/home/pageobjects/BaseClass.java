package org.home.pageobjects;

import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
    //TODO user generic classes/interfaces - WebDriver instead of FirefoxDriver
    protected FirefoxDriver driver;
    private final String url = "https://www.google.com.ua";

    //TODO user generic classes/interfaces - WebDriver instead of FirefoxDriver
    public BaseClass(FirefoxDriver driver) {
        this.driver = driver;
    }

    //TODO name is misleading - navigatoToHomepage(), goToHomepage() etc
    public HomePage getHomepage(){
        driver.get(url);
        return new HomePage(driver);
    }
}
