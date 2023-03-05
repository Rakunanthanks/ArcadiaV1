package arcadia.pages;

import arcadia.context.FlowContext;
import arcadia.domainobjects.BundleForm;
import arcadia.domainobjects.HarnessBundleDisplay;
import arcadia.domainobjects.InsulationParts;
import arcadia.domainobjects.NodeIdentifier;
import arcadia.utils.SeleniumCustomCommand;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.util.ArrayList;
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

    @FindBy(css = "input[name=\"setvalue\"]") private WebElement inputSetLength;
    @FindBy(css = "input[name=\"bom.name\"]") private WebElement inputBundlePartName;
    @FindBy(css = "div#coveringSearchContainer") private WebElement windowSearchCovering;
    @FindBy(css = "input#previewPieceID") private WebElement inputPreviewPieceId;
    @FindBy(xpath = "//div[@title='Draw Select']") private  WebElement drawSelectPointer;
    @FindBy(css = "select[name='coverings.covering']") private WebElement selectCoveringInsulationPartNumbers;
    @FindBy(css = "input[name='coverings.partnumber']") private WebElement inputCoveringPartNumber;
    @FindBy(css = "input[name='coverings.sAddon']") private WebElement inputCoveringSAddOn;
    @FindBy(css = "input[name='coverings.pieceid']") private WebElement inputCoveringPieceId;
    @FindBy(css = "input#addonlength") private WebElement inputAddOnLength;
    @FindBy(xpath = "//input[@id=\"addonlength\"]/..//following-sibling::div//span[text()=\"OK\"]") private WebElement buttonSubmitAddOnLength;

    @FindBy(css = "form#DynamicForm button[title=\"Cancel\"]") private WebElement buttonCancelBundleDetailsForm;
    String tableSearchCoveringRows = "table#tblSleeveTubePartNoList>tbody>tr";

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

    public List<WebElement> getBundleElementById(String bundleId) throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> ele = driver.findElements(By.xpath("//*[name()='g' and @id='"+bundleId+"']"));
        Thread.sleep(5000);
        return ele;
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
        String id=FlowContext.nodeIdentifierList.get(0).getNodeElementId();
        new HarnessPage(driver).getBundleContextMenu(id);
        new HarnessPage(driver).performOperation("Inspect",id);
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

    public void openBundle(String bundleId) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver,drawSelectPointer);
        Thread.sleep(2000);
        WebElement ele = getBundleElementById(bundleId).get(0);
        customCommand.waitForElementVisibility(driver,ele);
        customCommand.doubleClick(driver,ele);
        Thread.sleep(2000);
    }

    public void enterValueForBundleSetLength(String bundleLength) throws AWTException, InterruptedException {
        inputSetLength.click();
        customCommand.enterText(inputSetLength,bundleLength);
        customCommand.simulateKeyEnter();
        Thread.sleep(3000);
    }

    public void verifyBundleLength(String expectedLength) {
        List<WebElement> ele = driver.findElements(By.xpath("//*[name()='g' and @id='layer_85']//*[name()='g' and @class='DG5 bundleGroup']/*[name()='g']/*[name()='text' and contains(text(),'"+expectedLength+"')]"));
        Assert.assertTrue(ele.size()==1,"Expected bundle length is not displayed");
    }

    public void verifyBundleDoNotExists(String bundleid) throws InterruptedException {
        Assert.assertTrue(getBundleElementById(bundleid).size()==0, "Bundle exists on the drawing page");
    }

    public void verifyBundleDetailsWindowOpened() {
        customCommand.waitForElementVisibility(driver,inputBundlePartName);
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id=\"DynamicForm\"]//h1[text()=\"Bundle\"]")).isDisplayed(),"Bundle details form is not displayed");
        Assert.assertTrue(inputBundlePartName.isDisplayed(),"Inputfield to enter bunder part name is not displayed");

    }

    public void verifySearchCoveringWindowOpened() {
        Assert.assertTrue(windowSearchCovering.isDisplayed(),"Window to search covering is not displayed");
    }

    public void enterPieceId(String pieceId) {
        customCommand.clearAndEnterText(inputPreviewPieceId,pieceId);
    }

    public String addCoveringAndGetPartNumber() throws InterruptedException {
        List<WebElement> searchCoveringRows = driver.findElements(By.cssSelector(tableSearchCoveringRows));
        Assert.assertNotEquals(searchCoveringRows.size(),0,"No rows are present in search covering table");
        String partNumberOfFirstRow = searchCoveringRows.get(0).findElement(By.cssSelector("td")).getText();
        customCommand.doubleClick(driver,searchCoveringRows.get(0));
        Thread.sleep(4000);
        return partNumberOfFirstRow;
    }

    public void verifyCoveringPartNumber(String partNumber) throws InterruptedException {
        customCommand.scrollIntoView(driver,selectCoveringInsulationPartNumbers);
        customCommand.scrollIntoView(driver,inputCoveringPartNumber);
        Assert.assertEquals(inputCoveringPartNumber.getAttribute("value"),partNumber);
    }

    public void verifyCoveringPartNumberDisplayedOnBundle(String partNumber) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElements(By.cssSelector("a[data-partnumber='"+partNumber+"']")).size()==1,"PartNumber for the covering is not displayed on bundle");
    }

    public void enterAndSubmitAddOn(String addOnLength) throws InterruptedException {
        customCommand.waitForElementVisibility(driver,inputAddOnLength);
        customCommand.clearAndEnterText(inputAddOnLength,addOnLength);
        buttonSubmitAddOnLength.click();
        Thread.sleep(3000);
    }

    public void verifyAddOnInCovering(String addOnValue) throws InterruptedException {
        customCommand.scrollIntoView(driver,selectCoveringInsulationPartNumbers);
        customCommand.scrollIntoView(driver,inputCoveringSAddOn);
        Assert.assertEquals(inputCoveringSAddOn.getAttribute("value").replace("\"","").replace("mm",""),addOnValue,"Value of AddOn displayed in covering is not as expected");
    }

    public void verifyCoveringPieceId(String pieceId) throws InterruptedException {
        customCommand.scrollIntoView(driver,selectCoveringInsulationPartNumbers);
        customCommand.scrollIntoView(driver,inputCoveringPieceId);
        Assert.assertEquals(inputCoveringPieceId.getAttribute("value"),pieceId);
    }

    public void verifyBundleCanBeBended(String nodeId) throws InterruptedException {
        WebElement nodeElement;
        customCommand.waitForElementToBeClickable(driver,driver.findElement(By.xpath("//*[name()='g' and @id='layer_80']//*[name()='g' and contains(@class,'bundleGroup')]//*[name()='g' and @id='"+nodeId+"']")));
        nodeElement = driver.findElement(By.xpath("//*[name()='g' and @id='layer_80']//*[name()='g' and contains(@class,'bundleGroup')]//*[name()='g' and @id='"+nodeId+"']"));
        int xNodeCoordinateBeforeBundleBended = nodeElement.getLocation().getX();
        System.out.println("X Coordinate before bundle bend is : " + xNodeCoordinateBeforeBundleBended);
        int yNodeCoordinateBeforeBundleBended = nodeElement.getLocation().getY();
        System.out.println("Y Coordinate before bundle bend is : " + yNodeCoordinateBeforeBundleBended);
        Actions actions = new Actions(driver);
        actions.moveToElement(nodeElement).click().perform();
        Thread.sleep(2000);
//        actions.moveByOffset(xNodeCoordinateBeforeBundleBended+150,yNodeCoordinateBeforeBundleBended+200).click().perform();
        actions.moveByOffset(167,223).click().perform();
        Thread.sleep(2000);
        nodeElement = driver.findElement(By.xpath("//*[name()='g' and @id='layer_80']//*[name()='g' and contains(@class,'bundleGroup')]//*[name()='g' and @id='"+nodeId+"']"));
        int xNodeCoordinateAfterBundleBended = nodeElement.getLocation().getX();
        System.out.println("X Coordinate after bundle bend is : " + xNodeCoordinateAfterBundleBended);
        int yNodeCoordinateAfterBundleBended = nodeElement.getLocation().getY();
        System.out.println("Y Coordinate after bundle bend is : " + yNodeCoordinateAfterBundleBended);
        Assert.assertNotEquals(xNodeCoordinateAfterBundleBended,xNodeCoordinateBeforeBundleBended,"X-Coordinate of node is still same even after the bundle has been bended");
        Assert.assertNotEquals(yNodeCoordinateAfterBundleBended,yNodeCoordinateBeforeBundleBended,"Y-Coordinate of node is still same even after the bundle has been bended");
    }

    public void verifyBundleCanBeRotated(String nodeId) throws InterruptedException {
        WebElement nodeElement;
        customCommand.waitForElementToBeClickable(driver,driver.findElement(By.xpath("//*[name()='g' and @id='layer_80']//*[name()='g' and contains(@class,'bundleGroup')]//*[name()='g' and @id='"+nodeId+"']")));
        nodeElement = driver.findElement(By.xpath("//*[name()='g' and @id='layer_80']//*[name()='g' and contains(@class,'bundleGroup')]//*[name()='g' and @id='"+nodeId+"']"));
        int xNodeCoordinateBeforeBundleRotated = nodeElement.getLocation().getX();
        System.out.println("X Coordinate before bundle rotated is : " + xNodeCoordinateBeforeBundleRotated);
        int yNodeCoordinateBeforeBundleRotated = nodeElement.getLocation().getY();
        System.out.println("Y Coordinate before bundle rotated is : " + yNodeCoordinateBeforeBundleRotated);
        Actions actions = new Actions(driver);
        actions.moveByOffset(167,223).click().perform();
        Thread.sleep(2000);
        nodeElement = driver.findElement(By.xpath("//*[name()='g' and @id='layer_80']//*[name()='g' and contains(@class,'bundleGroup')]//*[name()='g' and @id='"+nodeId+"']"));
        int xNodeCoordinateAfterBundleRotated = nodeElement.getLocation().getX();
        System.out.println("X Coordinate after bundle rotated is : " + xNodeCoordinateAfterBundleRotated);
        int yNodeCoordinateAfterBundleRotated = nodeElement.getLocation().getY();
        System.out.println("Y Coordinate after bundle rotated is : " + yNodeCoordinateAfterBundleRotated);
        Assert.assertNotEquals(xNodeCoordinateAfterBundleRotated,xNodeCoordinateBeforeBundleRotated,"X-Coordinate of node is still same even after the bundle has been rotated");
        Assert.assertNotEquals(yNodeCoordinateAfterBundleRotated,yNodeCoordinateBeforeBundleRotated,"Y-Coordinate of node is still same even after the bundle has been rotated");
    }

    public void closeBundleDetailsWindow() throws InterruptedException {
        customCommand.javaScriptClick(driver,buttonCancelBundleDetailsForm);
    }
}
