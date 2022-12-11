package arcadia.pages;

import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class SearchWirePage extends BasePage{
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    @FindBy(xpath = "//span[contains(text(),\"Populate\")]") private WebElement populate;
    @FindBy(css = "input[name=\"nPartNumber\"]") private WebElement pnDescription;

    public SearchWirePage(WebDriver driver) {
        super(driver);
    }

    public void findInSearchWire(String description){
        customCommand.simulateKeyEnterWithValue(pnDescription,description);
    }
    public  void populateWire() throws InterruptedException{
        Thread.sleep(2000);
        WebElement d = driver.findElement(By.id("idFetchwiretable"));
        Actions actions = new Actions(driver);
        actions.moveToElement(d).moveByOffset(20,30).doubleClick().build().perform();
        Thread.sleep(2000);
        driver.findElement(By.id("idFetchwiretable")).click();
        WebElement element = driver.findElement(By.cssSelector("#tblWirePartNoList >tbody >.active"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", element);
        jse.executeScript("arguments[0].dispatchEvent(new MouseEvent('dblclick', { bubbles: true }));", element);
    }
}
