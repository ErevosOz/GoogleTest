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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class GoogleTest {

    private WebDriver driver;

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

    @DataProvider(name = "searchTerms")
    public Object[][] searchTerms(){
        final String searchDataFilePath = "src/searchData.txt";
        File searchData = new File(searchDataFilePath);
        String line;
        int numOfLines = 0;
        Object[][] data = null;

        try (FileReader fileReader = new FileReader(searchData);
             BufferedReader bufferedReader = new BufferedReader(fileReader)){

            while ((line = bufferedReader.readLine()) != null){
                if (!line.isEmpty()){
                    numOfLines++;
                }
            }

            data = new Object[numOfLines][1];
            numOfLines = 0;

            BufferedReader newBufferedReader = new BufferedReader(new FileReader(searchData));

            while ((line = newBufferedReader.readLine()) != null){

                if (line.isEmpty()){
                    continue;
                }

                data[numOfLines][0] = line;
                numOfLines++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    @Test(dataProvider = "searchTerms")
    public void test(String searchTerm){

        HomePage homePage = HomePage.getHomePage(driver);
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
