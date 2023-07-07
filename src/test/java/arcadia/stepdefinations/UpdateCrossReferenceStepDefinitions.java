package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.pages.ComponentDB.AddNewComponentPage;
import arcadia.pages.HarnessPage;
import arcadia.pages.PageFactoryManager;
import arcadia.pages.UpdateCrossReference;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.awt.*;
import java.sql.SQLException;



public class UpdateCrossReferenceStepDefinitions {
    private final TestContext context;
    private final UpdateCrossReference  updateCrossReference;
    private final HarnessPage harnessPage;
    public UpdateCrossReferenceStepDefinitions(TestContext context){
        this.context =context;
        updateCrossReference = PageFactoryManager.getUpdateCrossReference(context.driver);
        harnessPage = PageFactoryManager.getDrawingPage(context.driver);
    }
    @And("Edit Component {string}")
    public void editComponent(String component) {updateCrossReference.editComponent(component);}

    @Then("Create additional references for the given {string}")
    public void createAdditionalReferencesForTheGivenPartNumber(String partNumber) throws InterruptedException, AWTException {
        updateCrossReference.createAdditionalReferencesForTheGivenPartNumber(partNumber);
    }

    @And("user update cross reference by searching combination {string}")
    public void userUpdateCrossReferenceBySearchingCombination(String combination) throws InterruptedException {
        clickUpdateCrossRef();
        updateCrossReference.userUpdateCrossReferenceBySearchingCombination(combination);
    }
    public void clickUpdateCrossRef() throws InterruptedException {
        Thread.sleep(4000);
        harnessPage.selectHeader("Harness");
        harnessPage.clickUpdateCrossRef();
    }

    @And("change connector part number as {string}")
    public void changeConnectorPartNumber(String inputPartNumber) throws InterruptedException {
        updateCrossReference.changeConnectorPartNumber(inputPartNumber);
    }

    @Then("check update cross reference part number value for combination {string}")
    public void checkUpdateCrossReferencePartNumberValueForCombination(String combination) {
        updateCrossReference.checkUpdateCrossReferencePartNumberValueForCombination(combination);
    }


    @And("user add terminal as {string} to the placed connector")
    public void userAddTerminalAsSupplierToThePlacedConnector(String terminalPartNumber) throws InterruptedException, AWTException {
        updateCrossReference.userAddTerminalToThePlacedConnector(terminalPartNumber);
    }

    @Then("check terminal update cross reference part number value for combination {string}")
    public void checkTerminalUpdateCrossReferencePartNumberValueForCombination(String  combination) {
        updateCrossReference.checkTerminalUpdateCrossReferencePartNumberValueFor(combination);
    }

    @And("user add plug as {string} to the placed connector")
    public void userAddPlugAsSupplierToThePlacedConnector(String sealPartNumber) throws InterruptedException, AWTException {
        updateCrossReference.userAddPlugToThePlacedConnector(sealPartNumber);
    }

    @Then("check plug update cross reference part number value for combination {string}")
    public void checkPlugUpdateCrossReferencePartNumberValueForCombination(String combination) {
        updateCrossReference.checkPlugUpdateCrossReferencePartNumberValueFor(combination);
    }
}
