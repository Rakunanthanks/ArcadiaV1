package arcadia.pages;

import arcadia.domainobjects.SplicesComponentDB;
import arcadia.domainobjects.TerminalsComponentDB;
import arcadia.mapperObjects.DrawingInstructor;
import arcadia.pages.ComponentDB.CommonElements;
import arcadia.pages.ComponentDB.Splices.SplicesComponentDBPage;
import arcadia.pages.ComponentDB.Terminals.TerminalsComponentDBPage;
import arcadia.utils.RestAssuredUtility;
import arcadia.utils.SeleniumCustomCommand;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.eo.Se;
import net.bytebuddy.asm.Advice;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.desktop.SystemEventListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class DefineUpdateCavities extends BasePage {
    public static List<String> actualComponenDB = new ArrayList<>();
    public static List<String> actualcompanyname_1;
    public static List<String> actualcompanyname_2;
    public static  List<String> actualfamily;
    public static  List<String> actualmaterial;
    public static  List<String> actualtype;
    public static  List<String> actualfinish;

    public static  List<String> componentbfamily;
    public static  List<String> componentbmaterial;
    public static  List<String> componentbtype;
    public static  List<String> componentbfinish;
    public static String wirecsa;
    public static String wireod;
    public static String terminalpartnumber;
    public static String connectorpartnumber;
    public static String terminalerror;
    public static String ActualwirecsaFrom;
    public static String ActualwirecsaTo;
    public static String ActualwireODFrom;
    public static String ActualwireODTo;
    public static boolean findtermial;
    public static String material = null;
    public static String finish = null;
    public static String type = null;
    public static String gender = null;
    public static String family = null;

    public static String  tableTerminalRows = "#tblterminal > tbody > tr";



    public static SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    public DefineUpdateCavities(WebDriver driver) {
        super(driver);
    }

    public static void selectingupdatecavitiesvalue() throws InterruptedException {
        Thread.sleep(5000);
        WebElement cavitiesbutton = driver.findElement(By.cssSelector("div[id='igettermsandseals'] span[class='button-title']"));
        customCommand.longWaitForElementToBeClickable(driver,cavitiesbutton);
        cavitiesbutton.click();
    }
    public static void getComponentDBNameFromUpdateCavitiesForm() {
        Select selectdropdowncompanyname  = new Select(driver.findElement(By.cssSelector("select[name='termlibrary']")));
        List<WebElement> componentDBName = selectdropdowncompanyname.getOptions();
        List<String> actualcomponentDBName = new ArrayList<String>();
        for(WebElement componentDBNameoptions : componentDBName){
            actualcomponentDBName.add(componentDBNameoptions.getText());
        }
        actualcomponentDBName.remove(0);
        Collections.sort(actualcomponentDBName);
        actualComponenDB=actualcomponentDBName;
        System.out.println(actualComponenDB);
    }
   public static List<String> gettingallcompanyvalues(){
      //  new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeSelected(By.xpath("//select[@name='company']")));
       Select selectdropdowncompanyname = new Select(driver.findElement(By.cssSelector("select[name='company']")));
       List<WebElement> companyname = selectdropdowncompanyname.getOptions();
       List<String> actualcompanyname = new ArrayList<String>();
       for(WebElement companynameoptions : companyname){
           actualcompanyname.add(companynameoptions.getText());
       }
       actualcompanyname.remove(0);
       actualcompanyname_1 =actualcompanyname;
       return actualcompanyname;
    }
    public static void selectcomponentDB(String componentDB) throws InterruptedException {
        Thread.sleep(5000);
        Select selectcomponentdb = new Select(driver.findElement(By.xpath("//select[@name='termlibrary']")));
        Thread.sleep(3000);
        System.out.println(componentDB);
        selectcomponentdb.selectByValue(componentDB);
    }

    public static void selectwirestobeupdated() throws InterruptedException {
        Thread.sleep(8000);
        WebElement selectwire = driver.findElement(By.cssSelector("#findTbl > tbody > tr:nth-child(1) > td:nth-child(1) > input[type=checkbox]"));
        selectwire.click();
        WebElement readcsa = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[2]/tbody[1]/tr[1]/td[9]"));
        wirecsa = readcsa.getText();
        System.out.println(wirecsa);
        WebElement readod = driver.findElement(By.xpath("//*[@id=\"findTbl\"]/tbody/tr[1]/td[10]"));
        wireod = readod.getText();
        System.out.println(wireod);
        WebElement readterminalpartnumber=driver.findElement(By.xpath("//*[@id=\"findTbl\"]/tbody/tr[1]/td[11]"));
        terminalpartnumber = readterminalpartnumber.getText();
        System.out.println(terminalpartnumber);
        WebElement readconnectorpartnumber = driver.findElement(By.xpath("//*[@id=\"findTbl\"]/tbody/tr[1]/td[3]"));
        connectorpartnumber = readconnectorpartnumber.getText();
        System.out.println(connectorpartnumber);
        WebElement submitbutton = driver.findElement(By.xpath("//button[@title='Submit']"));
        submitbutton.click();
        Thread.sleep(1000);
      try
        {
            WebElement readterminalerror = driver.findElement(By.cssSelector("#ui-accordion-accordion-panel-1 > table:nth-child(2) > tbody > tr > td:nth-child(5)"));
            terminalerror = readterminalerror.getText();
            System.out.println(terminalerror);
            findtermial =false;
            System.out.println("there is an error");
        }
        catch(org.openqa.selenium.NoSuchElementException ex)
        {
            WebElement readterminalerror1 = driver.findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > table:nth-child(2) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(1)"));
            terminalerror= readterminalerror1.getText();
            System.out.println(terminalerror);
            findtermial =true;
            System.out.println("there is no error");
        }
    }
    public static void serachterminalpartnumber_csa_od() throws InterruptedException, JsonProcessingException {
        WebElement searchelement = driver.findElement(By.cssSelector("input[placeholder='Search']"));
        System.out.println(connectorpartnumber);
        searchelement.sendKeys(connectorpartnumber);
        searchelement.sendKeys(Keys.ENTER);
        WebElement editterminal = driver.findElement(By.cssSelector("button[title='View']"));
        editterminal.click();
        Thread.sleep(2000);
        float checkwirecsa = Float.parseFloat(wirecsa);
        float checkod = Float.parseFloat(wireod);
        List<WebElement> checkcsa1 = driver.findElements(By.cssSelector(".panel:nth-child(3) table tr td:nth-child(3)"));
        List<WebElement> checkod1 = driver.findElements(By.cssSelector(".panel:nth-child(3) table tr td:nth-child(4)"));
        for (int i = 0; i < checkcsa1.size(); i++) {
            WebElement csa = checkcsa1.get(i);
            WebElement od = checkod1.get(i);
            String csa1 = csa.getText();
            String od1 = od.getText();
            String[] casaSplit = csa1.split("-");
            Float fromod = null, tood = null;
            if (od1 != "0.00") {
                String[] odsplit = od1.split("-");
                fromod = Float.parseFloat(odsplit[0]);
                tood = Float.parseFloat(odsplit[1]);
            }
            float fromCSA = Float.parseFloat(casaSplit[0]);
            float toCSA = Float.parseFloat(casaSplit[1]);
            if (checkwirecsa >= fromCSA && checkwirecsa <= toCSA) {
                if (fromod != null && tood != null) {
                    if (checkod >= fromod && checkod <= tood) {
                        assertTrue(checkwirecsa >= fromCSA && checkwirecsa <= toCSA, "Wire CSA and OD matches to the terminal");
                    } else {
                        assertTrue(checkwirecsa >= fromCSA && checkwirecsa <= toCSA, "Wire CSA matches to the terminal where OD is 0 should be considered to map terminal");
                    }
                }
            }
        }
    }
    public static void serachterminal_properties_1() {

    }

    public static void serachterminal_properties_5() throws InterruptedException, JsonProcessingException {
        WebElement searchelement = driver.findElement(By.cssSelector("input[placeholder='Search']"));
        searchelement.sendKeys(connectorpartnumber);
        searchelement.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        WebElement editterminal = driver.findElement(By.cssSelector("button[title='View']"));
        editterminal.click();
        Thread.sleep(3000);
        float checkwirecsa = Float.parseFloat(wirecsa);
        float checkod = Float.parseFloat(wireod);
        List<WebElement> checkcsa1 = driver.findElements(By.cssSelector(".panel:nth-child(3) table tr td:nth-child(3)"));
        List<WebElement> checkod1 = driver.findElements(By.cssSelector(".panel:nth-child(3) table tr td:nth-child(4)"));
        List<WebElement> checkproperties = driver.findElements(By.cssSelector(".panel:nth-child(3) table tr td:nth-child(1)"));
        WebElement checkproperty = driver.findElement(By.cssSelector(".panel:nth-child(3) table  tr th:nth-child(5)"));
        for (int i = 0; i < checkcsa1.size(); i++) {
            WebElement csa = checkcsa1.get(i);
            WebElement od = checkod1.get(i);
            String csa1 = csa.getText();
            String od1 = od.getText();
            String[] casaSplit = csa1.split("-");
            Float fromod = null, tood = null;
            if (!Objects.equals(od1, "0.00")) {
                String[] odsplit = od1.split("-");
                fromod = Float.parseFloat(odsplit[0]);
                tood = Float.parseFloat(odsplit[1]);
            }
            float fromCSA = Float.parseFloat(casaSplit[0]);
            float toCSA = Float.parseFloat(casaSplit[1]);
            if(checkwirecsa >= fromCSA && checkwirecsa <= toCSA){
                assertTrue(checkwirecsa >= fromCSA && checkwirecsa <= toCSA, "Csa are in the range should be considered to map the terminal");
            }
            for (int j = 1; j <= checkproperties.size(); j++) {
            if (checkwirecsa >= fromCSA && checkwirecsa <= toCSA) {
                    WebElement getproperty = driver.findElement(By.cssSelector("body > div.bootbox.modal.fade.datasheet.bootdatasheet1.in > div > div > div.modal-body > div > div:nth-child(3) > div.panel-body.no-padding > table > tbody > tr:nth-child(" + j + ") > td:nth-child(1)"));
                    String terminalpartnumber = getproperty.getText();
                    System.out.println("Getting data from API");
                    RestAssuredUtility rs = new RestAssuredUtility();
                    String response = rs.getComponentDbResponse("terminal", driver);
                    List<TerminalsComponentDB> dbData = new TerminalsComponentDBPage(driver).getTerminalAPIData(response);
                    List<TerminalsComponentDB> filteredDbData = new ArrayList<>();
                    filteredDbData = dbData.stream().filter(x -> x.getPartnumber().equals(terminalpartnumber)).collect(Collectors.toList());
                    if (findtermial) {
                        assertFalse(filteredDbData.get(0).getFinish().isEmpty(), "Chosen finish Property do not match the terminal finish");
                    } else {
                        assertTrue( filteredDbData.get(0).getFinish().isEmpty(), "Chosen finish Property do not match the terminal finish");
                    }
                }
            }
        }
    }
    public static void serachterminal_properties_2() throws InterruptedException, JsonProcessingException {
        WebElement searchelement = driver.findElement(By.cssSelector("input[placeholder='Search']"));
        searchelement.sendKeys(connectorpartnumber);
        searchelement.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        WebElement editterminal = driver.findElement(By.cssSelector("button[title='View']"));
        editterminal.click();
        Thread.sleep(2000);
        float checkwirecsa = Float.parseFloat(wirecsa);
        float checkod = Float.parseFloat(wireod);
        List<WebElement> checkcsa1 = driver.findElements(By.cssSelector(".panel:nth-child(3) table tr td:nth-child(3)"));
        List<WebElement> checkod1 = driver.findElements(By.cssSelector(".panel:nth-child(3) table tr td:nth-child(4)"));
        List<WebElement> checkproperties = driver.findElements(By.cssSelector(".panel:nth-child(3) table tr td:nth-child(1)"));
        WebElement checkproperty = driver.findElement(By.cssSelector(".panel:nth-child(3) table  tr th:nth-child(5)"));
        for (int i = 0; i < checkcsa1.size(); i++) {
            WebElement csa = checkcsa1.get(i);
            WebElement od = checkod1.get(i);
            String csa1 = csa.getText();
            String od1 = od.getText();
            String[] casaSplit = csa1.split("-");
            Float fromod = null, tood = null;
            if (!Objects.equals(od1, "0.00")) {
                String[] odsplit = od1.split("-");
                fromod = Float.parseFloat(odsplit[0]);
                tood = Float.parseFloat(odsplit[1]);
            }
            float fromCSA = Float.parseFloat(casaSplit[0]);
            float toCSA = Float.parseFloat(casaSplit[1]);
            if (checkwirecsa >= fromCSA && checkwirecsa <= toCSA) {
                assertTrue(checkwirecsa >= fromCSA && checkwirecsa <= toCSA, "Csa are in the range should be considered to map the terminal");
            }
            for (int j = 1; j <= checkproperties.size(); j++) {
            if (checkwirecsa >= fromCSA && checkwirecsa <= toCSA) {
                    WebElement getproperty = driver.findElement(By.cssSelector("body > div.bootbox.modal.fade.datasheet.bootdatasheet1.in > div > div > div.modal-body > div > div:nth-child(3) > div.panel-body.no-padding > table > tbody > tr:nth-child(" + j + ") > td:nth-child(1)"));
                    System.out.println(getproperty.getText());
                    String terminalpartnumber = getproperty.getText();
                    System.out.println("Getting data from API");
                    RestAssuredUtility rs = new RestAssuredUtility();
                    String response = rs.getComponentDbResponse("terminal", driver);
                    List<TerminalsComponentDB> dbData = new TerminalsComponentDBPage(driver).getTerminalAPIData(response);
                    List<TerminalsComponentDB> filteredDbData = new ArrayList<>();
                    filteredDbData = dbData.stream().filter(x -> x.getPartnumber().equals(terminalpartnumber)).collect(Collectors.toList());
                    if (findtermial) {
                        assertEquals(finish, filteredDbData.get(0).getFinish(), "Chosen finish Property do not match the terminal finish");
                    } else {
                        assertNotEquals(finish, filteredDbData.get(0).getFinish(), "Chosen finish Property do not match the terminal finish");
                    }
                }
            }
        }
    }

    public static void serachterminalpartnumber() throws InterruptedException {
    WebElement searchelement = driver.findElement(By.cssSelector("input[placeholder='Search']"));
    searchelement.sendKeys(connectorpartnumber);
    searchelement.sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    WebElement editterminal = driver.findElement(By.cssSelector("button[title='View']"));
    editterminal.click();
    Thread.sleep(2000);
        float checkwirecsa = Float.parseFloat(wirecsa);
        float checkod = Float.parseFloat(wireod);
        System.out.println(checkwirecsa);
        System.out.println(checkod);
        List<WebElement> checkcsa1 = driver.findElements(By.cssSelector(".panel:nth-child(3) table tr td:nth-child(3)"));
        List<WebElement> checkod1 = driver.findElements(By.cssSelector(".panel:nth-child(3) table tr td:nth-child(4)"));
        System.out.println(checkcsa1);
        for (int i = 0; i < checkcsa1.size(); i++) {
            WebElement csa = checkcsa1.get(i);
            WebElement od = checkod1.get(i);
            String csa1 = csa.getText();
            String od1 = od.getText();
            String[] casaSplit = csa1.split("-");
            Float fromod = null, tood = null;
            if (!Objects.equals(od1, "0.00")) {
                String[] odsplit = od1.split("-");
                fromod = Float.parseFloat(odsplit[0]);
                tood = Float.parseFloat(odsplit[1]);
            }
            float fromCSA = Float.parseFloat(casaSplit[0]);
            float toCSA = Float.parseFloat(casaSplit[1]);
            System.out.println(fromCSA);
            System.out.println(toCSA);
            System.out.println(checkwirecsa);
            if (checkwirecsa >= fromCSA && checkwirecsa <= toCSA) {
                System.out.println("true");
                if (fromod != null && tood != null) {
                    if (checkod >= fromod && checkod <= tood) {
                        assertTrue(checkwirecsa >= fromCSA && checkwirecsa <= toCSA, "Wire CSA and OD matches to the terminal");
                    } else {
                        assertTrue(checkwirecsa >= fromCSA && checkwirecsa <= toCSA, "Wire CSA matches to the terminal where OD is 0 should be considered to map terminal");
                    }
                }
            }
        }
    }
    public static List<String> gettingcompnentDBoptions(){
        Select selectdropdowncompanyname = new Select(driver.findElement(By.xpath("//select[@name='company']")));
        List<WebElement> companyname = selectdropdowncompanyname.getOptions();
        List<String> actualcompanyname = new ArrayList<String>();
        for(WebElement companynameoptions : companyname) {
            actualcompanyname.add(companynameoptions.getText());
        }
        actualcompanyname_2 =  actualcompanyname;
        return actualcompanyname;
    }



    public static List<String> getTerminalsData() throws InterruptedException, JsonProcessingException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("terminal",driver);
        List<TerminalsComponentDB> dbData =new TerminalsComponentDBPage(driver).getTerminalAPIData(response);
        String expectedTerminalsListMaterial;
        String expectedTerminalsListType;
        String expectedFinishListType;
        String expectedFamilyList;
        List <String> material = new ArrayList<>();
        List <String> terminalType = new ArrayList<>();
        List<String> terminalFinish = new ArrayList<>();
        List<String> terminalFamily = new ArrayList<>();
        List<TerminalsComponentDB> terminalTypeDbData = dbData.stream().filter(x -> !Objects.equals(x.getTerminaltype(), "")).toList();
        for (TerminalsComponentDB terminalMaterialDbDatum : terminalTypeDbData) {
            expectedTerminalsListType = terminalMaterialDbDatum.getTerminaltype();
            terminalType.add(expectedTerminalsListType);
            expectedTerminalsListMaterial = terminalMaterialDbDatum.getMaterial();
            material.add(expectedTerminalsListMaterial);
            expectedFinishListType = terminalMaterialDbDatum.getFinish();
            terminalFinish.add(expectedFinishListType);
            expectedFamilyList = terminalMaterialDbDatum.getFamily();
            terminalFamily.add(expectedFamilyList);
        }
        Set<String> setType = new HashSet<>(terminalType);
        terminalType.clear();
        terminalType.addAll(setType);
        Collections.sort(terminalType);
        Set<String> setMaterial = new HashSet<>(material);
        material.clear();
        material.addAll(setMaterial);
        Collections.sort(material);
        Set<String> setFinish = new HashSet<>(terminalFinish);
        terminalFinish.clear();
        terminalFinish.addAll(setFinish);
        Collections.sort(terminalFinish);
        Set<String> setFamily = new HashSet<>(terminalFamily);
        terminalFamily.clear();
        terminalFamily.addAll(setFamily);
        Collections.sort(terminalFamily);
        componentbfamily=terminalFamily;
        componentbmaterial =material;
        componentbtype = terminalType;
        componentbfinish=terminalFinish;
        return terminalFinish;

    }
    public static List<String> selecting_overwriteparts() {
        Select selectoverwriteparts = new Select(driver.findElement(By.xpath("//select[@name='overwrite']")));
        List<WebElement> overwriteparts = selectoverwriteparts.getOptions();
        List<String> actualoverwriteparts = new ArrayList<String>();
        for (WebElement overwritepartsoptions : overwriteparts) {
            actualoverwriteparts.add(overwritepartsoptions.getText());
        }
        return actualoverwriteparts;
    }

    public static List<String> selecting_wireod() {
    Select selectcheckwireod = new Select(driver.findElement(By.xpath("//select[@name='checkod']")));
    List<WebElement> wireod = selectcheckwireod.getOptions();
    List<String> actualwireod = new ArrayList<String>();
        for(WebElement wireodoptions:wireod) {
            actualwireod.add(wireodoptions.getText());
        }return actualwireod;
     }

     public static List<String> Selecting_familyoverride() throws InterruptedException {
        Thread.sleep(1000);
         Select selectfamilyoverride = new Select(driver.findElement(By.xpath("//select[@name='termfamily']")));
         List<WebElement> familyoverride = selectfamilyoverride.getOptions();
         List<String> actualfamilyoverride = new ArrayList<String>();
         for (WebElement familyoverrideoptions : familyoverride) {
             actualfamilyoverride.add(familyoverrideoptions.getText());
         }
         actualfamilyoverride.remove(0);
         actualfamilyoverride.remove(0);
         System.out.println(actualfamilyoverride);
         actualfamily=actualfamilyoverride;
         return actualfamilyoverride;
     }
     public static List<String> Selecting_typeoverride() throws InterruptedException {
         Thread.sleep(1000);
         Select selecttypeoverride = new Select(driver.findElement(By.xpath("//select[@name='termtype']")));
         List<WebElement> typeoverride = selecttypeoverride.getOptions();
         List<String> actualtypeoverride = new ArrayList<String>();
         for (WebElement typeoverrideoptions : typeoverride) {
             actualtypeoverride.add(typeoverrideoptions.getText());
         }
         actualtypeoverride.remove(0);
         actualtypeoverride.remove(0);
         System.out.println(actualtypeoverride);
         actualtype=actualtypeoverride;
         return actualtypeoverride;
      }

      public static List<String> Selecting_finishoverride() throws InterruptedException {
        Thread.sleep(1000);
          Select selectfinishoverride =new Select( driver.findElement(By.xpath("//select[@name='termfinish']")));
          List <WebElement> finishoverride = selectfinishoverride.getOptions();
          List<String> actualfinishoverride =new ArrayList<String>();
          for (WebElement finishoverrideoptions :finishoverride){
              actualfinishoverride.add(finishoverrideoptions.getText());
          }
          actualfinishoverride.remove(0);
          actualfinishoverride.remove(0);
          actualfinish=actualfinishoverride;
          return actualfinishoverride;
      }

      public static List<String> Selecting_materialoverride() throws InterruptedException {
        Thread.sleep(1000);
       Select selectmaterialoverride =new Select( driver.findElement(By.xpath("//select[@name='termmaterial']")));
       List <WebElement>materialoverride = selectmaterialoverride.getOptions();
       List<String> actualmaterialoverride = new ArrayList<String>();
          for (WebElement materialoverrideoptions:materialoverride) {
              actualmaterialoverride.add(materialoverrideoptions.getText());
          }
          actualmaterialoverride.remove(0);
          actualmaterialoverride.remove(0);
          actualmaterial=actualmaterialoverride;
          return  actualmaterialoverride;
      }
      public static List<String> Selecting_genderoverride() {
          Select selectgenderoverride = new Select(driver.findElement(By.xpath("//select[@name='termgender']")));
          List<WebElement> genderoverride = selectgenderoverride.getOptions();
          List<String> actualgenderoverride = new ArrayList<String>();
          for (WebElement genderoverrideoptions : genderoverride) {
              actualgenderoverride.add(genderoverrideoptions.getText());
          }
          return actualgenderoverride;
      }
      public static void selecting_update_cavitiesform(int options) throws InterruptedException, IOException {
          Thread.sleep(4000);
          Select library = new Select(driver.findElement(By.cssSelector("select[name='termlibrary']")));
          Select checkod = new Select(driver.findElement(By.cssSelector("select[name='checkod']")));
          Select termfamily = new Select(driver.findElement(By.cssSelector("select[name='termfamily']")));
          Select termtype = new Select(driver.findElement(By.cssSelector("select[name='termtype']")));
          Select termfinish = new Select(driver.findElement(By.cssSelector("select[name='termfinish']")));
          Select termmaterial = new Select(driver.findElement(By.cssSelector("select[name='termmaterial']")));
          Select termgender = new Select(driver.findElement(By.cssSelector("select[name='termgender']")));
          Select updateType = new Select(driver.findElement(By.cssSelector("select[name='updateType']")));
          WebElement submit = driver.findElement(By.cssSelector("#DynamicForm #btnFotter .sbarbut"));
          WebElement manualSubmit = driver.findElement(By.cssSelector("button[id='idimport'] span[class='ui-button-text']"));
          switch (options) {
              case 1 -> {
                  library.selectByValue("all");
                  checkod.selectByValue("yes");
                  termfamily.selectByValue("no");
                  termtype.selectByValue("no");
                  termfinish.selectByValue("no");
                  termmaterial.selectByValue("no");
                  termgender.selectByValue("no");
                  submit.click();
              }
              case 2 -> {
                  library.selectByValue("quickstart");
                  checkod.selectByValue("yes");Thread.sleep(2000);
                  termfamily.selectByValue("ALTERNATOR");Thread.sleep(2000);
                  termtype.selectByValue("INTERNAL");Thread.sleep(2000);
                  termfinish.selectByValue("GOLD");Thread.sleep(2000);
                  termmaterial.selectByValue("COPPER");Thread.sleep(2000);
                  termgender.selectByValue("Female");Thread.sleep(2000);
                  submit.click();
                  family = "ALTERNATOR";
                  material = "COPPER";
                  finish = "GOLD";
                  type = "INTERNAL";
                  gender = "Female";
              }
              case 3 -> {
                  library.selectByValue("quickstart");
                  checkod.selectByValue("yes");Thread.sleep(2000);
                  termfamily.selectByValue("no");Thread.sleep(2000);
                  termtype.selectByValue("RING%20TERM");Thread.sleep(2000);
                  termfinish.selectByValue("NICKEL");Thread.sleep(2000);
                  termmaterial.selectByValue("COPPER");Thread.sleep(2000);
                  termgender.selectByValue("yes");
                  submit.click();
                  material = "COPPER";
                  finish = "NICKEL";
                  type = "RING TERM";
              }
              case 4 -> {
                  library.selectByValue("quickstart");
                  checkod.selectByValue("no");
                  termfamily.selectByValue("no");Thread.sleep(2000);
                  termtype.selectByValue("RING%20TERM");Thread.sleep(2000);
                  termfinish.selectByValue("NICKEL");Thread.sleep(2000);
                  termmaterial.selectByValue("COPPER");Thread.sleep(2000);
                  termgender.selectByValue("no");Thread.sleep(2000);
                  submit.click();
                  material = "COPPER";
                  finish = "NICKEL";
                  type = "RING TERM";
              }
              case 5 -> {
                  library.selectByValue("quickstart");
                  checkod.selectByValue("no");
                  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                  termfamily.selectByValue("no");
                  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                  termtype.selectByValue("no");
                  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                  termfinish.selectByValue("no");
                  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                  termmaterial.selectByValue("no");
                  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                  termgender.selectByValue("yes");
                  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                  submit.click();
              }
              case 6 ->{
                  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                  updateType.selectByValue("manual");
                  WebElement exportTemplate = driver.findElement(By.name("idexport"));
                  exportTemplate.click();
                  Thread.sleep(5000);
                  String downloadDir = System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles" ;
                  Files.list(Paths.get(downloadDir))
                          .filter(f -> f.toString().endsWith(".csv"))
                          .max(Comparator.comparingLong(f -> f.toFile().lastModified()))
                          .orElseThrow(() -> new RuntimeException("No Template downloaded in directory"));
                  File file = new File(downloadDir);
                  if(file.exists()) {
                      FileUtils.cleanDirectory(file);
                  }
              }
              case 7 -> {
                  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                  updateType.selectByValue("manual");
                  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                  manualSubmit.click();
              }
              case 8 -> {
                  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                  updateType.selectByValue("manual");
                  WebElement upload_csv = driver.findElement(By.name("uploadFile"));
                  upload_csv.sendKeys(System.getProperty("user.dir")  + File.separator + "src" + File.separator + "test"+ File.separator + "resources" +File.separator +"testData" +File.separator + "updateCavitiesManual.csv");
                  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                  Thread.sleep(5000);
                  manualSubmit.click();
                  Thread.sleep(5000);
              }

          }
      }
}
