package arcadia.pages;

import arcadia.domainobjects.Harness;
import arcadia.domainobjects.Schematic;
import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateSchematic extends BasePage {
    public CreateSchematic(WebDriver driver) {
        super(driver);
    }
    //Create schematic
    @FindBy(css = "input[name=\"Worktask\"]") private WebElement schematicWorkTask;
    @FindBy(css = "input[name=\"Title\"]") private WebElement schematicTitle;
    @FindBy(css = "input[name=\"Description\"]") private WebElement schematicDescription;
    @FindBy(css = "input[name=\"Part Number\"]") private WebElement schematicPartNumber;
    @FindBy(css = "input[name=\"Revision\"]") private WebElement schematicRevision;
    @FindBy(css = "div#Information select[name=\"Library\"]") private WebElement schematicComponentDB;
    @FindBy(css = "select[name=\"Profile\"]") private WebElement schematicProfile;
    @FindBy(css = "button#formSubmit") private WebElement schematicSubmitButton;

    SeleniumCustomCommand  customCommand = new SeleniumCustomCommand();

    public void submitSchematicData(Schematic schematicData) throws InterruptedException {
        customCommand.waitForElementVisibility(driver ,schematicWorkTask);
        Thread.sleep(1000);
        customCommand.enterText(schematicWorkTask,schematicData.getWorkTask());
        customCommand.enterText(schematicTitle,schematicData.getTitle());
        customCommand.enterText(schematicDescription,schematicData.getDescription());
        customCommand.enterText(schematicPartNumber,schematicData.getPartNumber());
        customCommand.enterText(schematicRevision,schematicData.getRevision());
        customCommand.selectDropDownByValue(schematicComponentDB,schematicData.getComponentDB());
        customCommand.selectDropDownByValue(schematicProfile,schematicData.getprofile());
        customCommand.selectDropDownByValue(schematicComponentDB,schematicData.getComponentDB());
        schematicSubmitButton.click();

    }

    public void verifySchematicCreated(){



    }


}
