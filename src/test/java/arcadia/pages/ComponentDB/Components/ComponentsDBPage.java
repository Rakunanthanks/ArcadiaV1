package arcadia.pages.ComponentDB.Components;

import arcadia.domainobjects.ComponentsDB;
import arcadia.domainobjects.MulticoreComponentDB;
import arcadia.pages.BasePage;
import arcadia.pages.ComponentDB.CommonElements;
import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComponentsDBPage extends BasePage {
    public ComponentsDBPage(WebDriver driver) {
        super(driver);
    }
    String tableComponents = "#tblcomponent > tbody > tr";


    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();

    public List<ComponentsDB> getComponentsData() throws InterruptedException {
        new CommonElements(driver).getFullPagination();
        List<ComponentsDB> componentDbData = new ArrayList<>();
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableComponents)));
        List<WebElement> componentDbElement = driver.findElements(By.cssSelector(tableComponents));
        int i = 0;
        for( WebElement element : componentDbElement){
            i++;
            List<WebElement> tdElements = element.findElements(By.cssSelector("td"));
            String partNumber = tdElements.get(1).getText();
            String description= tdElements.get(2).getText();
            String family= tdElements.get(3).getText();
            String status= tdElements.get(5).getText();
            String usage= tdElements.get(6).getText();
            String supplier= tdElements.get(7).getText();
            String supplierPN= tdElements.get(8).getText();
            Integer numberOfCavities= Integer.valueOf(tdElements.get(9).getText());
            componentDbData.add(new ComponentsDB(partNumber,description,family,status,usage,supplier,supplierPN,numberOfCavities));
        }
        return componentDbData;
    }

    public ComponentsDB getRandomComponent(List<ComponentsDB> ComponentDBList){
        Random rand = new Random();
        return ComponentDBList
                .get(rand.nextInt(ComponentDBList.size()));
    }
}
