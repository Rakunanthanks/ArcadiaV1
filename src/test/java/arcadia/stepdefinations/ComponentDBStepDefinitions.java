package arcadia.stepdefinations;

import arcadia.context.FlowContext;
import arcadia.context.TestContext;
import arcadia.datasources.ComponentDataJDBC;
import arcadia.domainobjects.*;
import arcadia.domainobjects.Macros.CustomLabelTags;
import arcadia.domainobjects.Macros.WireTags;
import arcadia.pages.ComponentDB.AddNewComponentPage;
import arcadia.pages.ComponentDB.Applicators.ApplicatorsComponentDBPage;
import arcadia.pages.ComponentDB.CommonElements;
import arcadia.pages.ComponentDB.ComponentDBHomePage;
import arcadia.pages.ComponentDB.Components.ComponentsDBPage;
import arcadia.pages.ComponentDB.Connectors.ConnectorsDBPage;
import arcadia.pages.ComponentDB.HeaderPanel;
import arcadia.pages.ComponentDB.JunctionParts.JunctionPartsComponentDBPage;
import arcadia.pages.ComponentDB.Multicore.MulticoreComponentDBPage;
import arcadia.pages.ComponentDB.OtherParts.OtherPartsComponentDBPage;
import arcadia.pages.ComponentDB.Seals.SealsComponentDBPage;
import arcadia.pages.ComponentDB.Splices.SplicesComponentDBPage;
import arcadia.pages.ComponentDB.Terminals.TerminalsComponentDBPage;
import arcadia.pages.ComponentDB.Wires.WiresComponentDBPage;
import arcadia.pages.GeneralMacrosPage;
import arcadia.utils.RestAssuredUtility;
import arcadia.utils.StringHelper;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ComponentDBStepDefinitions {
    private final TestContext context;

    public ComponentDBStepDefinitions(TestContext context) {
        this.context = context;
    }

    @Then("{string} component with status {string} is created successfully")
    public void component_with_status_is_created_successfully(String componentName, String componentStatus) throws InterruptedException, SQLException, ClassNotFoundException {
        AddComponentForm addComponentForm = null;
        ComponentDetails componentDetails = null;
        List<AdditionalReferences> additionalReferencesList = null;
        AdditionalReferences additionalReferences1 = null;
        BomDetails bomDetails = null;
        String csvQuery = "";
        String csvDirectoryPath = "src/test/resources/componentDB/TestData";
        new HeaderPanel(context.driver).openAddNewComponentPage();

        //Adding component details
        csvQuery = "Select * from ComponentDetails where componentName='" + componentName.toLowerCase() + "'";
        addComponentForm = new AddComponentForm();
        componentDetails = new ComponentDataJDBC().getComponentDetails(csvDirectoryPath, csvQuery);
        componentDetails.setDescription(String.format("testdescription-%04d", new StringHelper().generateRandomDigit()));
        componentDetails.setStatus(componentStatus);
        addComponentForm.setComponentDetails(componentDetails);
        ExtentCucumberAdapter.addTestStepLog(String.format("Component Name is "+ componentName+", Component Status is "+componentStatus));

        //Adding additional references details
        csvQuery = "Select * from AdditionalReferencesDetails where componentName='" + componentName.toLowerCase() + "'";
        additionalReferences1 = new ComponentDataJDBC().getAdditionalReferenceDetails(csvDirectoryPath, csvQuery);
        additionalReferencesList = new ArrayList<>();
        String referencesPartNumber = new StringHelper().generateRandomUUID();
        FlowContext.referencesPartNumber = referencesPartNumber;
        additionalReferences1.setReferencesPartNumber(referencesPartNumber);
        additionalReferencesList.add(additionalReferences1);
        addComponentForm.setAdditionalReferences(additionalReferencesList);
//        ExtentCucumberAdapter.addTestStepLog(String.format("Reference part number is "+ referencesPartNumber));

        //Adding bom details
        csvQuery = "Select * from BomDetails where componentName='" + componentName.toLowerCase() + "'";
        bomDetails = new ComponentDataJDBC().getBomDetails(csvDirectoryPath, csvQuery);
        addComponentForm.setBomDetails(bomDetails);
        new AddNewComponentPage(context.driver).createComponent(addComponentForm, componentName);
        new AddNewComponentPage(context.driver).submitComponentDetails();
        Thread.sleep(1000);
    }

    @Then("{string} component with billtype {string} is created successfully")
    public void component_with_billtype_is_created_successfully(String componentName, String componentBomBillType) throws InterruptedException, SQLException, ClassNotFoundException {
        AddComponentForm addComponentForm = null;
        ComponentDetails componentDetails = null;
        List<AdditionalReferences> additionalReferencesList = null;
        AdditionalReferences additionalReferences1 = null;
        BomDetails bomDetails = null;
        String csvQuery = "";
        String csvDirectoryPath = "src/test/resources/componentDB/TestData";
        new HeaderPanel(context.driver).openAddNewComponentPage();
        ExtentCucumberAdapter.addTestStepLog(String.format("Component Name is "+ componentName+" bill type is "+componentBomBillType));

        //Adding component details
        csvQuery = "Select * from ComponentDetails where componentName='" + componentName.toLowerCase() + "'";
        addComponentForm = new AddComponentForm();
        componentDetails = new ComponentDataJDBC().getComponentDetails(csvDirectoryPath, csvQuery);
        componentDetails.setDescription(String.format("testdescription-%04d", new StringHelper().generateRandomDigit()));
        addComponentForm.setComponentDetails(componentDetails);

        //Adding additional references details
        csvQuery = "Select * from AdditionalReferencesDetails where componentName='" + componentName.toLowerCase() + "'";
        additionalReferences1 = new ComponentDataJDBC().getAdditionalReferenceDetails(csvDirectoryPath, csvQuery);
        additionalReferencesList = new ArrayList<>();
        String referencesPartNumber = new StringHelper().generateRandomUUID();
        FlowContext.referencesPartNumber = referencesPartNumber;
        additionalReferences1.setReferencesPartNumber(referencesPartNumber);
        additionalReferencesList.add(additionalReferences1);
        addComponentForm.setAdditionalReferences(additionalReferencesList);

        //Adding bom details
        csvQuery = "Select * from BomDetails where componentName='" + componentName.toLowerCase() + "'";
        bomDetails = new ComponentDataJDBC().getBomDetails(csvDirectoryPath, csvQuery);
        bomDetails.setBomBillType(componentBomBillType);
        addComponentForm.setBomDetails(bomDetails);
        new AddNewComponentPage(context.driver).createComponent(addComponentForm, componentName);
        new AddNewComponentPage(context.driver).submitComponentDetails();
        Thread.sleep(1000);
    }

    @Then("{string} component with referencepartnumber {string} and referencecompany {string} only is created")
    public void component_with_reference_details_is_created(String componentName, String partNumber, String referencecompany) throws InterruptedException {
        ExtentCucumberAdapter.addTestStepLog(String.format("Component Name is "+ componentName+" part number is "+partNumber+", Reference Company is "+referencecompany));
        new HeaderPanel(context.driver).openAddNewComponentPage();
        AddComponentForm addComponentForm = null;
        addComponentForm = new AddComponentForm();
        if (!String.valueOf(partNumber).isEmpty()) {
            partNumber = new StringHelper().generateRandomUUID();
        }
        List<AdditionalReferences> additionalReferencesList = new ArrayList<>();
        FlowContext.referencesPartNumber = partNumber;
        AdditionalReferences additionalReferences1 = new AdditionalReferences(partNumber, "", referencecompany);
        additionalReferencesList.add(additionalReferences1);
        addComponentForm.setAdditionalReferences(additionalReferencesList);
        new AddNewComponentPage(context.driver).createComponentWithMandatoryDetailsOnly(addComponentForm);
        new AddNewComponentPage(context.driver).submitComponentDetails();
        Thread.sleep(1000);
    }

    @Then("Verify error message is displayed for mandatory field {string} for component {string}")
    public void error_message_is_displayed_for_mandatory_field(String fieldName, String componentName) throws InterruptedException {
        //ToDo the error messages needs to be moved to a separate file
        String errorMessage = "";
        switch (fieldName.toLowerCase()) {
            case "referencepartnumber":
                errorMessage = "Enter Part Number";
                break;
            case "referencecompany":
                errorMessage = "Enter Company";
                break;
        }
        ExtentCucumberAdapter.addTestStepLog(String.format("Error message is "+ errorMessage+" for Mandatory field is "+fieldName+", for component "+componentName));
        new AddNewComponentPage(context.driver).verifyAlertMessage(errorMessage);
        new AddNewComponentPage(context.driver).closeAlertPopUp();
    }

    @Then("{string} component with additionalreferencetype {string} is created successfully")
    public void component_with_additionalreferencetype_is_created_successfully(String componentName, String additionalRefernceType) throws InterruptedException, SQLException, ClassNotFoundException {
        ExtentCucumberAdapter.addTestStepLog(String.format("Component Name is "+ componentName+" additional Refernce Type is "+additionalRefernceType));
        AddComponentForm addComponentForm = null;
        ComponentDetails componentDetails = null;
        List<AdditionalReferences> additionalReferencesList = null;
        AdditionalReferences additionalReferences1 = null;
        BomDetails bomDetails = null;
        String csvQuery = "";
        String csvDirectoryPath = "src/test/resources/componentDB/TestData";
        new HeaderPanel(context.driver).openAddNewComponentPage();

        //Adding component details
        csvQuery = "Select * from ComponentDetails where componentName='" + componentName.toLowerCase() + "'";
        addComponentForm = new AddComponentForm();
        componentDetails = new ComponentDataJDBC().getComponentDetails(csvDirectoryPath, csvQuery);
        componentDetails.setDescription(String.format("testdescription-%04d", new StringHelper().generateRandomDigit()));
        addComponentForm.setComponentDetails(componentDetails);


        //Adding bom details
        csvQuery = "Select * from BomDetails where componentName='" + componentName.toLowerCase() + "'";
        bomDetails = new ComponentDataJDBC().getBomDetails(csvDirectoryPath, csvQuery);
        addComponentForm.setBomDetails(bomDetails);

        //Adding additional references details
        csvQuery = "Select * from AdditionalReferencesDetails where componentName='" + componentName.toLowerCase() + "'";
        additionalReferences1 = new ComponentDataJDBC().getAdditionalReferenceDetails(csvDirectoryPath, csvQuery);
        additionalReferencesList = new ArrayList<>();
        String[] arrayOfRefrenceType = additionalRefernceType.split(",");
        for (String refType : arrayOfRefrenceType) {
            AdditionalReferences additionalReferences = new ComponentDataJDBC().getAdditionalReferenceDetails(csvDirectoryPath, csvQuery);
            String referencesPartNumber = new StringHelper().generateRandomUUID();
            FlowContext.referencesPartNumber = referencesPartNumber;
            additionalReferences.setReferencesPartNumber(referencesPartNumber);
            additionalReferences.setReferencesType(refType);
            additionalReferencesList.add(additionalReferences);
        }
        addComponentForm.setAdditionalReferences(additionalReferencesList);
        new AddNewComponentPage(context.driver).createComponent(addComponentForm, componentName);
        new AddNewComponentPage(context.driver).submitComponentDetails();
        Thread.sleep(1000);
    }

    @Then("verify user can apply filter based on property {string}")
    public void verify_user_can_apply_filter_based_on_property(String propertyName) throws InterruptedException, IOException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("wire", context.driver);
        List<WiresComponentDB> dbData =new WiresComponentDBPage(context.driver).getWireAPIData(response);
        WiresComponentDB randomWireData = new WiresComponentDBPage(context.driver).getRandomWireComponent(dbData);
        List<WiresComponentDB> filteredDbData = new ArrayList<>();
        switch (propertyName.toLowerCase()) {
            case "status":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomWireData.getStatus()));
                filteredDbData = dbData.stream().filter(x -> x.getStatus().equals(randomWireData.getStatus())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnStatus(randomWireData.getStatus());
                break;
            case "partnumber":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomWireData.getPartnumber()));
                filteredDbData = dbData.stream().filter(x -> x.getPartnumber().equals(randomWireData.getPartnumber())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnPartNumber(randomWireData.getPartnumber());
                break;
            case "description":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomWireData.getDescription()));
                filteredDbData = dbData.stream().filter(x -> x.getDescription().equals(randomWireData.getDescription())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnDescription(randomWireData.getDescription());
                break;
            case "family":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomWireData.getFamily()));
                filteredDbData = dbData.stream().filter(x -> x.getFamily().equals(randomWireData.getFamily())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnFamily(randomWireData.getFamily());
                break;
            case "usage":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomWireData.getUsage()));
                filteredDbData = dbData.stream().filter(x -> x.getUsage().equals(randomWireData.getUsage())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnUsage(randomWireData.getUsage());
                break;
            case "supplier":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomWireData.getSupplier()));
                filteredDbData = dbData.stream().filter(x -> x.getSupplier().contains(randomWireData.getSupplier())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplier(randomWireData.getSupplier());
                break;
            case "supplierpn":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomWireData.getSupplierpn()));
                filteredDbData = dbData.stream().filter(x -> x.getSupplierpn().contains(randomWireData.getSupplierpn())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplierPN(randomWireData.getSupplierpn());
                break;
            case "colour":
                String[] color= (randomWireData.getColour().split("-"));
                String searchBy=color[0];
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", searchBy));
                filteredDbData = dbData.stream().filter(x -> x.getColour().contains(searchBy)).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnColour(searchBy);
                break;
            case "awgsize":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomWireData.getAwgsize()));
                filteredDbData = dbData.stream().filter(x -> x.getAwgsize().contains(randomWireData.getAwgsize())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnAwgSize(randomWireData.getAwgsize());
                break;
            case "gauge":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomWireData.getGauge()));
                filteredDbData = dbData.stream()
                        .filter(x -> x.getGauge().equals(randomWireData.getGauge()))
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnGauge(randomWireData.getGauge());
                break;
        }
        List<String> actualUniquePartList = new MulticoreComponentDBPage(context.driver).getPartNumber();
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
        Assert.assertEquals(expectedPartNumberList.size(), actualUniquePartList.size());
    }

    @Then("Verify wire component data is greater than value {string} for filter {string}")
    public void verify_component_data_is_greater_than_value_for_filter(String greaterThanValue, String filterName) throws IOException, InterruptedException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("wire", context.driver);
        List<WiresComponentDB> dbData =new WiresComponentDBPage(context.driver).getWireAPIData(response);
        List<WiresComponentDB> filteredDbData = new ArrayList<>();
        switch (filterName.toLowerCase()) {
            case "wirecsa":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", greaterThanValue));
                Double csaValue = Double.valueOf(greaterThanValue);
                filteredDbData = dbData.stream()
                        .filter(x -> x.getWirecsa() >= csaValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnCSARange(">= " + greaterThanValue);
                break;
            case "outsidedia":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", greaterThanValue));
                Double outsidedia = Double.valueOf(greaterThanValue);
                filteredDbData = dbData.stream()
                        .filter(x -> x.getOutsidedia() >= outsidedia)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnOutsideDiaRange(">= " + greaterThanValue);
                break;
            case "minimumbendradius":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", greaterThanValue));
                Double minimumbendradiusValue = Double.valueOf(greaterThanValue);
                filteredDbData = dbData.stream()
                        .filter(x -> x.getMinimumbendradius() >= minimumbendradiusValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnMinimumBendRadiusRange(">= " + greaterThanValue);
                break;
            case "maxcurrent":
                Double maxCurrentValue = Double.valueOf(greaterThanValue);
                filteredDbData = dbData.stream()
                        .filter(x -> x.getMaxcurrent() >= maxCurrentValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnMaxCurrentRange(">= " + greaterThanValue);
                break;
            case "resistance":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", greaterThanValue));
                Double resistanceValue = Double.valueOf(greaterThanValue);
                filteredDbData = dbData.stream()
                        .filter(x -> x.getResistance() >= resistanceValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnResistanceRange(">= " + greaterThanValue);
                break;
        }
        List<String> actualUniquePartList = new MulticoreComponentDBPage(context.driver).getPartNumber();
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
        Assert.assertEquals(expectedPartNumberList.size(), actualUniquePartList.size());
    }

    @Then("Verify wire component data on the basis of filter {string} with value {string}")
    public void verify_wire_component_data_on_the_basis_of_filter(String filterName, String filterValue) throws InterruptedException, IOException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("wire", context.driver);
        List<WiresComponentDB> dbData =new WiresComponentDBPage(context.driver).getWireAPIData(response);
        List<WiresComponentDB> filteredDbData = new ArrayList<>();
        switch (filterName.toLowerCase()) {
            case "wirecsa":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", filterValue));
                String[] csaRange = filterValue.split("-");
                Double initialCSAValue = Double.valueOf(csaRange[0]);
                Double finalCSAValue = Double.valueOf(csaRange[1]);
                filteredDbData = dbData.stream()
                        .filter(x -> x.getWirecsa() >= initialCSAValue)
                        .filter(x -> x.getWirecsa() <= finalCSAValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnCSARange(filterValue);
                break;
            case "outsidedia":
//                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", filterValue));
                String[] outDiaRange = filterValue.split("-");
                Double initialDiaValue = Double.valueOf(outDiaRange[0]);
                Double finalDiaValue = Double.valueOf(outDiaRange[1]);
                filteredDbData = dbData.stream()
                        .filter(x -> x.getOutsidedia() >= initialDiaValue)
                        .filter(x -> x.getOutsidedia() <= finalDiaValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnOutsideDiaRange(filterValue);
                break;
            case "minimumbendradius":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", filterValue));
                String[] bendRadiusRange = filterValue.split("-");
                Double initialRadiusValue = Double.valueOf(bendRadiusRange[0]);
                Double finalRadiusValue = Double.valueOf(bendRadiusRange[1]);
                filteredDbData = dbData.stream()
                        .filter(x -> x.getMinimumbendradius() >= initialRadiusValue)
                        .filter(x -> x.getMinimumbendradius() <= finalRadiusValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnMinimumBendRadiusRange(filterValue);
                break;
            case "maxcurrent":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", filterValue));
                String[] currentRange = filterValue.split("-");
                Double initialCurrentValue = Double.valueOf(currentRange[0]);
                Double finalCurrentValue = Double.valueOf(currentRange[1]);
                filteredDbData = dbData.stream()
                        .filter(x -> x.getMaxcurrent() >= initialCurrentValue)
                        .filter(x -> x.getMaxcurrent() <= finalCurrentValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnMaxCurrentRange(filterValue);
                break;
            case "resistance":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", filterValue));
                String[] resistanceRange = filterValue.split("-");
                Double initialResistanceValue = Double.valueOf(resistanceRange[0]);
                Double finalResistanceValue = Double.valueOf(resistanceRange[1]);
                filteredDbData = dbData.stream()
                        .filter(x -> x.getResistance() >= initialResistanceValue)
                        .filter(x -> x.getResistance() <= finalResistanceValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnResistanceRange(filterValue);
                break;
            case "material":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", filterValue));
                filteredDbData = dbData.stream().filter(x -> x.getWirematerial().equals(filterValue)).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnMaterial(filterValue);
                break;
        }
        List<String> actualUniquePartList = new MulticoreComponentDBPage(context.driver).getPartNumber();
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

    @And("User searches {string} component using {string}")
    public void userSearchesComponent(String componentName, String searchType) throws InterruptedException {
        switch (searchType.toLowerCase()) {
            case "partnumber":
//                ExtentCucumberAdapter.addTestStepLog(String.format("Searched component is ", componentName+ ", Searched type is "+searchType));
                new CommonElements(context.driver).filterComponentBasedOnPartNumber(FlowContext.referencesPartNumber);
                break;
        }
    }

    @And("User selects the first component")
    public void userSelectsTheFirstComponent() {
        new CommonElements(context.driver).selectFirstComponent();
    }

    @And("User edits the first component")
    public void userEditsTheFirstComponent() {
        new CommonElements(context.driver).editFirstComponent();
    }

    @Then("User Adds Similar Component")
    public void addSimilarComponent() throws InterruptedException {
        new HeaderPanel(context.driver).clickAddSimilarComponent();
        String newPartNumber = new StringHelper().generateRandomUUID();
        FlowContext.referencesPartNumber = newPartNumber;
        new CommonElements(context.driver).enterNewPartNumber(newPartNumber);
        new CommonElements(context.driver).clickAddSimilarOnPopup();
        new AddNewComponentPage(context.driver).verifyAlertMessage("Component added successfully");
        new AddNewComponentPage(context.driver).closeAlertPopUp();
    }

    @Then("User verified the component {string} is added successfully")
    public void userVerifiedTheComponentIsAddedSuccessfully(String componentName) throws InterruptedException {
       ExtentCucumberAdapter.addTestStepLog(String.format("Component to be added is "+ componentName));
        switch (componentName.toLowerCase()) {
            case "wire":
                List<WiresComponentDB> wiresdatalist = new WiresComponentDBPage(context.driver).getWiresData();
                Assert.assertTrue(wiresdatalist.size() != 0);
                Assert.assertEquals(FlowContext.referencesPartNumber, wiresdatalist.get(0).getPartnumber());
                break;
            case "terminal":
                List<TerminalsComponentDB> terminalsdatalist = new TerminalsComponentDBPage(context.driver).getTerminalsData();
                Assert.assertTrue(terminalsdatalist.size() != 0);
                Assert.assertEquals(FlowContext.referencesPartNumber, terminalsdatalist.get(0).getPartnumber());
                break;
            case "splice":
                List<SplicesComponentDB> splicesdatalist = new SplicesComponentDBPage(context.driver).getSplicesData();
                Assert.assertTrue(splicesdatalist.size() != 0);
                Assert.assertEquals(FlowContext.referencesPartNumber, splicesdatalist.get(0).getPartnumber());
                break;
            case "otherpart":
                List<OtherPartsComponentDB> otherpartsdatalist = new OtherPartsComponentDBPage(context.driver).getOtherPartsData();
                Assert.assertTrue(otherpartsdatalist.size() != 0);
                Assert.assertEquals(FlowContext.referencesPartNumber, otherpartsdatalist.get(0).getPartnumber());
                break;
            case "junctionpart":
                List<JunctionPartComponentDB> junctionpartdatalist = new JunctionPartsComponentDBPage(context.driver).getJunctionPartsData();
                Assert.assertTrue(junctionpartdatalist.size() != 0);
                Assert.assertEquals(FlowContext.referencesPartNumber, junctionpartdatalist.get(0).getPartnumber());
                break;
            case "multicore":
                List<MulticoreComponentDB> multicoredatalist = new MulticoreComponentDBPage(context.driver).getMulticoreData();
                Assert.assertTrue(multicoredatalist.size() != 0);
                Assert.assertEquals(FlowContext.referencesPartNumber, multicoredatalist.get(0).getPartnumber());
                break;
            case "applicator":
                List<ApplicatorsComponentDB> applicatorsdatalist = new ApplicatorsComponentDBPage(context.driver).getApplicatorsData();
                Assert.assertTrue(applicatorsdatalist.size() != 0);
                Assert.assertEquals(FlowContext.referencesPartNumber, applicatorsdatalist.get(0).getPartnumber());
                break;
            case "component":
                List<ComponentsDB> componentsdatalist = new ComponentsDBPage(context.driver).getComponentsData();
                Assert.assertTrue(componentsdatalist.size() != 0);
                Assert.assertEquals(FlowContext.referencesPartNumber, componentsdatalist.get(0).getPartnumber());
                break;
            case "connector":
                List<ConnectorDB> connectorsdatalist = new ConnectorsDBPage(context.driver).getConnectorsData();
                Assert.assertTrue(connectorsdatalist.size() != 0);
                Assert.assertEquals(FlowContext.referencesPartNumber, connectorsdatalist.get(0).getPartnumber());
                break;
            case "seal":
                List<SealsComponentDB> sealsdatalist = new SealsComponentDBPage(context.driver).getSealData();
                Assert.assertTrue(sealsdatalist.size() != 0);
                Assert.assertEquals(FlowContext.referencesPartNumber, sealsdatalist.get(0).getPartnumber());
                break;
        }
    }

    @Then("User Deletes the Component")
    public void deleteComponent() throws InterruptedException {
        new HeaderPanel(context.driver).clickDeleteComponent();
        new AddNewComponentPage(context.driver).verifyConfirmationMessage("Do you want to delete the selected Component Part(s).");
        new AddNewComponentPage(context.driver).acceptConfirmationPopup();
    }

    @Then("User verified the component is deleted successfully")
    public void userVerifiedTheComponentIsDeletedSuccessfully() throws InterruptedException {
        new AddNewComponentPage(context.driver).verifySuccessPopupMessage("Components Deleted Successfully");
        new AddNewComponentPage(context.driver).acceptSuccessPopup();
    }

    @And("User Copies the Component for DB {string}")
    public void userCopiesTheComponent(String dbName) throws InterruptedException {
        new HeaderPanel(context.driver).clickCopyComponent();
        new HeaderPanel(context.driver).selectCopyComponentDB(dbName);
        new HeaderPanel(context.driver).clickConfirmCopy();
        new AddNewComponentPage(context.driver).verifyConfirmationMessage("Copying parts will copy all its linked parts to the destination component db");
        new AddNewComponentPage(context.driver).acceptConfirmationPopup();
    }

    @And("Use Verifies the component {string} is copied successfully")
    public void useVerifiesTheComponentWireIsCopiedSuccessfully(String componentType) throws InterruptedException {
        new AddNewComponentPage(context.driver).verifyTotalComponentCopiedCount(componentType, "1");
    }

    @Then("verify user can filter terminal based on property {string}")
    public void verifyUserCanFilterTerminalComponentBasedOnProperty(String propertyName) throws InterruptedException, IOException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("terminal", context.driver);
        List<TerminalsComponentDB> dbData =new TerminalsComponentDBPage(context.driver).getTerminalAPIData(response);
        TerminalsComponentDB randomTerminalData = new TerminalsComponentDBPage(context.driver).getRandomTerminalComponent(dbData);
        List<TerminalsComponentDB> filteredDbData = new ArrayList<>();
        switch (propertyName.toLowerCase()) {
            case "status":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomTerminalData.getStatus()));
                filteredDbData = dbData.stream().filter(x -> x.getStatus().equals(randomTerminalData.getStatus())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnStatus(randomTerminalData.getStatus());
                break;
            case "partnumber":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomTerminalData.getPartnumber()));
                filteredDbData = dbData.stream().filter(x -> x.getPartnumber().equals(randomTerminalData.getPartnumber())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnPartNumber(randomTerminalData.getPartnumber());
                break;
            case "description":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomTerminalData.getDescription()));
                filteredDbData = dbData.stream().filter(x -> x.getDescription().equals(randomTerminalData.getDescription())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnDescription(randomTerminalData.getDescription());
                break;
            case "family":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomTerminalData.getFamily()));
                filteredDbData = dbData.stream().filter(x -> x.getFamily().equals(randomTerminalData.getFamily())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnFamily(randomTerminalData.getFamily());
                break;
            case "usage":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomTerminalData.getUsage()));
                filteredDbData = dbData.stream().filter(x -> x.getUsage().equals(randomTerminalData.getUsage())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnUsage(randomTerminalData.getUsage());
                break;
            case "supplier":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomTerminalData.getSupplier()));
                filteredDbData = dbData.stream().filter(x -> x.getSupplier().equals(randomTerminalData.getSupplier())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplier(randomTerminalData.getSupplier());
                break;
            case "supplierpn":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomTerminalData.getSupplierpn()));
                filteredDbData = dbData.stream().filter(x -> x.getSupplierpn().equals(randomTerminalData.getSupplierpn())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplierPN(randomTerminalData.getSupplierpn());
                break;
            case "colour":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomTerminalData.getColour()));
                filteredDbData = dbData.stream().filter(x -> x.getColour().equals(randomTerminalData.getColour())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnColour(randomTerminalData.getColour());
                break;
            case "gender":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomTerminalData.getGender()));
                filteredDbData = dbData.stream().filter(x -> x.getGender().equals(randomTerminalData.getGender())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnGender(randomTerminalData.getGender());
                break;
            case "type":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomTerminalData.getTerminaltype()));
                filteredDbData = dbData.stream()
                        .filter(x -> x.getTerminaltype().equals(randomTerminalData.getTerminaltype()))
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnType(randomTerminalData.getTerminaltype());
                break;
            case "material":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomTerminalData.getMaterial()));
                filteredDbData = dbData.stream().filter(x -> x.getMaterial().equals(randomTerminalData.getMaterial())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnMaterial(randomTerminalData.getMaterial());
                break;
            case "csa":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomTerminalData.getWirecsa()));
                filteredDbData = dbData.stream().filter(x -> x.getWirecsa().equals(randomTerminalData.getWirecsa())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnCSARange(randomTerminalData.getWirecsa());
                break;
        }
        List<String> actualUniquePartList = new MulticoreComponentDBPage(context.driver).getPartNumber();
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

    @Then("verify user can filter splice based on property {string}")
    public void verifyUserCanFilterSpliceBasedOnProperty(String propertyName) throws IOException, InterruptedException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("splice", context.driver);
        List<SplicesComponentDB> dbData =new SplicesComponentDBPage(context.driver).getSpliceAPIData(response);
        SplicesComponentDB randomSpliceData = new SplicesComponentDBPage(context.driver).getRandomSpliceComponent(dbData);
        List<SplicesComponentDB> filteredDbData = new ArrayList<>();
        switch (propertyName.toLowerCase()) {
            case "partnumber":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomSpliceData.getPartnumber()));
                filteredDbData = dbData.stream().filter(x -> x.getPartnumber().equals(randomSpliceData.getPartnumber())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnPartNumber(randomSpliceData.getPartnumber());
                break;
            case "description":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomSpliceData.getDescription()));
                filteredDbData = dbData.stream().filter(x -> x.getDescription().equals(randomSpliceData.getDescription())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnDescription(randomSpliceData.getDescription());
                break;
            case "family":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomSpliceData.getFamily()));
                filteredDbData = dbData.stream().filter(x -> x.getFamily().equals(randomSpliceData.getFamily())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnFamily(randomSpliceData.getFamily());
                break;
            case "status":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomSpliceData.getStatus()));
                filteredDbData = dbData.stream().filter(x -> x.getStatus().equals(randomSpliceData.getStatus())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnStatus(randomSpliceData.getStatus());
                break;
            case "usage":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomSpliceData.getUsage()));
                filteredDbData = dbData.stream().filter(x -> x.getUsage().equals(randomSpliceData.getUsage())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnUsage(randomSpliceData.getUsage());
                break;
            case "supplier":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomSpliceData.getSupplier()));
                filteredDbData = dbData.stream().filter(x -> x.getSupplier().equals(randomSpliceData.getSupplier())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplier(randomSpliceData.getSupplier());
                break;
            case "supplierpn":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomSpliceData.getSupplierpn()));
                filteredDbData = dbData.stream().filter(x -> x.getSupplierpn().equals(randomSpliceData.getSupplierpn())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplierPN(randomSpliceData.getSupplierpn());
                break;
            case "colour":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomSpliceData.getColour()));
                filteredDbData = dbData.stream().filter(x -> x.getColour().equals(randomSpliceData.getColour())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnColour(randomSpliceData.getColour());
                break;
            case "sealingtype":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomSpliceData.getSplicesealingtype()));
                filteredDbData = dbData.stream().filter(x -> x.getSplicesealingtype().equals(randomSpliceData.getSplicesealingtype())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSealingType(randomSpliceData.getSplicesealingtype());
                break;
            case "material":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomSpliceData.getMaterial()));
                filteredDbData = dbData.stream().filter(x -> x.getMaterial().equals(randomSpliceData.getMaterial())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnMaterial(randomSpliceData.getMaterial());
                break;
        }
        List<String> actualUniquePartList = new MulticoreComponentDBPage(context.driver).getPartNumber();
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

    @Then("verify user can filter otherpart based on property {string}")
    public void verifyUserCanFilterOtherpartBasedOnProperty(String propertyName) throws IOException, InterruptedException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("otherpart", context.driver);
        List<OtherPartsComponentDB> dbData =new OtherPartsComponentDBPage(context.driver).getOtherPartAPIData(response);
        OtherPartsComponentDB randomOtherPartData = new OtherPartsComponentDBPage(context.driver).getRandomOtherPartComponent(dbData);
        List<OtherPartsComponentDB> filteredDbData = new ArrayList<>();
        switch (propertyName.toLowerCase()) {
            case "partnumber":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomOtherPartData.getPartnumber()));
                filteredDbData = dbData.stream().filter(x -> x.getPartnumber().equals(randomOtherPartData.getPartnumber())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnPartNumber(randomOtherPartData.getPartnumber());
                break;
            case "description":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomOtherPartData.getDescription()));
                filteredDbData = dbData.stream().filter(x -> x.getDescription().equals(randomOtherPartData.getDescription())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnDescription(randomOtherPartData.getDescription());
                break;
            case "family":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomOtherPartData.getFamily()));
                filteredDbData = dbData.stream().filter(x -> x.getFamily().equals(randomOtherPartData.getFamily())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnFamily(randomOtherPartData.getFamily());
                break;
            case "status":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomOtherPartData.getStatus()));
                filteredDbData = dbData.stream().filter(x -> x.getStatus().equals(randomOtherPartData.getStatus())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnStatus(randomOtherPartData.getStatus());
                break;
            case "usage":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomOtherPartData.getUsage()));
                filteredDbData = dbData.stream().filter(x -> x.getUsage().equals(randomOtherPartData.getUsage())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnUsage(randomOtherPartData.getUsage());
                break;
            case "supplier":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomOtherPartData.getSupplier()));
                filteredDbData = dbData.stream().filter(x -> x.getSupplier().equals(randomOtherPartData.getSupplier())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplier(randomOtherPartData.getSupplier());
                break;
            case "supplierpn":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomOtherPartData.getSupplierpn()));
                filteredDbData = dbData.stream().filter(x -> x.getSupplierpn().equals(randomOtherPartData.getSupplierpn())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplierPN(randomOtherPartData.getSupplierpn());
                break;
            case "colour":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomOtherPartData.getColour()));
                filteredDbData = dbData.stream().filter(x -> x.getColour().equals(randomOtherPartData.getColour())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnColour(randomOtherPartData.getColour());
                break;
        }
        List<String> actualUniquePartList = new MulticoreComponentDBPage(context.driver).getPartNumber();
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

    @Then("verify user can filter junctionpart based on property {string}")
    public void verifyUserCanFilterJunctionpartBasedOnProperty(String propertyName) throws IOException, InterruptedException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("junctionpart", context.driver);
        List<JunctionPartComponentDB> dbData =new JunctionPartsComponentDBPage(context.driver).getJunctionPartsAPIData(response);
        JunctionPartComponentDB randomJunctionPartData = new JunctionPartsComponentDBPage(context.driver).getRandomJunctionPartComponent(dbData);
        List<JunctionPartComponentDB> filteredDbData = new ArrayList<>();
        if (!propertyName.equalsIgnoreCase("partnumber")){
            new CommonElements(context.driver).checkIfPropertyIsChecked(propertyName);
        }
        switch (propertyName.toLowerCase()) {
            case "partnumber":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomJunctionPartData.getPartnumber()));
                filteredDbData = dbData.stream().filter(x -> x.getPartnumber().equals(randomJunctionPartData.getPartnumber())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnPartNumber(randomJunctionPartData.getPartnumber());
                break;
            case "description":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomJunctionPartData.getDescription()));
                filteredDbData = dbData.stream().filter(x -> x.getDescription().equals(randomJunctionPartData.getDescription())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnDescription(randomJunctionPartData.getDescription());
                break;
            case "family":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomJunctionPartData.getFamily()));
                filteredDbData = dbData.stream().filter(x -> x.getFamily().equals(randomJunctionPartData.getFamily())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnFamily(randomJunctionPartData.getFamily());
                break;
            case "status":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomJunctionPartData.getStatus()));
                filteredDbData = dbData.stream().filter(x -> x.getStatus().equals(randomJunctionPartData.getStatus())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnStatus(randomJunctionPartData.getStatus());
                break;
            case "usage":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomJunctionPartData.getUsage()));
                filteredDbData = dbData.stream().filter(x -> x.getUsage().equals(randomJunctionPartData.getUsage())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnUsage(randomJunctionPartData.getUsage());
                break;
            case "supplier":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomJunctionPartData.getSupplier()));
                filteredDbData = dbData.stream().filter(x -> x.getSupplier().equals(randomJunctionPartData.getSupplier())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplier(randomJunctionPartData.getSupplier());
                break;
            case "supplierpn":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomJunctionPartData.getSupplierpn()));
                filteredDbData = dbData.stream().filter(x -> x.getSupplierpn().equals(randomJunctionPartData.getSupplierpn())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplierPN(randomJunctionPartData.getSupplierpn());
                break;
            case "colour":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomJunctionPartData.getColour()));
                filteredDbData = dbData.stream().filter(x -> x.getColour().equals(randomJunctionPartData.getColour())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnColour(randomJunctionPartData.getColour());
                break;
            case "type":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomJunctionPartData.getType()));
                filteredDbData = dbData.stream().filter(x -> x.getType().equals(randomJunctionPartData.getType())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnControlType(randomJunctionPartData.getType());
                break;
            case "material":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomJunctionPartData.getMaterial()));
                filteredDbData = dbData.stream().filter(x -> x.getMaterial().equals(randomJunctionPartData.getMaterial())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnMaterial(randomJunctionPartData.getMaterial());
                break;
        }
        List<String> actualUniquePartList = new MulticoreComponentDBPage(context.driver).getPartNumber();
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

    @Then("verify user can filter multicore based on property {string}")
    public void verifyUserCanFilterMulticoreBasedOnProperty(String propertyName) throws IOException, InterruptedException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("multicore", context.driver);
        List<MulticoreComponentDB> dbData =new MulticoreComponentDBPage(context.driver).getMultiCoreAPIData(response);
        MulticoreComponentDB randomMulticoreData = new MulticoreComponentDBPage(context.driver).getRandomMulticoreComponent(dbData);
        List<MulticoreComponentDB> filteredDbData = new ArrayList<>();
        switch (propertyName.toLowerCase()) {
            case "partnumber":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomMulticoreData.getPartnumber()));
                filteredDbData = dbData.stream().filter(x -> x.getPartnumber().equals(randomMulticoreData.getPartnumber())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnPartNumber(randomMulticoreData.getPartnumber());
                break;
            case "description":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomMulticoreData.getDescription()));
                filteredDbData = dbData.stream().filter(x -> x.getDescription().equals(randomMulticoreData.getDescription())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnDescription(randomMulticoreData.getDescription());
                break;
            case "family":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomMulticoreData.getFamily()));
                filteredDbData = dbData.stream().filter(x -> x.getFamily().equals(randomMulticoreData.getFamily())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnFamily(randomMulticoreData.getFamily());
                break;
            case "status":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomMulticoreData.getStatus()));
                filteredDbData = dbData.stream().filter(x -> x.getStatus().equals(randomMulticoreData.getStatus())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnStatus(randomMulticoreData.getStatus());
                break;
            case "usage":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomMulticoreData.getUsage()));
                filteredDbData = dbData.stream().filter(x -> x.getUsage().equals(randomMulticoreData.getUsage())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnUsage(randomMulticoreData.getUsage());
                break;
            case "supplier":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomMulticoreData.getSupplier()));
                filteredDbData = dbData.stream().filter(x -> x.getSupplier().equals(randomMulticoreData.getSupplier())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplier(randomMulticoreData.getSupplier());
                break;
            case "supplierpn":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomMulticoreData.getSupplierpn()));
                filteredDbData = dbData.stream().filter(x -> x.getSupplierpn().equals(randomMulticoreData.getSupplierpn())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplierPN(randomMulticoreData.getSupplierpn());
                break;
            case "colour":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomMulticoreData.getColour()));
                filteredDbData = dbData.stream().filter(x -> x.getColour().equals(randomMulticoreData.getColour())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnColour(randomMulticoreData.getColour());
                break;
            case "cabletype":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomMulticoreData.getCabletype()));
                filteredDbData = dbData.stream().filter(x -> x.getCabletype().equals(randomMulticoreData.getCabletype())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnCableType(randomMulticoreData.getCabletype());
                break;
        }
        List<String> actualUniquePartList = new MulticoreComponentDBPage(context.driver).getPartNumber();
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

    @Then("Verify multicore component data is greater than value {string} for filter {string}")
    public void verifyMulticoreComponentDataIsGreaterThanValueForFilter(String greaterThanValue, String filterName) throws IOException, InterruptedException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("multicore", context.driver);
        List<MulticoreComponentDB> dbData =new MulticoreComponentDBPage(context.driver).getMultiCoreAPIData(response);
        List<MulticoreComponentDB> filteredDbData = new ArrayList<>();
        switch (filterName.toLowerCase()) {
            case "numberofwires":
                int numberOfWiresValue = Integer.parseInt(greaterThanValue);
                filteredDbData = dbData.stream()
                        .filter(x -> x.getNoofwires() >= numberOfWiresValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnNumberOfWiresRange(">= " + greaterThanValue);
                break;
        }
        List<String> actualUniquePartList = new MulticoreComponentDBPage(context.driver).getPartNumber();
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

    @Then("Verify multicore component data on the basis of filter {string} with value {string}")
    public void verifyMulticoreComponentDataOnTheBasisOfFilterRange(String filterName, String filterValue) throws IOException, InterruptedException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("multicore", context.driver);
        List<MulticoreComponentDB> dbData =new MulticoreComponentDBPage(context.driver).getMultiCoreAPIData(response);
        List<MulticoreComponentDB> filteredDbData = new ArrayList<>();
        switch (filterName.toLowerCase()) {
            case "numberofwires":
                String[] numberRange = filterValue.split("-");
                int initialValue = Integer.parseInt(numberRange[0]);
                int finalValue = Integer.parseInt(numberRange[1]);
                filteredDbData = dbData.stream()
                        .filter(x -> x.getNoofwires() >= initialValue)
                        .filter(x -> x.getNoofwires() <= finalValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnNumberOfWiresRange(filterValue);
                break;
        }
        List<String> actualUniquePartList = new MulticoreComponentDBPage(context.driver).getPartNumber();
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

    @Then("verify user can filter applicator based on property {string}")
    public void verifyUserCanFilterApplicatorBasedOnProperty(String propertyName) throws IOException, InterruptedException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("applicator", context.driver);
        List<ApplicatorsComponentDB> dbData =new ApplicatorsComponentDBPage(context.driver).getApplicatorAPIData(response);
        ApplicatorsComponentDB randomApplicatorData = new ApplicatorsComponentDBPage(context.driver).getRandomApplicatorComponent(dbData);
        List<ApplicatorsComponentDB> filteredDbData = new ArrayList<>();
        switch (propertyName.toLowerCase()) {
            case "partnumber":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomApplicatorData.getPartnumber()));
                filteredDbData = dbData.stream().filter(x -> x.getPartnumber().equals(randomApplicatorData.getPartnumber())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnPartNumber(randomApplicatorData.getPartnumber());
                break;
            case "description":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomApplicatorData.getDescription()));
                filteredDbData = dbData.stream().filter(x -> x.getDescription().equals(randomApplicatorData.getDescription())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnDescription(randomApplicatorData.getDescription());
                break;
            case "family":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomApplicatorData.getFamily()));
                filteredDbData = dbData.stream().filter(x -> x.getFamily().equals(randomApplicatorData.getFamily())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnFamily(randomApplicatorData.getFamily());
                break;
            case "status":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomApplicatorData.getStatus()));
                filteredDbData = dbData.stream().filter(x -> x.getStatus().equals(randomApplicatorData.getStatus())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnStatus(randomApplicatorData.getStatus());
                break;
            case "usage":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomApplicatorData.getUsage()));
                filteredDbData = dbData.stream().filter(x -> x.getUsage().equals(randomApplicatorData.getUsage())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnUsage(randomApplicatorData.getUsage());
                break;
            case "supplier":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomApplicatorData.getSupplier()));
                filteredDbData = dbData.stream().filter(x -> x.getSupplier().equals(randomApplicatorData.getSupplier())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplier(randomApplicatorData.getSupplier());
                break;
            case "supplierpn":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomApplicatorData.getSupplierpn()));
                filteredDbData = dbData.stream().filter(x -> x.getSupplierpn().equals(randomApplicatorData.getSupplierpn())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplierPN(randomApplicatorData.getSupplierpn());
                break;
            case "colour":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomApplicatorData.getColour()));
                filteredDbData = dbData.stream().filter(x -> x.getColour().equals(randomApplicatorData.getColour())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnColour(randomApplicatorData.getColour());
                break;
            case "applicatorusage":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomApplicatorData.getApplicatorusage()));
                filteredDbData = dbData.stream().filter(x -> x.getApplicatorusage().equals(randomApplicatorData.getApplicatorusage())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnApplicatorUsage(randomApplicatorData.getApplicatorusage());
                break;
            case "forsealorterminal":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomApplicatorData.getForsealorterminal()));
                filteredDbData = dbData.stream().filter(x -> x.getForsealorterminal().equals(randomApplicatorData.getForsealorterminal())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSealOrTerminal(randomApplicatorData.getForsealorterminal());
                break;
            case "inservice":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomApplicatorData.getApplicatorinservice()));
                filteredDbData = dbData.stream().filter(x -> x.getApplicatorinservice().equals(randomApplicatorData.getApplicatorinservice())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnInService(randomApplicatorData.getApplicatorinservice());
                break;
            case "applicatorsite":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomApplicatorData.getApplicatorsite()));
                filteredDbData = dbData.stream().filter(x -> x.getApplicatorsite().equals(randomApplicatorData.getApplicatorsite())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnApplicatorSite(randomApplicatorData.getApplicatorsite());
                break;
        }
        List<String> actualUniquePartList = new MulticoreComponentDBPage(context.driver).getPartNumber();
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

    //For component type 'component"
    @Then("verify user can filter component based on property {string}")
    public void verifyUserCanFilterComponentBasedOnProperty(String propertyName) throws IOException, InterruptedException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("component", context.driver);
        List<ComponentsDB> dbData =new ComponentsDBPage(context.driver).getComponentAPIData(response);
        ComponentsDB randomComponentData = new ComponentsDBPage(context.driver).getRandomComponent(dbData);
        List<ComponentsDB> filteredDbData = new ArrayList<>();
        switch (propertyName.toLowerCase()) {
            case "partnumber":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomComponentData.getPartnumber()));
                filteredDbData = dbData.stream().filter(x -> x.getPartnumber().equals(randomComponentData.getPartnumber())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnPartNumber(randomComponentData.getPartnumber());
                break;
            case "description":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomComponentData.getDescription()));
                filteredDbData = dbData.stream().filter(x -> x.getDescription().equals(randomComponentData.getDescription())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnDescription(randomComponentData.getDescription());
                break;
            case "family":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomComponentData.getFamily()));
                filteredDbData = dbData.stream().filter(x -> x.getFamily().equals(randomComponentData.getFamily())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnFamily(randomComponentData.getFamily());
                break;
            case "status":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomComponentData.getStatus()));
                filteredDbData = dbData.stream().filter(x -> x.getStatus().equals(randomComponentData.getStatus())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnStatus(randomComponentData.getStatus());
                break;
            case "usage":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomComponentData.getUsage()));
                filteredDbData = dbData.stream().filter(x -> x.getUsage().equals(randomComponentData.getUsage())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnUsage(randomComponentData.getUsage());
                break;
            case "supplier":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomComponentData.getSupplier()));
                filteredDbData = dbData.stream().filter(x -> x.getSupplier().equals(randomComponentData.getSupplier())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplier(randomComponentData.getSupplier());
                break;
            case "supplierpn":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomComponentData.getSupplierpn()));
                filteredDbData = dbData.stream().filter(x -> x.getSupplierpn().equals(randomComponentData.getSupplierpn())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplierPN(randomComponentData.getSupplierpn());
                break;
        }
        List<String> actualUniquePartList = new MulticoreComponentDBPage(context.driver).getPartNumber();
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

    @Then("Verify component data on the basis of filter {string} with value {string}")
    public void verifyComponentDataOnTheBasisOfFilterWithValue(String filterName, String filterValue) throws IOException, InterruptedException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("component", context.driver);
        List<ComponentsDB> dbData =new ComponentsDBPage(context.driver).getComponentAPIData(response);
        List<ComponentsDB> filteredDbData = new ArrayList<>();
        switch (filterName.toLowerCase()) {
            case "numberofcavities":
                String[] numberRange = filterValue.split("-");
                int initialValue = Integer.parseInt(numberRange[0]);
                int finalValue = Integer.parseInt(numberRange[1]);
                filteredDbData = dbData.stream()
                        .filter(x -> x.getNoofcavity() >= initialValue)
                        .filter(x -> x.getNoofcavity() <= finalValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnNumberOfCavitiesRange(filterValue);
                break;
        }
        List<String> actualUniquePartList = new MulticoreComponentDBPage(context.driver).getPartNumber();
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

    @Then("Verify component data is greater than value {string} for filter {string}")
    public void verifyComponentDataIsGreaterThanValue(String greaterThanValue, String filterName) throws IOException, InterruptedException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("component", context.driver);
        List<ComponentsDB> dbData =new ComponentsDBPage(context.driver).getComponentAPIData(response);
        List<ComponentsDB> filteredDbData = new ArrayList<>();
        switch (filterName.toLowerCase()) {
            case "numberofcavities":
                int numberOfCavitiesValue = Integer.parseInt(greaterThanValue);
                filteredDbData = dbData.stream()
                        .filter(x -> x.getNoofcavity() >= numberOfCavitiesValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnNumberOfCavitiesRange(">= " + greaterThanValue);
                break;
        }
        List<String> actualUniquePartList = new MulticoreComponentDBPage(context.driver).getPartNumber();
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

    @Then("verify user can filter seals based on property {string}")
    public void verifyUserCanFilterSealsBasedOnProperty(String propertyName) throws IOException, InterruptedException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("seal", context.driver);
        List<SealsComponentDB> dbData =new SealsComponentDBPage(context.driver).getSealAPIData(response);
        SealsComponentDB randomSealsData = new SealsComponentDBPage(context.driver).getRandomSealsComponent(dbData);
        List<SealsComponentDB> filteredDbData = new ArrayList<>();
        switch (propertyName.toLowerCase()) {
            case "partnumber":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomSealsData.getPartnumber()));
                filteredDbData = dbData.stream().filter(x -> x.getPartnumber().equals(randomSealsData.getPartnumber())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnPartNumber(randomSealsData.getPartnumber());
                break;
            case "description":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomSealsData.getDescription()));
                filteredDbData = dbData.stream().filter(x -> x.getDescription().equals(randomSealsData.getDescription())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnDescription(randomSealsData.getDescription());
                break;
            case "family":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomSealsData.getFamily()));
                filteredDbData = dbData.stream().filter(x -> x.getFamily().equals(randomSealsData.getFamily())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnFamily(randomSealsData.getFamily());
                break;
            case "status":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomSealsData.getStatus()));
                filteredDbData = dbData.stream().filter(x -> x.getStatus().equals(randomSealsData.getStatus())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnStatus(randomSealsData.getStatus());
                break;
            case "usage":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomSealsData.getUsage()));
                filteredDbData = dbData.stream().filter(x -> x.getUsage().equals(randomSealsData.getUsage())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnUsage(randomSealsData.getUsage());
                break;
            case "supplier":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomSealsData.getSupplier()));
                filteredDbData = dbData.stream().filter(x -> x.getSupplier().equals(randomSealsData.getSupplier())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplier(randomSealsData.getSupplier());
                break;
            case "supplierpn":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomSealsData.getSupplierpn()));
                filteredDbData = dbData.stream().filter(x -> x.getSupplierpn().equals(randomSealsData.getSupplierpn())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplierPN(randomSealsData.getSupplierpn());
                break;
            case "colour":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomSealsData.getColour()));
                filteredDbData = dbData.stream().filter(x -> x.getColour().equals(randomSealsData.getColour())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnColour(randomSealsData.getColour());
                break;
            case "cavityplug":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomSealsData.getCavityplug()));
                filteredDbData = dbData.stream().filter(x -> x.getCavityplug().equals(randomSealsData.getCavityplug())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnCavity(randomSealsData.getCavityplug());
                break;
            case "insulationod":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomSealsData.getInsulationod()));
                filteredDbData = dbData.stream().filter(x -> x.getInsulationod().equals(randomSealsData.getInsulationod())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnInsulationOD(randomSealsData.getInsulationod());
                break;
        }
        List<String> actualUniquePartList = new MulticoreComponentDBPage(context.driver).getPartNumber();
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

    @And("User links {string} from componentDB")
    public void userLinksComponentFromComponentDB(String componentName) throws AWTException, InterruptedException {
        switch (componentName.toLowerCase()) {
            case "terminal":
                new HeaderPanel(context.driver).invokeFormTabs("Link_Terminals");
                new CommonElements(context.driver).loadDataFromDB();
                break;
            case "seal":
                new HeaderPanel(context.driver).invokeFormTabs("Link_Seals");
                new CommonElements(context.driver).loadDataFromDB();
                break;
            case "mating_halves":
                new HeaderPanel(context.driver).invokeFormTabs("Mating_Halves");
                new CommonElements(context.driver).loadDataFromDB();
                break;
            case "part":
                new HeaderPanel(context.driver).invokeFormTabs("Link_Parts");
                new CommonElements(context.driver).loadDataFromDB();
                break;
            case "cavity":
                new HeaderPanel(context.driver).invokeFormTabs("Cavity_Seal");
                new CommonElements(context.driver).enterLinkCavityPlug();
                break;
            case "applicator":
                new HeaderPanel(context.driver).invokeFormTabs("Applicator");
                new CommonElements(context.driver).loadDataFromDB();
                break;
            case "equivalents":
                new HeaderPanel(context.driver).invokeFormTabs("Equivalents");
                new CommonElements(context.driver).loadDataFromDB();
                break;
            case "tags":
                new HeaderPanel(context.driver).invokeFormTabs("Tags");
                new CommonElements(context.driver).enterTag();
                break;
            case "splice":
                new HeaderPanel(context.driver).invokeFormTabs("Splice");
                new CommonElements(context.driver).enterSpliceDetails();
                break;
            case "nwf":
                new HeaderPanel(context.driver).invokeFormTabs("NWF");
                new CommonElements(context.driver).enterNWFDetails();
                break;
            case "connectors":
                new HeaderPanel(context.driver).invokeFormTabs("Link_Connectors");
                new CommonElements(context.driver).loadDataFromDB();
                break;
        }
        new CommonElements(context.driver).clickUpdateComponent();
        new CommonElements(context.driver).verifyAlertSuccessMessage("Component updated");
    }

    //We are not using below step now due to changed approach in extraction of data.
    @Given("{string} details are extracted successfully")
    public void details_are_extracted_successfully(String componentName) throws IOException, InterruptedException {
        File file;
        switch (componentName.toLowerCase()) {
            case "connector":
                break;
            case "multicore":
                break;
            case "splice":
                break;
            case "junctionpart":
                break;
            case "component":
                break;
            case "otherpart":
                break;
        }
    }


    @Then("verify user can filter connector based on property {string}")
    public void verifyUserCanFilterConnectorBasedOnProperty(String propertyName) throws IOException, InterruptedException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("connector", context.driver);
        List<ConnectorDB> dbData =new ConnectorsDBPage(context.driver).getConnectorsAPIData(response);
        ConnectorDB randomConnectorData = new ConnectorsDBPage(context.driver).getRandomConnectorComponent(dbData);
        List<ConnectorDB> filteredDbData = new ArrayList<>();
        switch (propertyName.toLowerCase()) {
            case "partnumber":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomConnectorData.getPartnumber()));
                filteredDbData = dbData.stream().filter(x -> x.getPartnumber().equals(randomConnectorData.getPartnumber())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnPartNumber(randomConnectorData.getPartnumber());
                break;
            case "description":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomConnectorData.getDescription()));
                filteredDbData = dbData.stream().filter(x -> x.getDescription().equals(randomConnectorData.getDescription())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnDescription(randomConnectorData.getDescription());
                break;
            case "family":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomConnectorData.getFamily()));
                filteredDbData = dbData.stream().filter(x -> x.getFamily().equals(randomConnectorData.getFamily())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnFamily(randomConnectorData.getFamily());
                break;
            case "status":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomConnectorData.getStatus()));
                filteredDbData = dbData.stream().filter(x -> x.getStatus().equals(randomConnectorData.getStatus())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnStatus(randomConnectorData.getStatus());
                break;
            case "usage":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomConnectorData.getUsage()));
                filteredDbData = dbData.stream().filter(x -> x.getUsage().equals(randomConnectorData.getUsage())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnUsage(randomConnectorData.getUsage());
                break;
            case "supplier":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomConnectorData.getSupplier()));
                filteredDbData = dbData.stream().filter(x -> x.getSupplier().equals(randomConnectorData.getSupplier())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplier(randomConnectorData.getSupplier());
                break;
            case "supplierpn":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomConnectorData.getSupplierpn()));
                filteredDbData = dbData.stream().filter(x -> x.getSupplierpn().equals(randomConnectorData.getSupplierpn())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplierPN(randomConnectorData.getSupplierpn());
                break;
            case "colour":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomConnectorData.getColour()));
                filteredDbData = dbData.stream().filter(x -> x.getColour().equals(randomConnectorData.getColour())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnColour(randomConnectorData.getColour());
                break;
            case "housinggender":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomConnectorData.getHousingGender()));
                filteredDbData = dbData.stream().filter(x -> x.getHousingGender().equals(randomConnectorData.getHousingGender())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnHousingGender(randomConnectorData.getHousingGender());
                break;
            case "terminalgender":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomConnectorData.getGender()));
                filteredDbData = dbData.stream().filter(x -> x.getGender().equals(randomConnectorData.getGender())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnGender(randomConnectorData.getGender());
                break;
            case "connectortype":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomConnectorData.getTtype()));
                filteredDbData = dbData.stream().filter(x -> x.getTtype().equals(randomConnectorData.getTtype())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnConnectorType(randomConnectorData.getTtype());
                break;
            case "keyway":
                ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s", randomConnectorData.getKeyway()));
                filteredDbData = dbData.stream().filter(x -> x.getKeyway().equals(randomConnectorData.getKeyway())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnKeyway(randomConnectorData.getKeyway());
                break;
        }
        List<String> actualUniquePartList = new MulticoreComponentDBPage(context.driver).getPartNumber();
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

    @Then("Verify connector data on the basis of filter {string} with value {string}")
    public void verifyConnectorDataOnTheBasisOfFilterRange(String filterName, String filterValue) throws IOException, InterruptedException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("connector", context.driver);
        List<ConnectorDB> dbData =new ConnectorsDBPage(context.driver).getConnectorsAPIData(response);
        List<ConnectorDB> filteredDbData = new ArrayList<>();
        switch (filterName.toLowerCase()) {
            case "numberofcavities":
                String[] numberRange = filterValue.split("-");
                int initialValue = Integer.parseInt(numberRange[0]);
                int finalValue = Integer.parseInt(numberRange[1]);
                filteredDbData = dbData.stream()
                        .filter(x -> x.getNoofcavity() >= initialValue)
                        .filter(x -> x.getNoofcavity() <= finalValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnNumberOfCavitiesRange(filterValue);
                break;
        }
        List<String> actualUniquePartList = new MulticoreComponentDBPage(context.driver).getPartNumber();
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

    @Then("Verify connector component data is greater than value {string} for filter {string}")
    public void verifyConnectorComponentDataIsGreaterThanValueForFilter(String greaterThanValue, String filterName) throws IOException, InterruptedException {
        System.out.println("Getting data from API");
        RestAssuredUtility rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("connector", context.driver);
        List<ConnectorDB> dbData =new ConnectorsDBPage(context.driver).getConnectorsAPIData(response);
        List<ConnectorDB> filteredDbData = new ArrayList<>();
        switch (filterName.toLowerCase()) {
            case "numberofcavities":
                int numberOfCavitiesValue = Integer.parseInt(greaterThanValue);
                filteredDbData = dbData.stream()
                        .filter(x -> x.getNoofcavity() >= numberOfCavitiesValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnNumberOfCavitiesRange(">= " + greaterThanValue);
                break;
        }
        List<String> actualUniquePartList = new MulticoreComponentDBPage(context.driver).getPartNumber();
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

    @And("{string} macros tags are extracted successfully")
    public void macrosTagsAreExtractedSuccessfully(String componentName) throws IOException {
        File file;
        switch (componentName.toLowerCase()) {
            case "wire":
                file = new File("src/test/resources/macros/Wire/WireMacrosData.json");
                if (!file.exists()) {
                    WireTags macrosData = new GeneralMacrosPage(context.driver).getWiresTagData();
                    ObjectMapper mapper = new ObjectMapper();
                    Files.createDirectories(Paths.get("src/test/resources/macros/Wire"));
                    mapper.writeValue(new File("src/test/resources/macros/Wire/WireMacrosData.json"), macrosData);
                }
                break;
            case "custom label":
                file = new File("src/test/resources/macros/CustomLabel/CustomLabelData.json");
                if (!file.exists()) {
                    CustomLabelTags macrosData = new GeneralMacrosPage(context.driver).getCustomLabelTagsData();
                    ObjectMapper mapper = new ObjectMapper();
                    Files.createDirectories(Paths.get("src/test/resources/macros/CustomLabel"));
                    mapper.writeValue(new File("src/test/resources/macros/CustomLabel/CustomLabelData.json"), macrosData);
                }
                break;
        }
    }

    @And("User export the data for {string}")
    public void userExportTheDataForApplicator(String componentName)
    {
        new CommonElements(context.driver).exportComponentsData();
    }

    @And("User create new DB with name {string}")
    public void userCreateNewDBWithNameTestDB(String dbName) {
        dbName=dbName.toLowerCase(Locale.ROOT)+new StringHelper().generateRandomDigit();
        FlowContext.dbName=dbName;
        new CommonElements(context.driver).createNewComponentDB(dbName);
    }

    @And("User navigated to componentDB")
    public void userNavigatedToComponentDB()
    {
        new CommonElements(context.driver).navigateHome();
        new CommonElements(context.driver).openComponentDB();

    }

    @And("User import data for {string}")
    public void userImportDataForConnector(String component) throws InterruptedException {
        new CommonElements(context.driver).clickImportButton(component);
        new CommonElements(context.driver).importDB(component);
    }

    @And("User delete the new DB created")
    public void userDeleteTheNewDBWithNameTestDB()
    {
        new CommonElements(context.driver).deleteComponentDB(FlowContext.dbName);
    }

    @And("User delete all old files from the default download folder")
    public void userDeleteAllOldFilesFromTheDefaultDownloadFolder() throws IOException {
       String path=System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles";
        File file = new File(path);
        if(file.exists()){
            FileUtils.cleanDirectory(file);
        }
    }

    @And("custom label macros tags are updated with {string}")
    public void customLabelMacrosTagsAreUpdated(String valueType) throws IOException, InterruptedException {
        String labelValue="";
        switch (valueType.toLowerCase()) {
            case "customvalues":
                labelValue = "@@ConnectorID#\n@@Functional Description#";
                break;
            case "initialvalues":
                File file = new File("src/test/resources/macros/CustomLabel/CustomLabelData.json");
                CustomLabelTags dbMacrosData = null;
                if (file.exists()) {
                    ObjectMapper mapper = new ObjectMapper();
                    dbMacrosData = mapper.readValue(new File("src/test/resources/macros/CustomLabel/CustomLabelData.json"), new TypeReference<CustomLabelTags>() {
                    });
                    labelValue = dbMacrosData.getTagconnectorSpliceLabel();
                }
        }
        Thread.sleep(2000);
        new GeneralMacrosPage(context.driver).enterCustomLabelTags(labelValue);
        new GeneralMacrosPage(context.driver).clickSaveButton();
        new GeneralMacrosPage(context.driver).verifyAlertMacrosSuccessMessage("Macros updated successfully");
    }

    @And("Created DB {string}")
    public void createdDB(String dbName) throws InterruptedException {
        if (!new ComponentDBHomePage(context.driver).checkDBExists(dbName)){
            new ComponentDBHomePage(context.driver).cloneComponentDB(System.getProperty("componentDB"),dbName);
            new AddNewComponentPage(context.driver).verifyAlertMessage("Component Database Cloned Successfully");
            new AddNewComponentPage(context.driver).closeAlertPopUp();
        }
    }
}