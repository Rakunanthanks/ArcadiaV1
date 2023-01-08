package arcadia.stepdefinations;

import arcadia.context.FlowContext;
import arcadia.context.TestContext;
import arcadia.domainobjects.*;
import arcadia.pages.*;
import arcadia.utils.ConversionUtil;
import arcadia.utils.FormulaCalculator;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import one.util.streamex.StreamEx;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import static java.util.stream.Collectors.toList;

import static arcadia.context.FlowContext.defaultLineFont;

public class BundleStepDefinitions {
    private  BundlePage bundlePage;
    private  HarnessPage harnessPage;
    private SleeveTubeComponentDB sleeveTubeComponentDB;
    private final TestContext context;
    ConversionUtil conversionUtil  = new ConversionUtil();
    public BundleStepDefinitions(TestContext context){
        this.context = context;
        bundlePage = PageFactoryManager.getBundlePage(context.driver);
        harnessPage = PageFactoryManager.getDrawingPage(context.driver);
        sleeveTubeComponentDB = PageFactoryManager.getSleeveTubeComponentDB(context.driver);
    }

    @Given("bundle is drawn successfully")
    public void bundle_is_drawn_successfully() throws InterruptedException, AWTException {
//        harnessPage.waitForDrawingPage();
//        bundlePage.drawBundle();
//        harnessPage = PageFactoryManager.getDrawingPage(context.driver);
//        context.bundleNodes = bundlePage.getBundleNodeElementId();
    }

    @Then("Check bundle diameter for {string} and bundleform {string}")
    public void check_bundle_diameter_for_and_bundleform(String connectorName, String bundleFormName) {
        for(Wire wItem : FlowContext.wirePropertiesList){
            if(wItem.getConnectorName().equalsIgnoreCase(connectorName)){
                List<WireProperties> wireProperties = wItem.getWirePropertiesList();
                Double expectedDiameter = new FormulaCalculator().getBundleDiameter(wireProperties.stream().map(x->x.getWireOuterDiameter()).collect(toList()));
                Double actualDiameter = Double.valueOf(FlowContext.bundleFormData.stream().filter(x->x.getBundleFormName().equalsIgnoreCase(bundleFormName)).map(x->x.getBundleDiameter()).findFirst().get());
                ExtentCucumberAdapter.addTestStepLog(String.format("Bundleform name is %s", bundleFormName));
                Assert.assertEquals(actualDiameter,expectedDiameter,bundleFormName);
            }

        }
    }

    @Then("Check bundle diameter for {string}")
    public void check_bundle_diameter_for(String connectorName) {
        for(Wire wItem : FlowContext.wirePropertiesList){
            if(wItem.getConnectorName().equalsIgnoreCase(connectorName)){
                List<WireProperties> wireProperties = wItem.getWirePropertiesList();
                new FormulaCalculator().getBundleDiameter(wireProperties.stream().map(x->x.getWireOuterDiameter()).collect(toList()));

            }

        }
    }

    @Then("check reference value for covering type {string}")
    public void check_reference_value_for_covering_type(String coveringType) {
        Double actualReferenceValue = new BundlePage(context.driver).getCoveringTypeReference(FlowContext.bundleFormData,coveringType);
        HarnessBundleDisplay displayValue = new BundlePage(context.driver).getBundleHarnessFormData(FlowContext.defaultBundleDisplay,coveringType);
        Double expectedReferenceValue = new FormulaCalculator().getReference(displayValue.getDiameterScales(),displayValue.getDiameterAddon(),new BundlePage(context.driver).getBundleDiameter(FlowContext.bundleFormData,coveringType));
        ExtentCucumberAdapter.addTestStepLog(String.format("Covering type is %s", coveringType));
        Assert.assertEquals(actualReferenceValue,expectedReferenceValue);
    }



    @Then("Check wire bundle diameter is displayed")
    public void check_wire_bundle_diameter_is_displayed() throws InterruptedException, AWTException, IOException {
//        TestMapper mapper = conversionUtil.getTestMapperConfig(context.testIdentifier);
//        Bundle bundleGroup = mapper.getBundle();
//        bundlePage.getBundlePage(bundleGroup.getxCoordinates(),bundleGroup.getyCoordinates());
//        bundlePage = PageFactoryManager.getBundlePage(context.driver);
//        bundlePage.waitForBundleForm();
//        Double bundleDiameter = Double.valueOf(bundlePage.getWireBundleDiameter());
//        FormulaCalculator calculator = new FormulaCalculator();
//        //Double calculatedBundleDiameter = calculator.getBundleDiameter(context.wireProperties.getWireOuterDiameter());
//        //Assert.assertEquals(bundleDiameter,calculatedBundleDiameter);
//        context.bundleForm = bundlePage.chooseCovering(bundleGroup.getCovering());
    }

    @Then("Check covering value is as per componentDB")
    public void check_covering_value_is_as_per_component_db() throws InterruptedException, IOException {
        SoftAssert softAssertion= new SoftAssert();
        new SleeveTubeComponentDB(context.driver).launchSleeveTube();
        for(BundleForm bItem : FlowContext.bundleFormData){
            List<InsulationParts> insulationPartsList = bItem.getInsulationPartsList();
            List<ComponentDB> sleeveTubeData = null;
            for(InsulationParts inItem : insulationPartsList){
                String coveringType = inItem.getCovering().replace("_"," ");
                String filter = coveringType.substring(0, 1).toUpperCase() + coveringType.substring(1);
                ComponentDB expectedData = null;
                if(filter.equalsIgnoreCase("Conduit slit")){
                    defaultLineFont = "Conduit slit";
                    String colour = null;
                    if(FlowContext.globalSleeveTubeUpdate){
                        Double internalDiaStartRange = Double.valueOf(inItem.getInternalDia().replace("mm","").trim());
                        Double internalDiaEndRange = Double.valueOf(internalDiaStartRange+6);
                        String internalDiaRange = String.valueOf(internalDiaStartRange)+"-"+String.valueOf(internalDiaEndRange);
                        new SleeveTubeComponentDB(context.driver).filterComponentDB(internalDiaRange,filter);
                        sleeveTubeData= new SleeveTubeComponentDB(context.driver).getSleeveTubeData();
                        colour = FlowContext.globalSleeve.getColour();
                        expectedData = new SleeveTubeComponentDB(context.driver).sortByIntDiaFindFirst(sleeveTubeData.stream().filter(x->x.getColour().equals(FlowContext.globalSleeve.getColour()) && x.getMaterial().equalsIgnoreCase(FlowContext.globalSleeve.getMaterial())).collect(toList()));

                    }
                    if(!FlowContext.globalSleeveTubeUpdate) {
                        Double internalDiaStartRange = Double.valueOf(inItem.getInternalDia().replace("mm", "").trim());
                        Double internalDiaEndRange = Double.valueOf(internalDiaStartRange + 6);
                        String internalDiaRange = String.valueOf(internalDiaStartRange) + "-" + String.valueOf(internalDiaEndRange);
                        new SleeveTubeComponentDB(context.driver).filterComponentDB(internalDiaRange, filter);
                        sleeveTubeData = new SleeveTubeComponentDB(context.driver).getSleeveTubeData();
                        expectedData = new SleeveTubeComponentDB(context.driver).sortByIntDiaFindFirst(sleeveTubeData.stream().filter(x -> x.getColour().equals(inItem.getColour())).collect(toList()));

                    }
                    ExtentCucumberAdapter.addTestStepLog("Covering Type "+ filter + " ComponentDB  - PartNumber:"+expectedData.getPartNumber() + " Description:"+expectedData.getDescription() + " internalDia:"+expectedData.getInternalDiameter());
                    ExtentCucumberAdapter.addTestStepLog("Covering Type "+ filter + " BundleForm -" +   bItem.getBundleFormName()+  "- PartNumber:"+inItem.getPartNumber() + " Description:"+inItem.getPartDescription() + " internalDia:"+inItem.getInternalDia());
                    softAssertion.assertEquals(inItem.getPartNumber(),expectedData.getPartNumber(),inItem.getPartNumber() + " " + coveringType);
                    softAssertion.assertEquals(inItem.getPartDescription(),expectedData.getDescription(),inItem.getPartDescription()+ " " + coveringType);
                    softAssertion.assertEquals(Double.valueOf(inItem.getInternalDia().replace("mm","").trim()),expectedData.getInternalDiameter(),inItem.getInternalDia()+ " " + coveringType);
                }
                if(filter.equalsIgnoreCase("Braid tight")){
                    defaultLineFont = "Braid tight";
                    String colour = null;
                    if(FlowContext.globalSleeveTubeUpdate){
                        Double internalDiaStartRange = Double.valueOf(inItem.getInternalDia().replace("mm","").trim());
                        Double internalDiaEndRange = Double.valueOf(internalDiaStartRange+6);
                        String internalDiaRange = String.valueOf(internalDiaStartRange)+"-"+String.valueOf(internalDiaEndRange);
                        new SleeveTubeComponentDB(context.driver).filterComponentDB(internalDiaRange,filter);
                        sleeveTubeData= new SleeveTubeComponentDB(context.driver).getSleeveTubeData();
                        colour = FlowContext.globalSleeve.getColour();
                        expectedData = new SleeveTubeComponentDB(context.driver).sortByIntDiaFindFirst(sleeveTubeData.stream().filter(x->x.getColour().equals(FlowContext.globalSleeve.getColour()) && x.getMaterial().equalsIgnoreCase(FlowContext.globalSleeve.getMaterial())).collect(toList()));

                    }
                    if(!FlowContext.globalSleeveTubeUpdate) {
                        Double internalDiaStartRange = Double.valueOf(inItem.getInternalDia().replace("mm", "").trim());
                        Double internalDiaEndRange = Double.valueOf(internalDiaStartRange + 6);
                        String internalDiaRange = String.valueOf(internalDiaStartRange) + "-" + String.valueOf(internalDiaEndRange);
                        new SleeveTubeComponentDB(context.driver).filterComponentDB(internalDiaRange, filter);
                        sleeveTubeData = new SleeveTubeComponentDB(context.driver).getSleeveTubeData();
                        expectedData = new SleeveTubeComponentDB(context.driver).sortByIntDiaFindFirst(sleeveTubeData.stream().filter(x -> x.getColour().equals(inItem.getColour())).collect(toList()));

                    }
                    ExtentCucumberAdapter.addTestStepLog("Covering Type "+ filter + " ComponentDB  - PartNumber:"+expectedData.getPartNumber() + " Description:"+expectedData.getDescription() + " internalDia:"+expectedData.getInternalDiameter());
                    ExtentCucumberAdapter.addTestStepLog("Covering Type "+ filter + " BundleForm -" +   bItem.getBundleFormName()+  "- PartNumber:"+inItem.getPartNumber() + " Description:"+inItem.getPartDescription() + " internalDia:"+inItem.getInternalDia());
                    softAssertion.assertEquals(inItem.getPartNumber(),expectedData.getPartNumber(),inItem.getPartNumber() + " " + coveringType);
                    softAssertion.assertEquals(inItem.getPartDescription(),expectedData.getDescription(),inItem.getPartDescription()+ " " + coveringType);
                    softAssertion.assertEquals(Double.valueOf(inItem.getInternalDia().replace("mm","").trim()),expectedData.getInternalDiameter(),inItem.getInternalDia()+ " " + coveringType);
                }
                if(filter.equalsIgnoreCase("Conduit closed")){
                    defaultLineFont = "Conduit closed";
                    String colour = null;
                    if(FlowContext.globalSleeveTubeUpdate){
                        Double internalDiaStartRange = Double.valueOf(inItem.getInternalDia().replace("mm","").trim());
                        Double internalDiaEndRange = Double.valueOf(internalDiaStartRange+6);
                        String internalDiaRange = String.valueOf(internalDiaStartRange)+"-"+String.valueOf(internalDiaEndRange);
                        new SleeveTubeComponentDB(context.driver).filterComponentDB(internalDiaRange,filter);
                        sleeveTubeData= new SleeveTubeComponentDB(context.driver).getSleeveTubeData();
                        colour = FlowContext.globalSleeve.getColour();
                        expectedData = new SleeveTubeComponentDB(context.driver).sortByIntDiaFindFirst(sleeveTubeData.stream().filter(x->x.getColour().equals(FlowContext.globalSleeve.getColour()) && x.getMaterial().equalsIgnoreCase(FlowContext.globalSleeve.getMaterial())).collect(toList()));

                    }
                    if(!FlowContext.globalSleeveTubeUpdate) {
                        Double internalDiaStartRange = Double.valueOf(inItem.getInternalDia().replace("mm", "").trim());
                        Double internalDiaEndRange = Double.valueOf(internalDiaStartRange + 6);
                        String internalDiaRange = String.valueOf(internalDiaStartRange) + "-" + String.valueOf(internalDiaEndRange);
                        new SleeveTubeComponentDB(context.driver).filterComponentDB(internalDiaRange, filter);
                        sleeveTubeData = new SleeveTubeComponentDB(context.driver).getSleeveTubeData();
                        expectedData = new SleeveTubeComponentDB(context.driver).sortByIntDiaFindFirst(sleeveTubeData.stream().filter(x -> x.getColour().equals(inItem.getColour())).collect(toList()));

                    }
                    ExtentCucumberAdapter.addTestStepLog("Covering Type "+ filter + " ComponentDB  - PartNumber:"+expectedData.getPartNumber() + " Description:"+expectedData.getDescription() + " internalDia:"+expectedData.getInternalDiameter());
                    ExtentCucumberAdapter.addTestStepLog("Covering Type "+ filter + " BundleForm -" +   bItem.getBundleFormName()+  "- PartNumber:"+inItem.getPartNumber() + " Description:"+inItem.getPartDescription() + " internalDia:"+inItem.getInternalDia());
                    softAssertion.assertEquals(inItem.getPartNumber(),expectedData.getPartNumber(),inItem.getPartNumber() + " " + coveringType);
                    softAssertion.assertEquals(inItem.getPartDescription(),expectedData.getDescription(),inItem.getPartDescription()+ " " + coveringType);
                    softAssertion.assertEquals(Double.valueOf(inItem.getInternalDia().replace("mm","").trim()),expectedData.getInternalDiameter(),inItem.getInternalDia()+ " " + coveringType);
                }
                if(filter.equalsIgnoreCase("PVC tube")){
                    defaultLineFont = "PVC tube";
                    String colour = null;
                    if(FlowContext.globalSleeveTubeUpdate){
                        Double internalDiaStartRange = Double.valueOf(inItem.getInternalDia().replace("mm","").trim());
                        Double internalDiaEndRange = Double.valueOf(internalDiaStartRange+6);
                        String internalDiaRange = String.valueOf(internalDiaStartRange)+"-"+String.valueOf(internalDiaEndRange);
                        new SleeveTubeComponentDB(context.driver).filterComponentDB(internalDiaRange,"PVC tube");
                        sleeveTubeData= new SleeveTubeComponentDB(context.driver).getSleeveTubeData();
                        colour = FlowContext.globalSleeve.getColour();
                        expectedData = new SleeveTubeComponentDB(context.driver).sortByIntDiaFindFirst(sleeveTubeData.stream().filter(x->x.getColour().equals(FlowContext.globalSleeve.getColour()) && x.getMaterial().equalsIgnoreCase(FlowContext.globalSleeve.getMaterial())).collect(toList()));

                    }
                    if(!FlowContext.globalSleeveTubeUpdate) {
                        Double internalDiaStartRange = Double.valueOf(inItem.getInternalDia().replace("mm", "").trim());
                        Double internalDiaEndRange = Double.valueOf(internalDiaStartRange + 6);
                        String internalDiaRange = String.valueOf(internalDiaStartRange) + "-" + String.valueOf(internalDiaEndRange);
                        new SleeveTubeComponentDB(context.driver).filterComponentDB(internalDiaRange, "PVC tube");
                        sleeveTubeData = new SleeveTubeComponentDB(context.driver).getSleeveTubeData();
                        expectedData = new SleeveTubeComponentDB(context.driver).sortByIntDiaFindFirst(sleeveTubeData.stream().filter(x -> x.getColour().equals(inItem.getColour())).collect(toList()));

                    }
                    ExtentCucumberAdapter.addTestStepLog("Covering Type "+ filter + " ComponentDB  - PartNumber:"+expectedData.getPartNumber() + " Description:"+expectedData.getDescription() + " internalDia:"+expectedData.getInternalDiameter());
                    ExtentCucumberAdapter.addTestStepLog("Covering Type "+ filter + " BundleForm -" +   bItem.getBundleFormName()+  "- PartNumber:"+inItem.getPartNumber() + " Description:"+inItem.getPartDescription() + " internalDia:"+inItem.getInternalDia());
                    softAssertion.assertEquals(inItem.getPartNumber(),expectedData.getPartNumber(),inItem.getPartNumber() + " " + coveringType);
                    softAssertion.assertEquals(inItem.getPartDescription(),expectedData.getDescription(),inItem.getPartDescription()+ " " + coveringType);
                    softAssertion.assertEquals(Double.valueOf(inItem.getInternalDia().replace("mm","").trim()),expectedData.getInternalDiameter(),inItem.getInternalDia()+ " " + coveringType);
                }
                if(filter.equalsIgnoreCase("Shrinkable tube")){
                    String colour = null;
                    if(FlowContext.globalSleeveTubeUpdate){
                        Double referenceValue = Double.valueOf(inItem.getReference().replace("mm","").trim());
                        Double suppliedDiameterStartRange = Double.valueOf(referenceValue+0.1);
                        Double suppliedDiameterEndRange = Double.valueOf(referenceValue+50);
                        String suppliedDiaRange = String.valueOf(suppliedDiameterStartRange)+"-"+String.valueOf(suppliedDiameterEndRange);
                        new SleeveTubeComponentDB(context.driver).filterComponentDBBasedOnSuppliedDia(suppliedDiaRange,defaultLineFont,"Shrinkable Tube");
                        sleeveTubeData= new SleeveTubeComponentDB(context.driver).getSleeveTubeData();
                        colour = FlowContext.globalSleeve.getColour();
                        expectedData = new SleeveTubeComponentDB(context.driver).sortByExtDiaFindFirst(sleeveTubeData.stream().filter(x->x.getColour().equals(FlowContext.globalSleeve.getColour()) && x.getMaterial().equalsIgnoreCase(FlowContext.globalSleeve.getMaterial())).collect(toList()));

                    }
                    if(!FlowContext.globalSleeveTubeUpdate) {
                        Double referenceValue = Double.valueOf(inItem.getReference().replace("mm","").trim());
                        Double suppliedDiameterStartRange = Double.valueOf(referenceValue+0.1);
                        Double suppliedDiameterEndRange = Double.valueOf(referenceValue+50);
                        String suppliedDiaRange = String.valueOf(suppliedDiameterStartRange)+"-"+String.valueOf(suppliedDiameterEndRange);
                        new SleeveTubeComponentDB(context.driver).filterComponentDBBasedOnSuppliedDia(suppliedDiaRange,defaultLineFont,"Shrinkable Tube");
                        sleeveTubeData = new SleeveTubeComponentDB(context.driver).getSleeveTubeData();
                        expectedData = new SleeveTubeComponentDB(context.driver).sortByExtDiaFindFirst(sleeveTubeData.stream().filter(x -> x.getColour().equals(inItem.getColour())).collect(toList()));
                    }
                    ExtentCucumberAdapter.addTestStepLog("Covering Type "+ filter + " ComponentDB  - PartNumber:"+expectedData.getPartNumber() + " Description:"+expectedData.getDescription() + "externalDia:"+expectedData.getExternalDiameter());
                    ExtentCucumberAdapter.addTestStepLog("Covering Type "+ filter + " BundleForm -" +   bItem.getBundleFormName()+  "- PartNumber:"+inItem.getPartNumber() + " Description:"+inItem.getPartDescription() + " externalDia:"+inItem.getOuterDia());
                    softAssertion.assertEquals(inItem.getPartNumber(),expectedData.getPartNumber(),inItem.getPartNumber() + " " + coveringType);
                    softAssertion.assertEquals(inItem.getPartDescription(),expectedData.getDescription(),inItem.getPartDescription()+ " " + coveringType);
                    softAssertion.assertEquals(Double.valueOf(inItem.getInternalDia().replace("mm","").trim()),expectedData.getInternalDiameter(),inItem.getInternalDia()+ " " + coveringType);
                }
                context.driver.navigate().refresh();
            }
        }
        context.driver.switchTo().defaultContent();
        softAssertion.assertAll();
    }
    @Then("colour displayed for material is as per componentDB")
    public void colour_displayed_for_material_is_as_per() throws InterruptedException, AWTException {
        SoftAssert softAssert = new SoftAssert();
        new SleeveTubeComponentDB(context.driver).launchSleeveTube();
        List<ComponentDB> dbData = new SleeveTubeComponentDB(context.driver).getSleeveTubeData();
        context.driver.switchTo().window(FlowContext.mainWindowHandle);
        new HarnessPage(context.driver).clickOnGlobalUpdateSleeve();
        List<String> coveringTypeList = new GlobalUpdateSleeve(context.driver).getAllCoveringType();
        for(String cItem : coveringTypeList){
            List<String> material =new GlobalUpdateSleeve(context.driver).getMaterialFromGlobalUpdateSleeve(cItem,"quickstart");
            for(String mItem : material){
                if(mItem!=null && !StringUtils.isBlank(mItem) && !mItem.isEmpty())
                {
                    List<String> colourList = new GlobalUpdateSleeve(context.driver).getColour("quickstart",cItem,mItem);
                    List<String> newColourList = colourList.stream().filter(item-> !item.isEmpty()).collect(toList());
                    String optionValue = cItem.replace("_"," ");
                    String modifiedValue = optionValue.substring(0, 1).toUpperCase() + optionValue.substring(1);
                    List<ComponentDB> filteredData = dbData.stream().filter(x->x.getDefaultLineFont().equalsIgnoreCase(modifiedValue) && x.getMaterial().equalsIgnoreCase(mItem)).collect(toList());
                    List<String> dbColourList = StreamEx.of(filteredData).distinct(ComponentDB::getColour).map(ComponentDB::getColour).toList();
                    List<String> newDbColourList = dbColourList.stream().filter(item-> !item.isEmpty()).collect(toList());
                    boolean isEqual = CollectionUtils.isEqualCollection(newColourList, newDbColourList);
                    if(!isEqual){
                        ExtentCucumberAdapter.addTestStepLog("Covering Type "+ cItem +" material -"+mItem + " -ComponentDB  - Colour: "+ StringUtils.join(newDbColourList, "|"));
                        ExtentCucumberAdapter.addTestStepLog("Covering Type "+ cItem + " material -"+mItem + " -Form  - Colour: "+ StringUtils.join(newColourList, "|"));
                    }
                    softAssert.assertEquals(true,isEqual,"Colour not same for covering type "+ cItem +" material " +mItem );
                }
            }
        }
        softAssert.assertAll();
    }

    @Then("material displayed for covering type is as per componentDB")
    public void material_displayed_for_covering_type_is_as_per_component_db() throws InterruptedException, AWTException {
        SoftAssert softAssert = new SoftAssert();
        new SleeveTubeComponentDB(context.driver).launchSleeveTube();
        List<ComponentDB> dbData = new SleeveTubeComponentDB(context.driver).getSleeveTubeData();
        context.driver.switchTo().window(FlowContext.mainWindowHandle);
        new HarnessPage(context.driver).clickOnGlobalUpdateSleeve();
        List<String> coveringTypeList = new GlobalUpdateSleeve(context.driver).getAllCoveringType();
        for(String cItem : coveringTypeList){
            List<String> material =new GlobalUpdateSleeve(context.driver).getMaterialFromGlobalUpdateSleeve(cItem,"quickstart");
            List<String> newMaterial =material.stream().filter(item-> !item.isEmpty()).collect(toList());
            String optionValue = cItem.replace("_"," ");
            String modifiedValue = optionValue.substring(0, 1).toUpperCase() + optionValue.substring(1);
            List<ComponentDB> filteredData = dbData.stream().filter(x->x.getDefaultLineFont()!=null && !x.getDefaultLineFont().isEmpty() && !StringUtils.isBlank(x.getDefaultLineFont()) && x.getDefaultLineFont().equalsIgnoreCase(modifiedValue)).collect(toList());
            List<String> dbMaterialList = StreamEx.of(filteredData).distinct(ComponentDB::getMaterial).map(ComponentDB::getMaterial).toList();
            List<String> newDbMaterialList =dbMaterialList.stream().filter(item-> !item.isEmpty()).collect(toList());
            boolean isEqual = CollectionUtils.isEqualCollection(newMaterial, newDbMaterialList);
            if(!isEqual){
                ExtentCucumberAdapter.addTestStepLog("Covering Type "+ cItem + " ComponentDB  - Material: "+ StringUtils.join(newDbMaterialList, "|"));
                ExtentCucumberAdapter.addTestStepLog("Covering Type "+ cItem + " Form  - Material: "+ StringUtils.join(newMaterial, "|"));
            }
            softAssert.assertEquals(true,isEqual,"Material not same for covering type "+ cItem);
        }
        softAssert.assertAll();
    }

}
