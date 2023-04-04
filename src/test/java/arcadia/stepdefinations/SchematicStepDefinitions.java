package arcadia.stepdefinations;

import arcadia.context.FlowContext;
import arcadia.context.TestContext;
import arcadia.domainobjects.Harness;
import arcadia.domainobjects.Schematic;
import arcadia.pages.*;
import arcadia.utils.StringHelper;
import io.cucumber.java.en.And;

import java.awt.*;

public class SchematicStepDefinitions {
    private final TestContext context;
    private final ProjectLanding projectLanding;
    private final CreateSchematic createSchematic;

    public SchematicStepDefinitions(TestContext context) {
        this.context = context;
        projectLanding = PageFactoryManager.getProjectLanding(context.driver);
        createSchematic = PageFactoryManager.getCreateSchematic(context.driver);
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
       IntegrationTestElementsPage integrationTestElementsPage=new IntegrationTestElementsPage(context.driver);
        integrationTestElementsPage.addInlineConnector(0,0, "C1");
        integrationTestElementsPage.addInlineConnector(0,100,"C2");
        integrationTestElementsPage.addInlineConnector(200,0,"C3");
        integrationTestElementsPage.addInlineConnector(200,100,"C4");
        Thread.sleep(2000);

    }

    @And("add more pins to connector")
    public void addMorePinsToConnector() throws InterruptedException {
        new IntegrationTestElementsPage(context.driver).addPinsToConnector();

    }

    @And("click on Housings from the footer")
    public void clickOnHousings() throws InterruptedException {
        new IntegrationTestElementsPage(context.driver).clickOnHousingsFooter();

    }

    @And("click on Pins dropdown from the footer")
    public void clickOnPinsDropdownFromTheFooter() throws InterruptedException {
        new IntegrationTestElementsPage(context.driver).clickOnPinsFooter();
    }
}
