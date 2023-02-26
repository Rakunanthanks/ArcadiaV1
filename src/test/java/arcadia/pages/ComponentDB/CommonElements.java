package arcadia.pages.ComponentDB;

import arcadia.pages.BasePage;
import arcadia.utils.SeleniumCustomCommand;
import org.apache.tools.ant.types.resources.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.python.antlr.ast.Str;

import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class CommonElements extends BasePage {
    public CommonElements(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "idaddrow")
    WebElement buttonAddRow;
    @FindBy(id = "loadDataDb")
    WebElement buttonLoadDataDB;
    @FindBy(css = "button[value=\"Update Component\"]")
    WebElement updateComponent;
    String buttonMoveUp = "button[title=\"Move Up\"]";
    String buttonMoveDown = "button[title=\"Move Down\"]";
    String buttonDelete = "button[title=\"Delete\"]";
    @FindBy(id = "btnReset")
    WebElement resetButton;
    @FindBy(css = "table input[name=\"btSelectItem\"]")
    private WebElement checkboxfirstComponent;
    @FindBy(css = "table button[title=\"Edit\"]>i.fa-edit")
    private WebElement buttonEditFirstComponent;
    @FindBy(css = "input[name=\"addsimilar.NewPN\"]")
    private WebElement referencesNewPartNumber;
    @FindBy(css = "button[value^=\"Add Similar\"][name=\"confirmadd\"]")
    private WebElement buttonConfirmAddSimilar;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Part Number\"]")
    private WebElement searchFieldPartNumber;
    @FindBy(css = "#grid >.bootstrap-table >.fixed-table-container >.fixed-table-pagination >.pull-left.pagination-detail >.page-list >.btn-group.dropup >button >.caret")
    private WebElement paginationDropdown;
    @FindBy(css = "#grid >.bootstrap-table >.fixed-table-container >.fixed-table-pagination >.pull-left.pagination-detail >.page-list >.btn-group.dropup >.dropdown-menu>li:last-child >a")
    private WebElement paginationAll;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Description\"]")
    private WebElement searchFieldDescription;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Family\"]")
    private WebElement searchFieldFamily;
    @FindBy(css = "div.fixed-table-header select[class$=\"groupname\"]")
    private WebElement selectGroupName;
    @FindBy(css = "div.fixed-table-header select[class$=\"status\"]")
    private WebElement selectStatus;
    @FindBy(css = "div.fixed-table-header select[class$=\"usage\"]")
    private WebElement selectUsage;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Supplier\"]")
    private WebElement searchFieldSupplier;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Supplier PN\"]")
    private WebElement searchFieldSupplierPN;
    @FindBy(css = "div.fixed-table-header select[class$=\"colour\"]")
    private WebElement selectColour;
    @FindBy(css = "div.fixed-table-header select[class$=\"gender\"]")
    private WebElement selectGender;
    @FindBy(css = "div.fixed-table-header select[class$=\"sealingtype\"]")
    private WebElement selectSealingType;
    @FindBy(css = "div.fixed-table-header select[class$=\"control-type\"]")
    private WebElement selectControlType;
    @FindBy(css = "div.fixed-table-header select[class$=\"cabletype\"]")
    private WebElement selectCableType;
    @FindBy(css = "div.fixed-table-header select[class$=\"applicatorusage\"]")
    private WebElement selectApplicatorUsage;
    @FindBy(css = "div.fixed-table-header select[class$=\"forsealorterminal\"]")
    private WebElement selectSealOrTerminal;
    @FindBy(css = "div.fixed-table-header select[class$=\"inservice\"]")
    private WebElement selectInService;
    @FindBy(css = "div.fixed-table-header select[class$=\"housingGender\"]")
    private WebElement selectHousingGender;
    @FindBy(css = "div.fixed-table-header select[class$=\"ttype\"]")
    private WebElement selectConnectorType;
    @FindBy(css = "div.fixed-table-header input[placeholder$=\"Type\"]")
    private WebElement searchFieldType;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"AWG Size\"]")
    private WebElement searchFieldAwgSize;
    @FindBy(css = "div.fixed-table-header input[placeholder='Insulation OD']")
    private WebElement searchFieldInsulationOD;
    @FindBy(css = "div.fixed-table-header input[placeholder='Cavity Plug']")
    private WebElement searchFieldCavity;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Gauge\"]")
    private WebElement searchFieldGauge;
    @FindBy(css = "div.fixed-table-header input[placeholder$=\"CSA\"]")
    private WebElement searchFieldCSA;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Outside Dia\"]")
    private WebElement searchFieldOutsideDia;
    @FindBy(css = "div.fixed-table-header input[placeholder$=\"Material\"]")
    private WebElement searchFieldMaterial;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Minimum Bend Radius\"]")
    private WebElement searchFieldMinimumBendRadius;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Max Current\"]")
    private WebElement searchFieldMaxCurrent;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Resistance\"]")
    private WebElement searchFieldResistance;
    @FindBy(css = "div.fixed-table-header input[placeholder$=\"No. of Wires\"]")
    private WebElement searchFieldNumberOfWires;
    @FindBy(css = "div.fixed-table-header input[placeholder$=\"Applicator Site\"]")
    private WebElement searchFieldApplicatorSite;
    @FindBy(css = "div.fixed-table-header input[placeholder$=\"No. of Cavities\"]")
    private WebElement searchFieldNumberOfCavities;
    @FindBy(css = "div.fixed-table-header input[placeholder$=\"Keyway\"]")
    private WebElement searchFieldKeyway;
    @FindBy(css = "input[rel=\"partnumber\"]+div input")
    private WebElement linkPartNumber;
    @FindBy(css = "#idMsg.alert-success")
    private WebElement alertSuccessMessage;
    @FindBy(xpath = "//input[@name='Cavity_Seal.cavityplug']/following-sibling::div/div/input")
    private WebElement cavityPlugInput;
    @FindBy(xpath = "//input[@name='Tags.termsused.Tag']/following-sibling::div/div/input")
    private WebElement tagInput;
    @FindBy(xpath = "//input[@name='Cavity_Seal.cavityplug']/following-sibling::div/div/div/div[1]")
    private WebElement selectFirstCavity;
    @FindBy(xpath = "//input[@name='Cavity_Seal.wireinsfrom']")
    private WebElement wireinsfrom;
    @FindBy(xpath = "//input[@name='Cavity_Seal.wireinsto']")
    private WebElement wireinsto;
    @FindBy(xpath = "//button[@id='loadDataDb']")
    private WebElement loadDBButton;
    @FindBy(xpath = "//table[contains(@id,'termsavail')]/tbody//tr")
    private List<WebElement> dbRows;
    @FindBy(xpath = "(//h4[@id='myModalLabel']/parent::div/button[@class='close'])[1]")
    private WebElement closeButtonDB;
    @FindBy(css = "div.msgBoxContainer>div.msgBoxContent span")
    private WebElement alertMessageBox;
    @FindBy(css = "div.msgBoxButtons>input[name=\"Yes\"]")
    private WebElement buttonAcceptMessage;
    @FindBy(xpath = "(//label[text()='Splice Technology']/parent::div/following-sibling::div//input)[2]")
    private WebElement inputSpliceTechnology;
    @FindBy(xpath = "(//input[@rel='nwf'])")
    private WebElement inputNWF;
    @FindBy(xpath = "(//input[@name='NWF.termsused.modelname'])")
    private WebElement inputNWFModel;
    @FindBy(xpath = "(//label[text()='Splice Technology']/parent::div/following-sibling::div//input)[1]")
    private WebElement inputSpiceTech;
    @FindBy(xpath = "(//label[text()='Splice Technology']/parent::div/following-sibling::div//input)[2]")
    private WebElement inputSpiceType;
    @FindBy(xpath = "(//label[text()='Splice Dia (mm)']/parent::div/following-sibling::div//input)[1]")
    private WebElement inputSpiceDia;
    @FindBy(xpath = "(//label[text()='Splice Dia (mm)']/parent::div/following-sibling::div//input)[2]")
    private WebElement inputSpliceAddOn;
    @FindBy(xpath = "(//label[text()='Strip Length (mm)']/parent::div/following-sibling::div//input)[1]")
    private WebElement inputStripLength;
    @FindBy(xpath = "(//label[text()='Strip Length (mm)']/parent::div/following-sibling::div//input)[2]")
    private WebElement inputLengthOfHeatShrink;
    @FindBy(xpath = "(//label[text()='Splice Loopback Length (mm)']/parent::div/following-sibling::div//input)[1]")
    private WebElement inputSpliceLoopback;
    @FindBy(xpath = "//button[@name='idexport']")
    private WebElement exportButton;
    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement homeButton;
    @FindBy(xpath = "//button[@id='idnewlibrary']")
    private WebElement createComponentDBButton;
    @FindBy(xpath = "//input[@name='libName']")
    private WebElement dbNameInput;
    @FindBy(xpath = "//select[@name='profiles']")
    private WebElement profileSelect;
    @FindBy(xpath = "//button[@name='btnImport']")
    private WebElement importButton;
    @FindBy(xpath = "//span[text()='Component DB']")
    private WebElement componentDB;
    @FindBy(xpath = "//button[@id='btnCreate']")
            private WebElement createButton;
    @FindBy(xpath = "//input[@name='overwriteimport']")
            private WebElement overwriteExisting;
    @FindBy(xpath = "//input[@name='file']")
    private WebElement importFilePath;
    @FindBy(xpath = "//button[@name='importcsv']")
    private WebElement importButtonForCSV;
    @FindBy(xpath = "//button[@data-bb-handler='confirm']")
            private WebElement confirmDeleteButton;

    @FindBy(xpath="//div[@title='Columns']//span[@class='caret']")
            private WebElement checkColumns;

    String tableComponentRows = "table[data-page-list=\"[25, 50, 75, 100, All\"]>tbody>tr";

    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();

    public void selectFirstComponent() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkboxfirstComponent.click();
    }

    public void editFirstComponent() {
        buttonEditFirstComponent.click();
    }

    public void enterNewPartNumber(String newPartNumber) {
        customCommand.waitForElementVisibility(driver, referencesNewPartNumber);
        customCommand.enterText(referencesNewPartNumber, newPartNumber);
    }

    public void enterLinkPartNumber(String partNumber) throws AWTException, InterruptedException {
        customCommand.waitForElementVisibility(driver, linkPartNumber);
        customCommand.simulateKeyEnterWithValue(linkPartNumber, partNumber);
        Thread.sleep(2000);
        customCommand.simulateKeyEnter();
    }

    public void loadDataFromDB() throws InterruptedException, AWTException {
        customCommand.javaScriptClick(driver, loadDBButton);
        Thread.sleep(2000);
        for (int i = 0; i < dbRows.size(); i++) {
            if (dbRows.get(i).findElement(By.xpath("td[2]")).getText().contains("testdescription")) {
                continue;
            } else {
                dbRows.get(i).findElement(By.xpath("td/button[@title='Add']")).click();
                break;
            }
        }
        customCommand.javaScriptClick(driver, closeButtonDB);

    }

    public void enterApplicator(String partNumber) throws AWTException, InterruptedException {
        customCommand.waitForElementVisibility(driver, linkPartNumber);
        customCommand.simulateKeyEnterWithValue(linkPartNumber, partNumber);
        Thread.sleep(2000);
        customCommand.simulateKeyEnter();
    }

    public void enterEquivalents(String partNumber) throws AWTException, InterruptedException {
        customCommand.waitForElementVisibility(driver, linkPartNumber);
        customCommand.simulateKeyEnterWithValue(linkPartNumber, partNumber);
        Thread.sleep(2000);
        customCommand.simulateKeyEnter();
    }

    public void enterLinkCavityPlug() throws AWTException, InterruptedException {
        cavityPlugInput.click();
        cavityPlugInput.sendKeys("1");
        Thread.sleep(2000);
        selectFirstCavity.click();
        customCommand.enterText(wireinsfrom, "2.03");
        customCommand.enterText(wireinsto, "3.03");
        Thread.sleep(1000);
    }

    public void enterTag() throws AWTException, InterruptedException {
        tagInput.click();
        tagInput.sendKeys("testTag");
        Thread.sleep(2000);
    }

    public void clickAddSimilarOnPopup() {
        buttonConfirmAddSimilar.click();
    }

    public void getFullPagination() throws InterruptedException {
        Thread.sleep(3000);
        customCommand.scrollIntoView(driver, paginationDropdown);
        paginationDropdown.click();
        customCommand.waitForElementVisibility(driver, paginationAll);
        Thread.sleep(3000);
        paginationAll.click();
        Thread.sleep(3000);
    }


    public void viewAllFields() throws InterruptedException {
        driver.findElement(By.cssSelector("div[title=\"Columns\"]>button.dropdown-toggle")).click();
        Thread.sleep(2000);
        List<WebElement> allFieldsElements = driver.findElements(By.cssSelector("div.columns ul.dropdown-menu input"));
        Thread.sleep(5000);
        for (WebElement element : allFieldsElements) {
            if (element.getAttribute("checked") == null) {
                element.click();
            }
        }
    }

    private void checkIfResultsReturnedForComponents() {
        boolean isResultAvailable = driver.findElements(By.cssSelector(tableComponentRows)).size() >0 ;
        if(isResultAvailable){
            customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableComponentRows)));
        }
    }

    public void filterComponentBasedOnPartNumber(String partNumber) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.waitForElementToBeClickable(driver, searchFieldPartNumber);
        customCommand.simulateKeyEnterWithValue(searchFieldPartNumber, partNumber);
        Thread.sleep(3000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnStatus(String status) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.selectDropDownByValue(selectStatus, status);
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnDescription(String description) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldDescription, description);
        Thread.sleep(3000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnFamily(String family) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldFamily, family);
        Thread.sleep(3000);
        checkIfResultsReturnedForComponents();
    }

    public void checkIfPropertyIsChecked(String property) throws InterruptedException {
        customCommand.javaScriptClick(driver,checkColumns);
        property=property.toLowerCase();
        WebElement elem=driver.findElement(By.xpath("//div[@title='Columns']//input[@type='checkbox' and @data-field='"+property+"']"));
        if((elem.getAttribute("checked")==null))
        {
            customCommand.javaScriptClick(driver,elem);
        }
    }

    public void filterComponentBasedOnUsage(String usage) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.selectDropDownByValue(selectUsage, usage);
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnSupplier(String supplier) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldSupplier, supplier);
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnSupplierPN(String supplierPN) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldSupplierPN, supplierPN);
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnColour(String colour) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.selectDropDownByValue(selectColour, colour);
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnCavity(String cavity) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldCavity, cavity);
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnInsulationOD(String insulationOD) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldInsulationOD, insulationOD);
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnAwgSize(String awgSize) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldAwgSize, awgSize);
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnGauge(String gauge) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldGauge, gauge);
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnCSARange(String csaRange) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.scrollIntoView(driver, searchFieldCSA);
        customCommand.simulateKeyEnterWithValue(searchFieldCSA, csaRange);
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnOutsideDiaRange(String outsideDiaRange) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldOutsideDia, outsideDiaRange);
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnMaterial(String material) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldMaterial, material);
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnMinimumBendRadiusRange(String minimumBendRadiusRange) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldMinimumBendRadius, minimumBendRadiusRange);
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnMaxCurrentRange(String maxCurrentRange) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldMaxCurrent, maxCurrentRange);
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnResistanceRange(String resistanceRange) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldResistance, resistanceRange);
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnGender(String gender) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.selectDropDownByValue(selectGender, gender.toLowerCase());
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnType(String type) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldType, type);
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnSealingType(String sealingType) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.selectDropDownByValue(selectSealingType, sealingType.toLowerCase());
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnControlType(String controlType) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.selectDropDownByValue(selectControlType, controlType.replace(" ", "_"));
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnCableType(String cableType) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.selectDropDownByValue(selectCableType, cableType.toLowerCase());
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnNumberOfWiresRange(String wiresRange) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.scrollIntoView(driver, searchFieldNumberOfWires);
        customCommand.simulateKeyEnterWithValue(searchFieldNumberOfWires, wiresRange);
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnApplicatorUsage(String applicatorusage) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.selectDropDownByValue(selectApplicatorUsage, applicatorusage);
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnSealOrTerminal(String forsealorterminal) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.selectDropDownByValue(selectSealOrTerminal, forsealorterminal);
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnInService(String inservice) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.selectDropDownByValue(selectInService, inservice.toLowerCase());
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnApplicatorSite(String applicatorSite) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.scrollIntoView(driver, searchFieldApplicatorSite);
        customCommand.simulateKeyEnterWithValue(searchFieldApplicatorSite, applicatorSite);
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnNumberOfCavitiesRange(String cavitiesRange) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.scrollIntoView(driver, searchFieldNumberOfCavities);
        customCommand.simulateKeyEnterWithValue(searchFieldNumberOfCavities, cavitiesRange);
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnHousingGender(String housingGender) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.selectDropDownByValue(selectHousingGender, housingGender.toLowerCase());
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnConnectorType(String connectorType) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.selectDropDownByValue(selectConnectorType, connectorType.toLowerCase());
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void filterComponentBasedOnKeyway(String keyway) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver, paginationDropdown);
        customCommand.scrollIntoView(driver, searchFieldKeyway);
        customCommand.simulateKeyEnterWithValue(searchFieldKeyway, keyway);
        Thread.sleep(2000);
        checkIfResultsReturnedForComponents();
    }

    public void clickUpdateComponent() {
        updateComponent.click();
    }

    public void verifyAlertSuccessMessage(String message) {
        customCommand.waitForElementVisibility(driver, alertSuccessMessage);
        alertSuccessMessage.getText().equals(message);
    }

    public void verifyAlertMessage(String message) {
        customCommand.waitForElementVisibility(driver, alertMessageBox);
        alertMessageBox.getText().equals(message);
    }

    public void acceptAlertMessage() {
        buttonAcceptMessage.click();
    }

    public void enterSpliceDetails() {
        customCommand.simulateKeyEnterWithValue(inputSpiceTech, "Ultrasonic");
        customCommand.clearAndEnterText(inputSpiceDia, "1.8");
        customCommand.clearAndEnterText(inputSpliceAddOn, "1.8");
        customCommand.clearAndEnterText(inputStripLength, "6.0");
        customCommand.clearAndEnterText(inputLengthOfHeatShrink, "29.2");
        customCommand.clearAndEnterText(inputSpliceLoopback, "2.0");
    }

    public void enterNWFDetails()  {
        customCommand.clearAndEnterText(inputNWF,"test");
        customCommand.clearAndEnterText(inputNWFModel,"test");
    }

    public void exportComponentsData()
    {
        try {
            Thread.sleep(2000);
            customCommand.javaScriptClick(driver,exportButton);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void navigateHome()
    {
        try {
            customCommand.javaScriptClick(driver,homeButton);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void openComponentDB()
    {
        try {
            customCommand.javaScriptClick(driver,componentDB);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void createNewComponentDB(String dbName)
    {
        try {
            customCommand.javaScriptClick(driver, createComponentDBButton);
            customCommand.clearAndEnterText(dbNameInput, dbName);
            customCommand.selectDropDownByValue(profileSelect, "QUICKSTART");
            customCommand.javaScriptClick(driver,createButton);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void clickImportButton(String componentName)
    {
        try {
            Thread.sleep(2000);
            customCommand.javaScriptClick(driver,importButton);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void importDB(String componentName) throws InterruptedException {
        String path = System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles";
        File[] files=customCommand.getAllFilesInAFolder(path);
        Optional<File> matchedFile= Arrays.stream(files).filter(x->x.getName().toLowerCase().contains(componentName.toLowerCase(Locale.ROOT))).findAny();
        String pathOfFile=matchedFile.get().getAbsolutePath();
        importFilePath.sendKeys(pathOfFile);
        customCommand.javaScriptClick(driver,overwriteExisting);
        customCommand.javaScriptClick(driver,importButtonForCSV);
    }

    public void deleteComponentDB(String dbName)
    {
        WebElement delete=driver.findElement(By.xpath("//button[(contains(@onclick,'"+dbName.toLowerCase()+"')) and (contains(@Title,'Delete'))]"));
        try {
            customCommand.javaScriptClick(driver,delete);
            customCommand.javaScriptClick(driver,confirmDeleteButton);
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
