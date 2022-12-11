package arcadia.hooks;

import arcadia.context.FlowContext;
import arcadia.context.TestContext;
import arcadia.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

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