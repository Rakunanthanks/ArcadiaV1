package arcadia.stepdefinations;



import io.cucumber.java.en.Then;
import arcadia.pages.DefineBundleTolerance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static arcadia.pages.BasePage.driver;


public class BundleToleranceStepDefinition {

    static String lengthRangeOneTo     ;
    static String lowerToleranceOne    ;
    static String lengthRangeTwoFrom   ;
    static String lengthRangeTwoTo     ;
    static String lowerToleranceTwo    ;
    static String upperToleranceTwo    ;
    static String lengthRangeOneTo1_1  ;
    static String lowerToleranceOne_1  ;
    static String lengthRangeTwoFrom_1 ;
    static String lengthRangeTwoTo_1   ;
    static String lowerToleranceTwo_1  ;
    static String upperToleranceTwo_1  ;


    @Then("Check the Bundle Tolerance Value as per the Company Profile")
    public static  void check_the_bundle_tolerance_value_as_per_the_company_profile() {
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
        Assert.assertEquals(DefineBundleTolerance.bundlelowertolerance,"-10.00mm");
        Assert.assertEquals(DefineBundleTolerance.bundleuppertolerance,"10.00mm");
        WebElement cancel =  driver.findElement(By.xpath("//button[contains(text(),'Cancel')]"));
        cancel.click();
        System.out.println("Scenario 2 Tested");
    }
    @Then("Check Bundle Tolerance Value By Inspecting Bundle")
    public static void Check_bundle_tolerance_value_by_inspecting_bundle()
    {
        Assert.assertEquals(DefineBundleTolerance.bundlelowertolerance1,"-5mm");
        Assert.assertEquals(DefineBundleTolerance.bundleuppertolerance1,"5mm");
        WebElement cancel =  driver.findElement(By.xpath("//button[contains(text(),'Cancel')]"));
        cancel.click();
        System.out.println("Scenario 3 Tested");
    }
    @Then("Check the component label value")
    public static void check_the_complabel_value()
    {
        Assert.assertEquals(DefineBundleTolerance.complabelvalue, "100.00 (+/-5)");
        System.out.println("Scenario 4 Tested");
    }



}