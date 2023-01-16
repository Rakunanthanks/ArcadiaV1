package arcadia.hooks;

import arcadia.context.FlowContext;
import arcadia.context.TestContext;
import arcadia.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static arcadia.context.FlowContext.*;

public class MyHooks {
    private WebDriver driver;
    private final TestContext context;

    public MyHooks(TestContext context){
        this.context = context;
    }

    @Before
    public void before(Scenario scenario){
        System.out.println("BEFORE: THREAD ID : " + Thread.currentThread().getId() + "," +
                "SCENARIO NAME: " + scenario.getName());
        driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        context.driver = driver;
        nodeIdentifierList.removeAll(nodeIdentifierList);
        nodeIdentifierList.clear();
        connectorIdentifierList.removeAll(connectorIdentifierList);
        connectorIdentifierList.clear();
        wirePropertiesList.removeAll(wirePropertiesList);
        wirePropertiesList.clear();
        bundleFormData.removeAll(bundleFormData);
        bundleFormData.clear();
        defaultBundleDisplay.removeAll(defaultBundleDisplay);
        defaultBundleDisplay.clear();
        mainWindowHandle=null;
        defaultLineFont = null;
        globalSleeveTubeUpdate = false;
    }

    @After
    public void after(Scenario scenario){
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName().toString());
        }
        System.out.println("AFTER: THREAD ID : " + Thread.currentThread().getId() + "," +
                "SCENARIO NAME: " + scenario.getName());
        nodeIdentifierList.removeAll(nodeIdentifierList);
        nodeIdentifierList.clear();
        connectorIdentifierList.removeAll(connectorIdentifierList);
        connectorIdentifierList.clear();
        wirePropertiesList.removeAll(wirePropertiesList);
        wirePropertiesList.clear();
        bundleFormData.removeAll(bundleFormData);
        bundleFormData.clear();
        defaultBundleDisplay.removeAll(defaultBundleDisplay);
        defaultBundleDisplay.clear();
        mainWindowHandle=null;
        globalSleeveTubeUpdate = false;
        defaultLineFont = null;
        driver.quit();
    }
}