package arcadia.pages;

import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProjectLanding extends BasePage {
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    public ProjectLanding(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "a[title=\"Create Harness\"]") private WebElement createHarness;
    public void invokeCreateHarness(){
        customCommand.waitForElementToBeClickable(driver,createHarness);
        createHarness.click();
    }

}
