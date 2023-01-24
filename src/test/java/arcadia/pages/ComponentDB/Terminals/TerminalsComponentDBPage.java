package arcadia.pages.ComponentDB.Terminals;

import arcadia.domainobjects.TerminalsComponentDB;
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

public class TerminalsComponentDBPage extends BasePage {
    public TerminalsComponentDBPage(WebDriver driver) {
        super(driver);
    }
    String tableTerminalRows = "#tblterminal > tbody > tr";


    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();

    public List<TerminalsComponentDB> getTerminalAPIData(String jsonValue) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonValue);
        jsonValue=jsonNode.get("rows").toString();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        List<TerminalsComponentDB> dbData = objectMapper.readValue(jsonValue, new TypeReference<List<TerminalsComponentDB>>(){});
        return dbData;
    }

    public List<TerminalsComponentDB> getTerminalsData() throws InterruptedException {
        new CommonElements(driver).getFullPagination();
        List<TerminalsComponentDB> componentDbData = new ArrayList<>();
        List<WebElement> componentDbElement = driver.findElements(By.cssSelector(tableTerminalRows));
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
            String gender= tdElements.get(10).getText();
            String type= tdElements.get(11).getText();
            String finish= tdElements.get(12).getText();
            String material= tdElements.get(13).getText();
            Double stripLength= Double.valueOf(tdElements.get(14).getText());
            Double threadDia= Double.valueOf(tdElements.get(15).getText());
            String wireInsOD= tdElements.get(16).getText();
            String wireCSA= tdElements.get(17).getText();
            componentDbData.add(new TerminalsComponentDB(partNumber,description,family,status,usage,supplier,supplierPN,colour,gender,type,finish,material,stripLength,threadDia,wireInsOD,wireCSA));
        }
        return componentDbData;
    }

    public TerminalsComponentDB getRandomTerminalComponent(List<TerminalsComponentDB> terminalsComponentDBList){
        Random rand = new Random();
        return terminalsComponentDBList
                .get(rand.nextInt(terminalsComponentDBList.size()));
    }
}