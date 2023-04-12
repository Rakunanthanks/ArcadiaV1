package arcadia.pages;

import arcadia.domainobjects.SplicesComponentDB;
import arcadia.pages.ComponentDB.Splices.SplicesComponentDBPage;
import arcadia.utils.RestAssuredUtility;
import arcadia.utils.SeleniumCustomCommand;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SpliceEditorPage extends BasePage {
    @FindBy(css = "#cEditor table.htCore") private WebElement tableSpliceEditor;
    @FindBy(css = ".btn.btn-primary.btn-sm") private WebElement gotoDrawing;
    @FindBy(css = "button[class='btn btn-primary']") private WebElement okayButton;
    @FindBy(css = "#btnClearWire") private WebElement clearallValues;
    @FindBy(css = ".bootbox-body") private WebElement clearValueMessage;
    @FindBy(css = ".btn.btn-warning.btn-sm[href='templates/splice_editor_import_format_variants.csv']") private WebElement downloadTemplate;
    @FindBy(xpath = "//div[normalize-space()='Remove row']") private WebElement removeRow;
    @FindBy(xpath = "//div[normalize-space()='Undo']") private WebElement undo;
    @FindBy(xpath = "//div[normalize-space()='Redo']") private WebElement redo;
    @FindBy(css = "#idselectform > div.box-body.no-padding > div:nth-child(1) > div.box-body > div:nth-child(2) > span > label > span.switch-label")private WebElement conIDlabel;
    @FindBy(css = "#idselectform > div.box-body.no-padding > div:nth-child(1) > div.box-body > div:nth-child(16) > span > label > span.switch-label") private WebElement partnumberDescription;
    @FindBy(css = "#idselectform > div.box-body.no-padding > div:nth-child(1) > div.box-body > div:nth-child(4) > span > label > span.switch-label") private WebElement conIgroupID;
    @FindBy(css = "#idselectform > div.box-body.no-padding > div:nth-child(1) > div.box-body > div:nth-child(2) > span > label > span.switch-handle")
    private WebElement turnonConID;
    @FindBy(css = "#idselectform > div.box-body.no-padding > div:nth-child(1) > div.box-body > div:nth-child(4) > span > label > span.switch-handle")
    private WebElement turnonShortName;
    @FindBy(css = "#idselectform > div.box-body.no-padding > div:nth-child(1) > div.box-body > div:nth-child(16) > span > label > span.switch-handle")
    private WebElement turnonPnDescription;
    @FindBy(css = "button[value='Save']") private WebElement saveButton;
    @FindBy(css = "#btnSaveWire") private WebElement saveSplice;
    @FindBy(css = ".btnExportCSV.btn.btn-info.btn-sm") private WebElement exportToCSV;

    String spliceEditorRows = "#cEditor table.htCore tbody tr";
    String spliceEditorHeaders = "#cEditor > div.ht_clone_top.handsontable tr";
    String partNumberDescription = null;;
    String actualSpliceID = null;
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    RestAssuredUtility rs = new RestAssuredUtility();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    List<String> listOfHeaders = new ArrayList<>();
    public SpliceEditorPage(WebDriver driver) {
        super(driver);
    }
    public void verifySpliceEditorOpened(){
        customCommand.waitForElementVisibility(driver,tableSpliceEditor);
        customCommand.waitForElementToBeClickable(driver,tableSpliceEditor);
        Assert.assertTrue(tableSpliceEditor.isDisplayed(),"Splice editor is not opened");
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

    public void checkDefaultHeadersName() {
        List<String> expectedHeaders = new ArrayList<>(Arrays.asList("Splice ID", "Short Name","Functional Description", "Component DB", "Splice PN", "PN Description", "Cavities", "Link Node", "Variants"));
        Assert.assertEquals(listOfHeaders, expectedHeaders, "Default Headers are not as expected");
    }
    public void gotoDrawing() {
        gotoDrawing.click();
        try {
            okayButton.click();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }
    public String getTaskID() {
        String url1 = driver.getCurrentUrl();
        String taskID = url1;
        taskID = taskID.substring(taskID.indexOf("R") + 1);
        taskID = taskID.substring(0, taskID.indexOf("&"));
        System.out.println(taskID);
        return taskID;
    }
    public String getSpliceID() {
        //To get Connector ID from the ajax call
        String conurl = "?app=projects2&appoption=59&project=37&ajax=true&taskID=HAR" + getTaskID() + "&type=splice";
        String response = rs.getEditorResponse(driver, conurl);
        System.out.println("SPLICE ID");
        System.out.println(response);
        return response.trim();
    }


    public void getSpliceIDFromEditorPageFromSpliceIDDropDown() {
        actualSpliceID = getSpliceID();
    }

    public void checkSpliceIDPopulatedOrNotCorrectly() {
        Assert.assertEquals(actualSpliceID, "[\"SP-001\"]");
    }

    public void clearAllValue() throws InterruptedException {
        clearallValues.click();
        Thread.sleep(3000);
        System.out.println(clearValueMessage.getText());
        Assert.assertEquals(clearValueMessage.getText(), "Do you want to clear all splice details?", "Clear value message is not in expected");
        okayButton.click();
    }

    public void checkInEditorWhetherAllValuesAreDisappearedOrNot() {
        List<WebElement> spliceEditorTableRows = driver.findElements(By.cssSelector(spliceEditorRows));
        WebElement row = spliceEditorTableRows.get(0);
        List<WebElement> tdElements = row.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        customCommand.doubleClick(driver, tdElements.get(0));
        Assert.assertEquals(tdElements.get(0).getText(), "▼", "Clear Value is not working as Expected");
    }

    public void clickDownloadTemplateButtonInEditor() throws InterruptedException {
        customCommand.waitClick(downloadTemplate);
    }

    public String checkAbleToDownloadOrNot(String file_name) throws InterruptedException {
        Thread.sleep(5000);
        String path = System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles";
        String file_with_location = path + File.separator + file_name;
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
    public void rightClickValidation() {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(spliceEditorRows));
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

    public void checkEditorDetailThatRemoveRowHasBeenPerformedOrNot() {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(spliceEditorRows));
        WebElement row = connectorEditorTableRows.get(0);
        List<WebElement> tdElements = row.findElements(By.cssSelector("td"));
        tdElements.get(0).click();
        String expected = tdElements.get(0).getText().replaceAll("\\s+", "");
        Assert.assertEquals(expected, "▼");
    }

    public void performUndoOperation() {
        rightClickValidation();undo.click();
    }

    public void checkEditorDetailThatUndoHasBeenPerformedOrNot() {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(spliceEditorRows));
        WebElement row = connectorEditorTableRows.get(0);
        List<WebElement> tdElements = row.findElements(By.cssSelector("td"));
        tdElements.get(0).click();
        String expected = tdElements.get(0).getText().replaceAll("\\s+", "");
        Assert.assertEquals(expected, "▼SP-001");
    }

    public void performRedoOperation() {
        rightClickValidation();redo.click();
    }

    public void checkEditorDetailThatRedoOperationHasBeenPerformedOrNot() {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(spliceEditorRows));
        WebElement row = connectorEditorTableRows.get(0);
        List<WebElement> tdElements = row.findElements(By.cssSelector("td"));
        tdElements.get(0).click();
        String expected = tdElements.get(0).getText().replaceAll("\\s+", "");
        Assert.assertEquals(expected, "");
    }

    public void spliceEditorColumnCustomizaton() {
        try {
            conIDlabel.click();
            Thread.sleep(3000);
            partnumberDescription.click();
            conIgroupID.click();
            Thread.sleep(5000);
            saveButton.click();
        } catch (ElementClickInterceptedException | InterruptedException e) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

    }

    public void checkEditorHeadersByTurningOfVisibility() {
        List<String> expectedHeaders = new ArrayList<>(Arrays.asList("Functional Description", "Component DB","Splice PN","PN Description", "Cavities", "Link Node"));
        getHeaders();
        Assert.assertEquals(listOfHeaders, expectedHeaders, "Headers are not in expected after hiding headers");
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



    public void enterPossibleValuesInTheSpliceEditor(String spliceID, String compDB, String partNumber,boolean option) throws InterruptedException, AWTException {

        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(spliceEditorRows));
        WebElement row3 = connectorEditorTableRows.get(1);
        List<WebElement> tdElements = row3.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(5000);
        customCommand.doubleClick(driver, tdElements.get(0));
        Thread.sleep(5000);
        js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='" + spliceID + "';");
        customCommand.doubleClick(driver, tdElements.get(0));
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(3));
        js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='" + compDB + "';");
        customCommand.doubleClick(driver, tdElements.get(4));
        js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='" + partNumber + "';");
        System.out.println(tdElements.get(4).getText());
        customCommand.doubleClick(driver, tdElements.get(5));
        tdElements.get(2).click();
        Thread.sleep(5000);
        System.out.println(tdElements.get(5).getText());
        partNumberDescription = tdElements.get(5).getText();
    }
    public void saveEditor() throws InterruptedException {
            customCommand.waitClick(saveSplice);
            Thread.sleep(3000);
            Assert.assertEquals(clearValueMessage.getText(), "Splice details imported successfully.", "There is issue in saving splice editor");
            Thread.sleep(3000);
            okayButton.click();
            Thread.sleep(3000);
    }

    public void clickExportCSVButton() throws InterruptedException {
        customCommand.waitClick(exportToCSV);
        Thread.sleep(5000);
    }

    public void checkPartDescription() {
        Assert.assertEquals(partNumberDescription,"Krimptite Butt Splice for 18-22 AWG Wire","Issue is suggesting Description");
    }

    public void checkValidationMessageBySavingForm() throws InterruptedException {
        customCommand.waitClick(saveSplice);
        Thread.sleep(3000);
        Assert.assertEquals(clearValueMessage.getText(), "Splice name SP-001 already exists", "There is issue in saving splice editor should validate splice id now it is allowing duplicate ID");
        Thread.sleep(3000);
        okayButton.click();
        Thread.sleep(3000);
    }
String spliceIDBeforeSortingRow1, spliceIDBeforeSortingRow2;
    public void getValuesOfSpliceIDFromEditorBeforeSorting() {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(spliceEditorRows));
        WebElement row1 = connectorEditorTableRows.get(0);
        List<WebElement> tdElements1 = row1.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("Before Sorting");
        System.out.println(tdElements1.get(0).getText());
        spliceIDBeforeSortingRow1 = tdElements1.get(0).getText();
        WebElement row2 = connectorEditorTableRows.get(1);
        List<WebElement> tdElements2 = row2.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println(tdElements2.get(0).getText());
        spliceIDBeforeSortingRow2 = tdElements2.get(0).getText();
    }

    public void sortSpliceIDColumnInDescendingOrder() throws InterruptedException {
        List<WebElement> connectorEditorTableHeaders = driver.findElements(By.cssSelector(spliceEditorHeaders));
        WebElement row = connectorEditorTableHeaders.get(0);
        List<WebElement> tdElements = row.findElements(By.cssSelector("th >div span"));
        tdElements.get(1).click();
        Thread.sleep(2000);
        tdElements.get(1).click();
    }

    public void checkTheValueOfSpliceIDAfterSorted() {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(spliceEditorRows));
        WebElement row1 = connectorEditorTableRows.get(0);
        List<WebElement> tdElements1 = row1.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("After Sorting");
        System.out.println(tdElements1.get(0).getText());
        WebElement row2 = connectorEditorTableRows.get(1);
        List<WebElement> tdElements2 = row2.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println(tdElements2.get(0).getText());
        Assert.assertEquals(spliceIDBeforeSortingRow2,tdElements1.get(0).getText(),"There is issue in sorting of columns");
        Assert.assertEquals(spliceIDBeforeSortingRow1,tdElements2.get(0).getText(),"There is issue in sorting of columns");
    }

    public void getValuesOfSplicePartNumberFromEditorBeforeSorting() {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(spliceEditorRows));
        WebElement row1 = connectorEditorTableRows.get(0);
        List<WebElement> tdElements1 = row1.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("Before Sorting Part Number");
        System.out.println(tdElements1.get(4).getText());
        spliceIDBeforeSortingRow1 = tdElements1.get(4).getText();
        WebElement row2 = connectorEditorTableRows.get(1);
        List<WebElement> tdElements2 = row2.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println(tdElements2.get(4).getText());
        spliceIDBeforeSortingRow2 = tdElements2.get(4).getText();
    }

    public void sortPartNumberColumnInDescendingOrder() throws InterruptedException {
        List<WebElement> connectorEditorTableHeaders = driver.findElements(By.cssSelector(spliceEditorHeaders));
        WebElement row = connectorEditorTableHeaders.get(0);
        List<WebElement> tdElements = row.findElements(By.cssSelector("th >div span"));
        tdElements.get(5).click();
        Thread.sleep(2000);
        tdElements.get(5).click();
    }

    public void checkTheValueOfSplicePartNumberAfterSorted() {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(spliceEditorRows));
        WebElement row1 = connectorEditorTableRows.get(0);
        List<WebElement> tdElements1 = row1.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("After Sorting Part Number");
        System.out.println(tdElements1.get(4).getText());
        WebElement row2 = connectorEditorTableRows.get(1);
        List<WebElement> tdElements2 = row2.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println(tdElements2.get(4).getText());
        Assert.assertEquals(spliceIDBeforeSortingRow2,tdElements1.get(4).getText(),"There is issue in sorting of columns");
        Assert.assertEquals(spliceIDBeforeSortingRow1,tdElements2.get(4).getText(),"There is issue in sorting of columns");

    }

    public void enterPartNumber() throws InterruptedException {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(spliceEditorRows));
        WebElement row3 = connectorEditorTableRows.get(0);
        List<WebElement> tdElements = row3.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(5000);
        customCommand.doubleClick(driver, tdElements.get(4));
        js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='BSV18X';");
        Thread.sleep(5000);
    }

    public void selectingSpliceIDComponentDB() throws InterruptedException, AWTException {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(spliceEditorRows));
        WebElement row3 = connectorEditorTableRows.get(1);
        List<WebElement> tdElements = row3.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(5000);
        customCommand.doubleClick(driver, tdElements.get(0));
        Thread.sleep(5000);
        js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='SP-003';");
        customCommand.doubleClick(driver, tdElements.get(0));
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(3));
        js.executeScript("document.querySelector('#cEditor > div:nth-child(6) > textarea').value='quickstart';");
        customCommand.doubleClick(driver, tdElements.get(4));
    }
    String database = System.getProperty("componentDB");
    public List<String> getcomponentDBPartnumbers(String component) throws JsonProcessingException, JsonProcessingException {
        String response = rs.getComponentDbResponse(component, driver);
        List<SplicesComponentDB> dbData = new SplicesComponentDBPage(driver).getSpliceAPIData(response);
        List<String> expectedPartNumberList = dbData.stream().map(x -> x.getPartnumber()).collect(Collectors.toList());
        Collections.sort(expectedPartNumberList);
        return expectedPartNumberList;

    }
    public List<String> getPartnumbers(String component) throws JsonProcessingException {
        //TO get response splice part number
        String url = "?app=projects2&appoption=59&project=37&ajax=true&taskID=HAR" + getTaskID() + "&type=partnumber&pnonly=true&library="+database;
        String response = rs.getEditorResponse(driver, url);
        ObjectMapper mapper = new ObjectMapper();
        List<String> partNumbersList = new ArrayList<>();
        partNumbersList = Arrays.asList(mapper.readValue(response, String[].class));
        Collections.sort(partNumbersList);
        return partNumbersList;
    }

    public void checkAllSplicePartnumberListedOrNot() throws JsonProcessingException {
        List<String> componentDBPartnumbersList = getcomponentDBPartnumbers("splice");
        List<String> editorPartNumbers = getPartnumbers("splice");
        Assert.assertEquals(componentDBPartnumbersList, editorPartNumbers, "Splice Part number is not matching as expected");
    }

    public void importingCSVByAddingSomeValuesToTheCSV() {
        WebElement upload_csv = driver.findElement(By.name("fileImportCSV"));
        upload_csv.sendKeys(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"+ File.separator + "resources" +File.separator +"testData" +File.separator + "spliceEditorImport.csv");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement okbutton = driver.findElement(By.cssSelector("button[class='btn btn-primary']"));
        okbutton.click();
    }
    public void checkWhetherAbleToSaveOrNotWithoutAnyErrors() throws InterruptedException {
        customCommand.waitClick(saveSplice);
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        Thread.sleep(5000);
        Assert.assertEquals(clearValueMessage.getText(), "Splice details imported successfully.", "There is issue in saving splice editor");
        customCommand.waitClick(okayButton);
    }

    public void checkCheckAllValuesAreUpdatedInEditorsAsExpectedOrNot() {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector(spliceEditorRows));
        WebElement row3 = connectorEditorTableRows.get(1);
        List<WebElement> tdElements = row3.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String componentDB = tdElements.get(3).getText().replaceAll("\\s+", "");
        customCommand.doubleClick(driver,tdElements.get(4));
        String partNumber = tdElements.get(4).getText().replaceAll("\\s+", "");
        String conID = tdElements.get(0).getText().replaceAll("\\s+", "");
        System.out.println(componentDB+partNumber+conID);
        Assert.assertEquals(componentDB,"▼quickstart");
        Assert.assertEquals(partNumber,"▼19164-0043");
        Assert.assertEquals(tdElements.get(5).getText(),"SPLICE_STEP_BUTT_PERMA SEAL_0.35-2mm2");
        Assert.assertEquals(conID,"▼SP-002");
    }
}

