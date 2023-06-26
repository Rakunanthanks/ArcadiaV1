package arcadia.stepdefinations;

import arcadia.context.FlowContext;
import arcadia.context.TestContext;
import arcadia.domainobjects.Schematic;
import arcadia.pages.*;
import arcadia.pages.ComponentDB.AddNewComponentPage;
import arcadia.utils.SeleniumCustomCommand;
import arcadia.utils.StringHelper;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SchematicStepDefinitions {
    private final TestContext context;
    private final ProjectLanding projectLanding;
    private final CreateSchematic createSchematic;
    private final SchematicsDrawingPage schematicsDrawingPage;
    private final WireEditorPage wireEditorPage;

    public SchematicStepDefinitions(TestContext context) {
        this.context = context;
        projectLanding = PageFactoryManager.getProjectLanding(context.driver);
        createSchematic = PageFactoryManager.getCreateSchematic(context.driver);
        schematicsDrawingPage = PageFactoryManager.getSchematicDrawingPage(context.driver);
        wireEditorPage = PageFactoryManager.getWireEditorPage(context.driver);
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
        String expectedWireLabel = "WIRE12-10-BK-GXL";
        schematicsDrawingPage.verifyWireLabel(expectedWireLabel);
    }

    @When("User updates pin display")
    public void userUpdatesPinDisplay() {
    }

    @And("add the wire label for few of the wire and verify")
    public void addTheWireLabelForOneOfThwWireAndVerify() throws InterruptedException {
        schematicsDrawingPage.drawWireLabel(4,40,0,"C1");
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
        schematicsDrawingPage.zoomFit();
        new HarnessPage(context.driver).selectHeader("Harness");
        new HarnessPage(context.driver).clickOnNode();
        schematicsDrawingPage.addNodesToHarness();
        Thread.sleep(2000);
    }

    @And("user select the {string} to add the part {string}")
    public void userSelectTheNodeToAddTheParts(String nodeIndex,String partNameIndex) throws InterruptedException {
        schematicsDrawingPage.selectNodeToAddPart(nodeIndex,partNameIndex);
    }

    @And("user verifies the {string} filter to link part {string}")
    public void userVerifiesTheSearchFilterToLinkParts(String filter, String partNameIndex) throws InterruptedException {
        switch(filter.toLowerCase()) {
            case "search":
                break;
            default:
                schematicsDrawingPage.chooseFilter(filter);
                break;
    }
        schematicsDrawingPage.addPartToNode(partNameIndex);
    }

    @And("user selects footer snap {string}")
    public void userSelectsFooterSnap(String snap) throws InterruptedException {
        schematicsDrawingPage.selectSnap(snap.toUpperCase());
    }

    @And("User opens left pane on harness")
    public void userOpensLeftPaneOnHarness() throws InterruptedException {
        schematicsDrawingPage.openLeftPanel();
    }
    @And("User closes left pane on harness")
    public void userClosesLeftPaneOnHarness() throws InterruptedException {
        schematicsDrawingPage.closeLeftPanel();
    }

    @And("user adds connector and splice to node from tree view")
    public void userAddsConnectorAndSpliceToNodeFromTreeView() throws InterruptedException {
        schematicsDrawingPage.addComponentFromTreeToDrawing("Connector","C1 - Main","Node","Node10");
        schematicsDrawingPage.addComponentFromTreeToDrawing("Splice","SP-BK - Splice","Node","Node18");
    }

    @And("user click on part {string} to drag and drop to {string}")
    public void userClickOnPartCToDragAndDropToNode(String connectorIndex , String nodeindex) throws InterruptedException {
        schematicsDrawingPage.selectConnectorToChangeNode(nodeindex,connectorIndex);
    }

    @And("User imports schematic harness")
    public void userImportsSchematicHarness() throws InterruptedException {
        schematicsDrawingPage.verifyDrawingsListPageLoaded();
        String harnessFilePath = "src/test/resources/drawingboard/SchematicHarness_4308_7696_4492_1685634948.hrx";
        schematicsDrawingPage.importHarness(harnessFilePath);
    }

    @Then("user verifies wires can be deleted successfully on schematic harness")
    public void userVerifiesWiresCanBeDeletedSuccessfullyOnSchematicHarness() throws InterruptedException {
        schematicsDrawingPage.zoomFit();
        int initialWiresCount = schematicsDrawingPage.getWiresCount();
        schematicsDrawingPage.verifyWiresCanBeDeleted(initialWiresCount);
    }

    @And("User imports base schematic")
    public void userImportsBaseSchematic() throws InterruptedException {
        schematicsDrawingPage.verifyDrawingsListPageLoaded();
        String schematicFilePath = "src/test/resources/baseSchematic/7612_6530_7413_1684754979.srx";
        schematicsDrawingPage.importtask(schematicFilePath);
    }

    @Then("User verifies wires can be exported successfully on schematic harness")
    public void userVerifiesWiresCanBeExportedSuccesfullyOnSchematicHarness() throws InterruptedException {
        schematicsDrawingPage.zoomFit();
        int initialWiresCount = schematicsDrawingPage.getWiresCount();
        Assert.assertTrue(initialWiresCount!=0,"No wires are available on drawing to export");
        schematicsDrawingPage.moveToWireEditor();
        schematicsDrawingPage.selectExportWires();
        wireEditorPage.verifyFileIsDownloaded("wires.csv");
    }

    @Then("user verifies wires are loaded from schematic succesfully")
    public void userVerifiesWiresAreLoadedFromSchematicSuccesfullyOnHarnessWireeditor() throws InterruptedException {
        int wirecount = schematicsDrawingPage.getWiresCountOnWireEditor();
        Assert.assertTrue(wirecount!=0,"No wires present on wireeditor");
        schematicsDrawingPage.selectAllWiresOnEditor();
        schematicsDrawingPage.submitWires();
        schematicsDrawingPage.saveWireChanges();
        new AddNewComponentPage(context.driver).verifyAlertMessage("Wires imported successfully.");
        new AddNewComponentPage(context.driver).closeAlertPopUp();
        schematicsDrawingPage.goToDrawingFromWireEditor();
        int finalWiresCount = schematicsDrawingPage.getWiresCount();
        Assert.assertEquals(finalWiresCount,wirecount);
    }

    @And("user loades wires from schematic on harness wireeditor")
    public void userLoadesWiresFromSchematicOnHarnessWireeditor() throws InterruptedException {
        schematicsDrawingPage.zoomFit();
        int initialWiresCount = schematicsDrawingPage.getWiresCount();
        if (initialWiresCount>0){
            schematicsDrawingPage.verifyWiresCanBeDeleted(initialWiresCount);
        }
        schematicsDrawingPage.moveToWireEditor();
        Thread.sleep(4000);
        schematicsDrawingPage.selectLoadFromSchematic();
        schematicsDrawingPage.verifyLoadSchematicWindowOpened();
        String schematicTaskName = FlowContext.drawingTaskName;
        schematicsDrawingPage.selectTaskToBeLoaded(schematicTaskName);
    }

    @And("user move the whole drawing relatively to have every component inside frame")
    public void userMoveTheWholeDrawingRelativelyToHaveEveryComponentInsideFrame() throws InterruptedException {
        Point p=schematicsDrawingPage.getCurrentPositionOfNode();
        ExtentCucumberAdapter.addTestStepLog(String.format("Current Location of node, X: "+p.getX()+" and Y: "+p.getY()));
        String id=schematicsDrawingPage.getIdOfRelativeNode();
        String command="moverelative "+id+" 182.5mm,238.75mm";
        HarnessPage harnessPage = new HarnessPage(context.driver);
        harnessPage.fillCommandLine(command);
        harnessPage.clickOnCommandLineOK();
        harnessPage.waitBetweenHarnessActions();
        Point p1=schematicsDrawingPage.getCurrentPositionOfNode();
        ExtentCucumberAdapter.addTestStepLog(String.format("New Location of node, X: "+p1.getX()+" and Y: "+p1.getY()));

    }

    @And("User imports harness")
    public void userImportsHarness() throws InterruptedException {
        schematicsDrawingPage.verifyDrawingsListPageLoaded();
        String harnessFilePath = "src/test/resources/drawingboard/SchematicHarness_Restructuring.hrx";
        schematicsDrawingPage.importHarness(harnessFilePath);
    }

    @And("User click on Auto Arrange button to arrange the components")
    public void userClickOnAutoArrangeButtonToArrangeTheComponents() throws InterruptedException {
        schematicsDrawingPage.autoArrangeHanress();

    }

    @And("User toggle on the splice images for all the splices")
    public void userToggleOnTheSpliceImagesForAllTheSplices() throws InterruptedException {
        schematicsDrawingPage.toggleOnTheSpliceImage();
    }

    @And("User move the splice images to restructure the harness")
    public void userMoveTheSpliceImagesToRestructureTheHarness() throws InterruptedException {
        schematicsDrawingPage.moveSpliceImages();
        Thread.sleep(3000);
    }

    @And("user change select the Show to locations from context menu of splice")
    public void userChangeSelectTheShowToLocationsFromContextMenuOfSplice() throws InterruptedException {
        schematicsDrawingPage.showWireLocations();
    }

    @And("user scale up the image size for some components")
    public void userScaleUpTheImageSizeForSomeComponents() throws InterruptedException {
        schematicsDrawingPage.scaleUpImages();
    }

    @And("user move wire leads to restructure the wire linked to components")
    public void userMoveWireLeadsToRestructureTheWireLinkedToComponents() throws InterruptedException {
        schematicsDrawingPage.moveWireLeads();
    }

    @And("user toggle on the connector label option for all connectors")
    public void userToggleOnTheConnectorLabelOptionForAllConnectors() throws InterruptedException {
        int size=schematicsDrawingPage.toggleConnectorLabel();
        if (size>0)
        {
            ExtentCucumberAdapter.addTestStepLog(String.format("Connector Labels are toggled on"));
        }
        else{
            ExtentCucumberAdapter.addTestStepLog(String.format("Connector Labels are failed to toggled on"));
        }
    }

    @And("User add the label to connector label from config page {word} {}")
    public void userAddTheLabelToConnectorLabelFromConfigPage(String function,String word) throws InterruptedException {
        String yesno="";
        if(word.equalsIgnoreCase("enable"))
            yesno="yes";
        else yesno="no";
        schematicsDrawingPage.openProfileSettingPage(function.toLowerCase(),yesno);
    }

    @And("User moved to wire editor")
    public void userMovedToWireEditor() throws InterruptedException {
        schematicsDrawingPage.zoomFit();
        schematicsDrawingPage.moveToWireEditor();
    }

    @Then("user verifies columns can be hidden and shown on wire editor")
    public void userVerifiesColumnsCanBeHiddenAndShownOnWireEditor() throws InterruptedException {
        schematicsDrawingPage.verifyShowHideWireEditorColumns();
    }

    @And("user add the wire table in the new frame adjacent to existing frame")
    public void userAddTheWireTableInTheNewFrameAdjacentToExistingFrame() throws InterruptedException {
        schematicsDrawingPage.addNewFrame();
        schematicsDrawingPage.addWireTable();
    }
    @And("user updates wiretable")
    public void  userUpdatesWireTable() throws InterruptedException {
        schematicsDrawingPage.updateWireTable();
    }

    @And("user made some changes in wires connected to components")
    public void userMadeSomeChangesInWiresConnectedToComponents() {

    }
    @And("changes should be visible in wire table")
    public void changesShouldBeVisibleInWireTable() {

    }



    @When("User verifies wires can be loaded from schematic on drawing page succesfully")
    public void userTriesToLoadWiresFromSchematicOnDrawingPage() throws InterruptedException {
        schematicsDrawingPage.zoomFit();
        int initialWiresCount = schematicsDrawingPage.getWiresCount();
        if (initialWiresCount>0){
            schematicsDrawingPage.verifyWiresCanBeDeleted(initialWiresCount);
        }
        schematicsDrawingPage.openLoadWiresForm();
        schematicsDrawingPage.verifyLoadWiresFromSchematicOnDrawingOpened();
        String schematicTaskName = FlowContext.drawingTaskName;
        schematicsDrawingPage.submitAndVerifyLoadWiresDetails(schematicTaskName);
    }

    @And("User verifies wires can be imported successfully")
    public void userVerifiesWiresCanBeExportedAndImportedSuccessfully() throws InterruptedException {
        schematicsDrawingPage.zoomFit();
        int initialWiresCount = schematicsDrawingPage.getWiresCount();
        schematicsDrawingPage.verifyWiresCanBeDeleted(initialWiresCount);
        schematicsDrawingPage.moveToWireEditor();
        String wiresFilePath = "src/test/resources/drawingboard/wires.csv";
        schematicsDrawingPage.importWiresCsvOnWireEditor(wiresFilePath);
        int wiresImportedCount = schematicsDrawingPage.getWiresCountOnWireEditor();
        Assert.assertTrue(wiresImportedCount!=0,"Wires imported count is zero");
        schematicsDrawingPage.saveWireChanges();
        new AddNewComponentPage(context.driver).verifyAlertMessage("Wires imported successfully.");
        new AddNewComponentPage(context.driver).closeAlertPopUp();
        schematicsDrawingPage.goToDrawingFromWireEditor();
        int finalWiresCount = schematicsDrawingPage.getWiresCount();
        Assert.assertTrue(wiresImportedCount!=0,"Wires count is zero on drawing page");

    }

    @And("User schematic data can be synced on harness drawing")
    public void userSyncsSchematicDataOnHarnessDrawing() throws InterruptedException {
        schematicsDrawingPage.selectSchematicInfoTabFromLeftPane();
        String schematicTaskName = FlowContext.drawingTaskName;
        schematicsDrawingPage.enterSchematicDetailsOnLeftPane(schematicTaskName);
        schematicsDrawingPage.selectSheetsTabFromLeftPane();
        schematicsDrawingPage.syncSchematicLeftPane();
    }

    @And("user loads schematic data on connector editor")
    public void userLoadsSchematicDataOnConnectorEditor() throws InterruptedException {
        schematicsDrawingPage.loadSchematicOnConnectorEditor();
        schematicsDrawingPage.verifyLoadSchematicWindowOpened();
        String schematicTaskName = FlowContext.drawingTaskName;
//        String schematicTaskName = "3392";
        schematicsDrawingPage.selectTaskToBeLoaded(schematicTaskName);
    }

    @Then("user verifies schematic is loaded on connector editor successfully")
    public void userVerifiesSchematicIsLoadedOnConnectorEditorSuccessfully() throws InterruptedException {
        int connectorsRowCount = schematicsDrawingPage.getConnectorsCountOnConnectorEditor();
        Assert.assertEquals(connectorsRowCount,6);
        schematicsDrawingPage.selectAllConnectorsOnConnectorEditor();
        schematicsDrawingPage.submitConnectorEditorChanges();
        schematicsDrawingPage.saveConnectorEditorChanges();
        new AddNewComponentPage(context.driver).verifyAlertMessage("Connector details imported successfully.");
        new AddNewComponentPage(context.driver).closeAlertPopUp();
        schematicsDrawingPage.goToDrawingFromWireEditor();
    }

    @And("User imports harness {string}")
    public void userImportsHarnessSchematicHarness_Restructuring(String harnessName) throws InterruptedException {
        schematicsDrawingPage.verifyDrawingsListPageLoaded();
        String harnessFilePath="";
        switch (harnessName){
            case "SchematicHarness_Restructuring":
                harnessFilePath = "src/test/resources/drawingboard/SchematicHarness_Restructuring.hrx";
                break;
            case "NewScenarioHarness":
                 harnessFilePath = "src/test/resources/drawingboard/NewScenarioHarness.hrx";
                break;
            case "CrossRef_UpdateImage":
                harnessFilePath = "src/test/resources/drawingboard/CrossRef_UpdateImage.hrx";
                break;
            case "drawskeleton":
                harnessFilePath = "src/test/resources/drawingboard/drawskeleton.hrx";
                break;
            case "baselineHarness":
                harnessFilePath = "src/test/resources/drawingboard/baselineHarness.hrx";
                break;
             case "Load Wires":
                harnessFilePath = "src/test/resources/drawingboard/loadwires.hrx";
                break;

        }
        schematicsDrawingPage.importHarness(harnessFilePath);
    }

    @And("user move to connector cavity table Harness page and {string} hide empty column and make some column visible")
    public void userMoveToConnectorCavityTableHarnessPage(String word) throws InterruptedException {
        userAddTheLabelToConnectorLabelFromConfigPage("harness_cavity",word);
    }


    @And("user verifies that empty columns are {string} in table")
    public void userVerifiesThatEmptyColumnsAreVisibleInTable(String condition) throws InterruptedException {
        Thread.sleep(2000);
        int columns=schematicsDrawingPage.varifyHiddenColumns();
        System.out.println(columns);
        if(condition.equalsIgnoreCase("visible"))
        {
            if(columns>0)
            ExtentCucumberAdapter.addTestStepLog(String.format("Empty columns are visible"));
            else
            {
                ExtentCucumberAdapter.addTestStepLog(String.format("Empty columns are not visible"));
                Assert.fail();
            }}
        else if(condition.equalsIgnoreCase("not visible"))
        {
            if(columns>=4)
                ExtentCucumberAdapter.addTestStepLog(String.format("Empty columns are not visible"));
            else {
                ExtentCucumberAdapter.addTestStepLog(String.format("Empty columns are visible"));
                Assert.fail();
            }
        }
    }

    @And("user add the terminal part number to check if new column is coming on adding the details")
    public void userAddTheTerminalPartNumberToCheckIfNewColumnIsComingOnAddingTheDetails() throws InterruptedException {
        schematicsDrawingPage.addTerminalPartNo();
        Thread.sleep(3000);
        int columns=schematicsDrawingPage.varifyHiddenColumns();
        System.out.println(columns);
            if(columns>=0)
                ExtentCucumberAdapter.addTestStepLog(String.format("terminal part number column is visible"));
            else
            {
                ExtentCucumberAdapter.addTestStepLog(String.format("terminal part number column is not visible"));
                Assert.fail();
            }
            schematicsDrawingPage.undo();
    }

    @And("user verifies terminal in harness cavity is updated with default db hierarchy")
    public void userVerifiesTerminalInHarnessCavityIsUpdatedWithDefaultDbHierarchy() throws InterruptedException {
        schematicsDrawingPage.updateTerminal("db hierarchy");
    }

    @And("user verifies if error is coming if updated with invalid part number")
    public void userVerifiesIfErrorIsComingIfUpdatedWithInvalidPartNumber() throws InterruptedException {
//        schematicsDrawingPage.addInvalidFieldInCavity();
        schematicsDrawingPage.updateTerminal("select");

        int errorCount=schematicsDrawingPage.checkErrors();
        System.out.println(errorCount);
        if(errorCount>0)
            ExtentCucumberAdapter.addTestStepLog(String.format("Test Passed as invalid part number can not be linked to terminal"));
        else
        {
            ExtentCucumberAdapter.addTestStepLog(String.format("Test Failed as invalid part number linked to terminal"));
            Assert.fail();
        }
    }

    @And("user export the harness cavity for the specific connector")
    public void userExportTheHarnessCavityForTheSpecificConnector() throws InterruptedException {
        schematicsDrawingPage.exportHarnessCavity();
    }

    @And("user make some changes in the downloaded harness cavity table")
    public void userMakeSomeChangesInTheDownloadedHarnessCavityTable() {
        String filePath="src/test/resources/drawingboard/HAR_cavity_Import.csv";
        String outputfilePath="src/test/resources/drawingboard/HAR_cavity_ImportNew.csv";
        String oldValue="to change";
        String newValue="automation";
        new SeleniumCustomCommand().updateCSVColumn(filePath,outputfilePath,oldValue,newValue);
    }

    @And("user import the downloaded harness cavity file")
    public void userImportTheDownloadedHarnessCavityFile() throws InterruptedException {
        boolean flag=schematicsDrawingPage.importHarnessCavity();
        if (flag) {
            ExtentCucumberAdapter.addTestStepLog(String.format("Harness Cavity file is Imported successfully"));
        } else {
            ExtentCucumberAdapter.addTestStepLog(String.format("Harness Cavity file is failed to be Imported successfully"));
            Assert.fail();
        }
    }

    @And("user validate the changes done in file on UI")
    public void userValidateTheChangesDoneInFileOnUI() throws InterruptedException {
        int count=schematicsDrawingPage.validateImportOnUI();
        if (count>0) {
            ExtentCucumberAdapter.addTestStepLog(String.format("Harness Cavity file is Imported successfully and changes verified on UI"));
        } else {
            ExtentCucumberAdapter.addTestStepLog(String.format("Harness Cavity file is failed to be Imported successfully"));
            Assert.fail();
        }
    }

    @And("user verify that harness cavity file is exported")
    public void userVerifyThatHarnessCavityFileIsExported() {
        String path = System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles";
        File folder = new File(path);
        File[] files = folder.listFiles();
        boolean containsFile = false;
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().startsWith("HAR")) {
                    containsFile = true;
                    break;
                }
            }
        }
        if (containsFile) {
            ExtentCucumberAdapter.addTestStepLog(String.format("Harness Cavity file is exported successfully"));
        } else {
            ExtentCucumberAdapter.addTestStepLog(String.format("Harness Cavity file is failed to be exported successfully"));
            Assert.fail();
        }

    }

    @And("User verifies the cross ref for {string}")
    public void userVerifiesTheCrossRefForManufacture(String type) throws InterruptedException {
        schematicsDrawingPage.crossRef(type);
    }

    @And("user verifies the changes made for {string}")
    public void userVerifiesTheChangesMadeForManufacture(String type) {
        boolean flag=schematicsDrawingPage.checkCrossRef(type);
        if (flag) {
            ExtentCucumberAdapter.addTestStepLog(String.format("Cross Ref is successfully updated for"+ type));
        } else {
            ExtentCucumberAdapter.addTestStepLog(String.format("Cross Ref is falied to be updated for"+ type));
            Assert.fail();
        }
    }

    @And("user update the images with loading and side view from image views option")
    public void userUpdateTheImagesWithLoadingAndSideViewFromImageViewsOption() throws InterruptedException {
        schematicsDrawingPage.ImageViewsLoadingSide();
        Thread.sleep(2000);
    }

    @And("user update the images with Top and Isometric view from image views option")
    public void userUpdateTheImagesWithTopAndIsometricViewFromImageViewsOption() throws InterruptedException {
        schematicsDrawingPage.ImageViewsTopIsometric();
        Thread.sleep(2000);
    }

    @And("user update the images with Mating and catalogue view from image views option")
    public void userUpdateTheImagesWithMatingAndCatalogueViewFromImageViewsOption() throws InterruptedException {
        schematicsDrawingPage.ImageViewsMatingCatalogue();
        Thread.sleep(2000);
    }

    @And("User move the skeleton relatively")
    public void userMoveTheSkeletonRelatively() throws InterruptedException {
        schematicsDrawingPage.moveSkeletonRelatively();
    }

    @And("user set length and verifies it")
    public void userSetLengthAndVerifiesIt() throws InterruptedException {
        boolean flag=schematicsDrawingPage.setLength();
        if (flag) {
            ExtentCucumberAdapter.addTestStepLog(String.format("Set Length functionality is working"));
        } else {
            ExtentCucumberAdapter.addTestStepLog(String.format("Set Length functionality is failing"));
            Assert.fail();
        }
    }

    @And("user drawn length and verified it")
    public void userDrawnLengthAndVerifiedIt() throws InterruptedException {
        boolean flag=schematicsDrawingPage.drawnLength();
        if (flag) {
            ExtentCucumberAdapter.addTestStepLog(String.format("Drawn Length functionality is working"));
        } else {
            ExtentCucumberAdapter.addTestStepLog(String.format("Drawn Length functionality is failing"));
            Assert.fail();
        }
    }

    @And("wires with bend are added between connectors")
    public void wiresWithBendAreAddedBetweenConnectors() throws InterruptedException {
        Thread.sleep(5000);
        List<String> leftConnector=new ArrayList<>();
        List<String> rightConnector=new ArrayList<>();
        List<String> connectorC1= (schematicsDrawingPage.getInlineConnectorCircles("C1")).stream().map(x -> x.getAttribute("id")).toList();
        leftConnector.addAll(connectorC1);
        List<String> connectorC4=(schematicsDrawingPage.getInlineConnectorCircles("C4")).stream().map(x -> x.getAttribute("id")).toList();
        List<String> connectorC5=(schematicsDrawingPage.getInlineConnectorCircles("C5")).stream().map(x -> x.getAttribute("id")).toList();
        rightConnector.addAll(connectorC4);
        rightConnector.addAll(connectorC5);
        for(int i=0;i<rightConnector.size();i++)
        {
            WebElement left=context.driver.findElement(By.xpath("(//*[name()='circle' and @comp='"+leftConnector.get(i)+"'])[2]"));
            WebElement right=context.driver.findElement(By.xpath("(//*[name()='circle' and @comp='"+rightConnector.get(i)+"'])[1]"));
            String wireName="wire"+i;
            schematicsDrawingPage.connectWire(wireName,left,right);
        }
    }

    @Then("verify wire bend can be removed successfully")
    public void verifyWireBendCanBeRemovedSuccessfully() throws InterruptedException {
        int numberOfVertexLinesBeforeWireBendRemoved = schematicsDrawingPage.getNumberOfVertexLinesOnScehematic();
        schematicsDrawingPage.removeBend();
        int numberOfVertexLinesAfterWireBendRemoved = schematicsDrawingPage.getNumberOfVertexLinesOnScehematic();
        Assert.assertNotEquals(numberOfVertexLinesAfterWireBendRemoved,numberOfVertexLinesBeforeWireBendRemoved,"Wire bend was not removed successfully");
    }

    @And("user navigated to newly created schematic")
    public void userNavigatedToNewlyCreatedSchematic() throws InterruptedException {
        schematicsDrawingPage.verifyDrawingsListPageLoaded();
        schematicsDrawingPage.goToSchematic();
    }


    @And("User verifies drawing page is open")
    public void userVerifiesDrawingPageIsOpen() {
        schematicsDrawingPage.verifyDrawingPageIsOpen();
    }

    @Then("user verifies search view functionality on schematic tree view")
    public void userVerifiesSearchViewFunctionalityOnSchematicTreeView() throws InterruptedException {
        schematicsDrawingPage.verifyConnectorAndPinsCanBeSearchedOnTreeView("C1");
        schematicsDrawingPage.verifyConnectorAndPinsCanBeSearchedOnTreeView("C2");
        schematicsDrawingPage.verifyConnectorAndPinsCanBeSearchedOnTreeView("C3");
        schematicsDrawingPage.verifyConnectorAndPinsCanBeSearchedOnTreeView("C4");
        schematicsDrawingPage.verifyConnectorAndPinsCanBeSearchedOnTreeView("C5");
        schematicsDrawingPage.verifyConnectorAndPinsCanBeSearchedOnTreeView("C6");
        schematicsDrawingPage.verifyComponentCanBeSearchedOnTreeView("SP-BK");
        schematicsDrawingPage.verifyComponentCanBeSearchedOnTreeView("SP-GN");
        schematicsDrawingPage.verifyComponentCanBeSearchedOnTreeView("SP-YE");
        schematicsDrawingPage.verifyComponentCanBeSearchedOnTreeView("WIRE0");
        schematicsDrawingPage.verifyComponentCanBeSearchedOnTreeView("WIRE1");
    }

    @Then("User verifies schematic tree can be expanded")
    public void userVerifiesSchematicTreeCanBeExpanded() {
        schematicsDrawingPage.verifySchematicTreeExpanded();
    }

    @And("User verifies schematic tree can be collapsed")
    public void userVerifiesSchematicTreeCanBeCollapsed() throws InterruptedException {
        schematicsDrawingPage.verifySchematicTreeCollapsed();
    }

    @And("user convert splices to virtual node")
    public void userConvertSplicesToVirtualNode() {
        System.out.println("Could not find this option");
    }

    @And("user validate color label visibility")
    public void userValidateColorLabelVisibility() throws InterruptedException {
        schematicsDrawingPage.updateFont();
        schematicsDrawingPage.setVisibility();
        boolean flag=schematicsDrawingPage.verifySpliceFont();
        if (flag) {
            ExtentCucumberAdapter.addTestStepLog(String.format("Splice font and label visibility verified successfully"));
        } else {
            ExtentCucumberAdapter.addTestStepLog(String.format("Splice font and label visibility verification failed"));
            Assert.fail();
        }
        boolean flag1=schematicsDrawingPage.verifyConnectorFont();
        if (flag1) {
            ExtentCucumberAdapter.addTestStepLog(String.format("Connector font and label visibility verified successfully"));
        } else {
            ExtentCucumberAdapter.addTestStepLog(String.format("Connector font and label visibility verification failed"));
            Assert.fail();
        }
    }

    @When("User expands schematic harness tree")
    public void userExpandsSchematicHarnessTree() throws InterruptedException {
        schematicsDrawingPage.expandLeftTree();
    }

    @Then("Verify components displayed in expanded schematic harness tree")
    public void verifyThatTheHarnessTreeIsExpandedSuccessfully() throws InterruptedException {
        schematicsDrawingPage.verifySchematicHarnessTreeExpandedComponents();
    }

    @And("user verifies search view functionality on schematic harness tree view")
    public void userVerifiesSearchViewFunctionalityOnSchematicHarnessTreeView() throws InterruptedException {
        schematicsDrawingPage.verifySearchSchematicHarnessTree("C1");
        schematicsDrawingPage.verifySearchSchematicHarnessTree("SP-YE");
        schematicsDrawingPage.verifySearchSchematicHarnessTree("BUNDLE3");
        schematicsDrawingPage.verifySearchSchematicHarnessTree("WIRE5");
        schematicsDrawingPage.verifySearchSchematicHarnessTree("TestMCore");
    }

    @When("user updates sleevetube details on schematic harness")
    public void userUpdatesSleevetubeDetailsOnSchematicHarness() throws InterruptedException {
        schematicsDrawingPage.updateSleeveTubeOnSchematicHarness("conduit_slit","PA6");
    }

    @Then("verify that coverings are updated successfully on schematic harness")
    public void verifyThatCoveringsAreUpdatedSuccessfullyOnSchematicHarness() throws InterruptedException {
        schematicsDrawingPage.verifyCoveringsUpdatedOnSchematicHarness();
    }

    @And("user links multicore to schematic harness")
    public void userLinksMulticoreToSchematicHarness() throws InterruptedException {
        schematicsDrawingPage.linkMulticoreToSchematicHarness();
    }

    @And("user enable the label visibility and verify them")
    public void userEnableTheLabelVisibilityAndVerifyThem() throws InterruptedException {
        schematicsDrawingPage.setVisibilityOn();
        boolean flag=schematicsDrawingPage.labelValidation();
        if (flag) {
            ExtentCucumberAdapter.addTestStepLog(String.format("Labels has been verified successfully"));
        } else {
            ExtentCucumberAdapter.addTestStepLog(String.format("Labels has been failed to be verified"));
            Assert.fail();
        }
    }

    @And("user validate the terminal strip length")
    public void userValidateTheTerminalStripLength() {
        boolean flag= schematicsDrawingPage.verifyTerminalStripLength();
        if (flag) {
            ExtentCucumberAdapter.addTestStepLog(String.format("Terminal Strip Length has been verified successfully"));
        } else {
            ExtentCucumberAdapter.addTestStepLog(String.format("Terminal Strip Length has been failed to be verified"));
            Assert.fail();
        }
       WebElement ele= context.driver.findElement(By.xpath("//div[@aria-labelledby='ui-id-38']//span[text()='close']"));
        ele.click();
    }
}
