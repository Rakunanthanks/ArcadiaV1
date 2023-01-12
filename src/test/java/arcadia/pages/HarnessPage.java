package arcadia.pages;
import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;


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


    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    public HarnessPage(WebDriver driver) {
        super(driver);
    }
    public  void waitForDrawingPage(){
        customCommand.waitForElementToBeClickable(driver,bundle);
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

    public void selectHeader(String headerName){
        driver.findElement(By.xpath("//div[@id=\"ribbon-tab-header-strip\"]//span[text()=\""+headerName+"\"]")).click();
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
    }

    public void clickConnectorPlug(String ConnectorPlugId){
        WebElement ele = driver.findElement(By.cssSelector("g#"+ConnectorPlugId+">rect[etype='connector']"));
        customCommand.waitForElementVisibility(driver,ele);
        customCommand.doubleClick(driver,ele);
        System.out.println("Here we go");
    }

}