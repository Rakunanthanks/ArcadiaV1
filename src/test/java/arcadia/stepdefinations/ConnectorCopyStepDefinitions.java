package arcadia.stepdefinations;

import arcadia.context.FlowContext;
import arcadia.context.TestContext;
import arcadia.mapperObjects.SearchParts;
import arcadia.mapperObjects.TestMapper;
import arcadia.mapperObjects.WireTable;
import arcadia.pages.ConnectorPage;
import arcadia.pages.HarnessPage;
import arcadia.pages.PageFactoryManager;
import arcadia.utils.ConversionUtil;
import arcadia.utils.StringHelper;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.IOException;

public class ConnectorCopyStepDefinitions {
    private HarnessPage harnessPage;
    private ConnectorPage connectorPage;
    private final TestContext context;
    ConversionUtil conversionUtil = new ConversionUtil();

    public ConnectorCopyStepDefinitions(TestContext context){
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
        connectorPage.verifyConnectorDescription(FlowContext.testDescription,FlowContext.connectorPlugIdentifierList.get(0).getConnectorId());
    }

    @And("user enters piped description in connector details")
    public void userEntersPipedDescriptionInConnectorDetails() {
        String description1 ="";
        String description2="";
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
        connectorPage.verifyCavityTableDisplayed(Integer.parseInt(numberOfTables),FlowContext.connectorPlugIdentifierList.get(0).getConnectorId());
        }
}
