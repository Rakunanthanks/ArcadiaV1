package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.mapperObjects.SearchParts;
import arcadia.mapperObjects.TestMapper;
import arcadia.pages.BundlePage;
import arcadia.pages.HarnessPage;
import arcadia.pages.PageFactoryManager;
import arcadia.pages.SearchPartsDatabasePage;
import arcadia.utils.ConversionUtil;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class SearchPartsStepDefinitions {
    private final BundlePage bundlePage;
    private  HarnessPage harnessPage;
    private final SearchPartsDatabasePage searchPartsDatabasePage;
    private final TestContext context;
    ConversionUtil conversionUtil = new ConversionUtil();
    public SearchPartsStepDefinitions(TestContext context){
        this.context = context;
        bundlePage = PageFactoryManager.getBundlePage(context.driver);
        harnessPage = PageFactoryManager.getDrawingPage(context.driver);
        searchPartsDatabasePage = PageFactoryManager.getPartsDatabasePage(context.driver);
    }

    @Given("Search parts populated")
    public void search_parts_populated() throws IOException, InterruptedException {
        Thread.sleep(2000);
        TestMapper mapper = conversionUtil.getTestMapperConfig(context.testIdentifier);
        SearchParts searchParts = mapper.getSearchParts();
        ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s %s", searchParts.getDescription(),searchParts.getCavityNumber()));
        searchPartsDatabasePage.findInSearchPartDatabase(searchParts.getDescription(),searchParts.getCavityNumber());
        Thread.sleep(2000);
        searchPartsDatabasePage.populateParts();
    }

}
