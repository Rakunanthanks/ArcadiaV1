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
    @FindBy(id = "imagedetails") private WebElement connectortableImgDetails;
    @FindBy(css = "img[alt=\"Loading\"]") private WebElement connectorImageLoading;
    @FindBy(css = "img[alt=\"Mating\"]") private WebElement connectorImageMating;
    @FindBy(css = "img[alt=\"Top\"]") private WebElement connectorImageTop;
    @FindBy(css = "img[alt=\"Isometric\"]") private WebElement connectorImageIsometric;
    @FindBy(css = "img[alt=\"Catalogue\"]") private WebElement connectorImageCatalogue;
    @FindBy(css = "img[alt=\"Side\"]") private WebElement connectorImageSide;
    @FindBy(css = "input[name=\"Connector.harnessScaleLoading\"]") private WebElement connectorHarnessScaleLoading;
    @FindBy(css = "input[name=\"Connector.formboardScaleLoading\"]") private WebElement connectorFormboardScaleLoading;
    @FindBy(css = "input[name=\"Connector.harnessScaleMating\"]") private WebElement connectorHarnessScaleMating;
    @FindBy(css = "input[name=\"Connector.formboardScaleMating\"]") private WebElement connectorFormboardScaleMating;
    @FindBy(css = "input[name=\"Connector.harnessScaleTop\"]") private WebElement connectorHarnessScaleTop;
    @FindBy(css = "input[name=\"Connector.formboardScaleTop\"]") private WebElement connectorFormboardScaleTop;
    @FindBy(css = "input[name=\"Connector.harnessScaleIsometric\"]") private WebElement connectorHarnessScaleIsometric;
    @FindBy(css = "input[name=\"Connector.formboardScaleIsometric\"]") private WebElement connectorFormboardScaleIsometric;
    @FindBy(css = "input[name=\"Connector.harnessScaleCatalogue\"]") private WebElement connectorHarnessScaleCatalogue;
    @FindBy(css = "input[name=\"Connector.formboardScaleCatalogue\"]") private WebElement connectorFormboardScaleCatalogue;
    @FindBy(css = "input[name=\"Connector.harnessScaleSide\"]") private WebElement connectorHarnessScaleSide;
    @FindBy(css = "input[name=\"Connector.formboardScaleSide\"]") private WebElement connectorFormboardScaleSide;
    @FindBy(css = "input[type=\"checkbox\"][value=\"Loading\"]") private WebElement connectorCheckboxDefViewLoading;
    @FindBy(css = "input[type=\"checkbox\"][value=\"Mating\"]") private WebElement connectorCheckboxDefViewMating;
    @FindBy(css = "input[type=\"checkbox\"][value=\"Top\"]") private WebElement connectorCheckboxDefViewTop;
    @FindBy(css = "input[type=\"checkbox\"][value=\"Isometric\"]") private WebElement connectorCheckboxDefViewIsometric;
    @FindBy(css = "input[type=\"checkbox\"][value=\"Catalogue\"]") private WebElement connectorCheckboxDefViewCatalogue;
    @FindBy(css = "input[type=\"checkbox\"][value=\"Side\"]") private WebElement connectorCheckboxDefViewSide;
    @FindBy(css = "input[name=\"Connector.viewLoading\"]") private WebElement connectorImageLocationLoading;
    @FindBy(css = "input[name=\"Connector.viewMating\"]") private WebElement connectorImageLocationMating;
    @FindBy(css = "input[name=\"Connector.viewTop\"]") private WebElement connectorImageLocationTop;
    @FindBy(css = "input[name=\"Connector.viewIsometric\"]") private WebElement connectorImageLocationIsometric;
    @FindBy(css = "input[name=\"Connector.viewCatalogue\"]") private WebElement connectorImageLocationCatalogue;
    @FindBy(css = "input[name=\"Connector.viewSide\"]") private WebElement connectorImageLocationSide;
    @FindBy(css = "select[name=\"Connector.basePointOrientateLoading\"]") private WebElement connectorSelectOrientateLoading;
    @FindBy(css = "select[name=\"Connector.basePointOrientateMating\"]") private WebElement connectorSelectOrientateMating;
    @FindBy(css = "select[name=\"Connector.basePointOrientateTop\"]") private WebElement connectorSelectOrientateTop;
    @FindBy(css = "select[name=\"Connector.basePointOrientateIsometric\"]") private WebElement connectorSelectOrientateIsometric;
    @FindBy(css = "select[name=\"Connector.basePointOrientateCatalogue\"]") private WebElement connectorSelectOrientateCatalogue;
    @FindBy(css = "select[name=\"Connector.basePointOrientateSide\"]") private WebElement connectorSelectOrientateSide;
    String buttonUploadFile = "button[title=\"Select/Upload File\"]";
    String buttonDefaultImage = "button[title=\"Set Default Image\"]";
    String buttonUndo = "button[title=\"Undo\"]";
    String buttonSetBasePoint = "button[title=\"Set Base-Point\"]";
    String buttonRotateBasePoint = "button[title=\"Rotate Base-Point\"]";
}