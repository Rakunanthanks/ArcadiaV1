package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.pages.ConnectorCavityTablePage;
import arcadia.pages.PageFactoryManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Then;

import java.awt.*;

public class ConnectorCavityTableLabelStepDefinitions {
    private final TestContext context;
    private final ConnectorCavityTablePage connectorCavityTablePage;
    public ConnectorCavityTableLabelStepDefinitions(TestContext context){
        this.context = context;
        connectorCavityTablePage = PageFactoryManager.getConnectorCavityTablePage(context.driver);
    }
    @Then("Verify connector cavity {string} label is {string} or not")
    public void verifyConnectorCavityLabelIsVisibleOrNot(String labelName,String visibleHide) throws InterruptedException, AWTException, JsonProcessingException {
        connectorCavityTablePage.verifyConnectorCavityTableIsVisibleOrNot(labelName,visibleHide);
    }
}
