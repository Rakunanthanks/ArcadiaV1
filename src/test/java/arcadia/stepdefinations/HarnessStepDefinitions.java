package arcadia.stepdefinations;

import arcadia.context.FlowContext;
import arcadia.context.TestContext;
import arcadia.domainobjects.ConnectorPlugIdentifier;
import arcadia.domainobjects.Harness;
import arcadia.pages.*;
import arcadia.pages.ComponentDB.AddNewComponentPage;
import arcadia.utils.ConversionUtil;
import arcadia.utils.SeleniumCustomCommand;
import arcadia.utils.StringHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
        String harnessDescription = null;
        if(connectorDescription.toLowerCase().contains("dynamic")){
            harnessDescription = connectorDescription.concat(" "+ new StringHelper().generateRandomDigit());
        }
        if(!connectorDescription.toLowerCase().contains("dynamic")) {
            harnessDescription = connectorDescription.concat(" "+System.getProperty("uniqueIdentifier"));
        }
        Boolean isHarnessAlreadyExists = new HarnessPage(context.driver).isHarnessAlreadyExists(harnessDescription);
        if(isHarnessAlreadyExists){
            openExistingHarness(harnessDescription);
        }
        if(!isHarnessAlreadyExists){
            createNewHarnessInstance(harnessDescription);
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

    @And("{string} component with index {string} is opened")
    public void connectorPlugIsOpened(String componentt,String index) throws InterruptedException {
//        Thread.sleep(3000);
        new HarnessPage(context.driver).clickOnSelect();
        switch (componentt.toLowerCase()){
            case "connectorplug":
                String connectorid = new ConnectorPage(context.driver).getConnectorPlugELementIdsFromDrawingPage().get(Integer.parseInt(index)).getConnectorId();
                harnessPage.clickConnectorPlug(connectorid);
                break;
            case "splice":
                String spliceId = new ConnectorPage(context.driver).getSpliceElementIdsFromDrawingPage().get(Integer.parseInt(index)).getSpliceId();
                harnessPage.clickSplice(spliceId);
                break;
        }

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

    @When("User verifies reset labels functionality")
    public void userVerifiesResetLabelsFunctionality() throws InterruptedException {
        harnessPage.clickOnMove();
        harnessPage.verifyResetLabels(FlowContext.testDescription, FlowContext.connectorPlugIdentifierList.get(0).getConnectorId());

    }

    @Then("User verify {string} labels are displayed as expected")
    public void userVerifyConnectorLabelsAreDisplayedAsExpected(String labelType) {
        switch (labelType.toLowerCase()){
            case "connector":
                harnessPage.verifyConnectorLabels(FlowContext.connectorID, FlowContext.testDescription);
                break;
        }
    }

    @Then("User verifies {string} image is visible")
    public void userVerifiesImageIsVisible(String imageType) throws InterruptedException {
        switch (imageType.toLowerCase()){
            case "connector":
                harnessPage.verifyConnectorImageVisible(FlowContext.connectorPlugIdentifierList.get(0).getConnectorId());
                break;
            case "terminal":
//                harnessPage.verifyTerminalImageVisible(FlowContext.terminalImagePath);
                break;
        }
    }

    @Then("User verifies the {string} image is toggled successfully")
    public void userVerifiesTheImageIsToggledSuccessfully(String imageType) throws InterruptedException {
        String identifier=FlowContext.connectorPlugIdentifierList.get(0).getConnectorId();
        switch (imageType.toLowerCase()){
            case "connector":
                harnessPage.verifyConnectorImageNotVisible(FlowContext.connectorPlugIdentifierList.get(0).getConnectorId());
                break;
            case "terminal":
                String terminalImagePath = FlowContext.terminalImagePath;
                if (harnessPage.TerminalImageVisible(terminalImagePath)){
                    new HarnessPage(context.driver).getContextMenu(identifier);
                    new HarnessPage(context.driver).performOperation("Toggle Terminal Image",identifier);
                    Thread.sleep(5000);
                    Assert.assertFalse(harnessPage.TerminalImageVisible(terminalImagePath),"Terminal image is visible");
                }
                else {
                    new HarnessPage(context.driver).getContextMenu(identifier);
                    new HarnessPage(context.driver).performOperation("Toggle Terminal Image",identifier);
                    Thread.sleep(10000);
                    Assert.assertTrue(harnessPage.TerminalImageVisible(terminalImagePath),"Terminal image is not visible");
                }
                break;
        }
    }


    @And("{string} list is initialized")
    public void connectorListIsInitialized(String compType) {
        switch (compType.toLowerCase()){
            case "connector":
                new ConnectorPage(context.driver).getConnectorPlugELementIdsFromDrawingPage();
                break;
        }
    }

    @Then("User verify {string} destination is displayed successfully")
    public void userVerifyDestinationIsDisplayedSuccessfully(String compType) {
        String connectorid = FlowContext.connectorPlugIdentifierList.get(0).getConnectorId();
        switch (compType.toLowerCase()){
            case "wire":
                harnessPage.verifyWireDestination("X-002/1",connectorid);
                break;
        }

    }

    @Then("User verifies the WireFan is ShownHidden successfully")
    public void userVerifiesTheWireFanIsShownHiddenSuccessfully() throws InterruptedException {
        harnessPage.clickFooterWireFan();
        String identifier=FlowContext.connectorPlugIdentifierList.get(0).getConnectorId();
        if (harnessPage.WireFanVisible(identifier)){
            new HarnessPage(context.driver).getContextMenu(identifier);
            new HarnessPage(context.driver).performOperation("Hide Wire Fan",identifier);
            Thread.sleep(6000);
            Assert.assertFalse(harnessPage.WireFanVisible(identifier),"WireFan is visible even after trying to hide");
        }
        else {
            new HarnessPage(context.driver).getContextMenu(identifier);
            new HarnessPage(context.driver).performOperation("Show Wire Fan",identifier);
            Thread.sleep(6000);
            Assert.assertTrue(harnessPage.WireFanVisible(identifier),"WireFan is not visible");
        }
    }

    @Then("User verifies the UnusedCavities are ShownHidden successfully")
    public void userVerifiesTheUnusedCavitiesAreShownHiddenSuccessfully() throws InterruptedException {
        String identifier=FlowContext.connectorPlugIdentifierList.get(0).getConnectorId();
        if (harnessPage.getCavityRowCount(identifier)==4){
            new HarnessPage(context.driver).getContextMenu(identifier);
            new HarnessPage(context.driver).performOperation("Hide Unused Cavities",identifier);
            Thread.sleep(6000);
            Assert.assertEquals(harnessPage.getCavityRowCount(identifier),1);
        }
        else {
            new HarnessPage(context.driver).getContextMenu(identifier);
            new HarnessPage(context.driver).performOperation("Show Unused Cavities",identifier);
            Thread.sleep(6000);
            Assert.assertEquals(harnessPage.getCavityRowCount(identifier),4);
        }

    }

    @Then("User verifies the UnusedCavities with EntryPort are ShownHidden successfully")
    public void userVerifiesTheUnusedCavitiesWithEntryPortAreShownHiddenSuccessfully() throws InterruptedException {
        String identifier=FlowContext.connectorPlugIdentifierList.get(0).getConnectorId();
        Assert.assertEquals(harnessPage.getCavityRowCount(identifier),4);
        try {
            new HarnessPage(context.driver).getContextMenu(identifier);
            new HarnessPage(context.driver).performOperation("Hide Unused Cavities",identifier);
            Thread.sleep(6000);
        }
        catch (Exception e){
            new HarnessPage(context.driver).getContextMenu(identifier);
            new HarnessPage(context.driver).performOperation("Show Unused Cavities",identifier);
            Thread.sleep(6000);
        }
        Assert.assertEquals(harnessPage.getCavityRowCount(identifier),4);
    }

    @Then("User verifies the connector node is moved successfully")
    public void userVerifiesTheConnectorNodeIsMovedSuccessfully() throws InterruptedException {
        String identifier=FlowContext.connectorPlugIdentifierList.get(0).getConnectorId();
        try {
            harnessPage.changeConnectorNode(identifier);
        }
        finally {
            harnessPage.exitDrawingPage();
            harnessPage.deleteHarness("connectorValidator");

        }

    }

    @Then("User verifies the view is autoarranged successfully")
    public void userVerifiesTheAutoarrangeFunctionality() throws InterruptedException {
        try {
            harnessPage.clickOnMove();
            String identifier=FlowContext.connectorPlugIdentifierList.get(0).getConnectorId();
            harnessPage.verifyAutoArrange(identifier);
        }
        finally {
            harnessPage.exitDrawingPage();
            harnessPage.deleteHarness("connectorValidator");
        }

    }
}
//Reset Views