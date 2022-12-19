package arcadia.pages.ComponentDB;

import arcadia.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class HeaderPanel extends BasePage {
    public HeaderPanel(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "button[value=\"Add New Component\"]") private WebElement addNewComponent;
    @FindBy(id = "btnImport") private WebElement importCsv;
    @FindBy(id = "idexport") private WebElement exportCsv;
    @FindBy(id = "dataexport") private WebElement exportData;
    @FindBy(id = "customExport") private WebElement exportCustomFields;
    @FindBy(id = "btnaddsimilar") private WebElement addSimilar;
    @FindBy(id = "btnmove") private WebElement btnCopy;
    @FindBy(id = "btnDelete") private WebElement btnHeaderDelete;
    @FindBy(css = "select[name=\"company\"]") private WebElement selectBoxCompany;
    //SearchbarFilters
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Part Number\"]") private WebElement searchFieldPartNumber;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Description\"]") private WebElement searchFieldDescription;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Family\"]") private WebElement searchFieldFamily;
    @FindBy(css = "div.fixed-table-header select[class$=\"groupname\"]") private WebElement selectGroupName;
    @FindBy(css = "div.fixed-table-header select[class$=\"status\"]") private WebElement selectStatus;
    @FindBy(css = "div.fixed-table-header select[class$=\"usage\"]") private WebElement selectUsage;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Supplier\"]") private WebElement searchFieldSupplier;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Supplier PN\"]") private WebElement searchFieldSupplierPN;
    @FindBy(css = "div.fixed-table-header select[class$=\"colour\"]") private WebElement selectColour;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"AWG Size\"]") private WebElement searchFieldAwgSize;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Gauge\"]") private WebElement searchFieldGauge;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Wire CSA\"]") private WebElement searchFieldWireCSA;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Outside Dia\"]") private WebElement searchFieldOutsideDia;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Wire Material\"]") private WebElement searchFieldWireMaterial;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Minimum Bend Radius\"]") private WebElement searchFieldMinimumBendRadius;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Max Current\"]") private WebElement searchFieldMaxCurrent;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Resistance\"]") private WebElement searchFieldResistance;


    public void openAddNewComponentPage() throws InterruptedException {
        Thread.sleep(3000);
        addNewComponent.click();
        Thread.sleep(3000);
    }

    public void invokeMainMenu(String menuName){
        List<WebElement> maninMenuElements = driver.findElements(By.cssSelector(".nav.navbar-nav.pull-right >li >a"));
        for(WebElement element : maninMenuElements){
            if(element.getAttribute("href").contains(menuName)){
                element.click();
                break;
            }
        }
    }

}
