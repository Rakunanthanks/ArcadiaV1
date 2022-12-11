package arcadia.pages;

import arcadia.context.FlowContext;
import arcadia.domainobjects.GlobalSleeve;
import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static arcadia.context.FlowContext.globalSleeve;

public class GlobalUpdateSleeve extends BasePage{

    public GlobalUpdateSleeve(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#globalSleeveTube >.formDiv >.dynformrow >select[name=\"library\"]") private WebElement componentDB;
    @FindBy(css = "#globalSleeveTube >.formDiv >.dynformrow >select[name=\"covering\"]") private WebElement coveringType;
    @FindBy(css = "#globalSleeveTube >.formDiv >.dynformrow >select[name=\"material\"]") private WebElement material;
    @FindBy(css = "#globalSleeveTube >.formDiv >.dynformrow >select[name=\"colour\"]") private WebElement colour;
    @FindBy(css = "#globalSleeveTube >.formDiv >.dynformrow >select[name=\"replace\"]") private WebElement replaceExistingCovering;
    @FindBy(css = "#globalSleeveTube >#btnFotter >button[title=\"Submit\"]") private WebElement submitGlobalSleeve;
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    public List<String> getMaterialFromGlobalUpdateSleeve(String coveringTypeValue ,String componentDBValue) throws InterruptedException {
        List<String> materialList = new ArrayList<>();
        customCommand.waitClick(componentDB);
        customCommand.selectDropDownByValue(componentDB,componentDBValue);
        customCommand.waitClick(coveringType);
        customCommand.selectDropDownByValue(coveringType,coveringTypeValue);
        List<WebElement> coveringTypeElements = driver.findElements(By.cssSelector("#globalSleeveTube >.formDiv >.dynformrow >select[name=\"material\"] >option") );
        for(WebElement item : coveringTypeElements){
            String optionValue = item.getAttribute("value").replace("%20"," ").trim();
            if(optionValue!=null && !optionValue.isEmpty() && !optionValue.isBlank()){
                materialList.add(optionValue);
            }
        }
        return  materialList;
    }
    public List<String> getColour(String componentDBValue, String coveringTypeValue , String materialValue) throws InterruptedException {
        List<String> colourList = new ArrayList<>();
        customCommand.waitClick(componentDB);
        customCommand.selectDropDownByVisibleText(componentDB,componentDBValue);
        customCommand.waitClick(coveringType);
        customCommand.selectDropDownByVisibleText(coveringType,coveringTypeValue);
        customCommand.waitClick(material);
        customCommand.selectDropDownByVisibleText(material,materialValue);
        List<WebElement> colourElement = driver.findElements(By.cssSelector("#globalSleeveTube >.formDiv >.dynformrow >select[name=\"colour\"] >option") );
        for(WebElement item : colourElement){
            String optionValue = item.getAttribute("value").replace("%20"," ").trim();
            if(optionValue!=null && !optionValue.isEmpty() && !optionValue.isBlank()){
                colourList.add(optionValue);
            }
        }
        return  colourList;
    }
    public List<String> getAllCoveringType() throws InterruptedException {
        List<String> coveringType = new ArrayList<>();
        customCommand.waitClick(componentDB);
        customCommand.selectDropDownByValue(componentDB,"quickstart");
        List<WebElement> coveringTypeElements = driver.findElements(By.cssSelector("#globalSleeveTube >.formDiv >.dynformrow >select[name=\"covering\"] >option") );
        for(WebElement element : coveringTypeElements){
            String colour = element.getAttribute("value");
            if(colour!=null && !colour.isBlank() && !colour.isEmpty()){
                coveringType.add(element.getAttribute("value"));
            }
            }
        return  coveringType;
    }
    public void updateGlobalSleeveTube(String componentDBValue,String coveringTypeValue, String materialValue , String colourValue, boolean replaceCover) throws InterruptedException {
        customCommand.waitClick(componentDB);
        customCommand.selectDropDownByValue(componentDB,componentDBValue);
        FlowContext.globalSleeveTubeUpdate = true;
        if(coveringTypeValue!=null && !coveringTypeValue.isBlank() && !coveringTypeValue.isEmpty()){
            customCommand.waitClick(coveringType);
            customCommand.selectDropDownByValue(coveringType,coveringTypeValue);
            globalSleeve.setCoveringType(coveringTypeValue);
        }
        if(materialValue!=null && !materialValue.isBlank() && !materialValue.isEmpty()){
            customCommand.waitClick(material);
            customCommand.selectDropDownByValue(material,materialValue);
            globalSleeve.setMaterial(materialValue);
        }
        if(colourValue!=null && !colourValue.isBlank() && !colourValue.isEmpty()){
            customCommand.waitClick(colour);
            customCommand.selectDropDownByValue(colour,colourValue);
            globalSleeve.setColour(colourValue);
        }
        if(replaceCover){
            Thread.sleep(3000);
            customCommand.waitClick(replaceExistingCovering);
            customCommand.selectDropDownByValue(colour,"yes");
        }
        customCommand.waitClick(submitGlobalSleeve);
        Thread.sleep(2000);
        customCommand.waitForElementToBeClickable(driver,driver.findElement(By.cssSelector("input.selectall")));
        Thread.sleep(2000);
        customCommand.waitClick(driver.findElement(By.cssSelector(".selectall")));
        customCommand.javaScriptClick(driver,driver.findElement(By.cssSelector(".dynform >#frmBundleSelection >#btnFotter >button[type=\"Submit\"] >span>span")));
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver, driver.findElement(By.cssSelector(".dynform >#DynamicForm >#btnFotter >button[title=\"Cancel\"] >span>span")));
    }

}
