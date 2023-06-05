package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.pages.HarnessPage;
import arcadia.pages.PageFactoryManager;
import arcadia.pages.UpdateFontsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.awt.*;

public class UpdateFontsStepDefinition {
    private final TestContext context;
    private final UpdateFontsPage updateFontsPage;
    private final HarnessPage harnessPage;
    public UpdateFontsStepDefinition(TestContext context){
        this.context =context;
        updateFontsPage = PageFactoryManager.getUpdateFontsPage(context.driver);
        harnessPage = PageFactoryManager.getDrawingPage(context.driver);
    }

    @And("Change font size in profile and capture the font size {string}")
    public void changeFontSizeInProfile(String component) throws InterruptedException {
        updateFontsPage.changeFontSizeInProfile(component,"");
    }
    @And("Change font size in profile and capture the font size in formboard {string}")
    public void changeFontSizeInProfileInFormBoard(String component) throws InterruptedException {
        updateFontsPage.changeFontSizeInProfile(component,"");
    }


    @And("Save the profile settings")
    public void saveTheProfileSettings() throws InterruptedException {
        updateFontsPage.saveProfileSettings();
    }

    @Then("check the font size is as per the profile or not")
    public void checkTheFontSizeIsAsPerTheProfileOrNot() {
        updateFontsPage.checkTheFontSizeIsAsPerTheProfileOrNot();
    }
    @Then("check the font size is as per the profile or not in bundle")
    public void checkTheFontSizeIsAsPerTheProfileOrNotInBundle() {
        updateFontsPage.checkTheFontSizeIsAsPerTheProfileOrNotInBundle();
    }
    @Then("check the font size is as per the profile or not in connector")
    public void checkTheFontSizeIsAsPerTheProfileOrNotInConnector() {
        updateFontsPage.checkTheFontSizeIsAsPerTheProfileOrNotInConnector();
    }
    @Then("check the font size is as per the profile or not in splice")
    public void checkTheFontSizeIsAsPerTheProfileOrNotInSplice() {
        updateFontsPage.checkTheFontSizeIsAsPerTheProfileOrNotInSplice();
    }
    @And("click Update fonts")
    public void clickUpdateFonts() throws InterruptedException {
        harnessPage.selectHeader("Harness");
        harnessPage.openFonts();
    }

    @And("Change font size and colour in the task for {string}")
    public void changeFontSizeAndColourInTheTask(String labelName) throws InterruptedException {
        updateFontsPage.changeFontSizeAndColourInTheTask(labelName);
    }

    @Then("Check {string} is as per updated font size and font colour in the task")
    public void checkNodeChildElementIsAsPerUpdatedFontSizeAndFontColourInTheTask(String labelName) throws InterruptedException, AWTException {
        updateFontsPage.checkNodeChildElementIsAsPerUpdatedFontSizeAndFontColourInTheTask(labelName);
    }

    @Then("Check {string} is as per updated font size and font colour in the formboard")
    public void checkNodeNameIsAsPerUpdatedFontSizeAndFontColourInTheFormboard(String labelName) throws InterruptedException {
        updateFontsPage.changeFontSizeAndColourInFormBoard(labelName);
    }

    @And("Change font size in profile and capture the font size in {string} {string}")
    public void changeFontSizeInProfileAndCaptureTheFontSizeInBundle(String component,String module) throws InterruptedException {
        updateFontsPage.changeFontSizeInProfile(component,module);
    }


    @And("change colour and font size of {string} in formboard")
    public void changeColourAndFontSizeOfConnectorLabelInFormboard(String labelName) throws InterruptedException {
        updateFontsPage.changeFontSizeInProfileInFormboard(labelName);
    }

    @And("Place {string} table in harness")
    public void placeTableInHarness(String tableName) throws InterruptedException {
        updateFontsPage.placeTable(tableName);
    }

    @And("update discrete components values in properties")
    public void updateDiscreteComponentsValuesInProperties() throws InterruptedException {
        updateFontsPage.updateDiscreteComponentsValuesInProperties();
    }
}
