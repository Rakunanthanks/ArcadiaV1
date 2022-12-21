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
import java.util.concurrent.TimeUnit;


import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginStepDefinitions {
    private final LoginPage loginPage;
    private final TestContext context;
    public LoginStepDefinitions(TestContext context){
        this.context = context;
        loginPage = PageFactoryManager.getLoginPage(context.driver);
    }
    @Given("I'm on Arcadia test environment")
    public void i_m_on_arcadia_test_environment() throws IOException, InterruptedException {

        loginPage.load();
        loginPage.Login();
        Thread.sleep(1000);
    }
    @Given("test data config loaded for test identifier {word}")
    public void test_data_config_loaded_for_test_identifier(String string) throws IOException, InterruptedException {
        Thread.sleep(1000);
        context.testIdentifier = string;
    }

    @Given("Navigated to selected componentDB")
    public void navigated_to_selected_component_db() {
        String selectedComponentDB = System.getProperty("componentDB");
        System.out.println("selectedComponentDB "+ selectedComponentDB);
        String endpoint = EndPoint.COMPONENTDB.url.replace("componentDB",selectedComponentDB);
        loginPage.load(endpoint);

    }

    @And("Navigated to quickstart project")
    public void navigateToProjectQuickStart(){
        loginPage.load(EndPoint.PROJECT.url.replace("projectName",System.getProperty("projectName")));
    }
    @And( "Navigated to Test Project")
    public void navigateToTestProject() throws InterruptedException {
        Thread.sleep(1000);
        loginPage.load(EndPoint.TEST.url);
        Thread.sleep(1000);
    }
    @And( "Checking the Bundle Tolerance Value")
    public void Checking_the_Bundle_Tolerance_Value() throws InterruptedException {
        new DefineBundleTolerance(context.driver).CaptureBundleTollerance();
    }
    @And("Bundles are drawn")
    public void bundlesdrawn() throws InterruptedException{
        new DefineBundleTolerance(context.driver).Customcommands();
    }
    @And( "Inspecting Bundle")
    public void inspecting_bundle() throws InterruptedException{
        new DefineBundleTolerance(context.driver).InspectingBundle();
    }
    @And( "Inspecting Bundle Tolerance Value")
    public void inspecting_bundletolerance_value() throws InterruptedException{
        new DefineBundleTolerance(context.driver).InspectingBundletolerancevalue();
    }

    @And("Getting the Values of Component Label")
    public void values_of_comp_label() throws InterruptedException{
        new DefineBundleTolerance(context.driver).ValuesOfComplabel();
    }

    @And("Changing Bundle Tolerance Value")
    public void changing_bundletolerance_value() throws InterruptedException{
        new DefineBundleTolerance(context.driver).changing_bundletolerance_value();
    }
    @Then("Bundles are Deleted")
    public void bundles_are_deleted()throws InterruptedException
    {
        new DefineBundleTolerance(context.driver).bundles_deleted();
    }

    @And("Navigating to Company profile page")
    public void navigateToSettings() throws InterruptedException {
        Thread.sleep(1000);
        loginPage.load(EndPoint.SETTINGS.url);
        Thread.sleep(1000);
        loginPage.load(EndPoint.AutomationCompanyProfile.url);
        Thread.sleep(1000);
        loginPage.load(EndPoint.BUNDLEDEFAULTDISPLAY.url);
        Thread.sleep(1000);
       new DefineBundleTolerance(context.driver).CaptureModifyBundleTollerance();
        Thread.sleep(1000);

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
