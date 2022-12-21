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
import io.cucumber.java.hu.Ha;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
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
<<<<<<< HEAD
        arcadia.mapperObjects.CreateHarness harnessData = new arcadia.mapperObjects.CreateHarness();
        harnessData.setComponentDB(System.getProperty("componentDB"));
        harnessData.setPartNumber(partNumber);
        harnessData.setDescription(connectorDescription);
        harnessData.setRevision(new StringHelper().generateRandomDigit().toString());
        harnessData.setTitle(new StringHelper().generateRandomDigit().toString());
        harnessData.setWorkTask(new StringHelper().generateRandomDigit().toString());
        FlowContext.testDescription = connectorDescription;
        createHarness.submitHarnessData(new Harness(harnessData.getWorkTask(), harnessData.getTitle(), harnessData.getDescription(), harnessData.getPartNumber(), harnessData.getRevision(), harnessData.getComponentDB()));
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
=======
        TestMapper mapper = conversionUtil.getTestMapperConfig(context.testIdentifier);
        arcadia.mapperObjects.CreateHarness createHarnessData = mapper.getCreateHarness();
        createHarness.submitHarnessData(new Harness(createHarnessData.getWorkTask(), createHarnessData.getTitle(), createHarnessData.getDescription(), createHarnessData.getPartNumber(), createHarnessData.getRevision(), createHarnessData.getProfile(),createHarnessData.getComponentDB()));
>>>>>>> 445fded (Created Test Scenario for Bundle Tolerance)
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
        Thread.sleep(3000);
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

    @And("User deletes Harness successfully")
    public void harnessIsDeletedSuccessfully() {
        harnessPage.deleteHarness(FlowContext.testDescription);
    }

    @And("User exits the drawing page")
    public void userExitsTheDrawingPage() throws InterruptedException {
        harnessPage.exitDrawingPage();
    }
}
