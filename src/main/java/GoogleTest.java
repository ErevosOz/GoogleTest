import PageObjects.HomePage;
import PageObjects.ResultPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
//TODO create a package for tests, move this class there
public class GoogleTest {

    private FirefoxDriver driver;
    private String term = "Lorem Ipsum";

    @BeforeClass
    public void testSetup(){
        driver = new FirefoxDriver();
        driver.get("https://www.google.com.ua");

    }

    @AfterClass
    public void testTeardown(){
        driver.quit();
    }

    @Test
    public void test(){

        HomePage home = new HomePage(driver);
        Reporter.log("Opened homepage");
        home.verifyLogoIsDisplayed();
        Reporter.log("Logo is displayed");
        ResultPage result = home.searchTerm(term);
        Reporter.log("Entered search term");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        result.verifyFirstLink(term);
        Reporter.log("First link contains search term");
        HomePage home1  = result.getHomepage();
        Reporter.log("Returned to homepage");
        home1.hideLogo();
        home1.verifyLogoIsHidden();
        Reporter.log("Logo is hidden");


    }
}
