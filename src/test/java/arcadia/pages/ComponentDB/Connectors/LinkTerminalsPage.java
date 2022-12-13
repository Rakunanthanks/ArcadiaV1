package arcadia.pages.ComponentDB.Connectors;

import arcadia.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkTerminalsPage extends BasePage {
    public LinkTerminalsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "Link_Terminals_termsused") private WebElement tableTerminalsUsed;
    @FindBy(css = "input[rel=\"partnumber\"]+div input") private WebElement terminalsPartNumber;
    @FindBy(css = "input[rel=\"WireCSA\"]") private WebElement terminalsWireCsa;
    @FindBy(css = "input[rel=\"WireINS\"]") private WebElement terminalsWireOd;
    @FindBy(css = "input[rel=\"Finish\"]") private WebElement terminalsFinish;
    @FindBy(css = "input[name=\"Link_Terminals.termsused.Cavities\"]") private WebElement terminalsCavities;
    @FindBy(id = "idaddrow") private WebElement terminalsAddRow;
    @FindBy(id = "loadDataDb") private WebElement terminalsLoadDataDB;
}
