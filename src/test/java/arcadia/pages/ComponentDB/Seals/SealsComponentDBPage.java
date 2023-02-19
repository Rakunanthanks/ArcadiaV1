package arcadia.pages.ComponentDB.Seals;

import arcadia.domainobjects.MulticoreComponentDB;
import arcadia.domainobjects.SealsComponentDB;
import arcadia.domainobjects.SealsComponentDB;
import arcadia.pages.BasePage;
import arcadia.utils.SeleniumCustomCommand;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SealsComponentDBPage extends BasePage {
    public SealsComponentDBPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#grid >.bootstrap-table >.fixed-table-container >.fixed-table-pagination >.pull-left.pagination-detail >.page-list >.btn-group.dropup >button >.caret") private WebElement paginationDropdown;
    @FindBy(css = "#grid >.bootstrap-table >.fixed-table-container >.fixed-table-pagination >.pull-left.pagination-detail >.page-list >.btn-group.dropup >.dropdown-menu>li:last-child >a") private WebElement paginationAll;
    String tableSealRows = "#tblseal > tbody > tr";
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Part Number\"]") private WebElement searchFieldPartNumber;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Description\"]") private WebElement searchFieldDescription;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Family\"]") private WebElement searchFieldFamily;
    @FindBy(css = "div.fixed-table-header select[class$=\"groupname\"]") private WebElement selectGroupName;
    @FindBy(css = "div.fixed-table-header select[class$=\"status\"]") private WebElement selectStatus;
    @FindBy(css = "div.fixed-table-header select[class$=\"usage\"]") private WebElement selectUsage;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Supplier\"]") private WebElement searchFieldSupplier;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Supplier PN\"]") private WebElement searchFieldSupplierPN;
    @FindBy(css = "div.fixed-table-header select[class$=\"colour\"]") private WebElement selectColour;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Cavity Plug\"]") private WebElement selectCavityPlug;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Insulation OD\"]") private WebElement selectInsulationOD;


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

    public List<SealsComponentDB> getSealAPIData(String jsonValue) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonValue);
        jsonValue=jsonNode.get("rows").toString();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        List<SealsComponentDB> dbData = objectMapper.readValue(jsonValue, new TypeReference<List<SealsComponentDB>>(){});
        return dbData;
    }

    public List<SealsComponentDB> getSealData() throws InterruptedException {
        getFullPagination();
        List<SealsComponentDB> componentDbData = new ArrayList<>();
        List<WebElement> componentDbElement = driver.findElements(By.cssSelector(tableSealRows));
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
            String cavity= (tdElements.get(10).getText());
            String insulationOD= (tdElements.get(11).getText());
            componentDbData.add(new SealsComponentDB(partNumber,description,family,status,usage,supplier,supplierPN,colour,cavity,insulationOD));
        }
        return componentDbData;
    }

    public void filterSealsBasedOnPartNumber(String partNumber) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldPartNumber,partNumber);
        Thread.sleep(3000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableSealRows)));
    }

    public void filterSealsBasedOnDescription(String description) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldDescription,description);
        Thread.sleep(3000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableSealRows)));
    }

    public void filterSealsBasedOnFamily(String family) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldFamily,family);
        Thread.sleep(3000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableSealRows)));
    }

    public void filterSealsBasedOnUsage(String usage) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.selectDropDownByValue(selectUsage,usage);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableSealRows)));
    }

    public void filterSealsBasedOnSupplier(String supplier) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldSupplier,supplier);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableSealRows)));
    }

    public void filterSealsBasedOnSupplierPN(String supplierPN) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldSupplierPN,supplierPN);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableSealRows)));
    }

    public void filterSealsBasedOnColour(String colour) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.selectDropDownByValue(selectColour,colour);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableSealRows)));
    }

    public SealsComponentDB getRandomSealsComponent(List<SealsComponentDB> SealsComponentDBList){
        Random rand = new Random();
        return SealsComponentDBList
                .get(rand.nextInt(SealsComponentDBList.size()));
    }
}
