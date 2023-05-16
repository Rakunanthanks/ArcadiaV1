package arcadia.pages;

import arcadia.context.FlowContext;
import arcadia.domainobjects.OtherPartsComponentDB;
import arcadia.pages.ComponentDB.OtherParts.OtherPartsComponentDBPage;
import arcadia.utils.RestAssuredUtility;
import arcadia.utils.SeleniumCustomCommand;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.jna.platform.win32.WinCrypt;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NodeLabelVisibilityPage extends BasePage {

    @FindBy(css = ".complabel") private WebElement complabel;
    @FindBy(css="input[name='node.functiondescription']")private WebElement functionalDescription;
    @FindBy(css = "button[title=\"Submit\"]") private WebElement buttonSubmitDetails;
    @FindBy(xpath="//span[normalize-space()='Other Parts']")private WebElement otherParts;
    @FindBy(css="#Attachfilters > tbody > tr > td:nth-child(3) > input")private WebElement otherPartNumber;
    @FindBy(xpath = "//span[contains(text(),\"Populate\")]") private WebElement populate;
    @FindBy(css = "#btnFetchAttachPartInfo")private WebElement getDetails;
    @FindBy(css=".hyperlink")private WebElement attachParts;
    @FindBy(css = "#layer_85 > g > g:nth-child(1) > text")private WebElement attachPartsDetails;
    @FindBy(xpath = "//*[@id=\"node_attachpart\"]/tbody/tr[1]/td[29]/div/div[1]/input")private WebElement nodeVariants;
    @FindBy(css = "input[name=\"node.attachpart.partname\"]")private WebElement attachPartName;
    @FindBy(css="#ui-id-2")private WebElement variantOptions;
    @FindBy(css="#VO > fieldset > p:nth-child(1) > label:nth-child(2) > span > label > span.switch-label")private WebElement variants;
    @FindBy(css = "#itree")private WebElement leftToggle;
    @FindBy(css = "#layer_85 > g")private WebElement layer85;
    @FindBy(css = "input#nodeshow") private WebElement buttonShowNode;
    @FindBy(css="button[value='Save']")private WebElement profileSaveButton;
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    public String otherPartNumberValue = "12020807";
    public String testValue = "AutomationTest";
    RestAssuredUtility rs;
    public NodeLabelVisibilityPage(WebDriver driver) {
        super(driver);
    }

    HarnessPage harnessPage = new HarnessPage(driver);

    public void verifyNodeChildElementLabelIsVisibleOrNot() {
        Assert.assertEquals(complabel.getText(), "X-001", "Node Child Element is not Visible as expected");
        System.out.println(complabel.getText());
    }

    public void placeNode(String nodeCommand) throws InterruptedException, AWTException {
        harnessPage.waitForHarnessPage();
        harnessPage.clickOnNode();
        harnessPage.fillCommandLine(nodeCommand);
        harnessPage.clickOnCommandLineOK();
        harnessPage.waitBetweenHarnessActions();
    }

    public void placeNodeInTheHarness() {


    }

    public void verifyNodeChildElementLabelIsHiddenOrNot() {
        try {
            System.out.println("Component Label :"+ complabel.getText());
            assert false;
        } catch (org.openqa.selenium.NoSuchElementException e) {
           assert true;
        }
    }

    public void verifyNodeChildNameLabelIsVisibleOrNot() {
        Assert.assertEquals(complabel.getText(), "NODE1", "Node name is not Visible as expected");
        System.out.println(complabel.getText());
    }

    public void verifyNodeChildNameLabelIsHiddenOrNot() {
        try {
            System.out.println("Component Label :"+ complabel.getText());
            assert false;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            assert true;
        }
    }

    public void verifyNodeLabelIsVisibleOrNot(String labelname,String visibileHide) throws InterruptedException, AWTException, JsonProcessingException {
       if(visibileHide.equalsIgnoreCase("visible")) {
           switch (labelname.toLowerCase()) {
               case "child element": {
                   Assert.assertEquals(complabel.getText(), "X-001", "Node child element is not Visible as expected");
                   System.out.println(complabel.getText());
                   break;
               }
               case "name": {
                   Assert.assertEquals(complabel.getText(), "NODE1", "Node name is not Visible as expected");
                   System.out.println(complabel.getText());
                   break;
               }
               case "functional description": {
                   System.out.println(FlowContext.nodeIdentifierList.get(0).getNodeElementId());
                   String identifier = FlowContext.nodeIdentifierList.get(0).getNodeElementId();
                   harnessPage.getNodeContextMenu(identifier);
                   new HarnessPage(driver).performOperation("inspect",identifier);
                   customCommand.clearAndEnterText(functionalDescription,"Automation Test");
                   customCommand.javaScriptClick(driver,buttonSubmitDetails);
                   Assert.assertEquals(complabel.getText(), testValue, "Functional description is not Visible as expected");
                   System.out.println(complabel.getText());
                   break;
               }
               case "attached parts": {
                   linkOtherParts();
                   customCommand.javaScriptClick(driver,buttonSubmitDetails);
                   customCommand.waitForElementVisibility(driver,attachParts);
                   System.out.println(attachParts.getText());
                   Assert.assertEquals(attachParts.getText(), "1x  "+otherPartNumberValue, "Attach parts label is not Visible as expected");
                   break;
               }
               case "attached parts name": {
                   linkOtherParts();
                   String identifier = FlowContext.nodeIdentifierList.get(0).getNodeElementId();
                   harnessPage.getNodeContextMenu(identifier);
                   new HarnessPage(driver).performOperation("inspect",identifier);
                   customCommand.waitForElementVisibility(driver,attachPartName);
                   customCommand.javaScriptClickAndEnterValue(driver,attachPartName,testValue);
                   customCommand.javaScriptClick(driver,buttonSubmitDetails);
                   System.out.println(complabel.getText());
                   Assert.assertEquals(complabel.getText(),testValue,"Attach parts name comp label is not as expected");
               }
               case "attached parts description": {
                   linkOtherParts();
                   Assert.assertEquals(attachPartsDetails.getText(),"1x - "+otherPartsAPIData().get(0).getDescription(),"Attach parts description is not as expected");
                   break;
               }
               case "attached parts variants": {
                   linkOtherParts();
                   leftToggle.click();
                   variantOptions.click();
                   variants.click();
                   leftToggle.click();
                   String identifier = FlowContext.nodeIdentifierList.get(0).getNodeElementId();
                   harnessPage.getNodeContextMenu(identifier);
                   new HarnessPage(driver).performOperation("inspect",identifier);
                   customCommand.scrollIntoView(driver,nodeVariants);
                   nodeVariants.click();
                   Thread.sleep(2000);
                   customCommand.pressKey(driver,"down");
                   customCommand.pressKey(driver,"enter");
                   customCommand.javaScriptClick(driver,buttonSubmitDetails);
                   Assert.assertEquals(attachPartsDetails.getText(),"1x - BASIC","Attach parts variants is not displaying as expected");
                   break;
               }
               case "all node option visibility":{
                   userEnterPossibleNodeValuesForLabelVisibility();
                   customCommand.waitForElementVisibility(driver,layer85);
                   String description = otherPartsAPIData().get(0).getDescription().replaceAll("\\s+", "");
                   System.out.println("NODE1"+testValue+"1x"+otherPartNumberValue+"-"+otherPartsAPIData().get(0).getDescription()+"-BASIC"+testValue);
                   Assert.assertEquals(layer85.getText().replaceAll("\\s+", ""),"NODE1"+testValue+"1x"+otherPartNumberValue+"-"+description+"-BASIC"+testValue,"By enabling all values to show is not visible as expected");
               }
               case "all node option hide":{
                   userEnterPossibleNodeValuesForLabelVisibility();
                   Assert.assertEquals(layer85.getText().replaceAll("\\s+", ""),"","By enabling all values to show is not visible as expected");
               }
           }
       } else if (visibileHide.equalsIgnoreCase("hide")){
           try {
               System.out.println("Component Label :"+ complabel.getText());
               Assert.fail();
           } catch (org.openqa.selenium.NoSuchElementException e) {
               assert true;
           }
       } else if (visibileHide.equalsIgnoreCase("hide attached parts")) {
           try {
               System.out.println("Attached part Label :"+ attachParts.getText());
               Assert.fail();
           } catch (org.openqa.selenium.NoSuchElementException e) {
              assert true;
           }
       } else if (visibileHide.equalsIgnoreCase("hide attached parts details")) {
           try {
               System.out.println("Attached part Description Label :"+ attachPartsDetails.getText());
               Assert.fail();
           } catch (org.openqa.selenium.NoSuchElementException e) {
               assert true;
           }
       } else if (visibileHide.equalsIgnoreCase("hide all node details")) {
               System.out.println("Node all details :"+ layer85.getText());
               if (Objects.equals(layer85.getText(), "")) {
                  assert true;
               }else {
                   Assert.fail();
               }
       }
    }
    public void linkOtherParts() throws InterruptedException {
        String identifier = FlowContext.nodeIdentifierList.get(0).getNodeElementId();
        harnessPage.getNodeContextMenu(identifier);
        new HarnessPage(driver).performOperation("link parts",identifier);
        customCommand.waitForElementToBeClickable(driver,otherParts);
        otherParts.click();
        customCommand.waitForElementVisibility(driver,otherPartNumber);
        customCommand.javaScriptClickAndEnterValue(driver,otherPartNumber,otherPartNumberValue);
        customCommand.waitForElementVisibility(driver,otherPartNumber);
        customCommand.javaScriptClick(driver,getDetails);
        customCommand.javaScriptClick(driver,populate);
        customCommand.waitForElementVisibility(driver,buttonSubmitDetails);
        customCommand.javaScriptClick(driver,buttonSubmitDetails);
    }
    public List<OtherPartsComponentDB> otherPartsAPIData() throws JsonProcessingException {
        rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("otherpart", driver);
        List<OtherPartsComponentDB> otherpartsdbData =new OtherPartsComponentDBPage(driver).getOtherPartAPIData(response);
        List<OtherPartsComponentDB> expectedPartNumberList = otherpartsdbData.stream().filter(x ->x.getPartnumber().equals(otherPartNumberValue)).collect(Collectors.toList());
        return  expectedPartNumberList;
    }

    public void userSetsLabelInProfileNodeToShow(String labelName, String showHide) throws InterruptedException {
        customCommand.waitForElementVisibility(driver,buttonShowNode);
        switch (labelName.toLowerCase()) {
            case "node":
                if (showHide.equalsIgnoreCase("show")) {
                    driver.findElement(By.cssSelector("input#nodeshow")).click();
                } else {
                    driver.findElement(By.cssSelector("input#nodehide")).click();
                }
                break;
        }
        customCommand.scrollIntoView(driver,profileSaveButton);
        customCommand.javaScriptClick(driver,profileSaveButton);
    }

    public void userEnterPossibleNodeValuesForLabelVisibility() throws InterruptedException, AWTException {
        linkOtherParts();
        String identifier = FlowContext.nodeIdentifierList.get(0).getNodeElementId();
        harnessPage.getNodeContextMenu(identifier);
        new HarnessPage(driver).performOperation("inspect",identifier);
        customCommand.clearAndEnterText(functionalDescription,testValue);
        customCommand.waitForElementVisibility(driver,attachPartName);
        customCommand.javaScriptClickAndEnterValue(driver,attachPartName,testValue);
        customCommand.scrollIntoView(driver,nodeVariants);
        nodeVariants.click();
        Thread.sleep(2000);
        customCommand.pressKey(driver,"down");
        customCommand.pressKey(driver,"enter");
        customCommand.javaScriptClick(driver,buttonSubmitDetails);
        leftToggle.click();
        variantOptions.click();
        variants.click();
        leftToggle.click();
    }
}
