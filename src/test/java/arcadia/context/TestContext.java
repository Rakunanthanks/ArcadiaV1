package arcadia.context;

import arcadia.domainobjects.BundleForm;
import arcadia.domainobjects.Wire;
import io.cucumber.java.it.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestContext {
    public WebDriver driver;
    public String testIdentifier;
    public List<WebElement> bundleNodes;
    public String node1;
    public BundleForm bundleForm;



}
