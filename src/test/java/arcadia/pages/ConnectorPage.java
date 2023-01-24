package arcadia.pages;

import arcadia.context.FlowContext;
import arcadia.domainobjects.*;
import arcadia.pages.ComponentDB.CommonElements;
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

    @FindBy(css = "select[name=\"discrete_components.Dest_type\"]") private WebElement selectDestType;

    @FindBy(css = "select[name=\"discrete_components.cav_value\"]") private WebElement selectFromCavity;

    @FindBy(css = "select[name=\"discrete_components.dest_value\"]") private WebElement selectToCavity;

    @FindBy(css = "select[name=\"discrete_components.discrete_type\"]") private WebElement selectDiscreteType;

    @FindBy(css = "select[name=\"discrete_components.discretelibrary\"]") private WebElement selectDiscreteComponentDB;

    @FindBy(css = "table#discrete_components input[title=\"Get Details\"]") private WebElement buttonGetDiscreteCompDetails;

    @FindBy(css = "#tblAttachPartNoList>tbody>tr") private WebElement rowSearchedDiscreteParts;

    @FindBy(css = "select[name=\"node.connector.showdiscreteimage\"]") private WebElement selectShowDiscreteImage;

    @FindBy(css = "input[name=\"bom.name\"]") private WebElement inputConnectorId;

    @FindBy(css = "table#discrete_components input[title=\"Delete\"]") private WebElement buttonDeleteDiscrete;

    @FindBy(css = "div[aria-describedby=\"idFetchdiscrete_components\"] button[title=\"close\"]") private WebElement buttonCloseSearchDiscreteComp;

    String wireTableRows = "#wiretable>tbody>tr";

    @FindBy(css = "input[name=\"wiretable.get\"]") private WebElement buttonGetWireDetails;

    @FindBy(css = "input[name=\"wiretable.fromtag\"]") private WebElement tagWireFromConnector;

    @FindBy(css = "input[name=\"wiretable.totag\"]") private WebElement tagWireToConnector;

    @FindBy(css = "input[name=\"wiretable.material\"]") private WebElement inputMaterial;
    @FindBy(css = "input[name=\"wiretable.gauge\"]") private WebElement inputGauge;

    @FindBy(css = "button[name=\"wiretable.getPNdet\"]") private WebElement buttonUpdateWirePN;

    @FindBy(css = "input[name=\"wiretable.partnumber\"]") private WebElement inputWirePN;


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

    public WebElement getElementConnectorDiscreteComp(String plugID, String connectorId){
        WebElement ele = driver.findElement(By.xpath("//*[name()='g' and @id='"+plugID+"']//*[name()='g']//*[name()='text' and contains(text(),'"+connectorId+"')]"));
        return ele;
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

    public void enterDiscreteComponentDetails(String destType,int fromCavity,int toCavity, String discreteType, String componentDB ) throws InterruptedException {
        customCommand.waitForElementVisibility(driver,selectDestType);
        customCommand.selectDropDownByValue(selectDestType,destType.toLowerCase());
        customCommand.selectDropDownByValue(selectFromCavity, String.valueOf(fromCavity));
        customCommand.selectDropDownByValue(selectToCavity, String.valueOf(toCavity));
        customCommand.selectDropDownByValue(selectDiscreteType,discreteType.toLowerCase());
        customCommand.selectDropDownByValue(selectDiscreteComponentDB,componentDB);
        buttonGetDiscreteCompDetails.click();
    }

    public void selectFirstDiscretePart() throws InterruptedException {
        customCommand.waitForElementVisibility(driver,rowSearchedDiscreteParts);
        customCommand.waitForElementToBeClickable(driver,rowSearchedDiscreteParts);
        customCommand.doubleClick(driver,rowSearchedDiscreteParts);
        Thread.sleep(4000);
        if(driver.findElements(By.cssSelector("div[aria-describedby=\"idFetchdiscrete_components\"] button[title=\"close\"]")).size()!=0){
            buttonCloseSearchDiscreteComp.click();
            Thread.sleep(2000);
        }
    }

    public void setShowDiscreteImage(String showHide) throws InterruptedException {
        customCommand.waitForElementVisibility(driver,selectShowDiscreteImage);
        customCommand.waitForElementToBeClickable(driver,selectShowDiscreteImage);
        customCommand.selectDropDownByValue(selectShowDiscreteImage,showHide);
    }

    public String getConnectorID(){
        String connectorId = inputConnectorId.getAttribute("value");
        return connectorId;
    }

    public void verifyDiscreteComponentDisplayed(String connectorPlugId, String connectorId){
        WebElement elementDiscreteComponent = getElementConnectorDiscreteComp(connectorPlugId,connectorId);
        Assert.assertTrue(elementDiscreteComponent.isDisplayed());
    }

    public void deleteFirstDiscretePart() throws InterruptedException {
        customCommand.waitForElementVisibility(driver,buttonDeleteDiscrete);
        customCommand.waitClick(buttonDeleteDiscrete);
        new CommonElements(driver).verifyAlertMessage("Do you want to delete the selected one?");
        new CommonElements(driver).acceptAlertMessage();
    }

    public void addWire() throws InterruptedException {
        if (driver.findElements(By.cssSelector(wireTableRows)).size()==0){
            addRowInCavityTable(1);
        }
    }

    public void clickGetWireDetails(){
        customCommand.waitForElementToBeClickable(driver,buttonGetWireDetails);
        buttonGetWireDetails.click();
    }

    public void verifyTagWireFromConnector(String expectedTagValue){
        Assert.assertEquals(tagWireFromConnector.getAttribute("value"),expectedTagValue);
    }

    public void verifyTagWireToConnector(String expectedTagValue){
        Assert.assertEquals(tagWireToConnector.getAttribute("value"),expectedTagValue);
    }

    public void enterMaterialInWireTable(String materialValue ) throws InterruptedException {
        customCommand.enterText(inputMaterial,materialValue);
    }

    public void enterGaugeInWireTable(String gaugeValue ) throws InterruptedException {
        customCommand.enterText(inputGauge,gaugeValue);
    }

    public void clickUpdateWirePN() throws InterruptedException {
        customCommand.scrollIntoView(driver,buttonUpdateWirePN);
        customCommand.waitForElementToBeClickable(driver,buttonUpdateWirePN);
        buttonUpdateWirePN.click();
    }
    public String getValueOfWirePN() throws InterruptedException {
        customCommand.scrollIntoView(driver,inputWirePN);
        customCommand.waitForElementToBeClickable(driver,inputWirePN);
        String wirePN = customCommand.javaScriptGetValueOfElement(driver,inputWirePN);
        return wirePN;
    }

}
