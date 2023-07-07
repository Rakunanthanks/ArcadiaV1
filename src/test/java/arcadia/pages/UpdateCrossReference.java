package arcadia.pages;

import arcadia.domainobjects.AdditionalReferences;
import arcadia.pages.ComponentDB.AddNewComponentPage;
import arcadia.pages.ComponentDB.CommonElements;
import arcadia.stepdefinations.HarnessStepDefinitions;
import arcadia.utils.SeleniumCustomCommand;
import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.python.antlr.ast.Str;
import org.testng.Assert;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
//driver.findElement(By.cssSelector("body > div:nth-child(1) > section:nth-child(29) > div:nth-child(1) > section:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > table:nth-child(2) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(20) > button:nth-child(3)"))
public class UpdateCrossReference extends  BasePage{
    @FindBy(css="#tblconnector > tbody > tr:nth-child(1) > td:nth-child(17) > button.btn.btn-default.btn-sm.edit") private WebElement editConnector;
    @FindBy(css="#allcomponents > tbody > tr:nth-child(1) > td:nth-child(11) > button.btn.btn-default.btn-sm.edit") private WebElement editTerminal;
    @FindBy(css="#allcomponents > tbody > tr > td:nth-child(11) > button.btn.btn-default.btn-sm.edit")private WebElement editComponent;
    @FindBy(css ="#addrefs > tbody > tr > td:nth-child(4) > div > button.removeRow.btn.btn-sm.btn-danger")private WebElement deleteAddRefs;
    @FindBy(css="#btnSave")private WebElement updateComponent;
    @FindBy(css="body > div.bootbox.modal.fade.bootbox-confirm.in > div > div > div.modal-footer > button.btn.btn-primary")private WebElement okaySaveButton;
    @FindBy(css = "button[class='btn btn-primary']") private WebElement okayButton;
    @FindBy(css="input[name=\"addrefs.Partnumber\"]")private WebElement refPartNumber;
    @FindBy(css= "input[name=\"addrefs.Company\"] ~ div >div > ")private WebElement refCompany;
    @FindBy(css= "[name=\"addrefs.Type\"]")private WebElement refType;
    @FindBy(css="#rightPaneContent")private WebElement updateCrossRefTab;
    @FindBy(xpath="//input[@name='bom.partnumber']")private WebElement connectorPartNumber;
    @FindBy(css = "button[title=\"Submit\"]") private WebElement buttonSubmitDetails;
    @FindBy(css="#rightPaneContent > div:nth-child(4) > select")private WebElement updateCrossRefTabSelectCompany;
    public  String referencesPartNumber = "input[name=\"addrefs.Partnumber\"]";
    public  String referencesType = "[name=\"addrefs.Type\"]";
    public  String referencesCompany = "input[name=\"addrefs.Company\"] ~ div >div >input";
    @FindBy(css =".ignoreClick[text-anchor='start']")private WebElement partNumberDescription;
    public UpdateCrossReference(WebDriver driver) {
        super(driver);
    }
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    CommonElements commonElements = new CommonElements(driver);
    public void editComponent(String component) {
        switch (component) {
            case "connector" ->{
                customCommand.waitForElementToBeClickable(driver, editConnector);
                editConnector.click();}
            case "terminal" -> {
                customCommand.waitForElementToBeClickable(driver, editTerminal);
                editTerminal.click();
            }
            case "editComponent" ->{
                customCommand.waitForElementToBeClickable(driver, editComponent);
                editComponent.click();
            }
        }

    }
    public String getRefPartNumber(){
        System.out.println(refPartNumber.getAttribute("value"));
        return refPartNumber.getAttribute("value");
    }


    public void createAdditionalReferencesForTheGivenPartNumber(String partNumber) throws InterruptedException, AWTException {

        while (!Objects.equals(getRefPartNumber(), "")) {
            deleteAddRefs.click();
            customCommand.waitForElementToBeClickable(driver,okayButton);
            okayButton.click();
        }
        for (int i=0;i<2;i++) {
            commonElements.buttonAddRow.click();
        }
        List<String> partNumbers = Arrays.asList(partNumber +"-Manufacturer", partNumber +"-Supplier", partNumber +"-CrossRef");
        List<String> type = Arrays.asList("Manufacturer","Supplier", "CrossRef");
        List<WebElement> listOfPartNumber = driver.findElements(By.cssSelector(referencesPartNumber));
        List<WebElement> listOfType = driver.findElements(By.cssSelector(referencesType));
        List<WebElement> listOfCompany = driver.findElements(By.cssSelector(referencesCompany));

        for (int j=0;j<3;j++) {
            customCommand.enterText(listOfPartNumber.get(j), partNumbers.get(j));
            customCommand.selectDropDownByValue(listOfType.get(j), type.get(j));
            customCommand.enterText(listOfCompany.get(j), type.get(j));
        }
        updateComponent.click();
        try{
            System.out.println("test");
            customCommand.waitForElementVisibility(driver,okaySaveButton);
            okaySaveButton.click();
        }catch (Exception e)
        {
            Thread.sleep(1000);
        }
        customCommand.waitForElementVisibility(driver,commonElements.alertSuccessMessage);
        commonElements.verifyAlertSuccessMessage("Component updated");
    }

    public void userUpdateCrossReferenceBySearchingCombination(String combinations) throws InterruptedException {
        checkCrossRefOpenedOrNot();
        List<WebElement> combinationRadioButtons = driver.findElements(By.cssSelector("input[name=\"chOption\"]"));
        for(int i=0;i<4;i++){
            if ((Objects.equals(combinations, "1")) && Objects.equals(combinationRadioButtons.get(i).getAttribute("value"), "3") ) {
                combinationRadioButtons.get(i).click();
            } else if ((Objects.equals(combinations, "2")) && Objects.equals(combinationRadioButtons.get(i).getAttribute("value"), "4")) {
                combinationRadioButtons.get(i).click();
            } else if ((Objects.equals(combinations, "3")) && Objects.equals(combinationRadioButtons.get(i).getAttribute("value"), "1")) {
                combinationRadioButtons.get(i).click();
            }else if ((Objects.equals(combinations, "4")) && Objects.equals(combinationRadioButtons.get(i).getAttribute("value"), "2")) {
                combinationRadioButtons.get(i).click();
            }
        }
        switch (combinations){
            case "1" ->
                UseManufacturerPNIfCompanyPNNotInDatabase();
            case "2" ->
                CrossReferenceToManufacturerPNOnly();
            case "3" ->
                UseSupplierPNIfCompanyPNNotInDatabase();
            case "4" ->
                CrossReferenceToSupplierPNOnly();
        }
        customCommand.javaScriptClick(driver,buttonSubmitDetails);
    }
    public void UseManufacturerPNIfCompanyPNNotInDatabase() throws InterruptedException {
        customCommand.selectDropDownByValue(updateCrossRefTabSelectCompany,"Manufacturer");

    }

    public void CrossReferenceToManufacturerPNOnly(){

    }
    public void UseSupplierPNIfCompanyPNNotInDatabase() throws InterruptedException {
        customCommand.selectDropDownByValue(updateCrossRefTabSelectCompany,"Supplier");


    }
    public void CrossReferenceToSupplierPNOnly(){

    }

    public void checkCrossRefOpenedOrNot() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(updateCrossRefTab.isDisplayed());
    }

    public void changeConnectorPartNumber(String partNumber) throws InterruptedException {
        customCommand.clearAndEnterText(connectorPartNumber,partNumber);
        customCommand.javaScriptClick(driver,buttonSubmitDetails);
    }

    public void checkUpdateCrossReferencePartNumberValueForCombination(String combination) {
        switch (combination){
            case "1" ->
                    checkUseManufacturerPNIfCompanyPNNotInDatabase();
            case "2" ->
                    checkCrossReferenceToManufacturerPNOnly();
            case "3" ->
                    checkUseSupplierPNIfCompanyPNNotInDatabase();
            case "4" ->
                    checkCrossReferenceToSupplierPNOnly();
        }
    }

    private void checkCrossReferenceToSupplierPNOnly() {
        System.out.println(partNumberDescription.getText());
        Assert.assertEquals(partNumberDescription.getText(),"AY8193-SUPPLIER","Connector part number is not updated as expected");
    }

    private void checkUseSupplierPNIfCompanyPNNotInDatabase() {
        System.out.println(partNumberDescription.getText());
        Assert.assertEquals(partNumberDescription.getText(),"AY8193-SUPPLIER","Connector part number is not updated as expected");
    }

    private void checkCrossReferenceToManufacturerPNOnly() {
        System.out.println(partNumberDescription.getText());
        Assert.assertEquals(partNumberDescription.getText(),"AY8193-MANUFACTURER","Connector part number is not updated as expected");
    }

    private void checkUseManufacturerPNIfCompanyPNNotInDatabase() {
        System.out.println(partNumberDescription.getText());
        Assert.assertEquals(partNumberDescription.getText(),"AY8193-MANUFACTURER","Connector part number is not updated as expected");
    }
    HarnessPage harnessPage = new HarnessPage(driver);
    ConnectorCavityTablePage connectorCavityTablePage = new ConnectorCavityTablePage(driver);
    public void userAddTerminalToThePlacedConnector(String terminalPartNumber) throws InterruptedException, AWTException {
        connectorCavityTablePage.addCavity();
        connectorCavityTablePage. enterTerminalPartNumber();
        harnessComponentIsOpened("0");
        connectorCavityTablePage.addCavity();
        connectorCavityTablePage.enterTerminalPartNumber();
    }
    public void userAddPlugToThePlacedConnector(String sealPartNumber) throws InterruptedException,AWTException{
        connectorCavityTablePage.addCavity();
        customCommand.scrollIntoView(driver,connectorCavityTablePage.plugPN);
        connectorCavityTablePage.plugPN.click();
        connectorCavityTablePage.plugPN.sendKeys(sealPartNumber);
        customCommand.pressKey(driver,"enter");
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver,buttonSubmitDetails);

    }

    private void harnessComponentIsOpened(String index) throws InterruptedException {
        String connectorid = new ConnectorPage(driver).getConnectorPlugELementIdsFromDrawingPage().get(Integer.parseInt(index)).getConnectorId();
        harnessPage.clickConnectorPlug(connectorid);
    }

    public void checkTerminalUpdateCrossReferencePartNumberValueFor(String combination) {
        switch (combination) {
            case "1","2" -> {
                System.out.println(partNumberDescription.getText());
                Assert.assertEquals(partNumberDescription.getText(), "1x 0-0152404-3-MANUFACTURER", "Terminal part number is not updated as expected");
            }
            case "3","4" -> {
                System.out.println(partNumberDescription.getText());
                Assert.assertEquals(partNumberDescription.getText(), "1x 0-0152404-3-SUPPLIER", "Terminal part number is not updated as expected");
            }
        }
    }

    public void checkPlugUpdateCrossReferencePartNumberValueFor(String combination) {
        switch (combination) {
            case "1","2" -> {
                System.out.println(connectorCavityTablePage.partNumber.getText());
                Assert.assertEquals(connectorCavityTablePage.partNumber.getText(),"1x 1011-235-0405-MANUFACTURER","Plug part number is not updated as expected");
            }
            case "3","4" -> {
                System.out.println(connectorCavityTablePage.partNumber.getText());
                Assert.assertEquals(connectorCavityTablePage.partNumberDescription.getText(),"1x 1011-235-0405-SUPPLIER","Plug part number is not updated as expected");
            }
        }
    }
}


