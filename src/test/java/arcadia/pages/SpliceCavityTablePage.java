package arcadia.pages;

import arcadia.domainobjects.OtherPartsComponentDB;
import arcadia.pages.ComponentDB.OtherParts.OtherPartsComponentDBPage;
import arcadia.utils.RestAssuredUtility;
import arcadia.utils.SeleniumCustomCommand;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class SpliceCavityTablePage extends BasePage {
    @FindBy(css = ".complabel") private WebElement complabel;
    @FindBy(css = ".ignoreClick[data-extlink='false']")private WebElement cavityLabelDetails;
    @FindBy(css = "#ui-accordion-accordion-panel-0 > div:nth-child(3) > input")private WebElement functionDescription;
    @FindBy(css = "button[title=\"Submit\"]") private WebElement buttonSubmitDetails;
    @FindBy(css ="#ui-accordion-accordion-panel-0 > div:nth-child(15) > input")private WebElement partNumberDescription;
    @FindBy(css = "#ui-accordion-accordion-panel-0 > div:nth-child(8) > input.getDetails")private WebElement getPartNumber;
    @FindBy(css="#ui-accordion-accordion-panel-0 > div:nth-child(8) > input.partnumberspec")private WebElement enterPartNumber;
    @FindBy(xpath = "//span[contains(text(),\"Populate\")]") private WebElement populate;
    @FindBy(css=".hyperlink")private WebElement partNumber;
    @FindBy(css =".ignoreClick[text-anchor='start']")private WebElement partNumberDescriptionDrawing;
    @FindBy(css = "#itree")private WebElement leftToggle;
    @FindBy(css="#ui-id-2")private WebElement variantOptions;
    @FindBy(css="#VO > fieldset > p:nth-child(1) > label:nth-child(2) > span > label > span.switch-label")private WebElement variants;
    @FindBy(css ="div[class='dynformrow dynformrow mc overflow'] input[placeholder='Select variants']") private WebElement enterVariants;
    @FindBy(css ="#node_attachpart > tbody > tr > td:nth-child(12) > input")private WebElement attachedPartsPartNUmber;
    @FindBy(css ="#no")private WebElement attachedPartsCheckBox;
    @FindBy(css ="#node_attachpart > tbody > tr > td:nth-child(13) > input")private WebElement getAttachedPartsPartNumberDetails;
    @FindBy(css ="#body > div:nth-child(41)")private WebElement searchWindow;
    @FindBy(css ="#ui-accordion-accordion-panel-0 > div:nth-child(8) > input.getDetails")private WebElement getPartNumberDetails;
    @FindBy(css="#btnFetchAttachPartInfo")private WebElement fetchAttachPartNumber;
    @FindBy(css="#node_attachpart > tbody > tr > td:nth-child(27) > div > div.selectize-input.items.not-full.has-options > input")private WebElement attachPartsVariants;

    public String  testvalue = "automationTest";
    public String splicePartNumber = "JN218-216-M";
    public String splicePartNumberDescription ="SPLICE_JOINT_0.5-2mm2";
    public String attachedParts ="1011-235-0405";
    public SpliceCavityTablePage(WebDriver driver) {
        super(driver);
    }
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    RestAssuredUtility rs;

    public void verifySplicerCavityTableIsVisibleOrNot(String labelName, String visibleHide) throws InterruptedException, JsonProcessingException, AWTException {
        if (visibleHide.equalsIgnoreCase("visible")) {
            switch (labelName.toLowerCase()) {
                case "name" -> {
                    System.out.println(cavityLabelDetails.getText());
                    Assert.assertEquals(cavityLabelDetails.getText(), "SP-001", "Connector Cavity label name is not visible as expected");
                }
                case "functional description" -> {
                    enterFunctionalDescription();
                    System.out.println(complabel.getText());
                    Assert.assertEquals(complabel.getText(), testvalue, "Splice Cavity functional description is not visible as expected");
                }
                case "node description" -> {
                    nodeDescription();
                    System.out.println(complabel.getText());
                    Assert.assertEquals(complabel.getText(), testvalue, "Splice Cavity node description is not visible as expected");
                }
                case "part number" -> {
                    enterPartNumber();
                    System.out.println(partNumber.getText());
                    Assert.assertEquals(partNumber.getText(),splicePartNumber, "Splice Cavity part number is not visible as expected");
                }
                case "part number description" -> {
                    enterPartNumber();
                    System.out.println(partNumberDescriptionDrawing.getText());
                    Assert.assertEquals(partNumberDescriptionDrawing.getText(),splicePartNumberDescription, "Splice Cavity part number description is not visible as expected");
                }
                case "variants" -> {
                    enterVariant();
                    enableVariant();
                    System.out.println(partNumberDescriptionDrawing.getText());
                    Assert.assertEquals(partNumberDescriptionDrawing.getText(),"- BASIC", "Splice Cavity variants is not visible as expected");
                }
                case "attached parts" -> {
                    enterAttachedParts();
                    System.out.println(partNumberDescriptionDrawing.getText());
                    Assert.assertEquals(partNumberDescriptionDrawing.getText(),"1x "+attachedParts,"Splice cavity table attached parts is not visible as expected");
                }
                case "attached parts description" -> {
                    enterAttachedParts();
                    System.out.println(otherPartsAPIData().get(0).getDescription());
                    System.out.println(partNumberDescriptionDrawing.getText());
                    Assert.assertEquals(partNumberDescriptionDrawing.getText(),"1x - "+otherPartsAPIData().get(0).getDescription(),"Splice cavity table attached parts description is not visible as expected");
                }
                case "attached parts variants" -> {
                    enterAttachedPartsVariants();
                    enableVariant();
                    System.out.println(partNumberDescriptionDrawing.getText());
                    Assert.assertEquals(partNumberDescriptionDrawing.getText(),"1x - BASIC","Splice cavity table attached parts variants is not visible as expected");
                }
                case "formboard functional description" -> {
                    System.out.println(complabel.getText());
                    Assert.assertEquals(complabel.getText(), testvalue, "Splice Cavity functional description is not visible as expected");
                }
                case "formboard node description" -> {
                    System.out.println(complabel.getText());
                    Assert.assertEquals(complabel.getText(), testvalue, "Splice Cavity node description is not visible as expected");
                }
                case "formboard part number" -> {
                    System.out.println(partNumber.getText());
                    Assert.assertEquals(partNumber.getText(),splicePartNumber, "Splice Cavity part number is not visible as expected");
                }
                case "formboard part number description" -> {
                    System.out.println(partNumberDescriptionDrawing.getText());
                    Assert.assertEquals(partNumberDescriptionDrawing.getText(),splicePartNumberDescription, "Splice Cavity part number description is not visible as expected");
                }
                case "formboard variants" -> {
                    System.out.println(partNumberDescriptionDrawing.getText());
                    Assert.assertEquals(partNumberDescriptionDrawing.getText(),"- BASIC", "Splice Cavity variants is not visible as expected");
                }
                case "formboard attached parts" -> {
                    System.out.println(partNumberDescriptionDrawing.getText());
                    Assert.assertEquals(partNumberDescriptionDrawing.getText(),"1x "+attachedParts,"Splice cavity table attached parts is not visible as expected");
                }
                case "formboard attached parts description" -> {
                    System.out.println(otherPartsAPIData().get(0).getDescription());
                    System.out.println(partNumberDescriptionDrawing.getText());
                    Assert.assertEquals(partNumberDescriptionDrawing.getText(),"1x - "+otherPartsAPIData().get(0).getDescription(),"Splice cavity table attached parts description is not visible as expected");
                }
                case "formboard attached parts variants" -> {
                    System.out.println(partNumberDescriptionDrawing.getText());
                    Assert.assertEquals(partNumberDescriptionDrawing.getText(),"1x - BASIC","Splice cavity table attached parts variants is not visible as expected");
                }
            }
        }
        else if (visibleHide.equalsIgnoreCase("hide name")) {
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
        else if (visibleHide.equalsIgnoreCase("hide splice details")) {
            try {
                System.out.println("Splice Details:"+ partNumberDescriptionDrawing.getText());
                Assert.fail();
            } catch (org.openqa.selenium.NoSuchElementException e) {
                assert true;
            }
        }
        else if (visibleHide.equalsIgnoreCase("hide splice part number")) {
            try {
                System.out.println("Part number Label:"+ partNumber.getText());
                Assert.fail();
            } catch (org.openqa.selenium.NoSuchElementException e) {
                assert true;
            }
        }
    }
    public void enterFunctionalDescription() throws InterruptedException {
        functionDescription.sendKeys(testvalue);
        customCommand.javaScriptClick(driver,buttonSubmitDetails);
    }
    public void nodeDescription() throws InterruptedException {
        customCommand.clearAndEnterText(partNumberDescription,testvalue);
        customCommand.javaScriptClick(driver,buttonSubmitDetails);
    }
    public void enterPartNumber() throws InterruptedException {
        customCommand.javaScriptClickAndEnterValue(driver,enterPartNumber,splicePartNumber);
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver,buttonSubmitDetails);
    }
    public void enableVariant()
    {
        leftToggle.click();
        variantOptions.click();
        variants.click();
        leftToggle.click();
    }
    public void enterVariant() throws AWTException, InterruptedException {
        enterVariants.click();
        customCommand.pressKey(driver,"down");
        customCommand.pressKey(driver,"enter");
        enterPartNumber();
    }
    public void enterAttachedParts() throws InterruptedException {
        customCommand.javaScriptClickAndEnterValue(driver,enterPartNumber,splicePartNumber);
        customCommand.javaScriptClick(driver,attachedPartsPartNUmber);
        customCommand.javaScriptClickAndEnterValue(driver,attachedPartsPartNUmber,attachedParts);
        getAttachedPartsPartNumberDetails.click();
        customCommand.waitForElementVisibility(driver,searchWindow);
        customCommand.javaScriptClick(driver,fetchAttachPartNumber);
        customCommand.javaScriptClick(driver,populate);
        Thread.sleep(3000);
        attachedPartsCheckBox.click();
        customCommand.javaScriptClick(driver,buttonSubmitDetails);
    }
    public java.util.List<OtherPartsComponentDB> otherPartsAPIData() throws JsonProcessingException {
        rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("otherpart", driver);
        java.util.List<OtherPartsComponentDB> otherpartsdbData =new OtherPartsComponentDBPage(driver).getOtherPartAPIData(response);
        List<OtherPartsComponentDB> expectedPartNumberList = otherpartsdbData.stream().filter(x ->x.getPartnumber().equals(attachedParts)).collect(Collectors.toList());
        return  expectedPartNumberList;
    }
    public void enterAttachedPartsVariants() throws InterruptedException, AWTException {
        customCommand.javaScriptClickAndEnterValue(driver,enterPartNumber,splicePartNumber);
        customCommand.javaScriptClick(driver,attachedPartsPartNUmber);
        customCommand.javaScriptClickAndEnterValue(driver,attachedPartsPartNUmber,attachedParts);
        getAttachedPartsPartNumberDetails.click();
        customCommand.waitForElementVisibility(driver,searchWindow);
        customCommand.javaScriptClick(driver,fetchAttachPartNumber);
        customCommand.javaScriptClick(driver,populate);
        Thread.sleep(3000);
        attachedPartsCheckBox.click();
        customCommand.scrollIntoView(driver,attachPartsVariants);
        customCommand.javaScriptClick(driver,attachPartsVariants);
        customCommand.pressKey(driver,"down");
        customCommand.pressKey(driver,"enter");
        customCommand.javaScriptClick(driver,buttonSubmitDetails);
    }
}