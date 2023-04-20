package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.pages.ConnectorEditorPage;
import arcadia.pages.PageFactoryManager;
import arcadia.pages.SpliceEditorPage;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.awt.*;

import static arcadia.pages.BasePage.driver;

public class SpliceEditorStepDefinitions {
    private final TestContext context;

    private final SpliceEditorPage spliceEditorPage;

    public SpliceEditorStepDefinitions(TestContext context){
        this.context = context;
        spliceEditorPage = PageFactoryManager.getSpliceEditorPage(context.driver);
    }
    @And("Get default headers name")
    public void getDefaultHeadersName() {
        spliceEditorPage.getHeaders();
    }

    @Then("Check default headers name")
    public void checkDefaultHeadersName() {
        spliceEditorPage.checkDefaultHeadersName();
    }

    @And("go to drawing")
    public void goToDrawing() throws InterruptedException {
        spliceEditorPage.gotoDrawing();
    }

    @Then("check splice ID populated or not correctly")
    public void checkSpliceIDPopulatedOrNotCorrectly() {
        spliceEditorPage.checkSpliceIDPopulatedOrNotCorrectly();
    }

    @And("get spliceID from Editor page from splice ID drop down")
    public void getSpliceIDFromEditorPageFromSpliceIDDropDown() {
        spliceEditorPage.getSpliceIDFromEditorPageFromSpliceIDDropDown();
    }

    @And("Perform Clear all operation")
    public void performClearAllOperation() throws InterruptedException{
        spliceEditorPage.clearAllValue();
    }

    @Then("check in editor whether all values are disappeared or not")
    public void checkInEditorWhetherAllValuesAreDisappearedOrNot() {
        spliceEditorPage.checkInEditorWhetherAllValuesAreDisappearedOrNot();
    }

    @And("click Download Template button in editor")
    public void clickDownloadTemplateButtonInEditor() throws InterruptedException{
        spliceEditorPage.clickDownloadTemplateButtonInEditor();
    }

    @Then("check able to download template or not")
    public void checkAbleToDownloadTemplateOrNot() throws InterruptedException{
       spliceEditorPage.checkAbleToDownloadOrNot("templates_splice_editor_import_format_variants.csv");
    }

    @And("Perform remove row Operation")
    public void performRemoveRowOperation() {
        spliceEditorPage.removeRow();
    }

    @Then("Check editor detail that remove row has been performed or not")
    public void checkEditorDetailThatRemoveRowHasBeenPerformedOrNot() {
        spliceEditorPage.checkEditorDetailThatRemoveRowHasBeenPerformedOrNot();
    }

    @And("Perform undo operation")
    public void performUndoOperation() {
        spliceEditorPage.performUndoOperation();
    }

    @Then("Check editor detail that undo has been performed or not")
    public void checkEditorDetailThatUndoHasBeenPerformedOrNot() {
        spliceEditorPage.checkEditorDetailThatUndoHasBeenPerformedOrNot();
    }

    @And("Perform redo operation")
    public void performRedoOperation() {
        spliceEditorPage.performRedoOperation();
    }

    @Then("Check editor detail that redo operation has been performed or not")
    public void checkEditorDetailThatRedoOperationHasBeenPerformedOrNot() {
        spliceEditorPage.checkEditorDetailThatRedoOperationHasBeenPerformedOrNot();
    }



    @And("Hiding some headers in profile")
    public void hidingSomeHeadersInProfile() {
        spliceEditorPage.spliceEditorColumnCustomizaton();
    }


    @And("Check editor headers after hiding from profile")
    public void checkEditorHeadersAfterHidingFromProfile() {
        spliceEditorPage.checkEditorHeadersByTurningOfVisibility();
    }

    @And("Turning on all Splice editor headers visibility")
    public void turningOnAllSpliceEditorHeadersVisibility() {
        spliceEditorPage.turningOnAllConnectorEditorHeadersVisibility();
    }


    @And("Enter possible values in the splice editor")
    public void enterPossibleValuesInTheSpliceEditor() throws InterruptedException, AWTException {
        spliceEditorPage.enterPossibleValuesInTheSpliceEditor("SP-002","quickstart","19189002",true);
        spliceEditorPage.saveEditor();
    }

    @And("click export to csv")
    public void clickExportToCsv() throws InterruptedException {
        spliceEditorPage.clickExportCSVButton();
    }
    public String  getTaskID(){
        String url1 = driver.getCurrentUrl();
        String taskID = url1;
        taskID = taskID.substring(taskID.indexOf("R") + 1);
        taskID = taskID.substring(0, taskID.indexOf("&"));
        System.out.println(taskID);
        return taskID;
    }
    @Then("Check able to export csv and the entered values are present in the exported csv or not")
    public void checkAbleToExportCsvAndTheEnteredValuesArePresentInTheExportedCsvOrNot() throws InterruptedException {
        spliceEditorPage.checkAbleToDownloadOrNot("HAR"+getTaskID()+"_spliceInfo.csv");
    }

    @And("Enter values in the splice editor")
    public void enterValuesInTheSpliceEditor() throws InterruptedException, AWTException {
        spliceEditorPage.enterPossibleValuesInTheSpliceEditor("SP-002","quickstart","19189002",false);
        spliceEditorPage.saveEditor();
    }

    @Then("Check part description")
    public void checkPartDescription() {
        spliceEditorPage.checkPartDescription();
    }

    @And("Enter duplicate splice ID")
    public void enterDuplicateSpliceID() throws InterruptedException, AWTException {
        spliceEditorPage.enterPossibleValuesInTheSpliceEditor("SP-001","quickstart","19189002",false);
    }

    @Then("check validation message by saving form")
    public void checkValidationMessageBySavingForm() throws InterruptedException {
        spliceEditorPage.checkValidationMessageBySavingForm();
    }

    @And("Get values of Splice ID from editor before sorting")
    public void getValuesOfSpliceIDFromEditorBeforeSorting() throws InterruptedException, AWTException {
        spliceEditorPage.enterPartNumber();
        spliceEditorPage.enterPossibleValuesInTheSpliceEditor("SP-002","quickstart","19189002",false);
        spliceEditorPage.getValuesOfSpliceIDFromEditorBeforeSorting();
    }

    @And("Sort Splice ID column in descending order")
    public void sortSpliceIDSpliceInDescendingOrder() throws InterruptedException {
        spliceEditorPage.sortSpliceIDColumnInDescendingOrder();
    }

    @Then("Check the Value of Splice ID after sorted")
    public void checkTheValueOfSpliceIDAfterSorted() {
        spliceEditorPage.checkTheValueOfSpliceIDAfterSorted();
    }

    @And("Get values of Splice Part number from editor before sorting")
    public void getValuesOfSplicePartNumberFromEditorBeforeSorting() {
        spliceEditorPage.getValuesOfSplicePartNumberFromEditorBeforeSorting();
    }

    @And("Sort Part Number column in descending order")
    public void sortPartNumberColumnInDescendingOrder() throws InterruptedException {
        spliceEditorPage.sortPartNumberColumnInDescendingOrder();
    }

    @Then("Check the value of Splice part number after sorted")
    public void checkTheValueOfSplicePartNumberAfterSorted() {
        spliceEditorPage.checkTheValueOfSplicePartNumberAfterSorted();
    }

    @And("Selecting spliceID,ComponentDB")
    public void selectingSpliceIDComponentDB() throws InterruptedException, AWTException {
        spliceEditorPage.selectingSpliceIDComponentDB();
    }

    @Then("Check all Splice partnumber listed or not")
    public void checkAllSplicePartnumberListedOrNot() throws JsonProcessingException {
        spliceEditorPage.checkAllSplicePartnumberListedOrNot();
    }

    @And("Importing CSV by adding some values to the CSV")
    public void importingCSVByAddingSomeValuesToTheCSV() {
        spliceEditorPage.importingCSVByAddingSomeValuesToTheCSV();

    }

    @Then("Check whether able to save or not without any errors")
    public void checkWhetherAbleToSaveOrNotWithoutAnyErrors() throws InterruptedException {
        spliceEditorPage.checkWhetherAbleToSaveOrNotWithoutAnyErrors();
    }

    @Then("Check check all values are updated in editors as expected or not")
    public void checkCheckAllValuesAreUpdatedInEditorsAsExpectedOrNot() {
        spliceEditorPage.checkCheckAllValuesAreUpdatedInEditorsAsExpectedOrNot();
    }
}
