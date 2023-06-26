package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.pages.LoadWiresPage;
import arcadia.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.python.antlr.ast.Str;

public class LoadWiresStepDefinitions {
    private final TestContext context;
    private final LoadWiresPage loadWiresPage;
    public LoadWiresStepDefinitions(TestContext context){
        this.context = context;
        loadWiresPage = PageFactoryManager.getLoadWiresPage(context.driver);
    }

    @And("capture the number of projects in project folder in particular instance")
    public void captureNoOfProjectsInProjectFolder() throws InterruptedException {
        loadWiresPage.captureNoOfProjectsInProjectFolder();
    }

    @And("import base schematic task")
    public void importBaseSchematicTask() throws InterruptedException {
        loadWiresPage.importBaseSchematicTask();
    }

    @Then("check basic properties in load wires")
    public void checkBasicPropertiesInLoadWires() {
        loadWiresPage.checkBasicPropertiesInLoadWires();
    }

    @And("user tries to read number of schematic available")
    public void userTriesToReadNumberOfSchematicAvailable() {
        loadWiresPage.userTriesToReadNumberOfSchematicAvailable();
    }

    @And("user tries to load wire by removing wires by {string}")
    public void userTriesToLoadWireByRemovingWiresBy(String state) throws InterruptedException {
        loadWiresPage.userTriesToLoadWireByRemovingWiresBy(state);
        loadWiresPage.propertiesToUpdateLoadWires();
        loadWiresPage.submitLoadWires();
        loadWiresPage.wireImportInformationLoadWires();
        loadWiresPage.verifyLoadWiresSummaryAndWireImportInformation();
    }

    @Then("Check remove wires {string} is working as expected")
    public void checkRemoveWiresOffIsWorkingAsExpected(String state) throws InterruptedException {
        //loadWiresPage.addWireTable();
        loadWiresPage.checkRemoveWiresIsWorkingAsExpected(state);
    }

    @And("User import schematic {string} task")
    public void userImportsSchematicToValidateHarness(String schematicName) throws InterruptedException {
        loadWiresPage.userImportsSchematicToValidateHarness(schematicName);
    }

    @Then("check according to the tag values wires are updated or not")
    public void checkAccordingToTheTagValuesWiresAreUpdatedOrNot() throws InterruptedException {
        loadWiresPage.checkAccordingToTheTagValuesWiresAreUpdatedOrNot();
    }
    @And("user tries to load wires by inputting tag value as {string}")
    public void userTriesToLoadWiresByInputtingTagValues(String tagValue) throws InterruptedException {
        loadWiresPage.userTriesToLoadWireByRemovingWiresBy("yes");
        loadWiresPage.inputTagValues(tagValue);
        loadWiresPage.propertiesToUpdateLoadWires();
        loadWiresPage.submitLoadWires();
        loadWiresPage.wireImportInformationLoadWiresForTagValues();
        loadWiresPage.verifyLoadWiresSummaryAndWireImportInformation();
    }

    @Then("check remove wires is working as expected or not")
    public void checkRemoveWiresIsWorkingAsExpectedOrNot() throws InterruptedException {
        loadWiresPage.verifyRemoveWireIsWorkingAsExpectedOrNot();
    }


    @And("user tries to load virtual wires {string} and tags")
    public void userTriesToLoadVirtualWiresOnAndTags(String state) throws InterruptedException {
        loadWiresPage.userTriesToLoadWireByRemovingWiresBy("yes");
        loadWiresPage.inputTagValues("virtual wires");
        loadWiresPage.selectLoadVirtualWires(state);
        loadWiresPage.propertiesToUpdateLoadWires();
        loadWiresPage.submitLoadWires();
        loadWiresPage.wireImportInformationLoadWiresForTagValues();
        loadWiresPage.verifyLoadWiresSummaryAndWireImportInformation();
    }

    @Then("check according to the tag values wires are updated or not in off state")
    public void checkAccordingToTheTagValuesWiresAreUpdatedOrNotInOffState() {
        loadWiresPage.checkAccordingToTheTagValuesWiresAreUpdatedOrNotInOffState();
    }

    @And("user tries to read the name of title and part Number in the schematic task")
    public void userTriesToReadTheNameOfTitleAndPartNumberInTheSchematicTask() {
        loadWiresPage.getSchematicRevisions();
    }

    @Then("check schematic and revision in load wires")
    public void checkSchematicAndRevisionInLoadWires() {
        loadWiresPage.checkTaskAndRevisionInLoadWires();
    }

    @And("user tries to select update table {string} and input possible values")
    public void userTriesToSelectUpdateTableOnAndInputPossibleValues(String updateTable) throws InterruptedException {
        loadWiresPage.userTriesToLoadWireByRemovingWiresBy("yes");
        loadWiresPage.inputTagValues("Test3");
        loadWiresPage.userTriesToSelectUpdateTableOnAndInputPossibleValues(updateTable);
        loadWiresPage.propertiesToUpdateLoadWires();
        loadWiresPage.submitLoadWires();
        loadWiresPage.wireImportInformationLoadWiresForTagValues();
        loadWiresPage.verifyLoadWiresSummaryAndWireImportInformation();

    }

    @Then("check update table in {string} is working as expected or not")
    public void checkUpdateTableInOnIsWorkingAsExpectedOrNot(String updateTable) throws InterruptedException {
        loadWiresPage.checkUpdateTableInOnIsWorkingAsExpectedOrNot(updateTable);
    }

    @And("user tries to load wires variants by value {string}")
    public void userTriesToLoadWiresVariantsByValue(String variants) throws InterruptedException {
        loadWiresPage.userTriesToLoadWireByRemovingWiresBy("yes");
        loadWiresPage.userTriesToLoadWiresVariantsByValue(variants);
        loadWiresPage.propertiesToUpdateLoadWires();
        loadWiresPage.submitLoadWires();
    }

    @Then("check load wires variants by value {string} is update as expected or not")
    public void checkLoadWiresVariantsByValueSXIsUpdateAsExpectedOrNot(String variants) throws InterruptedException {
        loadWiresPage.checkLoadWiresVariantsByValueSXIsUpdateAsExpectedOrNot(variants);
    }

    @And("user tries to load wires by turning on component data {string}")
    public void userTriesToLoadWiresByTurningOnComponentDataOn(String loadComponentData) throws InterruptedException {
        loadWiresPage.userTriesToLoadWireByRemovingWiresBy("yes");
        loadWiresPage.loadComponent(loadComponentData);
        loadWiresPage.propertiesToUpdateLoadWires();
        loadWiresPage.submitLoadWires();
    }

    @Then("check load wires component data {string} is working as expected or not")
    public void checkLoadWiresComponentDataOnIsWorkingAsExpectedOrNot(String loadComponentData) throws InterruptedException {
        loadWiresPage.checkLoadWiresComponentDataOnIsWorkingAsExpectedOrNot(loadComponentData);
   }

    @And("user tries to submit load wires")
    public void userTriesToSubmitLoadWires() throws InterruptedException {
        loadWiresPage.userSelectsSchematic("test-mismatch");
        loadWiresPage.submitLoadWires();
    }

    @Then("check mismatch inform is highlighted in update summary report or not")
    public void checkMismatchInformIsHighlightedInUpdateSummaryReportOrNot() throws InterruptedException {
        loadWiresPage.checkMismatchInformIsHighlightedInUpdateSummaryReportOrNot();
    }
}
