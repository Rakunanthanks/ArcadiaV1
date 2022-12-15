package arcadia.pages.ComponentDB.Terminals;

import arcadia.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TerminalEquivalentsPage extends BasePage {
    public TerminalEquivalentsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "table#Equivalents_termsused") private WebElement tableEquivalentHalves;
    String equivalentHalvesPartNumber = "input[rel=\"partnumber\"]+div input";
    String equivalentDescription = "input[rel=\"Desc\"]";
    String equivalentColour = "input[rel=\"Colour\"]";
    String equivalentFamily = "input[rel=\"Family\"]";
    String equivalentTermGender = "input[rel=\"TermGender\"]";
    String equivalentStripLength = "input[rel=\"StripLength\"]";
    String equivalentThreadDia = "input[rel=\"ThreadDia\"]";
    String equivalentWireIns = "input[rel=\"WireInsOD\"]";
    String equivalentWireCsa = "input[rel=\"WireCSA\"]";
}
