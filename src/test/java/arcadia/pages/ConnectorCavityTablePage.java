package arcadia.pages;

import arcadia.domainobjects.ConnectorDB;
import arcadia.pages.ComponentDB.Connectors.ConnectorsDBPage;
import arcadia.utils.RestAssuredUtility;
import arcadia.utils.SeleniumCustomCommand;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class ConnectorCavityTablePage extends BasePage {
    @FindBy(css = ".complabel") private WebElement complabel;
    @FindBy(css = ".ignoreClick[data-extlink='false']")private WebElement cavityLabelDetails;
    @FindBy(css="#ui-accordion-accordion-panel-0 > div:nth-child(3) > input")private WebElement connectorDescription;
    @FindBy(css = "button[title=\"Submit\"]") private WebElement buttonSubmitDetails;
    @FindBy(css=".hyperlink")private WebElement partNumber;
    @FindBy(css =".ignoreClick[text-anchor='start']")private WebElement partNumberDescription;
    @FindBy(css="#ui-id-2")private WebElement variantOptions;
    @FindBy(css="#VO > fieldset > p:nth-child(1) > label:nth-child(2) > span > label > span.switch-label")private WebElement variants;
    @FindBy(css = "#itree")private WebElement leftToggle;
    @FindBy(css = "#ui-accordion-accordion-panel-0 > div:nth-child(28) > div > div.selectize-input.items.not-full.has-options > input")private WebElement connectorVariantOptions;
    @FindBy(css="#node_attachpart > tbody > tr:nth-child(1) > td:nth-child(27) > div > div.selectize-input.items.not-full.has-options > input")private WebElement connectorAttachPartVariants;
    @FindBy(css="#ui-accordion-accordion-header-4")private WebElement cavityTable;
    @FindBy(css= "#no")private WebElement attachPartsConnectorCheckBox;
    @FindBy(xpath="//tbody/tr[@class='used']/td[11]/div[1]/div[1]")private WebElement terminalPN;
    @FindBy(xpath="//*[@id=\"cavitytable\"]/tbody/tr[1]/td[23]/div/div[1]/input")private WebElement sealPN;
    @FindBy(xpath="//*[@id=\"cavitytable\"]/tbody/tr[1]/td[26]/div/div[1]/input")private WebElement plugPN;
    @FindBy(xpath = "//table[@id='cavitytable']//input[@class='addRow']") WebElement addRowCavity;
    @FindBy(css ="#ui-accordion-accordion-panel-0 > div:nth-child(26) > div > div.selectize-input.items.not-full > input")private WebElement conGroupID;
    @FindBy(css ="#ui-accordion-accordion-panel-0 > div:nth-child(23) > select")private WebElement terminalImageDisplay;

    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    String testvalue = "AutomationTest";
    String connectorPartNumber = "FFH04142BK*T";
    String partDescription ="FCI_FIN LOCK_4-WAY_RECEP HSG";

    public ConnectorCavityTablePage(WebDriver driver) {
        super(driver);
    }

    public void verifyConnectorCavityTableIsVisibleOrNot(String labelName, String visibleHide) throws InterruptedException, JsonProcessingException, AWTException {
        if (visibleHide.equalsIgnoreCase("visible")) {
            switch (labelName.toLowerCase()) {
                case "name" -> {
                    System.out.println(cavityLabelDetails.getText());
                    Assert.assertEquals(cavityLabelDetails.getText(), "X-001", "Connector Cavity label name is not visible as expected");
                }
                case "functional description" -> {
                    enterFunctionalDescription();
                    System.out.println(complabel.getText());
                    Assert.assertEquals(complabel.getText(), testvalue, "Connector Cavity functional description is not visible as expected");
                }
                case "node description" -> {
                    System.out.println(complabel.getText());
                    Assert.assertEquals(complabel.getText(), partDescription, "Connector Cavity node description is not visible as expected");
                }
                case "part number" ->{
                    System.out.println(partNumber.getText());
                    Assert.assertEquals(partNumber.getText(),connectorPartNumber,"Connector cavity part number is not visible as expected");
                }
                case "part number description" ->{
                    System.out.println(partNumberDescription.getText());
                    Assert.assertEquals(partNumberDescription.getText(),partDescription,"Connector cavity part description is not visible as expected");
                }
                case "company name" ->{
                    System.out.println(partNumberDescription.getText());
                    System.out.println(connectorAPIData().get(0).getSupplier());
                    Assert.assertEquals(partNumberDescription.getText(),connectorAPIData().get(0).getSupplier(),"Connector cavity company name is not visible as expected");
                }
                case "variants" ->{
                    enterVariant();
                    enableVariant();
                    System.out.println(partNumberDescription.getText());
                    Assert.assertEquals(partNumberDescription.getText(),"- BASIC","Connector cavity table variants is not visible as expected");
                }
                case "attach parts" ->{
                    attachPartsConnectorCheckBox.click();
                    customCommand.javaScriptClick(driver,buttonSubmitDetails);
                    System.out.println(partNumberDescription.getText());
                    Assert.assertEquals(partNumberDescription.getText(),"1x 15-117-103","Connector cavity table attach parts is not visible as expected");
                }
                case "attach parts description" ->{
                    attachPartsConnectorCheckBox.click();
                    customCommand.javaScriptClick(driver,buttonSubmitDetails);
                    System.out.println(partNumberDescription.getText());
                    Assert.assertEquals(partNumberDescription.getText(),"1x - COVER- WIRING CONNECTOR","Connector cavity table attach parts description is not visible as expected");
                }
                case "attach parts variants" ->{
                    attachPartsConnectorCheckBox.click();
                    customCommand.scrollIntoView(driver,connectorAttachPartVariants);
                    connectorAttachPartVariants.click();
                    customCommand.pressKey(driver,"down");
                    customCommand.simulateKeyEnter();
                    customCommand.javaScriptClick(driver,buttonSubmitDetails);
                    enableVariant();
                    System.out.println(partNumberDescription.getText());
                    Assert.assertEquals(partNumberDescription.getText(),"1x - BASIC","Connector cavity table attach parts variants is not visible as expected");
                }
                case "terminal" ->
                {
                    addCavity();
                    enterTerminalPartNumber();
                    customCommand.waitForElementVisibility(driver,partNumber);
                    System.out.println(partNumber.getText());
                    Assert.assertEquals(partNumber.getText(),"0-0444335-2","Terminal part number is not visible as expected");
                }
                case "terminal description" ->
                {
                    addCavity();
                    enterTerminalPartNumber();
                    System.out.println(partNumberDescription.getText());
                    Assert.assertEquals(partNumberDescription.getText(),"1x - FASTON .250 UNINSULATED RECEP TERMINAL","Terminal part description is not visible as expected");
                }
                case "seal part number" ->
                {
                    addCavity();
                    customCommand.scrollIntoView(driver,plugPN);
                    plugPN.click();
                    plugPN.sendKeys("15324980");
                    customCommand.pressKey(driver,"enter");
                    Thread.sleep(2000);
                    customCommand.javaScriptClick(driver,buttonSubmitDetails);
                    System.out.println(partNumber.getText());
                    Assert.assertEquals(partNumber.getText(),"15324980","Plug part number is not visible as expected");
                }
                case "seal part number description" ->
                {
                    addCavity();
                    customCommand.scrollIntoView(driver,sealPN);
                    sealPN.click();
                    sealPN.sendKeys("15324980");
                    customCommand.pressKey(driver,"enter");
                    Thread.sleep(2000);
                    customCommand.javaScriptClick(driver,buttonSubmitDetails);
                    System.out.println(partNumberDescription.getText());
                    Assert.assertEquals(partNumberDescription.getText(),"1x - CAVITY SEAL_METRI-PACK_2.81-3.49mm_GRAY","Seal part number description is not visible as expected");
                }
                case "plug part number" ->
                {
                    addCavity();
                    customCommand.scrollIntoView(driver,plugPN);
                    plugPN.click();
                    plugPN.sendKeys("15324980");
                    customCommand.pressKey(driver,"enter");
                    Thread.sleep(2000);
                    customCommand.javaScriptClick(driver,buttonSubmitDetails);
                    System.out.println(partNumber.getText());
                    Assert.assertEquals(partNumber.getText(),"15324980","plug part number is not visible as expected");
                }
                case "plug part number description" ->
                {
                    addCavity();
                    customCommand.scrollIntoView(driver,sealPN);
                    sealPN.click();
                    sealPN.sendKeys("15324980");
                    customCommand.pressKey(driver,"enter");
                    Thread.sleep(2000);
                    customCommand.javaScriptClick(driver,buttonSubmitDetails);
                    System.out.println(partNumberDescription.getText());
                    Assert.assertEquals(partNumberDescription.getText()," ","plug part number description is not visible as expected");
                }
                case "connector group id" -> {
                   conGroupID.click();
                   conGroupID.sendKeys("ABC");
                   customCommand.pressKey(driver,"enter");
                   customCommand.javaScriptClick(driver,buttonSubmitDetails);
                   System.out.println(complabel.getText());
                   Assert.assertEquals(complabel.getText(),"ABC","Connector group id is not visible as expected");
                }
                case "terminal image quantity" ->{
                    new Select(terminalImageDisplay).selectByVisibleText("Yes");
                    addCavity();
                    enterTerminalPartNumber();
                    System.out.println(complabel.getText());
                    Assert.assertEquals(complabel.getText(),"1 x","Terminal image quantity is not visible as expected ");
                }
                case "terminal image part number" ->{
                    new Select(terminalImageDisplay).selectByVisibleText("Yes");
                    addCavity();
                    enterTerminalPartNumber();
                    System.out.println(partNumber.getText());
                    Assert.assertEquals(partNumber.getText(),"0-0444335-2","Terminal image part number is not visible as expected");
                }
                case "formboard functional description" -> {
                    System.out.println(complabel.getText());
                    Assert.assertEquals(complabel.getText(), testvalue, "Connector Cavity functional description is not visible as expected");
                }
                case "formboard variants" ->{
                    System.out.println(partNumberDescription.getText());
                    Assert.assertEquals(partNumberDescription.getText(),"- BASIC","Connector cavity table variants is not visible as expected");
                }
                case "formboard attach parts" ->{
                    System.out.println(partNumberDescription.getText());
                    Assert.assertEquals(partNumberDescription.getText(),"1x 15-117-103","Connector cavity table attach parts is not visible as expected");
                }
                case "formboard attach parts description" ->{
                    System.out.println(partNumberDescription.getText());
                    Assert.assertEquals(partNumberDescription.getText(),"1x - COVER- WIRING CONNECTOR","Connector cavity table attach parts description is not visible as expected");
                }
                case "formboard attach parts variants" ->{
                    System.out.println(partNumberDescription.getText());
                    Assert.assertEquals(partNumberDescription.getText(),"1x - BASIC","Connector cavity table attach parts variants is not visible as expected");
                }
                case "formboard terminal" ->
                {
                    System.out.println(partNumber.getText());
                    Assert.assertEquals(partNumber.getText(),"0-0444335-2","Terminal part number is not visible as expected");
                }
                case "formboard terminal description" ->
                {
                    System.out.println(partNumberDescription.getText());
                    Assert.assertEquals(partNumberDescription.getText(),"1x - FASTON .250 UNINSULATED RECEP TERMINAL","Terminal part description is not visible as expected");
                }
                case "formboard seal part number" ->
                {
                    System.out.println(partNumber.getText());
                    Assert.assertEquals(partNumber.getText(),"15324980","Plug part number is not visible as expected");
                }
                case "formboard seal part number description" ->
                {
                    System.out.println(partNumberDescription.getText());
                    Assert.assertEquals(partNumberDescription.getText(),"1x - CAVITY SEAL_METRI-PACK_2.81-3.49mm_GRAY","Seal part number description is not visible as expected");
                }
                case "formboard plug part number" ->
                {
                    System.out.println(partNumber.getText());
                    Assert.assertEquals(partNumber.getText(),"15324980","plug part number is not visible as expected");
                }
                case "formboard plug part number description" ->
                {
                    System.out.println(partNumberDescription.getText());
                    Assert.assertEquals(partNumberDescription.getText()," ","plug part number description is not visible as expected");
                }
                case "formboard connector group id" -> {
                    System.out.println(complabel.getText());
                    Assert.assertEquals(complabel.getText(),"ABC","Connector group id is not visible as expected");
                }
                case "formboard terminal image quantity" ->{
                    System.out.println(complabel.getText());
                    Assert.assertEquals(complabel.getText(),"1 x","Terminal image quantity is not visible as expected ");
                }
                case "formboard terminal image part number" ->{
                    System.out.println(partNumber.getText());
                    Assert.assertEquals(partNumber.getText(),"0-0444335-2","Terminal image part number is not visible as expected");
                }
                }
        } else if (visibleHide.equalsIgnoreCase("hide name")) {
            try {
                System.out.println("Name :"+ cavityLabelDetails.getText());
                Assert.fail();
            } catch (org.openqa.selenium.NoSuchElementException e) {
                assert true;
            }
        }
        else if (visibleHide.equalsIgnoreCase("hide component label")) {
            try {
                System.out.println("Component Label :"+ complabel.getText());
                Assert.fail();
            } catch (org.openqa.selenium.NoSuchElementException e) {
                assert true;
            }
        }
        else if (visibleHide.equalsIgnoreCase("hide part number")) {
            try {
                System.out.println("Part number Label :"+ partNumber.getText());
                Assert.fail();
            } catch (org.openqa.selenium.NoSuchElementException e) {
                assert true;
            }
        }
        else if (visibleHide.equalsIgnoreCase("hide part description")) {
            try {
                System.out.println("Description Label :"+ partNumberDescription.getText());
                Assert.fail();
            } catch (org.openqa.selenium.NoSuchElementException e) {
                assert true;
            }
        }
    }

    public void enterFunctionalDescription() throws InterruptedException {
        connectorDescription.sendKeys(testvalue);
        customCommand.javaScriptClick(driver,buttonSubmitDetails);
    }
    public List<ConnectorDB> connectorAPIData() throws JsonProcessingException {
        RestAssuredUtility rs;
        rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("connector", driver);
        List<ConnectorDB> otherPartsDBData =new ConnectorsDBPage(driver).getConnectorsAPIData(response);
        return otherPartsDBData.stream().filter(x ->x.getPartnumber().equals(connectorPartNumber)).collect(Collectors.toList());
    }
    public void enableVariant()
    {
        leftToggle.click();
        variantOptions.click();
        variants.click();
        leftToggle.click();
    }
    public void enterVariant() throws InterruptedException, AWTException {
        connectorVariantOptions.click();
        customCommand.pressKey(driver,"down");
        customCommand.simulateKeyEnter();
        customCommand.javaScriptClick(driver,buttonSubmitDetails);
    }
    public void addCavity() throws InterruptedException {
        cavityTable.click();
        customCommand.javaScriptClick(driver,addRowCavity);
    }
    public void enterTerminalPartNumber() throws AWTException, InterruptedException {
        terminalPN.click();
        customCommand.pressKey(driver,"down");
        customCommand.pressKey(driver,"enter");
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver,buttonSubmitDetails);
    }

}
