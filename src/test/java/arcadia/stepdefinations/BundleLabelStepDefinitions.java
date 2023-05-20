package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.pages.BundleLabelVisibilityPage;
import arcadia.pages.PageFactoryManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Then;

import java.awt.*;

public class BundleLabelStepDefinitions {

    private final TestContext context;
    private final BundleLabelVisibilityPage bundleLabelVisibilityPage;
    public BundleLabelStepDefinitions(TestContext context){
        this.context = context;
        bundleLabelVisibilityPage = PageFactoryManager.getBundleLabelVisibilityPage(context.driver);
    }

    @Then("Verify bundle {string} label is {string} or not")
    public void verifyBundleLabelIsVisibleOrNot(String labelName,String visibleHide) throws InterruptedException, AWTException, JsonProcessingException {
        bundleLabelVisibilityPage.verifyBundleLabelIsVisibleOrNot(labelName,visibleHide);
    }
}
