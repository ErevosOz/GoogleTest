package org.home.tests;

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
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class GoogleTest {

    private WebDriver driver;
    private final String searchTerm = "Lorem Ipsum";

    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get(BaseClass.getUrl());
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test(){

        HomePage homePage = new HomePage(driver);
        Reporter.log("Opened homepage");
        Assert.assertTrue(driver.findElement(By.id(Locators.logo)).isDisplayed());
        Reporter.log("Logo is displayed");

        final ResultPage resultPage = homePage.doSearchFor(searchTerm);
        Reporter.log("Entered search term");
        Assert.assertTrue(driver.findElement(By.cssSelector(Locators.firstLink)).getText().contains(searchTerm));
        Reporter.log("First link contains search term");

        homePage  = resultPage.navigateToHomepage();
        Reporter.log("Returned to homepage");
        homePage.hideLogo();
        Assert.assertFalse(driver.findElement(By.id(Locators.logo)).isDisplayed());
        Reporter.log("Logo is hidden");

    }
}
