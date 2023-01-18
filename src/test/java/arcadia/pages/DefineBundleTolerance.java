package arcadia.pages;

import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DefineBundleTolerance extends BasePage {

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
