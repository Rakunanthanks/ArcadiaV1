package arcadia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IntegrationTestElementsPage extends BasePage{
    //Add project
    @FindBy(css = "button#addProject") private WebElement buttonAddProject;
    @FindBy(css = "input[name=\"projectName\"]") private WebElement inputProjectName;
    @FindBy(css = "input[name=\"data.description\"]") private WebElement inputProjectDescription;
    @FindBy(css = "input[name=\"data.tags\"]") private WebElement inputProjectTags;
    @FindBy(css = "select[name=\"data.editableStatus\"]") private WebElement selectProjectEditableStatus;
    @FindBy(css = "select[name=\"data.profile\"]") private WebElement selectProjectProfile;
    @FindBy(css = "div[aria-labelledby=\"addProject\"] button#formSubmit") private WebElement buttonSubmitAddProject;

    //Create schematic
    @FindBy(css = "table#project a.addSchematic") private WebElement linkAddSchematic;

    @FindBy(css = "input[name=\"Worktask\"]") private WebElement schematicWorkTask;
    @FindBy(css = "input[name=\"Title\"]") private WebElement schematicTitle;
    @FindBy(css = "input[name=\"Description\"]") private WebElement schematicDescription;
    @FindBy(css = "input[name=\"Part Number\"]") private WebElement schematicPartNumber;
    @FindBy(css = "input[name=\"Revision\"]") private WebElement schematicRevision;
    @FindBy(css = "select[name=\"Library\"]") private WebElement schematicComponentDB;
    @FindBy(css = "select[name=\"Profile\"]") private WebElement schematicProfile;
    @FindBy(css = "button#formSubmit") private WebElement schematicSubmitButton;

    //Drawingpage

    //clickOnFrame already there in DrawingHelper
    //chooseFrame already there in DrawingHelper
    //clickOnConnector already there in HarnessPage

    //Inline connectors
    @FindBy(xpath = "//*[name()='g' and @id='layer_components']//*[name()='g' and @puid='connector']") private List<WebElement> listOfInlineConnectors;
    @FindBy(xpath = "//*[name()='g' and @id='layer_components']//*[name()='g' and @puid='connector']//*[name()='g' and contains(@id,'_male')]") private List<WebElement> listOfMalePartInlineConnectors;
    @FindBy(xpath = "//div[@aria-describedby=\"EIC\"]//span[text()=\"Edit Connector\"]") private WebElement headingEditConnector;
    @FindBy(css = "#codesFemaleId+div input") private WebElement inputEditConnectorIdFemaleHalf;
    @FindBy(css = "button[title=\"Add connector data, close dialog\"]>span") private WebElement buttonOkEditConnector;

    //Context menu would be done at the time of script creation

    //Add pins
    @FindBy(xpath = "//div[@aria-describedby=\"AMIP\"]//span[text()=\"Add More Pins\"]") private WebElement headingAddPins;
    @FindBy(css = "input[name=\"numPins\"]") private WebElement inputAddMorePins;
    @FindBy(css = "button[title=\"Add more pins, close dialog\"]>span") private WebElement buttonOkAddMorePins;
    @FindBy(css = "input[name=\"newPinID\"]") private WebElement inputEditConnectorNewPinID;

    @FindBy(xpath = "//span[text()=\"Modify Connector\"]") private WebElement headingModifyConnector;
    @FindBy(xpath = "//span[text()=\"Entire Group\"]") private WebElement buttonEntireGroup;

    @FindBy(css = "li#dropdown_housing>span") private WebElement buttonFooterHousings;
    @FindBy(css = "li#dropdown_pins>span") private WebElement buttonFooterPins;

    //To select a pin and dragdrop
    @FindBy(xpath = "//*[name()='g' and @id='layer_nodes']//*[name()='g' and @class='housing']") private List<WebElement> listOfInlinePins;
    //After 06:20 in video
    @FindBy(xpath = "//*[name()='g' and @id='layer_components']//*[name()='g' and @puid='splice']") private List<WebElement> listOfSplice;
    @FindBy(xpath = "//input[@class='refCodeSpec']") private WebElement editSpliceName;
    @FindBy(xpath = "//button[contains(@title,'Update component data, close dialog')]") private WebElement okButtonEditSplice;
    @FindBy(xpath = "//span[@class='ribbon-title' and text()='Advanced']") private WebElement advancedTab;
    @FindBy(xpath = "//span[@class='button-title' and text()='Wire Editor']") private WebElement wireEditor;
    @FindBy(xpath = "count((//span[text() = 'Material'])[1]/../../preceding-sibling::th)") private WebElement materialColumnIndex;
    @FindBy(xpath = "//tbody/tr/td[15]") private List<WebElement> materialColumnList;
    @FindBy(xpath = "count((//span[text() = 'Gauge'])[1]/../../preceding-sibling::th)") private WebElement gaugeColumnIndex;
    @FindBy(xpath = "//tbody/tr/td[15]") private List<WebElement> gaugeColumnList;
    @FindBy(xpath = "count((//span[text() = 'Primary Color'])[1]/../../preceding-sibling::th)") private WebElement primaryColorColumnIndex;
    @FindBy(xpath = "//tbody/tr/td[15]") private List<WebElement> primaryColorColumnList;
    @FindBy(xpath = "//button[text() = 'Save']") private WebElement saveButton;
    @FindBy(xpath = "//a[contains(text(),'Go to Drawing')]") private WebElement goToDrawing;
    @FindBy(xpath = "//div[@Title = 'Wire Label Inline']") private WebElement wireLabelInline;
    @FindBy(xpath = "//div[@Title = 'Remove All Wire Labels']") private WebElement removeAllWireLabels;
    @FindBy(xpath = "//div[@Title = 'Line Label']") private WebElement wireLabel;





    public IntegrationTestElementsPage(WebDriver driver) {
        super(driver);
    }
}
