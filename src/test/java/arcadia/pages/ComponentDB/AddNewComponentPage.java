package arcadia.pages.ComponentDB;

import arcadia.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewComponentPage extends BasePage {
    public AddNewComponentPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "input[name=\"description\"]") private WebElement componentDeccription;
    @FindBy(css = "div#idDetails [name=\"family\"]+div input") private WebElement componentFamily;
    @FindBy(css = "select[name=\"typecode\"]") private WebElement componentTypeCode;
    @FindBy(css = "select[name=\"proprietary\"]+div input") private WebElement componentProprietary;
    @FindBy(css = "select[name=\"groupname\"]") private WebElement componentPartType;
    String componentColour = "select[name=\"colour\"]";
    @FindBy(css = "select[name=\"status\"]") private WebElement componentStatus;
    @FindBy(css = "select[name=\"materialcode\"]") private WebElement componentMaterialCode;
    @FindBy(css = "select[name=\"usage\"]") private WebElement componentUsage;
    @FindBy(css = "input[type=\"text\"][name=\"groupcategory\"]") private WebElement componentPartCategory;
    String  referencesPartNumber = "input[name=\"addrefs.Partnumber\"]";
    String  referencesType = "[name=\"addrefs.Type\"]";
    String  referencesCompany = "input[name=\"addrefs.Company\"]";
    @FindBy(css = "input[name=\"price\"]") private WebElement bomPrice;
    @FindBy(css = "input[name=\"weight\"]") private WebElement bomWeight;
    @FindBy(css = "select[name=\"eachorpm\"]") private WebElement bomMeasure;
    @FindBy(css = "select[name=\"currency\"]") private WebElement bomCurrency;
    @FindBy(css = "select[name=\"units\"]") private WebElement bomUnits;
    @FindBy(css = "select[name=\"excludebom\"]") private WebElement bomBillType;
    @FindBy(css = "button[value=\"Create New Component\"]") private WebElement createNewComponent;
    @FindBy(id = "idMsg") private WebElement alertSuccessMessage;
    @FindBy(css = "button[value=\"Delete Component\"]") private WebElement deleteComponent;
    @FindBy(css = "div#addnewcompmodal button.close") private WebElement buttonCloseAddModal;
}