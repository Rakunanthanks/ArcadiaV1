package arcadia.pages;

import arcadia.constants.EndPoint;
import arcadia.context.FlowContext;
import arcadia.pages.ComponentDB.AddNewComponentPage;
import arcadia.pages.ComponentDB.CommonElements;
import arcadia.utils.SeleniumCustomCommand;
import arcadia.utils.StringHelper;
import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.python.antlr.ast.Str;
import org.testng.Assert;


import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;

import static org.sikuli.hotkey.Keys.*;

public class SchematicsDrawingPage extends BasePage{

    @FindBy(css = "a[title=\"Create Schematic\"]") private WebElement createSchematic;
    @FindBy(css = "button[title=\"Import Tools\"]") private WebElement importTools;
    @FindBy(xpath = "//a[text()='Import Task']") private WebElement importTask;
    @FindBy(xpath = "//div[@Title = 'Insert Connector']") private WebElement inlineConnector;
    @FindBy(xpath = "//div[@Title = 'Insert Splice']") private WebElement insertInlineSplice;
    @FindBy(xpath = "//div[@Title = 'Draw Select']") private WebElement selectButton;
    //Inline connectors
    @FindBy(xpath = "//*[name()='g' and @id='layer_components']//*[name()='g' and @puid='connector']") private List<WebElement> listOfInlineConnectors;
    @FindBy(xpath = "//*[name()='g' and @id='layer_components']//*[name()='g' and @puid='connector']//*[name()='g' and contains(@id,'_male')]") private List<WebElement> listOfMalePartInlineConnectors;
    @FindBy(xpath = "//*[name()='g' and @id='layer_components']//*[name()='g' and @puid='connector']//*[name()='g' and contains(@id,'_female')]") private List<WebElement> listOfFemalePartInlineConnectors;
    @FindBy(css = "li#cmaddmorepins") private WebElement addMorePins;
    @FindBy(css = "li#cmeditconn") private WebElement editConnector;
    @FindBy(xpath = "//div[@aria-describedby=\"EIC\"]//span[text()=\"Edit Connector\"]") private WebElement headingEditConnector;
    @FindBy(css = "select[name='pinDisplay']") private WebElement selectPinDisplay;
    @FindBy(css = "#codesFemaleId+div div.item") private WebElement divEditConnectorIdFemaleHalf;
    @FindBy(css = "#codesFemaleId+div input") private WebElement inputEditConnectorIdFemaleHalf;
    @FindBy(css = "button[title=\"Add connector data, close dialog\"]>span") private WebElement buttonOkEditConnector;

    //Context menu would be done at the time of script creation

    //Add pins
    @FindBy(xpath = "//div[@aria-describedby=\"AMIP\"]//span[text()=\"Add More Pins\"]") private WebElement headingAddPins;
    @FindBy(css = "input[name=\"numPins\"]") private WebElement inputAddMorePins;
    @FindBy(css = "button[title=\"Add more pins, close dialog\"]>span") private WebElement buttonOkAddMorePins;
    @FindBy(css = "input[name=\"newPinID\"]") private WebElement inputEditConnectorNewPinID;

    @FindBy(xpath = "//span[text()=\"Modify Connector\"]") private WebElement headingModifyConnector;
    @FindBy(xpath = "//span[text()=\"Entire Group\"]") private WebElement buttonEntireGroup;

    @FindBy(css = "li#dropdown_housing>span") private WebElement buttonFooterHousings;
    @FindBy(css = "li#dropdown_pins>span") private WebElement buttonFooterPins;

    //To select a pin and dragdrop
    @FindBy(xpath = "//*[name()='g' and @id='layer_nodes']//*[name()='g' and @class='housing']") private List<WebElement> listOfInlineNodes;

    @FindBy(xpath = "//*[name()='g' and @id='layer_pins']//*[name()='g' and @objtype='pin']//*[name()='circle']") private List<WebElement> listOfPinsCircles;
    @FindBy(xpath = "//div[@id=\"EIC\"]//a[text()=\"Connector\"]") private WebElement tabConnectorEditConnector;
    @FindBy(xpath = "//div[@id=\"EIC\"]//a[text()=\"Inline Pin\"]") private WebElement tabInlinePinEditConnector;
    @FindBy(css = "input[name=\"connDescFemale\"]") private WebElement inputEditConnectorDescFemaleHalf;
    @FindBy(xpath = "//input[@id='EICshowDesc']//following-sibling::span[@class='switch-handle']") private WebElement switchShowDescription;
    @FindBy(xpath = "//*[name()='g' and @id='layer_components']//*[name()='g' and @puid='splice']") private List<WebElement> listOfSplice;
    @FindBy(xpath = "//input[@class='refCodeSpec']") private WebElement editSpliceName;
    @FindBy(xpath = "//button[contains(@title,'Update component data, close dialog')]") private WebElement okButtonEditSplice;
    @FindBy(xpath = "//span[@class='ribbon-title' and text()='Advanced']") private WebElement advancedTab;
    @FindBy(xpath = "//span[@class='button-title' and text()='Wire Editor']") private WebElement wireEditor;
    @FindBy(id = "wire-editor") private WebElement divWireEditorPage;
    @FindBy(xpath = "//div[@id='wire-editor']//label[contains(text(),'Component DB')]//following-sibling::select") private WebElement selectComponentDBWireEditor;
    @FindBy(xpath = "(//thead)[2]//th[11]//div//span") private WebElement headingToCon;
    @FindBy(xpath = "//th//span[text()=\"Material\"]") private WebElement headingMaterial;
    @FindBy(xpath = "//th//span[text()=\"Gauge\"]") private WebElement headingGauge;
    @FindBy(xpath = "//th//span[text()=\"Primary Color\"]") private WebElement headingPrimaryColour;
    @FindBy(xpath = "//label[contains(text(),\"Component DB\")]//following-sibling::select") private WebElement selectDropdownComponentDB;
    @FindBy(xpath = "//tbody/tr/td[10]") private WebElement connectorsColumns;
    @FindBy(xpath = "count((//span[text() = 'Material'])[1]/../../preceding-sibling::th)") private WebElement materialColumnIndex;
    @FindBy(xpath = "//tbody/tr/td[15]") private List<WebElement> materialColumnList;
    @FindBy(xpath = "count((//span[text() = 'Gauge'])[1]/../../preceding-sibling::th)") private WebElement gaugeColumnIndex;
    @FindBy(xpath = "//tbody/tr/td[16]") private List<WebElement> gaugeColumnList;
    @FindBy(xpath = "count((//span[text() = 'Primary Color'])[1]/../../preceding-sibling::th)") private WebElement primaryColorColumnIndex;
    @FindBy(xpath = "//tbody/tr/td[17]") private List<WebElement> primaryColorColumnList;
    @FindBy(xpath = "//button[text() = 'Save']") private WebElement saveButton;
    @FindBy(xpath = "//a[contains(text(),'Go to Drawing')]") private WebElement buttonGoToDrawing;
    @FindBy(xpath = "//div[@title='Insert Wire']") private WebElement insertWire;
    @FindBy(xpath = "//div[@Title = 'Wire Label Inline']") private WebElement wireLabelInline;
    @FindBy(xpath = "//div[@Title = 'Remove All Wire Labels']") private WebElement removeAllWireLabels;
    @FindBy(xpath = "//div[@id=\"dialog\" and text()=\"Remove all labels for wires?\"]") private WebElement popupMessageRemoveLabelsFromWires;
    @FindBy(xpath = "//div[@Title = 'Line Label']") private WebElement wireLabel;

    @FindBy(xpath = "//span[text()=\"Confirm Action\"]") private WebElement headingConfirmActionRemoveWireLabel;
    @FindBy(xpath = "//div[@class=\"ui-dialog-buttonset\"]//span[text()=\"Submit\"]") private WebElement buttonSubmitRemoveWireLabel;
    @FindBy(xpath = "//div[@title=\"no Line Label\"]//span") private WebElement wireWOLabel;
    @FindBy(css = "select#wireType") private WebElement selectWireTypeShowWireWithoutLabel;
    @FindBy(css = "div#btnFotter button[title=\"Submit\"]") private WebElement buttonSubmitDetails;
    @FindBy(xpath = "//input[@class='wireidspec']") private WebElement wireName;
    @FindBy(xpath = "//h1[text()='SUMMARY REPORT']") private WebElement summaryReport;
    @FindBy(xpath = "//div[@id='btnFotter']//span[text()='Close']") private WebElement footerCLoseButton;
    @FindBy(xpath = "//a[text()='automation']") private List<WebElement> columnChangedTable;
    @FindBy(xpath = "//label[text()='Wire ID:']") private WebElement wireId;
    @FindBy(xpath = "//button[@title='Update wire data, close dialog']") private WebElement wireOkButton;
    @FindBy(xpath = "//div[@title='Zoom Out']") private WebElement zoomOut;
    @FindBy(id = "izoom_in") private WebElement zoomIn;
    @FindBy(id = "izoom_fit") private WebElement zoomFit;
    @FindBy(xpath = "//*[name()='text' and @class='complabel' and contains(text(),'WIRE')]") private List<WebElement> wireLabels;
    @FindBy(xpath = "//span[text()='Remove All']") private WebElement removeWireLabels;
    @FindBy(xpath = "//div[@class='ui-dialog-buttonset']//span[text()='Submit']") private WebElement confirmSubmition;
    @FindBy(xpath = "//span[text()='Wire Label']") private WebElement addWireLabel;
    @FindBy(xpath = "//span[text()='Wire w/o Label']") private WebElement showWireWOLabel;
    @FindBy(xpath = "//div[@id='btnFotter']//span[text()='Submit']") private WebElement SubmitWire;

    @FindBy(css = "input[name='Fwiretable.conbutton'][type='button']") private WebElement buttonArrowFHalfPartNumber;
    @FindBy(css = "input[name='nPartNumber']") private WebElement inputSearchPnOrDescription;
    @FindBy(css = "input[name='nCavities']") private WebElement inputSearchCavities;
    @FindBy(css = "select[name='housingGender']") private WebElement selectHousingGender;
    @FindBy(css = "#tblBOMPartNoList>tbody>tr") private WebElement eleFirstRow;
    @FindBy(xpath = "//div[@class='ui-dialog-buttonset']//span[text()='Yes']")  private WebElement buttonYesWarning;
    @FindBy(xpath = "//span[text()='Update Font']") private WebElement updateFont;
    @FindBy(xpath = "(//table[@class='tablesorter'])[1]//td[2]/input") private List<WebElement> updateFontSize;
    @FindBy(xpath = "(//table[@class='tablesorter'])[1]//td[4]//input") private List<WebElement> updateFontCheckBox;
    @FindBy(xpath = "(//table[@class='tablesorter'])[1]//td[3]/input") private List<WebElement> updateFontColor;
    @FindBy(xpath = "//button[@class='sbarbut']/span[text()='Submit']") private WebElement submitFontUpdate;
    @FindBy(xpath = "//button[@class='sbarbut' and text()='Submit']") private WebElement submitButtonCavity;
    @FindBy(xpath = "//span[text()='Colour On/Off']") private WebElement colourOnOff;
    @FindBy(xpath = "//*[name()='g' and @title='WIRE2']//*[name()='path' and contains(@id,'outer')]") private WebElement verifyColor;

    @FindBy(xpath = "//span[text()='Open']") private WebElement openButton;

    @FindBy(xpath = "(//ul[@class='dropdown-menu']//a[@title='Create Harness'])[2]") private WebElement createharness;

    @FindBy(xpath = "//a[text()='Click here to return to projects']") private WebElement returnProject;
    @FindBy(xpath = "//*[name()='use' and contains(@onmouseenter,'#HEHBnode3')]") private List<WebElement> nodes;
    @FindBy(xpath = "//li[@id='cmiLinkParts']") private WebElement linkParts;
    @FindBy(xpath = "(//li[text()='Change Node'])[2]") private WebElement changeNode;

    @FindBy(xpath = "//span[text()='Existing']") private WebElement existingButton;
   @FindBy(xpath = "//input[@id='searchText']") private WebElement searchBox;
    @FindBy(xpath = "//button[@title='Submit']") private WebElement submitButton;
    @FindBy(xpath = "//input[@class='showConnector']") private WebElement connectorCheckbox;

    @FindBy(xpath = "//input[@class='showSplice']") private WebElement showSpliceCheckbox;
    @FindBy(xpath = "//input[@class='showOthers']") private WebElement showOthersCheckbox;
    @FindBy(xpath = "//input[@class='hidelink']") private WebElement hidelinkCheckbox;


    @FindBy(css = "div[title='Project Navigator']") private WebElement leftPanelProjectNavigator;

    //Harness footer
    @FindBy(css = "li#dropdown_snap") private WebElement footerSnap;

    //Import task form
    @FindBy(css = "form#frmImportLibrary") private WebElement formImportTask;
    @FindBy(css = "input[name=\"title\"]") private WebElement inputImportTaskName;
    @FindBy(css = "input[name=\"file\"]") private WebElement inputUploadFile;
    @FindBy(css = "select[name=\"profile\"]") private WebElement selectImportTaskProfile;
    @FindBy(css = "select[name=\"library\"]") private WebElement selectImportTaskLibrary;
    @FindBy(css = "button[value='Import']") private WebElement buttonSubmitImport;
    @FindBy(xpath = "//span[text()='Zoom In']") private WebElement zoominButton;
    @FindBy(xpath = "//span[text()='Refresh']") private WebElement refreshButton;
    @FindBy(xpath = "//span[text()='Undo' and @class='button-title']") private WebElement undoButton;

    @FindBy(css = "div[title=\"Load Wires from Schematic\"]") private WebElement buttonLoadWiresFromSchematicOnDrawing;
    @FindBy(css = "div[title=\"Delete All Existing Wires\"]") private WebElement buttonDeleteAllWires;
    @FindBy(xpath = "//span[text()='Auto Arrange']") private WebElement autoArrange;

    @FindBy(xpath = "//*[name()='g' and contains(@onclick,'splice')]") private List<WebElement> spliceImageNodes;
    @FindBy(xpath = "//span[text()='Move']") private WebElement moveButton;
    @FindBy(xpath = "//span[text()='Image Views']") private WebElement imageViews;

    @FindBy(xpath = "//*[name()='rect' and @etype='splice']") private List<WebElement> splices;
    @FindBy(xpath = "//li[@id='cmishowToLocation']") private WebElement showLocation;
    @FindBy(xpath = "//input[@name='updateviews']") private WebElement updateView;
    @FindBy(xpath = "//input[@name='updatescale']") private WebElement updateScale;
    @FindBy(xpath = "//div[@class='dynformrowexpand']//div[@value='Loading']//input[@name='autorotate.connector']") private WebElement loadingCheckBox;
    @FindBy(xpath = "//div[@class='dynformrowexpand']//div[@value='Mating']//input") private List<WebElement> matingInput;
    @FindBy(xpath = "//div[@class='dynformrowexpand']//div[@value='Catalogue']//input") private List<WebElement> catalogueInput;
    @FindBy(xpath = "//div[@class='dynformrowexpand']//div[@value='Top']//input") private List<WebElement> topInput;
    @FindBy(xpath = "//div[@class='dynformrowexpand']//div[@value='Isometric']//input") private List<WebElement> isometricInput;
    @FindBy(xpath = "//div[@class='dynformrowexpand']//div[@value='Side']//input[@name='colocate.connector']") private WebElement sideCheckBox;
    @FindBy(xpath = "//input[@name='Loading']") private WebElement LoadingInputBox;
    @FindBy(xpath = "//input[@name='Side']") private WebElement sideInputBox;
    @FindBy(xpath = "//button[@class='sbarbut']/span[text()='Submit']") private WebElement submitButtonImageView;
    @FindBy(xpath = "//input[@class='msgButton' and @name='Yes']") private WebElement yesButton;

    @FindBy(css = "a.btnExportCSV") private WebElement buttonExportCsvAllWires;
    @FindBy(xpath = "//button[contains(text(),'Load From Schematic')]") private WebElement buttonLoadFromSchematicOnWireEditor;
    @FindBy(css = "button#loadFromSchematicBtn") private WebElement buttonLoadFromSchematicOnConnectorEditor;
    @FindBy(css = "form[name=\"loadFromSchematicForm\"]") private WebElement formLoadSchematic;
    @FindBy(css = "div#DynamicFormSCH") private WebElement formChooseSchematic;
    @FindBy(xpath = "//form[@name=\"loadFromSchematicForm\"]//button[contains(text(),\"Next\")]") private WebElement buttonNextLoadFromSchematic;
    @FindBy(xpath = "//form[@name=\"loadFromSchematicForm\"]//button[text()=\"Submit \"]") private WebElement buttonSubmitLoadFromSchematic;
    @FindBy(css = "form[name=\"loadFromSchemForm\"] button[type=\"submit\"]") private WebElement buttonSubmitWireEditor;
    @FindBy(css = "form[name=\"loadschemEditor\"] input[type=\"submit\"]") private WebElement buttonSubmitConnectorEditor;
    @FindBy(css = "div#wire-editor table>thead input[type=\"checkbox\"]") private WebElement buttonSelectALlWiresOnEditor;
    @FindBy(css = "div#coninfo table>thead input[type=\"checkbox\"]") private WebElement buttonSelectALlConnectorsOnEditor;
    @FindBy(css = "div#wire-editor button[value=\"Clear all\"]+button") private WebElement buttonSaveWireEditor;
    @FindBy(css = "button[value=\"Save connectors\"]") private WebElement buttonSaveConnectors;
    @FindBy(xpath = "(//*[name()='image' and @data-etype='connector'])[5]") private WebElement connectorImageWire10;
    @FindBy(xpath = "//li[@id='cmieditconnlead']") private  WebElement moveWireLeads;
    @FindBy(xpath = "//li[@id='cmisaveconnlead']") private  WebElement saveWireLeads;

    @FindBy(xpath = "//*[name()='text' and text()='WIRE10']") private WebElement wire10;
    @FindBy(xpath = "(//*[name()='image' and @data-etype='connector'])[3]") private WebElement connectorImageWire4;
    @FindBy(xpath = "(//*[name()='text' and text()='WIRE4'])[2]") private WebElement wire4;
    @FindBy(xpath = "//span[text()='Connector Label']") private WebElement connectorLabel;
    @FindBy(xpath = "//*[name()='text']/*[name()='tspan']") private List<WebElement> connectorLabelsCount;
    @FindBy(xpath = "(//table[contains(@class,'cavityTableGFX')])[9]//tbody/tr[1]/td") private List<WebElement> cavityTableColumn;
    @FindBy(css = "table.wireTableClass thead") private WebElement wiretableHeader;
    @FindBy(xpath = "(//*[name()='rect'  and @etype='connector'])[1]") private WebElement connector;
    @FindBy(xpath = "(//*[name()='rect'  and @etype='connector'])[2]") private WebElement connector2;
    @FindBy(css = "div#wire-editor button.dropdown-toggle") private WebElement toggleButtonShowHideHeaders;
    String tablePartsRows = "#tblBOMPartNoList > tbody > tr";
    String wireTableRows = "table.wireTableClass tbody>tr";
    String wireEditorRows = "div#wire-editor table>tbody>tr";
    String connectorEditorRows = "table#schConsList>tbody>tr";
    @FindBy(xpath = "(//span[text()='General']/parent::a)[1]/i[1]") private WebElement GeneralMenuSelection;
    @FindBy(xpath = "(//span[text()='General']/parent::a)[1]/i[1]") private WebElement HarnessMenuSelection;

    @FindBy(xpath = "//a[contains(@href,'Macros')]") private WebElement macros;
    @FindBy(xpath = "//select[@name='hideEmptyColumn']") private WebElement hideEmptyColmn;
    @FindBy(xpath = "(//a[text()='Connector Cavity Table'])[1]") private WebElement connectorCavityTable;

    @FindBy(xpath = "//textarea[@name='labelcustom.LabelText']") private WebElement macrosLabel;
    @FindBy(xpath = "//input[@placeholder='Search']") private WebElement searchInput;
   @FindBy(xpath = "//button[@type='submit']") private WebElement submitButtonType;
    @FindBy(xpath = "//span[text()='Inspect']") private WebElement inspectButton;
    @FindBy(xpath = "(//li[@id='cmicprop'])[2]") private WebElement inspectContextMenu;
    @FindBy(xpath = "(//li[@id='cmigettermsandseals'])[2]") private WebElement updateCavity;
    @FindBy(xpath = "//select[@name='overwrite']") private WebElement overwriteSelect;
    @FindBy(xpath = "//select[@name='checkod']") private WebElement checkOD;
    @FindBy(xpath = "//select[@name='termfamily']") private WebElement termfamily;
    @FindBy(xpath = "//select[@name='termtype']") private WebElement termtype;
    @FindBy(xpath = "//select[@name='termfinish']") private WebElement termfinish;
    @FindBy(xpath = "//select[@name='termmaterial']") private WebElement termmaterial;
    @FindBy(xpath = "//select[@name='termgender']") private WebElement termgender;
    @FindBy(xpath = "//input[@class='selectall']") private WebElement selectAll;

    @FindBy(xpath = "//h3[text()='Cavity Table']") private WebElement cavityTable;

    @FindBy(xpath = "(//select[@name='cavitytable.terminalpn']/following-sibling::div/div[1])[1]") private WebElement terminalPN;
    @FindBy(xpath = "(//input[@rel='termfamily'])[1]") private WebElement termFamily;
    @FindBy(xpath = "(//table[@id='cavitytable']//input[@class='getDetails'])[1]") private WebElement terminalGetDetails;
    @FindBy(xpath = "//table[@id='termfilters']//input[@name='nPartNumber']") private WebElement terminalartNo;
    @FindBy(xpath = "//input[@id='btnFetchcavityPartInfo']") private WebElement arrowButton;
    @FindBy(xpath = "(//div[@class='ui-dialog-buttonset']//span[text()='Populate'])[6]") private WebElement populate;

    @FindBy(xpath = "(//table[@class='tablesorter'])[2]//tr") private List<WebElement> errorTableRows;
    @FindBy(xpath = "//select[@name='updateType']") private WebElement updateType;
    @FindBy(xpath = "//input[@name='uploadFile']") private WebElement uploadFile;
    @FindBy(xpath = "//span[text()=' Export']") private WebElement exportButton;
    @FindBy(xpath = "//th[@class='imageClick' and text()='S.No']") private WebElement serialNoTable;

    @FindBy(xpath = "//h3[text()='Table Layout']") private WebElement tableLayout;

    @FindBy(xpath = "//select[@name='wiretablelayout.showoptions']") private List<WebElement> selectYesOption;

    @FindBy(css = "select[name=\"Schematic\"]") private WebElement dropdownSelectSchematic;
    @FindBy(css = "select[name=\"autoarrange\"]") private WebElement dropdownSelectAutoArrange;
    @FindBy(xpath = "//h3[text()=\"WHICH PROPERTIES DO YOU WANT UPDATE?\"]//following-sibling::div//label") private WebElement labelSelectAllProperties;
    @FindBy(xpath = "//h3[text()=\"WHICH PROPERTIES DO YOU WANT UPDATE?\"]//following-sibling::div//label/input[@name=\"selectall\"]") private WebElement checkboxSelectAllProperties;
    @FindBy(xpath = "//h3[text()=\"Wire Import Information\"]") private WebElement headingWireImportInformation;
    @FindBy(xpath = "//table//tbody//td[text()=\"No. of Wires imported successfully\"]//following-sibling::td") private WebElement elementWiresImportedSuccessfully;
    @FindBy(xpath = "//button[@title=\"Close\"]/span") private WebElement buttonCloseWindow;

    @FindBy(xpath = "//a[text()=\"Schematic Info\"]") private WebElement tabSchematicInfoLeftPane;

    @FindBy(xpath = "//a[text()=\"Sheets\"]") private WebElement tabSheetsLeftPane;
    @FindBy(css = "button#syncSheetBtn") private WebElement buttonSyncSchematic;
    @FindBy(xpath = "//h3[text()=\"Modified Components\"]") private WebElement headingModifiedComponents;
    @FindBy(css = "select[name=\"projectlistLP\"]") private WebElement selectProjectListLeftPane;
    @FindBy(css = "select[name=\"SchematicLP\"]") private WebElement selectSchematicLeftPane;

    @FindBy(xpath = "//h3[text()=\"WHICH PROPERTIES DO YOU WANT COMPARE?\"]//following-sibling::div//label") private WebElement labelSelectAllPropertiesToCompare;
    @FindBy(xpath = "//h3[text()=\"WHICH PROPERTIES DO YOU WANT COMPARE?\"]//following-sibling::div//label/input[@name=\"selectall\"]") private WebElement checkboxSelectAllPropertiesToCompare;
    @FindBy(css = "button[title=\"Save\"]") private WebElement buttonSaveSchematicInfo;
    @FindBy(css = "div#btnFotter>button[title=\"Configure\"]") private WebElement buttonConfigureSchematicInfo;
    @FindBy(xpath = "(//span[text()='Update Cross Ref'])") private WebElement updateCrossRef;
    @FindBy(xpath = "(//select[@name='library'])[1]") private WebElement componentDB;
    @FindBy(xpath = "(//select[@name='company'])[1]") private WebElement companyDropdwon;
    @FindBy(xpath = "((//div[@class='dynformrow'])[1]//input)[1]") private WebElement manufactureInput;
    @FindBy(xpath = "((//div[@class='dynformrow'])[1]//input)[3]") private WebElement supplierInput;
    @FindBy(xpath = "(//*[@data-partnumber='MANU'])[2]") private WebElement ManuLabel;
    @FindBy(xpath = "(//*[@data-partnumber='SUPPLIER'])[2]") private WebElement SupplierLabel;
    @FindBy(xpath = "//span[text()='Move Relative']") private WebElement relativeButton;

    @FindBy(xpath = "//input[@placeholder='Set Length']") private WebElement setLength;
    @FindBy(xpath = "//input[@name='bundle.length']") private  WebElement setLengthInput;
    @FindBy(xpath = "//p[text()='Drawn Length:']/..") private WebElement drawnLength;
    @FindBy(xpath = "//*[name()='g' and contains(@class,'DG27')]//*[name()='use']") private WebElement bundle;

    String wireEditorHeaders = "//div[@id=\"wire-editor\"]//thead//th//input";

    String wiresImportedRows = "//h3[text()=\"Wire Import Information\"]//following-sibling::div//table//tbody//tr";

    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();



    public SchematicsDrawingPage(WebDriver driver) {
        super(driver);
    }

    public void addInlineConnector(int xpoint, int ypoint, String connectorIdFemaleHalfName,String connectorDescFemaleHalf, Boolean enableDescriptionToggle) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver,selectButton);
        customCommand.javaScriptClick(driver,inlineConnector);
        WebElement element;
        if(listOfInlineConnectors.size()>0)
        {
            element=listOfInlineConnectors.get(0);
            customCommand.moveByOffsetOfElementAndClick(driver,element,xpoint,ypoint);
        }
        else {
            element = inlineConnector;
            int initialXCoordinateOfInsertConnectorButton = element.getLocation().getX();
            int initialYCoordinateOfInsertConnectorButton = element.getLocation().getY();
            customCommand.moveByOffsetAndClick(driver,initialXCoordinateOfInsertConnectorButton-250,initialYCoordinateOfInsertConnectorButton+200);
        }
        Thread.sleep(3000);
        int numberOfInlineConnectors = listOfInlineConnectors.size();
        WebElement eleInlineConnector = listOfInlineConnectors.get(numberOfInlineConnectors-1);
        updateInlineConnectorFemaleHalfIdandDescription(eleInlineConnector,connectorIdFemaleHalfName,connectorDescFemaleHalf,enableDescriptionToggle);
        Thread.sleep(3000);
        WebElement eleInlineConnector1 = driver.findElements(By.xpath("//*[name()='g' and @id='layer_components']//*[name()='g' and @puid='connector']")).get(numberOfInlineConnectors-1);
        customCommand.waitForElementToBeClickable(driver,eleInlineConnector1);
    }

    public void updateInlineConnectorFemaleHalfIdandDescription(WebElement elementInlineConnector, String inlineConnectorIdFemaleHalfName, String connectorDescFemaleHalf, Boolean enableDescriptionToggle) throws InterruptedException {
        customCommand.javaScriptClick(driver,selectButton);
        customCommand.moveToElementAndDoubleClick(driver,elementInlineConnector);
        customCommand.waitForElementVisibility(driver,tabConnectorEditConnector);
        if (enableDescriptionToggle){
            switchShowDescription.click();
        }
        customCommand.waitForElementToBeClickable(driver,divEditConnectorIdFemaleHalf);
        divEditConnectorIdFemaleHalf.click();
        inputEditConnectorIdFemaleHalf.sendKeys(BACKSPACE);
        customCommand.clearAndEnterText(inputEditConnectorIdFemaleHalf,inlineConnectorIdFemaleHalfName);
        customCommand.waitForElementToBeClickable(driver,tabConnectorEditConnector);
        customCommand.javaScriptClick(driver,tabConnectorEditConnector);
        customCommand.waitForElementVisibility(driver,inputEditConnectorDescFemaleHalf);
        customCommand.clearAndEnterText(inputEditConnectorDescFemaleHalf,connectorDescFemaleHalf);
        customCommand.javaScriptClick(driver,buttonOkEditConnector);
    }

    public void addPinsToConnector() throws InterruptedException {
        customCommand.javaScriptClick(driver,selectButton);
        for(WebElement ele:listOfFemalePartInlineConnectors)
        {
            String[] ids=ele.getAttribute("id").split("_");
            String id=ids[0]+"comp";
            WebElement connectorId=driver.findElement(By.xpath("//*[name()='g' and @id='"+id+"']"));
            new HarnessPage(driver).getContextMenu("",connectorId);
            customCommand.javaScriptClick(driver,addMorePins);
            customCommand.waitForElementVisibility(driver,inputAddMorePins);
            customCommand.waitForElementToBeClickable(driver,inputAddMorePins);
            customCommand.clearAndEnterText(inputAddMorePins,"5");
            customCommand.javaScriptClick(driver,buttonOkAddMorePins);
        }
    }

    public void clickOnPinsFooter() throws InterruptedException {
        customCommand.waitForElementToBeClickable(driver,buttonFooterPins);
        customCommand.javaScriptClick(driver,buttonFooterPins);
        Thread.sleep(2000);
    }

    public void clickOnHousingsFooter() throws InterruptedException {
        customCommand.waitForElementToBeClickable(driver,buttonFooterHousings);
        customCommand.javaScriptClick(driver,buttonFooterHousings);
        Thread.sleep(3000);
    }

    public void addSplicesToSchematic( int pinNumber, int xOffset, int yOffset, String inlineConnectorName, String spliceName) throws InterruptedException {
        Thread.sleep(3000);
        customCommand.waitForElementToBeClickable(driver,insertInlineSplice);
        List<WebElement> inlineConnectorpins = driver.findElements(By.xpath("//*[name()='g' and @title='"+inlineConnectorName+"']//*[name()='circle']"));
        WebElement pin = inlineConnectorpins.get(pinNumber-1);
        customCommand.javaScriptClick(driver,selectButton);
        customCommand.javaScriptClick(driver,insertInlineSplice);
        customCommand.moveByOffsetOfElementAndClick(driver,pin,xOffset,yOffset);
        Thread.sleep(2000);
        int numberOfSplices = listOfSplice.size();
        WebElement eleSplice = listOfSplice.get(numberOfSplices-1);
        updateSpliceReferenceCode(eleSplice,spliceName);
    }

    private void updateSpliceReferenceCode(WebElement eleSplice, String spliceName) throws InterruptedException {
        customCommand.javaScriptClick(driver,selectButton);
        customCommand.moveToElementAndDoubleClick(driver,eleSplice);
        customCommand.waitForElementVisibility(driver,editSpliceName);
        customCommand.waitForElementToBeClickable(driver,editSpliceName);
        customCommand.clearAndEnterText(editSpliceName,spliceName);
        customCommand.javaScriptClick(driver,okButtonEditSplice);
        Thread.sleep(2000);
    }

    public void moveToWireEditor() throws InterruptedException {
        customCommand.longWaitForElementToBeClickable(driver,advancedTab);
        customCommand.javaScriptClick(driver,advancedTab);
        customCommand.waitForElementToBeClickable(driver,wireEditor);
        customCommand.javaScriptClick(driver,wireEditor);
        customCommand.waitForElementVisibility(driver,divWireEditorPage);
    }
    public void changePrimaryColour() throws InterruptedException, AWTException {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(buttonGoToDrawing));
        Thread.sleep(3000);
        customCommand.scrollIntoView(driver,headingPrimaryColour);
        List<WebElement> primaryColourColumns = driver.findElements(By.xpath("//tbody/tr/td[17]"));
        customCommand.scrollIntoView(driver,headingToCon);
        customCommand.moveToElementAndClick(driver,headingToCon);
        Thread.sleep(2000);
        String primaryColour;
        List<WebElement> listOfConnectorsColumns = driver.findElements(By.xpath("//tbody/tr/td[10]"));
        for (int i=0; i<listOfConnectorsColumns.size()-1; i++){
            System.out.println("Text of connector is : " +listOfConnectorsColumns.get(i).getText());
            if (listOfConnectorsColumns.get(i).getText().toUpperCase().contains("SP-BK")){
                primaryColour = "BK";
            }
            else if (listOfConnectorsColumns.get(i).getText().toUpperCase().contains("SP-YE")){
                primaryColour = "YE";
            }
            else if (listOfConnectorsColumns.get(i).getText().toUpperCase().contains("SP-GN")){
                primaryColour = "GN";
            }
            else {
                primaryColour = "WH";
            }
            customCommand.scrollIntoView(driver,headingPrimaryColour);
            customCommand.moveToElementAndDoubleClick(driver,primaryColourColumns.get(i));
            customCommand.clearAndEnterText(driver.findElement(By.xpath("//textarea")),primaryColour);
            customCommand.pressKey(driver,"Tab");
            customCommand.scrollIntoView(driver,headingToCon);
        }
    }

    public void changeGaugeAndMaterial() throws InterruptedException, AWTException {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(buttonGoToDrawing));
        Thread.sleep(2000);
        customCommand.scrollIntoView(driver,headingGauge);
        List<WebElement> gaugeColumns = driver.findElements(By.xpath("//tbody/tr/td[16]"));
        WebElement header=driver.findElement(By.xpath("(//span[text()='Material'])[1]//parent::div//parent::th"));
        customCommand.scrollToElement(driver,header);
        List<WebElement> materialColumns = driver.findElements(By.xpath("//tbody/tr/td[15]"));
        for(int i=0;i<materialColumns.size()-1;i++)
        {
            customCommand.moveToElementAndDoubleClick(driver,materialColumns.get(i));
            customCommand.clearAndEnterText(driver.findElement(By.xpath("//textarea")),"GXL");
            customCommand.pressKey(driver,"Tab");
            Thread.sleep(1000);
        }
        customCommand.scrollIntoView(driver,headingGauge);
        for(int i=0;i<gaugeColumns.size()-1;i++)
        {
            customCommand.moveToElementAndDoubleClick(driver,gaugeColumns.get(i));
            customCommand.clearAndEnterText(driver.findElement(By.xpath("//textarea")),"10");
            customCommand.pressKey(driver,"Tab");
            Thread.sleep(1000);
        }
    }

    public void saveWireEditorChanges() throws InterruptedException {
        customCommand.waitForElementToBeClickable(driver,saveButton);
        customCommand.javaScriptClick(driver,saveButton);
        new AddNewComponentPage(driver).verifyAlertMessage("Saved successfully");
        new AddNewComponentPage(driver).closeAlertPopUp();
        Thread.sleep(2000);
    }

    public void goToDrawingFromWireEditor() throws InterruptedException {
        Thread.sleep(3000);
        customCommand.longWaitForElementToBeClickable(driver, buttonGoToDrawing);
        buttonGoToDrawing.click();
        customCommand.longWaitForElementToBeClickable(driver,advancedTab);

    }

    public void addPinsToConnectorUsingConnectorName(String connectorIdFemaleHalf, int numberOfPins) throws InterruptedException {
        zoomFit();
        Thread.sleep(3000);
        customCommand.javaScriptClick(driver,selectButton);
        Thread.sleep(3000);
        WebElement ele = driver.findElement(By.xpath("//*[name()='g' and @title='"+connectorIdFemaleHalf+"']//*[name()='g' and contains(@id,'_male')]//*[name()='rect']"));
        customCommand.moveToElementAndContextClick(driver,ele);
        customCommand.waitForElementToBeClickable(driver,addMorePins);
        customCommand.javaScriptClick(driver,addMorePins);
        customCommand.waitForElementVisibility(driver,inputAddMorePins);
        customCommand.waitForElementToBeClickable(driver,inputAddMorePins);
        customCommand.clearAndEnterText(inputAddMorePins, String.valueOf(numberOfPins));
        customCommand.javaScriptClick(driver,buttonOkAddMorePins);

    }

    public boolean checkIfWireLabelPresent(String wireId) {
        List<WebElement> listOfWireLabelElements = driver.findElements(By.xpath("//*[name()='text' and @class='complabel' and contains(text(),'"+wireId+"')]"));
        if (listOfWireLabelElements.size()>0){
            return true;
        }
        else {
            return false;
        }
    }

    public void removeAllWireLabels() throws InterruptedException {
        Thread.sleep(3000);
        customCommand.scrollIntoView(driver,removeAllWireLabels);
        customCommand.waitForElementToBeClickable(driver,removeAllWireLabels);
        customCommand.javaScriptClick(driver,removeAllWireLabels);
        Assert.assertTrue(headingConfirmActionRemoveWireLabel.isDisplayed(),"ConfirmAction popup is not displayed for removing wire labels");
        Assert.assertTrue(popupMessageRemoveLabelsFromWires.isDisplayed(),"Message for removing wire labels is not displayed");
        customCommand.waitForElementToBeClickable(driver,buttonSubmitRemoveWireLabel);
        buttonSubmitRemoveWireLabel.click();
        Thread.sleep(2000);
        customCommand.waitForElementToBeClickable(driver,advancedTab);
    }

    public List<WebElement> getInlineConnectorCircles(String inlineConnectorName)
    {
        List<WebElement> inlineConnectorpins = driver.findElements(By.xpath("//*[name()='g' and @title='"+inlineConnectorName+"']"));
        return inlineConnectorpins;
    }
    public List<WebElement> getInlineSplices()
    {
        List<WebElement> inlineSplices = driver.findElements(By.xpath("//*[name()='g' and @puid='splice']"));
        return inlineSplices;
    }


    public void zoomOut() throws InterruptedException {
        customCommand.javaScriptClick(driver,zoomOut);
    }
    public void zoomFit() throws InterruptedException {
        customCommand.longWaitForElementToBeClickable(driver,zoomFit);
        customCommand.javaScriptClick(driver,zoomFit);
        Thread.sleep(2000);
    }

    public void connectWire(String name,WebElement left,WebElement right) throws InterruptedException {
        Actions actions = new Actions(driver);
        customCommand.javaScriptClick(driver,insertWire);
        actions.moveToElement(left).click().perform();
        Thread.sleep(2000);
        customCommand.moveByOffsetOfElementAndClick(driver,left,90,0);
        Thread.sleep(2000);
        actions.moveToElement(right).click().perform();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(wireId));
        wireName.click();
        customCommand.clearAndEnterText(wireName,name);
        customCommand.javaScriptClick(driver,wireOkButton);
        Thread.sleep(2000);
    }

    public int numberOfWireLabels()
    {
        return wireLabels.size();
    }

    public void removeWireLabels() throws InterruptedException {
        customCommand.javaScriptClick(driver,removeWireLabels);
        customCommand.javaScriptClick(driver,confirmSubmition);
        Thread.sleep(2000);
    }

    public void selectWireLabelsInline() throws InterruptedException {
        customCommand.waitForElementToBeClickable(driver,wireLabelInline);
        customCommand.javaScriptClick(driver,wireLabelInline);
        Thread.sleep(2000);
    }

    public void verifyWireLabel(String expectedWireLabel) throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> eleWireLabel = driver.findElements(By.xpath("//*[name()='g' and @class='complabel']//*[name()='text' and text()='"+expectedWireLabel+"']"));
        Assert.assertTrue(eleWireLabel.size()==1,"Wirelabel with text: " + expectedWireLabel + " is not present on schematic drawing as the wire property profile settings are not reflected on the drawing");
        Assert.assertTrue(eleWireLabel.get(0).isDisplayed(),"Wirelabel with text: " + expectedWireLabel + " is not displayed on schematic drawing as the wire property profile settings are not reflected on the drawing");
    }

    public void selectComponentDB() throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementToBeClickable(driver,selectComponentDBWireEditor);
        Thread.sleep(2000);
        customCommand.selectDropDownByValue(selectComponentDBWireEditor,"Manual");
        Thread.sleep(2000);
        if (driver.findElements(By.xpath("//div[text()='Do you want to overwrite the existing libraries?']")).size()==1){
            driver.findElement(By.cssSelector("button[data-bb-handler=\"confirm\"]")).click();
            Thread.sleep(2000);
        }
    }

    public void drawWireLabel( int pinNumber, int xOffset, int yOffset, String inlineConnectorName) throws InterruptedException {
        Thread.sleep(3000);
        customCommand.waitForElementToBeClickable(driver,addWireLabel);
        customCommand.javaScriptClick(driver,addWireLabel);
        List<WebElement> inlineConnectorpins = driver.findElements(By.xpath("//*[name()='g' and @title='"+inlineConnectorName+"']//*[name()='circle']"));
        WebElement pin = inlineConnectorpins.get(pinNumber-1);
        customCommand.moveByOffsetOfElementAndClick(driver,pin,xOffset,yOffset-30);
        Thread.sleep(2000);
        customCommand.moveByOffsetOfElementAndClick(driver,pin,xOffset,yOffset+50);
        Thread.sleep(3000);
        System.out.println("Wires Added");
    }

    public void showWireWOLabel() throws InterruptedException {
        customCommand.javaScriptClick(driver,showWireWOLabel);
        customCommand.javaScriptClick(driver,SubmitWire);
    }

    private boolean checkIfSearchComponentResultsReturned() throws InterruptedException {
        Thread.sleep(4000);
        boolean isResultAvailable = driver.findElements(By.cssSelector(tablePartsRows)).size() >0 ;
        if(isResultAvailable){
            customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tablePartsRows)));
        }
        return  isResultAvailable;
    }

    private void selectPartNumberFemaleHalf(int numberOfCavities, String housingGender) throws InterruptedException {
        customCommand.waitForElementToBeClickable(driver,buttonArrowFHalfPartNumber);
        customCommand.javaScriptClick(driver,buttonArrowFHalfPartNumber);
        customCommand.longWaitForElementToBeClickable(driver,inputSearchPnOrDescription);
        inputSearchPnOrDescription.clear();
        //We will enable this step after we have working data linked to component DB
        //customCommand.waitForElementToBeClickable(driver,selectHousingGender);
//        customCommand.selectDropDownByValue(selectHousingGender,housingGender.toUpperCase());
        customCommand.waitForElementToBeClickable(driver,inputSearchCavities);
        inputSearchCavities.clear();
        customCommand.simulateKeyEnterWithValue(inputSearchCavities, String.valueOf(numberOfCavities));
        Assert.assertTrue(checkIfSearchComponentResultsReturned(),"Parts not displayed for searched cavity");
        customCommand.waitForElementToBeClickable(driver,eleFirstRow);
        customCommand.doubleClick(driver,eleFirstRow);
        Thread.sleep(4000);
        if (driver.findElements(By.xpath("//div[@id=\"dialog\" and text()=\"You have chosen a Part Number with a different housing gender. Please click yes to continue.\"]")).size()>0){
            customCommand.javaScriptClick(driver,buttonYesWarning);
        }
        customCommand.longWaitForElementToBeClickable(driver,inputEditConnectorDescFemaleHalf);
    }

    public void updatePinDisplayAndPartNumber(String connectorIdFemaleHalf, String pinDisplay, int numberOfCavities) throws InterruptedException {
        zoomFit();
        Thread.sleep(4000);
        customCommand.javaScriptClick(driver,selectButton);
        Thread.sleep(4000);
        WebElement eleConnector = driver.findElement(By.xpath("//*[name()='g' and @title='"+connectorIdFemaleHalf+"']//*[name()='g' and contains(@id,'_male')]//*[name()='rect']"));
        customCommand.mouseHover(driver,eleConnector);
        customCommand.moveToElementAndContextClick(driver,eleConnector);
        customCommand.waitForElementToBeClickable(driver,editConnector);
        customCommand.javaScriptClick(driver,editConnector);
        customCommand.waitForElementVisibility(driver,headingEditConnector);
        customCommand.waitForElementToBeClickable(driver,selectPinDisplay);
        customCommand.selectDropDownByValue(selectPinDisplay,pinDisplay);
        customCommand.javaScriptClick(driver,tabConnectorEditConnector);
        customCommand.waitForElementVisibility(driver,inputEditConnectorDescFemaleHalf);
        customCommand.waitForElementToBeClickable(driver,inputEditConnectorDescFemaleHalf);
        selectPartNumberFemaleHalf(numberOfCavities,pinDisplay);
        customCommand.javaScriptClick(driver,buttonOkEditConnector);
        Thread.sleep(2000);
        customCommand.longWaitForElementToBeClickable(driver,advancedTab);
        customCommand.waitForElementToBeClickable(driver,selectButton);
        customCommand.waitForElementToBeClickable(driver,zoomOut);
        Thread.sleep(2000);
    }

    public void updateFontSettings() throws InterruptedException {
        customCommand.javaScriptClick(driver,updateFont);
        Thread.sleep(2000);
        for(int i=0;i<updateFontSize.size();i++)
        {
            customCommand.javaScriptClickAndEnterValue(driver,updateFontSize.get(i),"3");
            customCommand.javaScriptClickAndEnterValue(driver,updateFontColor.get(i),"#00ff0d");
            customCommand.javaScriptClick(driver,updateFontCheckBox.get(i));
        }
        customCommand.javaScriptClick(driver,submitFontUpdate);
        Thread.sleep(3000);
    }

    public void verifyPartNumberIsPresentForConnector(String connectorIdFemaleHalf) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver,selectButton);
        Thread.sleep(2000);
        WebElement ele = driver.findElement(By.xpath("//*[name()='g' and @title='"+connectorIdFemaleHalf+"']//*[name()='g' and contains(@id,'_male')]//*[name()='rect']"));
        customCommand.mouseHover(driver,ele);
        customCommand.moveToElementAndContextClick(driver,ele);
        customCommand.waitForElementToBeClickable(driver,editConnector);
        customCommand.javaScriptClick(driver,editConnector);
        customCommand.waitForElementVisibility(driver,headingEditConnector);
        customCommand.waitForElementToBeClickable(driver,selectPinDisplay);
        customCommand.javaScriptClick(driver,tabConnectorEditConnector);
        customCommand.waitForElementVisibility(driver,inputEditConnectorDescFemaleHalf);
        customCommand.waitForElementToBeClickable(driver,inputEditConnectorDescFemaleHalf);
        String partNumberValue = driver.findElement(By.xpath("//input[contains(@id,\"connPartNo\")]")).getAttribute("value");
        Assert.assertNotEquals(partNumberValue,"","Value of partnumber is blank");
        customCommand.javaScriptClick(driver,buttonOkEditConnector);
        Thread.sleep(2000);
        customCommand.longWaitForElementToBeClickable(driver,advancedTab);
        customCommand.waitForElementToBeClickable(driver,selectButton);
        customCommand.waitForElementToBeClickable(driver,zoomOut);
        Thread.sleep(2000);
    }

    public void switchOnColour() throws InterruptedException {
        customCommand.javaScriptClick(driver,colourOnOff);
    }

    public boolean verifyWireColour()
    {
        String text= verifyColor.getAttribute("stroke");
        if(text.equalsIgnoreCase("#FFAA00"))
            return true;
        else
            return false;
    }

    public void goToCreateHarness() throws InterruptedException {
        String currentWindowHandle = driver.getWindowHandle();
        customCommand.javaScriptClick(driver,openButton);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        String name= FlowContext.schematicDescription;
        WebElement ele=driver.findElement(By.xpath("//td[text()='"+name+"']/parent::tr//button[@title='Option List']"));
        customCommand.javaScriptClick(driver,ele);
        customCommand.javaScriptClick(driver,createharness);
        Thread.sleep(2000);
    }

    public boolean verifyHarnessCreated() throws InterruptedException {
        customCommand.waitClick(returnProject);
        String name= FlowContext.schematicDescription;
        WebElement ele=driver.findElement(By.xpath("//td[text()='"+name+"']"));
        if(ele.isDisplayed())
            return true;
        else
            return false;
    }

    public void goToHarness() throws InterruptedException {
        String name= FlowContext.schematicHarnessName;
//        String name= "AB_TestWires";
        WebElement ele=driver.findElement(By.xpath("//table[@id='tableHAR']//td[text()='"+name+"']"));
        customCommand.scrollIntoView(driver,ele);
        customCommand.javaScriptClick(driver,ele);
        try{
            new AddNewComponentPage(driver).verifyConfirmationMessage("It appears you are already editing this task! It is advised that you only edit a single instance of this task");
            new AddNewComponentPage(driver).acceptConfirmationPopup();
        }
        catch (Exception e){
            customCommand.waitForElementVisibility(driver, inlineConnector);
        }
    }

    public void switchToFrame(){
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='pluginFrame']"));
        driver.switchTo().frame(iframe);
    }

    public void verifyDrawingsListPageLoaded() {
        customCommand.longWaitForElementToBeClickable(driver,createSchematic);
        WebElement eleDrawingHeading=driver.findElement(By.xpath("//h3[text()=' Drawings']"));
        customCommand.waitForElementVisibility(driver,eleDrawingHeading);
    }

    public void addNodesToHarness() throws InterruptedException, AWTException {
        WebElement eleNode = driver.findElement(By.cssSelector("#layer_80 >g[class=\"DG28 bundleGroup\"]>g>g"));
        customCommand.moveRightOfElementAndClick(driver,eleNode,28);
        Thread.sleep(1000);
        new HarnessPage(driver).clickOnNode();
        WebElement eleNode1 = driver.findElement(By.cssSelector("#layer_80 >g[class=\"DG28 bundleGroup\"]>g>g"));
        customCommand.moveRightOfElementAndClick(driver,eleNode1,56);
        Thread.sleep(1000);
        new HarnessPage(driver).clickOnNode();
        WebElement eleNode2 = driver.findElement(By.cssSelector("#layer_80 >g[class=\"DG28 bundleGroup\"]>g>g"));
        customCommand.moveRightOfElementAndClick(driver,eleNode2,84);
        Thread.sleep(1000);
    }

    public void selectNodeToAddPart(String nodeIndex,String partNameIndex) throws InterruptedException {
        customCommand.javaScriptClick(driver,selectButton);
        int nIndex= Integer.parseInt(nodeIndex.substring(4));
        List<WebElement> nodesList = new LinkedList<>(driver.findElements(By.xpath("//*[name()='use' and contains(@onmouseenter,'#HEHBnode3')]")));
        WebElement node=nodesList.get(nIndex);
        new HarnessPage(driver).getContextMenu("",node);
        customCommand.javaScriptClick(driver,linkParts);
        customCommand.javaScriptClick(driver,existingButton);
        Thread.sleep(2000);
    }

    public void chooseFilter(String filter) throws InterruptedException {
        customCommand.javaScriptClick(driver,connectorCheckbox);
        customCommand.javaScriptClick(driver,showSpliceCheckbox);
        customCommand.javaScriptClick(driver,showOthersCheckbox);
        customCommand.javaScriptClick(driver,hidelinkCheckbox);
        switch(filter.toLowerCase()) {
            case "connector":
                customCommand.javaScriptClick(driver,connectorCheckbox);
                break;
            case "splices":
                customCommand.javaScriptClick(driver,showSpliceCheckbox);
                break;
        }
    }

    public void addPartToNode(String partNameIndex) throws InterruptedException {
        customCommand.clearAndEnterText(searchBox,partNameIndex);
        Thread.sleep(2000);
        WebElement ele=driver.findElement(By.xpath("//table[@id='findTbl']//tr/td[text()='"+partNameIndex+"']/parent::tr/td[1]/input"));
        customCommand.javaScriptClick(driver,ele);
        customCommand.javaScriptClick(driver,submitButton);

    }


    public void selectSnap(String snap) throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(footerSnap).moveToElement(driver.findElement(By.xpath("//li[@id='dropdown_snap']//li[text()='"+snap+"']"))).click().build().perform();
        Thread.sleep(2000);
    }

    public void openLeftPanel() throws InterruptedException {
        Boolean leftPanelDisplayed = driver.findElements(By.cssSelector("div#leftTabs")).get(0).isDisplayed();
        if (!leftPanelDisplayed){
            leftPanelProjectNavigator.click();
        }
    }

    public void addComponentFromTreeToDrawing(String componentType, String componentName, String destinationType, String destName) throws InterruptedException {
        switch (componentType.toLowerCase()){
            case "connector":
                driver.findElement(By.xpath("//ul[@id='idLinkPartsSheet']//span[contains(text(),'Connectors')]")).click();
                break;
            case "splice":
                driver.findElement(By.xpath("//ul[@id='idLinkPartsSheet']//span[contains(text(),'Splices')]")).click();
                break;
        }
        WebElement sourceElement = driver.findElement(By.xpath("//ul[@id='idLinkPartsSheet']//span[text()='"+componentName+"']"));
        WebElement destinationElement = null;
        switch (destinationType.toLowerCase()){
            case "node":
                if (destName.equalsIgnoreCase("Node10")) {
                    List<WebElement> destNode10 = driver.findElements(By.cssSelector("#layer_80 >g[class=\"DG27 bundleGroup\"]>g>g>use"));
//                    List<WebElement> destNode10 = driver.findElements(By.xpath("//*[@id='layer_80']//*[name()='g' and @class='DG27 bundleGroup']//*[name()='g']//*[name()='g']//*[name()='use']"));
                    if (destNode10.size()>1){
                        destinationElement = destNode10.get(1);
                    }
                    else {
                        destinationElement = destNode10.get(0);
                    }
//                    destinationElement = driver.findElements(By.xpath("//*[name()='use' and contains(@onmouseenter,'#HEHBnode3')]")).get(3);
                }
                else if (destName.equalsIgnoreCase("Node18")){
                    List<WebElement> destNode18 = driver.findElements(By.cssSelector("#layer_80 >g[class=\"DG57 bundleGroup\"]>g>g>use"));
                    if (destNode18.size()>1){
                        destinationElement = destNode18.get(1);
                    }
                    else {
                        destinationElement = destNode18.get(0);
                    }
//                    destinationElement = driver.findElements(By.xpath("//*[name()='use' and contains(@onmouseenter,'#HEHBnode3')]")).get(7);
                }
                break;
        }

        customCommand.javaScriptClick(driver,selectButton);
        customCommand.javaScriptClick(driver,sourceElement);
        Thread.sleep(2000);
        Actions actMove = new Actions(driver);
        actMove.moveToElement(destinationElement).click().build().perform();
        Thread.sleep(3000);
    }

    public void selectConnectorToChangeNode(String nodeIndex,String connectorIndex) throws InterruptedException {
        if(connectorIndex.contains("6"))
        {
            customCommand.javaScriptClick(driver,refreshButton);
            Thread.sleep(3000);
            customCommand.javaScriptClick(driver,zoomOut);
        }
        customCommand.javaScriptClick(driver,selectButton);
        WebElement ele=driver.findElement(By.xpath("//*[name()='text' and text()='"+connectorIndex+"']/ancestor::*[name()='g']/*[name()='rect' and @etype='connector']"));
        new HarnessPage(driver).getContextMenu("",ele);
        customCommand.javaScriptClick(driver,changeNode);
        int nIndex= Integer.parseInt(nodeIndex.substring(4));
        Thread.sleep(2000);
        WebElement node=nodes.get(nIndex);
        node.click();
        Thread.sleep(2000);
    }


    public void importHarness(String harnessFilePath) throws InterruptedException {
        customCommand.longWaitForElementToBeClickable(driver,importTools);
        customCommand.javaScriptClick(driver,importTools);
        customCommand.moveToElementAndClick(driver,importTask);
        switchToFrame();
        customCommand.longWaitForElementToBeClickable(driver,inputImportTaskName);
        String schemHarnessName = "SchematicHarness " + new StringHelper().generateRandomDigit();
        FlowContext.schematicHarnessName = schemHarnessName;
        inputImportTaskName.sendKeys(schemHarnessName);
        File file = new File(harnessFilePath);
        inputUploadFile.sendKeys(file.getAbsolutePath());
        Thread.sleep(4000);
        customCommand.selectDropDownByValue(selectImportTaskProfile,System.getProperty("profileName"));
        customCommand.selectDropDownByValue(selectImportTaskLibrary,System.getProperty("componentDB"));
        customCommand.javaScriptClick(driver,buttonSubmitImport);
        Thread.sleep(5000);
        customCommand.waitClick(returnProject);
    }

    public void importtask(String filePath) throws InterruptedException {
        customCommand.longWaitForElementToBeClickable(driver,importTools);
        customCommand.javaScriptClick(driver,importTools);
        customCommand.moveToElementAndClick(driver,importTask);
        switchToFrame();
        customCommand.longWaitForElementToBeClickable(driver,inputImportTaskName);
        String taskName = "TestTask " + new StringHelper().generateRandomDigit();
        FlowContext.drawingTaskName = taskName;
        inputImportTaskName.sendKeys(taskName);
        File file = new File(filePath);
        inputUploadFile.sendKeys(file.getAbsolutePath());
        Thread.sleep(4000);
        customCommand.selectDropDownByValue(selectImportTaskProfile,System.getProperty("profileName"));
        customCommand.selectDropDownByValue(selectImportTaskLibrary,System.getProperty("componentDB"));
        customCommand.javaScriptClick(driver,buttonSubmitImport);
        Thread.sleep(5000);
        customCommand.waitClick(returnProject);
    }

    public int getWiresCount() throws InterruptedException {
        customCommand.longWaitForElementToBeClickable(driver,zoomFit);
        customCommand.waitForElementVisibility(driver,wiretableHeader);
        Thread.sleep(2000);
        int numberOfWires = driver.findElements(By.cssSelector(wireTableRows)).size();
        return numberOfWires;
    }

    public void verifyWiresCanBeDeleted(int initialWiresCount) throws InterruptedException {
        customCommand.waitForElementToBeClickable(driver,advancedTab);
        customCommand.javaScriptClick(driver,advancedTab);
        customCommand.scrollIntoView(driver,buttonDeleteAllWires);
        customCommand.waitForElementToBeClickable(driver,buttonDeleteAllWires);
        customCommand.javaScriptClick(driver,buttonDeleteAllWires);
        new CommonElements(driver).verifyAlertMessage("Do you want to delete all the Existing Wires?");
        new CommonElements(driver).acceptAlertMessage();
        Thread.sleep(2000);
        customCommand.waitForElementToBeClickable(driver,buttonDeleteAllWires);
        Assert.assertTrue(driver.findElements(By.cssSelector(wireTableRows)).size()==0,"Wires were not deleted successfully as the wire count is not as expected");
    }

    public void selectExportWires() throws InterruptedException {
        customCommand.waitForElementToBeClickable(driver,buttonGoToDrawing);
        customCommand.longWaitForElementToBeClickable(driver,buttonExportCsvAllWires);
        Thread.sleep(4000);
        customCommand.javaScriptClick(driver,buttonExportCsvAllWires);
        Thread.sleep(4000);
    }

    public void selectLoadFromSchematic() throws InterruptedException {
        customCommand.longWaitForElementToBeClickable(driver, buttonLoadFromSchematicOnWireEditor);
        customCommand.javaScriptClick(driver, buttonLoadFromSchematicOnWireEditor);
    }

    public void verifyLoadSchematicWindowOpened() {
        customCommand.waitForElementVisibility(driver,formLoadSchematic);
        Assert.assertTrue(formLoadSchematic.isDisplayed(),"LoadFromSchematic form is not displayed");
    }

    public void selectTaskToBeLoaded(String schematicTaskName) throws InterruptedException {
        Thread.sleep(2000);
        WebElement eleTaskRadio = driver.findElement(By.xpath("//form[@name=\"loadFromSchematicForm\"]//input[@name=\"schtask\"][contains(@value,'"+schematicTaskName+"')]"));
        customCommand.scrollIntoView(driver,eleTaskRadio);
        customCommand.javaScriptClick(driver,eleTaskRadio);
        Thread.sleep(2000);
        customCommand.scrollIntoView(driver,buttonNextLoadFromSchematic);
        customCommand.javaScriptClick(driver,buttonNextLoadFromSchematic);
        customCommand.longWaitForElementToBeClickable(driver,buttonSubmitLoadFromSchematic);
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver,buttonSubmitLoadFromSchematic);
        customCommand.longWaitForElementToBeClickable(driver,buttonGoToDrawing);
    }

    public int getWiresCountOnWireEditor() {
        customCommand.longWaitForElementToBeClickable(driver,buttonGoToDrawing);
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(wireEditorRows)));
        int numberOfWiresOnEditor = driver.findElements(By.cssSelector(wireEditorRows)).size();
        return numberOfWiresOnEditor;
    }
    public int getConnectorsCountOnConnectorEditor() {
        customCommand.longWaitForElementToBeClickable(driver,buttonGoToDrawing);
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(connectorEditorRows)));
        int numberOfConnectorsOnEditor = driver.findElements(By.cssSelector(connectorEditorRows)).size();
        return numberOfConnectorsOnEditor;
    }

    public void selectAllWiresOnEditor() throws InterruptedException {
        customCommand.waitForElementToBeClickable(driver,buttonSelectALlWiresOnEditor);
        customCommand.javaScriptClick(driver,buttonSelectALlWiresOnEditor);
    }
    public void selectAllConnectorsOnConnectorEditor() throws InterruptedException {
        customCommand.waitForElementToBeClickable(driver,buttonSelectALlConnectorsOnEditor);
        customCommand.javaScriptClick(driver,buttonSelectALlConnectorsOnEditor);
    }

    public void submitWires() throws InterruptedException {
        customCommand.scrollToElement(driver,buttonSubmitWireEditor);
        customCommand.javaScriptClick(driver,buttonSubmitWireEditor);
    }

    public void submitConnectorEditorChanges() throws InterruptedException {
        customCommand.scrollToElement(driver,buttonSubmitConnectorEditor);
        customCommand.javaScriptClick(driver,buttonSubmitConnectorEditor);
    }

    public void saveWireChanges() throws InterruptedException {
        customCommand.waitForElementToBeClickable(driver,buttonSaveWireEditor);
        customCommand.javaScriptClick(driver,buttonSaveWireEditor);
    }
    public void saveConnectorEditorChanges() throws InterruptedException {
        customCommand.waitForElementToBeClickable(driver,buttonSaveConnectors);
        customCommand.javaScriptClick(driver,buttonSaveConnectors);
    }

    public String getIdOfRelativeNode()
    {
        WebElement ele=driver.findElement(By.xpath("//*[name()='g' and @id='layer_drawNodes']/*[name()='g'][3]"));
        String id=ele.getAttribute("id");
        id=id.substring(2);
        return id;
    }

    public Point getCurrentPositionOfNode()
    {
        WebElement ele=driver.findElement(By.xpath("//*[name()='g' and @id='layer_drawNodes']/*[name()='g'][3]"));
        Point p=ele.getLocation();
        return p;
    }

    public void autoArrangeHanress() throws InterruptedException {
        customCommand.javaScriptClick(driver,autoArrange);
    }

    public void toggleOnTheSpliceImage() throws InterruptedException {
        String command="toggleallspliceimage 1";
        HarnessPage harnessPage = new HarnessPage(driver);
        harnessPage.fillCommandLine(command);
        harnessPage.clickOnCommandLineOK();
        harnessPage.waitBetweenHarnessActions();
    }

    public void moveSpliceImages() throws InterruptedException {
        for(WebElement ele:spliceImageNodes)
        {
            String id="DN"+ele.getAttribute("data-uid");
            id=id.substring(2);
            WebElement node=driver.findElement(By.xpath("(//*[name()='g' and @data-uid='"+id+"'])[1]/*[name()='rect'][1]"));
            customCommand.javaScriptClick(driver,moveButton);
            Thread.sleep(2000);
            zoomIn.click();
            Thread.sleep(2000);
            node.click();
            Thread.sleep(2000);
            customCommand.moveByOffsetOfElementAndClick(driver,node,0,-50);
        }
    }

    public void showWireLocations() throws InterruptedException {
        for(WebElement ele:splices)
        {
            new HarnessPage(driver).getContextMenu("",ele);
            Thread.sleep(2000);
            customCommand.javaScriptClick(driver,showLocation);
            Thread.sleep(2000);
        }
    }

    public void scaleUpImages() throws InterruptedException {
        customCommand.javaScriptClick(driver,imageViews);
        customCommand.javaScriptClick(driver,updateView);
        customCommand.javaScriptClick(driver,loadingCheckBox);
        customCommand.javaScriptClick(driver,sideCheckBox);
        customCommand.javaScriptClick(driver,updateScale);
        customCommand.clearAndEnterText(LoadingInputBox,"1.5");
        customCommand.clearAndEnterText(sideInputBox,"1.5");
        customCommand.javaScriptClick(driver,submitButtonImageView);
        customCommand.javaScriptClick(driver,yesButton);
    }

    public void ImageViewsLoadingSide() throws InterruptedException {
        customCommand.javaScriptClick(driver,imageViews);
        customCommand.javaScriptClick(driver,updateView);
        customCommand.javaScriptClick(driver,loadingCheckBox);
        customCommand.javaScriptClick(driver,sideCheckBox);
        customCommand.javaScriptClick(driver,submitButtonImageView);
        customCommand.javaScriptClick(driver,yesButton);
    }
    public void ImageViewsTopIsometric() throws InterruptedException {
        customCommand.javaScriptClick(driver,imageViews);
        customCommand.javaScriptClick(driver,updateView);
        for(int i=0;i<3;i++)
        {
            topInput.get(i).click();
            isometricInput.get(i).click();
        }
        customCommand.javaScriptClick(driver,submitButtonImageView);
        customCommand.javaScriptClick(driver,yesButton);
    }
    public void ImageViewsMatingCatalogue() throws InterruptedException {
        customCommand.javaScriptClick(driver,imageViews);
        customCommand.javaScriptClick(driver,updateView);
       for(WebElement we:matingInput)
       {
           we.click();
       }
        for(int i=0;i<3;i++)
        {
            catalogueInput.get(i).click();
        }
        customCommand.javaScriptClick(driver,submitButtonImageView);
        customCommand.javaScriptClick(driver,yesButton);
    }

    public void moveWireLeads() throws InterruptedException {
        new HarnessPage(driver).getContextMenu("",connectorImageWire10);
        customCommand.javaScriptClick(driver,moveWireLeads);
        customCommand.dragAndDropByOffset(driver,wire10,-50,0);
        new HarnessPage(driver).getContextMenu("",connectorImageWire10);
        customCommand.javaScriptClick(driver,saveWireLeads);
        new HarnessPage(driver).getContextMenu("",connectorImageWire4);
        customCommand.javaScriptClick(driver,moveWireLeads);
        customCommand.dragAndDropByOffset(driver,wire4,-50,0);
        new HarnessPage(driver).getContextMenu("",connectorImageWire4);
        customCommand.javaScriptClick(driver,saveWireLeads);
    }

    public int toggleConnectorLabel() throws InterruptedException {
        customCommand.javaScriptClick(driver,connectorLabel);
        Thread.sleep(2000);
        return connectorLabelsCount.size();
    }

    public void openProfileSettingPage(String function,String word) throws InterruptedException {
        String currentWindowHandle = driver.getWindowHandle();
        String URL= driver.getCurrentUrl();
        String taskID=customCommand.extractTaskID(URL);
        customCommand.javaScriptClick(driver,openButton);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        new LoginPage(driver).load(EndPoint.PROFILE.url.replace("profileName",System.getProperty("profileName")));
        if(function.toLowerCase().contains("macro"))
        {
            openMacrosSetting();
            addMacrosLabel(taskID);
        } else if (function.toLowerCase().contains("harness_cavity"))
        {
            openHarnessSetting();
            changeConfigOnHarnessCavity(taskID,word);
        }
        driver.switchTo().window(currentWindowHandle);
        customCommand.javaScriptClick(driver,refreshButton);
    }
    public void openMacrosSetting() throws InterruptedException {
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver,GeneralMenuSelection);
        customCommand.mouseHover(driver,GeneralMenuSelection);
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver,macros);
    }

    public void changeConfigOnHarnessCavity(String task,String yes_no) throws InterruptedException {
        customCommand.selectDropDownByValue(hideEmptyColmn,yes_no);
        WebElement sealPN=driver.findElement(By.xpath("//span[text()='Seal PN']/../..//select[@name='showhide']"));
        WebElement plugPN=driver.findElement(By.xpath("//span[text()='Plug PN']/../..//select[@name='showhide']"));
        WebElement terminalPN=driver.findElement(By.xpath("//span[text()='Terminal PN']/../..//select[@name='showhide']"));
        WebElement terminalMaterial=driver.findElement(By.xpath("//span[text()='Terminal Material']/../..//select[@name='showhide']"));
        WebElement terminalLength=driver.findElement(By.xpath("//span[text()='Terminal Strip Length']/../..//select[@name='showhide']"));
        WebElement terminalFinish=driver.findElement(By.xpath("//span[text()='Terminal Finish']/../..//select[@name='showhide']"));

        customCommand.scrollToElement(driver,plugPN);
        customCommand.selectDropDownByValue(plugPN,yes_no);
        customCommand.scrollToElement(driver,sealPN);
        customCommand.selectDropDownByValue(sealPN,yes_no);
        customCommand.scrollToElement(driver,terminalPN);
        customCommand.selectDropDownByValue(terminalPN,yes_no);
        customCommand.scrollToElement(driver,terminalMaterial);
        customCommand.selectDropDownByValue(terminalMaterial,yes_no);
        customCommand.scrollToElement(driver,terminalLength);
        customCommand.selectDropDownByValue(terminalLength,yes_no);
        customCommand.scrollToElement(driver,terminalFinish);
        customCommand.selectDropDownByValue(terminalFinish,yes_no);
        customCommand.scrollToElement(driver,submitButtonType);
        customCommand.javaScriptClick(driver,submitButtonType);
        saveTask(task);
    }

    public void openHarnessSetting() throws InterruptedException {
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver,HarnessMenuSelection);
        customCommand.mouseHover(driver,HarnessMenuSelection);
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver,connectorCavityTable);
    }

    public void addMacrosLabel(String task) throws InterruptedException {
        customCommand.scrollToElement(driver,macrosLabel);
        customCommand.clearAndEnterText(macrosLabel,"@@ConnectorID#\n" +
                "@@Functional Description#\n" +
                "@@Short Name#\n" +
                "@@Connector Part Description#");
        new GeneralMacrosPage(driver).clickSaveButton();
        saveTask(task);
    }

    public void saveTask(String task) throws InterruptedException {
        customCommand.clearAndEnterText(searchInput,task);
        Thread.sleep(2000);
        WebElement ele=driver.findElement(By.xpath("//input[@id='"+task+"']"));
        ele.click();
        customCommand.javaScriptClick(driver,submitButtonType);
    }

    public void addNewFrame() throws InterruptedException {
        String command="insertframe 0mm,0mm DRA1_SHT8 2 1 5 0 yes";
        HarnessPage harnessPage = new HarnessPage(driver);
        harnessPage.fillCommandLine(command);
        harnessPage.clickOnCommandLineOK();
        harnessPage.waitBetweenHarnessActions();
    }

    public void addWireTable() throws InterruptedException {
        String command="wiretable 602.5mm,75mm";
        HarnessPage harnessPage = new HarnessPage(driver);
        harnessPage.fillCommandLine(command);
        harnessPage.clickOnCommandLineOK();
        harnessPage.waitBetweenHarnessActions();
    }

    public void updateWireTable() throws InterruptedException {
        customCommand.javaScriptClick(driver,inspectButton);
        customCommand.javaScriptClick(driver,serialNoTable);
        customCommand.waitForElementVisibility(driver,tableLayout);
        customCommand.javaScriptClick(driver,tableLayout);
        for(WebElement ele:selectYesOption)
        {
            customCommand.scrollToElement(driver,ele);
            customCommand.selectDropDownByValue(ele,"no");
        }
        customCommand.javaScriptClick(driver,submitButton);
    }
    public List<String> getWireEditorHeaders(){
        List<String> headersToBeReturned = new ArrayList<>();
        List<WebElement> listOfHeaders = driver.findElements(By.xpath(wireEditorHeaders));
        for (WebElement ele: listOfHeaders){
            headersToBeReturned.add(ele.getAttribute("placeholder"));
        }
        return headersToBeReturned;
    }

    public void showHideHeaders(int numberOfHeaders) throws InterruptedException {
        customCommand.waitClick(toggleButtonShowHideHeaders);
        Thread.sleep(2000);
        WebElement radioButton = driver.findElements(By.cssSelector("div#wire-editor button.dropdown-toggle+ul")).get(0);
        for (int i=0; i<numberOfHeaders; i++){
            customCommand.javaScriptClick(driver,radioButton.findElements(By.cssSelector("li label>input")).get(i));
        }
        customCommand.waitClick(toggleButtonShowHideHeaders);
        Thread.sleep(2000);
    }

    public void showAllHeaders() throws InterruptedException {
        customCommand.waitClick(toggleButtonShowHideHeaders);
        Thread.sleep(2000);
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("div#wire-editor button.dropdown-toggle+ul"));
        List<WebElement> lisOfCheckboxes = radioButtons.get(0).findElements(By.cssSelector("li label>input"));
        for(WebElement ele: lisOfCheckboxes){
            if(!ele.isSelected()){
                customCommand.javaScriptClick(driver,ele);
            }
        }
        customCommand.waitClick(toggleButtonShowHideHeaders);
        Thread.sleep(2000);
    }



    public void verifyShowHideWireEditorColumns() throws InterruptedException {
        try {
            showAllHeaders();
            List<String> headersShownOnWireEditor = getWireEditorHeaders();
            int headerCountBeforeHide = headersShownOnWireEditor.size();
            showHideHeaders(5);
            List<String> headersShownOnWireEditorAfterHide = getWireEditorHeaders();
            int headerCountAfterHide = headersShownOnWireEditorAfterHide.size();
            Assert.assertEquals(headerCountAfterHide,headerCountBeforeHide-5);
            Assert.assertNotEquals(headersShownOnWireEditorAfterHide,headersShownOnWireEditor);
            showAllHeaders();
        }
        catch (Exception e){
            showAllHeaders();
        }
    }

    public void openLoadWiresForm() throws InterruptedException {
        customCommand.waitForElementToBeClickable(driver,advancedTab);
        customCommand.javaScriptClick(driver,advancedTab);
        customCommand.scrollIntoView(driver,buttonLoadWiresFromSchematicOnDrawing);
        customCommand.javaScriptClick(driver,buttonLoadWiresFromSchematicOnDrawing);
    }

    public void verifyLoadWiresFromSchematicOnDrawingOpened() {
        customCommand.waitForElementVisibility(driver,formChooseSchematic);
        Assert.assertTrue(formChooseSchematic.isDisplayed(),"LoadWiresFromSchematic form is not displayed on drawing");
    }

    public void submitAndVerifyLoadWiresDetails(String schematicTaskName) throws InterruptedException {
        Thread.sleep(4000);
        customCommand.selectDropDownByContainsText(dropdownSelectSchematic, schematicTaskName);
        customCommand.scrollIntoView(driver,dropdownSelectAutoArrange);
        customCommand.selectDropDownByValue(dropdownSelectAutoArrange,"true");
        customCommand.scrollIntoView(driver,labelSelectAllProperties);
        customCommand.javaScriptClick(driver,checkboxSelectAllProperties);
        customCommand.javaScriptClick(driver,buttonSubmitDetails);
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver,headingWireImportInformation);
        Assert.assertTrue(headingWireImportInformation.isDisplayed(),"WireImportInformation form is not displayed on drawing");
        Thread.sleep(2000);
        int numberOfWiresImported = driver.findElements(By.xpath(wiresImportedRows)).size();
        customCommand.javaScriptClick(driver,buttonSubmitDetails);
        Thread.sleep(4000);
        customCommand.waitForElementVisibility(driver,elementWiresImportedSuccessfully);
        int numberOfWiresAfterImport = driver.findElements(By.xpath(wiresImportedRows)).size();
        Assert.assertEquals(numberOfWiresAfterImport,numberOfWiresImported);
        Assert.assertEquals(String.valueOf(numberOfWiresAfterImport),elementWiresImportedSuccessfully.getText());
        customCommand.javaScriptClick(driver, buttonCloseWindow);
        int wiresOnDrawing = getWiresCount();
        Assert.assertEquals(wiresOnDrawing,numberOfWiresAfterImport);
    }

    public void importWiresCsvOnWireEditor(String filePath) throws InterruptedException {
        Thread.sleep(3000);
        customCommand.longWaitForElementToBeClickable(driver, buttonGoToDrawing);
        Thread.sleep(3000);
        WebElement import_csv = driver.findElement(By.name("fileImportCSV"));
        customCommand.waitForElementToBeClickable(driver,import_csv);
        File fileToBeImported = new File(filePath);
        String file = fileToBeImported.getAbsolutePath();
        import_csv.sendKeys(file);
        new AddNewComponentPage(driver).acceptConfirmationPopup();
        Thread.sleep(3000);
    }

    public void selectSchematicInfoTabFromLeftPane() throws InterruptedException {
        customCommand.waitForElementToBeClickable(driver,tabSchematicInfoLeftPane);
        customCommand.javaScriptClick(driver,tabSchematicInfoLeftPane);
    }

    public void enterSchematicDetailsOnLeftPane(String schematicTaskName) throws InterruptedException {
        customCommand.waitForElementVisibility(driver,selectProjectListLeftPane);
        customCommand.waitForElementToBeClickable(driver,selectProjectListLeftPane);
        customCommand.waitForElementToBeClickable(driver,selectSchematicLeftPane);
        customCommand.selectDropDownByContainsText(selectSchematicLeftPane, schematicTaskName);
        customCommand.scrollIntoView(driver,labelSelectAllPropertiesToCompare);
        customCommand.javaScriptClick(driver,checkboxSelectAllPropertiesToCompare);
        customCommand.javaScriptClick(driver,buttonSaveSchematicInfo);
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver,buttonConfigureSchematicInfo);
    }

    public void selectSheetsTabFromLeftPane() throws InterruptedException {
        customCommand.waitForElementToBeClickable(driver,tabSheetsLeftPane);
        customCommand.javaScriptClick(driver,tabSheetsLeftPane);
    }

    public void syncSchematicLeftPane() throws InterruptedException {
        customCommand.javaScriptClick(driver,buttonSyncSchematic);
        new CommonElements(driver).verifyAlertMessage("This will update changes from schematic into the harness. Do you want to continue?");
        new CommonElements(driver).acceptAlertMessage();
        Thread.sleep(5000);
        customCommand.waitForElementVisibility(driver,headingModifiedComponents);
        customCommand.javaScriptClick(driver, buttonCloseWindow);
    }

    public void loadSchematicOnConnectorEditor() throws InterruptedException {
        customCommand.longWaitForElementToBeClickable(driver, buttonLoadFromSchematicOnConnectorEditor);
        customCommand.javaScriptClick(driver, buttonLoadFromSchematicOnConnectorEditor);
    }

    public int varifyHiddenColumns()
    {
       return cavityTableColumn.size();
    }

    public void addTerminalPartNo() throws InterruptedException {
        customCommand.javaScriptClick(driver,refreshButton);
        customCommand.javaScriptClick(driver,selectButton);
        new HarnessPage(driver).getContextMenu("",connector);
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver,inspectContextMenu);
        customCommand.scrollToElement(driver,cavityTable);
        customCommand.javaScriptClick(driver,cavityTable);
        customCommand.javaScriptClick(driver,terminalGetDetails);
        customCommand.clearAndEnterText(terminalartNo,"0-0444335-2");
        customCommand.javaScriptClick(driver,arrowButton);
        customCommand.javaScriptClick(driver,populate);
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver,submitButtonCavity);
    }

    public void undo() throws InterruptedException {
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver,undoButton);
        Thread.sleep(2000);
    }

    public void updateTerminal(String selectType) throws InterruptedException {
        String yesno="no";
        customCommand.javaScriptClick(driver,selectButton);
        if(selectType.equalsIgnoreCase("select"))
        {
            yesno="yes";
        }
        new HarnessPage(driver).getContextMenu("",connector);
        customCommand.javaScriptClick(driver,updateCavity);
        customCommand.selectDropDownByValue(overwriteSelect,"yes");
        customCommand.selectDropDownByValue(checkOD,"yes");
        customCommand.selectDropDownByValue(termfamily,yesno);
        customCommand.selectDropDownByValue(termtype,"no");
        customCommand.selectDropDownByValue(termfinish,yesno);
        customCommand.selectDropDownByValue(termmaterial,yesno);
        customCommand.selectDropDownByValue(termgender,yesno);
        customCommand.javaScriptClick(driver,SubmitWire);
        customCommand.javaScriptClick(driver,selectAll);
        customCommand.javaScriptClick(driver,buttonSubmitDetails);
        Thread.sleep(2000);
    }

    public void addInvalidFieldInCavity() throws InterruptedException {
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver,refreshButton);
        Thread.sleep(2000);
//        new HarnessPage(driver).getContextMenu("",connector2);
        customCommand.javaScriptClick(driver,inspectButton);
        customCommand.javaScriptClick(driver,connector);
        customCommand.scrollToElement(driver,cavityTable);
        customCommand.javaScriptClick(driver,cavityTable);
        customCommand.clearAndEnterText(termFamily,"autoamtionUser");
        customCommand.javaScriptClick(driver,submitFontUpdate);
    }

    public int checkErrors() throws InterruptedException {
        int count= errorTableRows.size();
        customCommand.javaScriptClick(driver,footerCLoseButton);
        Thread.sleep(2000);
        return count;
    }

    public void exportHarnessCavity() throws InterruptedException {
        String path = System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles";
        customCommand.clearFolder(path);
        customCommand.javaScriptClick(driver,refreshButton);
        new HarnessPage(driver).getContextMenu("",connector);
        customCommand.javaScriptClick(driver,updateCavity);
        customCommand.selectDropDownByValue(updateType,"manual");
        customCommand.javaScriptClick(driver,exportButton);
    }

    public boolean importHarnessCavity() throws InterruptedException {
        String path="src/test/resources/drawingboard/HAR_cavity_Import_New.csv";
        new HarnessPage(driver).getContextMenu("",connector);
        customCommand.javaScriptClick(driver,updateCavity);
        customCommand.selectDropDownByValue(updateType,"manual");
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        uploadFile.sendKeys(absolutePath);
        customCommand.javaScriptClick(driver,buttonSubmitDetails);
        Thread.sleep(5000);
        return summaryReport.isDisplayed();
    }

    public int validateImportOnUI() throws InterruptedException {
        customCommand.javaScriptClick(driver,footerCLoseButton);
        return columnChangedTable.size();
    }

    public void crossRef(String type) throws InterruptedException {
        customCommand.javaScriptClick(driver,updateCrossRef);
        customCommand.selectDropDownByValue(componentDB,"quickstart");
        if(type.equalsIgnoreCase("manufacture"))
        {
            customCommand.selectDropDownByValue(companyDropdwon,"Manufacturer");
            manufactureInput.click();
        }
        else{
            customCommand.selectDropDownByValue(companyDropdwon,"Supplier");
            supplierInput.click();
        }
        customCommand.javaScriptClick(driver,submitButton);
        Thread.sleep(2000);
    }

    public boolean checkCrossRef(String type)
    {
        if(type.equalsIgnoreCase("manufacture"))
        {
            return ManuLabel.isDisplayed();
        }
        else{
           return SupplierLabel.isDisplayed();
        }
    }

    public void moveSkeletonRelatively() throws InterruptedException {
        customCommand.javaScriptClick(driver,zoomFit);
        WebElement we=driver.findElement(By.xpath("//*[name()='g' and contains(@class,'DG28')]/*[name()='g']/*[name()='g']"));
        customCommand.javaScriptClick(driver,relativeButton);
        we.click();
        customCommand.moveByOffsetOfElementAndClick(driver,we,25,-20);
        we.click();
    }

    public boolean setLength() throws InterruptedException {
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver,selectButton);
        customCommand.javaScriptClick(driver,zoomIn);
        customCommand.javaScriptClick(driver,zoomIn);

        customCommand.moveRightOfElementAndContextClick(driver,bundle,40);

        setLength.click();
        setLength.sendKeys("100");
        customCommand.javaScriptClick(driver,inspectButton);
        customCommand.moveByOffsetOfElementAndClick(driver,bundle,40,0);
        String text=setLengthInput.getAttribute("value");
        if(text.contains("100"))
            return true;
        else
            return false;
    }

    public boolean drawnLength() throws InterruptedException {
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver,moveButton);
        bundle.click();
        customCommand.moveByOffsetOfElementAndClick(driver,bundle,-40,0);
        customCommand.javaScriptClick(driver,inspectButton);
        customCommand.moveByOffsetOfElementAndClick(driver,bundle,40,0);
        String text=drawnLength.getText();
        text= Arrays.stream(text.split("m")).findFirst().toString();
        if(text.contains("170"))
            return true;
        else
            return false;
    }
}
