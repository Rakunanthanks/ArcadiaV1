package arcadia.pages.ComponentDB.OtherParts;

import arcadia.domainobjects.OtherPartsComponentDB;
import arcadia.domainobjects.SplicesComponentDB;
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

public class OtherPartsComponentDBPage extends BasePage {
    public OtherPartsComponentDBPage(WebDriver driver) {
        super(driver);
    }
    String tableOtherParts = "#tblotherpart > tbody > tr";


    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();

    public List<OtherPartsComponentDB> getOtherPartAPIData(String jsonValue) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonValue);
        jsonValue=jsonNode.get("rows").toString();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        List<OtherPartsComponentDB> dbData = objectMapper.readValue(jsonValue, new TypeReference<List<OtherPartsComponentDB>>(){});
        return dbData;
    }
    public List<OtherPartsComponentDB> getOtherPartsData() throws InterruptedException {
        new CommonElements(driver).getFullPagination();
        List<OtherPartsComponentDB> componentDbData = new ArrayList<>();
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableOtherParts)));
        List<WebElement> componentDbElement = driver.findElements(By.cssSelector(tableOtherParts));
        int i = 0;
        for( WebElement element : componentDbElement){
            i++;
            List<WebElement> tdElements = element.findElements(By.cssSelector("td"));
            String partNumber = tdElements.get(1).getText();
            String description= tdElements.get(2).getText();
            String family= tdElements.get(3).getText();
            String status= tdElements.get(5).getText();
            String manufacturerStatus= tdElements.get(6).getText();
            String usage= tdElements.get(7).getText();
            String supplier= tdElements.get(8).getText();
            String supplierPN= tdElements.get(9).getText();
            String colour= tdElements.get(10).getText();
            componentDbData.add(new OtherPartsComponentDB(partNumber,description,family,status,manufacturerStatus,usage,supplier,supplierPN,colour));
        }
        return componentDbData;
    }

    public OtherPartsComponentDB getRandomOtherPartComponent(List<OtherPartsComponentDB> OtherPartComponentDBList){
        Random rand = new Random();
        return OtherPartComponentDBList
                .get(rand.nextInt(OtherPartComponentDBList.size()));
    }
}
