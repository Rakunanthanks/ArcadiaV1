package arcadia.pages;

import arcadia.utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver;
    protected WebDriverWait wait;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
    public void load(String endPoint){
        driver.get(ConfigLoader.getInstance().getBaseUrl() + System.getProperty("testInstance") +endPoint);
    }

    public void load(){
        driver.get(ConfigLoader.getInstance().getBaseUrl() + System.getProperty("testInstance"));
    }

}
