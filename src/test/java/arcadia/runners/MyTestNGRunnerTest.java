package arcadia.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin =  {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        glue = {"arcadia"},
        features = "src/test/resources/features"
)
public class MyTestNGRunnerTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}