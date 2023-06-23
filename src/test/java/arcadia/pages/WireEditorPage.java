package arcadia.pages;

import arcadia.domainobjects.WiresComponentDB;
import arcadia.pages.ComponentDB.AddNewComponentPage;
import arcadia.pages.ComponentDB.Wires.WiresComponentDBPage;
import arcadia.utils.RestAssuredUtility;
import arcadia.utils.SeleniumCustomCommand;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class WireEditorPage extends BasePage {

    @FindBy(css = "#wire-editor table.htCore")
    private WebElement tableWireEditor;
    @FindBy(xpath = "//div[@id='wire-editor']//label[contains(text(),'Component DB')]//following-sibling::select")
    private WebElement selectComponentDBWireEditor;
    @FindBy(css = "select[class='form-control input-sm']")
    private WebElement selectizeComponentDB;
    @FindBy(xpath = "//th//span[text()=\"Wire ID\"]")
    private WebElement headingWireID;
    @FindBy(xpath = "//th//span[text()=\"From Con\"]")
    private WebElement headingFromCon;
    @FindBy(xpath = "//th//span[text()=\"From Cav\"]")
    private WebElement headingFromCav;
    @FindBy(xpath = "//th//span[text()=\"To Con\"]")
    private WebElement headingToCon;
    @FindBy(xpath = "//th//span[text()=\"To Cav\"]")
    private WebElement headingToCav;
    @FindBy(xpath = "//a[contains(text(),'Go to Drawing')]")
    private WebElement buttonGoToDrawing;
    @FindBy(xpath = "//button[normalize-space()='OK']")
    private WebElement wireEditorOKButton;
    @FindBy(xpath = "//button[text() = 'Save']")
    private WebElement saveButton;
    @FindBy(css = ".btnExportCSV.btn.btn-info.btn-sm")
    private WebElement exportToCSV;
    @FindBy(css = ".btn.btn-warning.btn-sm[href='templates/wire_editor_import_format_grp.csv']")
    private WebElement downloadTemplate;

    @FindBy(xpath="//button[normalize-space()='Update Wire PN']")private WebElement updateWirePN;
    public WireEditorPage(WebDriver driver) {
        super(driver);
    }

    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    RestAssuredUtility rs = new RestAssuredUtility();
    String database = System.getProperty("componentDB");
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public static List<String> headerlist = new ArrayList<>();
    List<String> listOfHeaders = new ArrayList<>();
    public static List<String> savedlist = new ArrayList<>();
    public List<String> componentbpartnumber = new ArrayList<>();
    public List<String> componentDBColour = new ArrayList<>();
    public List<String> partnumberlist = new ArrayList<>();
    public List<String> editorColourdata = new ArrayList<>();


    public void verifyWireEditorOpened() {
        customCommand.waitForElementVisibility(driver, tableWireEditor);
        customCommand.waitForElementToBeClickable(driver, tableWireEditor);
        Assert.assertTrue(tableWireEditor.isDisplayed(), "Wire editor is not opened");
    }

    public void getHeaders() throws InterruptedException {
        headerlist.clear();
        WebElement mainTable = driver.findElement(By.cssSelector(".ht_master.handsontable table.htCore"));
        List<String> columnsToFillList = Arrays.asList("From Con Desc", "Part Number", " To Con Group ID","Tertiary Color", "From Func", "Gauge", "To Func", "CSA", "From Cav Display", "Ident Tag", "Outer Dia", "From Con", "To Con", " To Con Desc", "Primary Color", " Secondary Color", "Wire ID", "Material", "Twist Pitch", "Component DB", "From Cav", "Variant", " To Cav", " To Cav Display", " MC ID"," From Con Group ID"," Signal Name", " Core ID", " Wire Class", " Harness Tag");
        WebElement headerRow = mainTable.findElement(By.cssSelector("thead tr"));
        for (int i = 0; i < columnsToFillList.size(); i++) {
            for (int index = 2; index < headerRow.findElements(By.tagName("th")).size(); index++) {
                WebElement tableColumnElement = driver.findElement(By.cssSelector(".ht_master.handsontable table.htCore thead tr th:nth-child(" + index + ") .colHeader"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                String tableColumnName = js.executeScript("return document.querySelector('.ht_master.handsontable table.htCore thead tr th:nth-child(" + index + ") .colHeader').textContent;").toString();
                String texts = null;
                if (columnsToFillList.get(i).equals(tableColumnName)) {
                    String text = js.executeScript("return document.querySelector('.ht_master.handsontable table.htCore tbody tr:nth-child(1) td:nth-child(" + index + ")').textContent;").toString();
                    if (text.contains("▼")) {
                        texts = text.replace("▼", "");
                    } else {
                        texts = text;
                    }
                    savedlist.add(texts);
                }
                headerlist.add(tableColumnName);
                Set<String> componentcolour = new HashSet<>(headerlist);
                (headerlist).clear();
                (headerlist).addAll(componentcolour);

            }
        }
        System.out.println("headerlist");
        System.out.println(headerlist);

    }
    public void checkHeaders()
    {
        List<String> columnsToFillList = Arrays.asList("From Con Desc", "Part Number", "To Con Group ID","Tertiary Color", "From Func", "Gauge", "To Func", "CSA", "From Cav Display", "Ident Tag", "Outer Dia", "From Con", "To Con", "To Con Desc", "Primary Color", "Secondary Color", "Wire ID", "Material", "Twist Pitch", "Component DB", "From Cav", "Variant", "To Cav", "To Cav Display", "From Con Group ID","MC ID","Signal Name", "Core ID", "Wire Class", "Harness Tag");
        System.out.println(headerlist);
        System.out.println(columnsToFillList);
        Assert.assertEquals(headerlist, columnsToFillList, "Wire editor table headers are not in expected");
    }
    public void checkHeadersAfterHidingColumns()
    {
        List<String> columnsToFillList = Arrays.asList("Part Number","Tertiary Color","Gauge","CSA","From Cav Display","Ident Tag","Outer Dia","From Con","To Con","To Con Desc","Secondary Color","Wire ID","Material","Twist Pitch","Component DB","From Cav","Variant","To Cav","To Cav Display","From Con Group ID","MC ID","Core ID","Wire Class","Harness Tag");
        Assert.assertEquals(headerlist, columnsToFillList, "Wire editor table headers are not in expected");
    }

    public void checkComponentDBNameInWireEditor() {
        Select select = new Select(selectizeComponentDB);
        WebElement selectedOption = select.getFirstSelectedOption();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(selectedOption.getText());
        Assert.assertEquals(selectedOption.getText(), System.getProperty("componentDB"), "ComponentDB are not matching with harness created in selectize near export CSV");
    }

    public String getTaskID() {
        String url1 = driver.getCurrentUrl();
        String taskID = url1;
        taskID = taskID.substring(taskID.indexOf("R") + 1);
        taskID = taskID.substring(0, taskID.indexOf("&"));
        System.out.println(taskID);
        return taskID;
    }

    public List<String> getWireAPIData(String jsonValue) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonValue);
        jsonValue = jsonNode.get("data").toString();
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        objectMapper.enable(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY);
        List<String> dbData = objectMapper.readValue(jsonValue, new TypeReference<>() {
        });
        return dbData;
    }

    public void enterWireID() throws InterruptedException, AWTException {
        customCommand.scrollIntoView(driver, headingWireID);
        WebElement wireIDColumns = driver.findElement(By.xpath("//tbody/tr/td[1]"));
        for (int i = 0; i < 3 - 1; i++) {
            System.out.println(i);
            customCommand.moveToElementAndDoubleClick(driver, wireIDColumns);
            customCommand.enterText(driver.findElement(By.xpath("//textarea")), "AUTO");
            Thread.sleep(1000);
            customCommand.simulateKeyEnter();
            Thread.sleep(2000);
            customCommand.enterText(driver.findElement(By.xpath("//textarea")), "");
            customCommand.pressKey(driver, "Tab");
        }
        Thread.sleep(5000);
    }

    public void checkMaterialGaugeValueFromWireEditorPage() throws InterruptedException, AWTException, JsonProcessingException {
        String materialConurl = "?app=projects2&appoption=73&ajax=true&query=materials&wtype=Wire&taskID=HAR" + getTaskID() + "&library=" + database + "";
        String materialResponse = rs.getwireEditorResponse(driver, materialConurl);
        List<String> materialDBdata = getWireAPIData(materialResponse);
        Collections.sort(materialDBdata);
        System.out.println(materialDBdata);
        String gaugeConurl = "?app=projects2&appoption=73&ajax=true&query=gauges&wtype=Wire&library=" + database + "&material=";
        String gaugeResponse = rs.getwireEditorResponse(driver, gaugeConurl);
        List<String> gaugeDBdata = getWireAPIData(gaugeResponse);
        Collections.sort(gaugeDBdata);
        System.out.println(gaugeDBdata);
        String response = rs.getComponentDbResponse("wire", driver);
        List<WiresComponentDB> dbData = new WiresComponentDBPage(driver).getWireAPIData(response);
        List<String> materialList = dbData.stream().map(x -> x.getWirematerial()).collect(Collectors.toList());
        Set<String> expectedMaterial = new HashSet<>(materialList);
        materialList.clear();
        materialList.addAll(expectedMaterial);
        List<String> expectedMaterialList = new ArrayList<>(expectedMaterial);
        Collections.sort(expectedMaterialList);
        System.out.println(expectedMaterialList);
        List<String> gaugeList = dbData.stream().map(x -> x.getGauge()).collect(Collectors.toList());
        Set<String> expectedGauge = new HashSet<>(gaugeList);
        gaugeList.clear();
        gaugeList.addAll(expectedGauge);
        List<String> expectedGaugeList = new ArrayList<>(expectedGauge);
        Collections.sort(expectedGaugeList);
        System.out.println(expectedGaugeList);
        Assert.assertEquals(materialDBdata, expectedMaterialList, "Material is not same as componentDB");
        Assert.assertEquals(gaugeDBdata, expectedGaugeList, "Gauge is not same as component DB");
        Thread.sleep(2000);
    }

    public void goToDrawingFromWireEditorInHarness() throws InterruptedException {
        Thread.sleep(3000);
        customCommand.waitForElementToBeClickable(driver, buttonGoToDrawing);
        buttonGoToDrawing.click();
        customCommand.waitForElementToBeClickable(driver, wireEditorOKButton);
        wireEditorOKButton.click();
        Thread.sleep(3000);
    }


    public void checkTheValuesAreSuggestingAsPerFromToConnectorAndFromToCavity() throws InterruptedException, JsonProcessingException, ParseException {
        List<String> expectedCavity = Arrays.asList("1", "2", "3", "4");
        String fromConurl = "?app=projects2&appoption=73&ajax=true&query=connectors&taskID=HAR" + getTaskID() + "&fromToCon=toRefCode";
        String fromConResponse = rs.getwireEditorResponse(driver, fromConurl);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(fromConResponse);
        System.out.println(json.get("data"));
        String fromcondata = json.get("data").toString().replaceAll("[(){}/,-]", "").replaceAll("\"", "").replaceAll("\\[", "").replaceAll("\\]", "");
        Assert.assertEquals(fromcondata, "X001X002X002:X001:");
        String fromCavurl = "?app=projects2&appoption=73&ajax=true&query=cavities&taskID=HAR" + getTaskID() + "&conid=X-001";
        String fromCavResponse = rs.getwireEditorResponse(driver, fromCavurl);
        List<String> fromCavdata = getWireAPIData(fromCavResponse);
        System.out.println(fromCavdata);
        Assert.assertEquals(fromCavdata, expectedCavity);
        String toConurl = "?app=projects2&appoption=73&ajax=true&query=connectors&taskID=HAR" + getTaskID() + "&fromToCon=toRefCode";
        String toConResponse = rs.getwireEditorResponse(driver, toConurl);
        JSONObject toConJson = (JSONObject) parser.parse(toConResponse);
        String toCondata = toConJson.get("data").toString().replaceAll("[(){}/,-]", "").replaceAll("\"", "").replaceAll("\\[", "").replaceAll("\\]", "");
        Assert.assertEquals(toCondata, "X001X002X002:X001:");
        String toCavurl = "?app=projects2&appoption=73&ajax=true&query=cavities&taskID=HAR" + getTaskID() + "&conid=X-002";
        String toCavResponse = rs.getwireEditorResponse(driver, toCavurl);
        List<String> toCavdata = getWireAPIData(toCavResponse);
        Assert.assertEquals(toCavdata, expectedCavity);
        System.out.println(toCavdata);
    }

    public void saveWireEditorChanges() throws InterruptedException {
        customCommand.waitForElementToBeClickable(driver, saveButton);
        customCommand.javaScriptClick(driver, saveButton);
        new AddNewComponentPage(driver).verifyAlertMessage("Wires imported successfully.");
        Thread.sleep(5000);
        new AddNewComponentPage(driver).closeAlertPopUp();
        Thread.sleep(2000);
    }

    public void enterFromCon() throws InterruptedException, AWTException {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector("#wire-editor table.htCore tbody tr"));
        WebElement row = connectorEditorTableRows.get(0);
        List<WebElement> tdElements = row.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        customCommand.doubleClick(driver, tdElements.get(2));
        List<WebElement> testclick = driver.findElements(By.cssSelector("div[class='handsontableEditor autocompleteEditor listbox handsontable'] div[class='ht_master handsontable'] table[class='htCore'] tbody tr"));
        WebElement data = testclick.get(0);
        WebElement tdElements1 = data.findElement(By.cssSelector("td"));
        System.out.println(tdElements1.getText());
        tdElements1.click();
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(3));
        new Actions(driver).sendKeys("1").perform();
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(8));
        new Actions(driver).sendKeys("X-002").perform();
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(9));
        new Actions(driver).sendKeys("1").perform();
        customCommand.doubleClick(driver, tdElements.get(21));
        new Actions(driver).sendKeys("WIRE_GN_16.0_FLRY").perform();
        customCommand.pressKey(driver, "Tab");
    }

    public void checkAllTheWireEditorColumnValuesAreCorrectlyPopulatingOrNotAfterSavingDetails() throws AWTException {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector("#wire-editor table.htCore tbody tr"));
        WebElement row = connectorEditorTableRows.get(0);
        List<WebElement> tdElements = row.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        customCommand.doubleClick(driver, tdElements.get(2));
        Assert.assertEquals(tdElements.get(2).getText().replace("▼", "").trim(), "X-001", "Value is not saved as expected");
        customCommand.doubleClick(driver, tdElements.get(3));
        Assert.assertEquals(tdElements.get(3).getText().replace("▼", "").trim(), "1", "Value is not saved as expected");
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(8));
        Assert.assertEquals(tdElements.get(8).getText().replace("▼", "").trim(), "X-002", "Value is not saved as expected");
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(9));
        Assert.assertEquals(tdElements.get(9).getText().replace("▼", "").trim(), "1", "Value is not saved as expected");
        customCommand.doubleClick(driver, tdElements.get(21));
        Assert.assertEquals(tdElements.get(21).getText().replace("▼", "").trim(), "WIRE_GN_16.0_FLRY", "Value is not saved as expected");
        customCommand.pressKey(driver, "Tab");
    }

    public void checkThePartNumberInWireEditorMatchesComponentDbOrNot() {
        Object nodeCount = js.executeScript("return (document.querySelector(\"div[class='handsontableEditor autocompleteEditor handsontable listbox'] div[class='ht_master handsontable'] table[class='htCore'] tbody\").childElementCount)");
        int size = Integer.parseInt(nodeCount.toString());
        System.out.println(size);
        for (int i = 1; i <= size; i++) {
            WebElement partNumber = driver.findElement(By.cssSelector("div[class='handsontableEditor autocompleteEditor handsontable listbox'] div[class='ht_master handsontable'] table[class='htCore'] tbody tr:nth-child(" + i + ")"));
            String partnumber = partNumber.getText();
            partnumberlist.add(partnumber);
        }
        Collections.sort(partnumberlist);
        Assert.assertEquals(componentbpartnumber, partnumberlist, "Part numbers are not suggesting as per filter");
    }

    public void selectMaterialGaugeAndGetValuesOfPartnumber() throws AWTException, InterruptedException {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector("#wire-editor table.htCore tbody tr"));
        WebElement row = connectorEditorTableRows.get(0);
        List<WebElement> tdElements = row.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        customCommand.doubleClick(driver, tdElements.get(2));
        List<WebElement> testclick = driver.findElements(By.cssSelector("div[class='handsontableEditor autocompleteEditor listbox handsontable'] div[class='ht_master handsontable'] table[class='htCore'] tbody tr"));
        WebElement data = testclick.get(0);
        WebElement tdElements1 = data.findElement(By.cssSelector("td"));
        System.out.println(tdElements1.getText());
        tdElements1.click();
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(3));
        new Actions(driver).sendKeys("1").perform();
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(8));
        new Actions(driver).sendKeys("X-002").perform();
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(9));
        new Actions(driver).sendKeys("1").perform();
        customCommand.doubleClick(driver, tdElements.get(14));
        new Actions(driver).sendKeys("TXL").perform();
        customCommand.doubleClick(driver, tdElements.get(15));
        new Actions(driver).sendKeys("8").perform();
        customCommand.pressKey(driver, "Tab");
        customCommand.doubleClick(driver, tdElements.get(21));
        Thread.sleep(5000);
    }

    public void getPartNumberValueFromComponentdb() throws AWTException, JsonProcessingException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs = new RestAssuredUtility();
        String response = rs.getComponentDbResponse("wire", driver);
        List<WiresComponentDB> dbData = new WiresComponentDBPage(driver).getWireAPIData(response);
        List<WiresComponentDB> filteredDbData = new ArrayList<>();
        List<WiresComponentDB> filteredDbData1 = new ArrayList<>();
        filteredDbData = dbData.stream().filter(x -> x.getGauge().equals("8")).collect(Collectors.toList());
        filteredDbData1 = filteredDbData.stream().filter(x -> x.getWirematerial().equals("TXL")).collect(Collectors.toList());
        for (int i = 0; i < filteredDbData1.size(); i++) {
            componentbpartnumber.add(filteredDbData1.get(i).getPartnumber());
        }
    }

    public void selectMaterialGaugeAndGetValuesOfColourCode() throws JsonProcessingException {
        editorColourdata.clear();
        String colourURL = "index.lp?app=projects2&appoption=73&ajax=true&query=colours&colour=&colour2=&colour3=&library=quickstart&material=TXL&gauge=8&colourIndex=0&partnumber=&taskID=HAR" + getTaskID() + "&wtype=Wire";
        String colourResponse = rs.getwireEditorResponse(driver, colourURL);
        List<String> colourDB = getWireAPIData(colourResponse);
        for (int i = 0; i < colourDB.size(); i++) {
            String colour = switch (colourDB.get(i)) {
                case "BK" -> "BLACK";
                case "BL" -> "BLUE";
                case "BR" -> "BROWN";
                case "XX" -> "DEFAULT";
                case "GY" -> "GRAY";
                case "GN" -> "GREEN";
                case "OR" -> "ORANGE";
                case "PK" -> "PINK";
                case "VT" -> "PURPLE";
                case "RD" -> "RED";
                case "TQ" -> "TURQUOISE";
                case "WH" -> "WHITE";
                case "YE" -> "YELLOW";
                case "TAN" -> "TAN";
                case "none" -> "";
                default -> colourDB.get(i);
            };
            editorColourdata.add(colour);

        }
        System.out.println("editorColourdata");
        System.out.println(editorColourdata);
    }

    public void getMaterialGaugeColorValueFromComponentdb() throws JsonProcessingException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs = new RestAssuredUtility();
        String response = rs.getComponentDbResponse("wire", driver);
        List<WiresComponentDB> dbData = new WiresComponentDBPage(driver).getWireAPIData(response);
        List<WiresComponentDB> filteredDbData = new ArrayList<>();
        List<WiresComponentDB> filteredDbData1 = new ArrayList<>();
        filteredDbData = dbData.stream().filter(x -> x.getGauge().equals("8")).collect(Collectors.toList());
        filteredDbData1 = filteredDbData.stream().filter(x -> x.getWirematerial().equals("TXL")).collect(Collectors.toList());
        String[] colour1;
        for (int j = 0; j < filteredDbData1.size(); j++) {
            if (filteredDbData1.get(j).getColour().contains("-")) {
                colour1 = filteredDbData1.get(j).getColour().split("-");
                componentDBColour.add(colour1[0]);

            } else {
                componentDBColour.add(filteredDbData1.get(j).getColour());
            }
        }
    }

    public void checkRedoUndoRemoveRow() throws InterruptedException {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector("#wire-editor table.htCore tbody tr"));
        WebElement row = connectorEditorTableRows.get(0);
        List<WebElement> tdElements = row.findElements(By.cssSelector("td"));
        Thread.sleep(3000);
        customCommand.doubleClick(driver, tdElements.get(2));
        customCommand.rightClick(driver,tdElements.get(2));
        new Actions(driver).sendKeys("8").perform();
        Thread.sleep(3000);
        WebElement removeRow = driver.findElement(By.xpath("//div[normalize-space()='Remove row']"));
        removeRow.click();
        System.out.println(tdElements.get(2).getText());
        Assert.assertEquals(tdElements.get(2).getText().trim(),"▼");
        customCommand.rightClick(driver,tdElements.get(2));
        WebElement undo = driver.findElement(By.xpath("//div[normalize-space()='Undo']"));
        undo.click();
        Thread.sleep(3000);
        System.out.println(tdElements.get(2).getText().replace(" ","").trim());
       // Assert.assertEquals(tdElements.get(2).getText().replace(" ","").trim(),"▼X-001");
        customCommand.rightClick(driver,tdElements.get(2));
        WebElement redo = driver.findElement(By.xpath("//div[normalize-space()='Redo']"));
        redo.click();
        Thread.sleep(3000);
        System.out.println(tdElements.get(2).getText());
        Assert.assertEquals(tdElements.get(2).getText().trim(),"▼");
    }
    public void clickDownloadTemplateButtonInEditor() throws InterruptedException {
        customCommand.waitClick(downloadTemplate);
    }

    public String verifyFileIsDownloaded(String file_name) throws InterruptedException {
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

    public void clickExportToCsvInWireEditor() throws InterruptedException {
        customCommand.waitClick(exportToCSV);
        Thread.sleep(5000);
    }

    public void enterConIDCav() throws AWTException {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector("#wire-editor table.htCore tbody tr"));
        WebElement row = connectorEditorTableRows.get(0);
        List<WebElement> tdElements = row.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        customCommand.doubleClick(driver, tdElements.get(2));
        List<WebElement> testclick = driver.findElements(By.cssSelector("div[class='handsontableEditor autocompleteEditor listbox handsontable'] div[class='ht_master handsontable'] table[class='htCore'] tbody tr"));
        WebElement data = testclick.get(0);
        WebElement tdElements1 = data.findElement(By.cssSelector("td"));
        System.out.println(tdElements1.getText());
        tdElements1.click();
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(3));
        new Actions(driver).sendKeys("1").perform();
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(8));
        new Actions(driver).sendKeys("X-002").perform();
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(9));
        new Actions(driver).sendKeys("1").perform();
        customCommand.doubleClick(driver, tdElements.get(14));
    }
    public void clickUpdatePartNO() throws InterruptedException {
        customCommand.waitClick(updateWirePN);
        Thread.sleep(5000);
    }


    public void checkWhetherTheValueAreSavedCorrectlyOrNotByUpdatingPartNumber() throws AWTException {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector("#wire-editor table.htCore tbody tr"));
        WebElement row = connectorEditorTableRows.get(0);
        List<WebElement> tdElements = row.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        customCommand.doubleClick(driver, tdElements.get(16));
        Assert.assertTrue(!Objects.equals(tdElements.get(16).getText(), ""));
    }

    public void importingCSVByAddingSomeValuesToTheCSVInWireEditor() throws InterruptedException {
        WebElement upload_csv = driver.findElement(By.name("fileImportCSV"));
        upload_csv.sendKeys(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"+ File.separator + "resources" +File.separator +"testData" +File.separator + "wireEditorImport.csv");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(5000);
        WebElement okbutton = driver.findElement(By.cssSelector("button[class='btn btn-primary']"));
        okbutton.click();
    }


    public void enterWireClass() throws AWTException {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector("#wire-editor table.htCore tbody tr"));
        WebElement row = connectorEditorTableRows.get(0);
        List<WebElement> tdElements = row.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        customCommand.doubleClick(driver, tdElements.get(2));
        List<WebElement> testclick = driver.findElements(By.cssSelector("div[class='handsontableEditor autocompleteEditor listbox handsontable'] div[class='ht_master handsontable'] table[class='htCore'] tbody tr"));
        WebElement data = testclick.get(0);
        WebElement tdElements1 = data.findElement(By.cssSelector("td"));
        System.out.println(tdElements1.getText());
        tdElements1.click();
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(3));
        new Actions(driver).sendKeys("1").perform();
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(8));
        new Actions(driver).sendKeys("X-002").perform();
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(9));
        new Actions(driver).sendKeys("1").perform();
        customCommand.doubleClick(driver, tdElements.get(20));
        new Actions(driver).sendKeys("").perform();
        customCommand.doubleClick(driver, tdElements.get(20));
        new Actions(driver).sendKeys("MCore").perform();
    }

    public void validateCoreIDMCIDAlertMessage() throws InterruptedException {
        customCommand.waitForElementToBeClickable(driver, saveButton);
        customCommand.javaScriptClick(driver, saveButton);
        new AddNewComponentPage(driver).verifyAlertMessage("Please enter highlighted field: [Part Number]");
        Thread.sleep(5000);
        new AddNewComponentPage(driver).closeAlertPopUp();
        Thread.sleep(2000);
    }


    public void enterCoreIDMultiID() throws AWTException, InterruptedException {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector("#wire-editor table.htCore tbody tr"));
        WebElement row = connectorEditorTableRows.get(0);
        List<WebElement> tdElements = row.findElements(By.cssSelector("td"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        customCommand.doubleClick(driver, tdElements.get(2));
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(22));
        new Actions(driver).sendKeys("AC123").perform();
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(23));
        new Actions(driver).sendKeys("MC123").perform();
        customCommand.simulateKeyEnter();
        customCommand.doubleClick(driver, tdElements.get(21));
        new Actions(driver).sendKeys("").perform();
        Thread.sleep(3000);
    }

    public void hideSomeHeadersInTheWireEditor() throws InterruptedException {
        WebElement toggleButton = driver.findElement(By.cssSelector("body div[class='wrapper'] div[class='form-group'] div[class='form-group'] div:nth-child(1) div:nth-child(1) button:nth-child(1)"));
        customCommand.waitClick(toggleButton);
        for (int i=2;i<20;i++){
            WebElement toggle = driver.findElement(By.cssSelector("#wire-editor > div > div > div.box-body.no-padding > div.box-toolbar.grid-editor__toolbar > div > div:nth-child(1) > div:nth-child(1) > div > ul > li:nth-child("+i+") > label > input[type=checkbox]"));
            js.executeScript("arguments[0].click();", toggle);
            Thread.sleep(1000);
            i=i+2;
        }
        customCommand.waitClick(toggleButton);
    }


    public void checkAfterSavingValuesAreCorrectlyPopulatedOrNot() {

    }

    public void enterAllPossibleValuesInTheWireEditor() throws AWTException, InterruptedException {
        List<WebElement> connectorEditorTableRows = driver.findElements(By.cssSelector("#wire-editor table.htCore tbody tr"));
        WebElement row = connectorEditorTableRows.get(0);
        List<WebElement> tdElements = row.findElements(By.cssSelector("td"));
       Thread.sleep(2000);
        customCommand.doubleClick(driver, tdElements.get(2));
        new Actions(driver).sendKeys("X-001").perform();
        Thread.sleep(3000);
        customCommand.doubleClick(driver, tdElements.get(3));
        new Actions(driver).sendKeys("1").perform();
        customCommand.simulateKeyEnter();
        Thread.sleep(1000);
        customCommand.doubleClick(driver, tdElements.get(4));
        new Actions(driver).sendKeys("Automation Test From Con Desc").perform();
        customCommand.simulateKeyEnter();
        Thread.sleep(1000);
        customCommand.doubleClick(driver, tdElements.get(5));
        new Actions(driver).sendKeys("A").perform();
        customCommand.simulateKeyEnter();
        Thread.sleep(1000);
        customCommand.doubleClick(driver, tdElements.get(6));
        new Actions(driver).sendKeys("Automation Test From Con Group ID").perform();
        customCommand.simulateKeyEnter();
        Thread.sleep(1000);
        customCommand.doubleClick(driver, tdElements.get(7));
        new Actions(driver).sendKeys("Automation Test From Func").perform();
        customCommand.simulateKeyEnter();
        Thread.sleep(1000);
        customCommand.doubleClick(driver, tdElements.get(8));
        new Actions(driver).sendKeys("X-002").perform();
        customCommand.simulateKeyEnter();
        Thread.sleep(1000);
        customCommand.doubleClick(driver, tdElements.get(9));
        new Actions(driver).sendKeys("1").perform();
        customCommand.simulateKeyEnter();
        Thread.sleep(1000);
        customCommand.doubleClick(driver, tdElements.get(10));
        new Actions(driver).sendKeys("B").perform();
        customCommand.simulateKeyEnter();
        Thread.sleep(1000);
        customCommand.doubleClick(driver, tdElements.get(11));
        new Actions(driver).sendKeys("Automation Test To Con Desc").perform();
        customCommand.simulateKeyEnter();
        Thread.sleep(1000);
        customCommand.doubleClick(driver, tdElements.get(12));
        new Actions(driver).sendKeys("Automation Test To Cav Display").perform();
        Thread.sleep(1000);
        customCommand.simulateKeyEnter();
        Thread.sleep(1000);
        customCommand.doubleClick(driver, tdElements.get(13));
        new Actions(driver).sendKeys("Automation Test To Function").perform();
        customCommand.simulateKeyEnter();
        Thread.sleep(1000);
        customCommand.doubleClick(driver, tdElements.get(14));
        new Actions(driver).sendKeys("TXL").perform();
        customCommand.simulateKeyEnter();
        Thread.sleep(1000);
        customCommand.doubleClick(driver, tdElements.get(15));
        new Actions(driver).sendKeys("8").perform();
        customCommand.simulateKeyEnter();
        Thread.sleep(1000);
        customCommand.pressKey(driver, "Tab");
        clickUpdatePartNO();
    }
}

















