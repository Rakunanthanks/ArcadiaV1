package arcadia.pages.ComponentDB.Applicators;

import arcadia.domainobjects.ApplicatorsComponentDB;
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

public class ApplicatorsComponentDBPage extends BasePage {
    public ApplicatorsComponentDBPage(WebDriver driver) {
        super(driver);
    }
    String tableApplicator = "#tblapplicator > tbody > tr";


    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();

    public List<ApplicatorsComponentDB> getApplicatorsData() throws InterruptedException {
        new CommonElements(driver).getFullPagination();
        List<ApplicatorsComponentDB> componentDbData = new ArrayList<>();
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableApplicator)));
        List<WebElement> componentDbElement = driver.findElements(By.cssSelector(tableApplicator));
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
            String applicatorUsage= tdElements.get(10).getText();
            String forSealOrTerminal= tdElements.get(11).getText();
            String inService= tdElements.get(12).getText();
            String applicatorSite= tdElements.get(13).getText();
            componentDbData.add(new ApplicatorsComponentDB(partNumber,description,family,status,usage,supplier,supplierPN,colour,applicatorUsage,forSealOrTerminal,inService,applicatorSite));
        }
        return componentDbData;
    }

    public ApplicatorsComponentDB getRandomApplicatorComponent(List<ApplicatorsComponentDB> ApplicatorsComponentDBList){
        Random rand = new Random();
        return ApplicatorsComponentDBList
                .get(rand.nextInt(ApplicatorsComponentDBList.size()));
    }
}
