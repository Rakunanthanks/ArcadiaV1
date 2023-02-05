package arcadia.pages;

import arcadia.domainobjects.Macros.CustomLabelTags;
import arcadia.domainobjects.Macros.WireTags;
import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class GeneralMacrosPage extends BasePage {
    public GeneralMacrosPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "textarea[name=\"labelcustom.LabelText\"]") private WebElement textareaConnectorSpliceLabel;
    @FindBy(css = "textarea[name=\"labelcustom.DrawingLabelText\"]") private WebElement textareaHarnessLabel;

    @FindBy(css = "form#macroForm button[type=\"submit\"][class=\"btn btn-success pull-right\"]") private WebElement buttonSave;

    @FindBy(css = "#macroForm>div.alert-success") private WebElement alertMacrosSuccessMessage;

    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    public WireTags getWiresTagData(){
        WireTags wiretags = new WireTags();
        wiretags.setTagfromConnector(driver.findElement(By.cssSelector("input[name=\"wire.conid\"]")).getAttribute("value"));
        wiretags.setTagfromCavity(driver.findElement(By.cssSelector("input[name=\"wire.cavid\"]")).getAttribute("value"));
        wiretags.setTagToConnector(driver.findElement(By.cssSelector("input[name=\"wire.conidto\"]")).getAttribute("value"));
        wiretags.setTagToCavity(driver.findElement(By.cssSelector("input[name=\"wire.cavidto\"]")).getAttribute("value"));
        wiretags.setTagComponentDB(driver.findElement(By.cssSelector("input[name=\"wire.library\"]")).getAttribute("value"));
        wiretags.setTagWirePartNumber(driver.findElement(By.cssSelector("input[name=\"wire.partnumber\"]")).getAttribute("value"));
        wiretags.setTagShowOnBom(driver.findElement(By.cssSelector("input[name=\"wire.wirebom\"]")).getAttribute("value"));
        wiretags.setTagWireId(driver.findElement(By.cssSelector("input[name=\"wire.name\"]")).getAttribute("value"));
        wiretags.setTagMulticore(driver.findElement(By.cssSelector("input[name=\"wire.multicorepn\"]")).getAttribute("value"));
        wiretags.setTagMaterial(driver.findElement(By.cssSelector("input[name=\"wire.material\"]")).getAttribute("value"));
        wiretags.setTagGauge(driver.findElement(By.cssSelector("input[name=\"wire.gauge\"]")).getAttribute("value"));
        wiretags.setTagWireCsa(driver.findElement(By.cssSelector("input[name=\"wire.wirecsa\"]")).getAttribute("value"));
        wiretags.setTagPrimaryColour(driver.findElement(By.cssSelector("input[name=\"wire.colour\"]")).getAttribute("value"));
        wiretags.setTagSecondaryColour(driver.findElement(By.cssSelector("input[name=\"wire.colour2\"]")).getAttribute("value"));
        wiretags.setTagTertiaryColour(driver.findElement(By.cssSelector("input[name=\"wire.colour3\"]")).getAttribute("value"));
        wiretags.setTagOuterDiameter(driver.findElement(By.cssSelector("input[name=\"wire.outerdia\"]")).getAttribute("value"));
        wiretags.setTagWireLengthOffset(driver.findElement(By.cssSelector("input[name=\"wire.offsetlength\"]")).getAttribute("value"));
        wiretags.setTagAbsoluteLength(driver.findElement(By.cssSelector("input[name=\"wire.abslength\"]")).getAttribute("value"));
        wiretags.setTagSignalName(driver.findElement(By.cssSelector("input[name=\"wire.signalname\"]")).getAttribute("value"));
        wiretags.setTagWireLength(driver.findElement(By.cssSelector("input[name=\"wire.length\"]")).getAttribute("value"));
        wiretags.setTagIndentTag(driver.findElement(By.cssSelector("input[name=\"wire.identtag\"]")).getAttribute("value"));
        wiretags.setTagOptions(driver.findElement(By.cssSelector("input[name=\"wire.options\"]")).getAttribute("value"));
        return wiretags;
    }

    public CustomLabelTags getCustomLabelTagsData(){
        CustomLabelTags customlabeltags = new CustomLabelTags();
        customlabeltags.setTagconnectorSpliceLabel(textareaConnectorSpliceLabel.getAttribute("value"));
        customlabeltags.setTagHarnessLabel(textareaHarnessLabel.getAttribute("value"));
        return customlabeltags;
    }

    public void enterCustomLabelTags(String labelValue) {
        customCommand.clearAndEnterText(textareaConnectorSpliceLabel,labelValue);
    }

    public void clickSaveButton() throws InterruptedException {
        customCommand.scrollIntoView(driver,buttonSave);
        buttonSave.click();
    }

    public void verifyAlertMacrosSuccessMessage(String message) {
        customCommand.waitForElementVisibility(driver, alertMacrosSuccessMessage);
        Assert.assertEquals( alertMacrosSuccessMessage.getText(),message);
    }
}
