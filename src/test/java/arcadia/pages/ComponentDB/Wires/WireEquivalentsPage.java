package arcadia.pages.ComponentDB.Wires;

import arcadia.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WireEquivalentsPage extends BasePage {
    public WireEquivalentsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "table#Equivalents_termsused") private WebElement tableEquivalentHalves;
    String equivalentHalvesPartNumber = "input[rel=\"partnumber\"]+div input";
    String equivalentDescription = "input[rel=\"Desc\"]";
    String equivalentColour = "input[rel=\"Colour\"]";
    String equivalentFamily = "input[rel=\"Family\"]";
    String equivalentMaterial = "input[rel=\"Material\"]";
    String equivalentOutsideDia = "input[rel=\"OutsideDia\"]";
    String equivalentCsa = "input[rel=\"CSA\"]";
    String equivalentAwg = "input[rel=\"AWG\"]";
}
