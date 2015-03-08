package org.home.pageobjects;

import org.openqa.selenium.WebDriver;

public class BaseClass {
    protected static WebDriver driver;
    private static final String url = "https://www.google.com.ua";

    public BaseClass(WebDriver driver) {
        BaseClass.driver = driver;
    }

    public HomePage navigateToHomepage(){
        driver.get(url);
        return HomePage.getHomePage(driver);
    }

    public static String getUrl() {
        return url;
    }
}
