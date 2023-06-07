package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.pages.PageFactoryManager;
import arcadia.pages.SpliceCavityTablePage;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Then;

import java.awt.*;

public class SpliceCavityTableLabelStepDefinitions {
    private final TestContext context;
    private final SpliceCavityTablePage spliceCavityTablePage;

    public SpliceCavityTableLabelStepDefinitions(TestContext context) {
        this.context = context;
        spliceCavityTablePage = PageFactoryManager.getSpliceCavityTablePage(context.driver);
    }

    @Then("Verify splice cavity {string} label is {string} or not")
    public void verifySpliceCavityLabelIsVisibleOrNot(String labelName, String visibleHide) throws InterruptedException, AWTException, JsonProcessingException {
        spliceCavityTablePage.verifySplicerCavityTableIsVisibleOrNot(labelName, visibleHide);
    }
}
