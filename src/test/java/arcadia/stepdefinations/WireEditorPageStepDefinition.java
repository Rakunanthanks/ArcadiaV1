package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.domainobjects.WiresComponentDB;
import arcadia.pages.ComponentDB.Wires.WiresComponentDBPage;
import arcadia.pages.PageFactoryManager;
import arcadia.pages.WireEditorPage;
import arcadia.utils.RestAssuredUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import static arcadia.pages.BasePage.driver;


public class WireEditorPageStepDefinition {
    private final WireEditorPage WireEditorPage;
    private final TestContext context;

    public WireEditorPageStepDefinition(TestContext context) {
        this.context = context;
        WireEditorPage = PageFactoryManager.getWireEditorPage(context.driver);
    }

    @And("Navigated to Wire Editor")
    public void navigated_to_WireEditorPage() throws InterruptedException, AWTException {

        WireEditorPage.navigatedtoWireEditorPage();
    }


    @Then("Check the values are suggesting as per from-to connector and from-to cavity")
    public void   checkTheValuesAreSuggestingAsPerFromToConnectorAndFromToCavity() throws InterruptedException {
        WireEditorPage.checkfromconntocavvalue();
    }



    @Then("Check the values are suggesting as per the connector")
    public void checkTheValuesAreSuggestingAsPerTheConnector() throws JsonProcessingException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs = new RestAssuredUtility();
        String response = rs.getComponentDbResponse("wire", driver);
        List<WiresComponentDB> dbData = new WiresComponentDBPage(driver).getWireAPIData(response);
        List<String>  DbDataGauge = new ArrayList<>();
        List<String>  DbDataMaterial = new ArrayList<>();
        DbDataGauge = dbData.stream().map(x -> x.getGauge()).collect(Collectors.toList());
        DbDataMaterial = dbData.stream().map(x -> x.getWirematerial()).collect(Collectors.toList());
        Set<String> componentbgauge = new HashSet<>(DbDataGauge);
        (DbDataGauge).clear();
        (DbDataGauge).addAll(componentbgauge);
        Set<String> componentbmaterial = new HashSet<>(DbDataMaterial);
        (DbDataMaterial).clear();
        (DbDataMaterial).addAll(componentbmaterial);
        Collections.sort(DbDataGauge);
        Collections.sort(DbDataMaterial);
        Collections.sort(WireEditorPage.materiallist);
        Collections.sort(WireEditorPage.gaugelist);
        System.out.println(WireEditorPage.materiallist);
        System.out.println(WireEditorPage.gaugelist);
        System.out.println(DbDataMaterial);
        System.out.println(DbDataGauge);
        Assert.assertEquals(WireEditorPage.materiallist,DbDataMaterial);
        Assert.assertEquals(WireEditorPage.gaugelist,DbDataGauge);
    }

    @And("Get Material,Gauge value from WireEditorPage")
    public void getMaterialGaugeValueFromWireEditorPage() throws InterruptedException {
        WireEditorPage.getvaluesWireEditorPage();
    }

    @And("select material,gauge and get values of colour code")
    public void selectMaterialGaugeAndGetValuesOfColourCode() throws InterruptedException {
        WireEditorPage.select_get_colour_code();
    }

    @And("Get Material,Gauge,color value from componentdb")
    public void getMaterialGaugeColorValueFromWireEditorPage() throws InterruptedException, AWTException, JsonProcessingException {
        WireEditorPage.get_material_gauge_colour();
    }

    @Then("Check the colour code in wire editor matches ComponentDb or not")
    public void checkTheColourCodeInWireEditorPageMatchesComponentDbOrNot() {
        Set<String> componentcolour= new HashSet<>(WireEditorPage.componentdbcolour);
        (WireEditorPage.componentdbcolour).clear();
        (WireEditorPage.componentdbcolour).addAll(componentcolour);
        Collections.sort(WireEditorPage.componentdbcolour);
        Collections.sort(WireEditorPage.colourlist);
       Assert.assertEquals(WireEditorPage.componentdbcolour,WireEditorPage.colourlist);

   }

    @And("select material,gauge and get values of partnumber")
    public void selectMaterialGaugeAndGetValuesOfPartnumber() throws InterruptedException {
        WireEditorPage.selectMaterialGaugeAndGetValuesOfPartnumber();
    }

    @And("Get part number value from componentdb")
    public void getPartnumberValueFromComponentdb() throws JsonProcessingException {
        WireEditorPage.getPartnumberValueFromComponentdb();
    }

    @Then("Check the part number in wire editor matches ComponentDb or not")
    public void checkThePartNumberInWireEditorPageMatchesComponentDbOrNot() {
        Collections.sort(WireEditorPage.componentbpartnumber);
        Collections.sort(WireEditorPage.partnumberlist);
        System.out.println(WireEditorPage.componentbpartnumber);
        System.out.println(WireEditorPage.partnumberlist);
        Assert.assertEquals(WireEditorPage.componentbpartnumber,WireEditorPage.partnumberlist);
    }

    @And("select material,gauge,color")
    public void selectMaterialGaugeColor() throws InterruptedException {
        WireEditorPage.selectMaterialGaugeColor();
    }

    @And("get wire part number from wire editor")
    public void getWirePartNumberFromWireEditorPage() throws InterruptedException {
        WireEditorPage.getWirePartNumberFromWireEditorPage();
    }

    @Then("Check the part number matches the ComponentDb or not")
    public void checkThePartNumberMatchesTheComponentDbOrNot() throws JsonProcessingException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs = new RestAssuredUtility();
        String response = rs.getComponentDbResponse("wire", context.driver);
        List<WiresComponentDB> dbData = new WiresComponentDBPage(context.driver).getWireAPIData(response);
        List<WiresComponentDB> filteredDbData = new ArrayList<>();
        filteredDbData = dbData.stream().filter(x -> x.getPartnumber().equals(WireEditorPage.partnumber_value)).collect(Collectors.toList());
        Assert.assertEquals(filteredDbData.get(0).getWirematerial(),WireEditorPage.material_value, "Material is not matching as expected with Selected component DB");
        Assert.assertEquals(filteredDbData.get(0).getGauge(),WireEditorPage.gauge_value, "Gauge is not matching as expected with Selected component DB");
        Assert.assertEquals(filteredDbData.get(0).getWirecsa(),WireEditorPage.wireeditorcsa_value,"CSA is not matching as expected with Selected component DB");
        Assert.assertEquals(filteredDbData.get(0).getOutsidedia(),WireEditorPage.wireeditorod_value, "OD is not matching as expected with Selected component DB");
        Assert.assertEquals(filteredDbData.get(0).getColour(), WireEditorPage.colour_value, "Colour is not matching as expected with Selected component DB");
    }

    @And("Enter all the values in the wire editor.")
    public void enterAllTheValuesInTheWireEditor() throws InterruptedException, AWTException {
        WireEditorPage.enterAllTheValuesInTheWireEditor();
    }
    @Then("Check all the wire editor column values are correctly populating or not after saving details")
    public void checkAllTheWireEditorColumnValuesAreCorrectlyPopulatingOrNotAfterSavingDetails() {
        Assert.assertEquals(WireEditorPage.actrualWireEditorList, WireEditorPage.savedlist,"The values are not expected in Wire Editor after the values are getting saved");
    }

    @And("Enter WireID, From Con,From Cav,TO Conn,To Cav.")
    public void enterWireIDFromConFromCavTOConnToCav() throws InterruptedException {
        WireEditorPage.enterWireIDFromConFromCavTOConnToCav();
    }

    @Then("Check Whether the value are saved Correctly or not by updating part number.")
    public void checkWhetherTheValueAreSavedCorrectlyOrNotByUpdatingPartNumber() {
        String expectedAlertMessage = "Wires imported successfully.";
        Assert.assertEquals(WireEditorPage.actualAlertMessage,expectedAlertMessage,"Update part number is not updating the details in form that is blocking form data to save");
    }

    @And("Enter Possible Values in the form.")
    public void enterPossibleValuesInTheForm() throws InterruptedException {
        WireEditorPage.enterPossibleValuesInTheForm();
    }

    @Then("Check Redo,Undo,Remove Row.")
    public void checkRedoUndoRemoveRow() throws InterruptedException {
        WireEditorPage.checkRedoUndoRemoveRow();
    }

    @Then("Check whether in the wire editor it brings the selected componentDB or not")
    public void checkWhetherInTheWireEditorItBringsTheSelectedComponentDBOrNot() throws InterruptedException {
       WireEditorPage.checkautoselectscomponentDBornot();
    }

    @And("unselect the headers in the wire editor and save.")
    public void deselectTheHeadersInTheWireEditorAndSave() throws InterruptedException {
        WireEditorPage.unselectTheHeadersInTheWireEditorAndSave();
    }

    @Then("Check Whether Unselected headers are hided.")
    public void checkWhetherDeslectedHeadersAreHided() {
       Assert.assertEquals(WireEditorPage.actualHeaderList,WireEditorPage.expectedHeaderList);
    }

    @And("Fill the Wire Editor form,Save and Export csv.")
    public void fillTheWireEditorFormSaveAndExportCsv() throws InterruptedException, IOException {
        WireEditorPage.fillTheWireEditorFormSaveAndExportCsv();
    }

    @Then("Check whether exported CSV matches the Expected CSV or not.")
    public void checkWhetherExportedCSVMatchesTheExpectedCSVOrNot() {
        WireEditorPage.checkWhetherExportedCSVMatchesTheExpectedCSVOrNot();
    }

    @And("Fill the Wire Editor form,Save and select wire class as multicore.")
    public void fillTheWireEditorFormSaveAndSelectWireClassAsMulticore() throws InterruptedException {
        WireEditorPage.fillTheWireEditorFormSaveAndSelectWireClassAsMulticore();
    }

    @Then("Check the form by not filling the CORE ID and MC ID.")
    public void checkTheFormByNotFillingTheCOREIDAndMCID() throws InterruptedException {
        WireEditorPage.checkTheFormByNotFillingTheCOREIDAndMCID();
    }

    @Then("Check the form by fill all the possible values in the form.")
    public void checkTheFormByFillAllThePossibleValuesInTheForm() throws InterruptedException, AWTException {
       WireEditorPage.checkTheFormByFillAllThePossibleValuesInTheForm();
    }

    @Then("Check whether the imported csv has been saved successful or not without errors.")
    public void checkWhetherTheImportedCsvHasBeenSavedsuccessfulOrNotWithoutErrors() throws IOException, InterruptedException {
        WireEditorPage.checkWhetherTheImportedCsvHasBeenSavedsuccessfulOrNotWithoutErrors();
    }

    @And("Import the exported csv.")
    public void importTheExportedCsv() throws InterruptedException {
        WireEditorPage.importTheExportedCsv();
    }

    @And("Fill the Wire Editor form,Save and Export csv and check for any errors.")
    public void fillTheWireEditorFormSaveAndExportCsvAndCheckForAnyErrors() throws IOException, InterruptedException {
        WireEditorPage.fillTheWireEditorFormSaveAndExportCsvAndCheckForAnyErrors();
    }

    @And("Clear all the values in Wire Editor form.")
    public void clearAllTheValuesInWireEditorForm() throws InterruptedException {
        WireEditorPage.clearAllTheValuesInWireEditorForm();
    }

    @Then("Check whether the imported csv has been saved successful or not without errors by clearing all the values in the from.")
    public void checkWhetherTheImportedCsvHasBeenSavedSuccessfulOrNotWithoutErrorsByClearingAllTheValuesInTheFrom() throws IOException, InterruptedException {
        WireEditorPage.checkWhetherTheImportedCsvHasBeenSavedSuccessfulOrNotWithoutErrorsByClearingAllTheValuesInTheFrom();
    }
}
