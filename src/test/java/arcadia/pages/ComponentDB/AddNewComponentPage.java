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
    @FindBy(css = "input[name=\"family\"]") private WebElement componentFamily;
    @FindBy(css = "select[name=\"typecode\"]") private WebElement componentTypeCode;
    @FindBy(css = "select[name=\"proprietary\"]") private WebElement componentProprietary;
    @FindBy(css = "select[name=\"groupname\"]") private WebElement componentPartType;
    @FindBy(css = "select[name=\"colour\"]") private WebElement componentColour;
    @FindBy(css = "select[name=\"status\"]") private WebElement componentStatus;
    @FindBy(css = "select[name=\"materialcode\"]") private WebElement componentMaterialCode;
    @FindBy(css = "select[name=\"usage\"]") private WebElement componentUsage;
    @FindBy(css = "input[name=\"groupcategory\"]") private WebElement componentPartCategory;
    @FindBy(css = "input[name=\"addrefs.Partnumber\"]") private WebElement referencesPartNumber;
    @FindBy(css = "input[name=\"addrefs.Type\"]") private WebElement referencesType;
    @FindBy(css = "input[name=\"addrefs.Company\"]") private WebElement referencesCompany;
    @FindBy(css = "input[name=\"price\"]") private WebElement bomPrice;
    @FindBy(css = "input[name=\"weight\"]") private WebElement bomWeight;
    @FindBy(css = "select[name=\"eachorpm\"]") private WebElement bomMeasure;
    @FindBy(css = "select[name=\"currency\"]") private WebElement bomCurrency;
    @FindBy(css = "select[name=\"units\"]") private WebElement bomUnits;
    @FindBy(css = "select[name=\"excludebom\"]") private WebElement bomBillType;
    @FindBy(id = "btnReset") private WebElement resetButton;
    @FindBy(css = "button[value=\"Create New Component\"]") private WebElement createNewComponent;
    @FindBy(id = "idMsg") private WebElement alertSuccessMessage;
}