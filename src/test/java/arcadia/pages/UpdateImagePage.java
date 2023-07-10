package arcadia.pages;

import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Objects;

public class UpdateImagePage extends BasePage {
    @FindBy(css="#DynamicForm")private WebElement imageViewContent;
    @FindBy(xpath = "//div[@class='dynformrowexpand']//div[@value='Loading']//input[@name='colocate.connector']") WebElement loadingCoLocateCheckBox;
    @FindBy(css="input[value='Mating'][name='Default Connector View']")private WebElement matingViewCheckBox;
    @FindBy(css="input[value='Mating'][name='autorotate.connector']")private WebElement matingAutoRotateCheckBox;
    @FindBy(css="input[value='Mating'][name='colocate.connector']")private WebElement matingCoLocateCheckBox;
    @FindBy(css="input[value='Loading'][name='Default Connector View']")private WebElement loadingViewCheckBox;
    @FindBy(css="input[value='Top'][name='Default Connector View']")private WebElement topViewCheckBox;
    @FindBy(css= "input[value='Top'][name='autorotate.connector']")private WebElement topRotateCheckBox;
    @FindBy(css="input[value='Top'][name='colocate.connector']")private WebElement topCoLocateCheckBox;
    @FindBy(css="input[value='Isometric'][name='Default Connector View']") private WebElement isometricViewCheckBox;
    @FindBy(css="input[value='Isometric'][name='autorotate.connector']") private WebElement isometricAutoRotateCheckBox;
    @FindBy(css="input[value='Isometric'][name='colocate.connector']") private WebElement isometricCoLocateCheckBox;
    @FindBy(css="input[value='Catalogue'][name='Default Connector View']") private WebElement catalogueViewCheckBox;
    @FindBy(css="input[value='Catalogue'][name='autorotate.connector']") private WebElement catalogueAutoRotateCheckBox;
    @FindBy(css="input[value='Catalogue'][name='colocate.connector']") private WebElement catalogueCoLocateCheckBox;
    @FindBy(css="input[value='Side'][name='Default Connector View']") private WebElement sideViewCheckBox;
    @FindBy(css="input[value='Side'][name='autorotate.connector']") private WebElement sideAutoRotateCheckBox;
    @FindBy(css="input[value='Side'][name='colocate.connector']") private WebElement sideCoLocateCheckBox;
    @FindBy(css="input[value='Top'][name='Default Terminal View']") private WebElement topTerminalViewCheckBox;
    @FindBy(css="input[value='Top'][name='autorotate.terminal']") private WebElement topTerminalAutoRotateCheckBox;
    @FindBy(css="input[value='Top'][name='colocate.terminal']") private WebElement topTerminalCoLocateCheckBox;
    @FindBy(css="input[value='Isometric'][name='Default Terminal View']") private WebElement isometricTerminalViewCheckBox;
    @FindBy(css="input[value='Isometric'][name='autorotate.terminal']") private WebElement isometricTerminalAutoRotateCheckBox;
    @FindBy(css="input[value='Isometric'][name='colocate.terminal']") private WebElement isometricTerminalCoLocateCheckBox;
    @FindBy(css="input[value='Catalogue'][name='Default Terminal View']") private WebElement catalogueTerminalViewCheckBox;
    @FindBy(css="input[value='Catalogue'][name='autorotate.terminal']") private WebElement catalogueTerminalAutoRotateCheckBox;
    @FindBy(css="input[value='Catalogue'][name='colocate.terminal']") private WebElement catalogueTerminalCoLocateCheckBox;
    @FindBy(css="input[value='Isometric'][name='Default Splice View']") private WebElement isometricSpliceCheckBox;
    @FindBy(css="input[value='Catalogue'][name='Default Splice View']") private WebElement catalogueSpliceCheckBox;
    @FindBy(css="input[value='Top'][name='Default Other Part View']") private WebElement topOtherPartRadioButton;
    @FindBy(css="input[value='Isometric'][name='Default Other Part View']") private WebElement isometricOtherPartRadioButton;
    @FindBy(css="input[value='Catalogue'][name='Default Other Part View']") private WebElement catalogueOtherPartRadioButton;
    @FindBy(css="input[value='Top'][name='Default Seal View']") private WebElement topSealRadioButton;
    @FindBy(css="input[value='Isometric'][name='Default Seal View']") private WebElement isometricSealRadioButton;
    @FindBy(css="input[value='Catalogue'][name='Default Seal View']") private WebElement catalogueSealRadioButton;
    @FindBy(css="input[value='None'][name='Default Seal View']") private WebElement noneSealRadioButton;
    @FindBy(css="input[value='None'][name='Default Other Part View']") private WebElement noneOtherPartRadioButton;
    @FindBy(xpath = "//input[@name='Mating']") private WebElement matingInputBox;
    @FindBy(xpath = "//input[@name='Top']") private WebElement topInputBox;
    @FindBy(xpath = "//input[@name='Isometric']")  private WebElement isometricInputBox;
    @FindBy(xpath = "//input[@name='Catalogue']")  private WebElement catalogueInputBox;
    @FindBy(xpath = "//input[@name='Side']") private WebElement sideInputBox;
    @FindBy(css="#layer_80 > g.DG6.bundleGroup > g > g:nth-child(3) > g")private WebElement connectorImageElement;
    @FindBy(css="#layer_80 > g.DG6.bundleGroup > g > g:nth-child(4) > g")private WebElement terminalImageElement;
    @FindBy(css="#ui-accordion-accordion-panel-0 > div:nth-child(8) > input.partnumberspec")private WebElement splicePartNumber;
    @FindBy(css="#ui-accordion-accordion-panel-0 > div:nth-child(8) > input.getDetails")private WebElement getSplicePartNumber;

    @FindBy(xpath = "//div[@aria-describedby='idFetchnode_attachpart']//span[text()='Populate']") private WebElement populate;
    @FindBy(css="#layer_80 > g.DG8.bundleGroup > g > g:nth-child(3) > g")private WebElement spliceImageSelector;
    @FindBy(css="#layer_54 > g > g > g")private WebElement sealElementSelector;

    public UpdateImagePage(WebDriver driver) {
        super(driver);
    }
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    SchematicsDrawingPage schematicsDrawingPage = new SchematicsDrawingPage(driver);
    HarnessPage harnessPage = new HarnessPage(driver);

    public void verifyUpdateImageViewOpened() {
        customCommand.waitForElementVisibility(driver,imageViewContent);
        Assert.assertTrue(imageViewContent.isDisplayed(),"Update Image view window is not opened");
    }

    public void clickCheckboxOfViewsAndScale() throws InterruptedException {
        customCommand.javaScriptClick(driver,schematicsDrawingPage.updateView);
        customCommand.javaScriptClick(driver,schematicsDrawingPage.updateScale);
    }

    public void userSelectCheckboxImageLoadingAndSetsImageScaleSizeAs(String imageView, String imageScale) throws InterruptedException {
        switch (imageView){
            case "loading" ->{
                customCommand.javaScriptClick(driver,schematicsDrawingPage.loadingCheckBox);
                customCommand.javaScriptClick(driver,loadingCoLocateCheckBox);
                customCommand.clearAndEnterText(schematicsDrawingPage.LoadingInputBox,imageScale);
            }
            case "mating" -> {
                customCommand.javaScriptClick(driver,loadingViewCheckBox);
                customCommand.javaScriptClick(driver,matingViewCheckBox);
                customCommand.javaScriptClick(driver,matingAutoRotateCheckBox);
                customCommand.javaScriptClick(driver,matingCoLocateCheckBox);
                customCommand.clearAndEnterText(matingInputBox,imageScale);
            }
            case "top" -> {
                customCommand.javaScriptClick(driver,matingViewCheckBox);
                customCommand.javaScriptClick(driver,topViewCheckBox);
                customCommand.javaScriptClick(driver,topRotateCheckBox);
                customCommand.javaScriptClick(driver,topCoLocateCheckBox);
                customCommand.clearAndEnterText(topInputBox,imageScale);
            }
            case "isometric" ->{
                customCommand.javaScriptClick(driver,topViewCheckBox);
                customCommand.javaScriptClick(driver,isometricViewCheckBox);
                customCommand.javaScriptClick(driver,isometricAutoRotateCheckBox);
                customCommand.javaScriptClick(driver,isometricCoLocateCheckBox);
                customCommand.clearAndEnterText(isometricInputBox,imageScale);
            }
            case "catalogue" ->{
                customCommand.javaScriptClick(driver,isometricViewCheckBox);
                customCommand.javaScriptClick(driver,catalogueViewCheckBox);
                customCommand.javaScriptClick(driver,catalogueAutoRotateCheckBox);
                customCommand.javaScriptClick(driver,catalogueCoLocateCheckBox);
                customCommand.clearAndEnterText(catalogueInputBox,imageScale);
            }
            case "side"->{
                customCommand.javaScriptClick(driver,catalogueViewCheckBox);
                customCommand.javaScriptClick(driver,sideViewCheckBox);
                customCommand.javaScriptClick(driver,sideAutoRotateCheckBox);
                customCommand.javaScriptClick(driver,sideCoLocateCheckBox);
                customCommand.clearAndEnterText(sideInputBox,imageScale);
            }
        }
        customCommand.javaScriptClick(driver,schematicsDrawingPage.submitButtonImageView);
        customCommand.javaScriptClick(driver,schematicsDrawingPage.yesButton);
    }

    public void checkWhetherImageViewAndImageScaleOfTopOfConnector(String imageScale) throws InterruptedException {
          Thread.sleep(5000);
         int indexOfScale =  connectorImageElement.getAttribute("transform").indexOf("scale");
         String  imageScaleSize = connectorImageElement.getAttribute("transform").substring(indexOfScale+8,indexOfScale+9);
         System.out.println(indexOfScale);
         System.out.println(imageScaleSize);
         Assert.assertEquals(imageScaleSize,imageScale,"Image size is not updating as expected or connector is not attached to the bundle");
         Assert.assertEquals(connectorImageElement.getAttribute("basepointorientate"),"2","Image is not working as expected for co locate and auto rotate");
    }

    public void userSelectCheckboxTerminalImageTopViewAndImageScaleAs(String imageView, String imageScale) throws InterruptedException {
        switch (imageView){
            case "top" ->{
                customCommand.javaScriptClick(driver,topTerminalAutoRotateCheckBox);
                customCommand.javaScriptClick(driver,topTerminalCoLocateCheckBox);
                customCommand.clearAndEnterText(topInputBox,imageScale);
            }
            case "isometric" ->{
                customCommand.javaScriptClick(driver,topTerminalViewCheckBox);
                customCommand.javaScriptClick(driver,isometricTerminalViewCheckBox);
                customCommand.javaScriptClick(driver,isometricTerminalAutoRotateCheckBox);
                customCommand.javaScriptClick(driver,isometricTerminalCoLocateCheckBox);
                customCommand.clearAndEnterText(isometricInputBox,imageScale);

            }
            case "catalogue" ->{
                customCommand.javaScriptClick(driver,isometricTerminalViewCheckBox);
                customCommand.javaScriptClick(driver,catalogueTerminalViewCheckBox);
                customCommand.javaScriptClick(driver,catalogueTerminalAutoRotateCheckBox);
                customCommand.javaScriptClick(driver,catalogueTerminalCoLocateCheckBox);
                customCommand.clearAndEnterText(catalogueInputBox,imageScale);

            }
        }
        customCommand.javaScriptClick(driver,schematicsDrawingPage.submitButtonImageView);
        customCommand.javaScriptClick(driver,schematicsDrawingPage.yesButton);
    }

    public void checkWhetherTerminalImageIsMatchingAsPerTheExpectedImageScaleOrNot(String imageScale) throws InterruptedException {
        Thread.sleep(5000);
        int indexOfScale =  terminalImageElement.getAttribute("transform").indexOf("scale");
        String  imageScaleSize = terminalImageElement.getAttribute("transform").substring(indexOfScale+8,indexOfScale+9);
        System.out.println(indexOfScale);
        System.out.println(imageScaleSize);
        Assert.assertEquals(imageScaleSize,imageScale,"Image size is not updating as expected on Terminal");
        Assert.assertEquals(connectorImageElement.getAttribute("basepointorientate"),"2","Image is not working as expected for co locate and auto rotate");
    }

    public void assignPartNumberToSplice(String splicePartnumber) throws InterruptedException {
        customCommand.javaScriptClickAndEnterValue(driver,splicePartNumber,splicePartnumber);
        customCommand.javaScriptClick(driver,getSplicePartNumber);
        customCommand.javaScriptClick(driver,populate);
        customCommand.javaScriptClick(driver, harnessPage.buttonSubmitDetails);
    }

    public void userSelectCheckboxForDefaultSpliceViewTopAndImageScaleAs(String imageView, String imageScale) throws InterruptedException {
        switch (imageView) {
            case "top" -> {
                customCommand.clearAndEnterText(topInputBox, imageScale);
            }

            case "isometric" -> {
                customCommand.javaScriptClick(driver,isometricSpliceCheckBox);
                customCommand.clearAndEnterText(isometricInputBox, imageScale);
            }
            case "catalogue" -> {
                customCommand.javaScriptClick(driver,catalogueSpliceCheckBox);
                customCommand.clearAndEnterText(catalogueInputBox, imageScale);
            }
        }
        customCommand.javaScriptClick(driver, schematicsDrawingPage.submitButtonImageView);
        customCommand.javaScriptClick(driver, schematicsDrawingPage.yesButton);
    }


    public void checkWhetherSpliceViewAndImageScaleAs(String imageScale) throws InterruptedException {
        Thread.sleep(7000);
        int indexOfScale =  spliceImageSelector.getAttribute("transform").indexOf("scale");
        String  imageScaleSize = spliceImageSelector.getAttribute("transform").substring(indexOfScale+8,indexOfScale+9);
        System.out.println(indexOfScale);
        System.out.println(imageScaleSize);
        Assert.assertEquals(imageScaleSize,imageScale,"Image size is not updating as expected or connector is not attached to the bundle");
    }

    public void checkWhetherSealViewAndImageScaleAs(String imageScale) {
        if(!Objects.equals(imageScale, "none")) {
            int indexOfScale = sealElementSelector.getAttribute("transform").indexOf("scale");
            String imageScaleSize = sealElementSelector.getAttribute("transform").substring(indexOfScale + 8, indexOfScale + 9);
            System.out.println(indexOfScale);
            System.out.println(imageScaleSize);
            Assert.assertEquals(imageScaleSize, imageScale, "Seal size is not updating as expected or seal is not attached to the bundle");
        }
        else{
            assert true;
        }
    }

    public void userSelectCheckboxForDefaultSealViewTopAndImageScaleAs(String imageView, String imageScale) throws InterruptedException {
        switch (imageView) {
            case "top" -> {
                customCommand.clearAndEnterText(topInputBox, imageScale);
            }

            case "isometric" -> {
                customCommand.javaScriptClick(driver,isometricSealRadioButton);
                customCommand.javaScriptClick(driver,isometricOtherPartRadioButton);
                customCommand.clearAndEnterText(isometricInputBox, imageScale);
            }
            case "catalogue" -> {
                customCommand.javaScriptClick(driver,catalogueSealRadioButton);
                customCommand.javaScriptClick(driver,catalogueOtherPartRadioButton);
                customCommand.clearAndEnterText(catalogueInputBox, imageScale);
            }
            case "none" -> {
                customCommand.javaScriptClick(driver,noneOtherPartRadioButton);
                customCommand.javaScriptClick(driver,noneSealRadioButton);
            }
        }
        customCommand.javaScriptClick(driver, schematicsDrawingPage.submitButtonImageView);
        customCommand.javaScriptClick(driver, schematicsDrawingPage.yesButton);


    }
}
