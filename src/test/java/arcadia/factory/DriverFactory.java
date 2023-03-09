package arcadia.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static WebDriver initializeDriver(String browser){
        WebDriver driver;
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            default:
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);
                options.addArguments("--remote-allow-origins=*");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                break;
        }
        return driver;
    }
}
