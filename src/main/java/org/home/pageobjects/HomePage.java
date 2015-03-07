package org.home.pageobjects;

import org.home.locators.*;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomePage extends BaseClass {
    //TODO user generic classes/interfaces - WebDriver instead of FirefoxDriver
    public HomePage(FirefoxDriver driver) {
        super(driver);
    }

    public ResultPage doSearchFor(String term){
        driver.findElement(By.xpath(Locators.searchForm)).sendKeys(term);
        driver.findElement(By.xpath(Locators.searchButton)).click();
        return new ResultPage(driver);
    }

    public void hideLogo() {
        driver.executeScript("arguments[0].style.visibility='hidden'", driver.findElement(By.xpath(Locators.logo)));
    }
}
