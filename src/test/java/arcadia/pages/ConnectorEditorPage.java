package arcadia.pages;
import arcadia.domainobjects.ConnectorDB;
import arcadia.pages.ComponentDB.Connectors.ConnectorsDBPage;
import arcadia.utils.RestAssuredUtility;
import arcadia.utils.SeleniumCustomCommand;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


public class ConnectorEditorPage extends BasePage {

    @FindBy(css = "#cEditor table.htCore")
    private WebElement tableConnectorEditor;
    @FindBy(css = ".btn.btn-primary.btn-sm")
    private WebElement gotoDrawing;
    @FindBy(css = "#btnClearWire")
    private WebElement clearallValues;
    @FindBy(css = "button[class='btn btn-primary']")
    private WebElement okayButton;
    @FindBy(css = ".bootbox-body")
    private WebElement clearValueMessage;
    @FindBy(css = "button[value='Save']")
    private WebElement saveButton;
    @FindBy(xpath = "//div[normalize-space()='Remove row']")
    private WebElement removeRow;
    @FindBy(xpath = "//div[normalize-space()='Undo']")
    private WebElement undo;
    @FindBy(xpath = "//div[normalize-space()='Redo']")
    private WebElement redo;
    @FindBy(css = "#idselectform > div.box-body.no-padding > div:nth-child(1) > div.box-body > div:nth-child(2) > span > label > span.switch-handle")
    private WebElement turnonConID;
    @FindBy(css = "#idselectform > div.box-body.no-padding > div:nth-child(1) > div.box-body > div:nth-child(4) > span > label > span.switch-handle")
    private WebElement turnonShortName;
    @FindBy(css = "#idselectform > div.box-body.no-padding > div:nth-child(1) > div.box-body > div:nth-child(16) > span > label > span.switch-handle")
    private WebElement turnonPnDescription;
    @FindBy(css = "#idselectform > div.box-body.no-padding > div:nth-child(1) > div.box-body > div:nth-child(2) > span > label > span.switch-label")
    private WebElement conIDlabel;
    @FindBy(css = "#idselectform > div.box-body.no-padding > div:nth-child(1) > div.box-body > div:nth-child(16) > span > label > span.switch-label")
    private WebElement partnumberDescription;
    @FindBy(css = "#idselectform > div.box-body.no-padding > div:nth-child(1) > div.box-body > div:nth-child(4) > span > label > span.switch-label")
    private WebElement conIgroupID;
    @FindBy(css = ".btn.btn-warning.btn-sm[href='templates/connector_editor_import_format_variants.csv']")
    private WebElement downloadTemplate;
    @FindBy(css = ".btnExportCSV.btn.btn-info.btn-sm")
    private WebElement exportToCSV;
    @FindBy(css = "#btnSaveWire")
    private WebElement saveConnectors;
    String connectorEditorRows = "#cEditor table.htCore tbody tr";
    String connectorEditorHeaders = "#cEditor > div.ht_clone_top.handsontable tr";

    RestAssuredUtility rs = new RestAssuredUtility();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    String database = System.getProperty("componentDB");
    String projectID = System.getProperty("projectID");
    String actualConnectorID = null;
    String pnDescription;
    String cavities;
    String conID;
    String conPN;
    String partType;
    List<String> listOfHeaders = new ArrayList<>();
    String conIDBeforeSortingRow1,conIDBeforeSortingRow2;

    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();

    public ConnectorEditorPage(WebDriver driver) {
        super(driver);
    }

    public void verifyConnectorEditorOpened() {
        customCommand.waitForElementVisibility(driver, tableConnectorEditor);
        customCommand.waitForElementToBeClickable(driver, tableConnectorEditor);
        Assert.assertTrue(tableConnectorEditor.isDisplayed(), "Connector editor is not opened");
    }

    public void getHeaders() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object count = js.executeScript("return document.querySelector('#cEditor > div.ht_clone_top.handsontable tr').childElementCount");
        int count1 = Integer.parseInt(count.toString());

        for (int i = 1; i <= count1; i++) {
            WebElement childnode = driver.findElement(By.cssSelector("#cEditor  >div:nth-child(2) >div >div >div >table >thead >tr >th:nth-child(" + i + ")"));
            System.out.println(childnode.getText());
            listOfHeaders.add(childnode.getText());
        }
        System.out.println("Headers");
        listOfHeaders.remove(0);
        System.out.println(listOfHeaders);
    }
    public String getTaskID() {
        String url1 = driver.getCurrentUrl();
        String taskID = url1;
        taskID = taskID.substring(taskID.indexOf("R") + 1);
        taskID = taskID.substring(0, taskID.indexOf("&"));
        System.out.println(taskID);
        return taskID;
    }

    public void enterconnectorIDCompParttype(String conID, String compDB, String partType) throws InterruptedException, AWTException {
        System.out.println(partType);
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(connectorEditorRows));
        WebElement row3 = connectorEditorTableRows.get(2);
        List<WebElement> tdElements = row3.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(5000);
        customCommand.doubleClick(driver, tdElements.get(0));
        Thread.sleep(5000);
        js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='" + conID + "';");
        customCommand.tabKey();
        customCommand.doubleClick(driver, tdElements.get(4));
        js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='" + compDB + "';");
        System.out.println(tdElements.get(4).getText());
        customCommand.tabKey();
        customCommand.doubleClick(driver, tdElements.get(5));
        js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='" + partType + "';");
        System.out.println(tdElements.get(5).getText());
        customCommand.doubleClick(driver, tdElements.get(6));
    }

    public void enterConnectorDetails(String conID, String compDB, String partType, String partNumber, String description) throws InterruptedException, AWTException, JsonProcessingException {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(connectorEditorRows));
        WebElement row3 = connectorEditorTableRows.get(2);
        List<WebElement> tdElements = row3.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(5000);
        customCommand.doubleClick(driver, tdElements.get(0));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(5000);
        js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='" + conID + "';");
        customCommand.tabKey();
        System.out.println(tdElements.get(0).getText());
        Thread.sleep(3000);
        customCommand.doubleClick(driver, tdElements.get(6));
        List<String> componentDBPartnumbersList = getcomponentDBPartnumbers("connector");
//        getDetailsConnectorEditorDetails();
//        getConnnectorID();
//        getPartnumbers();
        List<String> editorpartNumbers = getPartnumbers("connector");
        System.out.println("componentDBPartnumbersList");
        System.out.println(componentDBPartnumbersList);
        System.out.println("editorpartNumbers");
        System.out.println(editorpartNumbers);
        Assert.assertEquals(componentDBPartnumbersList, editorpartNumbers, "Part number is not matching as expected");
    }

    public void getDetailsConnectorEditorDetails() {
        String fulldetailsurl = "?app=projects2&appoption=58&project="+projectID+"&ajax=true&taskID=HAR" + getTaskID() + "&type=partnumber&filter=FFH04142BK*T&rowIndex=4&library=" + database + "&ctype=connector";
        System.out.println(fulldetailsurl);
        String fulldetailsresponse = rs.getEditorResponse(driver, fulldetailsurl);
        System.out.println("FULLDETAILS");
        System.out.println(fulldetailsresponse);
    }

    public String getConnnectorID() {
        //To get Connector ID from the ajax call

        String conurl = "?app=projects2&appoption=58&project="+projectID+"&ajax=true&taskID=HAR" + getTaskID() + "&type=connector";
        String response = rs.getEditorResponse(driver, conurl);
        System.out.println("CONID");
        System.out.println(response);
        return response.trim();
    }

    public List<String> getPartnumbers(String component) throws JsonProcessingException {
        //TO get response connector part number
        String url = "?app=projects2&appoption=58&project="+projectID+"&ajax=true&taskID=HAR" + getTaskID() + "&type=partnumber&pnonly=true&library=" + database + "&ctype=" + component + "&cavity=";
        String response = rs.getEditorResponse(driver, url);
        System.out.println("PARTNUMBER");
        ObjectMapper mapper = new ObjectMapper();
        List<String> partNumbersList = new ArrayList<>();
        partNumbersList = Arrays.asList(mapper.readValue(response, String[].class));
        Collections.sort(partNumbersList);
        return partNumbersList;
    }

    public List<String> getcomponentDBPartnumbers(String component) throws JsonProcessingException {
        String response = rs.getComponentDbResponse(component, driver);
        List<ConnectorDB> dbData = new ConnectorsDBPage(driver).getConnectorsAPIData(response);
        List<String> expectedPartNumberList = dbData.stream().map(x -> x.getPartnumber()).collect(Collectors.toList());
        Collections.sort(expectedPartNumberList);
        return expectedPartNumberList;
    }

    private List<String> getComponentDB() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object count = js.executeScript("return document.querySelector('#cEditor > div.handsontableInputHolder > div > div.ht_master.handsontable > div > div > div > table > tbody').childElementCount");
        int count1 = Integer.parseInt(count.toString());
        List<String> listOfString = new ArrayList<>();
        for (int i = 1; i <= count1; i++) {
            WebElement childnode = driver.findElement(By.cssSelector("#cEditor > div.handsontableInputHolder > div > div.ht_master.handsontable > div > div > div > table > tbody tr:nth-child(" + i + ")"));
            listOfString.add(childnode.getText());
        }
        System.out.println("Component DB");
        System.out.println(listOfString);
        return listOfString;
    }

    public void gotoDrawing() {
        gotoDrawing.click();
        try {
            okayButton.click();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
    }

    public void turningOnConnectorIDGroup(String options) throws InterruptedException {
        int value = 0;
        if (Objects.equals(options, "on")) {
            value = 1;
        }
        WebElement selectElement = driver.findElement(By.name("Connector ID Group"));
        Select select = new Select(selectElement);
        select.selectByValue(String.valueOf(value));
        saveButton.click();
        Thread.sleep(4000);
        WebElement pagination = driver.findElement(By.xpath("//button[@type='button']"));
        pagination.click();
        WebElement selectall = driver.findElement(By.xpath("//a[normalize-space()='All']"));
        selectall.click();
        driver.findElement(By.xpath("(//input[@id='chbox'])[1]")).click();
        saveButton.click();
    }

    public void rightClickValidation() {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(connectorEditorRows));
        WebElement row3 = connectorEditorTableRows.get(0);
        List<WebElement> tdElements = row3.findElements(By.cssSelector("td"));
        tdElements.get(0).click();
        customCommand.rightClick(driver, tdElements.get(0));
        System.out.println(tdElements.get(0).getText());
        tdElements.get(0).click();
        customCommand.rightClick(driver, tdElements.get(0));
    }

    public void removeRow() {
        rightClickValidation();
        removeRow.click();
    }

    public void checkRemoverow() {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(connectorEditorRows));
        WebElement row3 = connectorEditorTableRows.get(0);
        List<WebElement> tdElements = row3.findElements(By.cssSelector("td"));
        tdElements.get(0).click();
        String expected = tdElements.get(0).getText().replaceAll("\\s+", "");
        Assert.assertEquals(expected, "▼X-002");
    }

    public void undo() {
        rightClickValidation();undo.click();
    }

    public void checkUndo() {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(connectorEditorRows));
        WebElement row3 = connectorEditorTableRows.get(0);
        List<WebElement> tdElements = row3.findElements(By.cssSelector("td"));
        tdElements.get(0).click();
        String expected = tdElements.get(0).getText().replaceAll("\\s+", "");
        Assert.assertEquals(expected, "▼X-001");
    }

    public void redo() {
        rightClickValidation();redo.click();
    }

    public void checkRedo() {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(connectorEditorRows));
        WebElement row3 = connectorEditorTableRows.get(0);
        List<WebElement> tdElements = row3.findElements(By.cssSelector("td"));
        tdElements.get(0).click();
        String expected = tdElements.get(0).getText().replaceAll("\\s+", "");
        Assert.assertEquals(expected, "▼X-002");
    }

    public void connectorEditorColumnCustomizaton() throws InterruptedException {
        try {
            conIDlabel.click();
            Thread.sleep(3000);
            partnumberDescription.click();
            conIgroupID.click();
            Thread.sleep(5000);
            saveButton.click();
        } catch (ElementClickInterceptedException e) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    public void checkEditorHeadersByTurningOfVisibility() {
        List<String> expectedHeaders = new ArrayList<>(Arrays.asList("Con Group ID", "Functional Description", "Component DB", "Part Type", "Con PN", "Cavities", "Link Node", "Variants"));
        getHeaders();
        Assert.assertEquals(listOfHeaders, expectedHeaders, "Headers are not in expected after hiding headers");
    }

    public void clearAllValue() throws InterruptedException {
        clearallValues.click();
        Thread.sleep(3000);
        System.out.println(clearValueMessage.getText());
        Assert.assertEquals(clearValueMessage.getText(), "Do you want to clear all connector details?", "Clear value message is not in expected");
        okayButton.click();
    }

    public void checkInEditorWhetherAllValuesAreDisappearedOrNot() {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(connectorEditorRows));
        WebElement row3 = connectorEditorTableRows.get(2);
        List<WebElement> tdElements = row3.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        customCommand.doubleClick(driver, tdElements.get(0));
        Assert.assertEquals(tdElements.get(0).getText(), "▼", "Clear Value is not working as Expected");
    }

    public void turningOnAllConnectorEditorHeadersVisibility() {
        try {
            turnonConID.click();
            turnonPnDescription.click();
            turnonShortName.click();
            saveButton.click();
        } catch (ElementClickInterceptedException e) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    public void checkDefaultHeadersName() {
        List<String> expectedHeaders = new ArrayList<>(Arrays.asList("Con ID", "Short Name", "Con Group ID", "Functional Description", "Component DB", "Part Type", "Con PN", "PN Description", "Cavities", "Link Node", "Variants"));
        Assert.assertEquals(listOfHeaders, expectedHeaders, "Default Headers are not as expected");
    }

    public void checkAllConnectorPartnumberListedOrNot() throws JsonProcessingException {
        System.out.println("Connector Part Numbers");
        List<String> componentDBPartnumbersList = getcomponentDBPartnumbers("connector");
        List<String> editorPartNumbers = getPartnumbers("connector");
        Assert.assertEquals(componentDBPartnumbersList, editorPartNumbers, "Connector Part number is not matching as expected");
    }

    public void checkAllTerminalPartnumberListedOrNot() throws JsonProcessingException {
        System.out.println("Terminal Part Numbers");
        List<String> componentDBPartnumbersList = getcomponentDBPartnumbers("terminal");
        List<String> editorPartNumbers = getPartnumbers("terminal");
        Assert.assertEquals(componentDBPartnumbersList, editorPartNumbers, "Terminal Part number is not matching as expected");
    }

    public void getConnectorIDFromEditorPageFromConIDDropDown() {
        actualConnectorID = getConnnectorID();
    }

    public void checkConnectorIDPopulatedOrNotCorrectly() {
        Assert.assertEquals(actualConnectorID, "[\"X-001\",\"X-002\"]");
    }

    public void getParttypeFromEditorFromPartTypeDropdown() throws InterruptedException, AWTException {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(connectorEditorRows));
        WebElement row3 = connectorEditorTableRows.get(2);
        List<WebElement> tdElements = row3.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(5000);
        customCommand.doubleClick(driver, tdElements.get(0));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(5000);
        js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='X-003';");
        customCommand.tabKey();
        customCommand.doubleClick(driver, tdElements.get(4));
        js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='quickstart';");
        System.out.println(tdElements.get(4).getText());
        customCommand.tabKey();
        customCommand.doubleClick(driver, tdElements.get(5));
    }

    public void checkParttypeIsPopulatingCorrectlyOrNot() {
        WebElement text = driver.findElement(By.cssSelector("div[class='handsontableEditor autocompleteEditor listbox handsontable'] div[class='ht_master handsontable'] div[class='wtHolder']"));
        String parttype = text.getText();
        parttype = parttype.replaceAll("\\s+", "");
        System.out.println(parttype);
        Assert.assertEquals(parttype, "connectorterminal");
    }

    public void clickDownloadTemplateButtonInEditor() throws InterruptedException {
        customCommand.waitClick(downloadTemplate);
    }

    public String checkAbleToDownloadOrNot(String file_name) throws InterruptedException {
        String path = System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles";
        String file_with_location = path + File.separator + file_name;
        Thread.sleep(3000);
        File file = new File(file_with_location);
        if (file.exists()) {
            System.out.println(file_with_location + " is present");
            String result = "File Present";
            assert true;
            return result;
        } else {
            System.out.println(file_with_location + " is not present");
            String result = "File not Present";
            String result1 = result;
            assert false;
            return result1;
        }
    }

    public void clickExportCSVButton() throws InterruptedException {
        customCommand.waitClick(exportToCSV);
        Thread.sleep(5000);
    }

    public void enterPossibleValuesInTheConnectorEditor(String conID, String compDB, String partType, String conPN) throws InterruptedException, AWTException {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(connectorEditorRows));
        WebElement row3 = connectorEditorTableRows.get(2);
        List<WebElement> tdElements = row3.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(5000);
        customCommand.doubleClick(driver, tdElements.get(0));
        Thread.sleep(5000);
        js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='" + conID + "';");
        customCommand.doubleClick(driver, tdElements.get(0));
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(4));
        js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='" + compDB + "';");
        System.out.println(tdElements.get(4).getText());
        customCommand.tabKey();
        customCommand.doubleClick(driver, tdElements.get(5));
        js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='" + partType + "';");
        System.out.println(tdElements.get(5).getText());
        customCommand.doubleClick(driver, tdElements.get(6));
        customCommand.tabKey();
        customCommand.tabKey();
        customCommand.tabKey();
        js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='" + conPN + "';");
        customCommand.waitClick(saveConnectors);
        Thread.sleep(3000);
        Assert.assertEquals(clearValueMessage.getText(), "Connector details imported successfully.", "There is issue in saving connector editor");
        Thread.sleep(3000);
        okayButton.click();
        Thread.sleep(3000);
    }
    public void enterValuesInTheConnectorEditor(String conID, String compDB, String partType, String conPN) throws InterruptedException, AWTException {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(connectorEditorRows));
        WebElement row3 = connectorEditorTableRows.get(2);
        List<WebElement> tdElements = row3.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(5000);
        customCommand.doubleClick(driver, tdElements.get(0));
        Thread.sleep(5000);
        js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='" + conID + "';");
        customCommand.doubleClick(driver, tdElements.get(0));
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(4));
        js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='" + compDB + "';");
        System.out.println(tdElements.get(4).getText());
        customCommand.tabKey();
        customCommand.doubleClick(driver, tdElements.get(5));
        js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='" + partType + "';");
        System.out.println(tdElements.get(5).getText());
        customCommand.tabKey();
        customCommand.doubleClick(driver, tdElements.get(6));
        js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='" + conPN + "';");
        customCommand.tabKey();
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(4));
        Thread.sleep(5000);
         pnDescription = tdElements.get(7).getText();
         cavities = tdElements.get(8).getText();
    }

    public void checkPartDescriptionAndCavities() {
        Assert.assertEquals(pnDescription,"FCI_FIN LOCK_4-WAY_RECEP HSG","Part number description is not matched");
        Assert.assertEquals(cavities,"1,2,3,4");
    }

    public void checkAllEnteredPossibleValuesAreSavedOrNot()  {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(connectorEditorRows));
        WebElement row3 = connectorEditorTableRows.get(2);
        List<WebElement> tdElements = row3.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String componentDB = tdElements.get(4).getText().replaceAll("\\s+", "");
        String partType = tdElements.get(5).getText().replaceAll("\\s+", "");
        customCommand.doubleClick(driver,tdElements.get(6));
        String partNumber = tdElements.get(6).getText().replaceAll("\\s+", "");
        String conID = tdElements.get(0).getText().replaceAll("\\s+", "");
        System.out.println(componentDB+partType+partNumber+conID);
        Assert.assertEquals(componentDB,"▼quickstart");
        Assert.assertEquals(partType,"▼connector");
        Assert.assertEquals(partNumber,"▼FFH04142BK*T");
        Assert.assertEquals(tdElements.get(7).getText(),"FCI_FIN LOCK_4-WAY_RECEP HSG");
        Assert.assertEquals(tdElements.get(8).getText(),"1-4");
        Assert.assertEquals(conID,"▼X-003");
    }
    public void enterDuplicateConnectorID(String conID) throws InterruptedException, AWTException {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(connectorEditorRows));
        WebElement row3 = connectorEditorTableRows.get(2);
        List<WebElement> tdElements = row3.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(5000);
        customCommand.doubleClick(driver, tdElements.get(0));
        Thread.sleep(5000);
        js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='" + conID + "';");
        customCommand.doubleClick(driver, tdElements.get(0));
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(4));
    }

    public void checkValidationMessageBySavingForm() throws InterruptedException {
        customCommand.waitClick(saveConnectors);
        Thread.sleep(3000);
        Assert.assertEquals(clearValueMessage.getText(), "Connector name X-002 already exists", "Connector Editor is allowing duplicate connector ID to save");
        Thread.sleep(3000);
        okayButton.click();
        Thread.sleep(3000);
    }
    public void getValuesOfConnectorIDFromEditorBeforeSorting() {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(connectorEditorRows));
        WebElement row1 = connectorEditorTableRows.get(0);
        List<WebElement> tdElements1 = row1.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("Before Sorting");
        System.out.println(tdElements1.get(0).getText());
        conIDBeforeSortingRow1 = tdElements1.get(0).getText();
        WebElement row2 = connectorEditorTableRows.get(1);
        List<WebElement> tdElements2 = row2.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println(tdElements2.get(0).getText());
        conIDBeforeSortingRow2 = tdElements2.get(0).getText();
    }

    public void sortConnectorIDColumn() throws InterruptedException {
        List<WebElement> connectorEditorTableHeaders = driver.findElements(By.cssSelector(connectorEditorHeaders));
        WebElement row = connectorEditorTableHeaders.get(0);
        List<WebElement> tdElements = row.findElements(By.cssSelector("th >div span"));
        tdElements.get(1).click();
        Thread.sleep(2000);
        tdElements.get(1).click();
    }

    public void checkTheValueOfConnectorIDAfterSorted() {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(connectorEditorRows));
        WebElement row1 = connectorEditorTableRows.get(0);
        List<WebElement> tdElements1 = row1.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("After Sorting");
        System.out.println(tdElements1.get(0).getText());
        WebElement row2 = connectorEditorTableRows.get(1);
        List<WebElement> tdElements2 = row2.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println(tdElements2.get(0).getText());
        Assert.assertEquals(conIDBeforeSortingRow2,tdElements1.get(0).getText(),"There is issue in sorting of columns");
        Assert.assertEquals(conIDBeforeSortingRow1,tdElements2.get(0).getText(),"There is issue in sorting of columns");
    }

    public void checkTheValueOfPartNumberAfterSorted() {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(connectorEditorRows));
        WebElement row1 = connectorEditorTableRows.get(0);
        List<WebElement> tdElements1 = row1.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("After Sorting Part Number");
        System.out.println(tdElements1.get(6).getText());
        WebElement row2 = connectorEditorTableRows.get(1);
        List<WebElement> tdElements2 = row2.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println(tdElements2.get(6).getText());
        Assert.assertEquals(conIDBeforeSortingRow2,tdElements1.get(6).getText(),"There is issue in sorting of columns");
        Assert.assertEquals(conIDBeforeSortingRow1,tdElements2.get(6).getText(),"There is issue in sorting of columns");
    }


    public void getValuesOfPArtNumberFromEditorBeforeSorting() {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(connectorEditorRows));
        WebElement row1 = connectorEditorTableRows.get(0);
        List<WebElement> tdElements1 = row1.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("Before Sorting Part Number");
        System.out.println(tdElements1.get(6).getText());
        conIDBeforeSortingRow1 = tdElements1.get(6).getText();
        WebElement row2 = connectorEditorTableRows.get(1);
        List<WebElement> tdElements2 = row2.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println(tdElements2.get(6).getText());
        conIDBeforeSortingRow2 = tdElements2.get(6).getText();
    }

    public void sortPartNumberColumn() throws InterruptedException {
        List<WebElement> connectorEditorTableHeaders = driver.findElements(By.cssSelector(connectorEditorHeaders));
        WebElement row = connectorEditorTableHeaders.get(0);
        List<WebElement> tdElements = row.findElements(By.cssSelector("th >div span"));
        tdElements.get(7).click();
        Thread.sleep(2000);
        tdElements.get(7).click();
    }

    public void enterConnectorIDComponentDBCavitiesInEditor(String conID, String cavity) throws InterruptedException, AWTException {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(connectorEditorRows));
        WebElement row3 = connectorEditorTableRows.get(2);
        List<WebElement> tdElements = row3.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(5000);
        customCommand.doubleClick(driver, tdElements.get(0));
        Thread.sleep(5000);
        js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='" + conID + "';");
        customCommand.doubleClick(driver, tdElements.get(0));
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(8));
        Thread.sleep(5000);
        js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='" + cavity + "';");
        customCommand.doubleClick(driver, tdElements.get(6));
    }

    public List<String> getConnectorPartnumberResponseFromEditor(String component,String cavity) throws JsonProcessingException {
        String url = "?app=projects2&appoption=58&project="+projectID+"&ajax=true&taskID=HAR" + getTaskID() + "&type=partnumber&pnonly=true&library=" + database + "&ctype=" + component + "&cavity="+cavity+"";
        String response = rs.getEditorResponse(driver, url);
        System.out.println("PARTNUMBER");
        ObjectMapper mapper = new ObjectMapper();
        List<String> partNumbersList = new ArrayList<>();
        partNumbersList = Arrays.asList(mapper.readValue(response, String[].class));
        Collections.sort(partNumbersList);
        System.out.println(partNumbersList);
        return partNumbersList;
    }


    public List<String> getPartnumberFromComponentDB() throws JsonProcessingException {
        String response = rs.getComponentDbResponse("connector", driver);
        List<ConnectorDB> dbData = new ConnectorsDBPage(driver).getConnectorsAPIData(response);
        List<ConnectorDB> filteredDbData = new ArrayList<>();
        filteredDbData = dbData.stream().filter(x -> x.getNoofcavity().equals(4)).collect(Collectors.toList());
        List<String> expectedPartNumberList = filteredDbData.stream().map(x -> x.getPartnumber()).collect(Collectors.toList());
        Collections.sort(expectedPartNumberList);
        System.out.println(expectedPartNumberList);
        return expectedPartNumberList;
    }

    public void checkWhetherPartnumberIsSuggestingAsPerCavities() throws JsonProcessingException {
        Assert.assertEquals(getConnectorPartnumberResponseFromEditor("connector","4"),getPartnumberFromComponentDB(),"Part number is not suggesting as per the cavity number");
    }

    public void enterDuplicateConnectorIDComponentDBCavitiesInEditor() throws InterruptedException, AWTException {
            List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(connectorEditorRows));
            WebElement row3 = connectorEditorTableRows.get(2);
            List<WebElement> tdElements = row3.findElements(By.cssSelector("td"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            Thread.sleep(5000);
            customCommand.doubleClick(driver, tdElements.get(0));
            Thread.sleep(5000);
            js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='X-001';");
            customCommand.doubleClick(driver, tdElements.get(0));
            customCommand.simulateKeyEnter();
            Thread.sleep(2100);
            customCommand.doubleClick(driver, tdElements.get(2));
            js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='B';");
        Thread.sleep(2100);
            customCommand.doubleClick(driver, tdElements.get(4));
            js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='quickstart';");
        Thread.sleep(2100);
            System.out.println(tdElements.get(4).getText());
            customCommand.doubleClick(driver, tdElements.get(8));
        Thread.sleep(2100);
        try{
            js.executeScript("document.querySelector('#cEditor > div:nth-child(7) > textarea').value='3,4';");
        }
        catch (Exception e) {
            js.executeScript("document.querySelector('#cEditor > div:nth-child(8) > textarea').value='3,4';");
        }
        Thread.sleep(2100);
            WebElement row4 = connectorEditorTableRows.get(3);
            List<WebElement> tdElements1 = row4.findElements(By.cssSelector("td"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            Thread.sleep(5000);
            customCommand.doubleClick(driver, tdElements1.get(0));
            Thread.sleep(5000);
            js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='X-002';");
        Thread.sleep(2100);
            customCommand.doubleClick(driver, tdElements1.get(0));
            customCommand.simulateKeyEnter();
            Thread.sleep(2100);
            customCommand.doubleClick(driver, tdElements1.get(2));
            js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='B';");
        Thread.sleep(2100);
            customCommand.doubleClick(driver, tdElements1.get(4));
            js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='quickstart';");
            System.out.println(tdElements1.get(4).getText());
            customCommand.doubleClick(driver, tdElements1.get(8));
        Thread.sleep(2100);
        try{
            js.executeScript("document.querySelector('#cEditor > div:nth-child(7) > textarea').value='3,4';");
        }
        catch (Exception e) {
            js.executeScript("document.querySelector('#cEditor > div:nth-child(8) > textarea').value='3,4';");
        }
        Thread.sleep(2100);
            WebElement row1 = connectorEditorTableRows.get(0);
            List<WebElement> tdElements2 = row1.findElements(By.cssSelector("td"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            Thread.sleep(5000);
            Thread.sleep(2100);
            customCommand.doubleClick(driver, tdElements2.get(2));
            js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='A';");
        Thread.sleep(2100);
            customCommand.doubleClick(driver, tdElements2.get(8));
        Thread.sleep(2100);
        try{
            js.executeScript("document.querySelector('#cEditor > div:nth-child(7) > textarea').value='1,2';");
        }
        catch (Exception e) {
            js.executeScript("document.querySelector('#cEditor > div:nth-child(8) > textarea').value='1,2';");
        }
        Thread.sleep(2100);
            WebElement row2 = connectorEditorTableRows.get(1);
            List<WebElement> tdElements3 = row2.findElements(By.cssSelector("td"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            Thread.sleep(5000);
            Thread.sleep(2100);
            customCommand.doubleClick(driver, tdElements3.get(2));
            js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='A';");
        Thread.sleep(2100);
            customCommand.doubleClick(driver, tdElements3.get(8));
        Thread.sleep(2100);
        try{
            js.executeScript("document.querySelector('#cEditor > div:nth-child(7) > textarea').value='1,2';");
        }
        catch (Exception e) {
            js.executeScript("document.querySelector('#cEditor > div:nth-child(8) > textarea').value='1,2';");
        }
        Thread.sleep(2100);
            customCommand.tabKey();

    }

    public void enterGroupIDEditor() {
    }

    public void checkAbleToSaveEditorOrNot() throws InterruptedException {
        saveConnectors.click();
        Thread.sleep(3000);
        //Assert.assertEquals(clearValueMessage.getText(),"Connector details imported successfully.", "There is issue in saving connector editor");
        customCommand.waitClick(okayButton);
    }

    public void whetherNewConnectorsAreAddedOrNot() throws InterruptedException {
        Thread.sleep(5000);
        String nodeCount =String.valueOf( js.executeScript("return (document.querySelector(\"#layer_80\").childElementCount);"));
        String expectedCount ="10";
        System.out.println("Node count"+nodeCount);
        Assert.assertEquals(nodeCount,expectedCount,"There is issue in grouping connector it is not populating grouped connectors in drawing");
    }
    public void importingCSVByAddingSomeValuesToTheCSV() {
        WebElement upload_csv = driver.findElement(By.name("fileImportCSV"));
        upload_csv.sendKeys(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"+ File.separator + "resources" +File.separator +"testData" +File.separator + "connectorEditorImport.csv");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement okbutton = driver.findElement(By.cssSelector("button[class='btn btn-primary']"));
        okbutton.click();
    }

    public void checkWhetherAbleToSaveOrNotWithoutAnyErrors() throws InterruptedException {
        customCommand.waitClick(saveConnectors);
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        Thread.sleep(3000);
        Assert.assertEquals(clearValueMessage.getText(), "Connector details imported successfully.", "There is issue in saving connector editor");
        customCommand.waitClick(okayButton);
    }

    public void checkCheckAllValuesAreUpdatedInEditorsAsExpectedOrNot() {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(connectorEditorRows));
        WebElement row3 = connectorEditorTableRows.get(2);
        List<WebElement> tdElements = row3.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String componentDB = tdElements.get(4).getText().replaceAll("\\s+", "");
        String partType = tdElements.get(5).getText().replaceAll("\\s+", "");
        customCommand.doubleClick(driver,tdElements.get(6));
        String partNumber = tdElements.get(6).getText().replaceAll("\\s+", "");
        String conID = tdElements.get(0).getText().replaceAll("\\s+", "");
        System.out.println(componentDB+partType+partNumber+conID);
        Assert.assertEquals(componentDB,"▼quickstart");
        Assert.assertEquals(partType,"▼connector");
        Assert.assertEquals(partNumber,"▼12124817");
        Assert.assertEquals(tdElements.get(7).getText(),"PLUG_2WY_METRI-PACK 280_BK_SLD_FEM TERMS");
        Assert.assertEquals(tdElements.get(8).getText(),"A,B");
        Assert.assertEquals(conID,"▼X-003");
    }
}