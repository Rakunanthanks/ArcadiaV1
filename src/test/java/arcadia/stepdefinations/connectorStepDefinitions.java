//package awesomecucumber.stepdefinations;
//
//import awesomecucumber.constants.EndPoint;
//import awesomecucumber.context.TestContext;
//import awesomecucumber.domainobjects.Harness;
//import awesomecucumber.pages.*;
//import io.cucumber.java.en.Given;
//import org.openqa.selenium.WebElement;
//
//import java.util.List;
//
//public class connectorStepDefinitions {
//    private final CreateHarness createHarness;
//    private final LoginPage loginPage;
//    private final ProjectLanding projectLanding;
//    private final SearchPartsDatabasePage searchPartsDatabasePage;
//    private final SearchWirePage searchWirePage;
//    private  ConnectorPage connectorPage;
//    private HarnessPage harnessPage;
//    private BundlePage bundlePage;
//    private SleeveTubeComponentDB sleeveTubeComponentDB;
//    private final TestContext context;
//    public connectorStepDefinitions(TestContext context){
//        this.context = context;
//        loginPage = PageFactoryManager.getLoginPage(context.driver);
//        createHarness = PageFactoryManager.getCreateHarness(context.driver);
//        projectLanding = PageFactoryManager.getProjectLanding(context.driver);
//        harnessPage = PageFactoryManager.getDrawingPage(context.driver);
//        searchPartsDatabasePage = PageFactoryManager.getPartsDatabasePage(context.driver);
//        bundlePage = PageFactoryManager.getBundlePage(context.driver);
//        searchWirePage = PageFactoryManager.getSearchWirePage(context.driver);
//        connectorPage = PageFactoryManager.getConnectorPage(context.driver);
//        sleeveTubeComponentDB = PageFactoryManager.getSleeveTubeComponentDB(context.driver);
//    }
//
//    @Given("I'm on the Cadonix Page")
//    public void iMOnTheStorePage() throws InterruptedException {
//        loginPage.load(EndPoint.TRAINING.url);
//        loginPage.Login();
//        loginPage.load(EndPoint.SLEEVETUBE.url);
//        sleeveTubeComponentDB.filterComponentDB("7.5-15","Conduit slit");
//        sleeveTubeComponentDB.getSleeveTubeData();
//        projectLanding.load(EndPoint.PROJECT.url);
//        projectLanding.invokeCreateHarness();
//        createHarness.submitHarnessData(new Harness("Quick Start Guide Harness","Fog Lamp Harness Complete","The Completed Harness","HAR-FL0001","A1","quickstart"));
//        harnessPage.waitForDrawingPage();
//        bundlePage.drawBundle();
//        harnessPage = PageFactoryManager.getDrawingPage(context.driver);
//        List<WebElement> bundleWebElements=  bundlePage.getBundleNodeElementId();
//        harnessPage = PageFactoryManager.getDrawingPage(context.driver);
//        harnessPage.clickOnConnector();
//        connectorPage.addConnectorToNode(bundleWebElements.get(0).getAttribute("id"));
////        searchPartsDatabasePage.findInSearchPartDatabase();
////        searchPartsDatabasePage.populateParts();
////        connectorPage.submitConnector();
////        harnessPage = PageFactoryManager.getDrawingPage(context.driver);
////        harnessPage.addConnectorToNode(bundleWebElements.get(1).getAttribute("id"));
////        searchPartsDatabasePage.populateParts();
////        connectorPage = PageFactoryManager.getConnectorPage(context.driver);
////        connectorPage.addWireToCavity();
////        connectorPage = PageFactoryManager.getConnectorPage(context.driver);
//        //connectorPage.updateWireTable();
//
//    }
//}