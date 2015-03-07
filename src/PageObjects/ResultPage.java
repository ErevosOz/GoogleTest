package PageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ResultPage extends AbstractPage {


    public ResultPage(FirefoxDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(.//*[@id='ires']//a)[1]")
    private WebElement firstLink;

    public void verifyFirstLink(String term){
        Assert.assertTrue(firstLink.getText().contains(term));


    }

}
