package arcadia.pages;

import arcadia.domainobjects.ComponentPrefix;
import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vipula
 * @date 10-01-2023
 */
public class ProfilePage extends BasePage
{
    SeleniumCustomCommand sel=null;
    public ProfilePage(WebDriver driver) {
        super(driver);
        sel=new SeleniumCustomCommand();
    }
    @FindBy(xpath = "(//span[text()='General']/parent::a)[1]/i[1]") private WebElement GeneralMenuSelection;
    @FindBy(xpath = "//a[contains(@href,'Component Prefix Editor')]") private WebElement ComponentPrefixEditor;
    @FindBy(xpath = "//input[@name='prefix']") private WebElement editPrefixText;
    @FindBy(xpath = "//button[@type='submit']") private WebElement saveButton;


    String tableRows = "//table[@id='myTable']//tr";

    public void clickMenuFromLeftPanel() throws InterruptedException {
        Thread.sleep(2000);
        sel.javaScriptClick(driver,GeneralMenuSelection);
        sel.mouseHover(driver,GeneralMenuSelection);
        Thread.sleep(2000);
        sel.javaScriptClick(driver,ComponentPrefixEditor);
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
        sel.javaScriptClick(driver,element);

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

}
