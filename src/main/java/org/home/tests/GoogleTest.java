package org.home.tests;

import org.home.locators.Locators;
import org.home.pageobjects.HomePage;
import org.home.pageobjects.ResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class GoogleTest {

    private FirefoxDriver driver;
    private final String searchTerm = "Lorem Ipsum";
    private final String url = "https://www.google.com.ua";

    @BeforeClass
    public void Setup(){
        driver = new FirefoxDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

    }

    @AfterClass
    public void Teardown(){
        driver.quit();
    }

    @Test
    public void test(){

        final HomePage homepage = new HomePage(driver);
        Reporter.log("Opened homepage");
        Assert.assertTrue(driver.findElement(By.xpath(Locators.logo)).isDisplayed());
        Reporter.log("Logo is displayed");

        final ResultPage result = homepage.doSearchFor(searchTerm);
        Reporter.log("Entered search term");
        Assert.assertTrue(driver.findElement(By.xpath(Locators.firstLink)).getText().contains(searchTerm));
        Reporter.log("First link contains search term");

        final HomePage homepage1  = result.getHomepage();
        Reporter.log("Returned to homepage");
        homepage1.hideLogo();
        Assert.assertFalse(driver.findElement(By.xpath(Locators.logo)).isDisplayed());
        Reporter.log("Logo is hidden");

    }
}
