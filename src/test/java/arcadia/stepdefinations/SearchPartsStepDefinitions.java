package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.domainobjects.*;
import arcadia.mapperObjects.SearchParts;
import arcadia.mapperObjects.TestMapper;
import arcadia.pages.BundlePage;
import arcadia.pages.ComponentDB.Connectors.ConnectorsDBPage;
import arcadia.pages.ComponentDB.Multicore.MulticoreComponentDBPage;
import arcadia.pages.ComponentDB.Seals.SealsComponentDBPage;
import arcadia.pages.ComponentDB.Splices.SplicesComponentDBPage;
import arcadia.pages.ComponentDB.Wires.WiresComponentDBPage;
import arcadia.pages.HarnessPage;
import arcadia.pages.PageFactoryManager;
import arcadia.pages.SearchPartsDatabasePage;
import arcadia.utils.ConversionUtil;
import arcadia.utils.RestAssuredUtility;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.python.antlr.ast.Str;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        File file = new File("src/test/resources/componentDB/Connector/ConnectorData.json");
        List<ConnectorDB> dbData = null;
        if (file.exists()) {
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/Connector/ConnectorData.json"), new TypeReference<List<ConnectorDB>>() {
            });
        }
        if (!file.exists()) {
            dbData = new ConnectorsDBPage(context.driver).getConnectorsData();
            ObjectMapper mapper = new ObjectMapper();
            Files.createDirectories(Paths.get("src/test/resources/componentDB/Connector"));
            mapper.writeValue(new File("src/test/resources/componentDB/Connector/ConnectorData.json"), dbData);
        }
        ConnectorDB randomConnectorData = new ConnectorsDBPage(context.driver).getRandomConnectorComponent(dbData);
        List<ConnectorDB> filteredDbData = new ArrayList<>();
        searchPartsDatabasePage.selectSearchDB(System.getProperty("componentDB"));
        searchPartsDatabasePage.selectComponentType(component);
        switch (filtertype.toLowerCase()) {
            case "partnumber":
                filteredDbData = dbData.stream().filter(x -> x.getPartNumber().equals(randomConnectorData.getPartNumber())).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingPartNumber(randomConnectorData.getPartNumber());
                break;
            case "cavity":
                filteredDbData = dbData.stream().filter(x -> x.getNumberOfCavities().equals(randomConnectorData.getNumberOfCavities())).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingCavity(randomConnectorData.getNumberOfCavities());
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
                filteredDbData = dbData.stream().filter(x -> x.getTerminalGender().equals(randomConnectorData.getTerminalGender())).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingTerminalGender(randomConnectorData.getTerminalGender());
                break;
        }
        List<String> actualUniquePartList = searchPartsDatabasePage.getSearchPartsData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x -> x.getPartNumber()).collect(Collectors.toList());
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
        File file = new File("src/test/resources/componentDB/Splices/SpliceData.json");
        List<SplicesComponentDB> dbData = null;
        if (file.exists()) {
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/Splices/SpliceData.json"), new TypeReference<List<SplicesComponentDB>>() {
            });
        }
        if (!file.exists()) {
            dbData = new SplicesComponentDBPage(context.driver).getSplicesData();
            ObjectMapper mapper = new ObjectMapper();
            Files.createDirectories(Paths.get("src/test/resources/componentDB/Splices"));
            mapper.writeValue(new File("src/test/resources/componentDB/Splices/SpliceData.json"), dbData);
        }
        SplicesComponentDB randomSpliceData = new SplicesComponentDBPage(context.driver).getRandomSpliceComponent(dbData);
        List<SplicesComponentDB> filteredDbData = new ArrayList<>();
        searchPartsDatabasePage.selectSearchDB(System.getProperty("componentDB"));
        searchPartsDatabasePage.selectComponentType("splice");
        switch (filtertype.toLowerCase()) {
            case "partnumber":
                filteredDbData = dbData.stream().filter(x -> x.getPartNumber().equals(randomSpliceData.getPartNumber())).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingPartNumber(randomSpliceData.getPartNumber());
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
        List<String> expectedPartNumberList = filteredDbData.stream().map(x -> x.getPartNumber()).collect(Collectors.toList());
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
        File f = new File("src/test/resources/componentDB/Connector/ConnectorData.json");
        List<ConnectorDB> dbData = null;
        System.out.println("Resuse JSON");
        ObjectMapper mapper = new ObjectMapper();
        dbData = mapper.readValue(new File("src/test/resources/componentDB/Connector/ConnectorData.json"), new TypeReference<List<ConnectorDB>>() {
        });
        List<ConnectorDB> filteredDbData = new ArrayList<>();
        searchPartsDatabasePage.selectSearchDB(System.getProperty("componentDB"));
        searchPartsDatabasePage.selectComponentType(component);
        switch (filtertype.toLowerCase()){
            case "housinggender":
                filteredDbData = dbData.stream().filter(x -> x.getHousingGender().equals(filterValue)).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingHousingGender(filterValue);
                break;
            case "terminalgender":
                filteredDbData = dbData.stream().filter(x -> x.getTerminalGender().equals(filterValue)).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingTerminalGender(filterValue);
                break;
            case "type":
                filteredDbData = dbData.stream().filter(x -> x.getConnectorType().equals(filterValue)).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingType(filterValue);
                break;
            case "colour":
                filteredDbData = dbData.stream().filter(x -> x.getColour().equals(filterValue)).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingColour(filterValue);
                break;
        }
        List<String> actualUniquePartList = searchPartsDatabasePage.getSearchPartsData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x -> x.getPartNumber()).collect(Collectors.toList());
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
        File file = new File("src/test/resources/componentDB/Wire/WireData.json");
        List<WiresComponentDB> dbData = null;
        if (file.exists()) {
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/Wire/WireData.json"), new TypeReference<List<WiresComponentDB>>() {
            });
        }
        WiresComponentDB randomWiresData = new WiresComponentDBPage(context.driver).getRandomWireComponent(dbData);
        List<WiresComponentDB> filteredDbData = new ArrayList<>();
        searchPartsDatabasePage.selectWireType("wire");
        switch (filterName.toLowerCase()) {
            case "partnumber":
                filteredDbData = dbData.stream().filter(x -> x.getPartNumber().equals(randomWiresData.getPartNumber())).collect(Collectors.toList());
                searchPartsDatabasePage.searchWireMulticoreUsingPartNumber(randomWiresData.getPartNumber());
                break;
            case "material":
                filteredDbData = dbData.stream().filter(x -> x.getMaterial().equals(randomWiresData.getMaterial())).collect(Collectors.toList());
                searchPartsDatabasePage.searchWireMulticoreUsingMaterial(randomWiresData.getMaterial());
                break;
            case "gauge":
                filteredDbData = dbData.stream().filter(x -> x.getGauge().equals(randomWiresData.getGauge())).collect(Collectors.toList());
                searchPartsDatabasePage.searchWireMulticoreUsingGauge(randomWiresData.getGauge());
                break;
            case "csa":
                filteredDbData = dbData.stream().filter(x -> x.getWireCSA().equals(randomWiresData.getWireCSA())).collect(Collectors.toList());
                searchPartsDatabasePage.searchWireMulticoreUsingCSA(String.valueOf(randomWiresData.getWireCSA()));
                break;
            case "outerdia":
                filteredDbData = dbData.stream().filter(x -> x.getOutsideDia().equals(randomWiresData.getOutsideDia())).collect(Collectors.toList());
                searchPartsDatabasePage.searchWireMulticoreUsingOuterDia(String.valueOf(randomWiresData.getOutsideDia()));
                break;
            case "primarycolour":
                filteredDbData = dbData.stream().filter(x -> x.getColour().split("-")[0].equals(randomWiresData.getColour().split("-")[0])).collect(Collectors.toList());
                searchPartsDatabasePage.searchWireMulticoreUsingPrimaryColour(randomWiresData.getColour().split("-")[0]);
                break;

        }
        List<String> actualUniquePartList = searchPartsDatabasePage.getSearchWiresData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x -> x.getPartNumber()).collect(Collectors.toList());
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
        File file = new File("src/test/resources/componentDB/Multicore/MulticoreData.json");
        List<MulticoreComponentDB> dbData = null;
        if (file.exists()) {
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/Multicore/MulticoreData.json"), new TypeReference<List<MulticoreComponentDB>>() {
            });
        }
        MulticoreComponentDB randomMulticoreData = new MulticoreComponentDBPage(context.driver).getRandomMulticoreComponent(dbData);
        List<MulticoreComponentDB> filteredDbData = new ArrayList<>();
        searchPartsDatabasePage.selectWireType("multicore");
        switch (filterName.toLowerCase()) {
            case "partnumber":
                filteredDbData = dbData.stream().filter(x -> x.getPartNumber().equals(randomMulticoreData.getPartNumber())).collect(Collectors.toList());
                searchPartsDatabasePage.searchWireMulticoreUsingPartNumber(randomMulticoreData.getPartNumber());
                break;
            case "primarycolour":
                filteredDbData = dbData.stream().filter(x -> x.getColour().equals(randomMulticoreData.getColour())).collect(Collectors.toList());
                searchPartsDatabasePage.searchWireMulticoreUsingPrimaryColour(randomMulticoreData.getColour());
                break;
        }
        List<String> actualUniquePartList = searchPartsDatabasePage.getSearchWiresData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x -> x.getPartNumber()).collect(Collectors.toList());
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
        File file = new File("src/test/resources/componentDB/Wire/WireData.json");
        List<WiresComponentDB> dbData = null;
        if (file.exists()) {
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/Wire/WireData.json"), new TypeReference<List<WiresComponentDB>>() {
            });
        }
        WiresComponentDB randomWiresData = new WiresComponentDBPage(context.driver).getRandomWireComponent(dbData);
        List<WiresComponentDB> filteredDbData = new ArrayList<>();
        searchPartsDatabasePage.selectWireType("wire");
        filteredDbData = dbData.stream().filter(x -> x.getPartNumber().equals(randomWiresData.getPartNumber())).collect(Collectors.toList());
        searchPartsDatabasePage.searchWireUsingPartNumberAndMaterial(randomWiresData.getPartNumber(), randomWiresData.getMaterial());
        List<String> actualUniquePartList = searchPartsDatabasePage.getSearchWiresData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x -> x.getPartNumber()).collect(Collectors.toList());
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
        List<String> expectedPartNumberList = new ArrayList<>();
        searchPartsDatabasePage.selectAttachPartComponentType(componentType);
        switch (componentType.toLowerCase()){
            case "connector":
                file = new File("src/test/resources/componentDB/Connector/ConnectorData.json");
                List<ConnectorDB> connectordbData = null;
                if (file.exists()) {
                    ObjectMapper mapper = new ObjectMapper();
                    connectordbData = mapper.readValue(new File("src/test/resources/componentDB/Connector/ConnectorData.json"), new TypeReference<List<ConnectorDB>>() {
                    });
                }
                expectedPartNumberList = connectordbData.stream().map(x -> x.getPartNumber()).collect(Collectors.toList());
                break;
            case "splice":
                file = new File("src/test/resources/componentDB/Splices/SpliceData.json");
                List<SplicesComponentDB> splicesdbData = null;
                if (file.exists()) {
                    ObjectMapper mapper = new ObjectMapper();
                    splicesdbData = mapper.readValue(new File("src/test/resources/componentDB/Splices/SpliceData.json"), new TypeReference<List<SplicesComponentDB>>() {
                    });
                }
                expectedPartNumberList = splicesdbData.stream().map(x -> x.getPartNumber()).collect(Collectors.toList());
                break;
            case "seal":
                RestAssuredUtility rs= new RestAssuredUtility();
                String response=rs.getResponse("seal", context.driver);
                List<SealsComponentDB> sealsdbData =new SealsComponentDBPage(context.driver).getSealAPIData(response);
                expectedPartNumberList = sealsdbData.stream().map(x -> x.getPartnumber()).collect(Collectors.toList());
                break;
            case "terminal":
                file = new File("src/test/resources/componentDB/Terminals/TerminalData.json");
                List<TerminalsComponentDB> terminalsdbData = null;
                if (file.exists()) {
                    ObjectMapper mapper = new ObjectMapper();
                    terminalsdbData = mapper.readValue(new File("src/test/resources/componentDB/Terminals/TerminalData.json"), new TypeReference<List<TerminalsComponentDB>>() {
                    });
                }
                expectedPartNumberList = terminalsdbData.stream().map(x -> x.getPartNumber()).collect(Collectors.toList());
                break;
            case "junctionpart":
                file = new File("src/test/resources/componentDB/JunctionParts/JunctionPartsData.json");
                List<JunctionPartComponentDB> junctionpartsdbData = null;
                if (file.exists()) {
                    ObjectMapper mapper = new ObjectMapper();
                    junctionpartsdbData = mapper.readValue(new File("src/test/resources/componentDB/JunctionParts/JunctionPartsData.json"), new TypeReference<List<JunctionPartComponentDB>>() {
                    });
                }
                expectedPartNumberList = junctionpartsdbData.stream().map(x -> x.getPartNumber()).collect(Collectors.toList());
                break;
            case "component":
                file = new File("src/test/resources/componentDB/Component/ComponentData.json");
                List<ComponentsDB> componentsdbData = null;
                if (file.exists()) {
                    ObjectMapper mapper = new ObjectMapper();
                    componentsdbData = mapper.readValue(new File("src/test/resources/componentDB/Component/ComponentData.json"), new TypeReference<List<ComponentsDB>>() {
                    });
                }
                expectedPartNumberList = componentsdbData.stream().map(x -> x.getPartNumber()).collect(Collectors.toList());
                break;
            case "otherpart":
                file = new File("src/test/resources/componentDB/OtherParts/OtherPartsData.json");
                List<OtherPartsComponentDB> otherpartsdbData = null;
                if (file.exists()) {
                    ObjectMapper mapper = new ObjectMapper();
                    otherpartsdbData = mapper.readValue(new File("src/test/resources/componentDB/OtherParts/OtherPartsData.json"), new TypeReference<List<OtherPartsComponentDB>>() {
                    });
                }
                expectedPartNumberList = otherpartsdbData.stream().map(x -> x.getPartNumber()).collect(Collectors.toList());
                break;
        }
        List<String> actualUniquePartList = searchPartsDatabasePage.getAttachedWiresData();

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
        List<String> expectedTerminalsList = new ArrayList<>();
        switch (terminalsType.toLowerCase()){
            case "linked":
                expectedTerminalsList = Arrays.asList("0-0444334-2","0-0281381-2","0-0444335-2");
                break;
            case "all":
                searchPartsDatabasePage.resetFiltersCavityDetails();
                File file = new File("src/test/resources/componentDB/Terminals/TerminalData.json");
                List<TerminalsComponentDB> terminalsdbData = null;
                if (file.exists()) {
                    ObjectMapper mapper = new ObjectMapper();
                    terminalsdbData = mapper.readValue(new File("src/test/resources/componentDB/Terminals/TerminalData.json"), new TypeReference<List<TerminalsComponentDB>>() {
                    });
                }
                expectedTerminalsList = terminalsdbData.stream().map(x -> x.getPartNumber()).collect(Collectors.toList());
                break;
        }

        List<String> actualListOfLinkedTerminalsShown = searchPartsDatabasePage.getCavityDetailsData();
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
