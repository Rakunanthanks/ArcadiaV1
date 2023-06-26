package arcadia.stepdefinations;

import arcadia.constants.EndPoint;
import arcadia.context.FlowContext;
import arcadia.context.TestContext;
import arcadia.mapperObjects.DrawingInstructor;
import arcadia.pages.*;
import arcadia.pages.ComponentDB.CommonElements;
import arcadia.pages.ComponentDB.HeaderPanel;
import arcadia.utils.DrawingHelper;
import arcadia.utils.SeleniumCustomCommand;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import static arcadia.context.FlowContext.harnessComponentAlreadyCreated;
import static arcadia.pages.BasePage.driver;
import static arcadia.stepdefinations.HarnessStepDefinitions.getHarnessDescription;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginStepDefinitions {
    private final LoginPage loginPage;
    private final TestContext context;
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
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
    @And("Navigate to component DB Page")
    public void componentdbList() {
        loginPage.load(EndPoint.COMPONENTDBLIST.url);
    }

    @And("Navigated to quickstart project")
    public void navigateToProjectQuickStart(){
        loginPage.load(EndPoint.PROJECT.url.replace("projectName",System.getProperty("projectName")));
    }
    @And("Navigated to project home page")
    public void navigateToProjectHomePage(){
        loginPage.load(EndPoint.PROJECTHOMEPAGE.url);
    }
    @And("Navigated to General task units")
    public void navigatedToGeneralTaskUnits() {
        loginPage.load(EndPoint.TASKUNITS.url.replace("profileName",System.getProperty("profileName")));
    }
    @And("Turning Visibility on for Bundle Tolerance")
    public void turning_visibility_on() throws InterruptedException {
        new DefineBundleTolerance(context.driver).turningvisibilityon();
    }

    @And("Navigating to Company profile page")
    public void navigateToSettings() throws InterruptedException {
        loginPage.load(EndPoint.SETTINGS.url);
        try {
            context.driver.switchTo().alert().accept();
        }catch(org.openqa.selenium.NoSuchElementException e){
            Thread.sleep(2000);
        }
        loginPage.load(EndPoint.BUNDLEDEFAULTDISPLAY.url.replace("profileName",System.getProperty("profileName")));
        Thread.sleep(1000);
        new DefineBundleTolerance(context.driver).CaptureModifyBundleTolerance();
        Thread.sleep(1000);
    }

    @And("Navigating to created Project")
    public  void navigating_ToCreatedProject() throws InterruptedException {
        loginPage.load(EndPoint.PROJECT.url.replace("projectName",System.getProperty("projectName")));
        Thread.sleep(2000);
        WebElement harnessElement =  context.driver.findElement(By.xpath("//table[@id=\"tableHAR\"]/tbody//tr//td[text()=\"" + getHarnessDescription + "\"]"));
        harnessElement.click();
        Thread.sleep(2000);
        WebElement ok = context.driver.findElement(By.xpath("//button[normalize-space()='OK']"));
        ok.click();
        Thread.sleep(5000);
    }
    @And("Generating Formboard")
    public void generatingFormboard() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(getHarnessDescription);
        WebElement findoptionButton =   driver.findElement(By.xpath("//table[@id=\"tableHAR\"]/tbody//tr//td[contains(text(),\""+getHarnessDescription+"\")]/following-sibling::td[3]/div/div/button[@title='Option List']"));
        findoptionButton.click();
        Thread.sleep(3000);
        WebElement clickformBoard = driver.findElement(By.xpath("//div[@class='btn-group dropup open']//a[@title='Formboard'][normalize-space()='Formboard']"));
        clickformBoard.click();
        Thread.sleep(3000);
        WebElement okayButton = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
        okayButton.click();
        Thread.sleep(5000);
//        String getUrl = driver.getCurrentUrl();
//        String string = getUrl;
//        String[] parts = string.split("#linkHAR");
//        String part1 = parts[0];
//        String part2 = parts[1];
        WebElement harnessElement =  context.driver.findElement(By.xpath("//td[@class='info'][normalize-space()=\""+getHarnessDescription+"\"][1]"));
        harnessElement.click();
        Thread.sleep(2000);
        WebElement ok = context.driver.findElement(By.xpath("//button[normalize-space()='OK']"));
        ok.click();
        Thread.sleep(3000);
        WebElement syncHarness = driver.findElement(By.cssSelector("#ifhsync"));
        Actions builder = new Actions(driver);
        builder.moveToElement( syncHarness ).click( syncHarness );
        builder.perform();
        Thread.sleep(3000);
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
        harnessComponentAlreadyCreated= false;
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
    @And("Navigated to Harness Font setting page")
    public void navigatedToHarnessFontSettingPage() {
        loginPage.load(EndPoint.FontSettingsURL.url.replace("profileName",System.getProperty("profileName")));
    }

    @And("Accept alert")
    public void acceptAlert() throws InterruptedException {
        try{
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
        catch (NoAlertPresentException e){
            Thread.sleep(2000);
        }
    }

    @And("User navigated to projects")
    public void userNavigatedToProjects() {
        new CommonElements(context.driver).navigateHome();
        new CommonElements(context.driver).openProjects();
        new ProjectLanding(context.driver).verifyProjectsPageOpened();
    }

    @And("Navigated to {string} project")
    public void navigatedToDemo_IntegrationProject(String newProject) {
        loginPage.load(EndPoint.PROJECT.url.replace("projectName",newProject));
    }
@And("Navigated to Harness Connector editor setting page")
    public void navigatedToHarnesConnectoreditorSettingPage() {
        loginPage.load(EndPoint.CONNECTOREDITORSETTING.url.replace("profileName",System.getProperty("profileName")));
    }
 @And("Navigated to Harness Advanced setting page")
    public void navigatedToHarnessAdvancedSettingPage() {
        loginPage.load(EndPoint.HARNESSADVANCED.url.replace("profileName",System.getProperty("profileName")));
    }
@And("Navigated to Harness Splice editor setting page")
    public void navigatedToHarnessSpliceEditorSettingPage() {
        loginPage.load(EndPoint.SPLICEEDITORSETTING.url.replace("profileName",System.getProperty("profileName")));
    }

    @And("Navigated to Schematic wire properties page")
    public void navigatedToSchematicWirePropertiesPage() {
        loginPage.load(EndPoint.SCHEMATICWIREPROPERTIES.url.replace("profileName",System.getProperty("profileName")));
//        loginPage.load(EndPoint.SCHEMATICWIREPROPERTIES.url.replace("profileName","default"));
    }
    @And("Navigated to Label visibility in profile page")
    public void navigatedToLabelVisibility() {
        loginPage.load(EndPoint.LABELVISIBILITY.url.replace("profileName",System.getProperty("profileName")));
    }
    @And("Navigated to Label visibility in profile page for formboard")
    public void navigatedToLabelVisibilityFormboard() {
        loginPage.load(EndPoint.FORMBOARDLABELVISIBILITY.url.replace("profileName",System.getProperty("profileName")));
    }
    @And("Navigated to harness update font in profile page")
    public void navigatedToHarnessUpdateFonts() {
        loginPage.load(EndPoint.HARNESSUPDATEFONTS.url.replace("profileName",System.getProperty("profileName")));
    }
    @And("Navigated to form board update font in profile page")
    public void navigatedToFormBoardUpdateFonts() {
        loginPage.load(EndPoint.FORMBOARDUPDATFONTS.url.replace("profileName",System.getProperty("profileName")));
    }
}
