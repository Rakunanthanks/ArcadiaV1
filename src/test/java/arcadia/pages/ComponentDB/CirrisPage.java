package arcadia.pages.ComponentDB;

import arcadia.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CirrisPage extends BasePage {
    public CirrisPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "table#Cirris_termsused") private WebElement tableCirris;
    @FindBy(css = "input[name=\"Cirris.termsused.CirrisCavity\"][title=\"A\"]") private WebElement cirisCavityA;
    @FindBy(css = "input[name=\"Cirris.termsused.CirrisCavity\"][title=\"B\"]") private WebElement cirisCavityB;
    @FindBy(css = "input[name=\"Cirris.termsused.CirrisCavity\"][title=\"1\"]") private WebElement cirisCavity1;
    String cirrisX = "input[name=\"Cirris.termsused.cirrisX\"]";
    String cirrisY = "input[name=\"Cirris.termsused.cirrisY\"]";
    @FindBy(css = "input[name=\"Cirris.termsused.imagewidth\"]") private WebElement cirisImageWidth;
    @FindBy(css = "input[name=\"Cirris.termsused.imageheight\"]") private WebElement cirisImageHeight;
}
