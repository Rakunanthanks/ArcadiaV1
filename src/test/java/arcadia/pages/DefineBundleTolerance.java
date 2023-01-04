package arcadia.pages;

import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DefineBundleTolerance extends BasePage {


  public DefineBundleTolerance(WebDriver driver) {
    super(driver);
  }

  SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
  public static String lengthRangeOneTo;
  public static String lowerToleranceOne;
  public static String upperToleranceOne;
  public static String lengthRangeTwoFrom;
  public static String lengthRangeTwoTo;
  public static String lowerToleranceTwo;
  public static String upperToleranceTwo;

  public static String lengthRangeThreeFrom;
  public  static String bundlelowertolerance;
  public static String bundleuppertolerance;

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


  public static void CaptureBundleTollerance() {
    driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
       //  new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#ibundleTolerances"))).click();

               try {
              driver.findElement(By.cssSelector("#ibundleTolerances")).click();
         } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
              executor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("#ibundleTolerances")));
            }

                 // new WebDriverWait(driver, Duration.ofSeconds(2000)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#ibundleTolerances"))).click();
                    System.out.println("Element was clicked");
    driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
         WebElement lengthrange1bundlelength = driver.findElement(By.name("lengthRangeOneTo"));
         System.out.println(lengthrange1bundlelength.getText());
         lengthRangeOneTo = lengthrange1bundlelength.getAttribute("Value");
    // System.out.println(lengthRangeOneTo);
          WebElement lenghtrange1lowertolerance = driver.findElement(By.name("lowerToleranceOne"));
          System.out.println(lenghtrange1lowertolerance.getText());
         // System.out.println(lenghtrange1lowertolerance.getAttribute("Value"));
          lowerToleranceOne = lenghtrange1lowertolerance.getAttribute("Value");;
         WebElement lenghtrange2frombundlelength = driver.findElement(By.name("lengthRangeTwoFrom"));
         System.out.println(lenghtrange2frombundlelength.getText());
         // System.out.println(lenghtrange2frombundlelength.getAttribute("Value"));
          lengthRangeTwoFrom = lenghtrange2frombundlelength.getAttribute("Value");;
          WebElement lenghtrange2tobundlelength = driver.findElement(By.name("lengthRangeTwoTo"));
          System.out.println(lenghtrange2tobundlelength.getText());
       //   System.out.println(lenghtrange2tobundlelength.getAttribute("Value"));
          lengthRangeTwoTo = lenghtrange2tobundlelength.getAttribute("Value");;
          WebElement lenghtrange2lowertolerance = driver.findElement(By.name("lowerToleranceTwo"));
          System.out.println(lenghtrange2lowertolerance.getText());
      //    System.out.println(lenghtrange2lowertolerance.getAttribute("Value"));
          lowerToleranceTwo = lenghtrange2lowertolerance.getAttribute("Value");;
          WebElement lenghtrange2uppertolerance = driver.findElement(By.name("upperToleranceTwo"));
          System.out.println(lenghtrange2uppertolerance.getText());
            //      System.out.println(lenghtrange2uppertolerance.getAttribute("Value"));
          upperToleranceTwo = lenghtrange2uppertolerance.getAttribute("Value");
  }

  public void CaptureModifyBundleTollerance() throws InterruptedException {


    WebElement lengthrange1bundlelength = driver.findElement(By.name("lengthRangeOneTo"));
    lengthrange1bundlelength.clear();
    lengthrange1bundlelength.sendKeys(("100"));
    lengthRangeOneTo_1 = "100";
    WebElement lenghtrange1lowertolerance = driver.findElement(By.name("lowerToleranceOne"));
    lenghtrange1lowertolerance.clear();
    lenghtrange1lowertolerance.sendKeys("-5");
    lowerToleranceOne_1 = "-5";
    WebElement lenghtrange1uppertolerance = driver.findElement(By.name("upperToleranceOne"));
    lenghtrange1uppertolerance.clear();
    lenghtrange1uppertolerance.sendKeys("5");
    upperToleranceOne_1 = "5";
    WebElement lenghtrange2frombundlelength = driver.findElement(By.name("lengthRangeTwoFrom"));
    lenghtrange2frombundlelength.clear();
    lenghtrange2frombundlelength.sendKeys("101");
    lengthRangeTwoFrom_1 = "101";
    WebElement lenghtrange2tobundlelength = driver.findElement(By.name("lengthRangeTwoTo"));
    lenghtrange2tobundlelength.clear();
    lenghtrange2tobundlelength.sendKeys(("199"));
    lengthRangeTwoTo_1 = "199";
    WebElement lenghtrange2lowertolerance = driver.findElement(By.name("lowerToleranceTwo"));
    lenghtrange2lowertolerance.clear();
    lenghtrange2lowertolerance.sendKeys(("-10"));
    lowerToleranceTwo_1 = "-10";
    WebElement lenghtrange2uppertolerance = driver.findElement(By.name("upperToleranceTwo"));
    lenghtrange2uppertolerance.clear();
    lenghtrange2uppertolerance.sendKeys("10");
    upperToleranceTwo_1 = "10";
    WebElement savebutton = driver.findElement(By.cssSelector("button[value='Save']"));
    savebutton.click();
    WebElement checkbutton = driver.findElement(By.cssSelector("#HAR34"));
    checkbutton.click();
    driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
    WebElement savebutton1 = driver.findElement(By.cssSelector("button[value='Save']"));
    savebutton1.click();
    driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
  }

  public void Customcommands() throws InterruptedException {
    driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);

    WebElement customcommands = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"commandline\"]"))));
    Thread.sleep(2000);
    String command100 = "freebundle 0 -72.5mm,38.75mm -72.5mm,38.75mm 27.5mm,38.75mm";
    Thread.sleep(2000);
    WebElement okaybutton = driver.findElement(By.xpath("//*[@id=\"commandbar-buttons\"]/button[2]/span"));
    customcommands.clear();
    customCommand.enterText(customcommands,command100);
    customCommand.waitClick(okaybutton);
    Thread.sleep(2000);
    customcommands.clear();
    String command150 = "freebundle 0 57.5mm,47.5mm 57.5mm,47.5mm -92.5mm,47.5mm";
    customCommand.enterText(customcommands,command150);
    customCommand.waitClick(okaybutton);
    Thread.sleep(2000);
    customcommands.clear();
    String command200 = "freebundle 0 72.5mm,57.5mm 72.5mm,57.5mm -127.5mm,57.5mm";
    customCommand.enterText(customcommands,command200);
    customCommand.waitClick(okaybutton);
    Thread.sleep(3000);
//    customCommand.enterText(customcommands,command100);
//    customCommand.waitClick(okaybutton);
//    Thread.sleep(3000);
  }

  public void InspectingBundle() throws InterruptedException{
    Actions act = new Actions(driver);
    driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
    WebElement inspectbundle = driver.findElement(By.cssSelector("path[d='M -72.5 38.75 L -72.5 38.75 L 27.5 38.75'][stroke='TRANSPARENT']"));
    act.doubleClick(inspectbundle).perform();
    Thread.sleep(4000);

    WebElement length = driver.findElement(By.name("bundle.length"));
    length.clear();
    length.sendKeys("150");
    WebElement focus = driver.findElement(By.name("coverings.internaldia"));
    focus.clear();
    focus.sendKeys("200");
    WebElement lowertolerance = driver.findElement(By.name("bundle.lowerTolerance"));
    Thread.sleep(4000);
    System.out.println(lowertolerance.getAttribute("placeholder"));
    bundlelowertolerance = lowertolerance.getAttribute("placeholder");
    WebElement uppertolerance = driver.findElement(By.name("bundle.upperTolerance"));
    Thread.sleep(4000);
    System.out.println(uppertolerance.getAttribute("placeholder"));
    bundleuppertolerance = uppertolerance.getAttribute("placeholder");
  }

  public void InspectingBundletolerancevalue()throws InterruptedException
  {
    Actions act = new Actions(driver);
    driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
    WebElement inspectbundle = driver.findElement(By.cssSelector("path[d='M -72.5 38.75 L -72.5 38.75 L 27.5 38.75'][stroke='TRANSPARENT']"));
    act.doubleClick(inspectbundle).perform();
    Thread.sleep(4000);
    WebElement lowertolerance = driver.findElement(By.name("bundle.lowerTolerance"));
    Thread.sleep(4000);
    System.out.println(lowertolerance.getAttribute("placeholder"));
    bundlelowertolerance1 = lowertolerance.getAttribute("placeholder");
    WebElement uppertolerance = driver.findElement(By.name("bundle.upperTolerance"));
    Thread.sleep(4000);
    System.out.println(uppertolerance.getAttribute("placeholder"));
    bundleuppertolerance1 = uppertolerance.getAttribute("placeholder");

  }

  public void ValuesOfComplabel() throws InterruptedException
  {
    driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
    WebElement Complabel = driver.findElement(By.xpath("//*[name()='text' and contains(@class,'complabel')]"));
    complabelvalue = Complabel.getText();
    System.out.println(complabelvalue);
  }
  public void changing_bundletolerance_value() throws InterruptedException{
    CaptureBundleTollerance();
  }

  public void bundles_deleted() throws InterruptedException {
    WebElement customcommands = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"commandline\"]"))));
    Thread.sleep(2000);
    String command100 = "# -136.15mm,10.83mm 76.26mm,72.13mm";
    WebElement okaybutton = driver.findElement(By.xpath("//*[@id=\"commandbar-buttons\"]/button[2]/span"));
    customcommands.clear();
    customCommand.enterText(customcommands, command100);
    customCommand.waitClick(okaybutton);
    Thread.sleep(4000);
    WebElement delete = driver.findElement(By.id("idrawdestroy"));
    delete.click();
    System.out.println("The Drawn Nodes are Deleted");
  }

    public DefineBundleTolerance(WebDriver driver) {
        super(driver);
    }

    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();

    public void CaptureBundleTollerance(){
      driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
      new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#ibundleTolerances"))).click();
      System.out.println("Element was clicked");
      driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
      WebElement lengthrange1bundlelength = driver.findElement(By.name("lengthRangeOneTo"));
      System.out.println(lengthrange1bundlelength.getText());
      WebElement lenghtrange1lowertolerance = driver.findElement(By.name("lowerToleranceOne"));
      System.out.println(lenghtrange1lowertolerance.getText());
      WebElement lenghtrange2frombundlelength = driver.findElement(By.name("lengthRangeTwoFrom"));
      System.out.println(lenghtrange2frombundlelength.getText());
      WebElement lenghtrange2tobundlelength = driver.findElement(By.name("lengthRangeTwoTo"));
      System.out.println(lenghtrange2tobundlelength.getText());
      WebElement lenghtrange2lowertolerance = driver.findElement(By.name("lowerToleranceTwo"));
      System.out.println(lenghtrange2lowertolerance.getText());
      WebElement lenghtrange2uppertolerance = driver.findElement(By.name("upperToleranceTwo"));
      System.out.println(lenghtrange2uppertolerance.getText());

    }

    public void CaptureModifyBundleTollerance() throws InterruptedException {


      WebElement lengthrange1bundlelength = driver.findElement(By.name("lengthRangeOneTo"));
        lengthrange1bundlelength.clear();
      lengthrange1bundlelength.sendKeys(("3002"));
      WebElement lenghtrange1lowertolerance = driver.findElement(By.name("lowerToleranceOne"));
        lenghtrange1lowertolerance.clear();
      lenghtrange1lowertolerance.sendKeys("1");

        WebElement lenghtrange2frombundlelength = driver.findElement(By.name("lengthRangeTwoFrom"));
        lenghtrange2frombundlelength.clear();
        lenghtrange2frombundlelength.sendKeys("3005");
        WebElement lenghtrange2tobundlelength = driver.findElement(By.name("lengthRangeTwoTo"));
        lenghtrange2tobundlelength.clear();
        lenghtrange2tobundlelength.sendKeys(("3007"));
        WebElement lenghtrange2lowertolerance = driver.findElement(By.name("lowerToleranceTwo"));
        lenghtrange2lowertolerance.clear();
        lenghtrange2lowertolerance.sendKeys(("2"));
        WebElement lenghtrange2uppertolerance = driver.findElement(By.name("upperToleranceTwo"));
        lenghtrange2uppertolerance.clear();
        lenghtrange2uppertolerance.sendKeys("1");
        WebElement savebutton = driver.findElement(By.cssSelector("button[value='Save']"));
        savebutton.click();
        WebElement checkbutton = driver.findElement(By.cssSelector("#HAR34"));
        checkbutton.click();
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        WebElement savebutton1 = driver.findElement(By.cssSelector("button[value='Save']"));
        savebutton1.click();
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
    }

}
