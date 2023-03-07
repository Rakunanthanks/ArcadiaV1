package arcadia.pages;

import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;


public class DefineBundleTolerance extends BasePage {
    public DefineBundleTolerance(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"commandline\"]")private WebElement commandField;
    @FindBy(css ="path[d='M 74.63 62.57 L 174.63 62.57'][stroke='TRANSPARENT']")private static WebElement inspectBundle;
    @FindBy(xpath="//*[@id=\"commandbar-buttons\"]/button[2]/span")private WebElement okaybutton;
    @FindBy(id = "idrawdestroy")private WebElement deleteButton;
    @FindBy(css = "#idrawcom")private static WebElement selectElement;
    @FindBy(css = "button[value='Save']")private WebElement saveButton;
    @FindBy(name = "lengthRangeOneTo")private static WebElement lengthrange1bundlelength;
    @FindBy(name="lowerToleranceOne")private static WebElement lenghtrange1lowertolerance;
    @FindBy(name="lengthRangeTwoFrom")private static WebElement lenghtrange2frombundlelength;
    @FindBy(name="lengthRangeTwoTo")private static WebElement lenghtrange2tobundlelength;
    @FindBy(name="lowerToleranceTwo")private static WebElement lenghtrange2lowertolerance;
    @FindBy(name = "upperToleranceTwo")private static WebElement lenghtrange2uppertolerance;
    @FindBy(css = "#ibundleTolerances")private static WebElement bundleToleranceIcon;

    String command100 = "freebundle 0 74.63mm,62.57mm 174.63mm,62.57mm";
    String command150 = "freebundle 0 63.87mm,75.38mm 213.87mm,75.38mm";
    String command200 = "freebundle 0 54.65mm,87.43mm 254.65mm,87.43mm";
    String delete = "# 27.49mm,37.47mm 271.90mm,121.76mm ";
    static SeleniumCustomCommand  customCommand = new SeleniumCustomCommand();
    public static String lengthRangeOneTo;
    public static String lowerToleranceOne;
    public static String lengthRangeTwoFrom;
    public static String lengthRangeTwoTo;
    public static String lowerToleranceTwo;
    public static String upperToleranceTwo;
    public  static String bundlelowertolerance = null;
    public static String bundleuppertolerance = null;
    public  static String bundlelowertolerance1;
    public static String bundleuppertolerance1;
    public static String complabelvalue;
    public static String lengthRangeOneTo_1;
    public static String lowerToleranceOne_1;
    public static String upperToleranceOne_1;
    public static String lengthRangeTwoFrom_1;
    public static String lengthRangeTwoTo_1;
    public static String lowerToleranceTwo_1;
    public static String upperToleranceTwo_1;

    public static void InspectingBundletolerancevalueImperial() {
        selectElement.click();
        customCommand.doubleClick(driver,inspectBundle);
        WebElement length = driver.findElement(By.name("bundle.length"));
        customCommand.clearAndEnterText(length,"3.14\"");
        WebElement focus = driver.findElement(By.name("bundle.allBendsRadius"));
        customCommand.clearAndEnterText(focus,"200");
        WebElement lowertolerance = driver.findElement(By.name("bundle.lowerTolerance"));
        bundlelowertolerance = lowertolerance.getAttribute("placeholder");
        System.out.println(bundlelowertolerance);
        WebElement uppertolerance = driver.findElement(By.name("bundle.upperTolerance"));
        bundleuppertolerance = uppertolerance.getAttribute("placeholder");
        System.out.println(bundleuppertolerance);
    }

    public static void placetheFrame() throws InterruptedException {
        Thread.sleep(3000);
        try {
            driver.findElement(By.cssSelector("#iaddframe")).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("#iaddframe")));
        }
        Thread.sleep(4000);
        WebElement submitButton = driver.findElement(By.cssSelector("#rightPaneContent > button:nth-child(3)"));
        submitButton.click();
        Thread.sleep(2000);
    }

    public static void turningVisibilityOnForBundleToleranceInFormboard() throws InterruptedException {
        Thread.sleep(8000);
        customCommand.longWaitForElementToBeClickable(driver,getHeaderElement("Harness"));
        getHeaderElement("Harness").click();
        WebElement visibility = driver.findElement(By.cssSelector("#iglabeledit"));
        visibility.click();
        Thread.sleep(5000);
        WebElement bundletoleranceon = driver.findElement(By.cssSelector("input[value='true'][name='bundle_Tolerances']"));
        bundletoleranceon.click();
        WebElement submit = driver.findElement(By.cssSelector("button[title='Submit'] span"));
        submit.click();
    }

    public static WebElement getHeaderElement(String headerName){
        WebElement ele = driver.findElement(By.xpath("//div[@id=\"ribbon-tab-header-strip\"]//span[text()=\""+headerName+"\"]"));
        return ele;
    }
    public void turningvisibilityon() throws InterruptedException {
        Thread.sleep(8000);
        customCommand.longWaitForElementToBeClickable(driver,getHeaderElement("Advanced"));
        getHeaderElement("Advanced").click();
        WebElement visibility = driver.findElement(By.xpath("(//div[@id='iglabeledit'])[1]"));
        visibility.click();
        WebElement bundletoleranceon =wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='true'][name='bundle_Tolerances']")));
        bundletoleranceon.click();
        WebElement submit = driver.findElement(By.cssSelector("button[title='Submit'] span"));
        submit.click();
    }

    public static void CaptureBundleTollerance() throws InterruptedException {
        Thread.sleep(6000);
        try {
            driver.findElement(By.cssSelector("#ibundleTolerances")).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("#ibundleTolerances")));
        }
        System.out.println("Element was clicked");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        Thread.sleep(6000);
        lengthRangeOneTo = lengthrange1bundlelength.getAttribute("Value");
        lowerToleranceOne = lenghtrange1lowertolerance.getAttribute("Value");
        lengthRangeTwoFrom = lenghtrange2frombundlelength.getAttribute("Value");
        lengthRangeTwoTo = lenghtrange2tobundlelength.getAttribute("Value");
        lowerToleranceTwo = lenghtrange2lowertolerance.getAttribute("Value");
        upperToleranceTwo = lenghtrange2uppertolerance.getAttribute("Value");
    }

    public void CaptureModifyBundleTolerance() {
        customCommand.clearAndEnterText(lengthrange1bundlelength,"100");
        lengthRangeOneTo_1 = "100";
        customCommand.clearAndEnterText(lenghtrange1lowertolerance,"-5");
        lowerToleranceOne_1 = "-5";
        WebElement lenghtrange1uppertolerance = driver.findElement(By.name("upperToleranceOne"));
        customCommand.clearAndEnterText(lenghtrange1uppertolerance,"5");
        upperToleranceOne_1 = "5";
        customCommand.clearAndEnterText(lenghtrange2frombundlelength,"101");
        lengthRangeTwoFrom_1 = "101";
        customCommand.clearAndEnterText(lenghtrange2tobundlelength,"199");
        lengthRangeTwoTo_1 = "199";
        customCommand.clearAndEnterText(lenghtrange2lowertolerance,"-10");
        lowerToleranceTwo_1 = "-10";
        customCommand.clearAndEnterText(lenghtrange2uppertolerance,"10");
        upperToleranceTwo_1 = "10";
        saveButton.click();
        WebElement pagination = driver.findElement(By.xpath("//button[@type='button']"));
        pagination.click();
        WebElement selectall = driver.findElement(By.xpath("//a[normalize-space()='All']"));
        selectall.click();
        WebElement checkbutton = driver.findElement(By.xpath("//*[@id=\"chbox\"]"));
        checkbutton.click();
        saveButton.click();
    }

    public void Customcommands() throws InterruptedException {
        WebElement customcommands = wait.until(ExpectedConditions.elementToBeClickable(commandField));
        Thread.sleep(2000);
        customCommand.clearAndEnterText(commandField,command100);
        okaybutton.click();
        Thread.sleep(2000);
        customcommands.clear();
        customCommand.clearAndEnterText(commandField,command150);
        customCommand.waitClick(okaybutton);
        Thread.sleep(2000);
        customCommand.clearAndEnterText(commandField,command200);
        customCommand.waitClick(okaybutton);
        Thread.sleep(3000);
    }

    public static void InspectingBundle() {
        selectElement.click();
        customCommand.doubleClick(driver,inspectBundle);
        WebElement length = driver.findElement(By.name("bundle.length"));
        customCommand.clearAndEnterText(length,"150");
        WebElement focus = driver.findElement(By.name("bundle.allBendsRadius"));
        customCommand.clearAndEnterText(focus,"200");
        WebElement lowertolerance = driver.findElement(By.name("bundle.lowerTolerance"));
        bundlelowertolerance = lowertolerance.getAttribute("placeholder");
        WebElement uppertolerance = driver.findElement(By.name("bundle.upperTolerance"));
        System.out.println(uppertolerance.getAttribute("placeholder"));
        bundleuppertolerance = uppertolerance.getAttribute("placeholder");
    }

    public static void InspectingBundletolerancevalue()throws InterruptedException {
        selectElement.click();
        customCommand.doubleClick(driver,inspectBundle);
        WebElement lowertolerance = driver.findElement(By.name("bundle.lowerTolerance"));
        bundlelowertolerance1 = lowertolerance.getAttribute("placeholder");
        WebElement uppertolerance = driver.findElement(By.name("bundle.upperTolerance"));
        bundleuppertolerance1 = uppertolerance.getAttribute("placeholder");
    }

    public static void ValuesOfComplabel() throws InterruptedException {
        Thread.sleep(2000);
        WebElement Complabel = driver.findElement(By.xpath("//*[name()='text' and contains(@class,'complabel')]"));
        complabelvalue = Complabel.getText();
        System.out.println(complabelvalue);
    }
    public void changing_bundletolerance_value() throws InterruptedException {
        CaptureBundleTollerance();
    }
    public void bundles_deleted() throws InterruptedException {
        WebElement customcommands = wait.until(ExpectedConditions.elementToBeClickable(commandField));
        Thread.sleep(2000);
        customcommands.clear();
        customCommand.enterText(customcommands, delete);
        customCommand.waitClick(okaybutton);
        Thread.sleep(4000);
        deleteButton.click();
        Thread.sleep(4000);
        System.out.println("The Drawn Bundles are Deleted");
    }
}
