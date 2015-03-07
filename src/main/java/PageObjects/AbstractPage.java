//TODO package names must be unique and lowercase - org.home.pageobjects etc
package PageObjects;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {

    protected FirefoxDriver driver;

    public AbstractPage(FirefoxDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public HomePage getHomepage(){
        //TODO move URL out to a variable
        driver.get("https://www.google.com.ua");
        return new HomePage(driver);
    }


}
