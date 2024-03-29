package arcadia.stepdefinations;

import arcadia.context.FlowContext;
import arcadia.context.TestContext;
import arcadia.domainobjects.ConnectorWireTable;
import arcadia.domainobjects.Macros.WireTags;
import arcadia.domainobjects.WiresComponentDB;
import arcadia.mapperObjects.SearchParts;
import arcadia.mapperObjects.TestMapper;
import arcadia.mapperObjects.WireTable;
import arcadia.pages.ComponentDB.Wires.WiresComponentDBPage;
import arcadia.pages.ConnectorPage;
import arcadia.pages.HarnessPage;
import arcadia.pages.PageFactoryManager;
import arcadia.pages.SearchPartsDatabasePage;
import arcadia.utils.ConversionUtil;
import arcadia.utils.RestAssuredUtility;
import arcadia.utils.StringHelper;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConnectorCopyStepDefinitions {
    private final TestContext context;
    ConversionUtil conversionUtil = new ConversionUtil();
    private HarnessPage harnessPage;
    private ConnectorPage connectorPage;

    public ConnectorCopyStepDefinitions(TestContext context) {
        this.context = context;
        harnessPage = PageFactoryManager.getDrawingPage(context.driver);
        connectorPage = PageFactoryManager.getConnectorPage(context.driver);
    }

    @Given("connector added to first node of bundle")
    public void connector_added_to_first_node_of_bundle() throws InterruptedException {
        Thread.sleep(2000);
        harnessPage.clickOnConnector();
        ExtentCucumberAdapter.addTestStepLog(String.format("Connector id is %s", context.bundleNodes.get(0).getAttribute("id")));
        context.node1 = context.bundleNodes.get(0).getAttribute("id");
        //connectorPage.addConnectorToNode(context.bundleNodes.get(0).getAttribute("id"));
    }

    @Given("connector added to second node of bundle")
    public void connector_added_to_second_node_of_bundle() throws InterruptedException {
        Thread.sleep(2000);
        harnessPage = PageFactoryManager.getDrawingPage(context.driver);
        // connectorPage.addConnectorToNode(context.bundleNodes.get(1).getAttribute("id"));
    }

    @Given("connectors are wired successfully")
    public void connectors_are_wired_successfully() throws IOException, InterruptedException {
        TestMapper mapper = conversionUtil.getTestMapperConfig(context.testIdentifier);
        SearchParts searchParts = mapper.getSearchParts();
        Thread.sleep(2000);
        connectorPage.addRowInCavityTable(Integer.valueOf(searchParts.getCavityNumber()));
        connectorPage = PageFactoryManager.getConnectorPage(context.driver);
        WireTable wireTable = mapper.getWireTable();
        // context.wireProperties = connectorPage.updateWireTableConnector(wireTable.getConnectTo(),wireTable.getWireDescription(), Integer.valueOf(searchParts.getCavityNumber()));
    }

    @Given("Submit connector")
    public void submit_connector() throws InterruptedException {
        connectorPage.submitConnector();
    }

    @And("user enters description in connector details")
    public void userEntersDescriptionInConnectorDetails() {
        String description;
        description = String.format("testdescription-%04d", new StringHelper().generateRandomDigit());
        FlowContext.testDescription = description;
        connectorPage.enterConnectorDescription(description);
    }

    @Then("User verifies the connectordescription is added successfully")
    public void userVerifiesTheConnectordescriptionIsAddedSuccessfully() {
        connectorPage.verifyConnectorDescription(FlowContext.testDescription, FlowContext.connectorPlugIdentifierList.get(0).getConnectorId());
    }

    @And("user enters piped description in connector details")
    public void userEntersPipedDescriptionInConnectorDetails() {
        String description1 = "";
        String description2 = "";
        description1 = String.format("testdescription-%04d", new StringHelper().generateRandomDigit());
        description2 = String.format("testdescription-%04d", new StringHelper().generateRandomDigit());
        String description = description1 + "|" + description2;
        FlowContext.testDescription = description;
        connectorPage.enterConnectorDescription(description);
    }

    @And("user sets cavitytable display to {string}")
    public void userSetsCavitytableDisplay(String displayYesNo) throws InterruptedException {
        connectorPage.selectCavityTableDisplay(displayYesNo);
    }

    @Then("User verifies {string} cavityTable displayed")
    public void userVerifiesTheCavityTableDisplay(String numberOfTables) {
        connectorPage.verifyCavityTableDisplayed(Integer.parseInt(numberOfTables), FlowContext.connectorPlugIdentifierList.get(0).getConnectorId());
    }

    @And("adds discrete component {string} with dest type {string}")
    public void addsDiscreteComponent(String discreteType, String destType) throws InterruptedException {
        int FromCavity = 1;
        int ToCavity = 1;
        String componentDB = System.getProperty("componentDB");
        connectorPage.enterDiscreteComponentDetails(destType, FromCavity, ToCavity, discreteType, componentDB);
        connectorPage.selectFirstDiscretePart();
        connectorPage.setShowDiscreteImage("true");
        FlowContext.connectorID = connectorPage.getConnectorID();
    }

    @Then("User verifies the discrete component is displayed")
    public void userVerifiesTheDiscreteComponentIsDisplayed() throws InterruptedException {
        Thread.sleep(3000);
        connectorPage.verifyDiscreteComponentDisplayed(FlowContext.connectorPlugIdentifierList.get(0).getConnectorId(), FlowContext.connectorID);
    }

    @And("user deletes the discrete component successfully")
    public void userDeletesTheDiscreteComponentSuccessfully() throws InterruptedException {
        connectorPage.deleteFirstDiscretePart();
        Thread.sleep(2000);
        connectorPage.submitConnector();
    }

    @And("User opens searchwire window")
    public void userOpensSearchWireWindow() throws InterruptedException {
        connectorPage.addWire();
        connectorPage.clickGetWireDetails();
        new SearchPartsDatabasePage(context.driver).verifySearchWiresWindowIsOpen();
    }

    @And("wire is added to cavity")
    public void wireIsAddedToCavity() throws InterruptedException {
        connectorPage.addWire();
    }

    @Then("User verifies the tags for {string}")
    public void userVerifiesTheTags(String component) throws IOException {
        File file;
        String tagPrefix = "@@";
        String tagSuffix = "#";
        switch (component.toLowerCase()) {
            case "wire":
                file = new File("src/test/resources/macros/Wire/WireMacrosData.json");
                WireTags dbMacrosData = null;
                if (file.exists()) {
                    ObjectMapper mapper = new ObjectMapper();
                    dbMacrosData = mapper.readValue(new File("src/test/resources/macros/Wire/WireMacrosData.json"), new TypeReference<WireTags>() {
                    });
                }
                String expectedFromTag = tagPrefix + dbMacrosData.getTagfromConnector()+ tagSuffix;
                String expectedToTag = tagPrefix +dbMacrosData.getTagToConnector()+ tagSuffix;
                connectorPage.verifyTagWireFromConnector(expectedFromTag);
                connectorPage.verifyTagWireToConnector(expectedToTag);
                break;
        }
    }
    @Then("Verify updateWirePN functionality in wiretable successfully")
    public void verifyUserUpdatesWIrePNInWiretableSuccessfully() throws IOException, InterruptedException {
        String materialValue;
        String gaugeValue;
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("wire", context.driver);
        List<WiresComponentDB> dbData =new WiresComponentDBPage(context.driver).getWireAPIData(response);
        WiresComponentDB randomWireData = new WiresComponentDBPage(context.driver).getRandomWireComponent(dbData);
        List<WiresComponentDB> filteredDbData = new ArrayList<>();
        filteredDbData = dbData.stream().filter(x -> x.getWirematerial()!=("")).collect(Collectors.toList());
        materialValue = filteredDbData.get(0).getWirematerial();
        gaugeValue = filteredDbData.get(0).getGauge();
        filteredDbData = filteredDbData.stream().filter(x->x.getWirematerial().equals(materialValue)).filter(x->x.getGauge().equals(gaugeValue)).collect(Collectors.toList());
        connectorPage.enterMaterialInWireTable(materialValue);
        connectorPage.enterGaugeInWireTable(gaugeValue);
        connectorPage.clickUpdateWirePN();
        String wirePN = connectorPage.getValueOfWirePN();
        Assert.assertTrue(filteredDbData.stream().filter(x->x.getPartnumber().equals(wirePN)).collect(Collectors.toList()).size()!=0);
    }

    @And("User opens attachedparts details window")
    public void userOpensSearchAttachedpartsWindow() throws InterruptedException {
        connectorPage.clickGetDetailsAttachedParts();
        new SearchPartsDatabasePage(context.driver).verifyGetAttachedPartsDetailsWindowIsOpen();
    }

    @Then("Verify attached part on connector is checked")
    public void verifyAttachedPartOnConnectorIsChecked() throws InterruptedException {
        connectorPage.verifyAttachedPartsAreChecked();
    }

    @Then("Verify attached part details on connector")
    public void verifyAttachedPartDetailsOnConnector() {
        connectorPage.verifyAttachedPartsDetails("15-117-103","COVER- WIRING CONNECTOR","1","EACH","Optional");
    }

    @Then("Verify imagepath of attached part on connector")
    public void verifyImagepathOfAttachedPartOnConnector() throws InterruptedException {
        new SearchPartsDatabasePage(context.driver).selectAttachPartComponentType("connector");
        String imagePath =  new SearchPartsDatabasePage(context.driver).getImagePathOfFirstAttachPart();
        connectorPage.verifyImagePath(imagePath);
    }

    @Then("Verify linked terminals are shown in cavity table")
    public void verifyLinkedTerminalsAreShownInCavityTable() throws InterruptedException {
        List<String> listOfLinkedTerminalsPNFromComponentDB = Arrays.asList("0-0444334-2","0-0281381-2","0-0444335-2");
        connectorPage.verifyTerminalsPNCavityTable(listOfLinkedTerminalsPNFromComponentDB);
    }

    @And("GetCavityDetails window is opened")
    public void getcavitydetailsWindowIsOpened() throws InterruptedException {
        connectorPage.openCavityTable();
        connectorPage.clickGetCavityTableDetails();
        new SearchPartsDatabasePage(context.driver).verifyGetCavityTableDetailsWindowIsOpen();
    }

    @Then("Verify linked seals are shown in cavity table")
    public void verifyLinkedSealsAreShownInCavityTable() throws InterruptedException {
        List<String> listOfLinkedSealsPNFromComponentDB = Arrays.asList("3301");
        connectorPage.verifySealsPNCavityTable(listOfLinkedSealsPNFromComponentDB);
    }

    @Then("Verify linked plug are shown in cavity table")
    public void verifyLinkedPlugAreShownInCavityTable() throws InterruptedException {
        List<String> listOfLinkedPlugsPNFromComponentDB = Arrays.asList("12134");
        connectorPage.verifyPlugsPNCavityTable(listOfLinkedPlugsPNFromComponentDB);
    }

    @And("user sets visibility of connector table layout to {string}")
    public void userSetsVisibilityOfConnectorTableLayoutTo(String visible) throws InterruptedException {
        connectorPage.openTableLayout();
        connectorPage.setTableLayoutVisibility(visible);
    }


    @And("User sets value of cavitytablewrap to {string}")
    public void userSetsValueOfCavitytablewrapTo(String wrapValue) throws InterruptedException {
        connectorPage.setTablePropertyWrapFrom(wrapValue);
    }

    @And("wire table data is updated")
    public void wireTableDataIsUpdated() throws InterruptedException {
        List<ConnectorWireTable> connectorWireTableList = new ArrayList<>();
        String connectFrom = "X-001";
        String connectTo = "X-002";
        String fromCavity = "1";
        String toCavity = "1";
        String wiringPart = "WIRE_BK_1.5_FLRY";
        ConnectorWireTable wireTable = new ConnectorWireTable();
        wireTable.setConnectFrom(connectFrom);
        wireTable.setConnectTo(connectTo);
        wireTable.setCavityFrom(fromCavity);
        wireTable.setCavityTo(toCavity);
        wireTable.setWireParts(wiringPart);
        connectorWireTableList.add(wireTable);
        connectorPage.addWire(connectorWireTableList, false);
    }

    @Then("User verifies the connector details window is opened successfully")
    public void userVerifiesTheConnectorDetailsWindowIsOpenedSuccessfully() {
        connectorPage.verifyConnectorDetailsWindowOpened();
    }

    @And("value of {string} is extracted successfully")
    public void valueOfConnectoridIsExtractedSuccessfully(String fieldName) {
        switch (fieldName.toLowerCase()){
            case "connectorid":
                FlowContext.connectorID = connectorPage.getConnectorID();
                break;
        }

    }

    @And("Cavity is updated with terminal image")
    public void cavityIsUpdatedWithTerminalImage() throws InterruptedException, AWTException {
        new SearchPartsDatabasePage(context.driver).addImageTerminalToCavity("0-0444335-2");
        String imagePath = connectorPage.getImagePathOfCavity();
        FlowContext.terminalImagePath = imagePath;
    }

    @Then("User verifies duplicate wire is added to cavity successfully")
    public void userVerifiesDuplicateWireIsAddedToCavitySuccessfully() throws InterruptedException {
        try {
            connectorPage.verifyWireTablesRowCount(2);
        }
        finally {
            harnessPage.exitDrawingPage();
            harnessPage.deleteHarness("connectorValidator");
        }
    }
}
