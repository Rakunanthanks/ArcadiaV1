package arcadia.pages.ComponentDB.Wires;

import arcadia.domainobjects.WiresComponentDB;
import arcadia.pages.BasePage;
import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WiresComponentDBPage extends BasePage {
    public WiresComponentDBPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#grid >.bootstrap-table >.fixed-table-container >.fixed-table-pagination >.pull-left.pagination-detail >.page-list >.btn-group.dropup >button >.caret") private WebElement paginationDropdown;
    @FindBy(css = "#grid >.bootstrap-table >.fixed-table-container >.fixed-table-pagination >.pull-left.pagination-detail >.page-list >.btn-group.dropup >.dropdown-menu>li:last-child >a") private WebElement paginationAll;
    String tableWireRows = "#tblwire > tbody > tr";
    @FindBy(css = "div.fixed-table-header select[class$=\"status\"]") private WebElement selectWireStatus;
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

    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();

    public void getFullPagination() throws InterruptedException {
        Thread.sleep(3000);
        customCommand.scrollIntoView(driver,paginationDropdown);
        paginationDropdown.click();
        customCommand.waitForElementVisibility(driver,paginationAll);
        Thread.sleep(3000);
        paginationAll.click();
        Thread.sleep(3000);
    }

    public List<WiresComponentDB> getWiresData() throws InterruptedException {
        getFullPagination();
        List<WiresComponentDB> componentDbData = new ArrayList<>();
        List<WebElement> componentDbElement = driver.findElements(By.cssSelector(tableWireRows));
        int i = 0;
        for( WebElement element : componentDbElement){
            i++;
            List<WebElement> tdElements = element.findElements(By.cssSelector("td"));
            String partNumber = tdElements.get(1).getText();
            String description= tdElements.get(2).getText();
            String family= tdElements.get(3).getText();
            String status= tdElements.get(5).getText();
            String usage= tdElements.get(6).getText();
            String supplier= tdElements.get(7).getText();
            String supplierPN= tdElements.get(8).getText();
            String colour= tdElements.get(9).getText();
            String awgSize= tdElements.get(10).getText();
            String gauge= tdElements.get(11).getText();
            Double wireCSA= Double.valueOf(tdElements.get(12).getText());
            Double outsideDia= Double.valueOf(tdElements.get(13).getText());
            String material= tdElements.get(14).getText();
            Double minimumRadius= Double.valueOf(tdElements.get(15).getText());
            Double maxcurrent= Double.valueOf(tdElements.get(16).getText());
            Double resistance= Double.valueOf(tdElements.get(17).getText());

            componentDbData.add(new WiresComponentDB(partNumber,description,family,status,usage,supplier,supplierPN,colour,awgSize,gauge,wireCSA,outsideDia,material,minimumRadius,maxcurrent,resistance));
        }
        return componentDbData;
    }

    public void filterWiresBasedOnStatus(String wireStatus) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.selectDropDownByValue(selectWireStatus,wireStatus);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableWireRows)));
    }

    public void filterWiresBasedOnDescription(String description) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldDescription,description);
        Thread.sleep(3000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableWireRows)));
    }

    public void filterWiresBasedOnFamily(String family) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldFamily,family);
        Thread.sleep(3000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableWireRows)));
    }

    public void filterWiresBasedOnUsage(String usage) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.selectDropDownByValue(selectUsage,usage);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableWireRows)));
    }

    public void filterWiresBasedOnSupplier(String supplier) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldSupplier,supplier);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableWireRows)));
    }

    public void filterWiresBasedOnSupplierPN(String supplierPN) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldSupplierPN,supplierPN);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableWireRows)));
    }

    public void filterWiresBasedOnColour(String colour) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.selectDropDownByValue(selectColour,colour);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableWireRows)));
    }

    public void filterWiresBasedOnAwgSize(String awgSize) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldAwgSize,awgSize);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableWireRows)));
    }

    public void filterWiresBasedOnGauge(String gauge) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldGauge,gauge);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableWireRows)));
    }

    public void filterWiresBasedOnWireCSARange(String wireCSARange) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldWireCSA,wireCSARange);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableWireRows)));
    }

    public void filterWiresBasedOnOutsideDiaRange(String outsideDiaRange) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldOutsideDia,outsideDiaRange);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableWireRows)));
    }

    public void filterWiresBasedOnMaterial(String wireMaterial) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldWireMaterial,wireMaterial);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableWireRows)));
    }

    public void filterWiresBasedOnMinimumBendRadiusRange(String minimumBendRadiusRange) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldMinimumBendRadius,minimumBendRadiusRange);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableWireRows)));
    }

    public void filterWiresBasedOnMaxCurrentRange(String maxCurrentRange) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldMaxCurrent,maxCurrentRange);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableWireRows)));
    }

    public void filterWiresBasedOnResistanceRange(String resistanceRange) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldResistance,resistanceRange);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableWireRows)));
    }
}
