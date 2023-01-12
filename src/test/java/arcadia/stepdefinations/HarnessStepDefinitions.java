package arcadia.stepdefinations;

import arcadia.context.FlowContext;
import arcadia.context.TestContext;
import arcadia.domainobjects.Harness;
import arcadia.mapperObjects.TestMapper;
import arcadia.pages.*;
import arcadia.utils.ConversionUtil;
import arcadia.utils.DrawingHelper;
import arcadia.utils.StringHelper;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.hu.Ha;

import java.io.IOException;

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
    @And("harness is created successfully")
    public void createHarness() throws IOException, InterruptedException {
        String description;
        projectLanding.invokeCreateHarness();
        TestMapper mapper = conversionUtil.getTestMapperConfig(context.testIdentifier);
        arcadia.mapperObjects.CreateHarness createHarnessData = mapper.getCreateHarness();
        description = String.format("testdescription-%04d", new StringHelper().generateRandomDigit());
        createHarnessData.setDescription(description);
        FlowContext.testDescription = description;
        ExtentCucumberAdapter.addTestStepLog(String.format("Harness data description is %s and part number is %s", createHarnessData.getDescription(),createHarnessData.getPartNumber()));
        createHarness.submitHarnessData(new Harness(createHarnessData.getWorkTask(), createHarnessData.getTitle(), createHarnessData.getDescription(), createHarnessData.getPartNumber(), createHarnessData.getRevision(), createHarnessData.getComponentDB()));
    }


    @And("get the all the options for connector with id {string}")
    public void getTheAllTheOptionsForConnectorWithIdCEEdDeEBcf(String id) {
        new HarnessPage(context.driver).getContextMenu(id);
    }

    @And("User try operation {string} for connector with id {string}")
    public void userTryOperationDeleteForConnectorWithIdCCAEdDeEBcf(String operation, String identifier) throws InterruptedException {
        new HarnessPage(context.driver).performOperation(operation,identifier);
    }
    @And("harness connectorvalidator is opened")
    public void harnessConnectorvalidatorIsOpened() throws InterruptedException {
        Thread.sleep(3000);
        new DrawingHelper().openValidatorHarness(context.driver);
    }

    @And("connector plug is opened")
    public void connectorPlugIsOpened() {
        String connectorid = new ConnectorPage(context.driver).getConnectorPlugELementIdsFromDrawingPage().get(0).getConnectorId();
        harnessPage.clickConnectorPlug(connectorid);
    }

    @And("user sets label {string} to {string}")
    public void userSetsLabelsToShowHide(String labelName, String showHide) throws InterruptedException {
        Thread.sleep(3000);
        harnessPage.selectHeader("Advanced");
        harnessPage.clickVisibility();
        harnessPage.showHideComponentLabel(labelName,showHide);
    }
}
