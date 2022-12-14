package arcadia.pages.ComponentDB.Connectors;

import arcadia.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddOnsPage extends BasePage {
    public AddOnsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "select#defaultConfig") private WebElement selectDefaultConfig;
    String addOnLinkedPart = "select[name$=\"_addonlinkPart\"]+div input";
    String addOnCavityNamesAB = "input[name$=\"_Add_Ons.termsused.names\"]";
    String addOnKnockOff = "input[name$=\"_Add_Ons.termsused.AddOn\"]";
    String resetButtonAddOn = "button#btnReset";
    @FindBy(css = "input#txtAddOn") private WebElement mmAddKnockOff;
    @FindBy(css = "input#txtApplytoCavs") private WebElement inputApplyAddOnToCavities;
    @FindBy(css = "button#txtApplytoCavsExpand") private WebElement expandApplyAddOnToCavities;
    @FindBy(css = "select#addonConfigApply") private WebElement selectonfigToApply;
    @FindBy(css = "button#btnApply") private WebElement buttonApplyConfig;
    @FindBy(css = "button#loadnewconfig") private WebElement buttonAddNewConfig;
    @FindBy(css = "input[name=\"configName\"]") private WebElement addConfigName;
    @FindBy(css = "input[name=\"configCode\"]") private WebElement addConfigCode;
    @FindBy(css = "input[name=\"configDesc\"]") private WebElement addConfigDescription;
    @FindBy(css = "select[name=\"linkPart\"]+div input") private WebElement selectLinkPartConfig;
    @FindBy(css = "form#addConfigdetails button.close") private WebElement closeButtonAddConfig;
}
