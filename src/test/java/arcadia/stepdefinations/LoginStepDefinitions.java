package arcadia.stepdefinations;

import arcadia.constants.EndPoint;
import arcadia.context.FlowContext;
import arcadia.context.TestContext;
import arcadia.mapperObjects.DrawingInstructor;
import arcadia.pages.*;
import arcadia.pages.ComponentDB.HeaderPanel;
import arcadia.utils.DrawingHelper;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class LoginStepDefinitions {
    private final LoginPage loginPage;
    private final TestContext context;
    public LoginStepDefinitions(TestContext context){
        this.context = context;
        loginPage = PageFactoryManager.getLoginPage(context.driver);
    }
    @Given("I'm on Arcadia test environment")
    public void i_m_on_arcadia_test_environment() throws IOException {
        loginPage.load();
        loginPage.Login();
    }
    @Given("test data config loaded for test identifier {word}")
    public void test_data_config_loaded_for_test_identifier(String string) throws IOException, InterruptedException {
        context.testIdentifier = string;
    }

    @Given("Navigated to selected componentDB")
    public void navigated_to_selected_component_db() {
        loginPage.load(EndPoint.COMPONENTDB.url.replace("databaseName",System.getProperty("componentDB")));

    }

    @And("Navigated to quickstart project")
    public void navigateToProjectQuickStart(){
        loginPage.load(EndPoint.PROJECT.url.replace("projectName",System.getProperty("projectName")));
    }

    @Given("User selected {string} from componentDB")
    public void user_selected_from_component_db(String menuName) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new HeaderPanel(context.driver).invokeMainMenu(menuName);
    }

    @And("Harness bundle default values are captured")
    public void captureHarnessBundleDefaults(){
        loginPage.load(EndPoint.HARNESSBUNDLEDISPLAY.url.replace("profileName",System.getProperty("profileName")));
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


    @And("Navigated to Profiles setting for profile {string}")
    public void navigatedToProfilesSettingForProfileQuickstart(String profileCode)
    {
        loginPage.load(EndPoint.PROFILE.url.replace("profileName",System.getProperty("profileName")));
    }
}
