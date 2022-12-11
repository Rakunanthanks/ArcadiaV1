package arcadia.pages;

import arcadia.constants.EndPoint;
import arcadia.context.FlowContext;
import arcadia.domainobjects.ComponentDB;
import arcadia.utils.ConfigLoader;
import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SleeveTubeComponentDB extends BasePage {
    public SleeveTubeComponentDB(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#grid >.bootstrap-table >.fixed-table-container >.fixed-table-pagination >.pull-left.pagination-detail >.page-list >.btn-group.dropup >button >.caret") private WebElement paginationCaret;
    @FindBy(css = "#grid >.bootstrap-table >.fixed-table-container >.fixed-table-pagination >.pull-left.pagination-detail >.page-list >.btn-group.dropup >.dropdown-menu>li:last-child >a") private WebElement paginationAll;
    @FindBy(css = "input[placeholder=\"Int-Dia / Rec-Dia\"]") private WebElement internalDiameter;
    @FindBy(css = "input[placeholder=\"Ext-Dia / Sup-Dia\"]") private WebElement suppliedDiameter;
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    public void getFullPagination() throws InterruptedException {
        Thread.sleep(3000);
        customCommand.scrollIntoView(driver,paginationCaret);
        paginationCaret.click();
        customCommand.waitForElementVisibility(driver,paginationAll);
        Thread.sleep(3000);
        paginationAll.click();
        Thread.sleep(3000);
    }

    public void launchSleeveTube() throws InterruptedException {
        String winHandleBefore = driver.getWindowHandle();
        FlowContext.mainWindowHandle = winHandleBefore;
        new HarnessPage(driver).clickOnOpen();
        for(String winHandle : driver.getWindowHandles()){
            if(!winHandle.equalsIgnoreCase(winHandleBefore)){
                driver.switchTo().window(winHandle);
            }
        }
        driver.get(ConfigLoader.getInstance().getBaseUrl() + EndPoint.SLEEVETUBE.url);
    }
    public void filterComponentDB(String interDia , String defaultLineFont) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationCaret);
        List<WebElement> elements = driver.findElements(By.cssSelector("th[data-field=\"defaultlinefont\"] >.fht-cell >.filterControl >select:first-child"));
        elements.get(0).click();
        Thread.sleep(2000 );
        List<WebElement> elements1 = driver.findElements(By.cssSelector("th[data-field=\"defaultlinefont\"] >.fht-cell >.filterControl >select:first-child"));
        customCommand.selectDropDownByVisibleText(elements1.get(0),defaultLineFont);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector("#tblsleevetube > tbody > tr")));
        customCommand.simulateKeyEnterWithValue(internalDiameter,interDia);
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector("#tblsleevetube > tbody > tr")));
    }
    public void filterComponentDBBasedOnSuppliedDia(String suppliedDia , String defaultLineFont , String type) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationCaret);
        List<WebElement> elements = driver.findElements(By.cssSelector("th[data-field=\"defaultlinefont\"] >.fht-cell >.filterControl >select:first-child"));
        elements.get(0).click();
        Thread.sleep(2000 );
        List<WebElement> elements1 = driver.findElements(By.cssSelector("th[data-field=\"defaultlinefont\"] >.fht-cell >.filterControl >select:first-child"));
        customCommand.selectDropDownByVisibleText(elements1.get(0),defaultLineFont);
        Thread.sleep(2000 );
        List<WebElement> typeElement = driver.findElements(By.cssSelector("th[data-field=\"Type\"] >.fht-cell >.filterControl >select:first-child"));
        typeElement.get(0).click();
        Thread.sleep(2000 );
        List<WebElement> typeElementValue = driver.findElements(By.cssSelector("th[data-field=\"Type\"] >.fht-cell >.filterControl >select:first-child"));
        customCommand.selectDropDownByVisibleText(typeElementValue.get(0),type);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector("#tblsleevetube > tbody > tr")));
        customCommand.simulateKeyEnterWithValue(suppliedDiameter,suppliedDia);
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector("#tblsleevetube > tbody > tr")));
    }
    public List<ComponentDB> getSleeveTubeData() throws InterruptedException {
        getFullPagination();
        List<ComponentDB> componentDbData = new ArrayList<>();
        List<WebElement> componentDbElement = driver.findElements(By.cssSelector("#tblsleevetube > tbody > tr"));
        int i = 0;
        for( WebElement element : componentDbElement){
            i++;
            List<WebElement> tdElements = element.findElements(By.cssSelector("td"));
            String partNumber = tdElements.get(1).getText();
            String description= tdElements.get(2).getText();
            String family= tdElements.get(3).getText();
            String status= tdElements.get(5).getText();
            String supplier= tdElements.get(7).getText();
            String supplierPN= tdElements.get(8).getText();
            String colour= tdElements.get(9).getText();
            String type= tdElements.get(10).getText();
            String material= tdElements.get(11).getText();
            Double internalDiameter= Double.valueOf(tdElements.get(12).getText());
            Double externalDiameter= Double.valueOf(tdElements.get(13).getText());
            Double maximumLength= Double.valueOf(tdElements.get(14).getText());
            String splitTube= tdElements.get(15).getText();
            String defaultLineFont= tdElements.get(16).getText();
            componentDbData.add(new ComponentDB(partNumber,description,family,status,supplier,supplierPN,colour,type,material,internalDiameter,externalDiameter,maximumLength,splitTube,defaultLineFont));
        }
        return componentDbData;
    }

    public List<ComponentDB> getFilterByDefaultLineFont(List<ComponentDB> componentDBList , String filterValue){
        return componentDBList.stream()
                .filter(e -> e.getDefaultLineFont().startsWith(filterValue)).toList();
    }

    public List<ComponentDB> getFilterByInternalDiameterGreaterThanEqualTo(List<ComponentDB> componentDBList , Integer filterValue){
        return componentDBList.stream()
                .filter(e -> e.getInternalDiameter()>=filterValue).toList();
    }

    public ComponentDB sortByIntDiaFindFirst(List<ComponentDB> componentDBList){
        ComponentDB comparisonData = componentDBList.stream().sorted(Comparator.comparingDouble(ComponentDB::getInternalDiameter)).findFirst().get();
        return comparisonData;

    }

    public ComponentDB sortByExtDiaFindFirst(List<ComponentDB> componentDBList){
        ComponentDB comparisonData = componentDBList.stream().sorted(Comparator.comparingDouble(ComponentDB::getExternalDiameter)).findFirst().get();
        return comparisonData;

    }





}