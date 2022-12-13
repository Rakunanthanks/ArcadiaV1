package arcadia.pages.ComponentDB.Connectors;

import arcadia.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewGeneratorPage extends BasePage {
    public ViewGeneratorPage(WebDriver driver) {
        super(driver);
    }
    //Shell
    @FindBy(id = "Cavity2_termsused") private WebElement cavityShellTable;
    @FindBy(id = "gen-fit-shell") private WebElement fitShell;
    @FindBy(id = "isvgedit") private WebElement editSVG;
    @FindBy(id = "isvgcancel") private WebElement clearSVG;
    @FindBy(css = "button[title=\"Add Background\"]") private WebElement addBackground;
    @FindBy(id = "useloading") private WebElement shellLoading;
    @FindBy(id = "usemating") private WebElement shellMating;
    @FindBy(id = "backgrounddel") private WebElement removeBackground;
    @FindBy(css = "input[name=\"Cavity.shell.x\"]") private WebElement cavityShellCenterX;
    @FindBy(css = "input[name=\"Cavity.shell.y\"]") private WebElement cavityShellCenterY;
    @FindBy(css = "select[name=\"Cavity.shell.shape\"]") private WebElement cavityShellShape;
    @FindBy(css = "input[name=\"Cavity.shell.diameter\"]") private WebElement cavityShellDiameter;
    @FindBy(css = "input[name=\"Cavity.shell.width\"]") private WebElement cavityShellWidth;
    @FindBy(css = "input[name=\"Cavity.shell.height\"]") private WebElement cavityShellHeight;
    @FindBy(css = "input[name=\"Cavity.shell.size\"]") private WebElement cavityShellThickness;
    @FindBy(css = "select[name=\"Cavity.shell.highlighting\"]") private WebElement cavityShellHighlighting;
    //Cavity Generator
    @FindBy(id = "generate") private WebElement newCavityGen;
    @FindBy(id = "gen-up") private WebElement updateCavityGen;
    @FindBy(id = "gen-del") private WebElement removeCavityGen;
    @FindBy(id = "gen-move-last") private WebElement originCavityGen;
    @FindBy(id = "gen-set-cavity-ss") private WebElement shapeSizeCavityGen;
    @FindBy(id = "gen-place-all") private WebElement placeCavityGen;
    @FindBy(css = "select[name=\"Cavity.generator.type\"]") private WebElement cavityGeneratorType;
    @FindBy(css = "input[name=\"Cavity.generator.cols\"]") private WebElement cavityGeneratorX;
    @FindBy(css = "input[name=\"Cavity.generator.rows\"]") private WebElement cavityGeneratorY;
    @FindBy(css = "input[name=\"Cavity.generator.stepx\"]") private WebElement cavityGeneratorXPitch;
    @FindBy(css = "input[name=\"Cavity.generator.stepy\"]") private WebElement cavityGeneratorYPitch;
    @FindBy(css = "input[name=\"Cavity.generator.offsetx\"]") private WebElement cavityGeneratorXOrigin;
    @FindBy(css = "input[name=\"Cavity.generator.offsety\"]") private WebElement cavityGeneratorYOrigin;
    @FindBy(css = "input[name=\"Cavity.generator.centered\"]") private WebElement cavityGeneratorToggle;
    @FindBy(css = "select[name=\"Cavity.generator.vertrect\"]") private WebElement cavityGeneratorNumberingDirection;
    @FindBy(css = "select[name=\"Cavity.generator.dirx\"]") private WebElement cavityGeneratorElementPositionX;
    @FindBy(css = "select[name=\"Cavity.generator.diry\"]") private WebElement cavityGeneratorElementPositionY;
    @FindBy(css = "select[name=\"Cavity.generator.pinshape\"]") private WebElement cavityGeneratorShape;
    @FindBy(css = "input[name=\"Cavity.generator.pinsize\"]") private WebElement cavityGeneratorSize;
    @FindBy(css = "select[name=\"Cavity.generator.cavLblPos\"]") private WebElement cavityGeneratorLabelPosition;
    //Cavity
    @FindBy(id = "idaddpinrow") private WebElement cavityAddRow;
    @FindBy(id = "iinvx") private WebElement cavityInvertX;
    @FindBy(id = "ignd") private WebElement cavityGnd;
    @FindBy(id = "irempin") private WebElement cavityRemoveOne;
    @FindBy(id = "iremall") private WebElement cavityRemoveAll;
    @FindBy(css = "input[name=\"Cavity.draw.x\"][rel=\"x\"]") private WebElement cavityDrawX;
    @FindBy(css = "input[name=\"Cavity.draw.y\"][rel=\"y\"]") private WebElement cavityDrawY;
    @FindBy(css = "input[name=\"Cavity.draw.name\"][rel=\"name\"]") private WebElement cavityDrawName;
    @FindBy(css = "input[title=\"Cavity Name Visibility\"]") private WebElement cavityCheckboxNameVisibility;
    @FindBy(css = "select[name=\"Cavity.draw.cavShape\"]") private WebElement cavityDrawShape;
    @FindBy(css = "input[name=\"Cavity.draw.cavSize\"][rel=\"cavSize\"]") private WebElement cavitySize;
    @FindBy(css = "input[name=\"Cavity.draw.cavHeight\"][rel=\"cavHeight\"]") private WebElement cavityHeight;
    @FindBy(css = "button[title=\"Set Cavity Coordinates\"]") private WebElement cavitySetCoordinates;
    @FindBy(id = "Cavity.cavStrokeWidth") private WebElement cavityStrokeWidth;
    @FindBy(id = "Cavity.shellStrokeWidth") private WebElement svgStrokeWidth;
    @FindBy(id = "Cavity.fontSize") private WebElement cavityFontSize;
    @FindBy(id = "Cavity.wireleadfontSize") private WebElement cavityWireLeadFontSize;
    @FindBy(id = "Cavity.connectorScale") private WebElement cavityonnectorScale;
    @FindBy(css = "select[name=\"Cavity.generator.units\"]") private WebElement cavityGenUnits;

}

