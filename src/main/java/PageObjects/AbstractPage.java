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
        driver.get("https://www.google.com.ua");
        return new HomePage(driver);
    }


}
