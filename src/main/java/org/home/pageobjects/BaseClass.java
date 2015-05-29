package org.home.pageobjects;

import org.openqa.selenium.WebDriver;

public class BaseClass {
    protected static WebDriver driver;
    private static final String URL = "https://www.google.com.ua";

    public BaseClass(WebDriver driver) {
        BaseClass.driver = driver;
    }

    public HomePage navigateToHomepage() {
        driver.get(URL);
        return HomePage.getHomepageInstance(driver);
    }

    public static String getUrl() {
        return URL;
    }
}
