package arcadia.stepdefinations;

import arcadia.constants.EndPoint;
import arcadia.context.FlowContext;
import arcadia.pages.ComponentDB.CommonElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import arcadia.pages.DefineBundleTolerance;
import io.cucumber.java.hu.De;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.print.PrintOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static arcadia.pages.BasePage.driver;
import static arcadia.stepdefinations.HarnessStepDefinitions.getHarnessDescription;


public class BundleToleranceStepDefinition {
    static String lengthRangeOneTo;
    static String lowerToleranceOne;
    static String lengthRangeTwoFrom;
    static String lengthRangeTwoTo;
    static String lowerToleranceTwo;
    static String upperToleranceTwo;
    static String lengthRangeOneTo1_1;
    static String lowerToleranceOne_1;
    static String lengthRangeTwoFrom_1;
    static String lengthRangeTwoTo_1;
    static String lowerToleranceTwo_1;
    static String upperToleranceTwo_1;


    @Then("Check the Bundle Tolerance Value as per the Company Profile")
    public static void check_the_bundle_tolerance_value_as_per_the_company_profile() {
        Assert.assertEquals(lengthRangeOneTo, lengthRangeOneTo1_1);
        Assert.assertEquals(lowerToleranceOne, lowerToleranceOne_1);
        Assert.assertEquals(lengthRangeTwoFrom, lengthRangeTwoFrom_1);
        Assert.assertEquals(lengthRangeTwoTo, lengthRangeTwoTo_1);
        Assert.assertEquals(lowerToleranceTwo, lowerToleranceTwo_1);
        Assert.assertEquals(upperToleranceTwo, upperToleranceTwo_1);
        System.out.println("Scenario 1 Tested");
    }

    @Then("Check outside focus changes lower tolerance and Upper tolerance")
    public static void Check_outside_focus_changes_lower_tolerance_and_Upper_tolerance() {
        Assert.assertEquals(DefineBundleTolerance.bundlelowertolerance, "-10.00mm");
        Assert.assertEquals(DefineBundleTolerance.bundleuppertolerance, "10.00mm");
        WebElement cancel = driver.findElement(By.xpath("//button[contains(text(),'Cancel')]"));
        cancel.click();
        System.out.println("Scenario 2 Tested");
    }

    @Then("Check Bundle Tolerance Value By Inspecting Bundle")
    public static void Check_bundle_tolerance_value_by_inspecting_bundle() {
        Assert.assertEquals(DefineBundleTolerance.bundlelowertolerance1, "-5mm");
        Assert.assertEquals(DefineBundleTolerance.bundleuppertolerance1, "5mm");
        WebElement cancel = driver.findElement(By.xpath("//button[contains(text(),'Cancel')]"));
        cancel.click();
        System.out.println("Scenario 3 Tested");
    }

    @Then("Check the component label value")
    public static void check_the_complabel_value() {
        Assert.assertEquals(DefineBundleTolerance.complabelvalue, "100.00 (+/-5)");
        System.out.println("Scenario 4 Tested");
    }


    @And("Changing General units to {string}")
    public void changingGeneralUnitsToMetric(String units) {
        Select Se = new Select(driver.findElement(By.name("generalunits")));
        Se.selectByValue(units);
        WebElement saveButton = driver.findElement(By.cssSelector("button[value='Save']"));
        saveButton.click();
        new CommonElements(driver).verifyAlertSuccessMessage("Properties updated successfully");
    }

    @Then("Check Bundle Tolerance Value By Inspecting Bundle for Imperial task")
    public void checkBundleToleranceValueByInspectingBundleForImperialTask() {
        Assert.assertEquals(DefineBundleTolerance.bundlelowertolerance1, "-0.20\"");
        Assert.assertEquals(DefineBundleTolerance.bundleuppertolerance1, "-0.20\"");
        WebElement cancel = driver.findElement(By.xpath("//button[contains(text(),'Cancel')]"));
        cancel.click();
        System.out.println("Scenario 3 Tested");
    }

    @Then("Check the component label value for Imperial task")
    public void checkTheComponentLabelValueForImperialTask() {
        Assert.assertEquals(DefineBundleTolerance.complabelvalue, "3.94 (+/-0.20)");
        System.out.println("Scenario 4 Tested ");
    }


    @Then("Check outside focus changes lower tolerance and Upper tolerance for Imperial task")
    public void checkOutsideFocusChangesLowerToleranceAndUpperToleranceForImperialTask() {
        Assert.assertEquals(DefineBundleTolerance.bundlelowertolerance, "-0.20\"");
        Assert.assertEquals(DefineBundleTolerance.bundleuppertolerance, "0.20\"");
        WebElement cancel = driver.findElement(By.xpath("//button[contains(text(),'Cancel')]"));
        cancel.click();
        System.out.println("Scenario 2 Tested");
    }

    @And("Inspecting Bundle Tolerance Value for Imperial task")
    public void inspectingBundleToleranceValueForImperialTask() {
        DefineBundleTolerance.InspectingBundletolerancevalueImperial();
    }

    @And("Place the Frame")
    public void placeTheFrame() throws InterruptedException {
        DefineBundleTolerance.placetheFrame();
    }

    @Then("Check by printing the drawing in Metric Task units")
    public void checkByPrintingTheDrawingMetric()  throws IOException, InterruptedException {
        WebElement print = driver.findElement(By.xpath("//div[@id='iprint']"));
        print.click();
        WebElement colorPrintButton = driver.findElement(By.cssSelector("body > div:nth-child(35) > div:nth-child(3) > div:nth-child(1) > button:nth-child(1)"));
        colorPrintButton.click();
        Thread.sleep(8000);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        System.out.println("Link for print page: " + driver.getCurrentUrl());
        String pdfContent = getPdfContent(driver.getCurrentUrl());
        System.out.println("pdfContent");
        System.out.println(pdfContent);
        Assert.assertTrue(pdfContent.contains("100.00 (+/-5)"),"Print is not Working as Expected for Metric Task Units should be 100.00 (+/-5)");
        Assert.assertTrue(pdfContent.contains("150.00 (+/-10)"),"Print is not Working as Expected for Metric Task Units should be 150.00 (+/-10)");
        Assert.assertTrue(pdfContent.contains("200.00 (+/-10)"),"Print is not Working as Expected for Metric Task Units should be 200.00 (+/-10) ");
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(5000);
    }
    public static String getPdfContent(String url) throws IOException {
        URL pdfURL = new URL(url);
        InputStream is = pdfURL.openStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        PDDocument doc = PDDocument.load(bis);
        PDFTextStripper strip = new PDFTextStripper();
        strip.setStartPage(1);
        strip.setEndPage(2);
        String stripText = strip.getText(doc);
        System.out.print(stripText);
        doc.close();
        return stripText;
    }

    @Then("Check by printing the drawing in Imperial Task units")
    public void checkByPrintingTheDrawingInImperialTaskUnits() throws IOException, InterruptedException {
        WebElement print = driver.findElement(By.xpath("//div[@id='iprint']"));
        print.click();
        WebElement colorPrintButton = driver.findElement(By.cssSelector("body > div:nth-child(35) > div:nth-child(3) > div:nth-child(1) > button:nth-child(1)"));
        colorPrintButton.click();
        Thread.sleep(8000);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        System.out.println("Page title of new tab: " + driver.getCurrentUrl());
        String pdfContent = getPdfContent(driver.getCurrentUrl());
        Assert.assertTrue(pdfContent.contains("3.94 (+/-0.20)"),"Print is not Working as Expected for Imperial Task Units");
        Assert.assertTrue(pdfContent.contains("5.91 (+/-0.39)"),"Print is not Working as Expected for Imperial Task Units");
        Assert.assertTrue(pdfContent.contains("7.87(0)"),"Print is not Working as Expected for Imperial Task Units");
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }

    @And("Turning visibility on for Bundle tolerance in formboard")
    public static void turningVisibilityOnForBundleToleranceInFormboard() throws InterruptedException {
        DefineBundleTolerance.turningVisibilityOnForBundleToleranceInFormboard();
    }
}
