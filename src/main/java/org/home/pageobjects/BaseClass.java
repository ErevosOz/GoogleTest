package org.home.pageobjects;

import org.openqa.selenium.WebDriver;

public class BaseClass {
    protected WebDriver driver;
    private static final String url = "https://www.google.com.ua";

    public BaseClass(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage navigateToHomepage(){
        driver.get(url);
        return new HomePage(driver);
    }

    public static String getUrl() {
        return url;
    }
}
