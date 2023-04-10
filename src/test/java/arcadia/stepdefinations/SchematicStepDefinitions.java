package arcadia.stepdefinations;

import arcadia.context.FlowContext;
import arcadia.context.TestContext;
import arcadia.domainobjects.Schematic;
import arcadia.pages.*;
import arcadia.utils.StringHelper;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        schematicsDrawingPage.addSplicesToSchematic(6,110,0,"C2","SP_GN");
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
    public void changeTheWireSettingsFromWireEditor() throws InterruptedException {
        schematicsDrawingPage.moveToWireEditor();
        schematicsDrawingPage.changeGaugeAndMaterial();
        schematicsDrawingPage.changePrimaryColour();
        schematicsDrawingPage.saveWireEditorChanges();
    }

    @And("go to drawing from wire editor")
    public void goToDrawingFromWireEditor() {
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
}
