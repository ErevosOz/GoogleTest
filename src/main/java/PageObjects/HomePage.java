package PageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends AbstractPage {

    public HomePage(FirefoxDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//*[@id='hplogo']")
    private WebElement logo;

    @FindBy(xpath = ".//input [@id='lst-ib']")
    private WebElement searchForm;

    @FindBy(xpath = ".//button[@class='lsb']")
    private WebElement searchButton;




    public void verifyLogoIsDisplayed() {
        Assert.assertTrue(logo.isDisplayed());
    }

    public ResultPage searchTerm(String term){
        searchForm.sendKeys(term);
        searchButton.click();
        return new ResultPage(driver);
    }

    public void hideLogo() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility='hidden'", logo);
    }

    public void verifyLogoIsHidden() {
        Assert.assertFalse(logo.isDisplayed());
    }


}
