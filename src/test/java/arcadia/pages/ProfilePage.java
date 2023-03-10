package arcadia.pages;

import arcadia.domainobjects.ComponentPrefix;
import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vipula
 * @date 10-01-2023
 */
public class ProfilePage extends BasePage
{
    SeleniumCustomCommand customCommand =null;
    public ProfilePage(WebDriver driver) {
        super(driver);
        customCommand =new SeleniumCustomCommand();
    }
    @FindBy(xpath = "(//span[text()='General']/parent::a)[1]/i[1]") private WebElement GeneralMenuSelection;
    @FindBy(xpath = "//a[contains(@href,'Component Prefix Editor')]") private WebElement ComponentPrefixEditor;
    @FindBy(xpath = "//input[@name='prefix']") private WebElement editPrefixText;
    @FindBy(xpath = "//button[@type='submit']") private WebElement saveButton;
    @FindBy(id = "idglobaloptions") private WebElement labelBundleGlobalOptions;
    @FindBy(css = "select[name='NTS Colour']") private WebElement selectNtsColour;
    @FindBy(css = "select[name='NTS Show Actual Length']") private WebElement selectShowActualLength;
    @FindBy(css = "input[name='NTS Text']") private WebElement inputNtsText;
    @FindBy(css = "input[name='bundle_DefaultLength1_value']") private WebElement inputBundleDefaultLength1;
    @FindBy(css = "input[name='bundle_DefaultLength2_value']") private WebElement inputBundleDefaultLength2;
    @FindBy(css = "input[name='bundle_DefaultLength3_value']") private WebElement inputBundleDefaultLength3;
    @FindBy(css = "input[name='bundle_DefaultLength4_value']") private WebElement inputBundleDefaultLength4;
    @FindBy(css = "input[name='bundle_DefaultLength5_value']") private WebElement inputBundleDefaultLength5;
    @FindBy(css = "div#idselectform button[value='Save']") private WebElement buttonSaveBundleDisplaySettings;
    @FindBy(css = "input[name='bundle_bendradius_value']") private WebElement defaultBendRadiusInput;


    String tableRows = "//table[@id='myTable']//tr";

    public void clickMenuFromLeftPanel() throws InterruptedException {
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver,GeneralMenuSelection);
        customCommand.mouseHover(driver,GeneralMenuSelection);
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver,ComponentPrefixEditor);
    }


    public List<ComponentPrefix> getPrefixData() throws InterruptedException {
        List<ComponentPrefix> componentPrefix = new ArrayList<>();
        List<WebElement> componentPrefixElement = driver.findElements(By.xpath(tableRows));

        for( int i=1;i<componentPrefixElement.size();i++){
            List<WebElement> tdElements = componentPrefixElement.get(i).findElements(By.cssSelector("td"));
            String Identifier = tdElements.get(0).getText();
            String IdentifierType= tdElements.get(1).getText();
            String Prefix=tdElements.get(2).getText();
            String Location= tdElements.get(3).getText();
            String UseSeperator= tdElements.get(4).getText();
            componentPrefix.add(new ComponentPrefix(Identifier,IdentifierType,Prefix,Location,UseSeperator));
        }
        return componentPrefix;
    }

    public void clickEditButtonForIdentifier(String Identifier) throws InterruptedException {
       Thread.sleep(2000);
        WebElement element=driver.findElement(By.xpath("//table[@id='myTable']//td[text()='"+Identifier+"']/following-sibling::td//i[contains(@class,'edit')]"));
        customCommand.javaScriptClick(driver,element);

    }

    public String editPrefixAndSave()
    {
        String prefix=editPrefixText.getAttribute("value");
       if(prefix.contains("TEST"))
       {
           prefix.replace("TEST","");
       }
       else{
        prefix=prefix+"test";
       }
       editPrefixText.clear();
        editPrefixText.sendKeys(prefix);
        saveButton.click();
        return prefix;
    }

    public boolean validateUpdatedPrefix(String Identifier, String updatedPrefix) throws InterruptedException {
        Thread.sleep(2000);
        WebElement element=driver.findElement(By.xpath("//table[@id='myTable']//td[text()='"+Identifier+"']/parent::tr//td[text()='"+updatedPrefix.toUpperCase()+"']"));
        return element.isDisplayed();
    }

    public void verifyBundleDefaultDisplayPageOpened() {
        Assert.assertTrue(labelBundleGlobalOptions.isDisplayed());
        Assert.assertTrue(selectNtsColour.isDisplayed());
    }

    public void updateBundleDisplayOptions(String colour, String showActualLength, String ntsText, String defaultLength1, String defaultLength2, String defaultLength3, String defaultLength4, String defaultLength5) throws InterruptedException {
        customCommand.selectDropDownByValue(selectNtsColour,colour);
        customCommand.selectDropDownByValue(selectShowActualLength,showActualLength);
        customCommand.clearAndEnterText(inputNtsText,ntsText);
        customCommand.clearAndEnterText(inputBundleDefaultLength1,defaultLength1);
        customCommand.clearAndEnterText(inputBundleDefaultLength2,defaultLength2);
        customCommand.clearAndEnterText(inputBundleDefaultLength3,defaultLength3);
        customCommand.clearAndEnterText(inputBundleDefaultLength4,defaultLength4);
        customCommand.clearAndEnterText(inputBundleDefaultLength5,defaultLength5);
        buttonSaveBundleDisplaySettings.click();
    }
    public void updateBundleBendRadius(String defaultBendRadius) throws InterruptedException {
        customCommand.clearAndEnterText(defaultBendRadiusInput,defaultBendRadius);
        buttonSaveBundleDisplaySettings.click();
    }
}
