package org.home.pageobjects;

import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

    protected FirefoxDriver driver;
    private final String url = "https://www.google.com.ua";

    public BaseClass(FirefoxDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomepage(){
        driver.get(url);
        return new HomePage(driver);
    }
}
