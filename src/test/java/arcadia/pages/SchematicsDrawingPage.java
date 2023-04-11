package arcadia.pages;

import arcadia.pages.ComponentDB.AddNewComponentPage;
import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.hotkey.Keys;
import org.testng.Assert;


import java.awt.*;
import java.util.List;

public class SchematicsDrawingPage extends BasePage{

    @FindBy(xpath = "//div[@Title = 'Insert Connector']") private WebElement inlineConnector;
    @FindBy(xpath = "//div[@Title = 'Insert Splice']") private WebElement insertInlineSplice;
    @FindBy(xpath = "//div[@Title = 'Draw Select']") private WebElement selectButton;
    //Inline connectors
    @FindBy(xpath = "//*[name()='g' and @id='layer_components']//*[name()='g' and @puid='connector']") private List<WebElement> listOfInlineConnectors;
    @FindBy(xpath = "//*[name()='g' and @id='layer_components']//*[name()='g' and @puid='connector']//*[name()='g' and contains(@id,'_male')]") private List<WebElement> listOfMalePartInlineConnectors;
    @FindBy(xpath = "//*[name()='g' and @id='layer_components']//*[name()='g' and @puid='connector']//*[name()='g' and contains(@id,'_female')]") private List<WebElement> listOfFemalePartInlineConnectors;
    @FindBy(css = "li#cmaddmorepins") private WebElement addMorePins;
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
    @FindBy(xpath = "//input[@id='EICshowDesc']//following-sibling::span[@class='switch-handle']") private WebElement switchShowDescription;
    @FindBy(xpath = "//*[name()='g' and @id='layer_components']//*[name()='g' and @puid='splice']") private List<WebElement> listOfSplice;
    @FindBy(xpath = "//input[@class='refCodeSpec']") private WebElement editSpliceName;
    @FindBy(xpath = "//button[contains(@title,'Update component data, close dialog')]") private WebElement okButtonEditSplice;
    @FindBy(xpath = "//span[@class='ribbon-title' and text()='Advanced']") private WebElement advancedTab;
    @FindBy(xpath = "//span[@class='button-title' and text()='Wire Editor']") private WebElement wireEditor;
    @FindBy(id = "wire-editor") private WebElement divWireEditorPage;
    @FindBy(xpath = "//th//span[text()=\"To Con\"]") private WebElement headingToCon;
    @FindBy(xpath = "//th//span[text()=\"Material\"]") private WebElement headingMaterial;
    @FindBy(xpath = "//th//span[text()=\"Gauge\"]") private WebElement headingGauge;
    @FindBy(xpath = "//th//span[text()=\"Primary Color\"]") private WebElement headingPrimaryColour;
    @FindBy(xpath = "//label[contains(text(),\"Component DB\")]//following-sibling::select") private WebElement selectDropdownComponentDB;
    @FindBy(xpath = "//tbody/tr/td[10]") private WebElement connectorsColumns;
    @FindBy(xpath = "count((//span[text() = 'Material'])[1]/../../preceding-sibling::th)") private WebElement materialColumnIndex;
    @FindBy(xpath = "//tbody/tr/td[15]") private List<WebElement> materialColumnList;
    @FindBy(xpath = "count((//span[text() = 'Gauge'])[1]/../../preceding-sibling::th)") private WebElement gaugeColumnIndex;
    @FindBy(xpath = "//tbody/tr/td[16]") private List<WebElement> gaugeColumnList;
    @FindBy(xpath = "count((//span[text() = 'Primary Color'])[1]/../../preceding-sibling::th)") private WebElement primaryColorColumnIndex;
    @FindBy(xpath = "//tbody/tr/td[17]") private List<WebElement> primaryColorColumnList;
    @FindBy(xpath = "//button[text() = 'Save']") private WebElement saveButton;
    @FindBy(xpath = "//a[contains(text(),'Go to Drawing')]") private WebElement buttonGoToDrawing;
    @FindBy(xpath = "//div[@title='Insert Wire']") private WebElement insertWire;
    @FindBy(xpath = "//div[@Title = 'Wire Label Inline']") private WebElement wireLabelInline;
    @FindBy(xpath = "//div[@Title = 'Remove All Wire Labels']") private WebElement removeAllWireLabels;
    @FindBy(xpath = "//div[@id=\"dialog\" and text()=\"Remove all labels for wires?\"]") private WebElement popupMessageRemoveLabelsFromWires;
    @FindBy(xpath = "//div[@Title = 'Line Label']") private WebElement wireLabel;

    @FindBy(xpath = "//span[text()=\"Confirm Action\"]") private WebElement headingConfirmActionRemoveWireLabel;
    @FindBy(xpath = "//div[@class=\"ui-dialog-buttonset\"]//span[text()=\"Submit\"]") private WebElement buttonSubmitRemoveWireLabel;
    @FindBy(xpath = "//div[@title=\"no Line Label\"]//span") private WebElement wireWOLabel;
    @FindBy(css = "select#wireType") private WebElement selectWireTypeShowWireWithoutLabel;
    @FindBy(css = "div#btnFotter button[title=\"Submit\"]") private WebElement buttonSubmitShowWireWithoutLabel;
    @FindBy(xpath = "//input[@class='wireidspec']") private WebElement wireName;
    @FindBy(xpath = "//button[@title='Update wire data, close dialog']") private WebElement wireOkButton;
    @FindBy(xpath = "//div[@title='Zoom Out']") private WebElement zoomOut;
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();



    public SchematicsDrawingPage(WebDriver driver) {
        super(driver);
    }

    public void addInlineConnector(int xpoint, int ypoint, String connectorIdFemaleHalfName,String connectorDescFemaleHalf, Boolean enableDescriptionToggle) throws InterruptedException {
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
        updateInlineConnectorFemaleHalfIdandDescription(eleInlineConnector,connectorIdFemaleHalfName,connectorDescFemaleHalf,enableDescriptionToggle);
        eleInlineConnector = driver.findElements(By.xpath("//*[name()='g' and @id='layer_components']//*[name()='g' and @puid='connector']")).get(numberOfInlineConnectors-1);
        customCommand.waitForElementToBeClickable(driver,eleInlineConnector);
    }

    public void updateInlineConnectorFemaleHalfIdandDescription(WebElement elementInlineConnector, String inlineConnectorIdFemaleHalfName, String connectorDescFemaleHalf, Boolean enableDescriptionToggle) throws InterruptedException {
        customCommand.javaScriptClick(driver,selectButton);
        customCommand.moveToElementAndDoubleClick(driver,elementInlineConnector);
        customCommand.waitForElementVisibility(driver,tabConnectorEditConnector);
        if (enableDescriptionToggle){
            switchShowDescription.click();
        }
        customCommand.waitForElementToBeClickable(driver,divEditConnectorIdFemaleHalf);
        divEditConnectorIdFemaleHalf.click();
        inputEditConnectorIdFemaleHalf.sendKeys(Keys.BACKSPACE);
        customCommand.clearAndEnterText(inputEditConnectorIdFemaleHalf,inlineConnectorIdFemaleHalfName);
        customCommand.waitForElementToBeClickable(driver,tabConnectorEditConnector);
        customCommand.javaScriptClick(driver,tabConnectorEditConnector);
        customCommand.waitForElementVisibility(driver,inputEditConnectorDescFemaleHalf);
        customCommand.clearAndEnterText(inputEditConnectorDescFemaleHalf,connectorDescFemaleHalf);
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
        customCommand.waitForElementToBeClickable(driver,advancedTab);
        customCommand.javaScriptClick(driver,advancedTab);
        customCommand.waitForElementToBeClickable(driver,wireEditor);
        customCommand.javaScriptClick(driver,wireEditor);
        customCommand.waitForElementVisibility(driver,divWireEditorPage);
    }
    public void changePrimaryColour() throws InterruptedException, AWTException {
        Thread.sleep(3000);
        customCommand.waitForElementToBeClickable(driver,selectDropdownComponentDB);
        customCommand.scrollIntoView(driver,headingToCon);
        customCommand.javaScriptClick(driver,headingToCon);
        Thread.sleep(2000);
        String primaryColour;
        List<WebElement> listOfConnectorsColumns = driver.findElements(By.xpath("//tbody/tr/td[10]"));
        for (int i=0; i<listOfConnectorsColumns.size(); i++){
            if (listOfConnectorsColumns.get(i).getText().equalsIgnoreCase("SP-BK")){
                primaryColour = "BK";
            }
            else if (listOfConnectorsColumns.get(i).getText().equalsIgnoreCase("SP-YE")){
                primaryColour = "YE";
            }
            else if (listOfConnectorsColumns.get(i).getText().equalsIgnoreCase("SP-GN")){
                primaryColour = "GN";
            }
            else {
                primaryColour = "WH";
            }
            customCommand.scrollIntoView(driver,headingPrimaryColour);
            customCommand.moveToElementAndDoubleClick(driver,primaryColorColumnList.get(i));
            customCommand.clearAndEnterText(driver.findElement(By.xpath("//textarea")),primaryColour);
            customCommand.scrollIntoView(driver,headingToCon);
        }
    }
    public void changeGaugeAndMaterial() throws InterruptedException, AWTException {
        Thread.sleep(3000);
        customCommand.scrollIntoView(driver,headingMaterial);
        List<WebElement> listOfGaugeColumnRows = driver.findElements(By.xpath("//tbody/tr/td[16]"));
        for(WebElement we:materialColumnList)
        {
            customCommand.moveToElementAndDoubleClick(driver,we);
            customCommand.clearAndEnterText(driver.findElement(By.xpath("//textarea")),"GXL");
        }
        Thread.sleep(2000);
        customCommand.scrollIntoView(driver,headingGauge);
        for(WebElement eleGauge:listOfGaugeColumnRows)
        {
            customCommand.moveToElementAndDoubleClick(driver,eleGauge);
            customCommand.clearAndEnterText(driver.findElement(By.xpath("//textarea")),"18");
        }
    }

    public void saveWireEditorChanges() throws InterruptedException {
        customCommand.waitForElementToBeClickable(driver,saveButton);
        customCommand.javaScriptClick(driver,saveButton);
        new AddNewComponentPage(driver).verifyAlertMessage("Saved successfully");
        new AddNewComponentPage(driver).closeAlertPopUp();
        Thread.sleep(2000);
    }

    public void goToDrawingFromWireEditor() {
        customCommand.waitForElementToBeClickable(driver, buttonGoToDrawing);
        buttonGoToDrawing.click();
        customCommand.longWaitForElementToBeClickable(driver,advancedTab);

    }

    public void addPinsToConnectorUsingConnectorName(String connectorIdFemaleHalf, int numberOfPins) throws InterruptedException {
        customCommand.javaScriptClick(driver,selectButton);
        WebElement ele = driver.findElement(By.xpath("//*[name()='g' and @title='"+connectorIdFemaleHalf+"']//*[name()='g' and contains(@id,'_male')]//*[name()='rect']"));
        customCommand.moveToElementAndContextClick(driver,ele);
        customCommand.waitForElementToBeClickable(driver,addMorePins);
        customCommand.javaScriptClick(driver,addMorePins);
        customCommand.waitForElementVisibility(driver,inputAddMorePins);
        customCommand.waitForElementToBeClickable(driver,inputAddMorePins);
        customCommand.clearAndEnterText(inputAddMorePins, String.valueOf(numberOfPins));
        customCommand.javaScriptClick(driver,buttonOkAddMorePins);

    }

    public boolean checkIfWireLabelPresent(String wireId) {
        List<WebElement> listOfWireLabelElements = driver.findElements(By.xpath("//*[name()='text' and @class='complabel' and contains(text(),'"+wireId+"')]"));
        if (listOfWireLabelElements.size()>0){
            return true;
        }
        else {
            return false;
        }
    }

    public void removeAllWireLabels() throws InterruptedException {
        customCommand.scrollIntoView(driver,removeAllWireLabels);
        customCommand.waitForElementToBeClickable(driver,removeAllWireLabels);
        customCommand.javaScriptClick(driver,removeAllWireLabels);
        Assert.assertTrue(headingConfirmActionRemoveWireLabel.isDisplayed(),"ConfirmAction popup is not displayed for removing wire labels");
        Assert.assertTrue(popupMessageRemoveLabelsFromWires.isDisplayed(),"Message for removing wire labels is not displayed");
        buttonSubmitRemoveWireLabel.click();
        customCommand.waitForElementToBeClickable(driver,advancedTab);
    }

    public List<WebElement> getInlineConnectorCircles(String inlineConnectorName)
    {
        List<WebElement> inlineConnectorpins = driver.findElements(By.xpath("//*[name()='g' and @title='"+inlineConnectorName+"']"));
        return inlineConnectorpins;
    }
    public List<WebElement> getInlineSplices()
    {
        List<WebElement> inlineSplices = driver.findElements(By.xpath("//*[name()='g' and @puid='splice']"));
        return inlineSplices;
    }


    public void zoomOut() throws InterruptedException {
        customCommand.javaScriptClick(driver,zoomOut);
    }

    public void connectWire(String name,WebElement left,WebElement right) throws InterruptedException {
        Actions actions = new Actions(driver);
        customCommand.javaScriptClick(driver,insertWire);
        actions.moveToElement(left).click().perform();
//        left.click();
        Thread.sleep(2000);
        customCommand.moveByOffsetOfElementAndClick(driver,left,120,0);
        Thread.sleep(2000);
        actions.moveToElement(right).click().perform();
//        right.click();
        Thread.sleep(2000);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='wireidspec']")));
        customCommand.clearAndEnterText(wireName,name);
        customCommand.javaScriptClick(driver,wireOkButton);
        Thread.sleep(2000);
    }

}
