package arcadia.pages.ComponentDB.Components;

import arcadia.domainobjects.ComponentsDB;
import arcadia.domainobjects.JunctionPartComponentDB;
import arcadia.domainobjects.MulticoreComponentDB;
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

public class ComponentsDBPage extends BasePage {
    public ComponentsDBPage(WebDriver driver) {
        super(driver);
    }
    String tableComponents = "#tblcomponent > tbody > tr";


    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();

    public List<ComponentsDB> getComponentAPIData(String jsonValue) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonValue);
        jsonValue=jsonNode.get("rows").toString();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        List<ComponentsDB> dbData = objectMapper.readValue(jsonValue, new TypeReference<List<ComponentsDB>>(){});
        return dbData;
    }

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
            String usage= tdElements.get(7).getText();
            String supplier= tdElements.get(8).getText();
            String supplierPN= tdElements.get(9).getText();
            Integer numberOfCavities= Integer.valueOf(tdElements.get(10).getText());
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
