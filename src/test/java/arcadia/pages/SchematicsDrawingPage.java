package arcadia.pages;

import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.sikuli.hotkey.Keys;

import java.util.List;

public class SchematicsDrawingPage extends BasePage{

    @FindBy(xpath = "//div[@Title = 'Insert Connector']") private WebElement inlineConnector;
    @FindBy(xpath = "//div[@Title = 'Insert Splice']") private WebElement insertInlineSplice;
    @FindBy(xpath = "//div[@Title = 'Draw Select']") private WebElement selectButton;
    //Inline connectors
    @FindBy(xpath = "//*[name()='g' and @id='layer_components']//*[name()='g' and @puid='connector']") private List<WebElement> listOfInlineConnectors;
    @FindBy(xpath = "//*[name()='g' and @id='layer_components']//*[name()='g' and @puid='connector']//*[name()='g' and contains(@id,'_male')]") private List<WebElement> listOfMalePartInlineConnectors;
    @FindBy(xpath = "//*[name()='g' and @id='layer_components']//*[name()='g' and @puid='connector']//*[name()='g' and contains(@id,'_female')]") private List<WebElement> listOfFemalePartInlineConnectors;
    @FindBy(xpath = "//li[@id='cmaddmorepins']") private WebElement addMorePins;
    @FindBy(xpath = "//div[@aria-describedby=\"EIC\"]//span[text()=\"Edit Connector\"]") private WebElement headingEditConnector;
    @FindBy(css = "#codesFemaleId+div div.item") private WebElement divEditConnectorIdFemaleHalf;
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
    @FindBy(xpath = "//tbody/tr/td[16]") private List<WebElement> gaugeColumnList;
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



    public SchematicsDrawingPage(WebDriver driver) {
        super(driver);
    }

    public void addInlineConnector(int xpoint, int ypoint, String connectorFemaleHalfName) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver,selectButton);
        customCommand.javaScriptClick(driver,inlineConnector);
        WebElement element;
        if(listOfInlineConnectors.size()>0)
        {
            element=listOfInlineConnectors.get(0);
            customCommand.moveByOffsetOfElementAndClick(driver,element,xpoint,ypoint);
        }
        else {
            element = inlineConnector;
            int initialXCoordinateOfInsertConnectorButton = element.getLocation().getX();
            int initialYCoordinateOfInsertConnectorButton = element.getLocation().getY();
            customCommand.moveByOffsetAndClick(driver,initialXCoordinateOfInsertConnectorButton-250,initialYCoordinateOfInsertConnectorButton+200);
        }
        Thread.sleep(3000);
        int numberOfInlineConnectors = listOfInlineConnectors.size();
        WebElement eleInlineConnector = listOfInlineConnectors.get(numberOfInlineConnectors-1);
        updateInlineConnectorName(eleInlineConnector,connectorFemaleHalfName);
        eleInlineConnector = driver.findElements(By.xpath("//*[name()='g' and @id='layer_components']//*[name()='g' and @puid='connector']")).get(numberOfInlineConnectors-1);
        customCommand.waitForElementToBeClickable(driver,eleInlineConnector);
    }

    public void updateInlineConnectorName(WebElement elementInlineConnector, String inlineConnectorName) throws InterruptedException {
        customCommand.javaScriptClick(driver,selectButton);
        customCommand.moveToElementAndDoubleClick(driver,elementInlineConnector);
        customCommand.waitForElementVisibility(driver,tabConnectorEditConnector);
        customCommand.waitForElementToBeClickable(driver,divEditConnectorIdFemaleHalf);
        divEditConnectorIdFemaleHalf.click();
        inputEditConnectorIdFemaleHalf.sendKeys(Keys.BACKSPACE);
        customCommand.clearAndEnterText(inputEditConnectorIdFemaleHalf,inlineConnectorName);
        tabConnectorEditConnector.click();
        customCommand.javaScriptClick(driver,buttonOkEditConnector);
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
            customCommand.waitForElementVisibility(driver,inputAddMorePins);
            customCommand.waitForElementToBeClickable(driver,inputAddMorePins);
            customCommand.clearAndEnterText(inputAddMorePins,"5");
            customCommand.javaScriptClick(driver,buttonOkAddMorePins);
        }
    }

    public void clickOnPinsFooter() throws InterruptedException {
        customCommand.waitForElementToBeClickable(driver,buttonFooterPins);
        customCommand.javaScriptClick(driver,buttonFooterPins);
        Thread.sleep(2000);
    }

    public void clickOnHousingsFooter() throws InterruptedException {
        customCommand.waitForElementToBeClickable(driver,buttonFooterHousings);
        customCommand.javaScriptClick(driver,buttonFooterHousings);
        Thread.sleep(3000);
    }

    public void addSplicesToSchematic( int pinNumber, int xOffset, int yOffset, String inlineConnectorName, String spliceName) throws InterruptedException {
        Thread.sleep(3000);
        customCommand.waitForElementToBeClickable(driver,insertInlineSplice);
        List<WebElement> inlineConnectorpins = driver.findElements(By.xpath("//*[name()='g' and @title='"+inlineConnectorName+"']//*[name()='circle']"));
        WebElement pin = inlineConnectorpins.get(pinNumber-1);
        customCommand.javaScriptClick(driver,selectButton);
        customCommand.javaScriptClick(driver,insertInlineSplice);
        customCommand.moveByOffsetOfElementAndClick(driver,pin,xOffset,yOffset);
        Thread.sleep(2000);
        int numberOfSplices = listOfSplice.size();
        WebElement eleSplice = listOfSplice.get(numberOfSplices-1);
        updateSpliceReferenceCode(eleSplice,spliceName);
    }

    private void updateSpliceReferenceCode(WebElement eleSplice, String spliceName) throws InterruptedException {
        customCommand.javaScriptClick(driver,selectButton);
        customCommand.moveToElementAndDoubleClick(driver,eleSplice);
        customCommand.waitForElementVisibility(driver,editSpliceName);
        customCommand.waitForElementToBeClickable(driver,editSpliceName);
        customCommand.clearAndEnterText(editSpliceName,spliceName);
        customCommand.javaScriptClick(driver,okButtonEditSplice);
        Thread.sleep(2000);
    }

    public void moveToWireEditor() throws InterruptedException {
        customCommand.javaScriptClick(driver,advancedTab);
        customCommand.javaScriptClick(driver,wireEditor);
    }
    public void changeGaugeAndMaterial() throws InterruptedException {
        for(WebElement we:materialColumnList)
        {
            customCommand.clearAndEnterText(we,"GXL");
        }
        for(WebElement we:gaugeColumnList)
        {
            customCommand.clearAndEnterText(we,"12");
        }
        customCommand.javaScriptClick(driver,saveButton);
    }

}
