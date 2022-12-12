package arcadia.pages.ComponentDB.Connectors;

import arcadia.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConnectorDetailsPage extends BasePage {
    public ConnectorDetailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "select[name=\"Connector.housingGender\"]") private WebElement connectorHousingGender;
    @FindBy(css = "input[name=\"Connector.keyway\"]") private WebElement connectorKeyWay;
    @FindBy(id = "Connector.names") private WebElement connectorCavityNames;
    @FindBy(id = "allowlower") private WebElement connectorAllowLower;
    @FindBy(css = "input[name=\"Connector.length\"]") private WebElement connectorLength;
    @FindBy(css = "select[name=\"Connector.gender\"]") private WebElement connectorTerminalGender;
    @FindBy(css = "input[name=\"Connector.cavities\"]") private WebElement connectorNumberOfCavitites;
    @FindBy(css = "select[name=\"Connector.tType\"]") private WebElement connectorCavityType;
    @FindBy(css = "select[name=\"Connector.builtinterm\"]") private WebElement connectorBuiltInTerminals;
    @FindBy(css = "input[name=\"Connector.backshelldia\"]") private WebElement connectorBackShell;
    @FindBy(id = "idsvgselectfile") private WebElement connectorUpload3dModel;
}