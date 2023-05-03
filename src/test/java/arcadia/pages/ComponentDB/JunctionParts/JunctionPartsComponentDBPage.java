package arcadia.pages.ComponentDB.JunctionParts;

import arcadia.domainobjects.JunctionPartComponentDB;
import arcadia.domainobjects.OtherPartsComponentDB;
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

public class JunctionPartsComponentDBPage extends BasePage {
    public JunctionPartsComponentDBPage(WebDriver driver) {
        super(driver);
    }
    String tableJunctionParts = "#tbljunctionpart > tbody > tr";


    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();

    public List<JunctionPartComponentDB> getJunctionPartsAPIData(String jsonValue) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonValue);
        jsonValue=jsonNode.get("rows").toString();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        List<JunctionPartComponentDB> dbData = objectMapper.readValue(jsonValue, new TypeReference<List<JunctionPartComponentDB>>(){});
        return dbData;
    }

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
            String manufacturerStatus= tdElements.get(6).getText();
            String usage= tdElements.get(7).getText();
            String supplier= tdElements.get(8).getText();
            String supplierPN= tdElements.get(9).getText();
            String colour= tdElements.get(10).getText();
            String controlType= tdElements.get(11).getText();
            String Material= tdElements.get(12).getText();
            String wallThickness= tdElements.get(13).getText();
            componentDbData.add(new JunctionPartComponentDB(partNumber,description,family,status,manufacturerStatus,usage,supplier,supplierPN,colour,controlType,Material,wallThickness));
        }
        return componentDbData;
    }

    public JunctionPartComponentDB getRandomJunctionPartComponent(List<JunctionPartComponentDB> JunctionPartComponentDBList){
        Random rand = new Random();
        return JunctionPartComponentDBList
                .get(rand.nextInt(JunctionPartComponentDBList.size()));
    }
}
