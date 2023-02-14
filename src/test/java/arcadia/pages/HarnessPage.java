package arcadia.pages;
import arcadia.pages.ComponentDB.AddNewComponentPage;
import arcadia.utils.SeleniumCustomCommand;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class HarnessPage extends BasePage{
    @FindBy(id = "commandline") private WebElement commandLine;
    @FindBy(css = "button[title=\"OK\"]") private WebElement commandOK;
    @FindBy(css = "div[title=\"Insert Connector\"]") private WebElement insertConnector;
    @FindBy(id = "ifreebundle") private WebElement bundle;
    @FindBy(id = "izoom_in") private WebElement zoomIn;
    @FindBy(id = "idrawcom") private WebElement select;

    @FindBy(xpath="//input[@name='cavitytable.conbutton']") private WebElement addPartNumber;
    @FindBy(xpath = "//table[@id='tblAttachPartNoList']/tbody/tr[1]/td[1]") private WebElement firstPartFromList;
    @FindBy(xpath = "//input[@name='bom.name']") private WebElement SplicePartName;
    @FindBy(xpath = "//select[@name='wiretable.conidto']") private List<WebElement> connectorTo;
    @FindBy(xpath = "//table[@id='wiretable']//input[@class='getDetails']") private List<WebElement> addWirePartNumber;
    @FindBy(xpath = "//table[@id='tblWirePartNoList']/tbody/tr/td[8]") private List<WebElement> outerDiameter;
    @FindBy(xpath = "//div[@aria-describedby='idFetchnode_attachpart']//span[text()='Populate']") private WebElement populateButtonParts;
    @FindBy(xpath = "//div[@aria-describedby='idFetchwiretable']//span[text()='Populate']") private WebElement populateButtonWire;
    @FindBy(xpath = "//select[@name='wiretable.spliceside']") private List<WebElement> spliceSide;
    @FindBy(xpath = "//table[@id='cavitytable']//input[@class='addRow']") WebElement addRowCavity;
    @FindBy(xpath = "//span[text()='Update wire PN']") WebElement updateWirePN;

    @FindBy(id = "idrawmove") private WebElement move;
    @FindBy(id = "iaddframe") private WebElement frame;
    @FindBy(id = "iupdateroute") private WebElement wireRoute;
    @FindBy(id = "iupdatesleevetube") private WebElement updateSleeveGlobal;
    @FindBy(id = "iopenmenu") private WebElement open;

    @FindBy(css = "input#nodeshow") private WebElement buttonShowNode;

    @FindBy(css = "div[title=\"Label Visibility\"]>span") private WebElement buttonVisibility;

    @FindBy(css = "button[title=\"Submit\"]") private WebElement buttonSubmitDetails;


    @FindBy(xpath = "//div[@id='appContextMenu']/li") private  List<WebElement> operations;
    @FindBy(xpath = "//div[@title='Draw Select']") private  WebElement drawSelectPointer;

    @FindBy(css = "div[title=\"Exit\"]") private WebElement buttonExitDrawing;
    @FindBy(xpath="//select[@name='node.splicetechnology']") private WebElement spliceTechnologyDropdown;

    @FindBy(xpath = "//span[@class=\"ui-dialog-title\"][text()=\"Add Wire\"]") private WebElement popUpAddWire;

    @FindBy(css = "input#wireid") private WebElement inputWireId;

    @FindBy(xpath = "//div[contains(@aria-describedby,\"ui-id\")]//span[text()=\"OK\"]") private WebElement buttonOkAddWire;

    @FindBy(xpath = "//*[name()=\"g\" and @class=\"hilight\"]//*[name()=\"path\" and @nonstroke = \"BLACK\"]") private WebElement wirePath;

    @FindBy(css = "form#quick-add-parts input.quick-add-parts__input") private WebElement inputQuickAddPartNumber;

    @FindBy(xpath = "//*[name()=\"rect\" and @etype=\"connector\"]") private List<WebElement> connectors ;

    @FindBy(css = "#iconneditor>span") private WebElement buttonConnectorEditor;

    @FindBy(css = "#cEditor table.htCore") private WebElement tableConnectorEditor;

    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    public HarnessPage(WebDriver driver) {
        super(driver);
    }
    public  void waitForDrawingPage(){
        customCommand.waitForElementToBeClickable(driver,bundle);
    }

    public WebElement getHeaderElement(String headerName){
        WebElement ele = driver.findElement(By.xpath("//div[@id=\"ribbon-tab-header-strip\"]//span[text()=\""+headerName+"\"]"));
        return ele;
    }

    public WebElement getConnectorPlugElement(String connectorPlugId) throws InterruptedException {
        WebElement ele = driver.findElement(By.xpath("//*[name()='g' and @id='"+connectorPlugId+"']//*[name()='rect' and @etype='connector']"));
        return ele;
    }

    public WebElement getElementConnectorImage(String connectorId) {
        WebElement ele = driver.findElement(By.xpath("//*[name()='g' and @id='"+connectorId+"']//*[name()='g']//*[name()='image']"));
        return ele;
    }

    public List<WebElement> getElementTerminalImage(String imagePath) {
        List<WebElement> ele = driver.findElements(By.xpath("//*[name()=\"image\" and @*[contains(.,'"+imagePath+"')]]"));
        return ele;
    }

    public WebElement getSpliceElement(String spliceId) throws InterruptedException {
        WebElement ele = driver.findElement(By.xpath("//*[name()='g' and @id='"+spliceId+"']//*[name()='rect' and @etype='splice']"));
        return ele;
    }
    public WebElement getNodeElement(String nodeId) throws InterruptedException {
        WebElement ele = driver.findElement(By.xpath("//*[name()='g' and @id='"+nodeId+"']"));
        return ele;
    }


    public List<WebElement> getElementWireFan(String connectorId) {
        List<WebElement> ele = driver.findElements(By.xpath("//*[name()='g' and @id='"+connectorId+"']//*[name()='g']//*[name()='g' and contains(@class,'wirefan')]"));
        return ele;
    }

    public Boolean isHarnessAlreadyExists(String description){
        Boolean elementExists = driver.findElements(By.xpath("//table[@id=\"tableHAR\"]/tbody//tr//td[text()=\"" + description + "\"]")).size()!=0;
        return elementExists ;
    }

    public void clickOnBundle() throws AWTException, InterruptedException {
        customCommand.longWaitForElementToBeClickable(driver,insertConnector);
        customCommand.waitClick(bundle);
    }

    public void clickOnGlobalUpdateSleeve() throws AWTException, InterruptedException {
        customCommand.scrollIntoView(driver,updateSleeveGlobal);
        customCommand.waitClick(updateSleeveGlobal);
        //updateSleeveGlobal.click();
    }

    public void clickOnWireRoute() throws AWTException, InterruptedException {
        customCommand.scrollIntoView(driver,wireRoute);
        customCommand.waitClick(wireRoute);
    }

    public void fillCommandLine(String command){
        commandLine.clear();
        customCommand.enterText(commandLine,command);
    }

    public void clickOnCommandLineOK() throws InterruptedException {
        customCommand.longWaitForElementToBeClickable(driver,commandOK);
        customCommand.waitClick(commandOK);
    }


    public void clickOnConnector() throws InterruptedException {
        customCommand.longWaitForElementToBeClickable(driver,insertConnector);
        customCommand.waitClick(insertConnector);
        insertConnector.click();
    }

    public void clickOnSelect() throws InterruptedException {
        customCommand.longWaitForElementToBeClickable(driver,select);
        customCommand.waitClick(select);
    }

    public void clickOnFrame() throws InterruptedException {
        customCommand.longWaitForElementToBeClickable(driver,frame);
        customCommand.waitClick(frame);
    }

    public void clickOnOpen() throws InterruptedException {
        customCommand.longWaitForElementToBeClickable(driver,open);
        customCommand.waitClick(open);
    }


    public void waitForHarnessPage() throws InterruptedException {
        Thread.sleep(4000);
    }

    public void waitBetweenHarnessActions() throws InterruptedException {
        Thread.sleep(2000);
    }

    public void getContextMenu(String id) throws InterruptedException {
        customCommand.javaScriptClick(driver,drawSelectPointer);
        WebElement ele=driver.findElement(By.xpath("//*[name()='g' and @id='"+id+"']/*[name()='rect']"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        customCommand.rightClick(driver,ele);
        Thread.sleep(2000);
    }

    public void getCavityTableContextMenu(String id) throws InterruptedException {
        customCommand.javaScriptClick(driver,drawSelectPointer);
        WebElement ele = driver.findElement(By.xpath("//*[name()='g' and @id='"+id+"']//table//tbody/tr/td"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        customCommand.rightClick(driver,ele);
        Thread.sleep(2000);
    }

    public void getNodeContextMenu(String id) throws InterruptedException {
        customCommand.javaScriptClick(driver,drawSelectPointer);
        WebElement ele = getNodeElement(id);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        customCommand.rightClick(driver,ele);
        Thread.sleep(2000);
    }

    public void performOperation(String operation,String id) throws InterruptedException {
        ExtentCucumberAdapter.addTestStepLog(String.format("Performing %s operation on component with id = %s", operation,id));
//        ExtentCucumberAdapter.addTestStepLog(String.format("Performing %s operation on connector with connector id = %s", operation,id));
        String xpathOfConnector="//*[name()='g' and @id='"+id+"']/*[name()='rect']";
        List<WebElement> connectors;
        boolean flag=false;
        if(operations.size()==0)
        {
            ExtentCucumberAdapter.addTestStepLog(String.format("Not able to get all the operations allowed"));
//            ExtentCucumberAdapter.addTestStepLog(String.format("Not able to get all the operations allowed on connector"));
        }
        for(WebElement ele:operations)
        {
            customCommand.waitForElementToBeClickable(driver,ele);
            if(ele.getText().equalsIgnoreCase(operation.toString()))
            {
                ele.click();
                Thread.sleep(2000);
                flag = true;
                break;
            }
        }
        if(flag==false)
        {
            System.out.println("Operation "+operation+" not found");
        }else{
            System.out.println("Operation "+operation+" performed");
        }

    }
    public void selectHeader(String headerName) throws InterruptedException {
        WebElement ele = getHeaderElement(headerName);
        customCommand.waitForElementVisibility(driver,ele);
        customCommand.waitForElementToBeClickable(driver,ele);
        customCommand.waitClick(ele);
    }

    public void clickVisibility() throws InterruptedException {
        customCommand.waitForElementVisibility(driver,buttonVisibility);
        customCommand.waitClick(buttonVisibility);
    }

    public void showHideComponentLabel(String labelName, String showHide) throws InterruptedException {
        customCommand.waitForElementVisibility(driver,buttonShowNode);
        switch (labelName.toLowerCase()){
            case "node":
                if (showHide.equalsIgnoreCase("show")){
                    driver.findElement(By.cssSelector("input#nodeshow")).click();
                }
                else {
                    driver.findElement(By.cssSelector("input#nodehide")).click();
                }
                break;
            case "bundle":
                if (showHide.equalsIgnoreCase("show")){
                    driver.findElement(By.cssSelector("input#bundleshow")).click();
                }
                else {
                    driver.findElement(By.cssSelector("input#bundlehide")).click();
                }
                break;
            case "connector cavity table":
                if (showHide.equalsIgnoreCase("show")){
                    driver.findElement(By.cssSelector("input#connectorcavityshow")).click();
                }
                else {
                    driver.findElement(By.cssSelector("input#connectorcavityhide")).click();
                }
                break;
            case "splice cavity table":
                if (showHide.equalsIgnoreCase("show")){
                    driver.findElement(By.cssSelector("input#splicecavityshow")).click();
                }
                else {
                    driver.findElement(By.cssSelector("input#splicecavityhide")).click();
                }
                break;
        }
        customCommand.javaScriptClick(driver,buttonSubmitDetails);
        Thread.sleep(2000);
    }

    public void clickConnectorPlug(String connectorPlugId) throws InterruptedException {
        Thread.sleep(2000);
        WebElement ele = getConnectorPlugElement(connectorPlugId);
        customCommand.waitForElementVisibility(driver,ele);
        customCommand.doubleClick(driver,ele);
        Thread.sleep(2000);
    }
    public void clickSplice(String spliceId) throws InterruptedException {
        Thread.sleep(2000);
        WebElement ele = getSpliceElement(spliceId);
        customCommand.waitForElementVisibility(driver,ele);
        customCommand.doubleClick(driver,ele);
        Thread.sleep(2000);
    }

    public void selectSpliceTechnology(String technology) throws InterruptedException {
        customCommand.selectDropDownByValue(spliceTechnologyDropdown,technology);
        customCommand.javaScriptClick(driver,buttonSubmitDetails);
    }

    public void validateSpliceTechnology(String technology) throws InterruptedException {
      Thread.sleep(2000);
        String tech = customCommand.getSelectedValueFromSelectDropDown(spliceTechnologyDropdown);
        if (tech.equalsIgnoreCase(technology)) {
//            ExtentCucumberAdapter.addTestStepLog(String.format("Expected technology is "+technology+", actual is "+tech));
        }
        else {
//            ExtentCucumberAdapter.addTestStepLog(String.format("Expected technology is "+technology+", actual is "+tech));
        }
    }


    public void deleteHarness(String description){
        driver.findElement(By.xpath("//table[@id=\"tableHAR\"]/tbody//tr//td[contains(text(),\""+description+"\")]/following-sibling::td[last()]//a[@title=\"Delete Task\"]")).click();
        new AddNewComponentPage(driver).verifyConfirmationMessage("Do you want to delete?");
        new AddNewComponentPage(driver).acceptConfirmationPopup();
        new AddNewComponentPage(driver).verifyAlertMessage("Task Deleted Successfully!");
        new AddNewComponentPage(driver).closeAlertPopUp();
    }

    public void exitDrawingPage() throws InterruptedException {
        getHeaderElement("Exit").click();
        customCommand.waitForElementVisibility(driver,buttonExitDrawing);
        buttonExitDrawing.click();
        Thread.sleep(2000);
    }

    public void verifyCavityTableColumnsDisplayed(String connectorid, List<String> expectedHeaders) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> eleListOfTableHeaders = driver.findElements(By.xpath("//*[name()='g' and @id='"+connectorid+"']//table/thead/tr/th"));
        List<String> actualHeaders = new ArrayList<>();
        for (WebElement ele: eleListOfTableHeaders){
            actualHeaders.add(ele.getText());
        }
        Assert.assertEquals(actualHeaders,expectedHeaders);
    }

    public void verifyCavityTableData(String connectorid, String colour, String gauge, String length, String material, String dest,String outerDia, String csa, String fromTag, String toTag, String cavityAddOn, String entryPort) {
        WebElement eleCavityDataRow = driver.findElement(By.xpath("//*[name()='g' and @id='"+connectorid+"']//table//tbody/tr"));
        List<WebElement> tdElements = eleCavityDataRow.findElements(By.cssSelector("td"));
        Assert.assertEquals(tdElements.get(2).findElement(By.tagName("span")).getText(),colour);
        Assert.assertEquals(tdElements.get(3).getText(),gauge);
        Assert.assertEquals(tdElements.get(4).getText(),length);
        Assert.assertEquals(tdElements.get(5).getText(),material);
        Assert.assertEquals(tdElements.get(8).getText(),dest);
        Assert.assertEquals(tdElements.get(16).getText(),outerDia);
        Assert.assertEquals(tdElements.get(17).getText(),csa);
        Assert.assertEquals(tdElements.get(18).getText(),fromTag);
        Assert.assertEquals(tdElements.get(19).getText(),toTag);
        Assert.assertEquals(tdElements.get(23).getText(),cavityAddOn);
        Assert.assertEquals(tdElements.get(25).getText(),entryPort);
    }

    public void verifyCavityTableWrapped(String connectorid) {
        customCommand.waitForElementVisibility(driver,driver.findElement(By.xpath("//*[name()='g' and @id='"+connectorid+"']//table/thead/tr/th")));
        List<WebElement> eleListOfTableHeaders = driver.findElements(By.xpath("//*[name()='g' and @id='"+connectorid+"']//table/thead/tr/th"));
        //There are 26 columns by default. But as we wrapped the data, the column numbers is expected to be doubled
        Assert.assertEquals(eleListOfTableHeaders.size(),52);
    }

    public void verifyConnectorDoNotExists(String connectorid) {
        Assert.assertTrue(driver.findElements(By.xpath("//*[name()='g' and @id='"+connectorid+"']//*[name()='rect' and @etype='connector']")).size()==0, "Connector exists on the drawing page");
    }

    public void verifyResetLabels(String connectorid) throws InterruptedException {
        int xCoordiante = getConnectorPlugElement(connectorid).getLocation().getX();
        int yCoordiante = getConnectorPlugElement(connectorid).getLocation().getY();
        System.out.println("x coordinate is :" + xCoordiante);
        System.out.println("Y coordinate is :" + yCoordiante);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(getConnectorPlugElement(connectorid),xCoordiante+10, yCoordiante+10);
        System.out.println("x coordinate after movement is :" + getConnectorPlugElement(connectorid).getLocation().getX());
        System.out.println("Y coordinate after movement is :" + getConnectorPlugElement(connectorid).getLocation().getY());
    }

    public void clickOnMove() throws InterruptedException {
        customCommand.waitClick(move);
    }

    public void verifyConnectorLabels(String connectorID, String testDescription) {
        List<WebElement> ele = driver.findElements(By.xpath("//*[name()='tspan']"));
        Assert.assertEquals(ele.get(0).getText(),connectorID);
        Assert.assertEquals(ele.get(1).getText(),testDescription);
    }

    public void verifyConnectorImageVisible(String connectorId) throws InterruptedException {
        Thread.sleep(3000);
        WebElement ele = getElementConnectorImage(connectorId);
        Assert.assertTrue(ele.isDisplayed(),"Connector image is not displayed");
    }

    public void verifyConnectorImageNotVisible(String connectorId) throws InterruptedException {
        Thread.sleep(4000);
        List<WebElement> eleList = driver.findElements(By.xpath("//*[name()='g' and @id='"+connectorId+"']//*[name()='g']//*[name()='image']"));
        Assert.assertTrue(eleList.size()==0,"Connector image is displayed");
    }

    public Boolean TerminalImageVisible(String imagePath) throws InterruptedException {
        Thread.sleep(3000);
        Boolean isTerminalImageVisible = getElementTerminalImage(imagePath).size()!=0 && getElementTerminalImage(imagePath).get(0).isDisplayed();
        return isTerminalImageVisible;
    }

    public void verifyWireDestination(String destinationValue, String connectorid) {
        WebElement eleCavityDataRow = driver.findElement(By.xpath("//*[name()='g' and @id='"+connectorid+"']//table//tbody/tr"));
        List<WebElement> tdElements = eleCavityDataRow.findElements(By.cssSelector("td"));
        Assert.assertEquals(tdElements.get(8).getText(),destinationValue);
    }

    public Boolean WireFanVisible(String connectorId) throws InterruptedException {
        Thread.sleep(2000);
        Boolean isWireFanVisible = getElementWireFan(connectorId).size()!=0 && getElementWireFan(connectorId).get(0).isDisplayed();
        return isWireFanVisible;
    }

    public void clickFooterWireFan() {
        driver.findElement(By.id("dropdown_wire_fan")).click();
    }

    public int getCavityRowCount(String identifier) {
        List<WebElement> eleCavityDataRow = driver.findElements(By.xpath("//*[name()='g' and @id='"+identifier+"']//table//tbody/tr"));
        Assert.assertTrue(eleCavityDataRow.size()!=0,"Rowcount inside CavityTable is zero");
        return  eleCavityDataRow.size();
    }

    public void changeConnectorNode(String identifier) throws InterruptedException {
        WebElement ele = getConnectorPlugElement(identifier);
        int xCoordianteBeforeMovement = ele.getLocation().getX();
        System.out.println("x coordinate BeforeMovement is :" + xCoordianteBeforeMovement);
        WebElement destination = driver.findElement(By.xpath("//*[name()='g' and @class ='DG1 bundleGroup']//*[name()='use' and @*[contains(.,'node')]]"));
        int xCoordianteDestinationElement = destination.getLocation().getX();
        Assert.assertNotEquals(xCoordianteBeforeMovement,xCoordianteDestinationElement);
        destination.click();
        Thread.sleep(5000);
        ele = getConnectorPlugElement(identifier);
        customCommand.waitForElementToBeClickable(driver,ele);
        int xCoordianteAfterMovement = ele.getLocation().getX();
        System.out.println("x coordinate after movement is :" + xCoordianteAfterMovement);
        Assert.assertNotEquals(xCoordianteBeforeMovement,xCoordianteAfterMovement);
    }

    public void verifyAutoArrange(String identifier) throws InterruptedException {
        WebElement eleToBeMoved = driver.findElement(By.xpath("//*[name()='g' and @id='"+identifier+"']//table"));
        int xCoordianteBeforeMovement = eleToBeMoved.getLocation().getX();
        System.out.println("x coordinate BeforeMovement is :" + xCoordianteBeforeMovement);
        eleToBeMoved.click();
        Actions actions = new Actions(driver);
        actions.moveByOffset(167,223).click().perform();
        Thread.sleep(3000);
        WebElement eleMoved = driver.findElement(By.xpath("//*[name()='g' and @id='"+identifier+"']//table"));
        int xCoordianteAfterMovement = eleMoved.getLocation().getX();
        System.out.println("x coordinate after movement is :" + xCoordianteAfterMovement);
        clickOnSelect();
        Thread.sleep(2000);
        getContextMenu(identifier);
        performOperation("Auto Arrange",identifier);
        Thread.sleep(5000);
        eleMoved = driver.findElement(By.xpath("//*[name()='g' and @id='"+identifier+"']//table"));
        int xCoordianteAfterAutoArrange = eleMoved.getLocation().getX();
        System.out.println("x coordinate after autoarrange is :" + xCoordianteAfterAutoArrange);
        Assert.assertEquals(xCoordianteAfterAutoArrange, xCoordianteBeforeMovement);
    }


    public void verifyResetLabels(String testDescription, String connectorId) throws InterruptedException {
        WebElement ele = new ConnectorPage(driver).getElementConnectorDescription(connectorId,testDescription);
        WebElement eleToBeMoved = ele.findElement(By.xpath("./.."));
        customCommand.waitForElementToBeClickable(driver,eleToBeMoved);
        int xCoordiante = eleToBeMoved.getLocation().getX();
        int yCoordiante = eleToBeMoved.getLocation().getY();
        System.out.println("x coordinate before movement is :" + xCoordiante);
        System.out.println("Y coordinate before movement is :" + yCoordiante);
        Actions actions = new Actions(driver);
        actions.moveToElement(eleToBeMoved).click().perform();
//        ele.click();
        Thread.sleep(2000);
//        Actions actions = new Actions(driver);
        actions.moveByOffset(167,223).click().perform();
        Thread.sleep(3000);
        ele = new ConnectorPage(driver).getElementConnectorDescription(connectorId,testDescription);
        WebElement eleAfterMove = ele.findElement(By.xpath("./.."));
        System.out.println("x coordinate after movement is :" + eleAfterMove.getLocation().getX());
        System.out.println("Y coordinate after movement is :" + eleAfterMove.getLocation().getY());
        clickOnSelect();
        Thread.sleep(2000);
        getContextMenu(connectorId);
        performOperation("Reset Labels",connectorId);
        Thread.sleep(5000);
        WebElement eleMoved = new ConnectorPage(driver).getElementConnectorDescription(connectorId,testDescription);
        eleMoved = eleMoved.findElement(By.xpath("./.."));
        int xCoordianteAfterResetLabels = eleMoved.getLocation().getX();
        System.out.println("x coordinate after resetlabels is :" + xCoordianteAfterResetLabels);
        Assert.assertEquals(xCoordianteAfterResetLabels, xCoordiante);

    }

    public void verifyWireAdded(String identifier) throws InterruptedException {
        List<WebElement> ele = driver.findElements(By.xpath("//*[name()='g' and @id='"+identifier+"']//table//tbody/tr/td"));
        customCommand.moveToElementAndClick(driver,ele.get(1));
        customCommand.waitForElementVisibility(driver,popUpAddWire);
        customCommand.enterText(inputWireId,"TESTWIRE");
        buttonOkAddWire.click();
        Thread.sleep(2000);
        ele = driver.findElements(By.xpath("//*[name()='g' and @id='"+identifier+"']//table//tbody/tr/td"));
        Assert.assertEquals(ele.get(1).getText(),"TESTWIRE");

    }

    public void verifyWireSwapped(String identifier) throws InterruptedException {
        List<WebElement> ele = driver.findElements(By.xpath("//*[name()='g' and @id='"+identifier+"']//table//tbody/tr/td"));
        customCommand.moveToElementAndClick(driver,ele.get(1));
        Thread.sleep(2000);
        ele = driver.findElements(By.xpath("//*[name()='g' and @id='"+identifier+"']//table//tbody/tr/td"));
        Assert.assertEquals(ele.get(1).getText(),"WIRE001");
    }

    public void verifyWireDeleted(String identifier) {
        List<WebElement> ele = driver.findElements(By.xpath("//*[name()='g' and @id='"+identifier+"']//table//tbody/tr/td"));
        Assert.assertEquals(ele.get(1).getText(),"");
    }

    public void verifyWirePathIsDisplayed() {
        Assert.assertTrue(driver.findElements(By.xpath("//*[name()=\"g\" and @class=\"hilight\"]//*[name()=\"path\" and @nonstroke = \"BLACK\"]")).size()!=0,"WirePath is not displayed");
    }

    public void addPartNumberToSplice() throws InterruptedException {
        customCommand.javaScriptClick(driver,addPartNumber);
        customCommand.javaScriptClick(driver,firstPartFromList);
        customCommand.javaScriptClick(driver,populateButtonParts);
    }

    public void addCavity() throws InterruptedException {
        customCommand.javaScriptClick(driver,addRowCavity);
        customCommand.javaScriptClick(driver,addRowCavity);

    }

    public void addWires() throws InterruptedException {
        String spliceId = new ConnectorPage(driver).getSpliceElementIdsFromDrawingPage().get(Integer.parseInt(String.valueOf(0))).getSpliceId();
        for (WebElement we:connectorTo)
        {
            customCommand.selectDropDownByValue(we,spliceId);
        }
        addWirePartNo();
        selectSpliceSide();
        customCommand.javaScriptClick(driver,updateWirePN);
    }

    public void addWirePartNo() throws InterruptedException {
        for (WebElement we:addWirePartNumber)
        {
            customCommand.javaScriptClick(driver,we);
            for (WebElement od:outerDiameter)
            {
                if(od.getText().contains("0.00"))
                {continue;}
                else{
                    customCommand.javaScriptClick(driver,od);
                    break;
                }
            }
            customCommand.javaScriptClick(driver,populateButtonWire);
        }
    }

    public void selectSpliceSide() throws InterruptedException {
        customCommand.selectDropDownByValue(spliceSide.get(0),"a");
        Thread.sleep(2000);
        customCommand.selectDropDownByValue(spliceSide.get(1),"b");
    }

    public void clickSubmit() {
        try {
            customCommand.javaScriptClick(driver,buttonSubmitDetails);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enterPartNumberForQuickAdd(String partNumber) throws AWTException, InterruptedException {
        customCommand.enterText(inputQuickAddPartNumber,partNumber);
        customCommand.simulateKeyEnter();
        Thread.sleep(4000);
    }

    public int getCountOfConnectors(){
        return connectors.size();
    }

    public void verifyCountOfConnectorsDisplayed(int expectedCountOfConnectors){
        Assert.assertEquals(getCountOfConnectors(),expectedCountOfConnectors);
    }

    public void selectLinkPartComponent(String componentType) {
        driver.findElement(By.xpath("//div[@class=\"ui-dialog-buttonset\"]//button//span[text()=\""+componentType+"\"]")).click();
    }

    public void openConnectorEditor() throws InterruptedException {
        customCommand.scrollIntoView(driver,buttonConnectorEditor);
        customCommand.javaScriptClick(driver,buttonConnectorEditor);
    }
}