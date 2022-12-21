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
        TestMapper mapper = conversionUtil.getTestMapperConfig(context.testIdentifier);
        arcadia.mapperObjects.CreateHarness createHarnessData = mapper.getCreateHarness();
        createHarness.submitHarnessData(new Harness(createHarnessData.getWorkTask(), createHarnessData.getTitle(), createHarnessData.getDescription(), createHarnessData.getPartNumber(), createHarnessData.getRevision(), createHarnessData.getProfile(),createHarnessData.getComponentDB()));
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
