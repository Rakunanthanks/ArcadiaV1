package arcadia.pages.ComponentDB.Terminals;

import arcadia.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TerminalDetailsPage extends BasePage {
    public TerminalDetailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "select[name=\"Terminal.gender\"]") private WebElement terminalGender;
    @FindBy(css = "input[name=\"Terminal.striplength\"]") private WebElement terminalStripLength;
    @FindBy(css = "input[name=\"Terminal.threaddia\"]") private WebElement terminalThreadDia;
    @FindBy(css = "input[name=\"Terminal.wireinsfrom\"]") private WebElement terminalWireInsulationFrom;
    @FindBy(css = "input[name=\"Terminal.wirecsafrom\"]") private WebElement terminalWireCsaFrom;
    @FindBy(css = "input[name=\"Terminal.taddon\"]") private WebElement terminalAddOn;
    @FindBy(css = "[name=\"Terminal.terminaltype\"]+div input") private WebElement terminalType;
    @FindBy(css = "[name=\"Terminal.termfinish\"]+div input") private WebElement terminalFinish;
    @FindBy(css = "[name=\"Terminal.tmaterial\"]+div input") private WebElement terminalMaterial;
    @FindBy(css = "input[name=\"Terminal.wireinsto\"]") private WebElement terminalWireInsulationTo;
    @FindBy(css = "input[name=\"Terminal.wirecsato\"]") private WebElement terminalWireCsaTo;
    @FindBy(id = "idsvgselectfile") private WebElement terminalUpload3dModel;
    //Image Details
    @FindBy(css = "img[alt=\"Top\"]") private WebElement terminalImageTop;
    @FindBy(css = "img[alt=\"Isometric\"]") private WebElement terminalImageIsometric;
    @FindBy(css = "img[alt=\"Catalogue\"]") private WebElement terminalImageCatalogue;
    @FindBy(css = "input[type=\"checkbox\"][value=\"Top\"]") private WebElement terminalCheckboxDefViewTop;
    @FindBy(css = "input[type=\"checkbox\"][value=\"Isometric\"]") private WebElement terminalCheckboxDefViewIsometric;
    @FindBy(css = "input[type=\"checkbox\"][value=\"Catalogue\"]") private WebElement terminalCheckboxDefViewCatalogue;
    @FindBy(css = "input[name=\"Terminal.harnessScaleTop\"]") private WebElement terminalHarnessScaleTop;
    @FindBy(css = "input[name=\"Terminal.harnessScaleIsometric\"]") private WebElement terminalHarnessScaleIsometric;
    @FindBy(css = "input[name=\"Terminal.harnessScaleCatalogue\"]") private WebElement terminalHarnessScaleCatalogue;
    @FindBy(css = "input[name=\"Terminal.formboardScaleTop\"]") private WebElement terminalFormboardScaleTop;
    @FindBy(css = "input[name=\"Terminal.formboardScaleIsometric\"]") private WebElement terminalFormboardScaleIsometric;
    @FindBy(css = "input[name=\"Terminal.formboardScaleCatalogue\"]") private WebElement terminalFormboardScaleCatalogue;
    @FindBy(css = "input[name=\"Terminal.viewTop\"]") private WebElement terminalImageLocationTop;
    @FindBy(css = "input[name=\"Terminal.viewIsometric\"]") private WebElement terminalImageLocationIsometric;
    @FindBy(css = "input[name=\"Terminal.viewCatalogue\"]") private WebElement terminalImageLocationCatalogue;
    String buttonUploadFile = "button[title=\"Select/Upload File\"]";
    String buttonDefaultImage = "button[title=\"Set Default Image\"]";
    String buttonUndo = "button[title=\"Undo\"]";
    String buttonSetBasePoint = "button[title=\"Set Base-Point\"]";
    String buttonRotateBasePoint = "button[title=\"Rotate Base-Point\"]";
    @FindBy(css = "select[name=\"Terminal.basePointOrientateTop\"]") private WebElement terminalSelectOrientateTop;
    @FindBy(css = "select[name=\"Terminal.basePointOrientateIsometric\"]") private WebElement terminalSelectOrientateIsometric;
    @FindBy(css = "select[name=\"Terminal.basePointOrientateCatalogue\"]") private WebElement terminalSelectOrientateCatalogue;
}
