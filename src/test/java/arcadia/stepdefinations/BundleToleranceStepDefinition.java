package arcadia.stepdefinations;

import io.cucumber.java.en.Then;
import arcadia.pages.DefineBundleTolerance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class BundleToleranceStepDefinition {


    static  String lengthRangeOneTo = DefineBundleTolerance.lengthRangeOneTo;
    static String lowerToleranceOne = DefineBundleTolerance.lowerToleranceTwo;
    static String lengthRangeTwoFrom = DefineBundleTolerance.lengthRangeTwoFrom;

    static String lengthRangeTwoTo = DefineBundleTolerance.lengthRangeTwoTo;
    static String lowerToleranceTwo = DefineBundleTolerance.lowerToleranceTwo;
    static String upperToleranceTwo = DefineBundleTolerance.upperToleranceTwo;
    static String lengthRangeOneTo1_1 = DefineBundleTolerance.lengthRangeOneTo_1;
    static String lowerToleranceOne_1 = DefineBundleTolerance.lowerToleranceTwo_1;
    static String lengthRangeTwoFrom_1 = DefineBundleTolerance.lengthRangeTwoFrom_1;
    static String lengthRangeTwoTo_1 = DefineBundleTolerance.lengthRangeTwoTo_1;
    static  String lowerToleranceTwo_1 = DefineBundleTolerance.lowerToleranceTwo_1;
    static  String upperToleranceTwo_1 = DefineBundleTolerance.upperToleranceTwo_1;
    static  String bundlelowertolerance= DefineBundleTolerance.bundlelowertolerance;
    static String bundleuppertolerance=DefineBundleTolerance.bundleuppertolerance;
    static  String bundlelowertolerance1= DefineBundleTolerance.bundlelowertolerance1;
    static String bundleuppertolerance1=DefineBundleTolerance.bundleuppertolerance1;

    static String complabel=DefineBundleTolerance.complabelvalue;
    @Then("Check the Bundle Tolerance Value as per the Company Profile")
    public static  void check_the_bundle_tolerance_value_as_per_the_company_profile() {
//           System.out.println(lengthRangeOneTo.equals(lengthRangeOneTo1_1));
//        System.out.println(lengthRangeOneTo);
//         System.out.println(lengthRangeOneTo1_1);
       try {
//            if(lengthRangeOneTo.equals(lengthRangeOneTo1_1)){
//                System.out.println("Matches Length Range One to" +lengthRangeOneTo);
//            }
           Assert.assertEquals(lengthRangeOneTo, lengthRangeOneTo1_1);
            Assert.assertEquals(lowerToleranceOne, lowerToleranceOne_1);
            Assert.assertEquals(lengthRangeTwoFrom, lengthRangeTwoFrom_1);
            Assert.assertEquals(lengthRangeTwoTo, lengthRangeTwoTo_1);
            Assert.assertEquals(lowerToleranceTwo, lowerToleranceTwo_1);
            Assert.assertEquals(upperToleranceTwo, upperToleranceTwo_1);
           System.out.println("All Values Matches As per the Company Profiles Scenario 1 is Success");

        } catch (Throwable throwable) {
          System.out.println("Values Do not match Scenario 1 been Failed");
       }
       finally {
           System.out.println("Scenario 1 has been Tested");
       }

    }

    @Then("Check outside focus changes lower tolerance and Upper tolerance")
    public static void Check_outside_focus_changes_lower_tolerance_and_Upper_tolerance()
    {
        try {
            Assert.assertEquals(bundlelowertolerance,"-10.00mm");
            Assert.assertEquals(bundleuppertolerance,"10.00mm");
            System.out.println("Scenario 2 Has been verified the values are changing as expected");
        }catch (Throwable throwable){
            System.out.println("Scenario 2 failed the values are not matching as expected value");
        }
    }
    @Then("Check Bundle Tolerance Value By Inspecting Bundle")
    public static void Check_bundle_tolerance_value_by_inspecting_bundle()
    {
        try {
            Assert.assertEquals(bundlelowertolerance1,"-5mm");
            Assert.assertEquals(bundleuppertolerance1,"5mm");
            System.out.println("Scenario 3 has been verified the values are stored expected");

        }catch (Throwable throwable){
            System.out.println("Scenario 3 failed the values are not matching as expected value");
        }
    }
    @Then("Check the component label value")
    public static void check_the_complabel_value()
    {
        try {
            Assert.assertEquals(complabel, "100.00 (+/-5)");
            System.out.println("Scenario 4 has been verified the values are Displayed as expected");
    }catch (Throwable throwable){
            System.out.println("Scenario 4 failed the values are not Displayed as expected value");
        }
    }

}

