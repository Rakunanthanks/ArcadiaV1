package arcadia.pages;
import arcadia.utils.SeleniumCustomCommand;
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
    @FindBy(xpath = "//div[@id='appContextMenu']/li") private  List<WebElement> operations;
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

    public void getContextMenu(String id)
    {
        WebElement ele=driver.findElement(By.xpath("//*[name()='g' and @id='"+id+"']/*[name()='rect']"));
       customCommand.rightClick(driver,ele);
    }

    public void performOperation(String operation,String id) throws InterruptedException {
        String xpathOfConnector="//*[name()='g' and @id='"+id+"']/*[name()='rect']";
        List<WebElement> connectors;
        boolean flag=false;
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

}