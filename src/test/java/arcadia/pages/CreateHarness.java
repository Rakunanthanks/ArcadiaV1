package arcadia.pages;

import arcadia.domainobjects.Harness;
import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateHarness extends BasePage {
    public CreateHarness(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "input[name=\"Worktask\"]") private WebElement workTask;
    @FindBy(css = "input[name=\"Title\"]") private WebElement title;
    @FindBy(css = "input[name=\"Description\"]") private WebElement description;
    @FindBy(css = "input[name=\"Part Number\"]") private WebElement partNumber;
    @FindBy(css = "input[name=\"Revision\"]") private WebElement revision;
    @FindBy(css = "select[name=\"Library\"]") private WebElement componentDB;
    @FindBy(id = "formSubmit") private WebElement harnessSubmitButton;

    SeleniumCustomCommand  customCommand = new SeleniumCustomCommand();

    public void submitHarnessData(Harness harnessData) throws InterruptedException {
        customCommand.waitForElementVisibility(driver ,workTask);
        Thread.sleep(1000);
        customCommand.enterText(workTask,harnessData.getWorkTask());
        customCommand.enterText(title,harnessData.getTitle());
        customCommand.enterText(description,harnessData.getDescription());
        customCommand.enterText(partNumber,harnessData.getPartNumber());
        customCommand.enterText(revision,harnessData.getRevision());
        customCommand.selectDropDownByValue(componentDB,harnessData.getComponentDB());
        harnessSubmitButton.click();
    }

    public void verifyHarnessCreated(){



    }


}
