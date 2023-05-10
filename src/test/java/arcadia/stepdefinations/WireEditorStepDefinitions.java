package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.pages.ConnectorEditorPage;
import arcadia.pages.PageFactoryManager;
import arcadia.pages.WireEditorPage;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.awt.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class WireEditorStepDefinitions {
    private final TestContext context;

    private final WireEditorPage wireEditorPage;

    public WireEditorStepDefinitions(TestContext context) {
        this.context = context;
        wireEditorPage = PageFactoryManager.getWireEditorPage(context.driver);
    }

    @Then("Check default headers name in wire editor")
    public void checkDefaultHeadersNameInWireEditor() throws InterruptedException {
        wireEditorPage.getHeaders();
        wireEditorPage.checkHeaders();
    }


    @Then("Check componentDB name in wire editor")
    public void checkComponentDBNameInWireEditor() {
        wireEditorPage.checkComponentDBNameInWireEditor();
    }

    @Then("Check the values are suggesting as per the connector")
    public void checkTheValuesAreSuggestingAsPerTheConnector() throws JsonProcessingException,InterruptedException, AWTException {
        wireEditorPage.enterWireID();
        wireEditorPage.checkMaterialGaugeValueFromWireEditorPage();
    }

    @And("go to drawing from wire editor in harness")
    public void goToDrawingFromWireEditorInHarness() throws InterruptedException {
        wireEditorPage.goToDrawingFromWireEditorInHarness();
    }

    @Then("Check the values are suggesting as per from-to connector and from-to cavity")
    public void checkTheValuesAreSuggestingAsPerFromToConnectorAndFromToCavity() throws InterruptedException, AWTException, JsonProcessingException, ParseException {
        wireEditorPage.enterWireID();
        wireEditorPage.checkTheValuesAreSuggestingAsPerFromToConnectorAndFromToCavity();
    }

    @And("Enter all the values in the wire editor.")
    public void enterAllTheValuesInTheWireEditor() throws InterruptedException, AWTException {
        wireEditorPage.enterWireID();
        wireEditorPage.enterFromCon();
        wireEditorPage.saveWireEditorChanges();
    }

    @Then("Check all the wire editor column values are correctly populating or not after saving details")
    public void checkAllTheWireEditorColumnValuesAreCorrectlyPopulatingOrNotAfterSavingDetails() throws AWTException {
        wireEditorPage.checkAllTheWireEditorColumnValuesAreCorrectlyPopulatingOrNotAfterSavingDetails();
    }

    @And("select material,gauge and get values of partnumber")
    public void selectMaterialGaugeAndGetValuesOfPartnumber() throws AWTException, InterruptedException {
        wireEditorPage.enterWireID();
        wireEditorPage.selectMaterialGaugeAndGetValuesOfPartnumber();
    }

    @And("Get part number value from componentdb")
    public void getPartNumberValueFromComponentdb() throws AWTException, JsonProcessingException {
        wireEditorPage.getPartNumberValueFromComponentdb();
    }

    @Then("Check the part number in wire editor matches ComponentDb or not")
    public void checkThePartNumberInWireEditorMatchesComponentDbOrNot() {
        wireEditorPage.checkThePartNumberInWireEditorMatchesComponentDbOrNot();
    }

    @And("select material,gauge and get values of colour code")
    public void selectMaterialGaugeAndGetValuesOfColourCode() throws InterruptedException, AWTException, JsonProcessingException {
        wireEditorPage.enterWireID();
        wireEditorPage.selectMaterialGaugeAndGetValuesOfPartnumber();
        wireEditorPage.selectMaterialGaugeAndGetValuesOfColourCode();
    }

    @And("Get Material,Gauge,color value from componentdb")
    public void getMaterialGaugeColorValueFromComponentdb() throws JsonProcessingException {
        wireEditorPage.getMaterialGaugeColorValueFromComponentdb();
    }

    @Then("Check the colour code in wire editor matches ComponentDb or not")
    public void checkTheColourCodeInWireEditorMatchesComponentDbOrNot() {
        Set<String> componentDBcolour= new HashSet<>(wireEditorPage.componentDBColour);
        (wireEditorPage.componentDBColour).clear();
        (wireEditorPage.componentDBColour).addAll(componentDBcolour);
        Collections.sort(wireEditorPage.componentDBColour);
        Collections.sort(wireEditorPage.editorColourdata);
        System.out.println(wireEditorPage.componentDBColour);
        System.out.println(wireEditorPage.editorColourdata);
        Assert.assertEquals(wireEditorPage.editorColourdata,wireEditorPage.componentDBColour);
    }

    @And("Enter Possible Values in the form.")
    public void enterPossibleValuesInTheForm() throws InterruptedException, AWTException {
        wireEditorPage.enterWireID();
        wireEditorPage.enterFromCon();
        wireEditorPage.saveWireEditorChanges();
    }

    @Then("Check Redo,Undo,Remove Row.")
    public void checkRedoUndoRemoveRow() throws InterruptedException {
        wireEditorPage.checkRedoUndoRemoveRow();
    }

    @And("Enter possible values in the wire editor")
    public void enterPossibleValuesInTheWireEditor() throws InterruptedException, AWTException {
        wireEditorPage.enterWireID();
        wireEditorPage.enterFromCon();
        wireEditorPage.saveWireEditorChanges();
    }

    @And("click export to csv in wire editor")
    public void clickExportToCsvInWireEditor() throws InterruptedException {
        wireEditorPage.clickExportToCsvInWireEditor();
    }
    @Then("Check able to download template or not in wire editor")
    public void checkAbleToDownloadTemplateOrNotInWireEditor() throws InterruptedException {
        wireEditorPage.checkAbleToDownloadOrNot("wire_editor_import_format_grp.csv");
    }

    @Then("Check able to export csv and the entered values are present in the exported csv or not in wire editor")
    public void checkAbleToExportCsvAndTheEnteredValuesArePresentInTheExportedCsvOrNotInWireEditor() {
        
    }

    @And("click download template in wire editor")
    public void clickDownloadTemplateInWireEditor() throws InterruptedException {
        wireEditorPage.clickDownloadTemplateButtonInEditor();
    }

    @Then("Check able to export csv in wire editor")
    public void checkAbleToExportCsvInWireEditor() throws InterruptedException {
        wireEditorPage.checkAbleToDownloadOrNot("wires.csv");
    }

    @And("Enter WireID, From Con,From Cav,TO Conn,To Cav.")
    public void enterWireIDFromConFromCavTOConnToCav() throws InterruptedException, AWTException {
        wireEditorPage.enterWireID();
        wireEditorPage.enterConIDCav();
        wireEditorPage.clickUpdatePartNO();
    }

    @Then("Check Whether the value are saved Correctly or not by updating part number.")
    public void checkWhetherTheValueAreSavedCorrectlyOrNotByUpdatingPartNumber() throws InterruptedException, AWTException {
        wireEditorPage.saveWireEditorChanges();
        wireEditorPage.checkWhetherTheValueAreSavedCorrectlyOrNotByUpdatingPartNumber();
    }

    @And("Importing CSV by adding some values to the CSV in wire editor")
    public void importingCSVByAddingSomeValuesToTheCSVInWireEditor() throws InterruptedException {
        wireEditorPage.importingCSVByAddingSomeValuesToTheCSVInWireEditor();
    }

    @Then("Check whether able to save or not without any errors in wire editor")
    public void checkWhetherAbleToSaveOrNotWithoutAnyErrorsInWireEditor() throws InterruptedException {
        wireEditorPage.saveWireEditorChanges();
        Thread.sleep(5000);
    }

    @And("Fill the Wire Editor form,Save and select wire class as multicore.")
    public void fillTheWireEditorFormSaveAndSelectWireClassAsMulticore() throws InterruptedException, AWTException {
        wireEditorPage.enterWireID();
        wireEditorPage.enterWireClass();
        wireEditorPage.validateCoreIDMCIDAlertMessage();
        wireEditorPage.clickUpdatePartNO();
    }

    @Then("Check the form by not filling the CORE ID and MC ID.")
    public void checkTheFormByNotFillingTheCOREIDAndMCID() throws AWTException, InterruptedException {
        wireEditorPage.enterCoreIDMultiID();
        wireEditorPage.clickUpdatePartNO();
        wireEditorPage.saveWireEditorChanges();
    }

    @And("Hide some headers in the wire editor")
    public void hideSomeHeadersInTheWireEditor() throws InterruptedException {
        wireEditorPage.hideSomeHeadersInTheWireEditor();

    }

    @And("Check whether able to save without any error or not")
    public void checkWhetherAbleToSaveWithoutAnyErrorOrNot() throws InterruptedException {
        wireEditorPage.saveWireEditorChanges();
        wireEditorPage.getHeaders();
        wireEditorPage.checkHeadersAfterHidingColumns();
    }

    @Then("check after saving values are correctly populated or not.")
    public void checkAfterSavingValuesAreCorrectlyPopulatedOrNot() {
        wireEditorPage.checkAfterSavingValuesAreCorrectlyPopulatedOrNot();
    }

    @And("Enter all possible values in the wire editor")
    public void enterAllPossibleValuesInTheWireEditor() throws InterruptedException, AWTException {
        Thread.sleep(3000);
        wireEditorPage.enterWireID();
        wireEditorPage.enterFromCon();
    }
}
