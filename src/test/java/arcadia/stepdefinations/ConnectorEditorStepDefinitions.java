package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.pages.ConnectorEditorPage;
import arcadia.pages.HarnessPage;
import arcadia.pages.PageFactoryManager;
import io.cucumber.java.en.And;

public class ConnectorEditorStepDefinitions {
    private final TestContext context;

    private final ConnectorEditorPage connectorEditorPage;

    public ConnectorEditorStepDefinitions(TestContext context){
        this.context = context;
        connectorEditorPage = PageFactoryManager.getConnectorEditorPage(context.driver);
    }
    @And("user enters details to add connector")
    public void userEntersDetailsToAddConnector() {
//        connectorEditorPage.enterConnectorDetails("X-003","quickstart","connector","FFH04142BK*T","FCI_FIN LOCK_4-WAY_RECEP HSG");
    }
}
