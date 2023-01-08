package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.domainobjects.Harness;
import arcadia.mapperObjects.DrawingInstructor;
import arcadia.mapperObjects.TestMapper;
import arcadia.pages.CreateHarness;
import arcadia.pages.HarnessPage;
import arcadia.pages.PageFactoryManager;
import arcadia.pages.ProjectLanding;
import arcadia.utils.ConversionUtil;
import arcadia.utils.DrawingHelper;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class HarnessStepDefinitions {
    private final CreateHarness createHarness;
    private final HarnessPage harnessPage;
    private final ProjectLanding projectLanding;
    private final TestContext context;
    ConversionUtil conversionUtil = new ConversionUtil();
    public HarnessStepDefinitions(TestContext context){
        this.context = context;
        createHarness = PageFactoryManager.getCreateHarness(context.driver);
        harnessPage = PageFactoryManager.getDrawingPage(context.driver);
        projectLanding = PageFactoryManager.getProjectLanding(context.driver);
    }
    @And("harness is created successfully")
    public void createHarness() throws IOException, InterruptedException {
        projectLanding.invokeCreateHarness();
        TestMapper mapper = conversionUtil.getTestMapperConfig(context.testIdentifier);
        arcadia.mapperObjects.CreateHarness createHarnessData = mapper.getCreateHarness();
        ExtentCucumberAdapter.addTestStepLog(String.format("Harness data description is %s and part number is %s", createHarnessData.getDescription(),createHarnessData.getPartNumber()));
        createHarness.submitHarnessData(new Harness(createHarnessData.getWorkTask(), createHarnessData.getTitle(), createHarnessData.getDescription(), createHarnessData.getPartNumber(), createHarnessData.getRevision(), createHarnessData.getComponentDB()));
    }


}
