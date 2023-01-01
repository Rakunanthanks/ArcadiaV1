package arcadia.pages.ComponentDB.Connectors;

import arcadia.domainobjects.ComponentsDB;
import arcadia.domainobjects.ConnectorDB;
import arcadia.pages.BasePage;
import arcadia.pages.ComponentDB.CommonElements;
import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConnectorsDBPage extends BasePage {
    public ConnectorsDBPage(WebDriver driver) {
        super(driver);
    }
    String tableConnectors = "#tblconnector > tbody > tr";


    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();

    public List<ConnectorDB> getConnectorsData() throws InterruptedException {
        new CommonElements(driver).getFullPagination();
        List<ConnectorDB> componentDbData = new ArrayList<>();
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableConnectors)));
        List<WebElement> componentDbElement = driver.findElements(By.cssSelector(tableConnectors));
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
            String housingGender= tdElements.get(10).getText();
            String terminalGender= tdElements.get(11).getText();
            String connectorType= tdElements.get(12).getText();
            Integer numberOfCavities= Integer.valueOf(tdElements.get(13).getText());
            String keyway= tdElements.get(14).getText();
            componentDbData.add(new ConnectorDB(partNumber,description,family,status,usage,supplier,supplierPN,colour,housingGender,terminalGender,connectorType,numberOfCavities,keyway));
        }
        return componentDbData;
    }

    public ConnectorDB getRandomConnectorComponent(List<ConnectorDB> ConnectorComponentDBList){
        Random rand = new Random();
        return ConnectorComponentDBList
                .get(rand.nextInt(ConnectorComponentDBList.size()));
    }
}
