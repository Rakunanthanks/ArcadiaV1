package arcadia.pages;

import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.List;

public class IntegrationTestElementsPage extends BasePage{

    //Drawingpage

    //clickOnFrame already there in DrawingHelper
    //chooseFrame already there in DrawingHelper
    //clickOnConnector already there in HarnessPage

    @FindBy(xpath = "//div[@Title = 'Insert Connector']") private WebElement inlineConnector;
    @FindBy(xpath = "//div[@Title = 'Draw Select']") private WebElement selectButton;
    //Inline connectors
    @FindBy(xpath = "//*[name()='g' and @id='layer_components']//*[name()='g' and @puid='connector']") private List<WebElement> listOfInlineConnectors;
    @FindBy(xpath = "//*[name()='g' and @id='layer_components']//*[name()='g' and @puid='connector']//*[name()='g' and contains(@id,'_male')]") private List<WebElement> listOfMalePartInlineConnectors;
    @FindBy(xpath = "//*[name()='g' and @id='layer_components']//*[name()='g' and @puid='connector']//*[name()='g' and contains(@id,'_female')]") private List<WebElement> listOfFemalePartInlineConnectors;
    @FindBy(xpath = "//li[@id='cmaddmorepins']") private WebElement addMorePins;
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
    @FindBy(xpath = "//*[name()='g' and @id='layer_nodes']//*[name()='g' and @class='housing']") private List<WebElement> listOfInlineNodes;

    @FindBy(xpath = "//*[name()='g' and @id='layer_pins']//*[name()='g' and @objtype='pin']//*[name()='circle']") private List<WebElement> listOfPinsCircles;
    @FindBy(xpath = "//div[@id=\"EIC\"]//a[text()=\"Connector\"]") private WebElement tabConnectorEditConnector;
    @FindBy(xpath = "//div[@id=\"EIC\"]//a[text()=\"Inline Pin\"]") private WebElement tabInlinePinEditConnector;
    @FindBy(css = "input[name=\"connDescFemale\"]") private WebElement inputEditConnectorDescFemaleHalf;
    @FindBy(xpath = "//input[@id='EICshowDesc']//following-sibling::span[@class='switch-handle'] ") private WebElement switchShowDescription;
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

    @FindBy(xpath = "//span[text()=\"Confirm Action\"]") private WebElement headingConfirmActionRemoveWireLabel;
    @FindBy(xpath = "//div[@class=\"ui-dialog-buttonset\"]//span[text()=\"Submit\"]") private WebElement buttonSubmitRemoveWireLabel;
    @FindBy(xpath = "//div[@title=\"no Line Label\"]//span") private WebElement wireWOLabel;
    @FindBy(css = "select#wireType") private WebElement selectWireTypeShowWireWithoutLabel;
    @FindBy(css = "div#btnFotter button[title=\"Submit\"]") private WebElement buttonSubmitShowWireWithoutLabel;

    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();



    public IntegrationTestElementsPage(WebDriver driver) {
        super(driver);
    }

    public void addInlineConnector(int xpoint, int ypoint) throws InterruptedException, AWTException {
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver,selectButton);
        customCommand.javaScriptClick(driver,inlineConnector);
        Actions actions = new Actions(driver);
        WebElement element=inlineConnector;
        if(listOfInlineConnectors.size()>0)
        {
            element=listOfInlineConnectors.get(0);
        }
        int x=element.getLocation().getX()-xpoint;
        int y=element.getLocation().getY()+ypoint;
        System.out.println(x+"-----"+y);
//        customCommand.moveElementByOffset(driver,inlineConnector,x-xpoint,y+ypoint);
        actions.moveByOffset(x,y).click().perform();
    }

    public void addPinsToConnector() throws InterruptedException {
        customCommand.javaScriptClick(driver,selectButton);
        for(WebElement ele:listOfFemalePartInlineConnectors)
        {
            String[] ids=ele.getAttribute("id").split("_");
            String id=ids[0]+"comp";
            WebElement connectorId=driver.findElement(By.xpath("//*[name()='g' and @id='"+id+"']"));
            new HarnessPage(driver).getContextMenu("",connectorId);
            customCommand.javaScriptClick(driver,addMorePins);
            customCommand.clearAndEnterText(inputAddMorePins,"5");
            customCommand.javaScriptClick(driver,buttonOkAddMorePins);
        }
    }

    public void clickOnPinsFooter() throws InterruptedException {
        customCommand.javaScriptClick(driver,buttonFooterPins);
    }

    public void clickOnHousingsFooter() throws InterruptedException {
        customCommand.javaScriptClick(driver,buttonFooterHousings);
System.out.println("");
    }

}
