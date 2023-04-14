package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.pages.ConnectorEditorPage;
import arcadia.pages.PageFactoryManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.awt.*;
import java.time.Duration;

import static arcadia.pages.BasePage.driver;

public class ConnectorEditorStepDefinitions {
    private final TestContext context;

    private final ConnectorEditorPage connectorEditorPage;

    public ConnectorEditorStepDefinitions(TestContext context){
        this.context = context;
        connectorEditorPage = PageFactoryManager.getConnectorEditorPage(context.driver);
    }
    @And("user enters details to add connector")
    public void userEntersDetailsToAddConnector() throws InterruptedException, AWTException, JsonProcessingException {
       connectorEditorPage.enterConnectorDetails("X-003","quickstart","connector","FFH04142BK*T","FCI_FIN LOCK_4-WAY_RECEP HSG");
    }

    @And("go to drawing in connector editor")
    public void goToDrawing() {
        connectorEditorPage.gotoDrawing();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @And("Turning {string} Connector ID Group")
    public void turningOnConnectorIDGroup(String options) throws InterruptedException {
        connectorEditorPage.turningOnConnectorIDGroup(options);
    }

    @And("Hiding some headers in profile in connector editor")
    public void turningOFF() throws InterruptedException {
        connectorEditorPage.connectorEditorColumnCustomizaton();
    }

    @Then("Check editor headers by turning of visibility")
    public void checkEditorHeadersByTurningOfVisibility() {
        connectorEditorPage.checkEditorHeadersByTurningOfVisibility();
    }
    @And("Perform remove row Operation in connector editor")
    public void performRemoveRowOperation() {
        connectorEditorPage.removeRow();
    }

    @Then("Check editor detail that remove row has been performed or not in connector editor")
    public void checkEditorDetailThatRemoveRowHasBeenPerformedOrNot() {
       connectorEditorPage.checkRemoverow();
    }

    @And("Perform undo operation in connector editor")
    public void performUndoOperation() {
        connectorEditorPage.undo();
    }

    @Then("Check editor detail that undo has been performed or not in connector editor")
    public void checkEditorDetailThatUndoHasBeenPerformedOrNot() {
        connectorEditorPage.checkUndo();
    }

    @And("Perform redo operation in connector editor")
    public void performRedoOperation() {
        connectorEditorPage.redo();
    }

    @Then("Check editor detail that redo operation has been performed or not in connector editor")
    public void checkEditorDetailThatRedoOperationHasBeenPerformedOrNot() {
        connectorEditorPage.checkRedo();
    }

    @And("Perform Clear all operation in connector editor")
    public void performClearAllOperation() throws InterruptedException {
        connectorEditorPage.clearAllValue();
    }

    @Then("check in editor whether all values are disappeared or not in connector editor")
    public void checkInEditorWhetherAllValuesAreDisappearedOrNot() {
        connectorEditorPage.checkInEditorWhetherAllValuesAreDisappearedOrNot();
    }

    @And("Check editor headers after hiding from profile in connector editor")
    public void checkEditorHeadersAfterHidingFromProfile() {
        connectorEditorPage.checkEditorHeadersByTurningOfVisibility();
    }

    @And("Turning on all connector editor headers visibility")
    public void turningOnAllConnectorEditorHeadersVisibility() {
        connectorEditorPage.turningOnAllConnectorEditorHeadersVisibility();
    }

    @And("Get default headers name in connector editor")
    public void getDefaultHeadersName() {
        connectorEditorPage.getHeaders();
    }

    @Then("Check default headers name in connector editor")
    public void checkDefaultHeadersName() {
        connectorEditorPage.checkDefaultHeadersName();
    }

    @And("Selecting ConnectorID,ComponentDB,partype as {string}")
    public void selectingConnectorIDComponentDBPartype(String parttype) throws InterruptedException, JsonProcessingException, AWTException {
        connectorEditorPage.enterconnectorIDCompParttype("X-003","quickstart",parttype);
        System.out.println(parttype);
    }

    @Then("Check all Connector partnumber listed or not")
    public void checkAllConnectorPartnumberListedOrNot() throws JsonProcessingException {
        connectorEditorPage.checkAllConnectorPartnumberListedOrNot();
    }

    @Then("Check all terminal partnumber listed or not")
    public void checkAllTerminalPartnumberListedOrNot() throws JsonProcessingException {
        connectorEditorPage.checkAllTerminalPartnumberListedOrNot();
    }

    @And("get connectorID from Editor page from con ID drop down")
    public void getConnectorIDFromEditorPageFromConIDDropDown() {
        connectorEditorPage.getConnectorIDFromEditorPageFromConIDDropDown();
    }

    @Then("check connector ID populated or not correctly")
    public void checkConnectorIDPopulatedOrNotCorrectly() {
        connectorEditorPage.checkConnectorIDPopulatedOrNotCorrectly();
    }

    @And("get parttype from Editor from part type dropdown")
    public void getParttypeFromEditorFromPartTypeDropdown() throws InterruptedException, AWTException {
        connectorEditorPage.getParttypeFromEditorFromPartTypeDropdown();
    }

    @Then("check parttype is populating correctly or not")
    public void checkParttypeIsPopulatingCorrectlyOrNot() {
        connectorEditorPage.checkParttypeIsPopulatingCorrectlyOrNot();
    }

    @And("click Download Template button in connector editor")
    public void clickDownloadTemplateButtonInEditor() throws InterruptedException {
        connectorEditorPage.clickDownloadTemplateButtonInEditor();
    }

    @Then("check able to download template or not in connector editor")
    public void checkAbleToDownloadTemplateOrNot() {
        connectorEditorPage.checkAbleToDownloadOrNot("templates_connector_editor_import_format_variants.csv");   }

    @And("Enter possible values in the connector editor")
    public void enterPossibleValuesInTheConnectorEditor() throws InterruptedException, AWTException {
        connectorEditorPage.enterPossibleValuesInTheConnectorEditor("X-003","quickstart","connector","FFH04142BK*T");
    }

    @And("click export to csv in connector editor")
    public void clickExportToCsv() throws InterruptedException {
        connectorEditorPage.clickExportCSVButton();
    }
    public String  getTaskID(){
        String url1 = driver.getCurrentUrl();
        String taskID = url1;
        taskID = taskID.substring(taskID.indexOf("R") + 1);
        taskID = taskID.substring(0, taskID.indexOf("&"));
        System.out.println(taskID);
        return taskID;
    }
    @Then("Check able to export csv and the entered values are present in the exported csv or not in connector editor")
    public void checkAbleToExportCsvAndTheEnteredValuesArePresentInTheExportedCsvOrNot() {
        connectorEditorPage.checkAbleToDownloadOrNot("HAR"+getTaskID()+"_conInfo.csv");
    }

    @Then("Check part description and cavities")
    public void checkPartDescriptionAndCavities() {
        connectorEditorPage.checkPartDescriptionAndCavities();
    }

    @And("Enter values in the connector editor")
    public void enterValuesInTheConnectorEditor() throws InterruptedException, AWTException {
        connectorEditorPage.enterValuesInTheConnectorEditor("X-003","quickstart","connector","FFH04142BK*T");
    }

    @Then("Check all entered possible values are saved or not")
    public void checkAllEnteredPossibleValuesAreSavedOrNot() throws InterruptedException {
        connectorEditorPage.checkAllEnteredPossibleValuesAreSavedOrNot();
    }

    @And("Enter duplicate connector ID")
    public void enterDuplicateConnectorID() throws InterruptedException, AWTException {
        connectorEditorPage.enterDuplicateConnectorID("X-002");
    }

    @Then("check validation message by saving form in connector editor")
    public void checkValidationMessageBySavingForm() throws InterruptedException {
        connectorEditorPage.checkValidationMessageBySavingForm();
    }

    @And("Get values of Connector ID from editor before sorting")
    public void getValuesOfConnectorIDFromEditorBeforeSorting() {
        connectorEditorPage.getValuesOfConnectorIDFromEditorBeforeSorting();
    }

    @And("Sort Connector ID column in descending order")
    public void sortConnectorIDColumn() throws InterruptedException {
        connectorEditorPage.sortConnectorIDColumn();
    }

    @Then("Check the Value of connector ID after sorted")
    public void checkTheValueOfConnectorIDAfterSorted() {
        connectorEditorPage.checkTheValueOfConnectorIDAfterSorted();
    }

    @And("Get values of Connector Part number from editor before sorting")
    public void getValuesOfConnectorPartNumberFromEditorBeforeSorting() {
        connectorEditorPage.getValuesOfPArtNumberFromEditorBeforeSorting();
    }

    @Then("Check the value of connector part number after sorted")
    public void checkTheValueOfConnectorPartnumberAfterSorted() {
        connectorEditorPage.checkTheValueOfPartNumberAfterSorted();
    }

    @And("Sort Part Number column in descending order in connector editor")
    public void sortPartNumberColumnInDescendingOrder() throws InterruptedException {
        connectorEditorPage.sortPartNumberColumn();
    }

    @And("Enter Connector ID,Component DB,Cavities in Editor")
    public void enterConnectorIDComponentDBCavitiesInEditor() throws InterruptedException, AWTException {
        connectorEditorPage.enterConnectorIDComponentDBCavitiesInEditor("X-004","4");
    }

    @And("Get Connector partnumber response from editor")
    public void getConnectorPartnumberResponseFromEditor() throws JsonProcessingException {
        connectorEditorPage.getConnectorPartnumberResponseFromEditor("connector","4");
    }

    @Then("Check whether partnumber is suggesting as per cavities")
    public void checkWhetherPartnumberIsSuggestingAsPerCavities() throws JsonProcessingException {
        connectorEditorPage.getPartnumberFromComponentDB();
        connectorEditorPage.checkWhetherPartnumberIsSuggestingAsPerCavities();
    }

    @And("Enter duplicate connector ID,component DB,cavities in editor")
    public void enterDuplicateConnectorIDComponentDBCavitiesInEditor() throws InterruptedException, AWTException {
        connectorEditorPage.enterDuplicateConnectorIDComponentDBCavitiesInEditor();
    }

    @And("Enter group ID editor")
    public void enterGroupIDEditor() {
        connectorEditorPage.enterGroupIDEditor();
    }

    @Then("Check able to save editor or not")
    public void checkAbleToSaveEditorOrNot() throws InterruptedException {
        connectorEditorPage.checkAbleToSaveEditorOrNot();
    }

    @Then("Whether new connectors are added or not")
    public void whetherNewConnectorsAreAddedOrNot() throws InterruptedException {
        connectorEditorPage.whetherNewConnectorsAreAddedOrNot();
    }

    @And("Importing CSV by adding some values to the CSV in connector editor")
    public void importingCSVByAddingSomeValuesToTheCSV() {
        connectorEditorPage.importingCSVByAddingSomeValuesToTheCSV();
    }

    @Then("Check whether able to save or not without any errors in connector editor")
    public void checkWhetherAbleToSaveOrNotWithoutAnyErrors() throws InterruptedException {
        connectorEditorPage.checkWhetherAbleToSaveOrNotWithoutAnyErrors();
    }

    @Then("Check check all values are updated in editors as expected or not in connector editor")
    public void checkCheckAllValuesAreUpdatedInEditorsAsExpectedOrNot() {
        connectorEditorPage.checkCheckAllValuesAreUpdatedInEditorsAsExpectedOrNot();
    }
}



