package arcadia.pages;

import arcadia.pages.ComponentDB.AddNewComponentPage;
import arcadia.pages.ComponentDB.CommonElements;
import arcadia.pages.ComponentDB.HeaderPanel;
import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    private static LoginPage loginPage;
    private static ProjectLanding projectLanding;
    private static CreateHarness createHarness;
    private static HarnessPage harnessPage;
    private static ConnectorPage connectorPage;
    private static SearchPartsDatabasePage searchPartsDatabasePage;
    private static SearchWirePage searchWirePage;
    private static BundlePage bundlePage;
    private static SleeveTubeComponentDB sleeveTubeComponentDB;
    private static AddNewComponentPage addNewComponentPage;
    private static HeaderPanel headerPanel;
    private static ProfilePage profilePage;
    private static ConnectorEditorPage connectorEditorPage;
    private static CreateSchematic createSchematic;
    private static SchematicsDrawingPage schematicsDrawingPagec;
    private static SpliceEditorPage spliceEditorPage;
    private static WireEditorPage wireEditorPage;
    private static NodeLabelVisibilityPage nodeLabelVisibilityPage;
    private static BundleLabelVisibilityPage bundleLabelVisibilityPage;
    private static ConnectorCavityTablePage connectorCavityTablePage;
    private static SpliceCavityTablePage spliceCavityTablePage;
    private static FormboardPage formboardPage;


    public static SearchPartsDatabasePage getPartsDatabasePage(WebDriver driver){
        return searchPartsDatabasePage == null ? new SearchPartsDatabasePage(driver) : searchPartsDatabasePage;
    }
    public static SleeveTubeComponentDB getSleeveTubeComponentDB(WebDriver driver){
        return sleeveTubeComponentDB == null ? new SleeveTubeComponentDB(driver) : sleeveTubeComponentDB;
    }
    public static SearchWirePage getSearchWirePage(WebDriver driver){
        return searchWirePage == null ? new SearchWirePage(driver) : searchWirePage;
    }
    public static ConnectorPage getConnectorPage(WebDriver driver){
        return connectorPage == null ? new ConnectorPage(driver) : connectorPage;
    }
    public static CreateHarness getCreateHarness(WebDriver driver){
        return createHarness == null ? new CreateHarness(driver) : createHarness;
    }
    public static HarnessPage getDrawingPage(WebDriver driver){
        return harnessPage == null ? new HarnessPage(driver) : harnessPage;
    }

    public static ProjectLanding getProjectLanding(WebDriver driver){
        return projectLanding == null ? new ProjectLanding(driver) : projectLanding;
    }

    public static BundlePage getBundlePage(WebDriver driver){
        return bundlePage == null ? new BundlePage(driver) : bundlePage;
    }

    public static LoginPage getLoginPage(WebDriver driver){
        return loginPage == null ? new LoginPage(driver) : loginPage;
    }

    public static ProfilePage getProfilePage(WebDriver driver){
        return profilePage == null ? new ProfilePage(driver) : profilePage;
    }

    public static AddNewComponentPage getAddNewComponentPage(WebDriver driver){
        return addNewComponentPage == null ? new AddNewComponentPage(driver) : addNewComponentPage;
    }

    public static HeaderPanel getHeaderPanel(WebDriver driver){
        return headerPanel == null ? new HeaderPanel(driver) : headerPanel;
    }
    public static ConnectorEditorPage getConnectorEditorPage(WebDriver driver){
        return connectorEditorPage == null ? new ConnectorEditorPage(driver) : connectorEditorPage;
    }

    public static CreateSchematic getCreateSchematic(WebDriver driver) {
        return createSchematic == null ? new CreateSchematic(driver) : createSchematic;
    }
    public static SchematicsDrawingPage getSchematicDrawingPage(WebDriver driver) {
        return schematicsDrawingPagec == null ? new SchematicsDrawingPage(driver) : schematicsDrawingPagec;
    }

    public static SpliceEditorPage getSpliceEditorPage(WebDriver driver) {
        return spliceEditorPage == null ? new SpliceEditorPage(driver) : spliceEditorPage;
    }
    public static WireEditorPage getWireEditorPage(WebDriver driver) {
        return wireEditorPage == null ? new WireEditorPage(driver) : wireEditorPage;
    }
    public static NodeLabelVisibilityPage getNodeLabelVisibilityPage(WebDriver driver) {
        return nodeLabelVisibilityPage == null ? new NodeLabelVisibilityPage(driver) : nodeLabelVisibilityPage;
    }
    public static BundleLabelVisibilityPage getBundleLabelVisibilityPage(WebDriver driver){
        return bundleLabelVisibilityPage == null ? new BundleLabelVisibilityPage(driver) :bundleLabelVisibilityPage;
    }
    public static ConnectorCavityTablePage getConnectorCavityTablePage(WebDriver driver){
        return connectorCavityTablePage == null ? new ConnectorCavityTablePage(driver) :connectorCavityTablePage;
    }
    public static SpliceCavityTablePage getSpliceCavityTablePage(WebDriver driver){
        return spliceCavityTablePage == null ? new SpliceCavityTablePage(driver) :spliceCavityTablePage;
    }
    public static FormboardPage getFormboardPage(WebDriver driver){
        return formboardPage == null ? new FormboardPage(driver) :formboardPage;
    }
}
