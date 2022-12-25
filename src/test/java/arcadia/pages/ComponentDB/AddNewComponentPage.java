package arcadia.pages.ComponentDB;

import arcadia.domainobjects.AddComponentForm;
import arcadia.domainobjects.AdditionalReferences;
import arcadia.pages.BasePage;
import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddNewComponentPage extends BasePage {
    public AddNewComponentPage(WebDriver driver) {
        super(driver);
    }
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    CommonElements commonElements = new CommonElements(driver);
    @FindBy(css = "input[name=\"description\"]") private WebElement componentDescription;
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
    String  referencesCompany = "input[name=\"addrefs.Company\"] ~ div >div >input";
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
    @FindBy(css = "div[class$=\"bootbox-alert in\"] div.modal-body div") private WebElement alertPopUpMessage;
    @FindBy(css = "div[class$=\"bootbox-alert in\"] div.modal-body button.close") private WebElement alertPopUpCloseButton;

    @FindBy(css = "div[class$=\"bootbox-confirm in\"] div.modal-body div") private WebElement confirmationPopUpMessage;

    @FindBy(css = "div[class$=\"bootbox-confirm in\"] div.modal-body button.close") private WebElement confirmationPopUpCloseButton;

    @FindBy(css = "div.modal-footer button[data-bb-handler=\"confirm\"]") private WebElement confirmationPopUpOkButton;

    @FindBy(css = "div[class$=\"modal-success in\"] div.modal-body div") private WebElement successPopUpMessage;
    @FindBy(css = "div.modal-footer button[data-bb-handler=\"ok\"]") private WebElement successPopUpOkButton;

    public void createComponent(AddComponentForm addComponentForm,String componentName) throws InterruptedException {
        //Details
        customCommand.enterText(componentDescription, addComponentForm.getComponentDetails().getDescription());
        customCommand.enterText(componentFamily, addComponentForm.getComponentDetails().getFamily());
        customCommand.enterText(componentTypeCode, addComponentForm.getComponentDetails().getTypecode());
        customCommand.enterText(componentProprietary, addComponentForm.getComponentDetails().getProprietary());
        customCommand.enterText(componentPartType, addComponentForm.getComponentDetails().getParttype());
        customCommand.selectDropDownByValue(componentMaterialCode, addComponentForm.getComponentDetails().getMaterialcode());
        customCommand.selectDropDownByValue(componentUsage, addComponentForm.getComponentDetails().getUsage());

        switch(componentName.toLowerCase()) {
            case "wire":
                List<WebElement> listOfColours = driver.findElements(By.cssSelector(componentColour));
                customCommand.selectDropDownByValue(listOfColours.get(0), addComponentForm.getComponentDetails().getPrimarycolour());
                customCommand.selectDropDownByValue(listOfColours.get(1), addComponentForm.getComponentDetails().getSecondarycolour());
                customCommand.selectDropDownByValue(listOfColours.get(2), addComponentForm.getComponentDetails().getTertiarycolour());
                //customCommand.selectDropDownByValue(componentPartCategory,addComponentForm.getComponentDetails().getPartcategory());
                break;
            case "seal":
                WebElement Colour = driver.findElement(By.cssSelector(componentColour));
                customCommand.selectDropDownByValue(Colour,addComponentForm.getComponentDetails().getColour());
        }

        //Additional references
        for(int i=1; i<addComponentForm.getAdditionalReferences().size();i++){
            commonElements.buttonAddRow.click();
        }
        List<WebElement> listOfPartNumber = driver.findElements(By.cssSelector(referencesPartNumber));
        List<WebElement> listOfType = driver.findElements(By.cssSelector(referencesType));
        List<WebElement> listOfCompany = driver.findElements(By.cssSelector(referencesCompany));
        int j=0;
        for(AdditionalReferences addReference: addComponentForm.getAdditionalReferences()){
            customCommand.enterText(listOfPartNumber.get(j),addReference.getReferencesPartNumber());
            customCommand.selectDropDownByValue(listOfType.get(j),addReference.getReferencesType());
            customCommand.enterText(listOfCompany.get(j),addReference.getReferencesCompany());
            j=j+1;
        }
        //BomDetails
        customCommand.enterText(bomPrice, String.valueOf(addComponentForm.getBomDetails().getBomPrice()));
        customCommand.enterText(bomWeight, addComponentForm.getBomDetails().getBomWeight());
        customCommand.selectDropDownByValue(bomMeasure, addComponentForm.getBomDetails().getBomMeasure());
        customCommand.selectDropDownByValue(bomCurrency, addComponentForm.getBomDetails().getBomCurrency());
        customCommand.selectDropDownByValue(bomUnits, addComponentForm.getBomDetails().getBomUnits());
        customCommand.selectDropDownByValue(bomBillType, addComponentForm.getBomDetails().getBomBillType());
    }

    public void createComponentWithMandatoryDetailsOnly(AddComponentForm addComponentForm) throws InterruptedException {
        //Additional references
        List<WebElement> listOfPartNumber = driver.findElements(By.cssSelector(referencesPartNumber));
        customCommand.enterText(listOfPartNumber.get(0),addComponentForm.getAdditionalReferences().get(0).getReferencesPartNumber());
        List<WebElement> listOfCompany = driver.findElements(By.cssSelector(referencesCompany));
        customCommand.enterText(listOfCompany.get(0),addComponentForm.getAdditionalReferences().get(0).getReferencesCompany());
    }

    public void submitComponentDetails() throws InterruptedException {
        new SeleniumCustomCommand().scrollIntoView(driver,createNewComponent);
        createNewComponent.click();
    }

    public void verifyAlertMessage(String message){
        customCommand.waitForElementVisibility(driver,alertPopUpMessage);
        alertPopUpMessage.getText().equals(message);
    }

    public void closeAlertPopUp(){
        alertPopUpCloseButton.click();
    }

    public void verifyConfirmationMessage(String message){
        customCommand.waitForElementVisibility(driver,confirmationPopUpMessage);
        confirmationPopUpMessage.getText().equals(message);
    }

    public void acceptConfirmationPopup(){
        confirmationPopUpOkButton.click();
    }

    public void verifySuccessPopupMessage(String message){
        customCommand.waitForElementVisibility(driver,successPopUpMessage);
        successPopUpMessage.getText().equals(message);
    }

    public void acceptSuccessPopup(){
        successPopUpOkButton.click();
    }
}