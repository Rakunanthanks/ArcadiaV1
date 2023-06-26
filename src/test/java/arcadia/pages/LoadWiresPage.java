package arcadia.pages;

import arcadia.context.FlowContext;
import arcadia.domainobjects.Harness;
import arcadia.utils.SeleniumCustomCommand;
import arcadia.utils.StringHelper;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.sl.In;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.hotkey.Keys;
import org.testng.Assert;

import java.io.File;
import java.util.*;

public class LoadWiresPage extends BasePage {
    @FindBy(xpath="//button[@id='addProject']")private WebElement addProject;
    @FindBy(css="#ExpProj")private WebElement expandButton;
    @FindBy(css="#frmMain > div.box-footer > div > a")private WebElement cancelButton;
    @FindBy(xpath="//*[@id=\"levels\"]/tbody/tr/td[1]/div/div[1]/input")private WebElement customLevel;
    @FindBy(css="#DynamicForm")private WebElement loadWiresTab;
    @FindBy(css = "button[title=\"Submit\"]") public WebElement submitLoadWires;
    @FindBy(css = "button[title=\"Close\"]") public WebElement closeLoadWiresSummaryReport;
    @FindBy(css="#ui-accordion-accordion-panel-2 > div:nth-child(1) > label > input")private WebElement selectAllCheckBoXProperties;
    @FindBy(css="#ui-accordion-accordion-header-0")private WebElement loadWiresSubmitImportHeaderInformation;
    @FindBy(css="div[id='rightPaneContent'] table[class='tablesorter']")private WebElement loadWiresSummary;
    @FindBy(css="#layer_80 > g.DG2.bundleGroup > g > g > g > foreignObject > table > tbody > tr:nth-child(3) > td:nth-child(2)")private WebElement wireIdOf1stConnector;
    @FindBy(xpath = "//div[@id='accordion']")private WebElement loadWireWireImportInformationTab;
    @FindBy(css="#ireload")private WebElement refreshButton;
    @FindBy(xpath = "//*[@id=\"ui-accordion-accordion-panel-1\"]/div[2]/div/div[1]/input")private  WebElement harnessTagsInput;
    @FindBy(css = "#ui-accordion-accordion-panel-0 > table > tbody > tr:nth-child(2) > td:nth-child(19)")private WebElement variantSXText;
    @FindBy(css = "#ui-accordion-accordion-panel-0 > table > tbody > tr:nth-child(3) > td:nth-child(19)")private WebElement variantExclusiveText;
    @FindBy(css ="#itree")private WebElement leftToggle;
    @FindBy(css="#EXCLUSIVE")private WebElement checkBoxExclusiveVariant;
    @FindBy(css="#layer_80 > g.DG5.bundleGroup > g > g > g > foreignObject > table > tbody > tr")private WebElement wire002;
    @FindBy(css="#SX")private WebElement checkBoxVariantSX;
    @FindBy(css ="#ui-accordion-accordion-panel-2 > table > tbody > tr:nth-child(1) > td") private WebElement mismatchInformationClass;
    @FindBy(css="#layer_80 > g.DG5.bundleGroup > g > g > g > foreignObject > table > tbody tr:nth-child(2)")private WebElement exclusiveWireCavityTable;
    @FindBy(css ="#ui-accordion-accordion-header-1")private WebElement header2;
    String wireTableSize = "#layer_52 > g > g > foreignObject > table > tbody";
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    HarnessPage harnessPage = new HarnessPage(driver);
    public LoadWiresPage(WebDriver driver) {
        super(driver);
    }
    SchematicsDrawingPage schematicsDrawingPage = new SchematicsDrawingPage(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    int projectCount,schematicTaskCountInProjectPage,schematicTaskCountInLoadWiresPage,loadWiresProjectCount;
    List<String> listOfSchematicTask = new ArrayList<>();

    public void captureNoOfProjectsInProjectFolder() throws InterruptedException {
        addProject.click();
        Thread.sleep(5000);
        customLevel.click();
        Object folderCount = js.executeScript("return document.querySelector('#levels > tbody > tr > td:nth-child(1) > div > div.selectize-dropdown.single > div').childElementCount");
        int folderCountToInt = Integer.parseInt(folderCount.toString());
        System.out.println(folderCountToInt);
        customCommand.javaScriptClick(driver,expandButton);
        Object projectTotalCount =js.executeScript("return document.querySelector('#example-tables > div.tabulator-tableholder > div').childElementCount");
        int projectTotalCountToInt = Integer.parseInt(projectTotalCount.toString());
        System.out.println(projectTotalCountToInt);
        projectCount =  projectTotalCountToInt-folderCountToInt;
        System.out.println("Project Count : "+projectCount);
    }
    public void importBaseSchematicTask() throws InterruptedException {
        schematicsDrawingPage.verifyDrawingsListPageLoaded();
        String schematicFilePath = "src/test/resources/baseSchematic/demo_Integration.srx";
        schematicsDrawingPage.importtask(schematicFilePath);
        Thread.sleep(10000);
    }
    public void verifyLoadWiresOpened() {
        customCommand.waitForElementVisibility(driver,loadWiresTab);
        Assert.assertTrue(loadWiresTab.isDisplayed(),"Load Wires Tab not opened");
    }
    public void checkBasicPropertiesInLoadWires() {
        Object projectCountInLoadWires = js.executeScript("return document.querySelector('#ui-accordion-accordion-panel-0 > div:nth-child(1) > select').childElementCount");
        int loadWiresProjectCountToInt = Integer.parseInt(projectCountInLoadWires.toString());
        loadWiresProjectCount = loadWiresProjectCountToInt-1;
        System.out.println("Load Wires  : "+loadWiresProjectCount);
        Assert.assertEquals(loadWiresProjectCount,projectCount,"Project count does not match in load wires");
        Object schematicTaskCountInLoadWires= js.executeScript("return document.querySelector('#ui-accordion-accordion-panel-0 > div:nth-child(3) > select').childElementCount");
        int schematicTaskCountInLoadWiresPageToInt = Integer.parseInt(schematicTaskCountInLoadWires.toString());
        schematicTaskCountInLoadWiresPage = schematicTaskCountInLoadWiresPageToInt;
        System.out.println("Schematic Project Count in Load wires task drop down :" +schematicTaskCountInLoadWiresPage);
        Assert.assertEquals(schematicTaskCountInLoadWiresPage,schematicTaskCountInProjectPage,"Schematic does not match");
    }
    public void userTriesToReadNumberOfSchematicAvailable() {
        Object schematicsCount = js.executeScript("return document.querySelector('#tableSCH > tbody').childElementCount");
        int schematicCountInProjectPageToInt = Integer.parseInt(schematicsCount.toString());
        schematicTaskCountInProjectPage = schematicCountInProjectPageToInt;
        System.out.println("Schematic Project Count :" + schematicTaskCountInProjectPage);
    }

    public void userTriesToLoadWireByRemovingWiresBy(String state) throws InterruptedException {
        Select removeExisting = new Select(driver.findElement(By.cssSelector("#ui-accordion-accordion-panel-1 > div:nth-child(1) > select")));
        Select selectSchematic = new Select(driver.findElement(By.cssSelector("#ui-accordion-accordion-panel-0 > div:nth-child(3) > select")));
        Select schematic = new Select(driver.findElement(By.cssSelector("select[name='Schematic']")));
        if (Objects.equals(state, "yes")) {
            Thread.sleep(1000);
            schematic.selectByVisibleText("test-loadwires 2");
            ///selectSchematic.selectByVisibleText("Demo_Integration-TestTask");
            removeExisting.selectByValue("true");
        } else if (Objects.equals(state, "no")) {
            selectSchematic.selectByVisibleText("test-loadwires 2");
            removeExisting.selectByValue("false");
        }
    }

    public void userSelectsSchematic(String schematicName) throws InterruptedException {
        Thread.sleep(3000);
        Select selectSchematic =  new Select(driver.findElement(By.cssSelector("select[name='Schematic']")));
        selectSchematic.selectByVisibleText(schematicName);

    }
    public void  verifyLoadWiresSummaryAndWireImportInformation() throws InterruptedException {
        Assert.assertTrue(loadWiresTab.isDisplayed(),"Load Wires tab is not opened");
        Assert.assertTrue(loadWireWireImportInformationTab.isDisplayed(),"Load Wires import information is not displayed");
        Assert.assertTrue(loadWiresSummary.isDisplayed(),"Load Wires summary information is not displayed");
        verifyWireImportInformationImportTextColour();
        customCommand.scrollIntoView(driver,closeLoadWiresSummaryReport);
        customCommand.javaScriptClick(driver,closeLoadWiresSummaryReport);
    }

    public void propertiesToUpdateLoadWires() throws InterruptedException {
        customCommand.scrollIntoView(driver,selectAllCheckBoXProperties);
        customCommand.javaScriptClick(driver,selectAllCheckBoXProperties);
    }
    public void submitLoadWires() throws InterruptedException {
        Thread.sleep(2000);
        customCommand.scrollIntoView(driver,submitLoadWires);
        customCommand.javaScriptClick(driver,submitLoadWires);
    }

    public void addWireTable() throws InterruptedException {
        System.out.println("addWireTable");
        customCommand.longWaitForElementToBeClickable(driver,harnessPage.commandLine);
        harnessPage.commandLine.clear();
        customCommand.enterText(harnessPage.commandLine,"wiretable 311.87,26.46");
        customCommand.longWaitForElementToBeClickable(driver,harnessPage.commandOK);
        customCommand.waitClick(harnessPage.commandOK);
    }

    public void wireImportInformationLoadWires() throws InterruptedException {
        Object loadWiresImportWireInformation = js.executeScript("return document.querySelector('#ui-accordion-accordion-panel-0 > table > tbody').childElementCount");
        System.out.println(loadWiresImportWireInformation);
        Assert.assertEquals(loadWiresImportWireInformation.toString(),"8","Wire import information is mismatching");
        submitLoadWires();
    }
    public void wireImportInformationLoadWiresForTagValues() throws InterruptedException {
        Object loadWiresImportWireInformation = js.executeScript("return document.querySelector('#ui-accordion-accordion-panel-0 > table > tbody').childElementCount");
        System.out.println(loadWiresImportWireInformation);
        Assert.assertEquals(loadWiresImportWireInformation.toString(),"2","Wire import information is mismatching");
        submitLoadWires();
    }
    public void checkRemoveWiresIsWorkingAsExpected(String state) throws InterruptedException {
        Thread.sleep(8000);
        customCommand.javaScriptClick(driver,refreshButton);
        System.out.println(wireTableRowSize());
     //   System.out.println(loadWiresSubmitImportHeaderInformation.getText());
        if(Objects.equals(state, "no"))
        {
            Assert.assertEquals(wireTableRowSize().toString(),"9","Load wires remove existing wire off is not working as expected");
            System.out.println(wireTableRowSize());
        } else if (Objects.equals(state, "yes")) {
            Assert.assertEquals(wireTableRowSize().toString(),"8","Load wires remove existing wire on is not working as expected");
            System.out.println(wireTableRowSize());
        }
    }

    public void userImportsSchematicToValidateHarness(String schematicName) throws InterruptedException {
        schematicsDrawingPage.verifyDrawingsListPageLoaded();
        String schematicFilePath="";
        switch (schematicName){
            case "loadwires 1":
                schematicFilePath = "src/test/resources/drawingboard/loadwires_1.srx";
                break;
            case "loadwires 2":
                schematicFilePath = "src/test/resources/drawingboard/loadwires_2.srx";
                break;
            case "mismatch" :
                schematicFilePath = "src/test/resources/drawingboard/mismatchloadwires.srx";
                break;
        }
        customCommand.longWaitForElementToBeClickable(driver,schematicsDrawingPage.importTools);
        customCommand.javaScriptClick(driver,schematicsDrawingPage.importTools);
        customCommand.moveToElementAndClick(driver,schematicsDrawingPage.importTask);
        schematicsDrawingPage.switchToFrame();
        customCommand.longWaitForElementToBeClickable(driver,schematicsDrawingPage.inputImportTaskName);
        FlowContext.schematicHarnessName = schematicName;
        schematicsDrawingPage.inputImportTaskName.sendKeys(schematicName);
        File file = new File(schematicFilePath);
        schematicsDrawingPage.inputUploadFile.sendKeys(file.getAbsolutePath());
        Thread.sleep(4000);
        customCommand.selectDropDownByValue(schematicsDrawingPage.selectImportTaskProfile,System.getProperty("profileName"));
        customCommand.selectDropDownByValue(schematicsDrawingPage.selectImportTaskLibrary,System.getProperty("componentDB"));
        customCommand.javaScriptClick(driver,schematicsDrawingPage.buttonSubmitImport);
        Thread.sleep(5000);
        customCommand.waitClick(schematicsDrawingPage.returnProject);
    }

    public void verifyWireImportInformationImportTextColour() {
        for (int i = 1; i <wireTableRowSize(); i++) {
            WebElement importOK = driver.findElement(By.cssSelector("#ui-accordion-accordion-panel-0 > table > tbody > tr:nth-child("+i+") >td"));
            System.out.println(importOK.getAttribute("class"));
            Assert.assertEquals(importOK.getAttribute("class"), "wireImp", "Wire import information IMPORT OK is not matched to the colour legends");
        }
    }

    public void checkAccordingToTheTagValuesWiresAreUpdatedOrNot() throws InterruptedException {
        System.out.println(wireTableRowSize());
        Assert.assertEquals(wireTableRowSize().toString(),"2","Wire importing through tag values are not importing as expected");
    }

    public void inputTagValues(String tagValue) throws InterruptedException {
        harnessTagsInput.click();
        harnessTagsInput.sendKeys(Keys.BACKSPACE);
        //harnessTagsInput.sendKeys(tagValue);
        customCommand.simulateKeyEnterWithValue(harnessTagsInput,tagValue);
    }
    public Integer wireTableRowSize(){
        Object wireTableRowSIze = js.executeScript("return document.querySelector('#layer_52 > g > g > foreignObject > table > tbody').childElementCount");
        return Integer.parseInt(wireTableRowSIze.toString());
    }

    public void verifyRemoveWireIsWorkingAsExpectedOrNot() throws InterruptedException {
        customCommand.javaScriptClick(driver, schematicsDrawingPage.yesButton);
        Assert.assertEquals(wireTableRowSize().toString(),"0","Remove wires is not working as expected there are some wires remain in wire table");
    }
    public void selectLoadVirtualWires(String state) throws InterruptedException {
        Thread.sleep(2000);
        Select loadVirtualWires = new Select(driver.findElement(By.xpath("//*[@id=\"ui-accordion-accordion-panel-1\"]/div[7]/select")));
        if(Objects.equals(state, "on")){
            loadVirtualWires.selectByValue("true");
        } else if (Objects.equals(state, "off")) {
            loadVirtualWires.selectByValue("false");
        }
    }

    public void checkAccordingToTheTagValuesWiresAreUpdatedOrNotInOffState() {
        Assert.assertEquals(wireTableRowSize().toString(), "0", "Virtual wires in off state is not working as expected");
    }

    public void getSchematicRevisions()
    {
        for(int i=1;i<schematicTaskCountInProjectPage;i++)
        {
            Object schematicTitle = js.executeScript("return document.querySelector('#tableSCH > tbody > tr:nth-child("+i+") > td:nth-child(2)').textContent");
            String schematicTitleString = schematicTitle.toString();
            System.out.println("schematicTitleString" +schematicTitleString);
            Object schematicPartNumber = js.executeScript("return document.querySelector('#tableSCH > tbody > tr:nth-child("+i+") > td:nth-child(8)').textContent");
            String schematicTitlePartNumberString = schematicPartNumber.toString()+"-"+schematicTitleString;
            Object schematicRevision = js.executeScript("return document.querySelector('#tableSCH > tbody > tr:nth-child("+i+") > td:nth-child(9)').textContent");
            String schematicTitlePartNumberRevisionString = schematicTitlePartNumberString+"&"+schematicRevision.toString();
            System.out.println("schematicTitlePartNumberRevisionString :" +schematicTitlePartNumberRevisionString);
            listOfSchematicTask.add(schematicTitlePartNumberRevisionString);
        }
        System.out.println("listOfSchematicTask :"  +listOfSchematicTask);
    }

    public void checkTaskAndRevisionInLoadWires() {
        List<String> schematicOptions = new ArrayList<>();
        Select schematic = new Select(driver.findElement(By.cssSelector("select[name='Schematic']")));
        Select revision = new Select(driver.findElement(By.cssSelector("#ui-accordion-accordion-panel-0 > div:nth-child(4) > select")));
        Set<String> setListOfSchematicTask = new HashSet<String>(listOfSchematicTask);
        List<String> listOfSchematicTaskSet = setListOfSchematicTask.stream().toList();
        System.out.println(setListOfSchematicTask);
        Object schematicTaskCountObject = js.executeScript("return document.querySelector('#ui-accordion-accordion-panel-0 > div:nth-child(3) > select').childElementCount");
        int schematicTaskCount = Integer.parseInt(schematicTaskCountObject.toString());
        List<WebElement> schematicOptionsWebElements = schematic.getOptions();
        for (int l =0;l<schematicOptionsWebElements.size();l++) {
            String schematicOptionGetText = schematicOptionsWebElements.get(l).getText();
            if(schematicOptionGetText != ""){
            schematicOptions.add(schematicOptionGetText);}
        }
        System.out.println("schematicOptions :" +schematicOptions);
        System.out.println(schematicTaskCount);
        System.out.println(listOfSchematicTask.size());
        for (int i=0;i<schematicOptions.size();i++)
        {
            schematic.selectByVisibleText(schematicOptions.get(i));
            List<WebElement> revisionOptionsWebElements = revision.getOptions();
            for(int j=0;j<revisionOptionsWebElements.size();j++) {
                String revisionOptionGetText = revisionOptionsWebElements.get(j).getText();
                System.out.println("schematicOptions :" +schematicOptions.get(i));
                System.out.println("revisionoptions  :" +revisionOptionGetText);
            }
        }
    }

    public void userTriesToSelectUpdateTableOnAndInputPossibleValues(String updateTable) {
        Select updateCavityTable = new Select(driver.findElement(By.xpath("//*[@id=\"ui-accordion-accordion-panel-1\"]/div[5]/select")));
        if(Objects.equals(updateTable, "on")){
            updateCavityTable.selectByValue("true");
        } else if (Objects.equals(updateTable, "off")) {
            updateCavityTable.selectByValue("false");
        }
    }

    public void checkUpdateTableInOnIsWorkingAsExpectedOrNot(String updateTable) throws InterruptedException {
        Thread.sleep(5000);
        if(Objects.equals(updateTable, "on")){
            System.out.println(wireIdOf1stConnector.getText());
            Assert.assertEquals(wireIdOf1stConnector.getText(),"WIRE005","Update table in load wires is not updating the cavity table as expected");
        } else if (Objects.equals(updateTable, "off")) {
            try{
            System.out.println(wireIdOf1stConnector.getText());
            assert false;
            }

            catch (NoSuchElementException E)
            {
                Thread.sleep(2000);
            }
        }

    }


    public void userTriesToLoadWiresVariantsByValue(String variants) {
        Select variantsSelect =new Select(driver.findElement(By.cssSelector("#ui-accordion-accordion-panel-1 > div:nth-child(7) > select")));
        if(Objects.equals(variants, "SX")){
            variantsSelect.selectByValue("SX");
        } else if (Objects.equals(variants, "EXCLUSIVE")) {
            variantsSelect.selectByValue("EXCLUSIVE");
        }
        
    }

    public void checkLoadWiresVariantsByValueSXIsUpdateAsExpectedOrNot(String variants) throws InterruptedException {
        if(Objects.equals(variants, "SX")){
        System.out.println(variantSXText.getText());
        Assert.assertEquals(variantSXText.getText(),"SX","Load wire summary variant sx is not populating  as expected");}
        else if (Objects.equals(variants, "EXCLUSIVE"))
        {System.out.println(variantExclusiveText.getText());
        Assert.assertEquals(variantExclusiveText.getText(),"EXCLUSIVE","Load wire summary variant exclusive is not populating as expected ");}
        submitLoadWires();
        customCommand.javaScriptClick(driver,closeLoadWiresSummaryReport);
        disableVariants(variants);
        checkFadeInCavityTable(variants);}

    public void disableVariants(String variant) throws InterruptedException {
        if(Objects.equals(variant, "SX"))
        {
        leftToggle.click();
        customCommand.javaScriptClick(driver,checkBoxVariantSX);
        leftToggle.click();} else if (Objects.equals(variant, "EXCLUSIVE")) {
            leftToggle.click();
            customCommand.javaScriptClick(driver,checkBoxExclusiveVariant);
            leftToggle.click();
        }
    }
    public void checkFadeInCavityTable(String variants){
        if(Objects.equals(variants,"EXCLUSIVE")) {
            System.out.println(exclusiveWireCavityTable.getAttribute("class"));
            Assert.assertEquals(exclusiveWireCavityTable.getAttribute("class"),"fade");
        } else if (Objects.equals(variants,"SX")) {
            System.out.println(wire002.getAttribute("class"));
            Assert.assertEquals(wire002.getAttribute("class"),"fade");
        }
    }

    public void userTriesToLoadWiresByTurningOnComponentDataOn(String loadComponentData) {

    }
    public void loadComponent(String loadComponentData) throws InterruptedException {
        Thread.sleep(1000);
        Select updateLoadComponentData = new Select(driver.findElement(By.cssSelector("#ui-accordion-accordion-panel-1 > div:nth-child(9) > select")));
        if(Objects.equals(loadComponentData, "on")){
            updateLoadComponentData.selectByValue("true");
        } else if (Objects.equals(loadComponentData, "off")) {
            updateLoadComponentData.selectByValue("false");
        }
    }

    public void checkLoadWiresComponentDataOnIsWorkingAsExpectedOrNot(String loadComponentData) throws InterruptedException {
        if(Objects.equals(loadComponentData, "on")){
            Assert.assertTrue(header2.isDisplayed(), "Load component data update information is not available");
            Assert.assertEquals(header2.getText(),"Component Import Information","Load component data update information is not available is not matching");
            System.out.println(header2.isDisplayed());
        } else if (Objects.equals(loadComponentData, "off")) {
            try {
                Assert.assertFalse(header2.isDisplayed(), "Load component data update information is not available where it should not be when load component data is off");
            }
            catch (NoSuchElementException E)
            {
                    assert true;
            }
        }
        customCommand.javaScriptClick(driver,submitLoadWires);
        Thread.sleep(3000);
        customCommand.javaScriptClick(driver,closeLoadWiresSummaryReport);
    }

    public void checkMismatchInformIsHighlightedInUpdateSummaryReportOrNot() throws InterruptedException {
        Assert.assertEquals(header2.getText(),"Mismatched Connector Information","Load wire mismatch information is not matching as expected");
        customCommand.javaScriptClick(driver,submitLoadWires);
        Assert.assertEquals(mismatchInformationClass.getAttribute("class"),"MismatchCav","Mismatch information colour is not matching as expected");
        customCommand.javaScriptClick(driver,closeLoadWiresSummaryReport);
    }
}
