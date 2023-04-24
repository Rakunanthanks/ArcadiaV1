package arcadia.stepdefinations;

import arcadia.constants.EndPoint;
import arcadia.context.TestContext;
import arcadia.domainobjects.ConnectorDB;
import arcadia.domainobjects.TerminalsComponentDB;
import arcadia.pages.ComponentDB.Connectors.ConnectorsDBPage;
import arcadia.pages.ComponentDB.Terminals.TerminalsComponentDBPage;
import arcadia.pages.DefineUpdateCavities;
import arcadia.utils.DrawingHelper;
import arcadia.utils.RestAssuredUtility;
import arcadia.utils.SeleniumCustomCommand;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

import static arcadia.pages.DefineUpdateCavities.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class UpdateCavitiesStepDefinitions {
    public static int options_to_check;
    public List<String> componentDBList = new ArrayList<>();

    private TestContext context ;

    public UpdateCavitiesStepDefinitions(TestContext context) throws InterruptedException {
        this.context = context;
    }

    @And("Get componentDB name from UpdateCavities form")
    public void getComponentDBNameFromUpdateCavitiesForm() {
        DefineUpdateCavities.getComponentDBNameFromUpdateCavitiesForm();
    }

    @Then("Check componentDB name matches to the UpdateCavities form componentDB name or not")
    public void checkComponentDBNameMatchesToTheUpdateCavitiesFormComponentDBNameOrNot() {
        Assert.assertEquals(actualComponenDB,componentDBList,"Component DB which is available in this instance doest not match with the Update Cavities which is listed in the form");
    }
    @And("Selecting update cavities option")
    public static void  selecting_update_cavities_option() throws InterruptedException {
        DefineUpdateCavities.selectingupdatecavitiesvalue();
    }
    @And("Getting cavities form company name values")
    public static void getting_company_values_cavitiesform(){
        DefineUpdateCavities.gettingallcompanyvalues();
    }
    @And("Getting update cavities form Family,Type,Finish,Material values")
    public static void getting_company_values_update_cavitiesform() throws InterruptedException {
        DefineUpdateCavities.Selecting_familyoverride();
        DefineUpdateCavities.Selecting_typeoverride();
        DefineUpdateCavities.Selecting_finishoverride();
        DefineUpdateCavities.Selecting_materialoverride();
    }
    @And("User selected componentDB from Update cavities form")
    public void userselectedcomponentdbfromupdatcavities() throws InterruptedException{
        String componentDB = System.getProperty("componentDB");
        DefineUpdateCavities.selectcomponentDB(componentDB);
    }

    @And("Getting componentDB company name options")
    public static void gettingcompnentDB_options(){
        DefineUpdateCavities.gettingcompnentDBoptions();
    }

     @And("Getting terminal values from componentDB")
     public static void gettingcomponentDBvalues() throws InterruptedException, JsonProcessingException {DefineUpdateCavities.getTerminalsData();}
    @And("select the wires to be updated")
    public static void select_wires_to_be_updated() throws InterruptedException{
        DefineUpdateCavities.selectwirestobeupdated();
  }
    @Then("Search the Terminal part number csa and od")
    public void search_the_terminal_part_number_csa_and_od() throws InterruptedException, JsonProcessingException {
        if(!DefineUpdateCavities.findtermial)
        {
            System.out.println("1.1");
            DefineUpdateCavities.serachterminalpartnumber();
        } else if (DefineUpdateCavities.findtermial) {
            System.out.println("2.2");
            DefineUpdateCavities.serachterminalpartnumber_csa_od();
        }
    }
    @Then("Check the selected properties")
    public void search_terminal_properties() throws InterruptedException, JsonProcessingException {
        if(options_to_check == 1){DefineUpdateCavities.serachterminal_properties_5();}
        if(options_to_check == 2 || options_to_check == 3 || options_to_check == 4){DefineUpdateCavities.serachterminal_properties_2();}
        if(options_to_check ==5){DefineUpdateCavities.serachterminal_properties_5();}
    }
    @And("user selects the options in the update cavity form {int}")
    public static void  user_selects_option(int options) throws InterruptedException, IOException {
        DefineUpdateCavities.selecting_update_cavitiesform(options);
        options_to_check =options;
    }
    @Then("Checking the Company name as per the componentDB")
    public static void checkcompanyname(){
        Set<String> expectedSet = new HashSet<>(DefineUpdateCavities.actualcompanyname_1);
        Collections.sort(DefineUpdateCavities.actualcompanyname_1);
        Collections.sort(DefineUpdateCavities.actualcompanyname_2);
        System.out.println(DefineUpdateCavities.actualcompanyname_2.size());
        System.out.println(DefineUpdateCavities.actualcompanyname_1);
        System.out.println(DefineUpdateCavities.actualcompanyname_2);
        Assert.assertEquals(DefineUpdateCavities.actualcompanyname_1, DefineUpdateCavities.actualcompanyname_2);
    }

    @Then("Checking The values are matching as per componentDB")
    public static void checkvalues(){
        Collections.sort(actualfinish);
        Collections.sort(actualmaterial);
        Collections.sort(actualfamily);
        componentbmaterial.remove(0);
        componentbfinish.remove(0);
        componentbfamily.remove(0);
        int j=0;
        for(int i =0;i<actualfinish.size();i++) {if (Objects.equals(actualfinish.get(i), "NONE")) {j =i;}}
        actualfinish.remove(j);
        Assert.assertEquals(actualtype, componentbtype,"There is Mismatch in Terminal Type as compared to Selected componentDB");
        Assert.assertEquals(actualmaterial, componentbmaterial,"There is Mismatch in Terminal Material as compared to Selected componentDB");
        Assert.assertEquals(actualfinish, componentbfinish,"There is Mismatch in Terminal Finish as compared to Selected componentDB");
        Assert.assertEquals(actualfamily, componentbfamily,"There is Mismatch in Terminal Family as compared to Selected componentDB\"");
    }

    @Then("Check whether terminal matches to the cavities")
    public static void check_whether_values_matches_to_the_cavities()
    {
        float wirecsa_1 = Float.parseFloat(wirecsa);
        float wireod_1=Float.parseFloat(wireod);
        float ActualwirecsaFrom_1 =Float.parseFloat(DefineUpdateCavities.ActualwirecsaFrom);
        float ActualwirecsaTo_1 =Float.parseFloat(DefineUpdateCavities.ActualwirecsaTo);
        float ActualwireODFrom_1=Float.parseFloat(DefineUpdateCavities.ActualwireODFrom);
        float ActualwireODTo_1=Float.parseFloat(DefineUpdateCavities.ActualwireODTo);
        System.out.println(ActualwireODFrom_1);
        System.out.println(ActualwireODTo_1);
        Assert.assertTrue(wirecsa_1 >= ActualwirecsaFrom_1 && wirecsa_1 <=ActualwirecsaTo_1);
        if(ActualwireODFrom_1 != 0 && ActualwireODTo_1 !=0) {
            Assert.assertTrue(wireod_1 >= ActualwireODFrom_1 && wireod_1 <=ActualwireODTo_1);
        }
    }


    @And("Get the validation and errors")
    public void getTheValidationAndErrors() throws InterruptedException {
        WebElement summary = driver.findElement(By.cssSelector("#ui-accordion-accordion-header-0"));
        summary.click();
        WebElement close = driver.findElement(By.cssSelector("button[onclick='fnDoCancel();']"));
        close.click();
        Thread.sleep(3000);
        WebElement connectorElement = driver.findElement(By.cssSelector("rect[etype='connector'][nodex='144.88']"));
        customCommand.rightClick(driver,connectorElement);
        Thread.sleep(5000);
        WebElement inspect = driver.findElement(By.cssSelector("body > div:nth-child(21) > li:nth-child(1)"));
        inspect.click();
        Thread.sleep(2000);
        WebElement cavityTable = driver.findElement(By.cssSelector("#ui-accordion-accordion-header-4"));
        cavityTable.click();
        Thread.sleep(2000);

    }
    @And("Check the value updated or not in connector properties")
    public void checkTheValueInConnectorProperties() {
        WebElement terminalPartNumber = driver.findElement(By.xpath("//*[@id=\"cavitytable\"]/tbody/tr[1]/td[11]/div/div[1]"));
        System.out.println(terminalPartNumber.getText());
        Assert.assertEquals(terminalPartNumber.getText(),"0-0444334-2","Manual Update cavities is not updating terminal part number");
    }

    @Then("Check the validation without submitting csv")
    public void checkTheValidationWithoutSubmittingCsv() {

        WebElement warningText = driver.findElement(By.cssSelector(".msgBoxContent"));
        Assert.assertEquals(warningText.getText(),"Select CSV file","There is issue in uploading csv in manual Update type");
        WebElement okayButton = driver.findElement(By.cssSelector("input[value='OK']"));
        okayButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @And("Getting componentDB from list")
    public void gettingComponentDBFromList() {
        WebElement body = driver.findElement(By.cssSelector(".box-body"));
        List <WebElement> list = body.findElements(By.cssSelector(".info-box-number"));
        for (WebElement webElement : list) {
            String componentDName = webElement.getText();
            componentDBList.add(componentDName.toLowerCase());
        }
        Collections.sort(componentDBList);
        System.out.println(componentDBList);
    }
}