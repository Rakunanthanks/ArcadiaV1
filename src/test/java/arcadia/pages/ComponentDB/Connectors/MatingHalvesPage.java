package arcadia.pages.ComponentDB.Connectors;

import arcadia.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MatingHalvesPage extends BasePage {
    public MatingHalvesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "Mating_Halves_termsused") private WebElement tableMatingHalves;
    String matingHalvesPartNumber = "input[rel=\"partnumber\"]+div input";
    String matingDescription = "input[rel=\"Desc\"]";
    String matingColour = "input[rel=\"Colour\"]";
    String matingHousingGender = "input[rel=\"housingGender\"]";
    String matingTerminalGender = "input[rel=\"TermGender\"]";
    String matingCavities = "input[rel=\"Cavities\"]";
}
