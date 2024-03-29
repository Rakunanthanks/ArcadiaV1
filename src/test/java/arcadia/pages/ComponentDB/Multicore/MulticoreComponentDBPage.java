package arcadia.pages.ComponentDB.Multicore;

import arcadia.domainobjects.MulticoreComponentDB;
import arcadia.domainobjects.SealsComponentDB;
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

public class MulticoreComponentDBPage extends BasePage {
    public MulticoreComponentDBPage(WebDriver driver) {
        super(driver);
    }
    String tableMulticore = "#tblmulticore > tbody > tr";

    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();

    public List<MulticoreComponentDB> getMulticoreData() throws InterruptedException {
        new CommonElements(driver).getFullPagination();
        List<MulticoreComponentDB> componentDbData = new ArrayList<>();
        customCommand.waitForElementVisibility(driver,driver.findElement(By.cssSelector(tableMulticore)));
        List<WebElement> componentDbElement = driver.findElements(By.cssSelector(tableMulticore));
        int i = 0;
        for( WebElement element : componentDbElement){
            i++;
            List<WebElement> tdElements = element.findElements(By.cssSelector("td"));
            String partNumber = tdElements.get(1).getText();
            String description= tdElements.get(2).getText();
            String family= tdElements.get(3).getText();
            String status= tdElements.get(5).getText();
            String manufacturerpartstatus=tdElements.get(6).getText();
            String usage= tdElements.get(7).getText();
            String supplier= tdElements.get(8).getText();
            String supplierPN= tdElements.get(9).getText();
            String colour= tdElements.get(10).getText();
            String cableType= tdElements.get(11).getText();
            Integer numberOfWires= Integer.valueOf(tdElements.get(12).getText());
            componentDbData.add(new MulticoreComponentDB(partNumber,description,family,status,usage,manufacturerpartstatus,supplier,supplierPN,colour,cableType,numberOfWires));
        }
        return componentDbData;
    }

    public List<MulticoreComponentDB> getMultiCoreAPIData(String jsonValue) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonValue);
        jsonValue=jsonNode.get("rows").toString();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        List<MulticoreComponentDB> dbData = objectMapper.readValue(jsonValue, new TypeReference<List<MulticoreComponentDB>>(){});
        return dbData;
    }

    public MulticoreComponentDB getRandomMulticoreComponent(List<MulticoreComponentDB> MulticoreComponentDBList){
        Random rand = new Random();
        return MulticoreComponentDBList
                .get(rand.nextInt(MulticoreComponentDBList.size()));
    }

    public int getRecordCountFromComponentDB() throws InterruptedException {
        new CommonElements(driver).getFullPagination();
        List<WebElement> webTable = driver.findElements(By.cssSelector(".fixed-table-body > table >tbody >tr"));
        return webTable.size();
    }
    public List<String> getPartNumber() throws InterruptedException {
        new CommonElements(driver).getFullPagination();
        List<WebElement> webTable = driver.findElements(By.cssSelector(".fixed-table-body > table >tbody >tr"));
        List<String> partNumberList = new ArrayList<>();
        for( WebElement element : webTable) {
            List<WebElement> tdElements = element.findElements(By.cssSelector("td"));
            String partNumber = tdElements.get(1).getText();
            partNumberList.add(partNumber);
        }
        return partNumberList;
    }
}


