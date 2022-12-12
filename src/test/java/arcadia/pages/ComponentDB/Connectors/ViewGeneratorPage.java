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
}

