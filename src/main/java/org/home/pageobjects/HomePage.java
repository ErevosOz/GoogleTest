package org.home.pageobjects;

import org.home.locators.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseClass {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ResultPage doSearchFor(String term){
        driver.findElement(By.id(Locators.searchForm)).sendKeys(term);
        driver.findElement(By.className(Locators.searchButton)).click();
        return new ResultPage(driver);
    }

    public void hideLogo() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='hidden'", driver.findElement(By.id(Locators.logo)));
    }
}
