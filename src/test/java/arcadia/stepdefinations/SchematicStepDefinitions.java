package arcadia.stepdefinations;

import arcadia.context.FlowContext;
import arcadia.context.TestContext;
import arcadia.domainobjects.NodeIdentifier;
import arcadia.domainobjects.Schematic;
import arcadia.pages.*;
import arcadia.utils.StringHelper;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SchematicStepDefinitions {
    private final TestContext context;
    private final ProjectLanding projectLanding;
    private final CreateSchematic createSchematic;
    private final SchematicsDrawingPage schematicsDrawingPage;

    public SchematicStepDefinitions(TestContext context) {
        this.context = context;
        projectLanding = PageFactoryManager.getProjectLanding(context.driver);
        createSchematic = PageFactoryManager.getCreateSchematic(context.driver);
        schematicsDrawingPage = PageFactoryManager.getSchematicDrawingPage(context.driver);
    }

    @And("schematic with name {string} is launched successfully")
    public void schematicWithNameDemo_IntegrationIsLaunchedSuccessfully(String description) throws InterruptedException {
        String schematicDescription = description.concat(" " + new StringHelper().generateRandomDigit());
        createNewSchematicInstance(schematicDescription);
    }
    private void createNewSchematicInstance(String schematicDescription) throws InterruptedException {
        String partNumber = new StringHelper().generateRandomDigit().toString();
        projectLanding.invokeCreateSchematic();
        arcadia.mapperObjects.CreateSchematic schematicData = new arcadia.mapperObjects.CreateSchematic();
        schematicData.setComponentDB(System.getProperty("componentDB"));
        schematicData.setProfile(System.getProperty("profileName"));
        schematicData.setPartNumber(partNumber);
        schematicData.setDescription(schematicDescription);
        schematicData.setRevision(new StringHelper().generateRandomDigit().toString());
        schematicData.setTitle(new StringHelper().generateRandomDigit().toString());
        schematicData.setWorkTask(new StringHelper().generateRandomDigit().toString());
        FlowContext.schematicDescription = schematicDescription;
        createSchematic.submitSchematicData(new Schematic(schematicData.getWorkTask(), schematicData.getTitle(), schematicData.getDescription(), schematicData.getPartNumber(), schematicData.getRevision(), schematicData.getComponentDB(),schematicData.getProfile()));
    }

    private void createNewHarnessInstance(String schematicDescription) throws InterruptedException {
        String partNumber = new StringHelper().generateRandomDigit().toString();
        arcadia.mapperObjects.CreateSchematic schematicData = new arcadia.mapperObjects.CreateSchematic();
        schematicData.setComponentDB(System.getProperty("componentDB"));
        schematicData.setProfile(System.getProperty("profileName"));
        schematicData.setPartNumber(partNumber);
        schematicData.setDescription(schematicDescription);
        schematicData.setRevision(new StringHelper().generateRandomDigit().toString());
        schematicData.setTitle(new StringHelper().generateRandomDigit().toString());
        schematicData.setWorkTask(new StringHelper().generateRandomDigit().toString());
        FlowContext.schematicDescription = schematicDescription;
        CreateSchematic createSchematic1=new CreateSchematic(context.driver);
        createSchematic1.submitHarnessData(new Schematic(schematicData.getWorkTask(), schematicData.getTitle(), schematicData.getDescription(), schematicData.getPartNumber(), schematicData.getRevision(), schematicData.getComponentDB(),schematicData.getProfile()));
    }

    @And("add inline connectors to schematic")
    public void addInlineConnectorsToSchematic() throws InterruptedException, AWTException {
        schematicsDrawingPage.addInlineConnector(0,0, "C1","Main",true);
        schematicsDrawingPage.addInlineConnector(0,100,"C2","Lamda1",true);
        schematicsDrawingPage.addInlineConnector(0,200,"C3","Pressure",true);
        schematicsDrawingPage.addInlineConnector(200,0,"C4","",false);
        schematicsDrawingPage.addInlineConnector(200,100,"C5","",false);
        schematicsDrawingPage.addInlineConnector(200,200,"C6","",false);
        Thread.sleep(2000);

    }

    @And("add more pins to connector")
    public void addMorePinsToConnector() throws InterruptedException {
        schematicsDrawingPage.addPinsToConnectorUsingConnectorName("C1",4);
        schematicsDrawingPage.addPinsToConnectorUsingConnectorName("C2",3);
        schematicsDrawingPage.addPinsToConnectorUsingConnectorName("C3",2);
        schematicsDrawingPage.addPinsToConnectorUsingConnectorName("C4",1);
        schematicsDrawingPage.addPinsToConnectorUsingConnectorName("C5",2);
        schematicsDrawingPage.addPinsToConnectorUsingConnectorName("C6",5);
    }

    @And("click on Housings from the footer")
    public void clickOnHousings() throws InterruptedException {
        schematicsDrawingPage.clickOnHousingsFooter();
    }

    @And("click on Pins dropdown from the footer")
    public void clickOnPinsDropdownFromTheFooter() throws InterruptedException {
        schematicsDrawingPage.clickOnPinsFooter();
    }

    @And("add splices to schematic")
    public void addSplicesToSchematicUsingPins() throws InterruptedException {
        schematicsDrawingPage.addSplicesToSchematic(4,90,0,"C1","SP-BK");
        schematicsDrawingPage.addSplicesToSchematic(6,110,0,"C2","SP-GN");
        schematicsDrawingPage.addSplicesToSchematic(2,90,0,"C2","SP-YE");
        schematicsDrawingPage.zoomOut();
    }

    @And("draw wires between connectors")
    public void drawWiresBetweenConnectors() throws InterruptedException {
        Thread.sleep(2000);
        List<String> leftConnector=new ArrayList<>();
        List<String> rightConnector=new ArrayList<>();
        List<String> connectorC1= (schematicsDrawingPage.getInlineConnectorCircles("C1")).stream().map(x -> x.getAttribute("id")).toList();
        List<String> connectorC2= (schematicsDrawingPage.getInlineConnectorCircles("C2")).stream().map(x -> x.getAttribute("id")).toList();
        List<String> connectorC3= (schematicsDrawingPage.getInlineConnectorCircles("C3")).stream().map(x -> x.getAttribute("id")).toList();
        leftConnector.addAll(connectorC1);
        leftConnector.addAll(connectorC2);
        leftConnector.addAll(connectorC3);
        List<String> connectorC4=(schematicsDrawingPage.getInlineConnectorCircles("C4")).stream().map(x -> x.getAttribute("id")).toList();
        List<String> connectorC5=(schematicsDrawingPage.getInlineConnectorCircles("C5")).stream().map(x -> x.getAttribute("id")).toList();
        List<String> connectorC6=(schematicsDrawingPage.getInlineConnectorCircles("C6")).stream().map(x -> x.getAttribute("id")).toList();
        rightConnector.addAll(connectorC4);
        rightConnector.addAll(connectorC5);
        rightConnector.addAll(connectorC6);
        for(int i=0;i<rightConnector.size();i++)
        {
            WebElement left=context.driver.findElement(By.xpath("(//*[name()='circle' and @comp='"+leftConnector.get(i)+"'])[2]"));
            WebElement right=context.driver.findElement(By.xpath("(//*[name()='circle' and @comp='"+rightConnector.get(i)+"'])[1]"));
            String wireName="wire"+i;
            schematicsDrawingPage.connectWire(wireName,left,right);
        }
        List<String> spliceIds=(schematicsDrawingPage.getInlineSplices()).stream().map(x -> x.getAttribute("id")).toList();
        for(int i=0;i<spliceIds.size();i++)
        {
            WebElement left=context.driver.findElement(By.xpath("(//*[name()='circle' and @comp='"+leftConnector.get(i)+"'])[2]"));
            WebElement right=context.driver.findElement(By.xpath("//*[name()='circle' and @comp='"+spliceIds.get(i)+"']"));
            String wireName="wire"+(i+12);
            schematicsDrawingPage.connectWire(wireName,left,right);
        }
    }

    @And("change the wire settings from wire editor")
    public void changeTheWireSettingsFromWireEditor() throws InterruptedException, AWTException {
        schematicsDrawingPage.moveToWireEditor();
        schematicsDrawingPage.selectComponentDB();
        schematicsDrawingPage.changePrimaryColour();
        schematicsDrawingPage.changeGaugeAndMaterial();
        schematicsDrawingPage.saveWireEditorChanges();
    }

    @And("go to drawing from wire editor")
    public void goToDrawingFromWireEditor() throws InterruptedException {
        schematicsDrawingPage.goToDrawingFromWireEditor();
    }

    @And("validate the wire labels before removing")
    public void validateTheWireLabelsBeforeRemoving() {
        int no=schematicsDrawingPage.numberOfWireLabels();
        if(no>0)
        {
            ExtentCucumberAdapter.addTestStepLog(String.format("Wire Labels are visible"));
        }
        else{
            ExtentCucumberAdapter.addTestStepLog(String.format("Wire Labels are not visible"));
            Assert.fail();
        }
    }

    @And("validate the wire labels after removing")
    public void validateTheWireLabelsAfterRemoving() throws InterruptedException {
        schematicsDrawingPage.removeWireLabels();
        int no=schematicsDrawingPage.numberOfWireLabels();
        if(no>0)
        {
            ExtentCucumberAdapter.addTestStepLog(String.format("Wire Labels are visible"));
            Assert.fail();
        }
        else{
            ExtentCucumberAdapter.addTestStepLog(String.format("Wire Labels are not visible"));
        }
    }

    @And("verify wire label can be removed successfully")
    public void verifyWireLabelCanBeRemovedSuccessfully() throws InterruptedException {
        String wireId = "WIRE0";
        boolean isWireLabelPresent = schematicsDrawingPage.checkIfWireLabelPresent(wireId);
        Assert.assertTrue(isWireLabelPresent,"Wire label is not present");
        schematicsDrawingPage.removeAllWireLabels();
        Thread.sleep(3000);
        isWireLabelPresent = schematicsDrawingPage.checkIfWireLabelPresent(wireId);
        Assert.assertFalse(isWireLabelPresent,"Wire label is present on schematic drawing page even after removing all wire labels");
    }

    @And("makes the wire labels inline")
    public void makesTheWireLabelsInline() throws InterruptedException {
        schematicsDrawingPage.selectWireLabelsInline();
    }

    @Then("verify the wire label on drawing matches wire properties")
    public void verifyTheWireLabelOnDrawingMatchesWireProperties() throws InterruptedException {
        Thread.sleep(3000);
        String expectedWireLabel = "WIRE12-10-BK-GXL";
        schematicsDrawingPage.verifyWireLabel(expectedWireLabel);
    }

    @When("User updates pin display")
    public void userUpdatesPinDisplay() {
    }

    @And("add the wire label for few of the wire and verify")
    public void addTheWireLabelForOneOfThwWireAndVerify() throws InterruptedException {
        schematicsDrawingPage.drawWireLabel(4,90,0,"C1");
        schematicsDrawingPage.showWireWOLabel();
        int no=schematicsDrawingPage.numberOfWireLabels();
        if(no>0)
        {
            ExtentCucumberAdapter.addTestStepLog(String.format("Wire Labels are visible"));
        }
        else{
            ExtentCucumberAdapter.addTestStepLog(String.format("Wire Labels are not visible"));
            Assert.fail();
        }
    }

    @And("pin display type and partnumber is updated")
    public void pinDisplayTypeAndPartNumberIsUpdated() throws InterruptedException {
        schematicsDrawingPage.updatePinDisplayAndPartNumber("C1","Male",5);
        schematicsDrawingPage.updatePinDisplayAndPartNumber("C2","Male",4);
        schematicsDrawingPage.updatePinDisplayAndPartNumber("C3","Male",3);
//        schematicsDrawingPage.updatePinDisplayAndPartNumber("C4","Female",1);
        schematicsDrawingPage.updatePinDisplayAndPartNumber("C5","Female",3);
        schematicsDrawingPage.updatePinDisplayAndPartNumber("C6","Female",6);
    }

    @And("updated the font settings for the schematic")
    public void updatedTheFontSettingsForTheSchematic() throws InterruptedException {
        schematicsDrawingPage.updateFontSettings();
    }

    @Then("verify partnumbers are added for connectors")
    public void verifyPartNumbersAreAddedForConnectors() throws InterruptedException {
        schematicsDrawingPage.verifyPartNumberIsPresentForConnector("C1");
        schematicsDrawingPage.verifyPartNumberIsPresentForConnector("C2");
        schematicsDrawingPage.verifyPartNumberIsPresentForConnector("C3");
//        schematicsDrawingPage.verifyPartNumberIsPresentForConnector("C4");
        schematicsDrawingPage.verifyPartNumberIsPresentForConnector("C5");
        schematicsDrawingPage.verifyPartNumberIsPresentForConnector("C6");
    }

    @And("switch on the colour of the wires")
    public void switchOnTheColourOfTheWires() throws InterruptedException {
        schematicsDrawingPage.switchOnColour();
    }

    @And("Verify the colour of the wires")
    public void verifyTheColourOfTheWires() {
        boolean flag=schematicsDrawingPage.verifyWireColour();
        if(flag)
        {
            ExtentCucumberAdapter.addTestStepLog(String.format("Wires colours are switched on"));
        }
        else{
            ExtentCucumberAdapter.addTestStepLog(String.format("Wires colours are not able to switched on"));
            Assert.fail();
        }
    }

    @And("user create the harness from schematic")
    public void userCreateTheHarnessFromSchematic() throws InterruptedException {
        schematicsDrawingPage.goToCreateHarness();
        schematicsDrawingPage.switchToFrame();
        createNewHarnessInstance(FlowContext.schematicDescription);
    }

    @And("user verify the harness created from schematic")
    public void userVerifyTheHarnessCreatedFromSchematic() throws InterruptedException {
        boolean flag=schematicsDrawingPage.verifyHarnessCreated();
        if(flag)
        {
            ExtentCucumberAdapter.addTestStepLog(String.format("Harness is successfully created from schematic"));
        }
        else{
            ExtentCucumberAdapter.addTestStepLog(String.format("Harness is failed to be created from schematic"));
            Assert.fail();
        }
    }

    @And("user navigated to newly created harness")
    public void userNavigatedToNewlyCreatedHarness() throws InterruptedException {
        schematicsDrawingPage.verifyDrawingsListPageLoaded();
        schematicsDrawingPage.goToHarness();
    }

    @And("user add nodes to schematic harness")
    public void userAddNodesToSchematicHarness() throws InterruptedException, AWTException {
        new HarnessPage(context.driver).selectHeader("Harness");
        new HarnessPage(context.driver).clickOnNode();
        schematicsDrawingPage.addNodesToHarness();
        Thread.sleep(2000);
    }
}
