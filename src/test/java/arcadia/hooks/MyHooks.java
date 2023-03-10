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
        context.driver = driver;
        nodeIdentifierList.removeAll(nodeIdentifierList);
        nodeIdentifierList.clear();
        connectorPlugIdentifierList.removeAll(connectorPlugIdentifierList);
        connectorPlugIdentifierList.clear();
        connectorIdentifierList.removeAll(connectorIdentifierList);
        connectorIdentifierList.clear();
        spliceIdentifierList.removeAll(connectorIdentifierList);
        spliceIdentifierList.clear();
        wirePropertiesList.removeAll(wirePropertiesList);
        wirePropertiesList.clear();
        bundleFormData.removeAll(bundleFormData);
        bundleFormData.clear();
        defaultBundleDisplay.removeAll(defaultBundleDisplay);
        defaultBundleDisplay.clear();
        bundleIdentifierList.removeAll(bundleIdentifierList);
        bundleIdentifierList.clear();
        mainWindowHandle=null;
        referencesPartNumber = "";
        testDescription = "";
        harnessComponentAlreadyCreated = false;
        defaultLineFont = null;
        globalSleeveTubeUpdate = false;
        dbName="";
        connectorID = "";
        terminalImagePath = "";
        bundleDefaultNtsText = "";
        bundleDefaultNtsColour = "";
    }

    @After
    public void after(Scenario scenario){
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName().toString());
        }
//        System.out.println("AFTER: THREAD ID : " + Thread.currentThread().getId() + "," +
//                "SCENARIO NAME: " + scenario.getName());
        context.driver = driver;
        nodeIdentifierList.removeAll(nodeIdentifierList);
        nodeIdentifierList.clear();
        connectorPlugIdentifierList.removeAll(connectorPlugIdentifierList);
        connectorPlugIdentifierList.clear();
        connectorIdentifierList.removeAll(connectorIdentifierList);
        connectorIdentifierList.clear();
        spliceIdentifierList.removeAll(connectorIdentifierList);
        spliceIdentifierList.clear();
        wirePropertiesList.removeAll(wirePropertiesList);
        wirePropertiesList.clear();
        bundleFormData.removeAll(bundleFormData);
        bundleFormData.clear();
        defaultBundleDisplay.removeAll(defaultBundleDisplay);
        defaultBundleDisplay.clear();
        bundleIdentifierList.removeAll(bundleIdentifierList);
        bundleIdentifierList.clear();
        mainWindowHandle=null;
        referencesPartNumber = "";
        testDescription = "";
        harnessComponentAlreadyCreated = false;
        defaultLineFont = null;
        globalSleeveTubeUpdate = false;
        dbName="";
        connectorID = "";
        terminalImagePath = "";
        bundleDefaultNtsText = "";
        bundleDefaultNtsColour = "";
        driver.quit();
        driver = null;
    }
}