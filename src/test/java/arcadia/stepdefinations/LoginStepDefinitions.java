package arcadia.stepdefinations;

import arcadia.constants.EndPoint;
import arcadia.context.FlowContext;
import arcadia.context.TestContext;
import arcadia.domainobjects.Harness;
import arcadia.domainobjects.HarnessBundleDisplay;
import arcadia.mapperObjects.DrawingInstructor;
import arcadia.mapperObjects.TestMapper;
import arcadia.pages.*;
import arcadia.utils.ConversionUtil;
import arcadia.utils.DrawingHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LoginStepDefinitions {
    private final LoginPage loginPage;
    private final TestContext context;
    DrawingHelper ins = new DrawingHelper();
    public LoginStepDefinitions(TestContext context){
        this.context = context;
        loginPage = PageFactoryManager.getLoginPage(context.driver);
    }
    @Given("I'm on Arcadia test environment")
    public void i_m_on_arcadia_test_environment() throws IOException {
        loginPage.load(EndPoint.TRAINING.url);
        loginPage.Login();
    }
    @Given("test data config loaded for test identifier {word}")
    public void test_data_config_loaded_for_test_identifier(String string) throws IOException, InterruptedException {
        context.testIdentifier = string;
    }
    @And("Navigated to quickstart project")
    public void navigateToProjectQuickStart(){
        loginPage.load(EndPoint.PROJECT.url);
    }

    @And("Harness bundle default values are captured")
    public void captureHarnessBundleDefaults(){
        loginPage.load(EndPoint.HARNESSBUNDLEDISPLAY.url);
        new HarnessBundleDisplayPage(context.driver).captureDefaultHarnessBundleValues();
        System.out.println(FlowContext.defaultBundleDisplay.get(0).getCoveringTypes());
        System.out.println(FlowContext.defaultBundleDisplay.get(0).getDiameterAddon());
        System.out.println(FlowContext.defaultBundleDisplay.get(0).getDiameterScales());
    }

    @Given("based on drawing orchestrator components are created")
    public void based_on_drawing_orchestrator_components_are_created() throws IOException, InterruptedException, AWTException {
        List<DrawingInstructor> drawingInstructorList =  new DrawingHelper().getDrawingInstruction(context.testIdentifier);
        new DrawingHelper().drawOrchestrator(drawingInstructorList,context.driver);
    }


}
