package arcadia.pages.ComponentDB.Wires;

import arcadia.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WireDetailsPage extends BasePage {
    public WireDetailsPage(WebDriver driver) {
        super(driver);
    }
    //WireDetails
    @FindBy(css = "input[name=\"Wire.outsidedia\"]") private WebElement wireOutsideDia;
    @FindBy(css = "input[name=\"Wire.csa\"]") private WebElement wireCSA;
    @FindBy(css = "input[name=\"Wire.awgsize\"]") private WebElement wireAwgSize;
    @FindBy(css = "input[name=\"Wire.material\"]+div input") private WebElement wireMaterial;
    @FindBy(css = "input[name=\"Wire.gauge\"]") private WebElement wireGauge;
    //Electrical Properties
    @FindBy(css = "input[name=\"Wire.resistance\"]") private WebElement wireResistance;
    @FindBy(css = "input[name=\"Wire.maxcurrent\"]") private WebElement wireMaxCurrent;
    //NWF Parameters
    @FindBy(css = "input[name=\"Wire.minimumbendradius\"]") private WebElement wireBendRadius;
    @FindBy(css = "input[name=\"Wire.density\"]") private WebElement wireDensity;
    @FindBy(css = "select[name=\"Wire.massunits\"]") private WebElement wireMassUnits;
    //Image Details
    @FindBy(css = "img[alt=\"Catalogue\"]") private WebElement wireImageCatalogue;
    @FindBy(css = "input[type=\"checkbox\"][name=\"Wire.defView\"]") private WebElement wireCheckboxDefView;
    @FindBy(css = "input[name=\"Wire.harnessScaleCatalogue\"]") private WebElement wireHarnessScaleCatalogue;
    @FindBy(css = "input[name=\"Wire.formboardScaleCatalogue\"]") private WebElement wireFormboardScaleCatalogue;
    @FindBy(css = "input[name=\"Wire.viewCatalogue\"]") private WebElement wireImageLocationCatalogue;
    String buttonUploadFile = "button[title=\"Select/Upload File\"]";
    String buttonDefaultImage = "button[title=\"Set Default Image\"]";
    String buttonUndo = "button[title=\"Undo\"]";
    String buttonSetBasePoint = "button[title=\"Set Base-Point\"]";
    String buttonRotateBasePoint = "button[title=\"Rotate Base-Point\"]";
    @FindBy(css = "select[name=\"Wire.basePointOrientateCatalogue\"]") private WebElement wireOrientateCatalogue;



}