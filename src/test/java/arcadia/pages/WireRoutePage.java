package arcadia.pages;

import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WireRoutePage extends BasePage {
    public WireRoutePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "input[name=\"Yes\"]") private WebElement wireRouteYes;
    @FindBy(css = "input[name=\"No\"]") private WebElement wireRouteNo;
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();

    public void updateWireRoute(boolean update) throws InterruptedException {
        if(update){
            customCommand.waitClick(wireRouteYes);
        }
        if(!update){
            customCommand.waitClick(wireRouteNo);
        }
        Thread.sleep(2000);
    }


}

