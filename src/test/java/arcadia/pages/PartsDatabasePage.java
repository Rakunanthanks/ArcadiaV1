package arcadia.pages;

import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PartsDatabasePage extends BasePage{
    @FindBy(xpath = "//span[contains(text(),\"Populate\")]") private WebElement populate;
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    public PartsDatabasePage(WebDriver driver) {
        super(driver);
    }
    public  void populateParts() throws InterruptedException{
        customCommand.waitForElementToBeClickable(driver,populate);
        this.populate.click();
    }
}

