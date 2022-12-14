package arcadia.pages.ComponentDB.Connectors;

import arcadia.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NwfPage extends BasePage {
    public NwfPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "NWF_termsused") private WebElement tableCavityNwf;
    @FindBy(css = "input[rel=\"Cavity\"][title=\"A\"]") private WebElement cavityA;
    @FindBy(css = "input[rel=\"Cavity\"][title=\"B\"]") private WebElement cavityB;
    @FindBy(css = "input[name=\"NWF.termsused.nwf\"][title=\"A\"]") private WebElement NwfA;
    @FindBy(css = "input[name=\"NWF.termsused.nwf\"][title=\"B\"]") private WebElement NwfB;
    String resetButtonNwf = "button#btnReset";
    @FindBy(css = "input#txtNWF") private WebElement inputNwf;
    @FindBy(css = "input#txtApplytoCavs") private WebElement inputApplyNwfToCavities;
    @FindBy(css = "button#txtApplytoCavsExpand") private WebElement expandApplyNwfToCavities;
    @FindBy(css = "button#btnApply") private WebElement buttonApplyNwf;
    @FindBy(id = "NWF.termsused.modelname") private WebElement defaultModelName;
}
