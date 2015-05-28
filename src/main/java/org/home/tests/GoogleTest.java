package org.home.tests;

import org.home.data.DataFileReader;
import org.home.locators.Locators;
import org.home.pageobjects.BaseClass;
import org.home.pageobjects.HomePage;
import org.home.pageobjects.ResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class GoogleTest {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get(BaseClass.getUrl());
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    @DataProvider(name = "searchTerms")
    public Object[][] searchTerms() {

        final String searchDataFilePath = "src/main/java/org/home/resources/searchData.txt";

        return DataFileReader.getSearchData(searchDataFilePath);
    }

    @Test(dataProvider = "searchTerms")
    public void test(String searchTerm) {

        HomePage homePage = HomePage.getHomepageInstance(driver);
        Reporter.log("Opened homepage");
        Assert.assertTrue(driver.findElement(By.id(Locators.logo)).isDisplayed());
        Reporter.log("Logo is displayed");

        final ResultPage resultPage = homePage.doSearchFor(searchTerm);
        Reporter.log("Entered search term");
        Assert.assertTrue(driver.findElement(By.cssSelector(Locators.firstLink)).getText().contains(searchTerm));
        Reporter.log("First link contains search term");

        homePage = resultPage.navigateToHomepage();
        Reporter.log("Returned to homepage");
        homePage.hideLogo();
        Assert.assertFalse(driver.findElement(By.id(Locators.logo)).isDisplayed());
        Reporter.log("Logo is hidden");
        homePage.navigateToHomepage();

    }
}
