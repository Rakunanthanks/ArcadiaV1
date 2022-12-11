package arcadia.pages;

import arcadia.context.FlowContext;
import arcadia.domainobjects.HarnessBundleDisplay;
import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HarnessBundleDisplayPage extends BasePage{
    public HarnessBundleDisplayPage(WebDriver driver) {
        super(driver);
    }
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();

    public void captureDefaultHarnessBundleValues(){
        List<WebElement> gridCavityTableList = driver.findElements(By.cssSelector("#GRIDcavitytable >tbody >tr"));
        for(WebElement item : gridCavityTableList){
            List<WebElement> tdElements = item.findElements(By.tagName("td"));
            String coveringType = tdElements.get(0).findElement(By.tagName("span")).getText();
            String diameterAddon = tdElements.get(1).findElement(By.cssSelector("select >option[selected=\"selected\"]")).getAttribute("value");
            String diameterScales = tdElements.get(2).findElement(By.cssSelector("select >option[selected=\"selected\"]")).getAttribute("value");
            FlowContext.defaultBundleDisplay.add(new HarnessBundleDisplay(coveringType,Double.parseDouble(diameterAddon),Double.parseDouble(diameterScales)));
        }
    }
}
