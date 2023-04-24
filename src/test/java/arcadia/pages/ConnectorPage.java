package arcadia.pages;

import arcadia.context.FlowContext;
import arcadia.domainobjects.*;
import arcadia.pages.ComponentDB.CommonElements;
import arcadia.utils.SeleniumCustomCommand;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConnectorPage extends BasePage {
    public ConnectorPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "button[title=\"Submit\"]") private WebElement submitConnector;
    @FindBy(css = "h3[id=\"ui-accordion-accordion-header-1\"]") private WebElement wireTable;
    @FindBy(css = "h3[id=\"ui-accordion-accordion-header-4\"]") private WebElement cavityTable;

    @FindBy(css = "h3[id=\"ui-accordion-accordion-header-5\"]") private WebElement tableLayout;

    @FindBy(css = "h3[id=\"ui-accordion-accordion-header-6\"]") private WebElement tableProperties;

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

    @FindBy(css = "input[name=\"cavitytable.imagepath\"]") private WebElement inputCavityImagePath;

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

    @FindBy(css = "table#node_attachpart input[title=\"Get Details\"]") private WebElement buttonGetAttachedPartsDetails;

    String attachedPartsCheckboxes = "input[name=\"node.attachpart.optionenabled\"]";

    @FindBy(css = "input[name=\"node.attachpart.partnumber\"]") private WebElement inputAttachPartNumber;
    @FindBy(css = "input[name=\"node.attachpart.description\"]") private WebElement inputAttachPartDescription;
    @FindBy(css = "input[name=\"node.attachpart.quantity\"]") private WebElement inputAttachPartQuantity;
    @FindBy(css = "input[name=\"node.attachpart.parttype\"]") private WebElement inputAttachPartRequirement;
    @FindBy(css = "select[name=\"node.attachpart.uom\"]") private WebElement attachPartSelectBoxMeasure;
    @FindBy(css = "input[name=\"node.attachpart.imagepath\"]") private WebElement inputAttachPartImagePath;

    @FindBy(css = "select[name=\"cavitytable.terminalpn\"]+div input") private WebElement terminalPNCavityTable;

    @FindBy(css = "select[name=\"cavitytable.sealpn\"]+div input") private WebElement sealPNCavityTable;
    @FindBy(css = "select[name=\"cavitytable.plugpn\"]+div input") private WebElement plugPNCavityTable;

    @FindBy(css = "input[name=\"cavitytablelayout.wrap\"]") private WebElement inputTableWrapFrom;

    @FindBy(xpath = "//input[@id='commandline']") private  WebElement commandLine;

    String getDetailsCavityTable = "div#ui-accordion-accordion-panel-4 input[title=\"Get Details\"]";
    String cavityTableLayoutShowOptions = "select[name=\"cavitytablelayout.showoptions\"]";

    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();

    public void submitConnector() throws InterruptedException{
        customCommand.waitForElementToBeClickable(driver,wireTable);
        customCommand.scrollIntoView(driver,submitConnector);
        customCommand.javaScriptClick(driver,submitConnector);
        Thread.sleep(3000);
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
            customCommand.clearAndEnterText(wirePartNumber.get(Integer.parseInt(connectorItem.getCavityFrom())-1),connectorItem.getWireParts());
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
            wireProperties.setWireOuterDiameter(String.valueOf(wireOuterDia));
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
        System.out.println(FlowContext.connectorPlugIdentifierList);
        return  FlowContext.connectorPlugIdentifierList;
    }
    public void rightClickConnectorPlugElement(String connectorPlugId) throws InterruptedException {
        WebElement select = driver.findElement(By.cssSelector("#idrawcom"));
        select.click();
        Actions actions = new Actions(driver);
        WebElement ele = driver.findElement(By.xpath("//*[name()='g' and @id='"+connectorPlugId+"']//*[name()='rect' and contains(@etype,'connector')]"));
        actions.contextClick(ele).perform();
        Thread.sleep(2000);
    }

    public void addSpliceWithCommand(String command) throws InterruptedException {
        customCommand.simulateKeyEnterWithValue(commandLine,command);
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver,submitConnector);
    }

    public List<SpliceIdentifier> getSpliceElementIdsFromDrawingPage() {
        String spliceId;
        List<WebElement> bundleElements = driver.findElements(By.cssSelector("#layer_80 >g[class$=\"bundleGroup\"]>g"));
        for( WebElement element : bundleElements){
            if(!element.findElements(By.cssSelector("rect[etype=\"splice\"]")).isEmpty()){
                spliceId = element.getAttribute("id");
                FlowContext.spliceIdentifierList.add(new SpliceIdentifier(spliceId));
            }
        }
        return  FlowContext.spliceIdentifierList;
    }

    public List<BundleIdentifier> getBundleElementIdsFromDrawingPage() {
        String bundleId;
        List<WebElement> bundleElements = driver.findElements(By.cssSelector("#layer_55 >g>g[class$=\"bundleGroup\"]"));
       List<String> bundleIds=new ArrayList<>();
        for( WebElement element : bundleElements){
                bundleId = element.getAttribute("id");
               FlowContext.bundleIdentifierList.add(new BundleIdentifier(bundleId));
        }
        return  FlowContext.bundleIdentifierList;
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

    public void clickGetDetailsAttachedParts() throws InterruptedException {
        customCommand.waitForElementToBeClickable(driver,buttonGetAttachedPartsDetails);
        buttonGetAttachedPartsDetails.click();
        Thread.sleep(2000);
    }

    public void verifyAttachedPartsAreChecked() throws InterruptedException {
        List<WebElement> listOfCheckboxes = driver.findElements(By.cssSelector(attachedPartsCheckboxes));
        for(WebElement e: listOfCheckboxes){
            Assert.assertEquals(e.getAttribute("value"),"yes");
        }
    }

    public void verifyAttachedPartsDetails(String partNumber,String description,String quantity,String measure, String requirement) {
        Assert.assertEquals(inputAttachPartNumber.getAttribute("value"),partNumber);
        Assert.assertEquals(inputAttachPartDescription.getAttribute("value"),description);
        Assert.assertEquals(inputAttachPartQuantity.getAttribute("value"),quantity);
        Assert.assertEquals(customCommand.getSelectedValueFromSelectDropDown(attachPartSelectBoxMeasure),measure);
        Assert.assertEquals(inputAttachPartRequirement.getAttribute("value"),requirement);
    }

    public void verifyImagePath(String imagePathValue) {
        Assert.assertEquals(inputAttachPartImagePath.getAttribute("value"),imagePathValue);
    }

    public void openCavityTable() throws InterruptedException {
        customCommand.waitForElementVisibility(driver,wireTable);
        customCommand.scrollIntoView(driver,cavityTable);
        cavityTable.click();
        Thread.sleep(2000);
    }


    public void verifyTerminalsPNCavityTable(List<String> listOfexpectedLinkedTerminalsPNFromComponentDB) throws InterruptedException {
        openCavityTable();
        terminalPNCavityTable.click();
        List<WebElement> eleTerminalsPN = driver.findElements(By.cssSelector("select[name=\"cavitytable.terminalpn\"]+div div.selectize-dropdown-content>div"));
        List<String> listOfactualTerminalPn = new ArrayList<>();
        for (WebElement e: eleTerminalsPN){
            listOfactualTerminalPn.add(e.getAttribute("data-value"));
        }
        List<String> differenceFromExpectedTerminalsPNList = listOfexpectedLinkedTerminalsPNFromComponentDB.stream()
                .filter(element -> !listOfactualTerminalPn.contains(element))
                .collect(Collectors.toList());
        if(differenceFromExpectedTerminalsPNList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with expected %s", differenceFromExpectedTerminalsPNList.toString()));
        }
        List<String> differenceFromActualTerminalsPNList = listOfactualTerminalPn.stream()
                .filter(element -> !listOfexpectedLinkedTerminalsPNFromComponentDB.contains(element))
                .collect(Collectors.toList());
        if(differenceFromActualTerminalsPNList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with actual %s", differenceFromActualTerminalsPNList.toString()));
        }
        Assert.assertEquals(listOfactualTerminalPn.size(),listOfexpectedLinkedTerminalsPNFromComponentDB.size());
    }

    public void clickGetCavityTableDetails() throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementToBeClickable(driver,driver.findElements(By.cssSelector(getDetailsCavityTable)).get(0));
        customCommand.javaScriptClick(driver,driver.findElements(By.cssSelector(getDetailsCavityTable)).get(0));
    }

    public void verifySealsPNCavityTable(List<String> listOfexpectedLinkedSealsPNFromComponentDB) throws InterruptedException {
        openCavityTable();
        customCommand.scrollIntoView(driver,sealPNCavityTable);
        sealPNCavityTable.click();
        List<WebElement> eleSealsPN = driver.findElements(By.cssSelector("select[name=\"cavitytable.sealpn\"]+div div.selectize-dropdown-content>div"));
        List<String> listOfactualSealPn = new ArrayList<>();
        for (WebElement e: eleSealsPN){
            listOfactualSealPn.add(e.getAttribute("data-value"));
        }
        List<String> differenceFromExpectedSealsPNList = listOfexpectedLinkedSealsPNFromComponentDB.stream()
                .filter(element -> !listOfactualSealPn.contains(element))
                .collect(Collectors.toList());
        if(differenceFromExpectedSealsPNList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with expected %s", differenceFromExpectedSealsPNList.toString()));
        }
        List<String> differenceFromActualSealsPNList = listOfactualSealPn.stream()
                .filter(element -> !listOfexpectedLinkedSealsPNFromComponentDB.contains(element))
                .collect(Collectors.toList());
        if(differenceFromActualSealsPNList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with actual %s", differenceFromActualSealsPNList.toString()));
        }
        Assert.assertEquals(listOfactualSealPn.size(),listOfexpectedLinkedSealsPNFromComponentDB.size());
    }

    public void verifyPlugsPNCavityTable(List<String> listOfLinkedPlugsPNFromComponentDB) throws InterruptedException {
        openCavityTable();
        customCommand.scrollIntoView(driver,plugPNCavityTable);
        plugPNCavityTable.click();
        List<WebElement> elePlugsPN = driver.findElements(By.cssSelector("select[name=\"cavitytable.plugpn\"]+div div.selectize-dropdown-content>div"));
        List<String> listOfactualPlugPn = new ArrayList<>();
        for (WebElement e: elePlugsPN){
            listOfactualPlugPn.add(e.getAttribute("data-value"));
        }
        List<String> differenceFromExpectedPlugsPNList = listOfLinkedPlugsPNFromComponentDB.stream()
                .filter(element -> !listOfactualPlugPn.contains(element))
                .collect(Collectors.toList());
        if(differenceFromExpectedPlugsPNList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with expected %s", differenceFromExpectedPlugsPNList.toString()));
        }
        List<String> differenceFromActualPlugsPNList = listOfactualPlugPn.stream()
                .filter(element -> !listOfLinkedPlugsPNFromComponentDB.contains(element))
                .collect(Collectors.toList());
        if(differenceFromActualPlugsPNList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with actual %s", differenceFromActualPlugsPNList.toString()));
        }
        Assert.assertEquals(listOfactualPlugPn.size(),listOfLinkedPlugsPNFromComponentDB.size());
    }

    public void openTableLayout() throws InterruptedException {
        customCommand.waitForElementVisibility(driver,tableLayout);
        customCommand.scrollIntoView(driver,tableLayout);
        tableLayout.click();
        Thread.sleep(2000);
    }

    public void setTableLayoutVisibility(String visible) throws InterruptedException {
        List<WebElement> listOfShowOptions = driver.findElements(By.cssSelector(cavityTableLayoutShowOptions));
        for (WebElement e : listOfShowOptions){
            customCommand.scrollIntoView(driver,e);
            customCommand.selectDropDownByValue(e,visible.toLowerCase());
        }
    }

    public int getNumberOfOptionsInCavityLayout(){
        List<WebElement> listOfShowOptions = driver.findElements(By.cssSelector(cavityTableLayoutShowOptions));
        return listOfShowOptions.size();
    }

    public void openTableProperties() throws InterruptedException {
        customCommand.waitForElementVisibility(driver,tableProperties);
        customCommand.scrollIntoView(driver,tableProperties);
        tableProperties.click();
        Thread.sleep(2000);
    }

    public void setTablePropertyWrapFrom(String wrapValue) throws InterruptedException {
        openTableProperties();
        inputTableWrapFrom.clear();
        customCommand.enterText(inputTableWrapFrom,wrapValue);
    }

    public void verifyConnectorDetailsWindowOpened() {
        Assert.assertTrue(driver.findElement(By.id("DynamicForm")).isDisplayed());
        Assert.assertTrue(inputConnectorId.isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()=\"CONNECTOR\"]")).isDisplayed());
    }

    public String getImagePathOfCavity() throws InterruptedException {
        customCommand.scrollIntoView(driver,inputCavityImagePath);
        String imagePath = inputCavityImagePath.getAttribute("value");
        return imagePath;
    }

    public void verifyCavityTableDetailsIsOpened() {
        Assert.assertTrue(terminalPNCavityTable.isDisplayed(),"Cavity table is not opened and terminal pn is not visible");
    }

    public void verifyWireTablesRowCount(int i) {
        Assert.assertEquals(driver.findElements(By.cssSelector(wireTableRows)).size(),i,"Number of rows present in cavity table are not as expected");
    }
}
