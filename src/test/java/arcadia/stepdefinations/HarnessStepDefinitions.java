package arcadia.stepdefinations;

import arcadia.context.FlowContext;
import arcadia.context.TestContext;
import arcadia.domainobjects.ConnectorPlugIdentifier;
import arcadia.domainobjects.Harness;
import arcadia.mapperObjects.TestMapper;
import arcadia.pages.*;
import arcadia.pages.ComponentDB.AddNewComponentPage;
import arcadia.utils.ConversionUtil;
import arcadia.utils.DrawingHelper;
import arcadia.utils.SeleniumCustomCommand;
import arcadia.utils.StringHelper;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.hu.Ha;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static arcadia.context.FlowContext.harnessComponentAlreadyCreated;

public class HarnessStepDefinitions {
    private final CreateHarness createHarness;
    private final HarnessPage harnessPage;
    private final ProjectLanding projectLanding;
    private final TestContext context;
    ConversionUtil conversionUtil = new ConversionUtil();
    public HarnessStepDefinitions(TestContext context){
        this.context = context;
        createHarness = PageFactoryManager.getCreateHarness(context.driver);
        harnessPage = PageFactoryManager.getDrawingPage(context.driver);
        projectLanding = PageFactoryManager.getProjectLanding(context.driver);
    }

    @And("harness with name {string} is launched successfully")
    public void harness_with_name_is_launched_successfully(String connectorDescription) throws InterruptedException {
        Boolean isHarnessAlreadyExists = new HarnessPage(context.driver).isHarnessAlreadyExists(connectorDescription);
        if(isHarnessAlreadyExists){
            openExistingHarness(connectorDescription);
        }
        if(!isHarnessAlreadyExists){
            createNewHarnessInstance(connectorDescription);
        }
    }

    private void createNewHarnessInstance(String connectorDescription) throws InterruptedException {
        String partNumber = new StringHelper().generateRandomDigit().toString();
        projectLanding.invokeCreateHarness();
        arcadia.mapperObjects.CreateHarness harnessData = new arcadia.mapperObjects.CreateHarness();
        harnessData.setComponentDB(System.getProperty("componentDB"));
        harnessData.setProfile(System.getProperty("profileName"));
        harnessData.setPartNumber(partNumber);
        harnessData.setDescription(connectorDescription);
        harnessData.setRevision(new StringHelper().generateRandomDigit().toString());
        harnessData.setTitle(new StringHelper().generateRandomDigit().toString());
        harnessData.setWorkTask(new StringHelper().generateRandomDigit().toString());
        FlowContext.testDescription = connectorDescription;
        createHarness.submitHarnessData(new Harness(harnessData.getWorkTask(), harnessData.getTitle(), harnessData.getDescription(), harnessData.getPartNumber(), harnessData.getRevision(), harnessData.getComponentDB(),harnessData.getProfile()));
    }

    private void openExistingHarness(String connectorDescription) {
       WebElement harnessElement =  context.driver.findElement(By.xpath("//table[@id=\"tableHAR\"]/tbody//tr//td[text()=\"" + connectorDescription + "\"]"));
        harnessElement.click();
        if(!connectorDescription.equalsIgnoreCase("connectorFilter")){
            harnessComponentAlreadyCreated = true;
        }
        try{
            new AddNewComponentPage(context.driver).verifyConfirmationMessage("It appears you are already editing this task! It is advised that you only edit a single instance of this task");
            new AddNewComponentPage(context.driver).acceptConfirmationPopup();
        }
        catch (Exception e){
            new SeleniumCustomCommand().waitForElementVisibility(context.driver, context.driver.findElement(By.cssSelector("div[title=\"Insert Connector\"]")));
        }
    }


    @And("harness is created successfully")
    public void createHarness() throws IOException, InterruptedException {
        String description = String.format("testdescription-%04d", new StringHelper().generateRandomDigit());
        createNewHarnessInstance(description);
    }

    @And("User try operation {string} for connector")
    public void userTryOperationDeleteForConnectorWithIdCCAEdDeEBcf(String operation) throws InterruptedException {
        List<ConnectorPlugIdentifier> connector_ids=new ConnectorPage(context.driver).getConnectorPlugELementIdsFromDrawingPage();
        String identifier=connector_ids.get(0).getConnectorId();
        new HarnessPage(context.driver).getContextMenu(identifier);
        new HarnessPage(context.driver).performOperation(operation,identifier);
        Thread.sleep(10000);
    }
    @And("harness connectorvalidator is opened")
    public void harnessConnectorvalidatorIsOpened() throws InterruptedException {
        Thread.sleep(3000);
       // new DrawingHelper().openValidatorHarness(context.driver);
    }

    @And("connector plug {string} is opened")
    public void connectorPlugIsOpened(String connectorPlugIndex) throws InterruptedException {
//        Thread.sleep(3000);
        new HarnessPage(context.driver).clickOnSelect();
        String connectorid = new ConnectorPage(context.driver).getConnectorPlugELementIdsFromDrawingPage().get(Integer.parseInt(connectorPlugIndex)).getConnectorId();
        harnessPage.clickConnectorPlug(connectorid);
    }

    @And("user sets label {string} to {string}")
    public void userSetsLabelsToShowHide(String labelName, String showHide) throws InterruptedException {
        Thread.sleep(4000);
        harnessPage.selectHeader("Advanced");
        harnessPage.clickVisibility();
        harnessPage.showHideComponentLabel(labelName,showHide);
    }

    @And("User deletes Harness {string} successfully")
    public void harnessIsDeletedSuccessfully(String harnessDescription) {
        if(harnessDescription==""){
            harnessDescription = FlowContext.testDescription;
        }
        harnessPage.deleteHarness(harnessDescription);
    }

    @And("User exits the drawing page")
    public void userExitsTheDrawingPage() throws InterruptedException {
        harnessPage.exitDrawingPage();
    }

    @Then("Verify CavityTableData is displayed on connector {string}")
    public void verifyCavityTableDataIsDisplayedOnConnector(String connectorPlugIndex) throws InterruptedException {
        List<String> expectedHeaders = Arrays.asList("Cav.","Wire","Colour","Gauge","Length (\")","Mat.","Opt.","To Loc.","Dest.","Signal","Term. PN","Term. Mat","Seal","Plug","Mult. ID","Ident Tag","Outer Dia","Wire CSA","From Tag","To Tag","Variant","Core ID","Term. Strip Length","Cavity Addon","Terminal Finish","Entry Port");
        String connectorid = FlowContext.connectorPlugIdentifierList.get(Integer.parseInt(connectorPlugIndex)).getConnectorId();
        harnessPage.verifyCavityTableColumnsDisplayed(connectorid,expectedHeaders);
        String colour = "BK";
        String gauge = "1.5";
        String length = "5.15";
        String material = "FLRY";
        String dest = "X-002/1";
        String outerdia = "2";
        String wirecsa = "2";
        String fromTag = "X-001";
        String toTag = "X-002";
        String cavityAddOn = "0.39\"";
        String entryPort = "EP_0";
        harnessPage.verifyCavityTableData(connectorid,colour,gauge,length,material,dest,outerdia,wirecsa,fromTag,toTag,cavityAddOn,entryPort);
    }

    @Then("Verify data is wrapped and displayed on connector {string}")
    public void verifyRowsDisplayedOnConnector(String connectorPlugIndex) {
        String connectorid = FlowContext.connectorPlugIdentifierList.get(Integer.parseInt(connectorPlugIndex)).getConnectorId();
        harnessPage.verifyCavityTableWrapped(connectorid);
    }

    @Then("User verifies the connector {string} is deleted successfully")
    public void userVerifiesTheConnectorIsDeletedSuccessfully(String connectorIndex) {
        String connectorid = FlowContext.connectorPlugIdentifierList.get(Integer.parseInt(connectorIndex)).getConnectorId();
        harnessPage.verifyConnectorDoNotExists(connectorid);
    }

    @Then("User verifies reset label works as expected")
    public void userVerifiesResetLabelWorksAsExpected() throws InterruptedException {
        String connectorid = FlowContext.connectorPlugIdentifierList.get(0).getConnectorId();
        harnessPage.verifyResetLabels(connectorid);
    }

    @When("User moves the label {string} to a different position")
    public void userMovesLabelToADifferentPosition(String elementToBeMoved) throws InterruptedException {
//        harnessPage.clickOnMove();
//        harnessPage.clickConnectorDescriptionElement(FlowContext.testDescription, FlowContext.connectorPlugIdentifierList.get(0).getConnectorId());

    }

    @Then("User verify {string} labels are displayed as expected")
    public void userVerifyConnectorLabelsAreDisplayedAsExpected(String labelType) {
        switch (labelType.toLowerCase()){
            case "connector":
                harnessPage.verifyConnectorLabels(FlowContext.connectorID, FlowContext.testDescription);
                break;
        }
    }
}
