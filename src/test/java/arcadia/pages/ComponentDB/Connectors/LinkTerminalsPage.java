package arcadia.pages.ComponentDB.Connectors;

import arcadia.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkTerminalsPage extends BasePage {
    public LinkTerminalsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "table#Link_Terminals_termsused") private WebElement tableTerminalsUsed;
    String terminalsPartNumber = "input[rel=\"partnumber\"]+div input";
    String terminalsDescription = "input[rel=\"Desc\"]";
    String terminalsWireCsa = "input[rel=\"WireCSA\"]";
    String terminalsWireOd = "input[rel=\"WireINS\"]";
    String terminalsFinish = "input[rel=\"Finish\"]";
    String terminalsCavities = "input[name=\"Link_Terminals.termsused.Cavities\"]";
    String buttonExpandTerminalsUsed = "table#Link_Terminals_termsused button.expand";
}
