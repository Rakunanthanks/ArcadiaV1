package arcadia.pages.ComponentDB.Connectors;

import arcadia.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkPartsPage extends BasePage {
    public LinkPartsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "Link_Parts_termsused") private WebElement tablePartsUsed;
    String partsUsedPartNumber = "input[rel=\"partnumber\"]+div input";
    String partsDescription = "input[rel=\"Desc\"]";
    String partsColour = "input[rel=\"Colour\"]";
    String partsQuantity = "input[name=\"Link_Parts.termsused.Qty\"]";
    String partsMeasure = "input[rel=\"Measure\"]";
    String partsRequirement = "select[name=\"Link_Parts.termsused.Requirement\"]";
}
