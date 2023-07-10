package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.pages.ConnectorCavityTablePage;
import arcadia.pages.PageFactoryManager;
import arcadia.pages.UpdateImagePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

public class UpdateImageStepDefinition {
    private final TestContext context;
    private final UpdateImagePage updateImagePage;
    private final ConnectorCavityTablePage connectorCavityTablePage;

    public UpdateImageStepDefinition(TestContext context){
        this.context =context;
        updateImagePage = PageFactoryManager.getUpdateImagePage(context.driver);
        connectorCavityTablePage = PageFactoryManager.getConnectorCavityTablePage(context.driver);
    }
    @And("user verifies update image tab is opened or not")
    public void userverifiesupdateimagetabisopenedornot(){

    }

    @And("user select checkbox image {string} and sets image scale size as {string}")
    public void userSelectCheckboxImageLoadingAndSetsImageScaleSizeAs(String imageView, String imageScale) throws InterruptedException {
        updateImagePage.userSelectCheckboxImageLoadingAndSetsImageScaleSizeAs(imageView,imageScale);
    }

    @Then("Check whether image view and image scale of {string} of connector")
    public void checkWhetherImageViewAndImageScaleOfTopOfConnector(String imageScale) throws InterruptedException {
        updateImagePage.checkWhetherImageViewAndImageScaleOfTopOfConnector(imageScale);
    }

    @And("click checkbox of views and scale")
    public void clickCheckboxOfViewsAndScale() throws InterruptedException {
        updateImagePage.clickCheckboxOfViewsAndScale();
    }

    @And("user add terminal to the placed connector and terminal image display")
    public void userAddTerminalToThePlacedConnectorAndTerminalImageDisplay() throws InterruptedException, AWTException {
        new Select(connectorCavityTablePage.terminalImageDisplay).selectByVisibleText("Yes");
        connectorCavityTablePage.addCavity();
        connectorCavityTablePage.enterTerminalPartNumber();
    }

    @And("user select checkbox terminal image {string} view and image scale as {string}")
    public void userSelectCheckboxTerminalImageTopViewAndImageScaleAs(String imageView,String imageScale) throws InterruptedException {
        updateImagePage.userSelectCheckboxTerminalImageTopViewAndImageScaleAs(imageView,imageScale);
        
    }

    @Then("check whether terminal image is matching as per the expected image scale {string} or not")
    public void checkWhetherTerminalImageIsMatchingAsPerTheExpectedImageScaleOrNot(String imageScale) throws InterruptedException {
        updateImagePage.checkWhetherTerminalImageIsMatchingAsPerTheExpectedImageScaleOrNot(imageScale);
    }

    @And("assign part number to splice as {string}")
    public void assignPartNumberToSplice(String splicePartNumber) throws InterruptedException {
        updateImagePage.assignPartNumberToSplice(splicePartNumber);
    }

    @And("user select checkbox for default splice view {string} and image scale as {string}")
    public void userSelectCheckboxForDefaultSpliceViewTopAndImageScaleAs(String imageView ,String imageScale) throws InterruptedException {
        updateImagePage.userSelectCheckboxForDefaultSpliceViewTopAndImageScaleAs(imageView,imageScale);
    }

    @And("check whether splice view and image scale as {string}")
    public void checkWhetherSpliceViewAndImageScaleAs(String imageScale) throws InterruptedException {
        updateImagePage.checkWhetherSpliceViewAndImageScaleAs(imageScale);
    }

    @And("user add seal to the placed connector and terminal image display")
    public void userAddSealToThePlacedConnectorAndTerminalImageDisplay() throws InterruptedException, AWTException {
        Thread.sleep(5000);
        connectorCavityTablePage.attachPartsConnectorCheckBox.click();
        connectorCavityTablePage.buttonSubmitDetails.click();
    }

    @And("user select checkbox for default seal view {string} and image scale as {string}")
    public void userSelectCheckboxForDefaultSealViewTopAndImageScaleAs(String  imageView,String imageScale) throws InterruptedException {
        updateImagePage.userSelectCheckboxForDefaultSealViewTopAndImageScaleAs(imageView,imageScale);
    }

    @And("check whether seal view and image scale as {string}")
    public void checkWhetherSealViewAndImageScaleAs(String imageScale) {
        updateImagePage.checkWhetherSealViewAndImageScaleAs(imageScale);
    }
}
