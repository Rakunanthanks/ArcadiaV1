package arcadia.pages;

import arcadia.context.FlowContext;
import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SearchPartsDatabasePage extends BasePage{
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    @FindBy(xpath = "//span[contains(text(),\"Populate\")]") private WebElement populate;
    @FindBy(css = "input[name=\"nCavities\"]") private WebElement numberOfCavities;
    @FindBy(css = "select[name=\"library\"]") private WebElement partsComponentDB;
    @FindBy(css = "select[name=\"concompntType\"]") private WebElement componentType;
    @FindBy(css = "input[name=\"conPartNumber\"]") private WebElement pnDescription;
    @FindBy(css = "input[name=\"nFamily\"]") private WebElement family;
    @FindBy(css = "select[name=\"nGroupname\"]") private WebElement partType;
    @FindBy(css = "select[name=\"housingGender\"]") private WebElement housingGender;
    @FindBy(css = "select[name=\"gender\"]") private WebElement gender;

    @FindBy(css = "input[name=\"nCompany\"]") private WebElement supplier;

    @FindBy(css = "select[name=\"type\"]") private WebElement type;

    @FindBy(css = "select[name=\"colors\"]") private WebElement colour;

    @FindBy(css = "input.next") private WebElement buttonNext;

    @FindBy(css = "div#idFetchwiretable input.next") private WebElement buttonNextWiresTable;

    @FindBy(css = "input#btnFetchBOMPartInfo") private WebElement arrowbuttonfetchInfo;

    @FindBy(css = "div[aria-describedby=\"searchdialog\"] button[title=\"close\"]") private WebElement buttonCloseSearchParts;

    @FindBy(css = "table#wirefilter") private WebElement tableSearchWires;
    @FindBy(css = "select[name=\"wiretype\"]") private WebElement selectWireType;

    @FindBy(css = "table#wirefilter input[name=\"nPartNumber\"]") private WebElement inputWirePnDescription;

    @FindBy(css = "table#wirefilter input[name=\"nMaterial\"]") private WebElement inputMaterial;

    @FindBy(css = "table#wirefilter input[name=\"nGauge\"]") private WebElement inputGauge;

    @FindBy(css = "table#wirefilter input[name=\"nCsa\"]") private WebElement inputCSA;

    @FindBy(css = "table#wirefilter input[name=\"nOuterdia\"]") private WebElement inputOuterDia;

    @FindBy(css = "select[name=\"nPricolors\"]") private WebElement selectPrimaryColour;

    @FindBy(css = "select[name=\"nSeccolors\"]") private WebElement selectSecondaryColour;

    @FindBy(css = "select[name=\"nTercolors\"]") private WebElement selectTertiaryColour;

    @FindBy(css = "table#Attachfilters+div #tblAttachPartNoList > tbody > tr") private WebElement rowSearchedAttachParts;

    @FindBy(css = "table#tblcavityPartNoList > tbody > tr") private WebElement rowSearchCavityDetails;

    @FindBy(xpath = "//div[@aria-describedby=\"idFetchcavitytable\"]//span[contains(text(),\"Populate\")]") private WebElement buttonPopulateCavityDetails;

    @FindBy(css = "table#Attachfilters+div table#tblAttachPartNoList") private WebElement tableGetAttachedPartsDetails;
    @FindBy(css = "table#Attachfilters select[name=\"componentType\"]") private WebElement attachedPartComponentType;
    @FindBy(css = "div#idFetchnode_attachpart input.next") private WebElement buttonNextAttachPartsTable;

    @FindBy(css = "div#idFetchcavitytable input.next") private WebElement buttonNextCavityDetailsTable;

    @FindBy(css = "table#tblcavityPartNoList") private WebElement tableCavityDetailsSearch;

    @FindBy(css = "div#idFetchcavitytable input#btnClearFilterDetails") private WebElement buttonResetCavityFilterDetails;

    @FindBy(css = "div#idFetchcavitytable input[name=\"nPartNumber\"]") private WebElement inputPNCavityFilterDetails;
    String tablePartsRows = "#tblBOMPartNoList > tbody > tr";

    String tableWiresRows = "#tblWirePartNoList>tbody>tr";

    String tableAttachedPartsRows = "table#Attachfilters+div #tblAttachPartNoList > tbody > tr";

    String tableCavityDetailsRows = "table#tblcavityPartNoList > tbody > tr";
    public SearchPartsDatabasePage(WebDriver driver) {
        super(driver);
    }

    public void findInSearchPartDatabase(String description , String cavityCount) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementToBeClickable(driver,pnDescription);
        customCommand.enterText(pnDescription,description);
        customCommand.simulateKeyEnterWithValue(numberOfCavities,cavityCount);
    }
    public  void populateParts() throws InterruptedException{
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver,populate);
        this.populate.click();
    }

    public void selectSearchDB(String partsDBName) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,pnDescription);
        customCommand.selectDropDownByValue(partsComponentDB,partsDBName);
    }

    public void selectComponentType(String componentPartType) throws InterruptedException {
        customCommand.selectDropDownByValue(componentType,componentPartType);
    }

    public void searchPartUsingPartNumber(String partNumberDescription) throws InterruptedException, AWTException {
        customCommand.simulateKeyEnterWithValue(pnDescription,partNumberDescription);
        customCommand.simulateKeyEnter();
        Thread.sleep(4000);
        checkIfResultsReturned();
    }

    public void searchPartUsingCavity(int cavity) throws InterruptedException, AWTException {
        customCommand.simulateKeyEnterWithValue(numberOfCavities, String.valueOf(cavity));
        customCommand.simulateKeyEnter();
        Thread.sleep(4000);
        checkIfResultsReturned();
    }

    public void searchPartUsingFamily(String familyName) throws InterruptedException, AWTException {
        customCommand.simulateKeyEnterWithValue(family, familyName);
        customCommand.simulateKeyEnter();
        Thread.sleep(4000);
        checkIfResultsReturned();
    }

    public void searchPartUsingSupplier(String companyName) throws InterruptedException, AWTException {
        customCommand.simulateKeyEnterWithValue(supplier, companyName);
        customCommand.simulateKeyEnter();
        Thread.sleep(4000);
        checkIfResultsReturned();
    }

    public void searchPartUsingHousingGender(String housingGenderType) throws InterruptedException, AWTException {
        customCommand.selectDropDownByValue(housingGender, housingGenderType);
        arrowbuttonfetchInfo.click();
        Thread.sleep(4000);
        checkIfResultsReturned();
    }

    public void searchPartUsingTerminalGender(String terminalGenderType) throws InterruptedException, AWTException {
        customCommand.selectDropDownByValue(gender, terminalGenderType);
        arrowbuttonfetchInfo.click();
        Thread.sleep(4000);
        checkIfResultsReturned();
    }

    public void searchPartUsingType(String compTypeValue) throws InterruptedException, AWTException {
        customCommand.simulateKeyEnterWithValue(type, compTypeValue);
        arrowbuttonfetchInfo.click();
        Thread.sleep(4000);
        checkIfResultsReturned();
    }

    public void searchPartUsingColour(String colourValue) throws InterruptedException, AWTException {
        customCommand.selectDropDownByValue(colour, colourValue);
        arrowbuttonfetchInfo.click();
        Thread.sleep(4000);
        checkIfResultsReturned();
    }

    private void checkIfResultsReturned() {
        boolean isResultAvailable = driver.findElements(By.cssSelector(tablePartsRows)).size() >0 ;
        if(isResultAvailable){
            customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tablePartsRows)));
        }
    }

    public List<String> getSearchPartsData() throws InterruptedException {
        List<String> searchPartsData = new ArrayList<>();
        List<WebElement> tablePartsElement;
        while (true){
            tablePartsElement = driver.findElements(By.cssSelector(tablePartsRows));
            if (tablePartsElement.size()==0){
                break;
            }
            int i = 0;
            for( WebElement element : tablePartsElement){
                i++;
                List<WebElement> tdElements = element.findElements(By.cssSelector("td"));
                String partNumber = tdElements.get(0).getText();
                searchPartsData.add(partNumber);
            }
            customCommand.waitForElementToBeClickable(driver,buttonNext);
            buttonNext.click();
            Thread.sleep(2000);
        }
        return searchPartsData;
    }

    public List<String> getSearchWiresData() throws InterruptedException {
        List<String> searchWiresData = new ArrayList<>();
        List<WebElement> tableWiresElement;
        while (true){
            tableWiresElement = driver.findElements(By.cssSelector(tableWiresRows));
            if (tableWiresElement.size()==0){
                break;
            }
            int i = 0;
            for( WebElement element : tableWiresElement){
                i++;
                List<WebElement> tdElements = element.findElements(By.cssSelector("td"));
                String partNumber = tdElements.get(0).getText();
                searchWiresData.add(partNumber);
            }
            try {
                customCommand.waitForElementToBeClickable(driver,buttonNextWiresTable);
                buttonNextWiresTable.click();
                Thread.sleep(2000);
            }
            catch (Exception e){
                System.out.println("Reached end of records");
                break;
            }
        }
        return searchWiresData;
    }
    public void closeSearchPartsWindow() throws InterruptedException {
        buttonCloseSearchParts.click();
        Thread.sleep(2000);
    }

    public void verifySearchWiresWindowIsOpen(){
        customCommand.waitForElementVisibility(driver,tableSearchWires);
        Assert.assertTrue(tableSearchWires.isDisplayed());
    }

    public void selectWireType(String wireType) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,selectWireType);
        customCommand.selectDropDownByValue(selectWireType,wireType.toLowerCase());
    }

    public void searchWireMulticoreUsingPartNumber(String partNumberDescription) throws InterruptedException, AWTException {
        customCommand.simulateKeyEnterWithValue(inputWirePnDescription,partNumberDescription);
        customCommand.simulateKeyEnter();
        Thread.sleep(4000);
    }

    public void searchWireMulticoreUsingMaterial(String material) throws InterruptedException, AWTException {
        inputMaterial.clear();
        customCommand.simulateKeyEnterWithValue(inputMaterial,material);
        customCommand.simulateKeyEnter();
        Thread.sleep(4000);
    }

    public void searchWireMulticoreUsingGauge(String gaugeValue) throws InterruptedException, AWTException {
        customCommand.simulateKeyEnterWithValue(inputGauge,gaugeValue);
        customCommand.simulateKeyEnter();
        Thread.sleep(4000);
    }

    public void searchWireMulticoreUsingCSA(String csaValue) throws InterruptedException, AWTException {
        customCommand.simulateKeyEnterWithValue(inputCSA,csaValue);
        customCommand.simulateKeyEnter();
        Thread.sleep(4000);
    }

    public void searchWireMulticoreUsingOuterDia(String outerDiaValue) throws InterruptedException, AWTException {
        customCommand.simulateKeyEnterWithValue(inputOuterDia,outerDiaValue);
        customCommand.simulateKeyEnter();
        Thread.sleep(4000);
    }

    public void searchWireMulticoreUsingPrimaryColour(String primaryColour) throws InterruptedException, AWTException {
        customCommand.selectDropDownByValue(selectPrimaryColour,primaryColour);
        customCommand.simulateKeyEnter();
        Thread.sleep(4000);
    }

    public void searchWireUsingPartNumberAndMaterial(String partNumberDescription, String material) throws InterruptedException, AWTException {
        customCommand.enterText(inputWirePnDescription,partNumberDescription);
        customCommand.waitForElementToBeClickable(driver,inputMaterial);
        inputMaterial.clear();
        customCommand.simulateKeyEnterWithValue(inputMaterial,material);
        customCommand.simulateKeyEnter();
        Thread.sleep(4000);
    }

    public void verifyGetAttachedPartsDetailsWindowIsOpen(){
        customCommand.waitForElementVisibility(driver,tableGetAttachedPartsDetails);
        Assert.assertTrue(tableGetAttachedPartsDetails.isDisplayed());
    }

    public void selectAttachPartComponentType(String componentType) throws InterruptedException {
        customCommand.waitForElementVisibility(driver,attachedPartComponentType);
        customCommand.waitForElementToBeClickable(driver,attachedPartComponentType);
        customCommand.selectDropDownByValue(attachedPartComponentType,componentType.toLowerCase());
        Thread.sleep(2000);
    }

    public List<String> getAttachedWiresData() throws InterruptedException {
        List<String> attachedPartsData = new ArrayList<>();
        List<WebElement> tableAttachedPartsElement;
        while (true){
            tableAttachedPartsElement = driver.findElements(By.cssSelector(tableAttachedPartsRows));
            if (tableAttachedPartsElement.size()==0){
                break;
            }
            int i = 0;
            for( WebElement element : tableAttachedPartsElement){
                i++;
                List<WebElement> tdElements = element.findElements(By.cssSelector("td"));
                String partNumber = tdElements.get(0).getText();
                attachedPartsData.add(partNumber);
            }
            try {
                customCommand.waitForElementToBeClickable(driver,buttonNextAttachPartsTable);
                buttonNextAttachPartsTable.click();
                Thread.sleep(2000);
            }
            catch (Exception e){
                System.out.println("Reached end of records");
                break;
            }
        }
        return attachedPartsData;
    }

    public String getImagePathOfFirstAttachPart() throws InterruptedException {
        customCommand.waitForElementVisibility(driver,rowSearchedAttachParts);
        customCommand.waitForElementToBeClickable(driver,rowSearchedAttachParts);
        String imagePathValue = rowSearchedAttachParts.findElement(By.cssSelector("td[rel=\"imagepath\"]")).getText();
        customCommand.doubleClick(driver,rowSearchedAttachParts);
        Thread.sleep(4000);
        return imagePathValue;
    }

    public void verifyGetCavityTableDetailsWindowIsOpen(){
        customCommand.waitForElementVisibility(driver,tableCavityDetailsSearch);
        Assert.assertTrue(tableCavityDetailsSearch.isDisplayed());
    }

    public List<String> getCavityDetailsData() throws InterruptedException {
        List<String> cavityDetailsData = new ArrayList<>();
        List<WebElement> tableCavityDetailsElement;
        while (true){
            tableCavityDetailsElement = driver.findElements(By.cssSelector(tableCavityDetailsRows));
            if (tableCavityDetailsElement.size()==0){
                break;
            }
            int i = 0;
            for( WebElement element : tableCavityDetailsElement){
                i++;
                List<WebElement> tdElements = element.findElements(By.cssSelector("td"));
                String partNumber = tdElements.get(0).getText();
                cavityDetailsData.add(partNumber);
            }
            try {
                customCommand.waitForElementToBeClickable(driver,buttonNextCavityDetailsTable);
                buttonNextCavityDetailsTable.click();
                Thread.sleep(2000);
            }
            catch (Exception e){
                System.out.println("Reached end of records");
                break;
            }
        }
        return cavityDetailsData;
    }

    public void resetFiltersCavityDetails() throws InterruptedException {
        customCommand.scrollIntoView(driver,buttonResetCavityFilterDetails);
        buttonResetCavityFilterDetails.click();
        Thread.sleep(2000);
    }

    public void addImageTerminalToCavity(String terminalWithImagePartNumber) throws AWTException, InterruptedException {
        Thread.sleep(2000);
        resetFiltersCavityDetails();
        customCommand.enterText(inputPNCavityFilterDetails,terminalWithImagePartNumber);
        customCommand.simulateKeyEnter();
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver,rowSearchCavityDetails);
        customCommand.waitForElementToBeClickable(driver,rowSearchCavityDetails);
        customCommand.scrollIntoView(driver, buttonPopulateCavityDetails);
        buttonPopulateCavityDetails.click();
        Thread.sleep(4000);
    }
}
