package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.pages.FormboardPage;
import arcadia.pages.HarnessPage;
import arcadia.pages.NodeLabelVisibilityPage;
import arcadia.pages.PageFactoryManager;
import io.cucumber.java.en.And;

public class FormboardStepDefinition{
    private final TestContext context;
    private final FormboardPage formboardPage;

    public FormboardStepDefinition(TestContext context){
        this.context =context;
        formboardPage = PageFactoryManager.getFormboardPage(context.driver);
    }
    @And("user sets label {string} to {string} in formboard")
    public void userSetsLabelsToShowHide(String labelName, String showHide) throws InterruptedException {
        Thread.sleep(4000);
        formboardPage.selectHeader("Harness");
        new HarnessPage(context.driver).clickVisibility();
        new HarnessPage(context.driver).showHideComponentLabel(labelName,showHide);
    }


    @And("click Update fonts in formboard")
    public void clickUpdateFontsInFormboard() throws InterruptedException {
        formboardPage.selectHeader("Formboard");
        formboardPage.clickUpdateFonts();
    }
}