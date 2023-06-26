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
import io.cucumber.java.hu.Ha;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;
import java.util.List;

import static arcadia.context.FlowContext.harnessComponentAlreadyCreated;

public class HarnessStepDefinitions {
    private final CreateHarness createHarness;
    private final HarnessPage harnessPage;
    private final ProjectLanding projectLanding;
    private final TestContext context;
    public static String getHarnessDescription;
    ConversionUtil conversionUtil = new ConversionUtil();
    public HarnessStepDefinitions(TestContext context){
        this.context = context;
        createHarness = PageFactoryManager.getCreateHarness(context.driver);
        harnessPage = PageFactoryManager.getDrawingPage(context.driver);
        projectLanding = PageFactoryManager.getProjectLanding(context.driver);
    }

    @And("harness with name {string} is launched successfully")
    public void harness_with_name_is_launched_successfully(String connectorDescription) throws InterruptedException {
//        String harnessDescription = null;
//        if(connectorDescription.toLowerCase().contains("dynamic")){
//            harnessDescription = connectorDescription.concat(" "+ new StringHelper().generateRandomDigit());
//        }
//        if(!connectorDescription.toLowerCase().contains("dynamic")) {
//            harnessDescription = connectorDescription.concat(" "+System.getProperty("uniqueIdentifier"));
//        }
//        Boolean isHarnessAlreadyExists = new HarnessPage(context.driver).isHarnessAlreadyExists(harnessDescription);
//        if(isHarnessAlreadyExists){
//            openExistingHarness(harnessDescription);
//        }
//        if(!isHarnessAlreadyExists){
//            createNewHarnessInstance(harnessDescription);
//        }
        String harnessDescription = connectorDescription.concat(" "+ new StringHelper().generateRandomDigit());
        createNewHarnessInstance(harnessDescription);
        getHarnessDescription = harnessDescription;
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
        WebElement ele=context.driver.findElement(By.xpath("//*[name()='g' and @id='"+identifier+"']/*[name()='rect']"));
        new HarnessPage(context.driver).getContextMenu(identifier,ele);
        new HarnessPage(context.driver).performOperation(operation,identifier);
        Thread.sleep(10000);
    }

    @And("User try operation {string} for cavitytable")
    public void userTryOperationOnCavityTableContextMenu(String operation) throws InterruptedException {
        List<ConnectorPlugIdentifier> connector_ids=new ConnectorPage(context.driver).getConnectorPlugELementIdsFromDrawingPage();
        String identifier=connector_ids.get(0).getConnectorId();
        new HarnessPage(context.driver).getCavityTableContextMenu(identifier);
        new HarnessPage(context.driver).performOperation(operation,identifier);
        Thread.sleep(5000);
    }

    @And("User try operation {string} for node")
    public void userTryOperationOnNodeContextMenu(String operation) throws InterruptedException {
        String identifier = FlowContext.nodeIdentifierList.get(0).getNodeElementId();
        harnessPage.getNodeContextMenu(identifier);
        new HarnessPage(context.driver).performOperation(operation,identifier);
        Thread.sleep(5000);
    }
    @And("harness connectorvalidator is opened")
    public void harnessConnectorvalidatorIsOpened() throws InterruptedException {
        Thread.sleep(3000);
       // new DrawingHelper().openValidatorHarness(context.driver);
    }

    @And("{string} component with index {string} is opened")
    public void harnessComponentIsOpened(String component, String index) throws InterruptedException {
        Thread.sleep(3000);
        new HarnessPage(context.driver).clickOnSelect();
        switch (component.toLowerCase()){
            case "connectorplug":
                String connectorid = new ConnectorPage(context.driver).getConnectorPlugELementIdsFromDrawingPage().get(Integer.parseInt(index)).getConnectorId();
                harnessPage.clickConnectorPlug(connectorid);
                break;
            case "splice":
                String spliceId = new ConnectorPage(context.driver).getSpliceElementIdsFromDrawingPage().get(Integer.parseInt(index)).getSpliceId();
                System.out.println(spliceId);
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
    @And("User deletes Schematic {string} successfully")
    public void schematicIsDeletedSuccessfully(String schematicDescription) {
        if(schematicDescription==""){
            schematicDescription = FlowContext.testDescription;
        }
        harnessPage.deleteSchematic(schematicDescription);
    }


    @And("User exits the drawing page")
    public void userExitsTheDrawingPage() throws InterruptedException {
        harnessPage.exitDrawingPage();
    }

    @Then("Verify CavityTableData is displayed on connector {string}")
    public void verifyCavityTableDataIsDisplayedOnConnector(String connectorPlugIndex) throws InterruptedException {
        new ConnectorPage(context.driver).openTableLayout();
        new ConnectorPage(context.driver).setTableLayoutVisibility("Yes");
        int expectedSizeOfHeaders = new ConnectorPage(context.driver).getNumberOfOptionsInCavityLayout();
        new ConnectorPage(context.driver).submitConnector();
        String connectorid = FlowContext.connectorPlugIdentifierList.get(Integer.parseInt(connectorPlugIndex)).getConnectorId();
        harnessPage.verifyCavityTableNumberOfColumnsDisplayed(connectorid,expectedSizeOfHeaders);
        String colour = "BK";
        String gauge = "1.5";
        String material = "FLRY";
        String dest = "X-002/1";
        String outerdia = "2";
        String wirecsa = "2";
        String fromTag = "X-001";
        String toTag = "X-002";
        String entryPort = "EP_0";
        harnessPage.verifyCavityTableData(connectorid,colour,gauge,material,dest,outerdia,wirecsa,fromTag,toTag,entryPort);
    }

    @Then("Verify data is wrapped successfully on connector {string}")
    public void verifyDataWrappedOnConnector(String connectorPlugIndex) throws InterruptedException {
        new ConnectorPage(context.driver).openTableLayout();
        new ConnectorPage(context.driver).setTableLayoutVisibility("Yes");
        int expectedSizeOfHeaders = new ConnectorPage(context.driver).getNumberOfOptionsInCavityLayout();
        new ConnectorPage(context.driver).setTablePropertyWrapFrom("2");
        new ConnectorPage(context.driver).submitConnector();
        String connectorid = FlowContext.connectorPlugIdentifierList.get(Integer.parseInt(connectorPlugIndex)).getConnectorId();
        //As we wrapped the data, the column numbers is expected to be doubled
        int expectedColumns = expectedSizeOfHeaders*2;
        harnessPage.verifyCavityTableWrapped(connectorid,expectedColumns);
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
        WebElement ele=context.driver.findElement(By.xpath("//*[name()='g' and @id='"+identifier+"']/*[name()='rect']"));

        switch (imageType.toLowerCase()){
            case "connector":
                harnessPage.verifyConnectorImageNotVisible(FlowContext.connectorPlugIdentifierList.get(0).getConnectorId());
                break;
            case "terminal":
                String terminalImagePath = FlowContext.terminalImagePath;
                if (harnessPage.TerminalImageVisible(terminalImagePath)){
                    new HarnessPage(context.driver).getContextMenu(identifier,ele);
                    new HarnessPage(context.driver).performOperation("Toggle Terminal Image",identifier);
                    Thread.sleep(5000);
                    Assert.assertFalse(harnessPage.TerminalImageVisible(terminalImagePath),"Terminal image is visible");
                }
                else {
                    new HarnessPage(context.driver).getContextMenu(identifier,ele);
                    new HarnessPage(context.driver).performOperation("Toggle Terminal Image",identifier);
                    Thread.sleep(10000);
                    Assert.assertTrue(harnessPage.TerminalImageVisible(terminalImagePath),"Terminal image is not visible");
                }
                break;
        }
    }


    @And("{string} list is initialized")
    public void harnesscomponentListIsInitialized(String compType) throws InterruptedException {
        switch (compType.toLowerCase()){
            case "connector":
                new ConnectorPage(context.driver).getConnectorPlugELementIdsFromDrawingPage();
                break;
            case "node":
                new BundlePage(context.driver).getNodeElementFromDrawingPage();
                break;
            case "bundle":
                new ConnectorPage(context.driver).getBundleElementIdsFromDrawingPage();
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
        WebElement ele=context.driver.findElement(By.xpath("//*[name()='g' and @id='"+identifier+"']/*[name()='rect']"));
        if (harnessPage.WireFanVisible(identifier)){
            ele=context.driver.findElement(By.xpath("//*[name()='g' and @id='"+identifier+"']/*[name()='rect']"));
            new HarnessPage(context.driver).getContextMenu(identifier,ele);
            new HarnessPage(context.driver).performOperation("Hide Wire Fan",identifier);
            Thread.sleep(6000);
            Assert.assertFalse(harnessPage.WireFanVisible(identifier),"WireFan is visible even after trying to hide");
        }
        else {
            ele=context.driver.findElement(By.xpath("//*[name()='g' and @id='"+identifier+"']/*[name()='rect']"));
            new HarnessPage(context.driver).getContextMenu(identifier,ele);
            new HarnessPage(context.driver).performOperation("Show Wire Fan",identifier);
            Thread.sleep(6000);
            Assert.assertTrue(harnessPage.WireFanVisible(identifier),"WireFan is not visible");
        }
    }

    @Then("User verifies the UnusedCavities are ShownHidden successfully")
    public void userVerifiesTheUnusedCavitiesAreShownHiddenSuccessfully() throws InterruptedException {
        String identifier=FlowContext.connectorPlugIdentifierList.get(0).getConnectorId();
        WebElement ele=context.driver.findElement(By.xpath("//*[name()='g' and @id='"+identifier+"']/*[name()='rect']"));
        if (harnessPage.getCavityRowCount(identifier)==4){
            new HarnessPage(context.driver).getContextMenu(identifier,ele);
            new HarnessPage(context.driver).performOperation("Hide Unused Cavities",identifier);
            Thread.sleep(6000);
            Assert.assertEquals(harnessPage.getCavityRowCount(identifier),1);
        }
        else {
            new HarnessPage(context.driver).getContextMenu(identifier,ele);
            new HarnessPage(context.driver).performOperation("Show Unused Cavities",identifier);
            Thread.sleep(6000);
            Assert.assertEquals(harnessPage.getCavityRowCount(identifier),4);
        }

    }

    @Then("User verifies the UnusedCavities with EntryPort are ShownHidden successfully")
    public void userVerifiesTheUnusedCavitiesWithEntryPortAreShownHiddenSuccessfully() throws InterruptedException {
        String identifier=FlowContext.connectorPlugIdentifierList.get(0).getConnectorId();
        WebElement ele=context.driver.findElement(By.xpath("//*[name()='g' and @id='"+identifier+"']/*[name()='rect']"));
        Assert.assertEquals(harnessPage.getCavityRowCount(identifier),4);
        try {
            new HarnessPage(context.driver).getContextMenu(identifier,ele);
            new HarnessPage(context.driver).performOperation("Hide Unused Cavities",identifier);
            Thread.sleep(6000);
        }
        catch (Exception e){
            new HarnessPage(context.driver).getContextMenu(identifier,ele);
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

    @Then("User verifies the wire is added successfully")
    public void userVerifiesTheWireIsAddedSuccessfully() throws InterruptedException {
        try {
            String identifier=FlowContext.connectorPlugIdentifierList.get(1).getConnectorId();
            harnessPage.verifyWireAdded(identifier);
        }
        finally {
            harnessPage.exitDrawingPage();
            harnessPage.deleteHarness("connectorValidator");
        }
    }

    @Then("User verifies the wire is swapped successfully")
    public void userVerifiesTheWireIsSwappedSuccessfully() throws InterruptedException {
        try {
            String identifier=FlowContext.connectorPlugIdentifierList.get(1).getConnectorId();
            harnessPage.verifyWireSwapped(identifier);
        }
        finally {
            harnessPage.exitDrawingPage();
            harnessPage.deleteHarness("connectorValidator");
        }
    }

    @Then("User verifies the wire is deleted successfully")
    public void userVerifiesTheWireIsDeletedSuccessfully() throws InterruptedException {
        try {
            String identifier=FlowContext.connectorPlugIdentifierList.get(0).getConnectorId();
            harnessPage.verifyWireDeleted(identifier);
        }
        finally {
            harnessPage.exitDrawingPage();
            harnessPage.deleteHarness("connectorValidator");
        }
    }

    @And("{string} can be filtered with technology {string}")
    public void spliceCanBeFilteredWithTechnologyUltrasonic(String component,String technology) throws InterruptedException {
        harnessPage.selectSpliceTechnology(technology);
        String spliceId = new ConnectorPage(context.driver).getSpliceElementIdsFromDrawingPage().get(Integer.parseInt(String.valueOf(0))).getSpliceId();
        WebElement ele=context.driver.findElement(By.xpath("//*[name()='g' and @id='"+spliceId+"']/*[name()='rect']"));
        new HarnessPage(context.driver).getContextMenu(spliceId,ele);
        Thread.sleep(2000);
        new HarnessPage(context.driver).performOperation("Inspect",spliceId);
        new HarnessPage(context.driver).validateSpliceTechnology(technology);
    }


    @Then("User verifies the wirepath is shown successfully")
    public void userVerifiesTheWirepathIsShownSuccessfully() throws InterruptedException {
        try {
            harnessPage.verifyWirePathIsDisplayed();
        }
        finally {
            harnessPage.exitDrawingPage();
            harnessPage.deleteHarness("connectorValidator");
        }
    }

    @Then("User verifies cavitytable is opened successfully")
    public void userVerifiesCavitytableIsOpenedSuccessfully() {
        new ConnectorPage(context.driver).verifyCavityTableDetailsIsOpened();
    }

    @And("user opens context menu for node {string}")
    public void userOpensContextMenuForNode(String index) throws InterruptedException {
        String identifier = FlowContext.nodeIdentifierList.get(Integer.parseInt(index)).getNodeElementId();
        harnessPage.getNodeContextMenu(identifier);
    }

    @Then("user verifies connector can be added from context menu of node successfully")
    public void userVerifiesConnectorCanBeAddedFromContextMenuOfNode() throws InterruptedException, AWTException {
        int countOfConnectors = harnessPage.getCountOfConnectors();
        try {
            harnessPage.enterPartNumberForQuickAdd("FFH04142BK*T");
            int expectedCount = countOfConnectors + 1;
            harnessPage.verifyCountOfConnectorsDisplayed(expectedCount);
        }
        finally {
            harnessPage.exitDrawingPage();
            harnessPage.deleteHarness("connectorValidator");
        }
    }

    @And("User selects component {string} on linkparts window")
    public void userSelectsComponentOnLinkpartsWindow(String componentType) {
        harnessPage.selectLinkPartComponent(componentType);
    }

    @Then("Verify {string} is added successfully on harness")
    public void verifyComponentIsAddedSuccessfullyOnHarness(String componentType) {
        switch (componentType.toLowerCase()){
            case "connector":
                int countOfConnectors = FlowContext.connectorPlugIdentifierList.size();
                int expectedCount = countOfConnectors + 1;
                harnessPage.verifyCountOfConnectorsDisplayed(expectedCount);
                break;
        }
    }
    @And("Image view is opened")
    public void updateImageViewIsOpened() throws InterruptedException {
        harnessPage.selectHeader("Harness");
        harnessPage.openUpdateImageView();
        new UpdateImagePage(context.driver).verifyUpdateImageViewOpened();
    }

    @And("connector editor is opened")
    public void connectorEditorIsOpened() throws InterruptedException {
        harnessPage.selectHeader("Advanced");
        harnessPage.openConnectorEditor();
        new ConnectorEditorPage(context.driver).verifyConnectorEditorOpened();
    }
       @And("Load wires is opened")
   public void loadWiresIsOpened() throws InterruptedException {
               Thread.sleep(5000);
                harnessPage.selectHeader("Advanced");
                harnessPage.openLoadWires();
                new LoadWiresPage(context.driver).verifyLoadWiresOpened();
            }

    @And("wire editor is opened")
    public void wirerEditorIsOpened() throws InterruptedException {
        Thread.sleep(9000);
        harnessPage.selectHeader("Advanced");
        harnessPage.openWireEditor();
        new WireEditorPage(context.driver).verifyWireEditorOpened();
    }

    @And("add configurations to create splice image")
    public void addConfigurationsToCreateSpliceImage() throws InterruptedException {
        harnessPage.addPartNumberToSplice();
        harnessPage.addCavity();
        harnessPage.addWires();
        harnessPage.clickSubmit();
    }

    @And("toggle splice image from context menu options")
    public void toggleSpliceImageFromContextMenuOptions() throws InterruptedException {
        String spliceId = new ConnectorPage(context.driver).getSpliceElementIdsFromDrawingPage().get(Integer.parseInt(String.valueOf(0))).getSpliceId();
        WebElement ele=context.driver.findElement(By.xpath("//*[name()='g' and @id='"+spliceId+"']/*[name()='rect']"));
        new HarnessPage(context.driver).getContextMenu(spliceId,ele);
        Thread.sleep(2000);
        new HarnessPage(context.driver).performOperation("Toggle Splice Image",spliceId);
    }

    @And("verify splice image is drawn on Harness page with above configuration")
    public void verifySpliceImageIsDrawnOnHarnessPageWithAboveConfiguration() {
        String spliceId = new ConnectorPage(context.driver).getSpliceElementIdsFromDrawingPage().get(Integer.parseInt(String.valueOf(0))).getSpliceId();
            new HarnessPage(context.driver).checkForImage(spliceId);
    }

    @And("check again for splice sides are added")
    public void checkAgainForSpliceSidesAreAdded() throws InterruptedException {
        new HarnessPage(context.driver).checkSpliceSideAgain();
    }

    @And("User set the bundle radius from drawing page")
    public void userSetTheBundleRadiusFromDrawingPage() throws InterruptedException {
       String id= new HarnessPage(context.driver).bendRadiusFromDrawingPage();
       new HarnessPage(context.driver).validateBendRadius(id);
    }

    @And("User set the bundle radius from inspect bundle page")
    public void userSetTheBundleRadiusFromInspectBundlePage() throws InterruptedException {
        String id= new HarnessPage(context.driver).bendRadiusFromDrawingPage();
        new HarnessPage(context.driver).enterBundleRadius();
        new HarnessPage(context.driver).validateBendRadius(id);


    }

    @And("user validate the default bend radius of the bundle")
    public void userValidateTheDefaultBendRadiusOfTheBundle() throws InterruptedException {
        String id= new HarnessPage(context.driver).getBundleRadiusId();
        new HarnessPage(context.driver).validateBendRadius(id);
    }

    @And("verify that font size and colors are updated")
    public void verifyThatFontSizeAndColorsAreUpdated() throws InterruptedException {
        String id= new HarnessPage(context.driver).getBundleNodeId();
        new HarnessPage(context.driver).inspectNode(id);
        new HarnessPage(context.driver).validateTextAndColorOfBundle();
    }
    @And("splice editor is opened")
    public void spliceEditorIsOpened() throws InterruptedException {
        harnessPage.selectHeader("Advanced");
        harnessPage.openSpliceEditor();
        new SpliceEditorPage(context.driver).verifySpliceEditorOpened();
    }
    @And("Click remove wires")
    public void removeWiresIsCLicked() throws InterruptedException {
        harnessPage.selectHeader("Advanced");
        harnessPage.clickRemoveWires();
    }



//    @And("user delete the created bundle from context menu")
//    public void userDeleteTheCreatedBundleFromContextMenu() throws InterruptedException {
//        List<BundleIdentifier> bundleId = new ConnectorPage(context.driver).getBundleElementIdsFromDrawingPage();
//        WebElement ele=context.driver.findElement(By.xpath("//*[name()='g' and @id='layer_55']//*[name()='g' and @class='bundleGroup']"));
//        new HarnessPage(context.driver).getContextMenu(bundleId.get(0).getBundleId(),ele);
//        Thread.sleep(2000);
//        new HarnessPage(context.driver).performOperation("Delete",bundleId.get(0).getBundleId());
//    }
}