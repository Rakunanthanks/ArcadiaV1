package arcadia.stepdefinations;

import arcadia.constants.EndPoint;
import arcadia.context.FlowContext;
import arcadia.context.TestContext;
import arcadia.mapperObjects.DrawingInstructor;
import arcadia.pages.*;
import arcadia.pages.ComponentDB.HeaderPanel;
import arcadia.utils.DrawingHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import static arcadia.context.FlowContext.harnessComponentAlreadyCreated;
import static arcadia.stepdefinations.HarnessStepDefinitions.getHarnessDescription;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

    @And("Turning Visibility on for Bundle Tolerance")
    public void turning_visibility_on() throws InterruptedException {
        new DefineBundleTolerance(context.driver).turningvisibilityon();
    }

    @And("Navigating to Company profile page")
    public void navigateToSettings() throws InterruptedException {
        Thread.sleep(1000);
        loginPage.load(EndPoint.SETTINGS.url);
        context.driver.switchTo( ).alert( ).accept();
        Thread.sleep(1000);
        loginPage.load(EndPoint.AutomationCompanyProfile.url.replace("profileName",System.getProperty("profileName")));
        Thread.sleep(1000);
        loginPage.load(EndPoint.BUNDLEDEFAULTDISPLAY.url.replace("profileName",System.getProperty("profileName")));
        Thread.sleep(1000);
        new DefineBundleTolerance(context.driver).CaptureModifyBundleTollerance();
        Thread.sleep(1000);

    }
    @And("Navigating to created Project")
    public  void navigating_ToCreatedProject() throws InterruptedException {
        loginPage.load(EndPoint.PROJECT.url.replace("projectName","quickstart"));
        Thread.sleep(2000);
        WebElement harnessElement =  context.driver.findElement(By.xpath("//table[@id=\"tableHAR\"]/tbody//tr//td[text()=\"" + getHarnessDescription + "\"]"));
        harnessElement.click();
        Thread.sleep(2000);
        WebElement ok = context.driver.findElement(By.xpath("//button[normalize-space()='OK']"));
        ok.click();
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
        if (!harnessComponentAlreadyCreated) {
            List<DrawingInstructor> drawingInstructorList = new DrawingHelper().getDrawingInstruction(context.testIdentifier);
            new DrawingHelper().drawOrchestrator(drawingInstructorList, context.driver);
        }
    }
    @And("Navigated to Profiles setting for profile {string}")
    public void navigatedToProfilesSettingForProfileQuickstart(String profileCode)
    {
        loginPage.load(EndPoint.PROFILE.url.replace("profileName",System.getProperty("profileName")));
    }

    @And("Navigated to GeneralMacros page")
    public void navigatedToGeneralMacrosPage() {
        loginPage.load(EndPoint.GENERALMACROS.url);
    }

    @And("Navigated to Harness Bundle Default Display Settings page")
    public void navigatedToBundleDefaultDisplaySettingsPage() {
        loginPage.load(EndPoint.BUNDLEDEFAULTDISPLAY.url.replace("profileName",System.getProperty("profileName")));
    }
    @And("Navigated to Harness Bundle Default Font Settings page")
    public void navigatedToBundleDefaultFontSettingsPage() {
        loginPage.load(EndPoint.BUNDLEFONTDISPLAY.url.replace("profileName",System.getProperty("profileName")));
    }
}
