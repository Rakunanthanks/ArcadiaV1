package arcadia.pages.ComponentDB.Connectors;

import arcadia.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkSealsPage extends BasePage {
    public LinkSealsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "Link_Seals_termsused") private WebElement tableLinkSealsUsed;
    String selectSealType = "select[name=\"Link_Seals.termsused.SealType\"]";
    String sealsPartNumber = "input[rel=\"partnumber\"]+div input";
    String sealsDescription = "input[rel=\"Desc\"]";
    String sealsolour = "input[rel=\"Colour\"]";
    String sealsWireDia = "input[name=\"Link_Seals.termsused.WireDia\"]";
    String sealsPlug = "input[name=\"Link_Seals.termsused.Plug\"]";
    String sealsCavities = "input[name=\"Link_Seals.termsused.Cavities\"]";
    String buttonExpandSealsUsed = "table#Link_Seals_termsused button.expand";
}
