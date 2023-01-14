package arcadia.pages;
import arcadia.pages.ComponentDB.AddNewComponentPage;
import arcadia.utils.SeleniumCustomCommand;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.List;


public class HarnessPage extends BasePage{
    @FindBy(id = "commandline") private WebElement commandLine;
    @FindBy(css = "button[title=\"OK\"]") private WebElement commandOK;
    @FindBy(css = "div[title=\"Insert Connector\"]") private WebElement insertConnector;
    @FindBy(id = "ifreebundle") private WebElement bundle;
    @FindBy(id = "izoom_in") private WebElement zoomIn;
    @FindBy(id = "idrawcom") private WebElement select;
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

    public WebElement getConnectorPlugElement(String connectorPlugId){
        WebElement ele = driver.findElement(By.cssSelector("g#"+connectorPlugId+">rect[etype='connector']"));
        return ele;
    }

    public WebElement getHarnessElement(String description){
        WebElement ele = driver.findElement(By.xpath("//table[@id=\"tableHAR\"]/tbody//tr//td[text()=\""+description+"\"]"));
        return ele;
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
    public void selectHeader(String headerName){
        WebElement ele = getHeaderElement(headerName);
        customCommand.waitForElementToBeClickable(driver,ele);
        ele.click();
    }

    public void clickVisibility() throws InterruptedException {
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

}