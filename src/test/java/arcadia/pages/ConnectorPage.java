package arcadia.pages;

import arcadia.context.FlowContext;
import arcadia.domainobjects.*;
import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ConnectorPage extends BasePage {
    public ConnectorPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "button[title=\"Submit\"]") private WebElement submitConnector;
    @FindBy(css = "h3[id=\"ui-accordion-accordion-header-1\"]") private WebElement wireTable;
    @FindBy(css = "h3[id=\"ui-accordion-accordion-header-4\"]") private WebElement cavityTable;

    @FindBy(css = "input[name=\"node.functiondescription\"]") private WebElement connectorDescription;

    @FindBy(css = "select[name=\"bom.cavityDisplay\"]") private WebElement selectCavityTableDisplay;
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();

    public void submitConnector() throws InterruptedException{
        customCommand.waitForElementToBeClickable(driver,wireTable);
        customCommand.scrollIntoView(driver,submitConnector);
        customCommand.javaScriptClick(driver,submitConnector);
    }

    public WebElement getElementConnectorDescription(String plugID, String description){
        WebElement ele = driver.findElement(By.xpath("//*[name()='g' and @id='"+plugID+"']//*[name()='g']//*[name()='text' and text()='"+description+"']"));
        return ele;
    }

    public WebElement getElementConnectorMultiDescription(String plugID, String description){
        WebElement ele = driver.findElement(By.xpath("//*[name()='g' and @id='"+plugID+"']//*[name()='g']//*[name()='text']//*[name()='tspan' and text()='"+description+"']"));
        return ele;
    }

    public List<WebElement> getElementsConnectorCavityTable(String plugID){
        List<WebElement> elements = driver.findElements(By.xpath("//*[name()='g' and @id='"+plugID+"']//*[name()='g']//table"));
        return elements;
    }
    public void addRowInCavityTable(Integer numberOfCavities) throws InterruptedException {
        customCommand.waitForElementVisibility(driver,wireTable);
        customCommand.scrollIntoView(driver,cavityTable);
        cavityTable.click();
        Thread.sleep(2000);
        List<WebElement> addRows = driver.findElements(By.cssSelector("#cavitytable >tbody >tr >td >.addRow"));
        for (int i=0 ;i<numberOfCavities ;i++){
            addRows.get(i).click();
            Thread.sleep(1000);
        }
    }
    public Wire updateWireTableConnector(List<ConnectorWireTable> wireTableList, boolean submitConnector) throws  InterruptedException{
        List<WireProperties> wPropertyList = new ArrayList<>();
        Wire wireItem = new Wire();
        customCommand.scrollIntoView(driver,wireTable);
        List<WebElement> wireTableConnectorTo = driver.findElements(By.cssSelector("#wiretable >tbody >tr >td >select[name=\"wiretable.conidto\"]"));
        List<WebElement> wireTableCavityFrom = driver.findElements(By.cssSelector("#wiretable >tbody >tr >td >select[name=\"wiretable.cavid\"]"));
        List<WebElement> wireTableCavityTo = driver.findElements(By.cssSelector("#wiretable >tbody >tr >td >select[name=\"wiretable.cavidto\"]"));
        List<WebElement> wirePartNumber = driver.findElements(By.cssSelector("input[name=\"wiretable.partnumber\"]"));
        List<WebElement> wireTablePopup = driver.findElements(By.cssSelector("#wiretable>tbody>tr>td>input[rel=\"get\"]"));
        for(ConnectorWireTable connectorItem : wireTableList){
            WireProperties wireProperties = new WireProperties();
            customCommand.selectDropDownByVisibleText(wireTableCavityFrom.get(Integer.parseInt(connectorItem.getCavityFrom())-1), connectorItem.getCavityFrom());
            customCommand.selectDropDownByVisibleText(wireTableConnectorTo.get(Integer.parseInt(connectorItem.getCavityFrom())-1),connectorItem.getConnectTo());
            customCommand.selectDropDownByValue(wireTableCavityTo.get(Integer.parseInt(connectorItem.getCavityFrom())-1),connectorItem.getCavityTo());
            customCommand.enterText(wirePartNumber.get(Integer.parseInt(connectorItem.getCavityFrom())-1),connectorItem.getWireParts());
            wireTablePopup.get(Integer.parseInt(connectorItem.getCavityFrom())-1).click();
            Thread.sleep(2000);
            SearchWirePage searchWirePage = PageFactoryManager.getSearchWirePage(driver);
            searchWirePage.populateWire();
            customCommand.waitForElementVisibility(driver,wireTableCavityFrom.get(Integer.parseInt(connectorItem.getCavityFrom())-1));
            WebElement wireColour = driver.findElement(By.cssSelector("#wiretable >tbody >tr >td >select[name=\"wiretable.pcolour\"]"));
            customCommand.scrollIntoView(driver,wireColour);
            String colour = customCommand.getValueByJavascriptExecutor(driver,wireColour);
            wireProperties.setWireColour(colour);
            List<WebElement> outerDia = driver.findElements(By.cssSelector("#wiretable >tbody >tr >td >input[name=\"wiretable.outerdia\"]"));
            customCommand.scrollIntoView(driver,outerDia.get(Integer.parseInt(connectorItem.getCavityFrom())-1));
            String wireOuterDia = outerDia.get(Integer.parseInt(connectorItem.getCavityFrom())-1).getAttribute("value");
            wireProperties.setWireOuterDiameter(Double.valueOf(wireOuterDia));
            wPropertyList.add(wireProperties);
        }
        wireItem.setWirePropertiesList(wPropertyList);
        wireItem.setConnectorName(wireTableList.get(0).getConnectTo());
        FlowContext.wirePropertiesList.add(wireItem);
        if(submitConnector){
            submitConnector();
        }
        return wireItem;
    }
    public void addConnectorToNode(String nodeElement, Integer addRowInCavityTable,String connectorPart , String cavityNumber) throws InterruptedException{
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(By.cssSelector("g[id=\""+nodeElement+"\"]"));
        actions.moveToElement(menu).click().build().perform();

        if(connectorPart != null && !connectorPart.isEmpty()) {
        new SearchPartsDatabasePage(driver).findInSearchPartDatabase(connectorPart,cavityNumber);
        new SearchPartsDatabasePage(driver).populateParts();
        Thread.sleep(4000);
        WebElement bomElement = driver.findElement(By.cssSelector("input[name=\"bom.name\"]"));
        customCommand.waitForElementVisibility(driver,bomElement);
        WebElement connectorNameElement = driver.findElement(By.cssSelector("input[name=\"bom.name\"]"));
        customCommand.waitForElementVisibility(driver,connectorNameElement);
        String connectorId = connectorNameElement.getAttribute("value");
        List<String> connectorIdList = new ArrayList<>();
        List<String> connectorNodeElementList = new ArrayList<>();
        if(!FlowContext.connectorIdentifierList.isEmpty()){
            for(ConnectorIdentifier item :FlowContext.connectorIdentifierList){
                connectorIdList.add(item.getConnectorId());
                connectorNodeElementList.add(item.getConnectorReferenceNumber());
            }
        }
        List<WebElement> nodeElements = driver.findElements(By.cssSelector("#layer_80 >g[class$=\"bundleGroup\"]>g>g"));
        for(WebElement element : nodeElements){
            if(!element.findElements(By.cssSelector("g>g>image[data-etype=\"connector\"]")).isEmpty()){
                String connectorReference = element.findElement(By.cssSelector("g>g>image[data-etype=\"connector\"]")).getAttribute("data-uid");
                if(!connectorIdList.contains(connectorId) && !connectorNodeElementList.contains(connectorReference)){
                    FlowContext.connectorIdentifierList.add(new ConnectorIdentifier(connectorId,connectorReference));
                    connectorIdList.add(connectorId);
                    connectorNodeElementList.add(connectorReference);
                }
            }
        }
        if(addRowInCavityTable != null && addRowInCavityTable > 0){
            addRowInCavityTable(addRowInCavityTable);
        }
        submitConnector();
        }

    }
    public void addWire(List<ConnectorWireTable> wireTableList , boolean submitConnector) throws InterruptedException {
        Thread.sleep(2000);
        updateWireTableConnector(wireTableList,submitConnector);
    }

    public void openConnectorForm(String connectorNodeReference) throws InterruptedException {
        new HarnessPage(driver).clickOnSelect();
        WebElement connectorElement = driver.findElement(By.cssSelector("image[data-uid=\""+connectorNodeReference+"\"]"));
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveToElement(connectorElement).doubleClick().build().perform();
        Thread.sleep(4000);

    }

    public List<ConnectorPlugIdentifier> getConnectorPlugELementIdsFromDrawingPage() {
        String connectorPlugId;
        List<WebElement> bundleElements = driver.findElements(By.cssSelector("#layer_80 >g[class$=\"bundleGroup\"]>g"));
        for( WebElement element : bundleElements){
                if(!element.findElements(By.cssSelector("rect[etype=\"connector\"]")).isEmpty()){
                    connectorPlugId = element.getAttribute("id");
                    FlowContext.connectorPlugIdentifierList.add(new ConnectorPlugIdentifier(connectorPlugId));
                }
            }
        return  FlowContext.connectorPlugIdentifierList;
    }

    public void enterConnectorDescription(String description){
        customCommand.waitForElementVisibility(driver,connectorDescription);
        connectorDescription.clear();
        connectorDescription.sendKeys(description);
    }

    public void verifyConnectorDescription(String description, String connectorPlugId){
        String[] desc;
        WebElement ele;
        if (description.contains("|")){
            desc = description.split("\\|");
            for (String conDesc: desc){
                ele = getElementConnectorMultiDescription(connectorPlugId,conDesc);
                Assert.assertTrue(ele.isDisplayed());
            }
        }
        else {
            ele = getElementConnectorDescription(connectorPlugId,description);
            Assert.assertTrue(ele.isDisplayed());
        }
    }

    public void selectCavityTableDisplay(String displayValue) throws InterruptedException {
        customCommand.waitForElementVisibility(driver,selectCavityTableDisplay);
        customCommand.selectDropDownByValue(selectCavityTableDisplay,displayValue);
    }

    public void verifyCavityTableDisplayed(int numberOfTables, String connectorPlugId){
        List<WebElement> cavityTables = getElementsConnectorCavityTable(connectorPlugId);
        Assert.assertTrue(cavityTables.size()==numberOfTables);
    }

}
