package arcadia.context;

import arcadia.domainobjects.*;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class FlowContext {
    public static List<NodeIdentifier> nodeIdentifierList = new ArrayList<>();;
    public static List<ConnectorIdentifier> connectorIdentifierList = new ArrayList<>();
    public static List<ConnectorPlugIdentifier> connectorPlugIdentifierList = new ArrayList<>();
    public static List<Wire> wirePropertiesList = new ArrayList<>();
    public static List<BundleForm>  bundleFormData = new ArrayList<>();
    public static GlobalSleeve globalSleeve = new GlobalSleeve();
    public static String mainWindowHandle = null;
    public static Boolean globalSleeveTubeUpdate = false;
    public static List<HarnessBundleDisplay> defaultBundleDisplay = new ArrayList<>();
    public static String defaultLineFont = null;
    public static String referencesPartNumber = "";
    public static String testDescription = "";
}
