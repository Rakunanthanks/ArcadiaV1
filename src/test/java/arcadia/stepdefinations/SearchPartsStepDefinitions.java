package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.domainobjects.*;
import arcadia.mapperObjects.SearchParts;
import arcadia.mapperObjects.TestMapper;
import arcadia.pages.BundlePage;
import arcadia.pages.ComponentDB.Components.ComponentsDBPage;
import arcadia.pages.ComponentDB.Connectors.ConnectorsDBPage;
import arcadia.pages.ComponentDB.JunctionParts.JunctionPartsComponentDBPage;
import arcadia.pages.ComponentDB.Multicore.MulticoreComponentDBPage;
import arcadia.pages.ComponentDB.OtherParts.OtherPartsComponentDBPage;
import arcadia.pages.ComponentDB.Seals.SealsComponentDBPage;
import arcadia.pages.ComponentDB.Splices.SplicesComponentDBPage;
import arcadia.pages.ComponentDB.Terminals.TerminalsComponentDBPage;
import arcadia.pages.ComponentDB.Wires.WiresComponentDBPage;
import arcadia.pages.HarnessPage;
import arcadia.pages.PageFactoryManager;
import arcadia.pages.SearchPartsDatabasePage;
import arcadia.utils.ConversionUtil;
import arcadia.utils.RestAssuredUtility;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPartsStepDefinitions {
    private final BundlePage bundlePage;
    private  HarnessPage harnessPage;
    private final SearchPartsDatabasePage searchPartsDatabasePage;
    private final TestContext context;
    ConversionUtil conversionUtil = new ConversionUtil();
    public SearchPartsStepDefinitions(TestContext context){
        this.context = context;
        bundlePage = PageFactoryManager.getBundlePage(context.driver);
        harnessPage = PageFactoryManager.getDrawingPage(context.driver);
        searchPartsDatabasePage = PageFactoryManager.getPartsDatabasePage(context.driver);
    }

    @Given("Search parts populated")
    public void search_parts_populated() throws IOException, InterruptedException {
        Thread.sleep(2000);
        TestMapper mapper = conversionUtil.getTestMapperConfig(context.testIdentifier);
        SearchParts searchParts = mapper.getSearchParts();
        ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s %s", searchParts.getDescription(),searchParts.getCavityNumber()));
        searchPartsDatabasePage.findInSearchPartDatabase(searchParts.getDescription(),searchParts.getCavityNumber());
        Thread.sleep(2000);
        searchPartsDatabasePage.populateParts();
    }

    @Then("Verify user can filter {string} using {string}")
    public void userFiltersConnectorOnCreateBundle(String component, String filtertype) throws InterruptedException, AWTException, IOException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("connector", context.driver);
        List<ConnectorDB> dbData =new ConnectorsDBPage(context.driver).getConnectorsAPIData(response);
        ConnectorDB randomConnectorData = new ConnectorsDBPage(context.driver).getRandomConnectorComponent(dbData);
        List<ConnectorDB> filteredDbData = new ArrayList<>();
        searchPartsDatabasePage.selectSearchDB(System.getProperty("componentDB"));
        searchPartsDatabasePage.selectComponentType(component);
        switch (filtertype.toLowerCase()) {
            case "partnumber":
                filteredDbData = dbData.stream().filter(x -> x.getPartnumber().equals(randomConnectorData.getPartnumber())).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingPartNumber(randomConnectorData.getPartnumber());
                break;
            case "cavity":
                filteredDbData = dbData.stream().filter(x -> x.getNoofcavity().equals(randomConnectorData.getNoofcavity())).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingCavity(randomConnectorData.getNoofcavity());
                break;
            case "family":
                filteredDbData = dbData.stream().filter(x -> x.getFamily().equals(randomConnectorData.getFamily())).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingFamily(randomConnectorData.getFamily());
                break;
            case "supplier":
                filteredDbData = dbData.stream().filter(x -> x.getSupplier().equals(randomConnectorData.getSupplier())).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingSupplier(randomConnectorData.getSupplier());
                break;
            case "housinggender":
                filteredDbData = dbData.stream().filter(x -> x.getHousingGender().equals(randomConnectorData.getHousingGender())).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingHousingGender(randomConnectorData.getHousingGender());
                break;
            case "terminalgender":
                filteredDbData = dbData.stream().filter(x -> x.getGender().equals(randomConnectorData.getGender())).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingTerminalGender(randomConnectorData.getGender());
                break;
        }
        List<String> actualUniquePartList = searchPartsDatabasePage.getSearchPartsData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x -> x.getPartnumber()).collect(Collectors.toList());
        List<String> differenceFromExpectedPartNumberList = expectedPartNumberList.stream()
                .filter(element -> !actualUniquePartList.contains(element))
                .collect(Collectors.toList());
        if(differenceFromExpectedPartNumberList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with expected %s", differenceFromExpectedPartNumberList.toString()));
        }
        List<String> differenceFromActualPartNumberList = actualUniquePartList.stream()
                .filter(element -> !expectedPartNumberList.contains(element))
                .collect(Collectors.toList());
        Assert.assertEquals(actualUniquePartList.size(),expectedPartNumberList.size());
    }


    @Then("Verify user can filter splice using {string}")
    public void userFiltersSpliceOnCreateBundle(String filtertype) throws InterruptedException, AWTException, IOException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("splice", context.driver);
        List<SplicesComponentDB> dbData =new SplicesComponentDBPage(context.driver).getSpliceAPIData(response);
        SplicesComponentDB randomSpliceData = new SplicesComponentDBPage(context.driver).getRandomSpliceComponent(dbData);
        List<SplicesComponentDB> filteredDbData = new ArrayList<>();
        searchPartsDatabasePage.selectSearchDB(System.getProperty("componentDB"));
        searchPartsDatabasePage.selectComponentType("splice");
        switch (filtertype.toLowerCase()) {
            case "partnumber":
                filteredDbData = dbData.stream().filter(x -> x.getPartnumber().equals(randomSpliceData.getPartnumber())).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingPartNumber(randomSpliceData.getPartnumber());
                break;
//            case "cavity":
//                filteredDbData = dbData.stream().filter(x -> x.get().equals(randomSpliceData.getNumberOfCavities())).collect(Collectors.toList());
//                searchPartsDatabasePage.searchPartUsingCavity(randomSpliceData.getNumberOfCavities());
//                break;
            case "family":
                filteredDbData = dbData.stream().filter(x -> x.getFamily().equals(randomSpliceData.getFamily())).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingFamily(randomSpliceData.getFamily());
                break;
            case "supplier":
                filteredDbData = dbData.stream().filter(x -> x.getSupplier().equals(randomSpliceData.getSupplier())).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingSupplier(randomSpliceData.getSupplier());
                break;
//            case "housinggender":
//                filteredDbData = dbData.stream().filter(x -> x.getHousingGender().equals(randomSpliceData.getHousingGender())).collect(Collectors.toList());
//                searchPartsDatabasePage.searchPartUsingHousingGender(randomSpliceData.getHousingGender());
//                break;
//            case "terminalgender":
//                filteredDbData = dbData.stream().filter(x -> x.getTerminalGender().equals(randomSpliceData.getTerminalGender())).collect(Collectors.toList());
//                searchPartsDatabasePage.searchPartUsingTerminalGender(randomSpliceData.getTerminalGender());
//                break;
        }
        List<String> actualUniquePartList = searchPartsDatabasePage.getSearchPartsData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x -> x.getPartnumber()).collect(Collectors.toList());
        List<String> differenceFromExpectedPartNumberList = expectedPartNumberList.stream()
                .filter(element -> !actualUniquePartList.contains(element))
                .collect(Collectors.toList());
        if(differenceFromExpectedPartNumberList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with expected %s", differenceFromExpectedPartNumberList.toString()));
        }
        List<String> differenceFromActualPartNumberList = actualUniquePartList.stream()
                .filter(element -> !expectedPartNumberList.contains(element))
                .collect(Collectors.toList());
        Assert.assertEquals(actualUniquePartList.size(),expectedPartNumberList.size());
    }


    @Then("Verify user can filter {string} using {string} with value {string}")
    public void verifyUserCanFilterConnectorUsingFilterAndValue(String component, String filtertype, String filterValue) throws IOException, InterruptedException, AWTException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("connector", context.driver);
        List<ConnectorDB> dbData =new ConnectorsDBPage(context.driver).getConnectorsAPIData(response);
        List<ConnectorDB> filteredDbData = new ArrayList<>();
        searchPartsDatabasePage.selectSearchDB(System.getProperty("componentDB"));
        searchPartsDatabasePage.selectComponentType(component);
        switch (filtertype.toLowerCase()){
            case "housinggender":
                filteredDbData = dbData.stream().filter(x -> x.getHousingGender().equals(filterValue)).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingHousingGender(filterValue);
                break;
            case "terminalgender":
                filteredDbData = dbData.stream().filter(x -> x.getGender().equals(filterValue)).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingTerminalGender(filterValue);
                break;
            case "type":
                filteredDbData = dbData.stream().filter(x -> x.getTtype().equals(filterValue)).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingType(filterValue);
                break;
            case "colour":
                filteredDbData = dbData.stream().filter(x -> x.getColour().equals(filterValue)).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingColour(filterValue);
                break;
        }
        List<String> actualUniquePartList = searchPartsDatabasePage.getSearchPartsData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x -> x.getPartnumber()).collect(Collectors.toList());
        List<String> differenceFromExpectedPartNumberList = expectedPartNumberList.stream()
                .filter(element -> !actualUniquePartList.contains(element))
                .collect(Collectors.toList());
        if(differenceFromExpectedPartNumberList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with expected %s", differenceFromExpectedPartNumberList.toString()));
        }
        List<String> differenceFromActualPartNumberList = actualUniquePartList.stream()
                .filter(element -> !expectedPartNumberList.contains(element))
                .collect(Collectors.toList());
        if(differenceFromActualPartNumberList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with actual %s", differenceFromActualPartNumberList.toString()));
        }
        Assert.assertEquals(actualUniquePartList.size(),expectedPartNumberList.size());
    }

    @And("User closes the searchparts window")
    public void userClosesTheSearchpartsWindow() throws InterruptedException {
        searchPartsDatabasePage.closeSearchPartsWindow();
    }

    @Then("Verify user filters wire using {string} successfully")
    public void verifyUserFiltersWire(String filterName) throws IOException, InterruptedException, AWTException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("wire", context.driver);
        List<WiresComponentDB> dbData =new WiresComponentDBPage(context.driver).getWireAPIData(response);
        WiresComponentDB randomWireData = new WiresComponentDBPage(context.driver).getRandomWireComponent(dbData.stream().filter(x->x.getWirematerial()!="").collect(Collectors.toList()));
        List<WiresComponentDB> filteredDbData = new ArrayList<>();
        searchPartsDatabasePage.selectWireType("wire");
        switch (filterName.toLowerCase()) {
            case "partnumber":
                filteredDbData = dbData.stream().filter(x -> x.getPartnumber().equals(randomWireData.getPartnumber())).collect(Collectors.toList());
                searchPartsDatabasePage.searchWireMulticoreUsingPartNumber(randomWireData.getPartnumber());
                break;
            case "material":
                filteredDbData = dbData.stream().filter(x -> x.getWirematerial().contains(randomWireData.getWirematerial())).collect(Collectors.toList());
                searchPartsDatabasePage.searchWireMulticoreUsingMaterial(randomWireData.getWirematerial());
                break;
            case "gauge":
                filteredDbData = dbData.stream().filter(x -> x.getGauge().contains(randomWireData.getGauge())).collect(Collectors.toList());
                searchPartsDatabasePage.searchWireMulticoreUsingGauge(randomWireData.getGauge());
                break;
            case "csa":
                filteredDbData = dbData.stream().filter(x -> x.getWirecsa().equals(randomWireData.getWirecsa())).collect(Collectors.toList());
                searchPartsDatabasePage.searchWireMulticoreUsingCSA(String.valueOf(randomWireData.getWirecsa()));
                break;
            case "outerdia":
                filteredDbData = dbData.stream().filter(x -> x.getOutsidedia().equals(randomWireData.getOutsidedia())).collect(Collectors.toList());
                searchPartsDatabasePage.searchWireMulticoreUsingOuterDia(String.valueOf(randomWireData.getOutsidedia()));
                break;
            case "primarycolour":
                filteredDbData = dbData.stream().filter(x -> x.getColour().split("-")[0].equals(randomWireData.getColour().split("-")[0])).collect(Collectors.toList());
                searchPartsDatabasePage.searchWireMulticoreUsingPrimaryColour(randomWireData.getColour().split("-")[0]);
                break;

        }
        List<String> actualUniquePartList = searchPartsDatabasePage.getSearchWiresData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x -> x.getPartnumber()).collect(Collectors.toList());
        List<String> differenceFromExpectedPartNumberList = expectedPartNumberList.stream()
                .filter(element -> !actualUniquePartList.contains(element))
                .collect(Collectors.toList());
        if(differenceFromExpectedPartNumberList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with expected %s", differenceFromExpectedPartNumberList.toString()));
        }
        List<String> differenceFromActualPartNumberList = actualUniquePartList.stream()
                .filter(element -> !expectedPartNumberList.contains(element))
                .collect(Collectors.toList());
        if(differenceFromActualPartNumberList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with actual %s", differenceFromActualPartNumberList.toString()));
        }
        Assert.assertEquals(actualUniquePartList.size(),expectedPartNumberList.size());
    }

    @Then("Verify user filters multicore using {string} successfully")
    public void verifyUserFiltersMulticore(String filterName) throws IOException, InterruptedException, AWTException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("multicore", context.driver);
        List<MulticoreComponentDB> dbData =new MulticoreComponentDBPage(context.driver).getMultiCoreAPIData(response);
        MulticoreComponentDB randomMulticoreData = new MulticoreComponentDBPage(context.driver).getRandomMulticoreComponent(dbData);
        List<MulticoreComponentDB> filteredDbData = new ArrayList<>();
        searchPartsDatabasePage.selectWireType("multicore");
        switch (filterName.toLowerCase()) {
            case "partnumber":
                filteredDbData = dbData.stream().filter(x -> x.getPartnumber().equals(randomMulticoreData.getPartnumber())).collect(Collectors.toList());
                searchPartsDatabasePage.searchWireMulticoreUsingPartNumber(randomMulticoreData.getPartnumber());
                break;
            case "primarycolour":
                filteredDbData = dbData.stream().filter(x -> x.getColour().equals(randomMulticoreData.getColour())).collect(Collectors.toList());
                searchPartsDatabasePage.searchWireMulticoreUsingPrimaryColour(randomMulticoreData.getColour());
                break;
        }
        List<String> actualUniquePartList = searchPartsDatabasePage.getSearchWiresData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x -> x.getPartnumber()).collect(Collectors.toList());
        List<String> differenceFromExpectedPartNumberList = expectedPartNumberList.stream()
                .filter(element -> !actualUniquePartList.contains(element))
                .collect(Collectors.toList());
        if(differenceFromExpectedPartNumberList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with expected %s", differenceFromExpectedPartNumberList.toString()));
        }
        List<String> differenceFromActualPartNumberList = actualUniquePartList.stream()
                .filter(element -> !expectedPartNumberList.contains(element))
                .collect(Collectors.toList());
        if(differenceFromActualPartNumberList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with actual %s", differenceFromActualPartNumberList.toString()));
        }
        Assert.assertEquals(actualUniquePartList.size(),expectedPartNumberList.size());
    }

    @Then("Verify user filters wire using {string} and {string} successfully")
    public void verifyUserFiltersWireUsingMultipleFilters(String filter1, String filter2) throws IOException, InterruptedException, AWTException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("wire", context.driver);
        List<WiresComponentDB> dbData =new WiresComponentDBPage(context.driver).getWireAPIData(response);
        WiresComponentDB randomWireData = new WiresComponentDBPage(context.driver).getRandomWireComponent(dbData);
        List<WiresComponentDB> filteredDbData = new ArrayList<>();
        searchPartsDatabasePage.selectWireType("wire");
        filteredDbData = dbData.stream().filter(x -> x.getPartnumber().equals(randomWireData.getPartnumber())).collect(Collectors.toList());
        searchPartsDatabasePage.searchWireUsingPartNumberAndMaterial(randomWireData.getPartnumber(), randomWireData.getWirematerial());
        List<String> actualUniquePartList = searchPartsDatabasePage.getSearchWiresData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x -> x.getPartnumber()).collect(Collectors.toList());
        List<String> differenceFromExpectedPartNumberList = expectedPartNumberList.stream()
                .filter(element -> !actualUniquePartList.contains(element))
                .collect(Collectors.toList());
        if(differenceFromExpectedPartNumberList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with expected %s", differenceFromExpectedPartNumberList.toString()));
        }
        List<String> differenceFromActualPartNumberList = actualUniquePartList.stream()
                .filter(element -> !expectedPartNumberList.contains(element))
                .collect(Collectors.toList());
        if(differenceFromActualPartNumberList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with actual %s", differenceFromActualPartNumberList.toString()));
        }
        Assert.assertEquals(actualUniquePartList.size(),expectedPartNumberList.size());
    }

    @Then("Verify user filters component {string} in attachedparts successfully")
    public void verifyUserFiltersComponenttypeInAttachedpartsSuccessfully(String componentType) throws IOException, InterruptedException {
        File file;
        RestAssuredUtility rs;
        String response;
        List<String> expectedPartNumberList = new ArrayList<>();
        searchPartsDatabasePage.selectAttachPartComponentType(componentType);
        switch (componentType.toLowerCase()){
            case "connector":
                System.out.println("Getting data from API");
                rs= new RestAssuredUtility();
                response=rs.getComponentDbResponse("connector", context.driver);
                List<ConnectorDB> connectorDbData =new ConnectorsDBPage(context.driver).getConnectorsAPIData(response);
                expectedPartNumberList = connectorDbData.stream().map(x -> x.getPartnumber()).collect(Collectors.toList());
                break;
            case "splice":
                System.out.println("Getting data from API");
                rs= new RestAssuredUtility();
                response=rs.getComponentDbResponse("splice", context.driver);
                List<SplicesComponentDB> splicesdbData =new SplicesComponentDBPage(context.driver).getSpliceAPIData(response);
                expectedPartNumberList = splicesdbData.stream().map(x -> x.getPartnumber()).collect(Collectors.toList());
                break;
            case "seal":
                System.out.println("Getting data from API");
                rs= new RestAssuredUtility();
                response=rs.getComponentDbResponse("seal", context.driver);
                List<SealsComponentDB> sealsdbData =new SealsComponentDBPage(context.driver).getSealAPIData(response);
                expectedPartNumberList = sealsdbData.stream().map(x -> x.getPartnumber()).collect(Collectors.toList());
                break;
            case "terminal":
                System.out.println("Getting data from API");
                rs= new RestAssuredUtility();
                response=rs.getComponentDbResponse("terminal", context.driver);
                List<TerminalsComponentDB> terminalsdbData =new TerminalsComponentDBPage(context.driver).getTerminalAPIData(response);
                expectedPartNumberList = terminalsdbData.stream().map(x -> x.getPartnumber()).collect(Collectors.toList());
                break;
            case "junctionpart":
                System.out.println("Getting data from API");
                rs= new RestAssuredUtility();
                response=rs.getComponentDbResponse("junctionpart", context.driver);
                List<JunctionPartComponentDB> junctionpartsdbData =new JunctionPartsComponentDBPage(context.driver).getJunctionPartsAPIData(response);
                expectedPartNumberList = junctionpartsdbData.stream().map(x -> x.getPartnumber()).collect(Collectors.toList());
                break;
            case "component":
                System.out.println("Getting data from API");
                rs= new RestAssuredUtility();
                response=rs.getComponentDbResponse("component", context.driver);
                List<ComponentsDB> componentsdbData =new ComponentsDBPage(context.driver).getComponentAPIData(response);
                expectedPartNumberList = componentsdbData.stream().map(x -> x.getPartnumber()).collect(Collectors.toList());
                break;
            case "otherpart":
                System.out.println("Getting data from API");
                rs= new RestAssuredUtility();
                response=rs.getComponentDbResponse("otherpart", context.driver);
                List<OtherPartsComponentDB> otherpartsdbData =new OtherPartsComponentDBPage(context.driver).getOtherPartAPIData(response);
                expectedPartNumberList = otherpartsdbData.stream().map(x -> x.getPartnumber()).collect(Collectors.toList());
                break;
        }
        List<String> actualUniquePartList = searchPartsDatabasePage.getAttachedPartsData();

        List<String> differenceFromExpectedPartNumberList = expectedPartNumberList.stream()
                .filter(element -> !actualUniquePartList.contains(element))
                .collect(Collectors.toList());
        if(differenceFromExpectedPartNumberList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with expected %s", differenceFromExpectedPartNumberList.toString()));
        }
        List<String> finalExpectedPartNumberList = expectedPartNumberList;
        List<String> differenceFromActualPartNumberList = actualUniquePartList.stream()
                .filter(element -> !finalExpectedPartNumberList.contains(element))
                .collect(Collectors.toList());
        if(differenceFromActualPartNumberList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with actual %s", differenceFromActualPartNumberList.toString()));
        }
        Assert.assertEquals(actualUniquePartList.size(),expectedPartNumberList.size());
    }

    @Then("Verify {string} terminals are shown in cavity table searchdetails")
    public void verifyLinkedTerminalsAreShownInCavityTableSearchdetails(String terminalsType) throws InterruptedException, IOException {
        if (terminalsType.toLowerCase().equals("all")){
            searchPartsDatabasePage.resetFiltersCavityDetails();
        }
        List<String> actualListOfLinkedTerminalsShown = searchPartsDatabasePage.getCavityDetailsData();
        List<String> expectedTerminalsList = new ArrayList<>();
        switch (terminalsType.toLowerCase()){
            case "linked":
                expectedTerminalsList = Arrays.asList("0-0444334-2","0-0281381-2","0-0444335-2");
                break;
            case "all":
                System.out.println("Getting data from API");
                RestAssuredUtility rs= new RestAssuredUtility();
                String response=rs.getComponentDbResponse("terminal", context.driver);
                List<TerminalsComponentDB> terminalsdbData =new TerminalsComponentDBPage(context.driver).getTerminalAPIData(response);
                expectedTerminalsList = terminalsdbData.stream().map(x -> x.getPartnumber()).collect(Collectors.toList());
                break;
        }
        List<String> differenceFromExpectedPartNumberList = expectedTerminalsList.stream()
                .filter(element -> !actualListOfLinkedTerminalsShown.contains(element))
                .collect(Collectors.toList());
        if(differenceFromExpectedPartNumberList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with expected %s", differenceFromExpectedPartNumberList.toString()));
        }
        List<String> finalExpectedTerminalsList = expectedTerminalsList;
        List<String> differenceFromActualPartNumberList = actualListOfLinkedTerminalsShown.stream()
                .filter(element -> !finalExpectedTerminalsList.contains(element))
                .collect(Collectors.toList());
        if(differenceFromActualPartNumberList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with actual %s", differenceFromActualPartNumberList.toString()));
        }
        Assert.assertEquals(actualListOfLinkedTerminalsShown.size(),expectedTerminalsList.size());

    }

    @And("User selects connector from searchparts window")
    public void userSelectsConnectorFromSearchpartsWindow() throws InterruptedException {
        new SearchPartsDatabasePage(context.driver).populateParts();
    }
}
