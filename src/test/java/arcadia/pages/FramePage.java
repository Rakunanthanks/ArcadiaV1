package arcadia.pages;

import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends BasePage {
    public FramePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "select[name=\"frameList\"]") private WebElement chooseFrame;
    @FindBy(css = "button[title=\"Submit\"]") private WebElement submitFrame;
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();

    public void chooseFrame(String frameSize) throws InterruptedException {
        customCommand.waitClick(chooseFrame);
        customCommand.selectDropDownByVisibleText(chooseFrame,frameSize);
        submitFrame.click();
    }


}
