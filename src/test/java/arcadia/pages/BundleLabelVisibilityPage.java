package arcadia.pages;

import arcadia.context.FlowContext;
import arcadia.domainobjects.BundleIdentifier;
import arcadia.domainobjects.ComponentDB;
import arcadia.domainobjects.NodeIdentifier;
import arcadia.domainobjects.OtherPartsComponentDB;
import arcadia.pages.ComponentDB.OtherParts.OtherPartsComponentDBPage;
import arcadia.stepdefinations.BundleStepDefinitions;
import arcadia.utils.RestAssuredUtility;
import arcadia.utils.SeleniumCustomCommand;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BundleLabelVisibilityPage  extends BasePage {
    @FindBy(css = ".complabel") private WebElement complabel;
    @FindBy(css = "div#coveringSearchContainer") private WebElement windowSearchCovering;
    @FindBy(css ="#coveringfilterquick > tbody > tr > td:nth-child(3) > input") private WebElement coveringPartnumberInput;
    @FindBy(css="#btnFetchCoverings")private WebElement fetchCoveringPartnumber;
    @FindBy(css="#previewPieceID")private WebElement pieceIDInput;
    @FindBy(xpath = "//span[contains(text(),\"Populate\")]") private WebElement populate;
    @FindBy(css = ".ignoreClick")private WebElement coveringDetails;
    @FindBy(css ="#btnchkvariant")private WebElement addVariant;
    @FindBy(css = "button[title=\"Submit\"]") private WebElement buttonSubmitDetails;
    @FindBy(css = "#itree")private WebElement leftToggle;
    @FindBy(css="#ui-id-2")private WebElement variantOptions;
    @FindBy(css="#VO > fieldset > p:nth-child(1) > label:nth-child(2) > span > label > span.switch-label")private WebElement variants;
    @FindBy(css = "#layer_85 > g.DG5.bundleGroup")private WebElement layer85;
    @FindBy(css = "#layer_85")private WebElement formboardLayer85;
    String pieceIDValue = "1234";
    String coveringPartNumberValue = "ES2000-NO.3-B9-0-40MM";
    String bundleLengthInch = "5.15";
    String bundleLengthMM = "130.83";
    HarnessPage harnessPage = new HarnessPage(driver);
    private  BundlePage bundlePage;
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();

    public BundleLabelVisibilityPage(WebDriver driver) {
        super(driver);
    }

    public void verifyBundleLabelIsVisibleOrNot(String labelName, String visibleHide) throws InterruptedException, AWTException, JsonProcessingException {
        if (visibleHide.equalsIgnoreCase("visible")) {
            switch (labelName.toLowerCase()) {
                case "name" -> {
                    Assert.assertEquals(complabel.getText(), "BUNDLE1", "Bundle name is not visible as expected");
                    System.out.println(complabel.getText());
                }
                case "length inch" -> {
                    Assert.assertEquals(complabel.getText(), "5.15", "Bundle length is not visible as expected");
                    System.out.println(complabel.getText());
                }
                case "bundle tolerance inch" -> {
                    Assert.assertEquals(complabel.getText(),"5.15 (+/-0.39)","Bundle tolerance is not visible as expected");
                    System.out.println(complabel.getText());
                }
                case "wire bundle diameter inch" ->{
                    Assert.assertEquals(complabel.getText(),"∅0.2\"","Wire bundle diameter is not visible as expected");
                    System.out.println(complabel.getText());
                }
                case "length mm" -> {
                    Assert.assertEquals(complabel.getText(), "130.83", "Bundle length metric is not visible as expected");
                    System.out.println(complabel.getText());
                }
                case "bundle tolerance mm" -> {
                    Assert.assertEquals(complabel.getText(),"130.83 (+/-10)","Bundle tolerance metric is not visible as expected");
                    System.out.println(complabel.getText());
                }
                case "wire bundle diameter mm" ->{
                    Assert.assertEquals(complabel.getText(),"∅5.2mm","Wire bundle diameter metric is not visible as expected");
                    System.out.println(complabel.getText());
                }
                case "bundle pieceid" ->{
                    addCovering();
                    System.out.println(coveringDetails.getText());
                    Assert.assertEquals(coveringDetails.getText(),pieceIDValue,"Bundle Piece ID is not visible as expected");
                }
                case "bundle piece id length mm" ->{
                    addCovering();
                    System.out.println(coveringDetails.getText());
                    Assert.assertEquals(coveringDetails.getText(),"130.83mm","Bundle Piece length in metric task is not visible as expected");
                }
                case "bundle piece id length inch" ->{
                    addCovering();
                    System.out.println(coveringDetails.getText());
                    Assert.assertEquals(coveringDetails.getText(),"5.15\"","Bundle Piece length in imperial is not visible as expected");
                }
                case "bundle covering pn" -> {
                    addCovering();
                    System.out.println(coveringDetails.getText());
                    Assert.assertEquals(coveringDetails.getText(),coveringPartNumberValue,"Bundle covering part number is not visible as expected");
                }
                case "bundle covering partdescription" -> {
                    addCovering();
                    Assert.assertEquals(coveringDetails.getText(),"HEATSHRINK_ES2000_40mm_NATURAL","Bundle covering part description is not visible as expected");
                }
                case "bundle covering part variant" ->{
                    addCovering();
                    inspectBundle();
                    addVariant();
                    enableVariant();
                    System.out.println(coveringDetails.getText());
                    Assert.assertEquals(coveringDetails.getText(),"BASIC","Covering attach variant is not visible as expected");
                }
                case "bundle covering length mm" ->{
                    addCovering();
                    System.out.println(coveringDetails.getText());
                    Assert.assertEquals(coveringDetails.getText(),"130.83","Covering attach length is not visible as expected");
                }
                case "bundle covering length inch" ->{
                    addCovering();
                    System.out.println(coveringDetails.getText());
                    Assert.assertEquals(coveringDetails.getText(),"5.15","Covering attach length is not visible as expected");
                }
                case "bundle inch" ->{
                    addCovering();
                    inspectBundle();
                    addVariant();
                    enableVariant();
                    System.out.println(layer85.getText().replaceAll("\\s+", ""));
                    Assert.assertEquals(layer85.getText().replaceAll("\\s+", ""), "BUNDLE1"+bundleLengthInch+"∅0\"(+/-0.39)HEATSHRINK_ES2000_40mm_NATURAL-"+coveringPartNumberValue+"-"+bundleLengthInch+pieceIDValue+"-"+bundleLengthInch+"\"-BASIC","all bundle label values are not visible as expected in imperial task");
                }
                case "bundle mm" ->{
                    addCovering();
                    inspectBundle();
                    addVariant();
                    enableVariant();
                    System.out.println(layer85.getText().replaceAll("\\s+", ""));
                    Assert.assertEquals(layer85.getText().replaceAll("\\s+", ""),"BUNDLE1"+bundleLengthMM+"∅0mm(+/-10)HEATSHRINK_ES2000_40mm_NATURAL-"+coveringPartNumberValue+"-"+bundleLengthMM+pieceIDValue+"-"+bundleLengthMM+"mm-BASIC","all bundle label values are not visible as expected in imperial task");
                }
                case "formboard bundle pieceid" ->{
                    System.out.println(coveringDetails.getText());
                    Assert.assertEquals(coveringDetails.getText(),pieceIDValue,"Bundle Piece ID is not visible as expected in formboard");
                }
                case "formboard bundle piece id length mm" ->{
                    System.out.println(coveringDetails.getText());
                    Assert.assertEquals(coveringDetails.getText(),"130.83","Bundle Piece length in metric task is not visible as expected");
                }
                case "formboard bundle piece id length inch" ->{
                    System.out.println(coveringDetails.getText());
                    Assert.assertEquals(coveringDetails.getText(),"5.15","Bundle Piece length in imperial is not visible as expected");
                }
                case "formboard bundle covering pn" -> {
                    System.out.println(coveringDetails.getText());
                    Assert.assertEquals(coveringDetails.getText(),coveringPartNumberValue,"Bundle covering part number is not visible as expected");
                }
                case "formboard bundle covering partdescription" -> {
                    Assert.assertEquals(coveringDetails.getText(),"HEATSHRINK_ES2000_40mm_NATURAL","Bundle covering part description is not visible as expected");
                }
                case "formboard bundle covering part variant" ->{
                    System.out.println(coveringDetails.getText());
                    Assert.assertEquals(coveringDetails.getText(),"BASIC","Covering attach variant is not visible as expected");
                }
                case "formboard bundle covering length mm" ->{
                    System.out.println(coveringDetails.getText());
                    Assert.assertEquals(coveringDetails.getText(),"130.83","Covering attach length is not visible as expected");
                }
                case "formboard bundle covering length inch" ->{
                    System.out.println(coveringDetails.getText());
                    Assert.assertEquals(coveringDetails.getText(),"5.15","Covering attach length is not visible as expected");
                }
                case "formboard inch" ->{
                    System.out.println(formboardLayer85.getText().replaceAll("\\s+", ""));
                    Assert.assertEquals(formboardLayer85.getText().replaceAll("\\s+", ""), "BUNDLE1"+bundleLengthInch+"∅0\"(+/-0.39)HEATSHRINK_ES2000_40mm_NATURAL-"+coveringPartNumberValue+"-"+bundleLengthInch+pieceIDValue+"-"+bundleLengthInch+"\"-BASIC","all bundle label values are not visible as expected in imperial task");
                }
                case "formboard mm" ->{
                    System.out.println(formboardLayer85.getText().replaceAll("\\s+", ""));
                    Assert.assertEquals(formboardLayer85.getText().replaceAll("\\s+", ""),"BUNDLE1"+bundleLengthMM+"∅0mm(+/-10)HEATSHRINK_ES2000_40mm_NATURAL-"+coveringPartNumberValue+"-"+bundleLengthMM+pieceIDValue+"-"+bundleLengthMM+"mm-BASIC","all bundle label values are not visible as expected in imperial task");
                }
            }
        }
        else if (visibleHide.equalsIgnoreCase("hide")){
            try {
                System.out.println("Component Label :"+ complabel.getText());
                Assert.fail();
            } catch (org.openqa.selenium.NoSuchElementException e) {
                assert true;
            }
        }
        else if (visibleHide.equalsIgnoreCase("hide covering details")){
            try {
                System.out.println("Covering Details:"+ coveringDetails.getText());
                Assert.fail();
            } catch (org.openqa.selenium.NoSuchElementException e) {
                assert true;
            }
        } else if (visibleHide.equalsIgnoreCase("hide all details")) {
            System.out.println("Bundle details :"+ layer85.getText());
            if (Objects.equals(layer85.getText(), "")) {
                assert true;
            }else {
                Assert.fail();
            }
        }
        else if (visibleHide.equalsIgnoreCase("formboard hide all details")) {
            System.out.println("Bundle details :"+ formboardLayer85.getText());
            if (Objects.equals(formboardLayer85.getText(), "")) {
                assert true;
            }else {
                Assert.fail();
            }
        }
    }
    public void addCovering () throws InterruptedException {
        customCommand.waitForElementVisibility(driver,windowSearchCovering);
        Assert.assertTrue(windowSearchCovering.isDisplayed(),"Window to search covering is not displayed");
        customCommand.waitForElementToBeClickable(driver,coveringPartnumberInput);
        customCommand.javaScriptClickAndEnterValue(driver,coveringPartnumberInput,coveringPartNumberValue);
        customCommand.javaScriptClick(driver,fetchCoveringPartnumber);
        customCommand.javaScriptClickAndEnterValue(driver,pieceIDInput,pieceIDValue);
        customCommand.javaScriptClick(driver,populate);
    }
    public void enableVariant()
    {
        leftToggle.click();
        variantOptions.click();
        variants.click();
        leftToggle.click();
    }
    public void inspectBundle() throws InterruptedException {
        String identifier = FlowContext.bundleIdentifierList.get(0).getBundleId();
        harnessPage.getNodeContextMenu(identifier);
        new HarnessPage(driver).performOperation("inspect",identifier);
    }
    public void addVariant() throws InterruptedException {
        customCommand.javaScriptClick(driver,addVariant);
        Select selectVariant  =new Select(driver.findElement(By.cssSelector("select[name='variants']")));
        selectVariant.selectByValue("BASIC");
        customCommand.waitForElementVisibility(driver,buttonSubmitDetails);
        customCommand.javaScriptClick(driver,buttonSubmitDetails);
    }

}
