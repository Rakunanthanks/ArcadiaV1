package arcadia.pages;

import arcadia.context.FlowContext;
import arcadia.pages.ComponentDB.CommonElements;
import arcadia.utils.ConversionUtil;
import arcadia.utils.SeleniumCustomCommand;
import com.sun.jna.platform.win32.WinCrypt;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.util.List;
import java.util.Objects;

public class UpdateFontsPage extends BasePage {
    @FindBy(css = "#idselectform > div.box-header.with-border > div > a")
    private WebElement buttonResetToDefaults;
    @FindBy(css = "#nodesttings > div > table > tbody > tr:nth-child(1) > td:nth-child(3) > input")
    private WebElement nodeChildElementName;
    @FindBy(css = "div.modal-footer button[data-bb-handler=\"confirm\"]")
    private WebElement confirmationPopUpOkButton;
    @FindBy(css = "button[value='Save']")
    private WebElement saveButton;
    @FindBy(css = "input[name='Nodechildelesize']")private WebElement nodeChildElementSize;
    @FindBy(css="input[name='Nodechildelecol']")private WebElement nodeChildElementColour;
    @FindBy(css = "input[name='Nodenamesize']")private WebElement nodeNameSize;
    @FindBy(css="input[name='Nodenamecol']")private WebElement nodeNameColour;
    @FindBy(css = "input[name='Nodefuncdescsize']")private WebElement nodeFunctionalDescSize;
    @FindBy(css="input[name='Nodefuncdesccol']")private WebElement nodeFunctionalDescColour;
    @FindBy(css = "input[name='Nodeattpartsize']")private WebElement nodeAttachPartsSize;
    @FindBy(css="input[name='Nodeattpartcol']")private WebElement nodeAttachPartsColour;
    @FindBy(css = "input[name='NodeattpartNamesize']")private WebElement nodeAttachPartNameSize;
    @FindBy(css="input[name='NodeattpartNamecol']")private WebElement nodeAttachPartNameColour;
    @FindBy(css = "button[title=\"Submit\"]") private WebElement buttonSubmitDetails;
    @FindBy(css = ".complabel") private WebElement complabel;
    @FindBy(css = "#childele")private WebElement nodeChildElementCheckBox;
    @FindBy(css = "#name")private WebElement nodeNameCheckBox;
    @FindBy(css = "div.msgBoxContainer>div.msgBoxContent span")
    private WebElement alertMessageBox;
    @FindBy(css = "input[value='OK']")
    private WebElement buttonAcceptMessage;
    @FindBy(css="input[name='node.functiondescription']")private WebElement functionalDescription;
    @FindBy(css="#funcdesc")private WebElement functionalDescriptionCheckBox;
    @FindBy(css="#attpart")private WebElement attachPartCheckBox;
    @FindBy(css = "#layer_85 > g > g:nth-child(1) > text")private WebElement attachPartsDetails;
    @FindBy(css = "input[name=\"node.attachpart.partname\"]")private WebElement attachPartName;
    @FindBy(css="#attpartName")private WebElement attachPartNameCheckBox;
    @FindBy(css="input[name='Bundlenamesize']")private WebElement bundleNameFontSize;
    @FindBy(css="input[name='Bundlenamecol']")private WebElement bundleNameColor;
    @FindBy(css="input[name='Bundlelengthsize']")private WebElement bundleLengthFontSize;
    @FindBy(css="input[name='Bundlelengthcol']")private WebElement bundleLengthColor;
    @FindBy(css="input[name='Bundlesubdimensionsize']")private WebElement bundleSubDimensionLengthFontSize;
    @FindBy(css="input[name='Bundlesubdimensioncol']")private WebElement bundleSubDimensionColor;
    @FindBy(css="input[name='Bundlecoveringssize']")private WebElement bundleCoveringsFontSize;
    @FindBy(css="input[name='Bundlecoveringscol']")private WebElement bundleCoveringColor;
    @FindBy(css="input[name='Bundlebreaksize']")private WebElement bundleBreakFontSize;
    @FindBy(css="input[name='Bundlebreakcol']")private WebElement bundleBreakColor;
    @FindBy(css="input[name='Bundle_Bundlenamesize']")private WebElement bundleNameCheckBox;
    @FindBy(css="input[name='Connectornamesize']")private WebElement connectorCavityNameSize;
    @FindBy(css="input[name='Connectornamecol']")private WebElement connectorCavityNameColour;
    @FindBy(css="input[name='Connector_Connectornamesize']")private WebElement connectorCavityNameCheckBox;
    @FindBy(css="input[name='Connectorfuncdescsize']")private WebElement connectorCavityFuncDescSize;
    @FindBy(css="input[name='Connectorfuncdesccol']")private WebElement connectorCavityFuncDescColour;
    @FindBy(css="input[name='Connector_Connectorfuncdescsize']")private WebElement connectorCavityFuncDescCheckBox;
    @FindBy(css="input[name='Connectornodedescsize']")private WebElement connectorCavityNodeDescSize;
    @FindBy(css="input[name='Connectornodedesccol']")private WebElement connectorCavityNodeDescColour;
    @FindBy(css="input[name='Connector_Connectornodedescsize']")private WebElement connectorCavityNodeDescCheckBox;
    @FindBy(css="input[name='Connectorpartnosize']")private WebElement connectorCavityPartNumberSize;
    @FindBy(css="input[name='Connectorpartnocol']")private WebElement connectorCavityPartNumberColour;
    @FindBy(css="input[name='Connector_Connectorpartnosize']")private WebElement connectorCavityPartNumberCheckBox;
    @FindBy(css="input[name='Connectorattpartsize']")private WebElement connectorCavityAttachedPartSize;
    @FindBy(css="input[name='Connectorattpartcol']")private WebElement connectorCavityAttachedPartColour;
    @FindBy(css="input[name='Connector_Connectorattpartsize']")private WebElement connectorCavityAttachedPartCheckBox;
    @FindBy(css="input[name='Connectorterminalssize']")private WebElement connectorCavityTerminalsSize;
    @FindBy(css="input[name='Connectorterminalscol']")private WebElement connectorCavityTerminalsColour;
    @FindBy(css="input[name='Connector_Connectorterminalssize']")private WebElement connectorCavityTerminalsCheckBox;
    @FindBy(css="input[name='Connectorsealssize']")private WebElement connectorCavitySealsSize;
    @FindBy(css="input[name='Connectorsealscol']")private WebElement connectorCavitySealsColour;
    @FindBy(css="input[name='Connector_Connectorsealssize']")private WebElement connectorCavitySealsCheckBox;
    @FindBy(css="input[name='Connectorplugssize']")private WebElement connectorCavityPlugsSize;
    @FindBy(css="input[name='Connectorplugscol']")private WebElement connectorCavityPlugsColour;
    @FindBy(css="input[name='Connector_Connectorplugssize']")private WebElement connectorCavityPlugsCheckBox;
    @FindBy(css="input[name='Connectorcongrpidsize']")private WebElement connectorCavityGroupIdSize;
    @FindBy(css="input[name='Connectorcongrpidcol']")private WebElement connectorCavityGroupIdColour;
    @FindBy(css="input[name='Connector_Connectorcongrpidsize']")private WebElement connectorCavityGroupIdCheckBox;
    @FindBy(css="input[name='Connectortermimageqtysize']")private WebElement connectorCavityTerminalImageQuantitySize;
    @FindBy(css="input[name='Connectortermimageqtycol']")private WebElement connectorCavityTerminalImageQuantityColour;
    @FindBy(css="input[name='Connector_Connectortermimageqtysize']")private WebElement connectorCavityTerminalImageQuantityCheckBox;
    @FindBy(css="input[name='Connectortermimageqtysize']")private WebElement connectorCavityTerminalImagePartNumberSize;
    @FindBy(css="input[name='Connectortermimageqtycol']")private WebElement connectorCavityTerminalImagePartNumberColour;
    @FindBy(css="input[name='Connector_Connectortermimageqtysize']")private WebElement connectorCavityTerminalImagePArtNumberCheckBox;
    @FindBy(css="input[name='Connectortablesize']")private WebElement connectorCavityTableFontSize;
    @FindBy(css="input[name='Connector_Connectortablesize']")private WebElement connectorCavityTableFontCheckBox;
    @FindBy(css="input[name='Splicenamesize']")private WebElement spliceCavityNameSize;
    @FindBy(css="input[name='Splicenamecol']")private WebElement spliceCavityNameColour;
    @FindBy(css="input[name='Splice_Splicenamesize']")private WebElement spliceCavityNameCheckbox;
    @FindBy(css="input[name='Splicefuncdescsize']")private WebElement spliceCavityFunctionDescriptionSize;
    @FindBy(css="input[name='Splicefuncdesccol']")private WebElement spliceCavityFunctionDescriptionColour;
    @FindBy(css="input[name='Splice_Splicefuncdescsize']")private WebElement spliceCavityFunctionDescriptionCheckbox;
    @FindBy(css="input[name='Splicenodedescsize']")private WebElement spliceCavityNodeDescriptionSize;
    @FindBy(css="input[name='Splicenodedesccol']")private WebElement spliceCavityNodeDescriptionColour;
    @FindBy(css="input[name='Splice_Splicenodedescsize']")private WebElement spliceCavityNodeDescriptionCheckbox;
    @FindBy(css="input[name='Splicepartnosize']")private WebElement spliceCavityPartNumberSize;
    @FindBy(css="input[name='Splicepartnocol']")private WebElement spliceCavityPartNumberColour;
    @FindBy(css="input[name='Splice_Splicepartnosize']")private WebElement spliceCavityPartNumberCheckbox;
    @FindBy(css="input[name='Spliceattpartsize']")private WebElement spliceCavityAttachedPartsSize;
    @FindBy(css="input[name='Spliceattpartcol']")private WebElement spliceCavityAttachedPartsColour;
    @FindBy(css="input[name='Splice_Spliceattpartsize']")private WebElement spliceCavityAttachedPartsCheckbox;
    @FindBy(css="input[name='Splicetablesize']")private WebElement spliceCavityTableFontSize;
    @FindBy(css="input[name='Splice_Splicetablesize']")private WebElement spliceCavityTableFontCheckbox;
    @FindBy(css="input[name='Connector Labelidsize']")private WebElement connectorLabelSize;
    @FindBy(css="input[name='Connector Labelidcol']")private WebElement connectorLabelColour;
    @FindBy(css="input[name='Connector Label_Connector Labelidsize']")private WebElement ConnectorLabelCheckbox;
    @FindBy(css="input[name='Harness Labelharlabelsize']")private WebElement harnessLabelSize;
    @FindBy(css="input[name='Harness Labelharlabelcol']")private WebElement harnessLabelColour;
    @FindBy(css="input[name='Harness Label_Harness Labelharlabelsize']")private WebElement harnessLabelCheckbox;
    @FindBy(css="input[name='MANUFACTURING Tabletablesize']")private WebElement manufacturingTableFontSize;
    @FindBy(css="input[name='MANUFACTURING Table_MANUFACTURING Tabletablesize']")private WebElement manufacturingTableFontCheckbox;
    @FindBy(css="input[name='BOM Tabletablesize']")private WebElement harnessBomTableFontSize;
    @FindBy(css="input[name='BOM Table_BOM Tabletablesize']")private WebElement harnessBomTableCheckBox;
    @FindBy(css="input[name='WIRE Tabletablesize']")private WebElement wireTableFontSize;
    @FindBy(css="input[name='WIRE Table_WIRE Tabletablesize']")private WebElement wireTableCheckBox;
    @FindBy(css="input[name='bomtablelayout.fontSize']")private WebElement bomTableFontInProperties;
    @FindBy(css="input[name='manufacturingtablelayout.fontSize']")private WebElement manufacturingTableFontInProperties;
    @FindBy(css="input[name='wiretablelayout.fontSize']")private WebElement wireTableFontInProperties;
    @FindBy(css="input[name='varianttablelayout.fontSize']")private WebElement variantTableFontInProperties;
    @FindBy(css="input[name='revisiontablelayout.fontSize']")private WebElement revisionTableFontInProperties;
    @FindBy(css="#length")private WebElement bundleLengthCheckBox;
    @FindBy(css="#subdimension")private WebElement bundleSubDimensionCheckBox;
    @FindBy(css="#coverings")private WebElement bundleCoveringCheckBox;
    @FindBy(css ="#break")private WebElement bundleBreakCheckBox;
    @FindBy(css = ".ignoreClick")private WebElement bundleCoveringDetails;
    @FindBy(css="#revisionsettings > div > table > tbody > tr > td:nth-child(2) > input")private WebElement revisionTableFontSizeInProfile;
    @FindBy(css="#layer_100 > g.DG8.bundleGroup > text")private WebElement subDimensionText;
    @FindBy(css="#layer_100 > g.DG99999911.bundleGroup > text")private WebElement formboardSubDimensionText;
    @FindBy(css="#ui-accordion-accordion-header-6")private WebElement connectorTableProperties;
    @FindBy(css="#ui-accordion-accordion-panel-6 > fieldset:nth-child(1) > div:nth-child(3) > input")private WebElement connectorCavityTableFontSizeInProperties;
    @FindBy(css="#consettings > div > table > tbody > tr:nth-child(12) > td:nth-child(2) > input")private WebElement ConnectorCavityTableFontSizeInProfile;
    @FindBy(css = ".ignoreClick[data-extlink='false']")private WebElement cavityLabelDetails;
    @FindBy(css =".ignoreClick[text-anchor='start']")private WebElement connectorPartNumberDescription;
    @FindBy(css=".hyperlink")private WebElement partNumber;
    @FindBy(css="button[title='Submit'] span[class='ui-button-text'] span")private WebElement connectorLabelSubmitButton;
    @FindBy(css = "#iaddconnectorlabel") private  WebElement connectorLabelButton;
    @FindBy(css ="#layer_76 > g > g > text")private WebElement connectorLabelText;
    @FindBy(css="#connectorLableForm > div > table > tbody > tr > td:nth-child(3) > input")private WebElement connectLabelSizeFormboardProfile;
    @FindBy(css="#connectorLableForm > div > table > tbody > tr > td:nth-child(4) > input[type=color]")private WebElement connectLabelColourFormboardProfile;
    @FindBy(css="#harnessLabelForm > div > table > tbody > tr > td:nth-child(3) > input")private WebElement harnessLabelSizeInProfile;
    @FindBy(css="#harnessLabelForm > div > table > tbody > tr > td:nth-child(4) > input[type=color]")private WebElement harnessLabelColourInProfile;
    @FindBy(css="#discretesettings > div > table > tbody > tr > td:nth-child(3) > input")private WebElement discreteComponentsSizeInProfile;
    @FindBy(css="#discretesettings > div > table > tbody > tr > td:nth-child(4) > input[type=color]")private WebElement discreteComponentsColourInProfile;
    @FindBy(css="#bomsettings > div > table > tbody > tr > td:nth-child(2) > input")private WebElement bomTableSizeInProfile;
    @FindBy(css="#wiresettings > div > table > tbody > tr > td:nth-child(2) > input") private WebElement wireTableSizeInProfile;
    @FindBy(css="#variantsettings > div > table > tbody > tr:nth-child(1) > td:nth-child(2) > input")private WebElement variantTableFontSizeInProfile;
    @FindBy(css="#variantsettings > div > table > tbody > tr:nth-child(2) > td:nth-child(2) > input")private WebElement variantTableWrapCountInProfile;
    @FindBy(css="#manufacturesettings > div > table > tbody > tr > td:nth-child(2) > input")private WebElement manufacturingTableFontSizeInProfile;
    @FindBy(css="#ui-accordion-accordion-header-2")private WebElement bomTableProperties;
    @FindBy(xpath = "//div[@title='Draw Select']") private  WebElement drawSelectPointer;
    @FindBy(css="#layer_52 > g > g > foreignObject > table")private WebElement bomTableId;
    @FindBy(css="#ui-accordion-accordion-header-1")private WebElement revisionTableProperties;
    @FindBy(css="input[name='VARIANT Tabletablesize']")private WebElement variantFontSize;
    @FindBy(css="input[name='VARIANT Table_VARIANT Tabletablesize']")private WebElement variantFontSizeCheckbox;
    @FindBy(css="input[name='Discrete Componentsrefsize']")private WebElement discreteComponentsFontSize;
    @FindBy(css="input[name='Discrete Componentsrefcol']")private WebElement discreteComponentsFontColour;
    @FindBy(css="input[name='Discrete Components_Discrete Componentsrefsize']")private WebElement discreteComponentsFontCheckbox;
@FindBy(css="text[x='0.75']")private WebElement discreteComponents;
    public UpdateFontsPage(WebDriver driver) {
        super(driver);
    }

    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();

    String profileFontSize = "3.0";
    String profileNodeFontColour ="#008000";
    String profileFontSizeBundle = "3.5";
    String profileFontColourBundle ="#ff0000";
    String profileFontColourFormboardBundle ="#34f31b";
    String taskFontSize = "8";
    String taskFontColour ="#ff00f0";
    String profileFontColourConnectorFormboard ="#9900ff";
    String profileFontColourConnectorHarness="#00ffff";
    HarnessPage harnessPage = new HarnessPage(driver);
    FormboardPage formboardPage = new FormboardPage(driver);
    NodeLabelVisibilityPage nodeLabelVisibilityPage = new NodeLabelVisibilityPage(driver);

    public void changeFontSizeInProfile(String component,String module) throws InterruptedException {
        customCommand.javaScriptClick(driver, buttonResetToDefaults);
        confirmationPopUpOkButton.click();
        if(Objects.equals(component, "bundle")){
        changeBundleFontSize(module);
        } else if (Objects.equals(component, "connector")) {
            changeConnectorFontSize(module);
        }
        else if (Objects.equals(component, "node")) {
            changeNodeFontSize();
        }
        else if (Objects.equals(component, "splice")) {
            changeSpliceFontSize(module);
        }
    }

    public void saveProfileSettings() throws InterruptedException {
        customCommand.scrollIntoView(driver, saveButton);
        customCommand.javaScriptClick(driver, saveButton);
        new CommonElements(driver).verifyAlertSuccessMessage("Properties updated successfully! Please select the tasks to update the settings");
    }

    public void changeNodeFontSize() throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            WebElement nodeCssSelector = driver.findElement(By.cssSelector("#nodesttings > div > table > tbody > tr:nth-child(" + i + ") > td:nth-child(3) > input"));
            customCommand.javaScriptClickAndEnterValue(driver, nodeCssSelector, profileFontSize);
            WebElement nodeCssColor = driver.findElement(By.cssSelector("#nodesttings > div > table > tbody > tr:nth-child("+i+") > td:nth-child(4) > input[type=color]"));
            customCommand.javaScriptClickAndEnterValue(driver,nodeCssColor,profileNodeFontColour);
        }
    }

    public void changeBundleFontSize(String module) throws InterruptedException {
        for (int i = 1; i <5; i++) {
            WebElement bundleCssSelector = driver.findElement(By.cssSelector("#bundlesettings > div > table > tbody > tr:nth-child(" + i + ") > td:nth-child(3) > input"));
            customCommand.javaScriptClickAndEnterValue(driver, bundleCssSelector, profileFontSizeBundle);
            WebElement bundleCssColor = driver.findElement(By.cssSelector("#bundlesettings > div > table > tbody > tr:nth-child("+i+") > td:nth-child(4) > input[type=color]"));
            System.out.println();
            if(Objects.equals(module, "harness")){
            customCommand.javaScriptClickAndEnterValue(driver,bundleCssColor,profileFontColourBundle);}
            else if (Objects.equals(module, "formboard")) {
                customCommand.javaScriptClickAndEnterValue(driver,bundleCssColor,profileFontColourFormboardBundle);
            }
        }
    }

    public void changeConnectorFontSize(String module) throws InterruptedException {
        for (int i = 1; i < 12; i++) {
            WebElement connectorSelector = driver.findElement(By.cssSelector("#consettings > div > table > tbody > tr:nth-child(" + i + ") > td:nth-child(3) > input"));
            customCommand.javaScriptClickAndEnterValue(driver, connectorSelector, profileFontSize);
            WebElement connectorCssColor = driver.findElement(By.cssSelector("#consettings > div > table > tbody > tr:nth-child("+i+") > td:nth-child(4) > input[type=color]"));
            if(Objects.equals(module, "harness")){
                customCommand.javaScriptClickAndEnterValue(driver,connectorCssColor,profileFontColourConnectorHarness);}
            else if (Objects.equals(module, "formboard")) {
                customCommand.javaScriptClickAndEnterValue(driver,connectorCssColor,profileFontColourConnectorFormboard);
            }
            }
        }


    public void changeSpliceFontSize(String module) throws InterruptedException {
        for (int i = 1; i < 6; i++) {
            WebElement spliceSelector = driver.findElement(By.cssSelector("#splicesettings > div > table > tbody > tr:nth-child(" + i + ") > td:nth-child(3) > input"));
            customCommand.javaScriptClickAndEnterValue(driver, spliceSelector, profileFontSize);
            WebElement spliceCssColor = driver.findElement(By.cssSelector("#splicesettings > div > table > tbody > tr:nth-child("+i+") > td:nth-child(4) > input[type=color]"));
            if(Objects.equals(module, "harness")){
                customCommand.javaScriptClickAndEnterValue(driver,spliceCssColor,profileFontColourConnectorHarness);}
            else if (Objects.equals(module, "formboard")) {
                customCommand.javaScriptClickAndEnterValue(driver,spliceCssColor,profileFontColourConnectorFormboard);
            }
        }
    }


    public void checkTheFontSizeIsAsPerTheProfileOrNot() {
        Assert.assertEquals(nodeChildElementSize.getAttribute("value"),profileFontSize,"Font size of node child element is not matched as per the profile updated");
        Assert.assertEquals(nodeChildElementColour.getAttribute("value"),profileNodeFontColour,"Font Colour of node child element is not matched as per the profile updated");
        Assert.assertEquals(nodeFunctionalDescSize.getAttribute("value"),profileFontSize,"Font size of node child element is not matched as per the profile updated");
        Assert.assertEquals(nodeFunctionalDescColour.getAttribute("value"),profileNodeFontColour,"Font size of node child element is not matched as per the profile updated");
        Assert.assertEquals(nodeNameSize.getAttribute("value"),profileFontSize,"Font size of node child element is not matched as per the profile updated");
        Assert.assertEquals(nodeNameColour.getAttribute("value"),profileNodeFontColour,"Font Colour of node child element is not matched as per the profile updated");
        Assert.assertEquals(nodeAttachPartNameSize.getAttribute("value"),profileFontSize,"Font size of node child element is not matched as per the profile updated");
        Assert.assertEquals(nodeAttachPartNameColour.getAttribute("value"),profileNodeFontColour,"Font Colour of node child element is not matched as per the profile updated");
    }

    public void checkTheFontSizeIsAsPerTheProfileOrNotInBundle() {
        Assert.assertEquals(bundleNameFontSize.getAttribute("value"),profileFontSizeBundle,"Bundle size of node child element is not matched as per the profile updated");
        Assert.assertEquals(bundleNameColor.getAttribute("value"),profileFontColourFormboardBundle,"Bundle Colour of node child element is not matched as per the profile updated");
        Assert.assertEquals(bundleLengthFontSize.getAttribute("value"),profileFontSizeBundle,"Bundle size of node child element is not matched as per the profile updated");
        Assert.assertEquals(bundleLengthColor.getAttribute("value"),profileFontColourFormboardBundle,"Bundle size of node child element is not matched as per the profile updated");
        Assert.assertEquals(bundleSubDimensionLengthFontSize.getAttribute("value"),profileFontSizeBundle,"Bundle size of node child element is not matched as per the profile updated");
        Assert.assertEquals(bundleSubDimensionColor.getAttribute("value"),profileFontColourFormboardBundle,"Bundle Colour of node child element is not matched as per the profile updated");
        Assert.assertEquals(bundleCoveringsFontSize.getAttribute("value"),profileFontSizeBundle,"Bundle size of node child element is not matched as per the profile updated");
        Assert.assertEquals(bundleCoveringColor.getAttribute("value"),profileFontColourFormboardBundle,"Bundle Colour of node child element is not matched as per the profile updated");
        Assert.assertEquals(bundleBreakFontSize.getAttribute("value"),profileFontSizeBundle,"Bundle size of node child element is not matched as per the profile updated");
        Assert.assertEquals(bundleBreakColor.getAttribute("value"),profileFontColourFormboardBundle,"Bundle Colour of node child element is not matched as per the profile updated");
    }
    public void checkTheFontSizeIsAsPerTheProfileOrNotInConnector(){
        Assert.assertEquals(connectorCavityNameSize.getAttribute("value"),profileFontSize,"Connector Cavity name font size is not matched as per the profile matched");
        Assert.assertEquals(connectorCavityNameColour.getAttribute("value"),profileFontColourConnectorHarness,"Connector Cavity name font colour is not matched as per the profile matched");
        Assert.assertEquals(connectorCavityFuncDescSize.getAttribute("value"),profileFontSize,"Connector Cavity functional description font size is not matched as per the profile matched");
        Assert.assertEquals(connectorCavityFuncDescColour.getAttribute("value"),profileFontColourConnectorHarness,"Connector Cavity functional description font colour is not matched as per the profile matched");
        Assert.assertEquals(connectorCavityNodeDescSize.getAttribute("value"),profileFontSize,"Connector Cavity node description font size is not matched as per the profile matched");
        Assert.assertEquals(connectorCavityNodeDescColour.getAttribute("value"),profileFontColourConnectorHarness,"Connector Cavity node description font colour is not matched as per the profile matched");
        Assert.assertEquals(connectorCavityPartNumberSize.getAttribute("value"),profileFontSize,"Connector Cavity part number font size is not matched as per the profile matched");
        Assert.assertEquals(connectorCavityPartNumberColour.getAttribute("value"),profileFontColourConnectorHarness,"Connector Cavity part number font colour is not matched as per the profile matched");
        Assert.assertEquals(connectorCavityAttachedPartSize.getAttribute("value"),profileFontSize,"Connector Cavity attached part font size is not matched as per the profile matched");
        Assert.assertEquals(connectorCavityAttachedPartColour.getAttribute("value"),profileFontColourConnectorHarness,"Connector Cavity attached part font colour is not matched as per the profile matched");
        Assert.assertEquals(connectorCavityTerminalsSize.getAttribute("value"),profileFontSize,"Connector Cavity terminals font size is not matched as per the profile matched");
        Assert.assertEquals(connectorCavityTerminalsColour.getAttribute("value"),profileFontColourConnectorHarness,"Connector Cavity terminals font colour is not matched as per the profile matched");
        Assert.assertEquals(connectorCavitySealsSize.getAttribute("value"),profileFontSize,"Connector Cavity seals font size is not matched as per the profile matched");
        Assert.assertEquals(connectorCavitySealsColour.getAttribute("value"),profileFontColourConnectorHarness,"Connector Cavity seals font colour is not matched as per the profile matched");
        Assert.assertEquals(connectorCavityPlugsSize.getAttribute("value"),profileFontSize,"Connector Cavity plugs font size is not matched as per the profile matched");
        Assert.assertEquals(connectorCavityPlugsColour.getAttribute("value"),profileFontColourConnectorHarness,"Connector Cavity plugs font colour is not matched as per the profile matched");
        Assert.assertEquals(connectorCavityGroupIdSize.getAttribute("value"),profileFontSize,"Connector Cavity group id font size is not matched as per the profile matched");
        Assert.assertEquals(connectorCavityGroupIdColour.getAttribute("value"),profileFontColourConnectorHarness,"Connector Cavity group id font colour is not matched as per the profile matched");
        Assert.assertEquals(connectorCavityTerminalImageQuantitySize.getAttribute("value"),profileFontSize,"Connector Cavity image quantity font size is not matched as per the profile matched");
        Assert.assertEquals(connectorCavityTerminalImageQuantityColour.getAttribute("value"),profileFontColourConnectorHarness,"Connector Cavity image quantity font colour is not matched as per the profile matched");
        Assert.assertEquals(connectorCavityTerminalImagePartNumberSize.getAttribute("value"),profileFontSize,"Connector Cavity image part number  font size is not matched as per the profile matched");
        Assert.assertEquals(connectorCavityTerminalImagePartNumberColour.getAttribute("value"),profileFontColourConnectorHarness,"Connector Cavity image part number font colour is not matched as per the profile matched");
    }
    public void checkTheFontSizeIsAsPerTheProfileOrNotInSplice(){
        Assert.assertEquals(spliceCavityNameSize.getAttribute("value"),profileFontSize,"splice Cavity name font size is not matched as per the profile matched");
        Assert.assertEquals(spliceCavityNameColour.getAttribute("value"),profileFontColourConnectorHarness,"splice Cavity name font colour is not matched as per the profile matched");
        Assert.assertEquals(spliceCavityFunctionDescriptionSize.getAttribute("value"),profileFontSize,"splice Cavity functional description font size is not matched as per the profile matched");
        Assert.assertEquals(spliceCavityFunctionDescriptionColour.getAttribute("value"),profileFontColourConnectorHarness,"splice Cavity functional description font colour is not matched as per the profile matched");
        Assert.assertEquals(spliceCavityNodeDescriptionSize.getAttribute("value"),profileFontSize,"splice Cavity node description font size is not matched as per the profile matched");
        Assert.assertEquals(spliceCavityNodeDescriptionColour.getAttribute("value"),profileFontColourConnectorHarness,"splice Cavity node description font colour is not matched as per the profile matched");
        Assert.assertEquals(spliceCavityPartNumberSize.getAttribute("value"),profileFontSize,"splice Cavity part number font size is not matched as per the profile matched");
        Assert.assertEquals(spliceCavityPartNumberColour.getAttribute("value"),profileFontColourConnectorHarness,"splice Cavity part number font colour is not matched as per the profile matched");
        Assert.assertEquals(spliceCavityAttachedPartsSize.getAttribute("value"),profileFontSize,"splice Cavity attached parts font size is not matched as per the profile matched");
        Assert.assertEquals(spliceCavityAttachedPartsColour.getAttribute("value"),profileFontColourConnectorHarness,"splice Cavity attached parts font colour is not matched as per the profile matched");
    }

    public void changeFontSizeAndColourInTheTask(String labelName) throws InterruptedException {
        switch (labelName.toLowerCase()) {
            case "node child element" -> {
                customCommand.javaScriptClickAndEnterValue(driver, nodeChildElementSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, nodeChildElementColour, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                customCommand.javaScriptClick(driver, nodeChildElementCheckBox);
                fontsFormSubmit();
            }
            case "node name" ->{
                customCommand.javaScriptClickAndEnterValue(driver, nodeNameSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, nodeNameColour, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                customCommand.javaScriptClick(driver, nodeNameCheckBox);
                fontsFormSubmit();
            }
            case "node functional description" ->{
                customCommand.javaScriptClickAndEnterValue(driver, nodeFunctionalDescSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, nodeFunctionalDescColour, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                functionalDescriptionCheckBox.click();
                fontsFormSubmit();
                Thread.sleep(2000);
                String identifier = FlowContext.nodeIdentifierList.get(0).getNodeElementId();
                harnessPage.getNodeContextMenu(identifier);
                new HarnessPage(driver).performOperation("inspect",identifier);
                customCommand.clearAndEnterText(functionalDescription,"test");
                customCommand.javaScriptClick(driver, buttonSubmitDetails);
            }
            case "node attach parts" ->{
                customCommand.javaScriptClickAndEnterValue(driver, nodeAttachPartsSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, nodeAttachPartsColour, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                attachPartCheckBox.click();
                fontsFormSubmit();
                nodeLabelVisibilityPage.linkOtherParts();
            }
            case "node attached parts name" ->{
                customCommand.javaScriptClickAndEnterValue(driver, nodeAttachPartNameSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, nodeAttachPartNameColour, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                attachPartNameCheckBox.click();
                fontsFormSubmit();
                nodeLabelVisibilityPage.linkOtherParts();
                String identifier = FlowContext.nodeIdentifierList.get(0).getNodeElementId();
                harnessPage.getNodeContextMenu(identifier);
                new HarnessPage(driver).performOperation("inspect",identifier);
                customCommand.waitForElementVisibility(driver,attachPartName);
                customCommand.javaScriptClickAndEnterValue(driver,attachPartName,"test121");
                customCommand.javaScriptClick(driver,buttonSubmitDetails);
            }
            case "bundle name" ->{
                customCommand.javaScriptClickAndEnterValue(driver, bundleNameFontSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, bundleNameColor, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                customCommand.javaScriptClick(driver, bundleNameCheckBox);
                fontsFormSubmit();
            }
            case "bundle length" ->{
                customCommand.javaScriptClickAndEnterValue(driver, bundleLengthFontSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, bundleLengthColor, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                bundleLengthCheckBox.click();
                fontsFormSubmit();
            }
            case "bundle sub dimension" ->{
                customCommand.javaScriptClickAndEnterValue(driver, bundleSubDimensionLengthFontSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, bundleSubDimensionColor, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                bundleSubDimensionCheckBox.click();
                fontsFormSubmit();
            }
            case "bundle coverings" ->{
                customCommand.javaScriptClickAndEnterValue(driver, bundleCoveringsFontSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, bundleCoveringColor, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                bundleCoveringCheckBox.click();
                fontsFormSubmit();
            }
            case "bundle break" ->{
                customCommand.javaScriptClickAndEnterValue(driver, bundleBreakFontSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, bundleBreakColor, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                bundleBreakCheckBox.click();
                fontsFormSubmit();
            }
            case "connector name" ->{
                customCommand.javaScriptClickAndEnterValue(driver, connectorCavityNameSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, connectorCavityNameColour, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                connectorCavityNameCheckBox.click();
                fontsFormSubmit();
            }
            case "connector functional description" ->{
                customCommand.javaScriptClickAndEnterValue(driver, connectorCavityFuncDescSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, connectorCavityFuncDescColour, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                connectorCavityFuncDescCheckBox.click();
                fontsFormSubmit();
            }
            case "connector part number" ->{
                customCommand.javaScriptClickAndEnterValue(driver, connectorCavityPartNumberSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, connectorCavityPartNumberColour, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                connectorCavityPartNumberCheckBox.click();
                fontsFormSubmit();
            }
            case "connector attached parts" ->{
                customCommand.javaScriptClickAndEnterValue(driver, connectorCavityAttachedPartSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, connectorCavityAttachedPartColour, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                connectorCavityAttachedPartCheckBox.click();
                fontsFormSubmit();
            }
            case "connector terminals" ->{
                customCommand.javaScriptClickAndEnterValue(driver, connectorCavityTerminalsSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, connectorCavityTerminalsColour, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                connectorCavityTerminalsCheckBox.click();
                fontsFormSubmit();
            }
            case "connector seals" ->{
                customCommand.javaScriptClickAndEnterValue(driver, connectorCavitySealsSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, connectorCavitySealsColour, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                connectorCavitySealsCheckBox.click();
                fontsFormSubmit();
            }
            case "connector plugs" ->{
                customCommand.javaScriptClickAndEnterValue(driver, connectorCavityPlugsSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, connectorCavityPlugsColour, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                connectorCavityPlugsCheckBox.click();
                fontsFormSubmit();
            }
            case "connector group id" ->{
                customCommand.javaScriptClickAndEnterValue(driver, connectorCavityGroupIdSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, connectorCavityGroupIdColour, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                connectorCavityGroupIdCheckBox.click();
                fontsFormSubmit();
            }
            case "connector terminal image quantity" ->{
                customCommand.javaScriptClickAndEnterValue(driver, connectorCavityTerminalImageQuantitySize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, connectorCavityTerminalImageQuantityColour, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                connectorCavityTerminalImageQuantityCheckBox.click();
                fontsFormSubmit();
            }
            case "connector terminal image part number" ->{
                customCommand.javaScriptClickAndEnterValue(driver, connectorCavityTerminalImagePartNumberSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, connectorCavityTerminalImagePartNumberColour, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                connectorCavityTerminalImagePArtNumberCheckBox.click();
                fontsFormSubmit();
            }
            case "connector cavity table font" ->{
                customCommand.javaScriptClickAndEnterValue(driver, connectorCavityTableFontSize, taskFontSize);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                connectorCavityTableFontCheckBox.click();
                fontsFormSubmit();
            }
            case "splice cavity name" ->{
                customCommand.javaScriptClickAndEnterValue(driver, spliceCavityNameSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, spliceCavityNameColour, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                spliceCavityNameCheckbox.click();
                fontsFormSubmit();
            }
            case "splice cavity functional description" ->{
                customCommand.javaScriptClickAndEnterValue(driver, spliceCavityFunctionDescriptionSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, spliceCavityFunctionDescriptionColour, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                spliceCavityFunctionDescriptionCheckbox.click();
                fontsFormSubmit();
            }
            case "splice cavity node description" ->{
                customCommand.javaScriptClickAndEnterValue(driver, spliceCavityNodeDescriptionSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, spliceCavityNodeDescriptionColour, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                spliceCavityNodeDescriptionCheckbox.click();
                fontsFormSubmit();
            }
            case "splice cavity part number" ->{
                customCommand.javaScriptClickAndEnterValue(driver, spliceCavityPartNumberSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, spliceCavityPartNumberColour, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                spliceCavityPartNumberCheckbox.click();
                fontsFormSubmit();
            }
            case "splice cavity attached parts" ->{
                customCommand.javaScriptClickAndEnterValue(driver, spliceCavityAttachedPartsSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, spliceCavityAttachedPartsColour, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                spliceCavityAttachedPartsCheckbox.click();
                fontsFormSubmit();
            }
            case "splice cavity table font" ->{
                customCommand.javaScriptClickAndEnterValue(driver, spliceCavityTableFontSize, taskFontSize);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                spliceCavityTableFontCheckbox.click();
                fontsFormSubmit();
            }
            case "connector label" ->{
                customCommand.javaScriptClickAndEnterValue(driver, connectorLabelSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, connectorLabelColour, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                ConnectorLabelCheckbox.click();
                fontsFormSubmit();
            }
            case "harness label" ->{
                customCommand.javaScriptClickAndEnterValue(driver, harnessLabelSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, harnessLabelColour, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                harnessLabelCheckbox.click();
                fontsFormSubmit();
            }
            case "bom font" ->{
                customCommand.scrollIntoView(driver,harnessBomTableFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, harnessBomTableFontSize, taskFontSize);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                harnessBomTableCheckBox.click();
                fontsFormSubmit();
            }
            case "manufacturing table font" ->{
                customCommand.scrollIntoView(driver,manufacturingTableFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, manufacturingTableFontSize, taskFontSize);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                manufacturingTableFontCheckbox.click();
                fontsFormSubmit();
            }
            case "wire table font" ->{
                customCommand.scrollIntoView(driver,wireTableFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, wireTableFontSize, taskFontSize);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                wireTableCheckBox.click();
                fontsFormSubmit();
            }
            case "variant table font" ->{
                customCommand.scrollIntoView(driver,variantFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, variantFontSize, taskFontSize);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                variantFontSizeCheckbox.click();
                fontsFormSubmit();
            }
            case "discrete font" ->{
                customCommand.scrollIntoView(driver,discreteComponentsFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, discreteComponentsFontSize, taskFontSize);
                customCommand.javaScriptClickAndEnterValue(driver, discreteComponentsFontColour, taskFontColour);
                fontsFormSubmit();
                verifyAlertMessage("Please select the checkbox to update the Fontsize/Colour.");
                discreteComponentsFontCheckbox.click();
                fontsFormSubmit();
            }
        }
    }

    public void fontsFormSubmit() throws InterruptedException {
        customCommand.scrollIntoView(driver, buttonSubmitDetails);
        customCommand.javaScriptClick(driver, buttonSubmitDetails);
    }
    public void verifyAlertMessage(String message) {
        customCommand.waitForElementVisibility(driver, alertMessageBox);
        Assert.assertEquals(alertMessageBox.getText(),message );
        buttonAcceptMessage.click();
    }


    public void checkNodeChildElementIsAsPerUpdatedFontSizeAndFontColourInTheTask(String labelName) throws InterruptedException, AWTException {
        switch (labelName.toLowerCase()) {
            case "node child element", "node name" ,"node functional description","node attached parts name","bundle name","bundle length","connector functional description","connector group id","connector terminal image quantity","splice cavity functional description","splice cavity node description"-> {
                Assert.assertEquals(complabel.getAttribute("font-size"), taskFontSize, "Font size of node element is not matched as per the task updated");
                Assert.assertEquals(complabel.getAttribute("fill"), taskFontColour, "Font Colour of node element is not matched as per the task updated");
            }
            case "node attach parts" ->
            {
                Assert.assertEquals(attachPartsDetails.getAttribute("font-size"), taskFontSize, "Font size of node element is not matched as per the task updated");
                Assert.assertEquals(attachPartsDetails.getAttribute("fill"), taskFontColour, "Font Colour of node element is not matched as per the task updated");
            }
            case "bundle sub dimension" ->{
                harnessPage.fillCommandLine("insertcomp clip "+bundleId()+" 87.5mm,46.25mm 87.5mm,46.25mm");
                harnessPage.clickOnCommandLineOK();
                Thread.sleep(3000);
                Assert.assertEquals(subDimensionText.getAttribute("font-size"), taskFontSize, "Font size of node element is not matched as per the task updated");
                Assert.assertEquals(subDimensionText.getAttribute("fill"), taskFontColour, "Font Colour of node element is not matched as per the task updated");
                //place a clip on bundle and check add different scenarios
                //              insertcomp clip 8cfebde2054911ee9a9f02de8e05bcf8 87.5mm,46.25mm 87.5mm,46.25mm
                //for bundle Break use following command    bundlebreak d891108c052511ee9a9f02de8e05bcf8 87.5mm,46.25mm 87.5mm,46.25mm
            }
            case "bundle break" ->{
                harnessPage.fillCommandLine(" bundlebreak "+bundleId()+" 87.5mm,46.25mm 87.5mm,46.25mm");
                harnessPage.clickOnCommandLineOK();
                Thread.sleep(3000);
                Assert.assertEquals(complabel.getAttribute("font-size"), taskFontSize, "Font size of node element is not matched as per the task updated");
                Assert.assertEquals(complabel.getAttribute("fill"), taskFontColour, "Font Colour of node element is not matched as per the task updated");
            }
            case "bundle coverings" -> {
                Assert.assertEquals(bundleCoveringDetails.getAttribute("font-size"), taskFontSize, "Font size of node element is not matched as per the task updated");
                Assert.assertEquals(bundleCoveringDetails.getAttribute("fill"), taskFontColour, "Font Colour of node element is not matched as per the task updated");
            }
            case "connector cavity table" ->
                Assert.assertEquals(connectorCavityTableFontSize.getAttribute("value"),taskFontSize,"Font size of connector cavity table font  is not matched as per the task");
            case "connector name","splice cavity name" ->
            {
                Assert.assertEquals(cavityLabelDetails.getAttribute("font-size"),taskFontSize,"Font size of cavity table is not matched as per the task updated");
                Assert.assertEquals(cavityLabelDetails.getAttribute("fill"),taskFontColour,"Font colour of cavity table is not matched as per the task updated");
            }
            case "connector part number","connector terminal image part number"->
            {
                Assert.assertEquals(partNumber.getAttribute("font-size"),taskFontSize,"Font size of Connector cavity table part number is not matched as per the task updated");
                Assert.assertEquals(partNumber.getAttribute("fill"),taskFontColour,"Font colour of Connector cavity table part number  is not matched as per the task updated");
            }
            case "connector attached parts","connector seals","connector plugs","connector terminals","splice cavity attached parts","splice cavity part number" ->
            {
                Assert.assertEquals(connectorPartNumberDescription.getAttribute("font-size"),taskFontSize,"Font size of Connector cavity table part number is not matched as per the task updated");
                Assert.assertEquals(connectorPartNumberDescription.getAttribute("fill"),taskFontColour,"Font colour of Connector cavity table part number  is not matched as per the task updated");
            }
            case "connector cavity table font","splice cavity table font"  ->
            {
                customCommand.javaScriptClick(driver,connectorTableProperties);
                System.out.println(connectorCavityTableFontSizeInProperties.getAttribute("value"));
                //Assert.assertEquals(connectorCavityTableFontSizeInProperties.getAttribute("value"),taskFontSize);
            }
            case "connector label" -> {
                harnessPage.selectHeader("Harness");
                harnessPage.clickOnSelect();
                customCommand.waitForElementToBeClickable(driver,connectorLabelButton);
                customCommand.javaScriptClick(driver,connectorLabelButton);
                verifyText("Place Connector Label");
                customCommand.javaScriptClick(driver,connectorLabelSubmitButton);
                Assert.assertEquals(connectorLabelText.getAttribute("font-size"),taskFontSize);
                Assert.assertEquals(connectorLabelText.getAttribute("fill"),taskFontColour);
            }
            case "harness label" -> {
                harnessPage.fillCommandLine("harnesslabel 87.5mm,46.25mm");
                harnessPage.clickOnCommandLineOK();
                Thread.sleep(3000);
                Assert.assertEquals(connectorLabelText.getAttribute("font-size"), taskFontSize, "Font size of harness label is not matched as per the task updated");
                Assert.assertEquals(connectorLabelText.getAttribute("fill"), taskFontColour, "Font Colour of harness label is not matched as per the task updated");
            }
            case "bom table" ->{
                bomTableOperations();
                Assert.assertEquals(bomTableFontInProperties.getAttribute("value"),taskFontSize,"Bom table font is not matching as expected");
            }
            case "manufacturing table" ->{
                bomTableOperations();
                Assert.assertEquals(manufacturingTableFontInProperties.getAttribute("value"),taskFontSize,"Manufacturing table font is not matching as expected");
            }
            case "wire table" ->{
                bomTableOperations();
                Assert.assertEquals(wireTableFontInProperties.getAttribute("value"),taskFontSize,"Wire table font is not matching as expected");
            }
            case "revision table" ->{
                bomTableId();
                String id = bomTableId.getAttribute("id");
                WebElement getID =driver.findElement(By.xpath("//*[@id=\""+id+"\"]/thead/tr/th[1]"));
                customCommand.javaScriptClick(driver,drawSelectPointer);
                customCommand.doubleClick(driver,getID);
                Thread.sleep(5000);
                customCommand.javaScriptClick(driver,revisionTableProperties);
                Assert.assertEquals(revisionTableFontInProperties.getAttribute("value"),"1.6","Revision table font is not matching as expected");
            }
            case "variant table" ->{
                bomTableOperations();
                Assert.assertEquals(variantTableFontInProperties.getAttribute("value"),taskFontSize,"Variant table font is not matching as expected");
            }
           case "discrete font"->{
                Assert.assertEquals(discreteComponents.getAttribute("fill"),taskFontColour);
                Assert.assertEquals(discreteComponents.getAttribute("font-size"),taskFontSize);
           }

        }

    }
    public void bomTableOperations() throws InterruptedException {
        bomTableId();
        String id = bomTableId.getAttribute("id");
        WebElement getID =driver.findElement(By.xpath("//*[@id=\""+id+"\"]/thead/tr/th[1]"));
        customCommand.javaScriptClick(driver,drawSelectPointer);
        customCommand.doubleClick(driver,getID);
        Thread.sleep(5000);
        customCommand.javaScriptClick(driver,bomTableProperties);
    }
    public boolean verifyText(String text)
    {
        boolean check;
        List <WebElement> verifyConnectorLabelButton = driver.findElements(By.xpath("//*[contains(text(),'"+ text +"')]"));
        check = verifyConnectorLabelButton.size() != 0;
        return check;
    }
    public String connectorId(){
        String connectorid = new ConnectorPage(driver).getConnectorPlugELementIdsFromDrawingPage().get(Integer.parseInt("0")).getConnectorId();
        System.out.println(connectorid);
        return connectorid;
    }
public String bundleId(){
    String identifier = FlowContext.bundleIdentifierList.get(0).getBundleId();
    System.out.println(identifier);
        return identifier;
}
    public String bomTableId(){
        String identifier = FlowContext.bomTableIdentifier;
        System.out.println(identifier);
        return identifier;
    }
    public void changeFontSizeAndColourInFormBoard(String labelName) throws InterruptedException {
        switch (labelName.toLowerCase()) {
            case "node name" ,"node functional description","node attached parts name"->{
                Assert.assertEquals(complabel.getAttribute("font-size"), profileFontSize, "Font size of node element is not matched as per the formboard ");
                Assert.assertEquals(complabel.getAttribute("fill"), profileNodeFontColour, "Font Colour of node element is not matched as per the formboard");
            }
            case "node attach parts" ->
            {
                Assert.assertEquals(attachPartsDetails.getAttribute("font-size"), profileFontSize, "Font size of node element is not matched as per the formboardd");
                Assert.assertEquals(attachPartsDetails.getAttribute("fill"), profileNodeFontColour, "Font Colour of node element is not matched as per the formboard");
            }
            case "bundle name","bundle length" ->{
                Assert.assertEquals(complabel.getAttribute("font-size"), profileFontSizeBundle, "Font size of bundle element is not matched as per the formboard ");
                Assert.assertEquals(complabel.getAttribute("fill"), profileFontColourFormboardBundle, "Font Colour of bundle element is not matched as per the formboard");
            }
            case "bundle sub dimension" ->{
                Thread.sleep(5000);
                Assert.assertEquals(formboardSubDimensionText.getAttribute("font-size"), profileFontSizeBundle, "Font size of bundle sub dimension element is not matched as per the task updated");
                Assert.assertEquals(formboardSubDimensionText.getAttribute("fill"), profileFontColourFormboardBundle, "Font Colour of node sub dimension element is not matched as per the task updated");
            }
            case "bundle coverings" ->{
                Assert.assertEquals(bundleCoveringDetails.getAttribute("font-size"), profileFontSizeBundle, "Font size of bundle covering part description element is not matched as per the task updated");
                Assert.assertEquals(bundleCoveringDetails.getAttribute("fill"), profileFontColourFormboardBundle, "Font Colour of covering part description is not matched as per the task updated");
            }
            case "connector part number","connector terminal image part number" ->
            {
                Assert.assertEquals(partNumber.getAttribute("font-size"),profileFontSizeBundle,"Font size of Connector cavity table part number is not matched as per the task updated");
                Assert.assertEquals(partNumber.getAttribute("fill"),profileFontColourConnectorFormboard,"Font colour of Connector cavity table part number  is not matched as per the task updated");
            }
            case "connector attached parts","connector seals","connector plugs","connector terminals" ->
            {
                Assert.assertEquals(connectorPartNumberDescription.getAttribute("font-size"),profileFontSize,"Font size of Connector cavity table part number is not matched as per the task updated");
                Assert.assertEquals(connectorPartNumberDescription.getAttribute("fill"),profileFontColourConnectorFormboard,"Font colour of Connector cavity table part number  is not matched as per the task updated");
            }
            case "connector group id","connector terminal image quantity"->{
                Assert.assertEquals(complabel.getAttribute("font-size"), profileFontSize, "Font size of node element is not matched as per the formboard ");
                Assert.assertEquals(complabel.getAttribute("fill"), profileFontColourConnectorFormboard, "Font Colour of node element is not matched as per the formboard");
            }
            case "connector cavity table font","splice cavity table font" ->
            {
                customCommand.javaScriptClick(driver,connectorTableProperties);
                System.out.println(connectorCavityTableFontSizeInProperties.getAttribute("value"));
                //Assert.assertEquals(connectorCavityTableFontSizeInProperties.getAttribute("value"),profileFontSize);
            }
            case "connector label","harness label" -> {
                Assert.assertEquals(connectorLabelText.getAttribute("font-size"),profileFontSize);
                Assert.assertEquals(connectorLabelText.getAttribute("fill"),profileFontColourConnectorFormboard);
            }
            case "bom table" -> {
                placeTable("bom");
                Thread.sleep(3000);
                bomTableOperations();
                Assert.assertEquals(bomTableFontInProperties.getAttribute("value"),"2.5");
            }
            case "manufacturing table" -> {
                placeTable("manufacturing");
                Thread.sleep(3000);
                bomTableOperations();
                Assert.assertEquals(manufacturingTableFontInProperties.getAttribute("value"),"2.5");
            }
            case "wire table" -> {
                placeTable("wire");
                Thread.sleep(3000);
                bomTableOperations();
                Assert.assertEquals(wireTableFontInProperties.getAttribute("value"),"2.5");
            }
            case "variant table" -> {
                placeTable("variant");
                Thread.sleep(3000);
                bomTableOperations();
                Assert.assertEquals(variantTableFontInProperties.getAttribute("value"),"2.5");
            }
            case "discrete font"->{
                Assert.assertEquals(discreteComponents.getAttribute("fill"),profileFontColourConnectorFormboard);
                Assert.assertEquals(discreteComponents.getAttribute("font-size"),"2.5");
            }
        }
    }


    public void changeFontSizeInProfileInFormboard(String labelName) throws InterruptedException {
        if(Objects.equals(labelName, "connector label")){
            customCommand.scrollIntoView(driver,connectLabelSizeFormboardProfile);
            customCommand.javaScriptClickAndEnterValue(driver,connectLabelSizeFormboardProfile,"2.5");
            customCommand.javaScriptClickAndEnterValue(driver,connectLabelColourFormboardProfile,profileFontColourConnectorFormboard);
        } else if (Objects.equals(labelName, "Harness label")) {
            customCommand.scrollIntoView(driver,harnessLabelSizeInProfile);
            customCommand.javaScriptClickAndEnterValue(driver,harnessLabelSizeInProfile,"2.5");
            customCommand.javaScriptClickAndEnterValue(driver,harnessLabelColourInProfile,profileFontColourConnectorFormboard);
        }
        else if (Objects.equals(labelName, "Discrete Components")) {
            customCommand.scrollIntoView(driver,discreteComponentsSizeInProfile);
            customCommand.javaScriptClickAndEnterValue(driver,discreteComponentsSizeInProfile,"2.5");
            customCommand.javaScriptClickAndEnterValue(driver,discreteComponentsColourInProfile,profileFontColourConnectorFormboard);
        }
        else if (Objects.equals(labelName, "Bom Table Font")) {
            customCommand.scrollIntoView(driver,bomTableSizeInProfile);
            customCommand.javaScriptClickAndEnterValue(driver,bomTableSizeInProfile,"2.5");
        }
        else if (Objects.equals(labelName, "Wire Table Font")) {
            customCommand.scrollIntoView(driver,wireTableSizeInProfile);
            customCommand.javaScriptClickAndEnterValue(driver,wireTableSizeInProfile,"2.5");
        }
        else if (Objects.equals(labelName, "Variant Table Font")) {
            customCommand.scrollIntoView(driver,variantTableFontSizeInProfile);
            customCommand.javaScriptClickAndEnterValue(driver,variantTableFontSizeInProfile,"2.5");
            customCommand.javaScriptClickAndEnterValue(driver,variantTableWrapCountInProfile,"8");
        }
        else if (Objects.equals(labelName, "Manufacturing Table Font")) {
            customCommand.scrollIntoView(driver,manufacturingTableFontSizeInProfile);
            customCommand.javaScriptClickAndEnterValue(driver,manufacturingTableFontSizeInProfile,"2.5");
        }
        customCommand.scrollIntoView(driver,saveButton);
        customCommand.javaScriptClick(driver,saveButton);
    }

    public void placeTable(String tableName) throws InterruptedException {
        if(Objects.equals(tableName, "bom")){
            harnessPage.fillCommandLine("bomtable 100.5mm,100.25mm");
        } else if (Objects.equals(tableName, "wire")) {
            harnessPage.fillCommandLine("wiretable 50.5mm,50.25mm");
        }else if (Objects.equals(tableName, "manufacturing")) {
            harnessPage.fillCommandLine("manufacturingtable 0.5mm,0.25mm");
        }else if (Objects.equals(tableName, "revision")) {
            harnessPage.fillCommandLine("revisiontable 20.5mm,25.25mm");
        } else if (Objects.equals(tableName, "variant")) {
            harnessPage.fillCommandLine("varianttable 20.5mm,25.25mm");
        }
        harnessPage.clickOnCommandLineOK();
    }

    public void updateDiscreteComponentsValuesInProperties() throws InterruptedException {
        Select se = new Select(driver.findElement(By.cssSelector("#ui-accordion-accordion-panel-0 > div:nth-child(22) > select")));
        se.selectByValue("true");
        Select descType = new Select(driver.findElement(By.cssSelector("#discrete_components > tbody > tr > td:nth-child(3) > select")));
        descType.selectByValue("cavity");
        Select fromCavity = new Select(driver.findElement(By.cssSelector("#discrete_components > tbody > tr > td:nth-child(4) > select")));
        fromCavity.selectByValue("1");
        Select toCavity = new Select(driver.findElement(By.cssSelector("#discrete_components > tbody > tr > td:nth-child(5) > select")));
        toCavity.selectByValue("2");
        customCommand.scrollIntoView(driver, buttonSubmitDetails);
        customCommand.javaScriptClick(driver, buttonSubmitDetails);
    }
}