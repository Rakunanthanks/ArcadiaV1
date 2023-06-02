package arcadia.pages;

import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormboardPage extends BasePage{
    @FindBy(css = "div[title=\"Label Visibility\"]>span") private WebElement buttonVisibility;
    @FindBy(css = "input#nodeshow") private WebElement buttonShowNode;
    public FormboardPage (WebDriver driver) {
        super(driver);
    }
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    public WebElement getHeaderElement(String headerName) throws InterruptedException {
        Thread.sleep(3000);
        WebElement ele = driver.findElement(By.xpath("//div[@id=\"ribbon-tab-header-strip\"]//span[text()=\""+headerName+"\"]"));
        return ele;
    }
    public void selectHeader(String headerName) throws InterruptedException {
        WebElement ele = getHeaderElement(headerName);
        customCommand.waitForElementVisibility(driver,ele);
        customCommand.waitForElementToBeClickable(driver,ele);
        customCommand.waitClick(ele);
    }
}
