package arcadia.pages;
import arcadia.pages.ComponentDB.AddNewComponentPage;
import arcadia.stepdefinations.HarnessStepDefinitions;
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

    public Boolean isHarnessAlreadyExists(String description){
        Boolean elementExists = driver.findElements(By.xpath("//table[@id=\"tableHAR\"]/tbody//tr//td[text()=\"" + description + "\"]")).size()!=0;
        return elementExists ;
    }

    public void clickOnBundle() throws AWTException, InterruptedException {
        customCommand.waitForElementVisibility(driver,insertConnector);
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
        System.out.println("bundle - " + command+"bundle");
        commandLine.clear();
        customCommand.enterText(commandLine,command);
    }

    public void clickOnCommandLineOK() throws InterruptedException {
        customCommand.waitClick(commandOK);
//        commandOK.click();
    }


    public void clickOnConnector() throws InterruptedException {
        customCommand.waitClick(insertConnector);
        insertConnector.click();
    }

    public void clickOnSelect() throws InterruptedException {
        customCommand.waitClick(select);
    }

    public void clickOnFrame() throws InterruptedException {
        customCommand.waitClick(frame);
    }

    public void clickOnOpen() throws InterruptedException {
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
    }

    public void performOperation(String operation,String id) throws InterruptedException {
        ExtentCucumberAdapter.addTestStepLog(String.format("Performing %s operation on connector with connector id = %s", operation,id));
        String xpathOfConnector="//*[name()='g' and @id='"+id+"']/*[name()='rect']";
        List<WebElement> connectors;
        boolean flag=false;
        if(operations.size()==0)
        {
            ExtentCucumberAdapter.addTestStepLog(String.format("Not able to get all the operations allowed on connector"));
        }
        for(WebElement ele:operations)
        {
            if(ele.getText().equalsIgnoreCase(operation.toString()))
            {
                ele.click();
                Thread.sleep(2000);
                connectors=driver.findElements(By.xpath(xpathOfConnector));
                if(connectors.size()==0)
                {
                flag=true;}
                break;
            }
        }
        if(flag==false)
        {
            System.out.println("Operation "+operation+" not found");
        }else{
            System.out.println("Connector is "+operation+"ed");
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

    public void deleteHarness(String description){
        driver.findElement(By.xpath("//table[@id=\"tableHAR\"]/tbody//tr//td[text()=\""+description+"\"]/following-sibling::td[last()]//a[@title=\"Delete Task\"]")).click();
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

//    public void clickConnectorDescriptionElement(String testDescription, String connectorId) throws InterruptedException {
//        WebElement ele = new ConnectorPage(driver).getElementConnectorDescription(connectorId,testDescription);
//        customCommand.waitForElementToBeClickable(driver,ele);
//        int xCoordiante = ele.getLocation().getX();
//        int yCoordiante = ele.getLocation().getY();
//        System.out.println("x coordinate is :" + xCoordiante);
//        System.out.println("Y coordinate is :" + yCoordiante);
//        xCoordiante = xCoordiante + 20;
//        yCoordiante = yCoordiante + 20;
//        Actions actions = new Actions(driver);
//        actions.moveToElement(ele).clickAndHold(ele).moveByOffset(50,50).release().build().perform();
////        actions.dragAndDropBy(ele,xCoordiante, yCoordiante).perform();
//        System.out.println("x coordinate after movement is :" + ele.getLocation().getX());
//        System.out.println("Y coordinate after movement is :" + ele.getLocation().getY());
//    }
}