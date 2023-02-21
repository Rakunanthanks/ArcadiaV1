package arcadia.pages.ComponentDB.Splices;

import arcadia.domainobjects.SplicesComponentDB;
import arcadia.domainobjects.WiresComponentDB;
import arcadia.pages.BasePage;
import arcadia.pages.ComponentDB.CommonElements;
import arcadia.utils.SeleniumCustomCommand;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SplicesComponentDBPage extends BasePage {
    public SplicesComponentDBPage(WebDriver driver) {
        super(driver);
    }
    String tableSpliceRows = "#tblsplice > tbody > tr";


    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();

    public List<SplicesComponentDB> getSpliceAPIData(String jsonValue) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonValue);
        jsonValue=jsonNode.get("rows").toString();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        List<SplicesComponentDB> dbData = objectMapper.readValue(jsonValue, new TypeReference<List<SplicesComponentDB>>(){});
        return dbData;
    }
    public List<SplicesComponentDB> getSplicesData() throws InterruptedException {
        new CommonElements(driver).getFullPagination();
        List<SplicesComponentDB> componentDbData = new ArrayList<>();
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableSpliceRows)));
        List<WebElement> componentDbElement = driver.findElements(By.cssSelector(tableSpliceRows));
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
            String sealingType= tdElements.get(10).getText();
            String material= tdElements.get(12).getText();
            componentDbData.add(new SplicesComponentDB(partNumber,description,family,status,usage,supplier,supplierPN,colour,sealingType,material));
        }
        return componentDbData;
    }

    public SplicesComponentDB getRandomSpliceComponent(List<SplicesComponentDB> SplicesComponentDBList){
        Random rand = new Random();
        return SplicesComponentDBList
                .get(rand.nextInt(SplicesComponentDBList.size()));
    }
}
