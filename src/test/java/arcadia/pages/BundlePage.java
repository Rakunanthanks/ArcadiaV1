package arcadia.pages;

import arcadia.context.FlowContext;
import arcadia.domainobjects.BundleForm;
import arcadia.domainobjects.HarnessBundleDisplay;
import arcadia.domainobjects.InsulationParts;
import arcadia.domainobjects.NodeIdentifier;
import arcadia.utils.FormulaCalculator;
import arcadia.utils.SeleniumCustomCommand;
import io.cucumber.java.eo.Do;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static arcadia.context.FlowContext.bundleFormData;
import static java.util.stream.Collectors.toList;

public class BundlePage extends BasePage {
    public BundlePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "p[rel=\"BundleWireDia\"]") private WebElement wireBundleDiameter;
    @FindBy(css = "button[name=\"coverings.getdimension\"] > span") private WebElement getSleeveTube;
    @FindBy(css = "input[rel=\"reference\"]") private WebElement partReference;
    @FindBy(id = "bundlesize") private WebElement bundleSize;

    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    HarnessPage harnessPage = new HarnessPage(driver);
    public void drawBundle(String bundleCommand) throws InterruptedException, AWTException {
        harnessPage.waitForHarnessPage();
        harnessPage.clickOnBundle();
        harnessPage.fillCommandLine(bundleCommand);
        harnessPage.clickOnCommandLineOK();
        harnessPage.waitBetweenHarnessActions();
    }
    public List<WebElement> getBundleNodeElementId() throws InterruptedException{
        WebElement element = driver.findElement(By.cssSelector("g[class$=\"bundleGroup\"] > g >g"));
        customCommand.waitForElementVisibility(driver,element);
        List<WebElement> bundleWebElement = driver.findElements(By.cssSelector("g[class$=\"bundleGroup\"] > g >g"));
        return bundleWebElement;
    }
    private String getWireBundleDiameter(){
        return wireBundleDiameter.getText().replace("mm","").trim();
    }
    public void waitForBundleForm(){
        customCommand.waitForElementVisibility(driver,bundleSize);
    }
    public void chooseCovering(String coveringValue , int coveringRow, boolean multipleCoveringType) throws InterruptedException {
        waitForBundleForm();
        List<WebElement> coveringElements = driver.findElements(By.cssSelector("#coverings >tbody >tr >td >select[name=\"coverings.covering\"]"));
        customCommand.scrollIntoView(driver,coveringElements.get(coveringRow));
        coveringElements.get(coveringRow).click();
        customCommand.selectDropDownByValue(coveringElements.get(coveringRow),coveringValue);
        Thread.sleep(2000);
        getSleeveTube.click();
        submitBundle();
    }
    private void submitBundle() throws InterruptedException {
        if(!driver.findElements(By.cssSelector("#btnFotter >button[title=\"Submit\"]")).isEmpty()){
            WebElement submit = driver.findElement(By.cssSelector("#btnFotter >button[title=\"Submit\"]"));
            customCommand.scrollIntoView(driver,submit);
            customCommand.javaScriptClick(driver,submit);
        }
    }
    public BundleForm getValuesFromBundleForm(String bundleName) throws InterruptedException {
        BundleForm bundleForm = new BundleForm();
        List<InsulationParts> insulationPartsList = new ArrayList<>();
        Thread.sleep(3000);
        WebElement bundleFormElement = driver.findElement(By.cssSelector("p[rel=\"BundleWireDia\"]"));
        customCommand.waitForElementVisibility(driver,bundleFormElement);
        bundleForm.setBundleDiameter(getWireBundleDiameter());
        bundleForm.setBundleFormName(bundleName);
        List<WebElement> tableElements = driver.findElements(By.cssSelector("#coverings >tbody >tr"));
        for(WebElement element : tableElements){
            InsulationParts insulationParts = new InsulationParts();
            WebElement covering = element.findElement(By.cssSelector("select[rel=\"covering\"]"));
            customCommand.scrollIntoView(driver,covering);
            insulationParts.setCovering(customCommand.getValueByJavascriptExecutor(driver,covering));
            WebElement reference = element.findElement(By.cssSelector("input[rel=\"reference\"]"));
            customCommand.scrollIntoView(driver,reference);
            insulationParts.setReference(customCommand.getValueByJavascriptExecutor(driver,reference));
            WebElement internalDia = element.findElement(By.cssSelector("input[rel=\"internaldia\"]"));
            customCommand.scrollIntoView(driver,internalDia);
            insulationParts.setInternalDia(customCommand.getValueByJavascriptExecutor(driver,internalDia));
            WebElement outerDia = element.findElement(By.cssSelector("input[rel=\"width\"]"));
            customCommand.scrollIntoView(driver,outerDia);
            insulationParts.setOuterDia(customCommand.getValueByJavascriptExecutor(driver,outerDia));
            WebElement partNumber = element.findElement(By.cssSelector("input[rel=\"partnumber\"]"));
            customCommand.scrollIntoView(driver,partNumber);
            insulationParts.setPartNumber(customCommand.getValueByJavascriptExecutor(driver,partNumber));
            WebElement description = element.findElement(By.cssSelector("input[rel=\"partdescription\"]"));
            customCommand.scrollIntoView(driver,description);
            insulationParts.setPartDescription(customCommand.getValueByJavascriptExecutor(driver,description));
            WebElement colour = element.findElement(By.cssSelector("select[rel=\"color\"]"));
            customCommand.scrollIntoView(driver,colour);
            insulationParts.setColour(customCommand.getValueByJavascriptExecutor(driver,colour));
            insulationPartsList.add(insulationParts);
        }
        bundleForm.setInsulationPartsList(insulationPartsList);
        bundleFormData.add(bundleForm);
        submitBundle();
        return bundleForm;
    }
    public void getBundlePage(String xCoordinates , String yCoordinates) throws InterruptedException, AWTException {
        Thread.sleep(2000);
        new HarnessPage(driver).clickOnSelect();
        customCommand.movePointerAndDoubleClick(Integer.parseInt(xCoordinates),Integer.parseInt(yCoordinates));
    }
    public List<NodeIdentifier> getNodeElementFromDrawingPage() throws InterruptedException {
        List<String> nodElementList = new ArrayList<>();
        int i=0;
        if(!FlowContext.nodeIdentifierList.isEmpty())
        {
            for(NodeIdentifier item : FlowContext.nodeIdentifierList){
                nodElementList.add(item.getNodeElementId());
            }
            int listSize = FlowContext.nodeIdentifierList.size();
            i = FlowContext.nodeIdentifierList.get(listSize-1).getNodeNumber();
        }
        List<WebElement> nodeElements = driver.findElements(By.cssSelector("#layer_80 >g[class$=\"bundleGroup\"]>g>g"));
        for( WebElement element : nodeElements){
            customCommand.waitForElementVisibility(driver,element);
            List<WebElement> bundleWebElement = driver.findElements(By.cssSelector("g[class$=\"bundleGroup\"]>g>g"));
            for(WebElement bundleElement : bundleWebElement){
                if(bundleElement.findElements(By.cssSelector("rect[etype=\"connector\"]")).isEmpty()){
                    if(!nodElementList.contains(bundleElement.getAttribute("id"))){
                        if(!bundleElement.getAttribute("id").isEmpty() && ! StringUtils.isBlank(bundleElement.getAttribute("id")))
                        {
                            FlowContext.nodeIdentifierList.add( new NodeIdentifier(i+1,bundleElement.getAttribute("id")));
                            nodElementList.add(bundleElement.getAttribute("id"));
                            i++;
                        }

                    }
                }

            }
        }
    return  FlowContext.nodeIdentifierList;
    }

    public void addCoveringRow(){
        WebElement addInsulation = driver.findElement(By.cssSelector("button[name=\"coverings.addrow\"]"));
        addInsulation.click();
    }

    public Double getCoveringTypeReference(List<BundleForm> bundleFormList , String coveringType){
        Double referenceValue = 0.0;
        for(BundleForm item : FlowContext.bundleFormData){
            List<InsulationParts> insulationPartsList =  item.getInsulationPartsList();
            for(InsulationParts iItem : insulationPartsList){
                String coveringTypeValue = iItem.getCovering();
                if(coveringTypeValue.equalsIgnoreCase(coveringType)){
                    String referenceValueFromForm = iItem.getReference().replace("mm","").trim();
                    referenceValue = Double.valueOf(referenceValueFromForm);
                    break;
                }

            }
        }
        return  referenceValue;
    }

    public Double getBundleDiameter(List<BundleForm> bundleFormList , String coveringType){
        Double bundleDiameter = 0.0;
        for(BundleForm item : FlowContext.bundleFormData){
            List<InsulationParts> insulationPartsList =  item.getInsulationPartsList();
            for(InsulationParts iItem : insulationPartsList){
                String coveringTypeValue = iItem.getCovering();
                if(coveringTypeValue.equalsIgnoreCase(coveringType)){
                    bundleDiameter = Double.valueOf(item.getBundleDiameter());
                    break;
                }
            }
        }
        return  bundleDiameter;
    }


    public HarnessBundleDisplay getBundleHarnessFormData(List<HarnessBundleDisplay> bundleDisplayList , String coveringType){
        HarnessBundleDisplay bundleDisplay = null;
        for(HarnessBundleDisplay item : bundleDisplayList){
            if(item.getCoveringTypes().equalsIgnoreCase(coveringType)){
                bundleDisplay = item;
                break;
            }
        }
        return  bundleDisplay;
    }


    public List<NodeIdentifier> getFurtherNodeElementFromDrawingPage(List<NodeIdentifier> nodeIdentifierList){
        List<String> nodeElementList = nodeIdentifierList.stream().map(x->x.getNodeElementId()).collect(toList());
        List<Integer> nodeNumberList = nodeIdentifierList.stream().map(x->x.getNodeNumber()).collect(toList());
        Integer max = nodeNumberList
                .stream()
                .mapToInt(v -> v)
                .max().orElseThrow(NoSuchElementException::new);
        List<WebElement> nodeElements = driver.findElements(By.cssSelector("#layer_80 >g[class$=\"bundleGroup\"]>g>g"));
        for( WebElement element : nodeElements){
            customCommand.waitForElementVisibility(driver,element);
            List<WebElement> bundleWebElement = driver.findElements(By.cssSelector("g[class$=\"bundleGroup\"]>g>g"));
            for(WebElement bElement : bundleWebElement){
                if(driver.findElements(By.cssSelector("rect[etype=\"connector\"]")).isEmpty()){
                    if(!nodeElementList.contains(bElement.getAttribute("id"))){
                        max ++;
                        nodeIdentifierList.add( new NodeIdentifier(max,bElement.getAttribute("id")));
                        nodeElementList.add(bElement.getAttribute("id"));
                    }

                }
            }
        }
        FlowContext.nodeIdentifierList = nodeIdentifierList;
    return  nodeIdentifierList;

    }
}
