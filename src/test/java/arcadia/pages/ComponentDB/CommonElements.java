package arcadia.pages.ComponentDB;

import arcadia.pages.BasePage;
import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonElements extends BasePage {
    public CommonElements(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "idaddrow") WebElement buttonAddRow;
    @FindBy(id = "loadDataDb") WebElement buttonLoadDataDB;
    @FindBy(css = "button[value=\"Update Component\"]") WebElement updateComponent;
    String buttonMoveUp = "button[title=\"Move Up\"]";
    String buttonMoveDown = "button[title=\"Move Down\"]";
    String buttonDelete = "button[title=\"Delete\"]";
    @FindBy(id = "btnReset") WebElement resetButton;

    @FindBy(css = "table input[name=\"btSelectItem\"]") private WebElement checkboxfirstComponent;

    @FindBy(css = "input[name=\"addsimilar.NewPN\"]") private WebElement referencesNewPartNumber;

    @FindBy(css = "button[value^=\"Add Similar\"][name=\"confirmadd\"]") private WebElement buttonConfirmAddSimilar;

    @FindBy(css = "div.fixed-table-header input[placeholder=\"Part Number\"]") private WebElement searchFieldPartNumber;

    @FindBy(css = "#grid >.bootstrap-table >.fixed-table-container >.fixed-table-pagination >.pull-left.pagination-detail >.page-list >.btn-group.dropup >button >.caret") private WebElement paginationDropdown;
    @FindBy(css = "#grid >.bootstrap-table >.fixed-table-container >.fixed-table-pagination >.pull-left.pagination-detail >.page-list >.btn-group.dropup >.dropdown-menu>li:last-child >a") private WebElement paginationAll;

    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    public void selectFirstComponent(){
        checkboxfirstComponent.click();
    }

    public void enterNewPartNumber(String newPartNumber){
        customCommand.waitForElementVisibility(driver,referencesNewPartNumber);
        customCommand.enterText(referencesNewPartNumber,newPartNumber);
    }

    public void clickAddSimilarOnPopup(){
        buttonConfirmAddSimilar.click();
    }

    public void filterComponentBasedOnPartNumber(String partNumber) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.waitForElementToBeClickable(driver,searchFieldPartNumber);
        customCommand.simulateKeyEnterWithValue(searchFieldPartNumber,partNumber);
        Thread.sleep(3000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void getFullPagination() throws InterruptedException {
        Thread.sleep(3000);
        customCommand.scrollIntoView(driver,paginationDropdown);
        paginationDropdown.click();
        customCommand.waitForElementVisibility(driver,paginationAll);
        Thread.sleep(3000);
        paginationAll.click();
        Thread.sleep(3000);
    }

}
