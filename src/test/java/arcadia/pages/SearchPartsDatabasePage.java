package arcadia.pages;

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
    String tablePartsRows = "#tblBOMPartNoList > tbody > tr";

    String tableWiresRows = "#tblWirePartNoList>tbody>tr";
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
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tablePartsRows)));
    }

    public void searchPartUsingCavity(int cavity) throws InterruptedException, AWTException {
        customCommand.simulateKeyEnterWithValue(numberOfCavities, String.valueOf(cavity));
        customCommand.simulateKeyEnter();
        Thread.sleep(4000);
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tablePartsRows)));
    }

    public void searchPartUsingFamily(String familyName) throws InterruptedException, AWTException {
        customCommand.simulateKeyEnterWithValue(family, familyName);
        customCommand.simulateKeyEnter();
        Thread.sleep(4000);
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tablePartsRows)));
    }

    public void searchPartUsingSupplier(String companyName) throws InterruptedException, AWTException {
        customCommand.simulateKeyEnterWithValue(supplier, companyName);
        customCommand.simulateKeyEnter();
        Thread.sleep(4000);
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tablePartsRows)));
    }

    public void searchPartUsingHousingGender(String housingGenderType) throws InterruptedException, AWTException {
        customCommand.selectDropDownByValue(housingGender, housingGenderType);
        arrowbuttonfetchInfo.click();
        Thread.sleep(4000);
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tablePartsRows)));
    }

    public void searchPartUsingTerminalGender(String terminalGenderType) throws InterruptedException, AWTException {
        customCommand.selectDropDownByValue(gender, terminalGenderType);
        arrowbuttonfetchInfo.click();
        Thread.sleep(4000);
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tablePartsRows)));
    }

    public void searchPartUsingType(String compTypeValue) throws InterruptedException, AWTException {
        customCommand.simulateKeyEnterWithValue(type, compTypeValue);
        arrowbuttonfetchInfo.click();
        Thread.sleep(4000);
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tablePartsRows)));
    }

    public void searchPartUsingColour(String colourValue) throws InterruptedException, AWTException {
        customCommand.selectDropDownByValue(colour, colourValue);
        arrowbuttonfetchInfo.click();
        Thread.sleep(4000);
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tablePartsRows)));
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
}
