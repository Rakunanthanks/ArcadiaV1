package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.pages.NodeLabelVisibilityPage;
import arcadia.pages.PageFactoryManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import java.awt.*;

public class NodeLabelStepDefinitions {
    private final TestContext context;
    private final NodeLabelVisibilityPage nodeLabelVisibilityPage;
    public NodeLabelStepDefinitions(TestContext context){
        this.context = context;
        nodeLabelVisibilityPage = PageFactoryManager.getNodeLabelVisibilityPage(context.driver);
    }
    @And("Place node in the Harness")
    public void placeNodeInTheHarness() {
        nodeLabelVisibilityPage.placeNodeInTheHarness();
    }

    @And("Turn on label visibility for {string}")
    public void turnOnLabelVisibilityForNode_Name() {
    }

    @Then("Verify label Node name")
    public void verifyLabelNodeName() {
    }

    @Then("Verify node child element label is visible or not")
    public void verifyNodeChildElementLabelIsVisibleOrNot() {
        nodeLabelVisibilityPage.verifyNodeChildElementLabelIsVisibleOrNot();
    }

    @Then("Verify node child element label is Hidden or not")
    public void verifyNodeChildElementLabelIsHiddenOrNot() {
        nodeLabelVisibilityPage.verifyNodeChildElementLabelIsHiddenOrNot();
    }

    @Then("Verify node name label is visible or not")
    public void verifyNodeChildNameLabelIsVisibleOrNot() {
        nodeLabelVisibilityPage.verifyNodeChildNameLabelIsVisibleOrNot();
    }

    @Then("Verify node child name label is Hidden or not")
    public void verifyNodeChildNameLabelIsHiddenOrNot() {
        nodeLabelVisibilityPage.verifyNodeChildNameLabelIsHiddenOrNot();
    }

    @Then("Verify {string} label is {string} or not")
    public void verifyNodeLabelIsVisibleOrNot(String labelname,String visibleHide) throws InterruptedException, AWTException, JsonProcessingException {
        nodeLabelVisibilityPage.verifyNodeLabelIsVisibleOrNot(labelname,visibleHide);
    }

    @And("user sets label in profile {string} to {string}")
    public void userSetsLabelInProfileNodeToShow(String labelName, String showHide) throws InterruptedException {
       nodeLabelVisibilityPage.userSetsLabelInProfileNodeToShow(labelName,showHide);

    }

}
