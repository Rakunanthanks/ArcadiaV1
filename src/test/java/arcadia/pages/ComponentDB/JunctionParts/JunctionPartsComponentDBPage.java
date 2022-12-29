package arcadia.pages.ComponentDB.JunctionParts;

import arcadia.domainobjects.JunctionPartComponentDB;
import arcadia.domainobjects.OtherPartsComponentDB;
import arcadia.pages.BasePage;
import arcadia.pages.ComponentDB.CommonElements;
import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JunctionPartsComponentDBPage extends BasePage {
    public JunctionPartsComponentDBPage(WebDriver driver) {
        super(driver);
    }
    String tableJunctionParts = "#tbljunctionpart > tbody > tr";


    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();

    public List<JunctionPartComponentDB> getJunctionPartsData() throws InterruptedException {
        new CommonElements(driver).viewAllFields();
        new CommonElements(driver).getFullPagination();
        List<JunctionPartComponentDB> componentDbData = new ArrayList<>();
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableJunctionParts)));
        List<WebElement> componentDbElement = driver.findElements(By.cssSelector(tableJunctionParts));
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
            String colour= tdElements.get(9).getText();
            String controlType= tdElements.get(10).getText();
            String Material= tdElements.get(11).getText();
            String wallThickness= tdElements.get(12).getText();
            componentDbData.add(new JunctionPartComponentDB(partNumber,description,family,status,usage,supplier,supplierPN,colour,controlType,Material,wallThickness));
        }
        return componentDbData;
    }

    public JunctionPartComponentDB getRandomJunctionPartComponent(List<JunctionPartComponentDB> JunctionPartComponentDBList){
        Random rand = new Random();
        return JunctionPartComponentDBList
                .get(rand.nextInt(JunctionPartComponentDBList.size()));
    }
}
