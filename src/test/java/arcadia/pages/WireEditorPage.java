package arcadia.pages;

import arcadia.domainobjects.WiresComponentDB;
import arcadia.pages.ComponentDB.CommonElements;
import arcadia.pages.ComponentDB.Wires.WiresComponentDBPage;
import arcadia.utils.RestAssuredUtility;
import arcadia.utils.SeleniumCustomCommand;
import com.fasterxml.jackson.core.JsonProcessingException;
import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class WireEditorPage extends BasePage {
     SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    @FindBy(css = ".htCore td:nth-child(2)") private  List<WebElement> basetable;
    @FindBy(css="div[id='ribbon-tab-header-2'] span[class='ribbon-title']") private WebElement advanced;
    @FindBy(xpath = "//*[@id=\"iwireeditor\"]") private WebElement findwireeditor;
    @FindBy(css = "body > div:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(3)")private WebElement bastablesignal;
    @FindBy(css = "body > div:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(4) > div:nth-child(1)") private WebElement    basetableFromConn;
    @FindBy(css = "body > div:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(5) > div:nth-child(1)") private WebElement basetableFromCav;
    @FindBy(css = "body > div:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(7) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(1)") private WebElement getvalue1;
    @FindBy(css = "body > div:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(7) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(2) > td:nth-child(1)") private WebElement getvalue2;
    @FindBy(css = "body > div:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(7) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(3) > td:nth-child(1)") private WebElement getvalue3;
    @FindBy(css = "body > div:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(7) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(4) > td:nth-child(1)") private WebElement getvalue4;
    @FindBy(css ="body > div:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(9) > div:nth-child(1)")private WebElement basetableToConn;
    @FindBy(css ="body > div:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(10) > div:nth-child(1)")private WebElement basetableToCav;
    @FindBy(css ="body > div:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(14) > div:nth-child(1)")private WebElement basetablematerial;
    @FindBy(css = "body > div:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(15)")private WebElement basetablegauge;
    @FindBy(css = "#wire-editor > div > div > div.grid-wrapper > div.handsontable.htRowHeaders.htColumnHeaders > div.handsontableInputHolder > div > div.ht_master.handsontable > div > div > div > table > tbody")private WebElement gaugesize;
    @FindBy(css = "div[class='fixed-table-header'] input[placeholder='Gauge']")private WebElement findgauge;
    @FindBy(css="div[class='fixed-table-header'] input[placeholder='Wire Material']")private WebElement findmaterial;
    @FindBy(css = "body > div:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(16) > div:nth-child(1)")private WebElement basetablecolour;
    @FindBy(css = "body > div:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(6)")private WebElement size;
    @FindBy(css = "body > div:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(21) > div:nth-child(1)")private WebElement basetablepartnumber;
    @FindBy(css = "body > div:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(21)")private WebElement basetablepartnumbervalue;
    @FindBy(css = "body > div:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(22)")private WebElement basetablecoreid;
    @FindBy(css = "body > div:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(23)")private WebElement basetablemcid;


    @FindBy(css = "body > div:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(19)")private WebElement basetablecomponentdb;
    @FindBy(css = "body > div:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(20)")private WebElement basetablewireclass;

    @FindBy(css ="body > div:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(25)")private WebElement basetableod;
    @FindBy(css = "body > div:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(26)")private WebElement basetablecsa;
    @FindBy(css = "div[class='fixed-table-header'] input[placeholder='Part Number']")private WebElement findpartnumber;
    @FindBy(css = "button[title='Edit']")private WebElement findedit;
    @FindBy(xpath = "//a[normalize-space()='Wire']")private WebElement selectwire;
    @FindBy(css = "input[title='Enter Gauge']")private WebElement gauge;
    @FindBy(css = ".selectize-input.items.full.has-options.has-items")private WebElement materaialdb;
    @FindBy(css = "input[title='Enter CSA']")private WebElement getcsadb;
    @FindBy(css = "input[title='Enter Outside Dia']")private WebElement getoddb;
    @FindBy(css = "button:nth-child(4)")private WebElement savebuttonWire;
    @FindBy(xpath = "//a[@class='btnExportCSV btn btn-info btn-sm']")private WebElement exportcsvbuttonWire;
    @FindBy(xpath="//button[normalize-space()='Update Wire PN']")private WebElement updateWirePN;
    @FindBy(css=".bootbox-body")private WebElement getAlertMessage;
    @FindBy(css ="tbody tr:nth-child(1) td:nth-child(4)")private WebElement fromConn;
    @FindBy(css ="tbody tr:nth-child(1) td:nth-child(21)")private WebElement partNumber;
    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(13)")private WebElement material;
    @FindBy(xpath = "//div[normalize-space()='Undo']")private WebElement wireEditorUndo;
    @FindBy(xpath = "//div[normalize-space()='Redo']")private WebElement getWireEditorRedo;
    @FindBy(xpath = "//div[normalize-space()='Remove row']")private WebElement getWireEditorRemoveRow;
    @FindBy(css= "select[class='form-control input-sm']")private WebElement selectizeComponentDB;
    String  tableWireRows = "#tblwire > tbody > tr";
    public static  List<String>  partnumberlist= new ArrayList<>();
    public static List<String> materiallist= new ArrayList<>();
    public static List<String> gaugelist = new ArrayList<>();
    public static List<String> componentbpartnumber=new ArrayList<>();
    public static List<String>colourlist = new ArrayList<>();
    public static List<String>  savedlist = new ArrayList<>();
    public static List<String>  headerlist = new ArrayList<>();
    public List<String> componentdbcolour= new ArrayList<>();
    public static List<String> actrualWireEditorList= new ArrayList<>();
    public static List<String> actualHeaderList= new ArrayList<>();
    public static List<String> expectedHeaderList= new ArrayList<>();
    public static String material_value,gauge_value,colour_value,partnumber_value,wiredbgauge,wiredbmaterial,wiredbcsa,wiredbod,wireeditorod_value,wireeditorcsa_value,componentdbvalue , actualAlertMessage,expectedRedoText,actualRedoText,expectedRemoveRowText,actualRemoveRowText;
    public static StringBuilder expectedCsv = new StringBuilder();
    public static  StringBuilder actualCsv = new StringBuilder();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    public WireEditorPage(WebDriver driver) {
        super(driver);
    }

    public  void navigatedtoWireEditorPage() throws InterruptedException, AWTException {
        customCommand.waitForElementToBeClickable(driver,advanced);
        advanced.click();
        customCommand.waitForElementToBeClickable(driver,findwireeditor);
        findwireeditor.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(2)")));
        WebElement drive = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(2)"));
        customCommand.doubleClick(driver,drive);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.querySelector('textarea.handsontableInput').value ='AUTO';");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        customCommand.tabKey();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        js.executeScript("document.querySelector('textarea.handsontableInput').value ='';");

    }
    public void checkfromconntocavvalue() {
        {
            basetableFromConn.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String fromconnvalue1 = getvalue1.getText();
            String fromconnvalue2 = getvalue2.getText();
            wait.until(ExpectedConditions.visibilityOf(getvalue2));
            getvalue2.click();
            basetableFromCav.click();
            wait.until(ExpectedConditions.visibilityOf(getvalue1));
            String cav1value = getvalue1.getText();
            String cav2value = getvalue2.getText();
            String cav3value = getvalue3.getText();
            String cav4value = getvalue4.getText();
            getvalue1.click();
            basetableToConn.click();
            wait.until(ExpectedConditions.visibilityOf(getvalue1));
            String toconnvalue1 = getvalue1.getText();
            String toconnvalue2 = getvalue2.getText();
            wait.until(ExpectedConditions.visibilityOf(getvalue1));
            getvalue1.click();
            basetableToCav.click();
            wait.until(ExpectedConditions.visibilityOf(getvalue1));
            String tocav1value = getvalue1.getText();
            String tocav2value = getvalue2.getText();
            String tocav3value = getvalue3.getText();
            String tocav4value = getvalue4.getText();
            getvalue1.click();
            Assert.assertEquals(fromconnvalue1,"X-001");
            Assert.assertEquals(fromconnvalue2,"X-002");
            Assert.assertEquals(cav1value,"1");
            Assert.assertEquals(cav2value,"2");
            Assert.assertEquals(cav3value,"3");
            Assert.assertEquals(cav4value,"4");
            Assert.assertEquals(toconnvalue1,"X-001");
            Assert.assertEquals(toconnvalue2,"X-002");
            Assert.assertEquals(tocav1value,"1");
            Assert.assertEquals(tocav2value,"2");
            Assert.assertEquals(tocav3value,"3");
            Assert.assertEquals(tocav4value,"4");
        }
    }
        public  void getvaluesWireEditorPage() throws InterruptedException {
            basetableFromConn.click();
            customCommand.waitClick(getvalue1);
            System.out.println(getvalue1.getText());
            basetablematerial.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            List<WebElement> materialrows = gaugesize.findElements(By.tagName("tr"));
            System.out.println(materialrows.size());
            for(int i=1;i<=materialrows.size();i++) {
                WebElement materialelement = driver.findElement(By.cssSelector("#wire-editor > div > div > div.grid-wrapper > div.handsontable.htRowHeaders.htColumnHeaders > div.handsontableInputHolder > div > div.ht_master.handsontable > div > div > div > table > tbody > tr:nth-child("+i+") > td"));
                String material = materialelement.getText();
                materiallist.add(material);
            }
            wait.until(ExpectedConditions.visibilityOf(basetablegauge));
            basetablegauge.click();
            customCommand.doubleClick(driver,basetablegauge);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            List<WebElement> gaugerows = gaugesize.findElements(By.tagName("tr"));
            System.out.println(gaugerows.size());
            for(int i=1;i<=gaugerows.size();i++) {
                WebElement gaugeelement = driver.findElement(By.cssSelector("#wire-editor > div > div > div.grid-wrapper > div.handsontable.htRowHeaders.htColumnHeaders > div.handsontableInputHolder > div > div.ht_master.handsontable > div > div > div > table > tbody > tr:nth-child("+i+") > td"));
                String gauge = gaugeelement.getText();
                gaugelist.add(gauge);
            }
            System.out.println(gaugelist);
        }

    public  void select_get_colour_code()  {
        basetableFromConn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(getvalue1.getText());
        getvalue1.click();
        basetableToConn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(getvalue1.getText());
        getvalue1.click();
        basetablematerial.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        material_value = getvalue1.getText();
        getvalue1.click();
        System.out.println(material_value);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        basetablegauge.click();
        customCommand.doubleClick(driver,basetablegauge);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        gauge_value =getvalue1.getText();
        getvalue1.click();
        System.out.println(gauge_value);
        basetablecolour.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> colourrows = gaugesize.findElements(By.tagName("tr"));
        System.out.println(colourrows.size());
        for(int i=1;i<=colourrows.size();i++) {
            WebElement colourlelement = driver.findElement(By.cssSelector("#wire-editor > div > div > div.grid-wrapper > div.handsontable.htRowHeaders.htColumnHeaders > div.handsontableInputHolder > div > div.ht_master.handsontable > div > div > div > table > tbody > tr:nth-child("+i+") > td"));
            String colour = colourlelement.getText();
            switch (colour) {
                case "BK":
                    colour = "BLACK";
                    break;
                case "BL":
                    colour = "BLUE";
                    break;
                case "BR":
                    colour = "BROWN";
                    break;
                case "XX":
                    colour = "DEFAULT";
                    break;
                case "GY":
                    colour = "GRAY";
                    break;
                case "GN":
                    colour = "GREEN";
                    break;
                case "OR":
                    colour = "ORANGE";
                    break;
                case "PK":
                    colour = "PINK";
                    break;
                case "VT":
                    colour = "PURPLE";
                    break;
                case "RD":
                    colour = "RED";
                    break;
                case "TQ":
                    colour = "TURQUOISE";
                    break;
                case "WH" :
                    colour = "WHITE";
                    break;
                case "YE":
                    colour = "YELLOW";
                    break;
            }
            colourlist.add(colour);
            System.out.println(colourlist);
        }
    }


    public  List<String> get_material_gauge_colour() throws JsonProcessingException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs = new RestAssuredUtility();
        String response = rs.getComponentDbResponse("wire", driver);
        List<WiresComponentDB> dbData = new WiresComponentDBPage(driver).getWireAPIData(response);
        List<WiresComponentDB> filteredDbData = new ArrayList<>();
        List<WiresComponentDB> filteredDbData1 = new ArrayList<>();
        filteredDbData = dbData.stream().filter(x -> x.getGauge().equals(gauge_value)).collect(Collectors.toList());
        filteredDbData1 = filteredDbData.stream().filter(x -> x.getWirematerial().equals(material_value)).collect(Collectors.toList());
        String colour1[];
        for (int j = 0; j < filteredDbData1.size(); j++)
        {
            if(filteredDbData1.get(j).getColour().contains("-")) {
                colour1 = filteredDbData1.get(j).getColour().split("-");
                componentdbcolour.add(colour1[0]);

            }
             else{
                componentdbcolour.add(filteredDbData1.get(j).getColour());
             }
        }
        System.out.println(componentdbcolour);
        return componentdbcolour;
    }

    public  void selectMaterialGaugeAndGetValuesOfPartnumber() throws InterruptedException {
        basetableFromConn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(getvalue1.getText());
        getvalue1.click();
        basetablematerial.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        material_value = getvalue1.getText();
        getvalue1.click();
        System.out.println(material_value);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        basetablegauge.click();
        customCommand.doubleClick(driver,basetablegauge);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        gauge_value =getvalue1.getText();
        getvalue1.click();
        System.out.println(gauge_value);
        basetablepartnumber.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> partrows = gaugesize.findElements(By.tagName("tr"));
        System.out.println(partrows.size());
        for(int i=1;i<=partrows.size();i++) {
            WebElement partnumberlelement = driver.findElement(By.cssSelector("#wire-editor > div > div > div.grid-wrapper > div.handsontable.htRowHeaders.htColumnHeaders > div.handsontableInputHolder > div > div.ht_master.handsontable > div > div > div > table > tbody > tr:nth-child("+i+") > td"));
            String colour = partnumberlelement.getText();
            partnumberlist.add(colour);
        }
    }

    public  void getPartnumberValueFromComponentdb() throws JsonProcessingException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs = new RestAssuredUtility();
        String response = rs.getComponentDbResponse("wire", driver);
        List<WiresComponentDB> dbData = new WiresComponentDBPage(driver).getWireAPIData(response);
        List<WiresComponentDB> filteredDbData = new ArrayList<>();
        List<WiresComponentDB> filteredDbData1 = new ArrayList<>();
        filteredDbData = dbData.stream().filter(x -> x.getGauge().equals(gauge_value)).collect(Collectors.toList());
        filteredDbData1 = filteredDbData.stream().filter(x -> x.getWirematerial().equals(material_value)).collect(Collectors.toList());
        for (int i = 0; i < filteredDbData1.size(); i++)
        {
            componentbpartnumber.add(filteredDbData1.get(i).getPartnumber());
         }
    }

    public  void selectMaterialGaugeColor() throws InterruptedException {
        selectFromconnToconn();
        basetablematerial.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        material_value = getvalue1.getText();
        actrualWireEditorList.add(material_value);
        getvalue1.click();
        System.out.println(material_value);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        basetablegauge.click();
        customCommand.doubleClick(driver, basetablegauge);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        gauge_value = getvalue1.getText();
        actrualWireEditorList.add(gauge_value);
        getvalue1.click();
        System.out.println(gauge_value);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        basetablecolour.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getvalue1.click();
        basetablecolour.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String colour = getvalue1.getText();
        actrualWireEditorList.add(colour);
        switch (colour) {
            case "BK":
                colour = "BLACK";
                break;
            case "BL":
                colour = "BLUE";
                break;
            case "BR":
                colour = "BROWN";
                break;
            case "XX":
                colour = "DEFAULT";
                break;
            case "GY":
                colour = "GRAY";
                break;
            case "GN":
                colour = "GREEN";
                break;
            case "OR":
                colour = "ORANGE";
                break;
            case "PK":
                colour = "PINK";
                break;
            case "VT":
                colour = "PURPLE";
                break;
            case "RD":
                colour = "RED";
                break;
            case "TQ":
                colour = "TURQUOISE";
                break;
            case "WH":
                colour = "WHITE";
                break;
            case "YE":
                colour = "YELLOW";
                break;
        }
        colour_value=colour;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actrualWireEditorList.add(0,"123");
    }

    public  void getWirePartNumberFromWireEditorPage() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        basetablepartnumbervalue.click();
        customCommand.doubleClick(driver,basetablepartnumbervalue);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        partnumber_value =getvalue1.getText();
        getvalue1.click();
        System.out.println(partnumber_value);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wireeditorod_value = basetableod.getText();
        System.out.println(basetableod.getText());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wireeditorcsa_value=basetablecsa.getText();
        System.out.println(basetablecsa.getText());
    }
    public void getValues()  {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        customCommand.doubleClick(driver,basetablecomponentdb);
        String text = basetablecomponentdb.getText();
        if(text.contains("▼")) {
            componentdbvalue= text.replace("▼","");
        }
        actrualWireEditorList.add(componentdbvalue.trim());
        basetablepartnumbervalue.click();
        customCommand.doubleClick(driver,basetablepartnumbervalue);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        partnumber_value =getvalue1.getText();
        actrualWireEditorList.add(partnumber_value);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wireeditorod_value = basetableod.getText();
        actrualWireEditorList.add(wireeditorod_value);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wireeditorcsa_value=basetablecsa.getText();
        actrualWireEditorList.add(wireeditorcsa_value);
        System.out.println(actrualWireEditorList);
    }
    public void findselector() {
        headerlist.clear();
        WebElement mainTable = driver.findElement(By.cssSelector(".ht_master.handsontable table.htCore"));
        List<String> columnsToFillList = Arrays.asList("Wire ID","From Con", "From Cav", "To Con", "To Cav","Material","Gauge","Primary Color","Component DB","Part Number","Outer Dia","CSA");
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

            }
        }
        Set<String> componentcolour= new HashSet<>(headerlist);
        (headerlist).clear();
        (headerlist).addAll(componentcolour);
        System.out.println(headerlist);

    }
    public void enterAllTheValuesInTheWireEditor() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        selectMaterialGaugeColor();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getValues();
        savebuttonWire.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement okbutton = driver.findElement(By.cssSelector("button[data-bb-handler=\"ok\"]")) ;
        okbutton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        findselector();
    }
    public void selectFromconnToconn() throws InterruptedException {
        basetableFromConn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String fromConnText = getvalue1.getText();
        actrualWireEditorList.add(fromConnText);
        getvalue1.click();
        basetableFromCav.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String fromCav = getvalue1.getText();
        actrualWireEditorList.add(fromCav);
        getvalue1.click();
        basetableToConn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String toConnText = getvalue1.getText();
        actrualWireEditorList.add(toConnText);
        getvalue1.click();
        basetableToCav.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String toCavText = getvalue1.getText();
        actrualWireEditorList.add(toCavText);
        getvalue1.click();
    }

    public void enterWireIDFromConFromCavTOConnToCav() throws InterruptedException {
        selectFromconnToconn();
        updateWirePN.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        savebuttonWire.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actualAlertMessage  = getAlertMessage.getText();
    }

    public void enterPossibleValuesInTheForm() throws InterruptedException {
        selectFromconnToconn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        updateWirePN.click();
    }

    public void checkRedoUndoRemoveRow() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        partNumber.click();
        if(partNumber.getText().contains("▼")) {
            String temp = partNumber.getText().replace("▼","");
            expectedRedoText = temp.trim();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        customCommand.rightClick(driver,partNumber);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wireEditorUndo.click();
        String expectedUndoText = partNumber.getText();
        String ActualUndoText = material.getText();
        Assert.assertEquals(ActualUndoText,expectedUndoText,"UNDO is not working as expected");
        partNumber.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        customCommand.rightClick(driver,partNumber);
        getWireEditorRedo.click();
        partNumber.click();
        if(partNumber.getText().contains("▼")) {
            String temp = partNumber.getText().replace("▼","");
            actualRedoText = temp.trim();
        }
        Assert.assertEquals(actualRedoText,expectedRedoText,"REDO is not working as expected");
        fromConn.click();
        expectedRemoveRowText = "";
        customCommand.rightClick(driver,fromConn);
        getWireEditorRemoveRow.click();
        fromConn.click();
        if(fromConn.getText().contains("▼")) {
            String temp = fromConn.getText().replace("▼","");
            actualRemoveRowText = temp.trim();
        }
        Assert.assertEquals(actualRemoveRowText,expectedRemoveRowText,"Remove Row is not working as expected");
    }

    public void checkautoselectscomponentDBornot() throws InterruptedException {
        Select select = new Select(selectizeComponentDB);
        WebElement selectedOption = select.getFirstSelectedOption();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        customCommand.doubleClick(driver,basetablecomponentdb);
        String text = basetablecomponentdb.getText();
        if(text.contains("▼")) {
            componentdbvalue= text.replace("▼","");
            componentdbvalue = componentdbvalue.trim();
        }
        Assert.assertEquals(componentdbvalue,System.getProperty("componentDB"),"ComponentDB are not matching with harness Created in the Wire Editor Form");
        Assert.assertEquals(selectedOption.getText(),System.getProperty("componentDB"),"ComponentDB are not matching with harness created in selectize near export CSV");
    }

    public void unselectTheHeadersInTheWireEditorAndSave() throws InterruptedException {
        enterPossibleValuesInTheForm();
        WebElement uncheck = driver.findElement(By.cssSelector("body div[class='wrapper'] div[class='form-group'] div[class='form-group'] div:nth-child(1) div:nth-child(1) button:nth-child(1)"));
        uncheck.click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        for(int i=4;i<9;i++) {
            WebElement uncheck2 = driver.findElement(By.cssSelector(" #wire-editor > div > div > div.box-body.no-padding > div.box-toolbar.grid-editor__toolbar > div > div:nth-child(1) > div:nth-child(1) > div > ul > li:nth-child("+i+") > label > input[type=checkbox]"));
            js.executeScript("arguments[0].click();", uncheck2);
            System.out.println(uncheck2.getText());
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        findselector();
        actualHeaderList = headerlist;
        updateWirePN.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        savebuttonWire.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actualAlertMessage  = getAlertMessage.getText();
        Assert.assertEquals("Please enter highlighted field.","Wires imported successfully.","There is some error Wire editor form which is blocking to save the form");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        findselector();
        expectedHeaderList=headerlist;
        System.out.println(expectedHeaderList);
    }

    public void fillTheWireEditorFormSaveAndExportCsv() throws InterruptedException, IOException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        enterPossibleValuesInTheForm();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        savebuttonWire.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement okbutton = driver.findElement(By.cssSelector("button[data-bb-handler=\"ok\"]"));
        okbutton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        exportcsvbuttonWire.click();
      // js.executeScript("arguments[0].click();", exportcsvbuttonWire);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String downloadDir = System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles";
        Path newestFile = Files.list(Paths.get(downloadDir))
                .filter(f -> f.toString().endsWith(".csv"))
                .max(Comparator.comparingLong(f -> f.toFile().lastModified()))
                .orElseThrow(() -> new RuntimeException("No CSV files found in directory"));
        File csvFile = newestFile.toFile();
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        String line ;
        while ((line = reader.readLine()) != null) {
            actualCsv.append(line).append("\n");
        }
        reader.close();
        File expectedCsvFile = new File("src/test/resources/expected/expectedWireEditor.csv");
        reader = new BufferedReader(new FileReader(expectedCsvFile));

        while ((line = reader.readLine()) != null) {
            expectedCsv.append(line).append("\n");
        }
        reader.close();
        // delete downloaded file
        csvFile.delete();
    }

    public void checkWhetherExportedCSVMatchesTheExpectedCSVOrNot() {
        Assert.assertEquals(actualCsv.toString(),expectedCsv.toString(),"CSV files do not match.");
    }

    public void fillTheWireEditorFormSaveAndSelectWireClassAsMulticore() throws InterruptedException {
        selectFromconnToconn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        customCommand.doubleClick(driver,basetablewireclass);
        getvalue2.click();
        System.out.println(getvalue2.getText());
        updateWirePN.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void checkTheFormByNotFillingTheCOREIDAndMCID() throws InterruptedException {
        savebuttonWire.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actualAlertMessage  = getAlertMessage.getText();
        Assert.assertEquals(actualAlertMessage,"Please enter highlighted field.","There is some error Wire editor form should not allow to submit the form");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void checkTheFormByFillAllThePossibleValuesInTheForm() throws InterruptedException, AWTException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        customCommand.doubleClick(driver,basetablecoreid);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getvalue1.click();
        System.out.println(getvalue1.getText());
        customCommand.doubleClick(driver,basetablemcid);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.querySelector('textarea.handsontableInput').value ='MC';");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        customCommand.tabKey();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        js.executeScript("document.querySelector('textarea.handsontableInput').value ='';");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        savebuttonWire.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actualAlertMessage = "";
        actualAlertMessage  = getAlertMessage.getText();
        Assert.assertEquals(actualAlertMessage,"Wires imported successfully.","There is some error Wire editor form should not allow to submit the form");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void checkWhetherTheImportedCsvHasBeenSavedsuccessfulOrNotWithoutErrors() throws InterruptedException, IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        savebuttonWire.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actualAlertMessage = "";
        actualAlertMessage  = getAlertMessage.getText();
        Assert.assertEquals(actualAlertMessage,"Wires imported successfully.","There is some error Wire editor form should not allow to submit the form");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement okbutton1 = driver.findElement(By.cssSelector("button[data-bb-handler=\"ok\"]"));
        okbutton1.click();
    }

    public void importTheExportedCsv() throws InterruptedException {
        WebElement upload_csv = driver.findElement(By.name("fileImportCSV"));
        upload_csv.sendKeys(System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles"+ File.separator + "wires.csv");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement okbutton = driver.findElement(By.cssSelector("button[class='btn btn-primary']"));
        okbutton.click();
    }

    public void fillTheWireEditorFormSaveAndExportCsvAndCheckForAnyErrors() throws InterruptedException, IOException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        enterPossibleValuesInTheForm();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        savebuttonWire.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement okbutton = driver.findElement(By.cssSelector("button[data-bb-handler=\"ok\"]"));
        okbutton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        exportcsvbuttonWire.click();
        // js.executeScript("arguments[0].click();", exportcsvbuttonWire);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String downloadDir = System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles";
        Path newestFile = Files.list(Paths.get(downloadDir))
                .filter(f -> f.toString().endsWith(".csv"))
                .max(Comparator.comparingLong(f -> f.toFile().lastModified()))
                .orElseThrow(() -> new RuntimeException("No CSV files found in directory"));
        File csvFile = newestFile.toFile();
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        String line ;
        while ((line = reader.readLine()) != null) {
            actualCsv.append(line).append("\n");
        }
        reader.close();
        File expectedCsvFile = new File("src/test/resources/expected/expectedWireEditor.csv");
        reader = new BufferedReader(new FileReader(expectedCsvFile));

        while ((line = reader.readLine()) != null) {
            expectedCsv.append(line).append("\n");
        }
        reader.close();
    }

    public void clearAllTheValuesInWireEditorForm() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement clearall = driver.findElement(By.cssSelector("button[value='Clear all']"));
        clearall.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement okbutton = driver.findElement(By.cssSelector("button[class='btn btn-primary']"));
        okbutton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement clear = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
        clear.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        basetablematerial.click();
        Assert.assertEquals(basetablematerial.getText(),"▼","Clear all is not clearing the value in the wire editor Form");
    }

    public void checkWhetherTheImportedCsvHasBeenSavedSuccessfulOrNotWithoutErrorsByClearingAllTheValuesInTheFrom() throws InterruptedException, IOException {
        importTheExportedCsv();
        checkWhetherTheImportedCsvHasBeenSavedsuccessfulOrNotWithoutErrors();
    }
}





