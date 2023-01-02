package arcadia.stepdefinations;

import arcadia.context.FlowContext;
import arcadia.context.TestContext;
import arcadia.domainobjects.*;
import arcadia.pages.ComponentDB.AddNewComponentPage;
import arcadia.pages.ComponentDB.Applicators.ApplicatorsComponentDBPage;
import arcadia.pages.ComponentDB.CommonElements;
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
import arcadia.utils.StringHelper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComponentDBStepDefinitions {
    private final TestContext context;
    public ComponentDBStepDefinitions(TestContext context) {
        this.context = context;
    }

    @Then("{string} component with status {string} is created successfully")
    public void component_with_status_is_created_successfully(String componentName, String componentStatus) throws InterruptedException {
        AddComponentForm addComponentForm=null;
        ComponentDetails componentDetails=null;
        List<AdditionalReferences> additionalReferencesList = null;
        AdditionalReferences additionalReferences1=null;
        BomDetails bomDetails=null;
        switch(componentName.toLowerCase()) {
            case "wire":
                new HeaderPanel(context.driver).openAddNewComponentPage();
                addComponentForm = new AddComponentForm();
                componentDetails = new ComponentDetails(String.format("testdescription-%04d", new StringHelper().generateRandomDigit()), "testfamily", componentStatus, "", "testproprietary", "", "BLACK", "BLUE", "BROWN", "PVC", "NOT SET", "", "");
                addComponentForm.setComponentDetails(componentDetails);
                break;
            case "seal":
            case "terminal":
            case "splice":
            case "otherpart":
            case "junctionpart":
            case "multicore":
            case "applicator":
            case "component":
            case "connector":
                new HeaderPanel(context.driver).openAddNewComponentPage();
                addComponentForm = new AddComponentForm();
                componentDetails = new ComponentDetails(String.format("testdescription-%04d", new StringHelper().generateRandomDigit()), "testfamily", componentStatus, "", "testproprietary", "", "", "", "", "PVC", "NOT SET", "", "BLACK");
                addComponentForm.setComponentDetails(componentDetails);
                break;
        }
                additionalReferencesList = new ArrayList<>();
                String referencesPartNumber = String.valueOf(new StringHelper().generateRandomDigit());
                FlowContext.referencesPartNumber = referencesPartNumber;
                additionalReferences1 = new AdditionalReferences(referencesPartNumber,"Manufacturer","testcompany");
                additionalReferencesList.add(additionalReferences1);
                addComponentForm.setAdditionalReferences(additionalReferencesList);
                bomDetails = new BomDetails(0.0022,"","EACH","GBP","gm","INCLUDED");
                addComponentForm.setBomDetails(bomDetails);
                new AddNewComponentPage(context.driver).createComponent(addComponentForm,componentName);
                new AddNewComponentPage(context.driver).submitComponentDetails();
                Thread.sleep(1000);

    }

    @Then("{string} component with billtype {string} is created successfully")
    public void component_with_billtype_is_created_successfully(String componentName, String componentBomBillType) throws InterruptedException {
        AddComponentForm addComponentForm=null;
        ComponentDetails componentDetails=null;
        List<AdditionalReferences> additionalReferencesList = null;
        AdditionalReferences additionalReferences1=null;
        BomDetails bomDetails=null;
        switch(componentName.toLowerCase()) {
            case "wire":
                new HeaderPanel(context.driver).openAddNewComponentPage();
                addComponentForm = new AddComponentForm();
                componentDetails = new ComponentDetails(String.format("testdescription-%04d", new StringHelper().generateRandomDigit()), "testfamily", "IN REVIEW", "", "testproprietary", "", "BLACK", "BLUE", "BROWN", "PVC", "NOT SET", "", "");
                addComponentForm.setComponentDetails(componentDetails);
                break;
            case "seal":
            case "terminal":
            case "splice":
            case "otherpart":
            case "junctionpart":
            case "multicore":
            case "applicator":
            case "component":
            case "connector":
                new HeaderPanel(context.driver).openAddNewComponentPage();
                addComponentForm = new AddComponentForm();
                componentDetails = new ComponentDetails(String.format("testdescription-%04d", new StringHelper().generateRandomDigit()), "testfamily", "IN REVIEW", "", "testproprietary", "", "", "", "", "PVC", "NOT SET", "", "BLACK");
                addComponentForm.setComponentDetails(componentDetails);
                break;
        }
                additionalReferencesList = new ArrayList<>();
                additionalReferences1 = new AdditionalReferences(String.valueOf(new StringHelper().generateRandomDigit()),"Manufacturer","testcompany");
                additionalReferencesList.add(additionalReferences1);
                addComponentForm.setAdditionalReferences(additionalReferencesList);
                bomDetails = new BomDetails(0.0022,"","EACH","GBP","gm",componentBomBillType);
                addComponentForm.setBomDetails(bomDetails);
                new AddNewComponentPage(context.driver).createComponent(addComponentForm,componentName);
                new AddNewComponentPage(context.driver).submitComponentDetails();
                Thread.sleep(1000);
    }

    @Then("{string} component with referencepartnumber {string} and referencecompany {string} only is created")
    public void component_with_reference_details_is_created(String componentName, String partNumber, String referencecompany) throws InterruptedException {
        new HeaderPanel(context.driver).openAddNewComponentPage();
        if(componentName.equalsIgnoreCase("wire")||componentName.equalsIgnoreCase("seal")||componentName.equalsIgnoreCase("terminal")||componentName.equalsIgnoreCase("splice")||componentName.equalsIgnoreCase("otherpart")||componentName.equalsIgnoreCase("junctionpart")||componentName.equalsIgnoreCase("multicore")||componentName.equalsIgnoreCase("applicator")||componentName.equalsIgnoreCase("component"))
        {
            componentName="common";
        }
        else{
            componentName="unique";
        }
        AddComponentForm addComponentForm = null;
        switch(componentName.toLowerCase()) {
            case "common":
                addComponentForm = new AddComponentForm();
                if(!String.valueOf(partNumber).isEmpty()){
                    partNumber = String.valueOf(new StringHelper().generateRandomDigit());
                }
                List<AdditionalReferences> additionalReferencesList = new ArrayList<>();
                AdditionalReferences additionalReferences1 = new AdditionalReferences(partNumber,"",referencecompany);
                additionalReferencesList.add(additionalReferences1);
                addComponentForm.setAdditionalReferences(additionalReferencesList);
                new AddNewComponentPage(context.driver).createComponentWithMandatoryDetailsOnly(addComponentForm);
                new AddNewComponentPage(context.driver).submitComponentDetails();
                Thread.sleep(1000);
                break;
        }
    }

    @Then("Verify error message is displayed for mandatory field {string} for component {string}")
    public void error_message_is_displayed_for_mandatory_field(String fieldName, String componentName) throws InterruptedException {
        //ToDo the error messages needs to be moved to a separate file
        String errorMessage="";
        switch(fieldName.toLowerCase()) {
            case "referencepartnumber":
                errorMessage = "Enter Part Number";
                break;
            case "referencecompany":
                errorMessage = "Enter Company";
                break;
        }
        new AddNewComponentPage(context.driver).verifyAlertMessage(errorMessage);
        new AddNewComponentPage(context.driver).closeAlertPopUp();
    }

    @Then("{string} component with additionalreferencetype {string} is created successfully")
    public void component_with_additionalreferencetype_is_created_successfully(String componentName, String additionalRefernceType) throws InterruptedException {
        AddComponentForm addComponentForm=null;
        ComponentDetails componentDetails=null;
        List<AdditionalReferences> additionalReferencesList = null;
        AdditionalReferences additionalReferences1=null;
        BomDetails bomDetails=null;
        switch(componentName.toLowerCase()) {
            case "wire":
                new HeaderPanel(context.driver).openAddNewComponentPage();
                addComponentForm = new AddComponentForm();
                componentDetails = new ComponentDetails(String.format("testdescription-%04d", new StringHelper().generateRandomDigit()), "testfamily", "IN REVIEW", "", "testproprietary", "", "BLACK", "BLUE", "BROWN", "PVC", "NOT SET", "", "");
                addComponentForm.setComponentDetails(componentDetails);
                break;
            case "seal":
            case "terminal":
            case "splice":
            case "otherpart":
            case "junctionpart":
            case "multicore":
            case "applicator":
            case "component":
            case "connector":
                new HeaderPanel(context.driver).openAddNewComponentPage();
                addComponentForm = new AddComponentForm();
                componentDetails = new ComponentDetails(String.format("testdescription-%04d", new StringHelper().generateRandomDigit()), "testfamily", "IN REVIEW", "", "testproprietary", "", "", "", "", "PVC", "NOT SET", "", "BLACK");
                addComponentForm.setComponentDetails(componentDetails);
                break;
        }
                bomDetails = new BomDetails(0.0022,"","EACH","GBP","gm","INCLUDED");
                addComponentForm.setBomDetails(bomDetails);
                additionalReferencesList = new ArrayList<>();
                String[] arrayOfRefrenceType = additionalRefernceType.split(",");
                for(String refType: arrayOfRefrenceType){
                    AdditionalReferences additionalReferences = new AdditionalReferences(String.valueOf(new StringHelper().generateRandomDigit()),refType,"testcompany");
                    additionalReferencesList.add(additionalReferences);
                }
                addComponentForm.setAdditionalReferences(additionalReferencesList);
                new AddNewComponentPage(context.driver).createComponent(addComponentForm,componentName);
                new AddNewComponentPage(context.driver).submitComponentDetails();
                Thread.sleep(1000);
    }

    @Then("verify user can apply filter based on property {string}")
    public void verify_user_can_apply_filter_based_on_property(String propertyName) throws InterruptedException, IOException {
        File f = new File("src/test/resources/componentDB/Wire/WireData.json");
        List<WiresComponentDB> dbData = null;
        if(f.exists()) {
            System.out.println("Resuse JSON");
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/Wire/WireData.json"), new TypeReference<List<WiresComponentDB>>(){});
        }
        if(!f.exists()) {
            System.out.println("Scanning UI");
            dbData=  new WiresComponentDBPage(context.driver).getWiresData();
            ObjectMapper mapper = new ObjectMapper();
            Files.createDirectories(Paths.get("src/test/resources/componentDB/Wire"));
            mapper.writeValue(new File("src/test/resources/componentDB/Wire/WireData.json"), dbData);
        }
        WiresComponentDB randomData = new WiresComponentDBPage(context.driver).getRandomWireComponent(dbData);
        List<WiresComponentDB> filteredDbData = new ArrayList<>();
        switch(propertyName.toLowerCase()) {
            case "status":
                filteredDbData = dbData.stream().filter(x->x.getStatus().equals(randomData.getStatus())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnStatus(randomData.getStatus());
                break;
            case "partnumber":
                filteredDbData = dbData.stream().filter(x->x.getPartNumber().equals(randomData.getPartNumber())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnPartNumber(randomData.getPartNumber());
                break;
            case "description":
                filteredDbData = dbData.stream().filter(x->x.getDescription().equals(randomData.getDescription())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnDescription(randomData.getDescription());
                break;
            case "family":
                filteredDbData = dbData.stream().filter(x->x.getFamily().equals(randomData.getFamily())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnFamily(randomData.getFamily());
                break;
            case "usage":
                filteredDbData = dbData.stream().filter(x->x.getUsage().equals(randomData.getUsage())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnUsage(randomData.getUsage());
                break;
            case "supplier":
                filteredDbData = dbData.stream().filter(x->x.getSupplier().equals(randomData.getSupplier())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplier(randomData.getSupplier());
                break;
            case "supplierpn":
                filteredDbData = dbData.stream().filter(x->x.getSupplierPN().equals(randomData.getSupplierPN())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplierPN(randomData.getSupplierPN());
                break;
            case "colour":
                filteredDbData = dbData.stream().filter(x->x.getColour().equals(randomData.getColour())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnColour(randomData.getColour());
                break;
            case "awgsize":
                filteredDbData = dbData.stream().filter(x->x.getAwgSize().equals(randomData.getAwgSize())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnAwgSize(randomData.getAwgSize());
                break;
            case "gauge":
                filteredDbData = dbData.stream()
                        .filter(x->x.getGauge().equals(randomData.getGauge()))
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnGauge(randomData.getGauge());
                break;
            case "material":
                filteredDbData = dbData.stream().filter(x->x.getMaterial().equals(randomData.getMaterial())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnMaterial(randomData.getMaterial());
                break;
        }
        List<WiresComponentDB> wiresData = new WiresComponentDBPage(context.driver).getWiresData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> actualPartNumberList = wiresData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> differencesFromExpected = expectedPartNumberList.stream()
                .filter(element -> !actualPartNumberList.contains(element))
                .collect(Collectors.toList());
        Assert.assertEquals(0,differencesFromExpected.size(),differencesFromExpected.toString());
    }

    @Then("Verify wire component data is greater than value {string} for filter {string}")
    public void verify_component_data_is_greater_than_value_for_filter(String greaterThanValue, String filterName) throws IOException, InterruptedException {
        File f = new File("src/test/resources/componentDB/Wire/WireData.json");
        List<WiresComponentDB> dbData = null;
        if(f.exists()) {
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/Wire/WireData.json"), new TypeReference<List<WiresComponentDB>>(){});
        }
        if(!f.exists()) {
            dbData=  new WiresComponentDBPage(context.driver).getWiresData();
            ObjectMapper mapper = new ObjectMapper();
            Files.createDirectories(Paths.get("src/test/resources/componentDB/Wire"));
            mapper.writeValue(new File("src/test/resources/componentDB/Wire/WireData.json"), dbData);
        }
        List<WiresComponentDB> filteredDbData = new ArrayList<>();
        switch(filterName.toLowerCase()) {
            case "wirecsa":
                Double csaValue = Double.valueOf(greaterThanValue);
                filteredDbData = dbData.stream()
                        .filter(x->x.getWireCSA()>=csaValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnCSARange(">="+greaterThanValue);
                break;
            case "outsidedia":
                Double outsidedia = Double.valueOf(greaterThanValue);
                filteredDbData = dbData.stream()
                        .filter(x->x.getOutsideDia()>=outsidedia)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnCSARange(">="+greaterThanValue);
                break;
            case "minimumbendradius":
                Double minimumbendradiusValue = Double.valueOf(greaterThanValue);
                filteredDbData = dbData.stream()
                        .filter(x->x.getMinimumRadius()>=minimumbendradiusValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnCSARange(">="+greaterThanValue);
                break;
            case "maxcurrent":
                Double maxCurrentValue = Double.valueOf(greaterThanValue);
                filteredDbData = dbData.stream()
                        .filter(x->x.getMaxcurrent()>=maxCurrentValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnCSARange(">="+greaterThanValue);
                break;
            case "resistance":
                Double resistanceValue = Double.valueOf(greaterThanValue);
                filteredDbData = dbData.stream()
                        .filter(x->x.getResistance()>=resistanceValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnCSARange(">="+greaterThanValue);
                break;
        }
        List<WiresComponentDB> wiresData = new WiresComponentDBPage(context.driver).getWiresData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> actualPartNumberList = wiresData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> differencesFromExpected = expectedPartNumberList.stream()
                .filter(element -> !actualPartNumberList.contains(element))
                .collect(Collectors.toList());
        Assert.assertEquals(0,differencesFromExpected.size(),differencesFromExpected.toString());
    }

    @Then("Verify wire component data on the basis of filter {string} with value {string}")
    public void verify_wire_component_data_on_the_basis_of_filter(String filterName, String filterValue) throws InterruptedException, IOException {
        File f = new File("src/test/resources/componentDB/Wire/WireData.json");
        List<WiresComponentDB> dbData = null;
        if(f.exists()) {
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/Wire/WireData.json"), new TypeReference<List<WiresComponentDB>>(){});
        }
        if(!f.exists()) {
            dbData=  new WiresComponentDBPage(context.driver).getWiresData();
            ObjectMapper mapper = new ObjectMapper();
            Files.createDirectories(Paths.get("src/test/resources/componentDB/Wire"));
            mapper.writeValue(new File("src/test/resources/componentDB/Wire/WireData.json"), dbData);
        }
        List<WiresComponentDB> filteredDbData = new ArrayList<>();
        switch(filterName.toLowerCase()) {
            case "wirecsa":
                String[] csaRange = filterValue.split("-");
                Double initialCSAValue = Double.valueOf(csaRange[0]);
                Double finalCSAValue = Double.valueOf(csaRange[1]);
                filteredDbData = dbData.stream()
                        .filter(x->x.getWireCSA()>=initialCSAValue)
                        .filter(x->x.getWireCSA()<=finalCSAValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnCSARange(filterValue);
                break;
            case "outsidedia":
                String[] outDiaRange = filterValue.split("-");
                Double initialDiaValue = Double.valueOf(outDiaRange[0]);
                Double finalDiaValue = Double.valueOf(outDiaRange[1]);
                filteredDbData = dbData.stream()
                        .filter(x->x.getOutsideDia()>=initialDiaValue)
                        .filter(x->x.getOutsideDia()<=finalDiaValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnOutsideDiaRange(filterValue);
                break;
                case "minimumbendradius":
                String[] bendRadiusRange = filterValue.split("-");
                Double initialRadiusValue = Double.valueOf(bendRadiusRange[0]);
                Double finalRadiusValue = Double.valueOf(bendRadiusRange[1]);
                filteredDbData = dbData.stream()
                        .filter(x->x.getMinimumRadius()>=initialRadiusValue)
                        .filter(x->x.getMinimumRadius()<=finalRadiusValue)
                        .collect(Collectors.toList());
                    new CommonElements(context.driver).filterComponentBasedOnMinimumBendRadiusRange(filterValue);
                break;
            case "maxcurrent":
                String[] currentRange = filterValue.split("-");
                Double initialCurrentValue = Double.valueOf(currentRange[0]);
                Double finalCurrentValue = Double.valueOf(currentRange[1]);
                filteredDbData = dbData.stream()
                        .filter(x->x.getMaxcurrent()>=initialCurrentValue)
                        .filter(x->x.getMaxcurrent()<=finalCurrentValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnMaxCurrentRange(filterValue);
                break;
            case "resistance":
                String[] resistanceRange = filterValue.split("-");
                Double initialResistanceValue = Double.valueOf(resistanceRange[0]);
                Double finalResistanceValue = Double.valueOf(resistanceRange[1]);
                filteredDbData = dbData.stream()
                        .filter(x->x.getResistance()>=initialResistanceValue)
                        .filter(x->x.getResistance()<=finalResistanceValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnResistanceRange(filterValue);
                break;
        }
        List<WiresComponentDB> wiresData = new WiresComponentDBPage(context.driver).getWiresData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> actualPartNumberList = wiresData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> differencesFromExpected = expectedPartNumberList.stream()
                .filter(element -> !actualPartNumberList.contains(element))
                .collect(Collectors.toList());
        Assert.assertEquals(0,differencesFromExpected.size(),differencesFromExpected.toString());
    }

    @And("User searches {string} component using {string}")
    public void userSearchesComponent(String componentName, String searchType) throws InterruptedException {
        switch (searchType.toLowerCase()){
            case "partnumber" :
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
        String newPartNumber = String.valueOf(new StringHelper().generateRandomDigit());
        FlowContext.referencesPartNumber = newPartNumber;
        new CommonElements(context.driver).enterNewPartNumber(newPartNumber);
        new CommonElements(context.driver).clickAddSimilarOnPopup();
        new AddNewComponentPage(context.driver).verifyAlertMessage("Component added successfully");
        new AddNewComponentPage(context.driver).closeAlertPopUp();
    }

    @Then("User verified the component {string} is added successfully")
    public void userVerifiedTheComponentIsAddedSuccessfully(String componentName) throws InterruptedException {
        switch (componentName.toLowerCase()){
            case "wire":
                List<WiresComponentDB> wiresdatalist = new WiresComponentDBPage(context.driver).getWiresData();
                Assert.assertTrue(wiresdatalist.size()!=0);
                Assert.assertEquals(FlowContext.referencesPartNumber,wiresdatalist.get(0).getPartNumber());
                break;
            case "terminal":
                List<TerminalsComponentDB> terminalsdatalist = new TerminalsComponentDBPage(context.driver).getTerminalsData();
                Assert.assertTrue(terminalsdatalist.size()!=0);
                Assert.assertEquals(FlowContext.referencesPartNumber,terminalsdatalist.get(0).getPartNumber());
                break;
            case "splice":
                List<SplicesComponentDB> splicesdatalist = new SplicesComponentDBPage(context.driver).getSplicesData();
                Assert.assertTrue(splicesdatalist.size()!=0);
                Assert.assertEquals(FlowContext.referencesPartNumber,splicesdatalist.get(0).getPartNumber());
                break;
            case "otherpart":
                List<OtherPartsComponentDB> otherpartsdatalist = new OtherPartsComponentDBPage(context.driver).getOtherPartsData();
                Assert.assertTrue(otherpartsdatalist.size()!=0);
                Assert.assertEquals(FlowContext.referencesPartNumber,otherpartsdatalist.get(0).getPartNumber());
                break;
            case "junctionpart":
                List<JunctionPartComponentDB> junctionpartdatalist = new JunctionPartsComponentDBPage(context.driver).getJunctionPartsData();
                Assert.assertTrue(junctionpartdatalist.size()!=0);
                Assert.assertEquals(FlowContext.referencesPartNumber,junctionpartdatalist.get(0).getPartNumber());
                break;
            case "multicore":
                List<MulticoreComponentDB> multicoredatalist = new MulticoreComponentDBPage(context.driver).getMulticoreData();
                Assert.assertTrue(multicoredatalist.size()!=0);
                Assert.assertEquals(FlowContext.referencesPartNumber,multicoredatalist.get(0).getPartNumber());
                break;
            case "applicator":
                List<ApplicatorsComponentDB> applicatorsdatalist = new ApplicatorsComponentDBPage(context.driver).getApplicatorsData();
                Assert.assertTrue(applicatorsdatalist.size()!=0);
                Assert.assertEquals(FlowContext.referencesPartNumber,applicatorsdatalist.get(0).getPartNumber());
                break;
            case "component":
                List<ComponentsDB> componentsdatalist = new ComponentsDBPage(context.driver).getComponentsData();
                Assert.assertTrue(componentsdatalist.size()!=0);
                Assert.assertEquals(FlowContext.referencesPartNumber,componentsdatalist.get(0).getPartNumber());
                break;
            case "connector":
                List<ConnectorDB> connectorsdatalist = new ConnectorsDBPage(context.driver).getConnectorsData();
                Assert.assertTrue(connectorsdatalist.size()!=0);
                Assert.assertEquals(FlowContext.referencesPartNumber,connectorsdatalist.get(0).getPartNumber());
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
        new AddNewComponentPage(context.driver).verifyTotalComponentCopiedCount(componentType,"1");
    }

    @Then("verify user can filter terminal based on property {string}")
    public void verifyUserCanFilterTerminalComponentBasedOnProperty(String propertyName) throws InterruptedException, IOException {
        File f = new File("src/test/resources/componentDB/Terminals/TerminalData.json");
        List<TerminalsComponentDB> dbData = null;
        if(f.exists()) {
            System.out.println("Resuse JSON");
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/Terminals/TerminalData.json"), new TypeReference<List<TerminalsComponentDB>>(){});
        }
        if(!f.exists()) {
            System.out.println("Scanning UI");
            dbData=  new TerminalsComponentDBPage(context.driver).getTerminalsData();
            ObjectMapper mapper = new ObjectMapper();
            Files.createDirectories(Paths.get("src/test/resources/componentDB/Terminals"));
            mapper.writeValue(new File("src/test/resources/componentDB/Terminals/TerminalData.json"), dbData);
        }
        TerminalsComponentDB randomTerminalData = new TerminalsComponentDBPage(context.driver).getRandomTerminalComponent(dbData);
        List<TerminalsComponentDB> filteredDbData = new ArrayList<>();
        switch(propertyName.toLowerCase()) {
            case "status":
                filteredDbData = dbData.stream().filter(x->x.getStatus().equals(randomTerminalData.getStatus())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnStatus(randomTerminalData.getStatus());
                break;
            case "partnumber":
                filteredDbData = dbData.stream().filter(x->x.getPartNumber().equals(randomTerminalData.getPartNumber())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnPartNumber(randomTerminalData.getPartNumber());
                break;
            case "description":
                filteredDbData = dbData.stream().filter(x->x.getDescription().equals(randomTerminalData.getDescription())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnDescription(randomTerminalData.getDescription());
                break;
            case "family":
                filteredDbData = dbData.stream().filter(x->x.getFamily().equals(randomTerminalData.getFamily())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnFamily(randomTerminalData.getFamily());
                break;
            case "usage":
                filteredDbData = dbData.stream().filter(x->x.getUsage().equals(randomTerminalData.getUsage())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnUsage(randomTerminalData.getUsage());
                break;
            case "supplier":
                filteredDbData = dbData.stream().filter(x->x.getSupplier().equals(randomTerminalData.getSupplier())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplier(randomTerminalData.getSupplier());
                break;
            case "supplierpn":
                filteredDbData = dbData.stream().filter(x->x.getSupplierPN().equals(randomTerminalData.getSupplierPN())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplierPN(randomTerminalData.getSupplierPN());
                break;
            case "colour":
                filteredDbData = dbData.stream().filter(x->x.getColour().equals(randomTerminalData.getColour())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnColour(randomTerminalData.getColour());
                break;
            case "gender":
                filteredDbData = dbData.stream().filter(x->x.getGender().equals(randomTerminalData.getGender())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnGender(randomTerminalData.getGender());
                break;
            case "type":
                filteredDbData = dbData.stream()
                        .filter(x->x.getType().equals(randomTerminalData.getType()))
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnType(randomTerminalData.getType());
                break;
            case "material":
                filteredDbData = dbData.stream().filter(x->x.getMaterial().equals(randomTerminalData.getMaterial())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnMaterial(randomTerminalData.getMaterial());
                break;
            case "csa":
                filteredDbData = dbData.stream().filter(x->x.getCsa().equals(randomTerminalData.getCsa())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnCSARange(randomTerminalData.getCsa());
                break;
        }
        List<TerminalsComponentDB> terminalsData = new TerminalsComponentDBPage(context.driver).getTerminalsData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> actualPartNumberList = terminalsData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> differencesFromExpected = expectedPartNumberList.stream()
                .filter(element -> !actualPartNumberList.contains(element))
                .collect(Collectors.toList());
        Assert.assertEquals(0,differencesFromExpected.size(),differencesFromExpected.toString());
    }

    @Then("verify user can filter splice based on property {string}")
    public void verifyUserCanFilterSpliceBasedOnProperty(String propertyName) throws IOException, InterruptedException {
        File f = new File("src/test/resources/componentDB/Splices/SpliceData.json");
        List<SplicesComponentDB> dbData = null;
        if(f.exists()) {
            System.out.println("Resuse JSON");
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/Splices/SpliceData.json"), new TypeReference<List<SplicesComponentDB>>(){});
        }
        if(!f.exists()) {
            System.out.println("Scanning UI");
            dbData=  new SplicesComponentDBPage(context.driver).getSplicesData();
            ObjectMapper mapper = new ObjectMapper();
            Files.createDirectories(Paths.get("src/test/resources/componentDB/Splices"));
            mapper.writeValue(new File("src/test/resources/componentDB/Splices/SpliceData.json"), dbData);
        }
        SplicesComponentDB randomSpliceData = new SplicesComponentDBPage(context.driver).getRandomSpliceComponent(dbData);
        List<SplicesComponentDB> filteredDbData = new ArrayList<>();
        switch(propertyName.toLowerCase()) {
            case "partnumber":
                filteredDbData = dbData.stream().filter(x->x.getPartNumber().equals(randomSpliceData.getPartNumber())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnPartNumber(randomSpliceData.getPartNumber());
                break;
            case "description":
                filteredDbData = dbData.stream().filter(x->x.getDescription().equals(randomSpliceData.getDescription())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnDescription(randomSpliceData.getDescription());
                break;
            case "family":
                filteredDbData = dbData.stream().filter(x->x.getFamily().equals(randomSpliceData.getFamily())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnFamily(randomSpliceData.getFamily());
                break;
            case "status":
                filteredDbData = dbData.stream().filter(x->x.getStatus().equals(randomSpliceData.getStatus())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnStatus(randomSpliceData.getStatus());
                break;
            case "usage":
                filteredDbData = dbData.stream().filter(x->x.getUsage().equals(randomSpliceData.getUsage())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnUsage(randomSpliceData.getUsage());
                break;
            case "supplier":
                filteredDbData = dbData.stream().filter(x->x.getSupplier().equals(randomSpliceData.getSupplier())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplier(randomSpliceData.getSupplier());
                break;
            case "supplierpn":
                filteredDbData = dbData.stream().filter(x->x.getSupplierPN().equals(randomSpliceData.getSupplierPN())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplierPN(randomSpliceData.getSupplierPN());
                break;
            case "colour":
                filteredDbData = dbData.stream().filter(x->x.getColour().equals(randomSpliceData.getColour())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnColour(randomSpliceData.getColour());
                break;
            case "sealingtype":
                filteredDbData = dbData.stream().filter(x->x.getSealingType().equals(randomSpliceData.getSealingType())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSealingType(randomSpliceData.getSealingType());
                break;
            case "material":
                filteredDbData = dbData.stream().filter(x->x.getMaterial().equals(randomSpliceData.getMaterial())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnMaterial(randomSpliceData.getMaterial());
                break;
        }
        List<SplicesComponentDB> splicesData = new SplicesComponentDBPage(context.driver).getSplicesData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> actualPartNumberList = splicesData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> differencesFromExpected = expectedPartNumberList.stream()
                .filter(element -> !actualPartNumberList.contains(element))
                .collect(Collectors.toList());
        Assert.assertEquals(0,differencesFromExpected.size(),differencesFromExpected.toString());
    }

    @Then("verify user can filter otherpart based on property {string}")
    public void verifyUserCanFilterOtherpartBasedOnProperty(String propertyName) throws IOException, InterruptedException {
        File f = new File("src/test/resources/componentDB/OtherParts/OtherPartsData.json");
        List<OtherPartsComponentDB> dbData = null;
        if(f.exists()) {
            System.out.println("Resuse JSON");
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/OtherParts/OtherPartsData.json"), new TypeReference<List<OtherPartsComponentDB>>(){});
        }
        if(!f.exists()) {
            System.out.println("Scanning UI");
            dbData=  new OtherPartsComponentDBPage(context.driver).getOtherPartsData();
            ObjectMapper mapper = new ObjectMapper();
            Files.createDirectories(Paths.get("src/test/resources/componentDB/OtherParts"));
            mapper.writeValue(new File("src/test/resources/componentDB/OtherParts/OtherPartsData.json"), dbData);
        }
        OtherPartsComponentDB randomOtherPartData = new OtherPartsComponentDBPage(context.driver).getRandomOtherPartComponent(dbData);
        List<OtherPartsComponentDB> filteredDbData = new ArrayList<>();
        switch(propertyName.toLowerCase()) {
            case "partnumber":
                filteredDbData = dbData.stream().filter(x->x.getPartNumber().equals(randomOtherPartData.getPartNumber())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnPartNumber(randomOtherPartData.getPartNumber());
                break;
            case "description":
                filteredDbData = dbData.stream().filter(x->x.getDescription().equals(randomOtherPartData.getDescription())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnDescription(randomOtherPartData.getDescription());
                break;
            case "family":
                filteredDbData = dbData.stream().filter(x->x.getFamily().equals(randomOtherPartData.getFamily())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnFamily(randomOtherPartData.getFamily());
                break;
            case "status":
                filteredDbData = dbData.stream().filter(x->x.getStatus().equals(randomOtherPartData.getStatus())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnStatus(randomOtherPartData.getStatus());
                break;
            case "usage":
                filteredDbData = dbData.stream().filter(x->x.getUsage().equals(randomOtherPartData.getUsage())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnUsage(randomOtherPartData.getUsage());
                break;
            case "supplier":
                filteredDbData = dbData.stream().filter(x->x.getSupplier().equals(randomOtherPartData.getSupplier())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplier(randomOtherPartData.getSupplier());
                break;
            case "supplierpn":
                filteredDbData = dbData.stream().filter(x->x.getSupplierPN().equals(randomOtherPartData.getSupplierPN())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplierPN(randomOtherPartData.getSupplierPN());
                break;
            case "colour":
                filteredDbData = dbData.stream().filter(x->x.getColour().equals(randomOtherPartData.getColour())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnColour(randomOtherPartData.getColour());
                break;
        }
        List<OtherPartsComponentDB> otherpartsData = new OtherPartsComponentDBPage(context.driver).getOtherPartsData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> actualPartNumberList = otherpartsData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> differencesFromExpected = expectedPartNumberList.stream()
                .filter(element -> !actualPartNumberList.contains(element))
                .collect(Collectors.toList());
        Assert.assertEquals(0,differencesFromExpected.size(),differencesFromExpected.toString());
    }

    @Then("verify user can filter junctionpart based on property {string}")
    public void verifyUserCanFilterJunctionpartBasedOnProperty(String propertyName) throws IOException, InterruptedException {
        File f = new File("src/test/resources/componentDB/JunctionParts/JunctionPartsData.json");
        List<JunctionPartComponentDB> dbData = null;
        if(f.exists()) {
            System.out.println("Resuse JSON");
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/JunctionParts/JunctionPartsData.json"), new TypeReference<List<JunctionPartComponentDB>>(){});
        }
        if(!f.exists()) {
            System.out.println("Scanning UI");
            dbData=  new JunctionPartsComponentDBPage(context.driver).getJunctionPartsData();
            ObjectMapper mapper = new ObjectMapper();
            Files.createDirectories(Paths.get("src/test/resources/componentDB/JunctionParts"));
            mapper.writeValue(new File("src/test/resources/componentDB/JunctionParts/JunctionPartsData.json"), dbData);
        }
        new CommonElements(context.driver).viewAllFields();
        JunctionPartComponentDB randomJunctionPartData = new JunctionPartsComponentDBPage(context.driver).getRandomJunctionPartComponent(dbData);
        List<JunctionPartComponentDB> filteredDbData = new ArrayList<>();
        switch(propertyName.toLowerCase()) {
            case "partnumber":
                filteredDbData = dbData.stream().filter(x->x.getPartNumber().equals(randomJunctionPartData.getPartNumber())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnPartNumber(randomJunctionPartData.getPartNumber());
                break;
            case "description":
                filteredDbData = dbData.stream().filter(x->x.getDescription().equals(randomJunctionPartData.getDescription())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnDescription(randomJunctionPartData.getDescription());
                break;
            case "family":
                filteredDbData = dbData.stream().filter(x->x.getFamily().equals(randomJunctionPartData.getFamily())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnFamily(randomJunctionPartData.getFamily());
                break;
            case "status":
                filteredDbData = dbData.stream().filter(x->x.getStatus().equals(randomJunctionPartData.getStatus())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnStatus(randomJunctionPartData.getStatus());
                break;
            case "usage":
                filteredDbData = dbData.stream().filter(x->x.getUsage().equals(randomJunctionPartData.getUsage())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnUsage(randomJunctionPartData.getUsage());
                break;
            case "supplier":
                filteredDbData = dbData.stream().filter(x->x.getSupplier().equals(randomJunctionPartData.getSupplier())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplier(randomJunctionPartData.getSupplier());
                break;
            case "supplierpn":
                filteredDbData = dbData.stream().filter(x->x.getSupplierPN().equals(randomJunctionPartData.getSupplierPN())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplierPN(randomJunctionPartData.getSupplierPN());
                break;
            case "colour":
                filteredDbData = dbData.stream().filter(x->x.getColour().equals(randomJunctionPartData.getColour())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnColour(randomJunctionPartData.getColour());
                break;
            case "controltype":
                filteredDbData = dbData.stream().filter(x->x.getControltype().equals(randomJunctionPartData.getControltype())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnControlType(randomJunctionPartData.getControltype());
                break;
            case "material":
                filteredDbData = dbData.stream().filter(x->x.getMaterial().equals(randomJunctionPartData.getMaterial())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnMaterial(randomJunctionPartData.getMaterial());
                break;
        }
        List<JunctionPartComponentDB> junctionpartsData = new JunctionPartsComponentDBPage(context.driver).getJunctionPartsData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> actualPartNumberList = junctionpartsData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> differencesFromExpected = expectedPartNumberList.stream()
                .filter(element -> !actualPartNumberList.contains(element))
                .collect(Collectors.toList());
        Assert.assertEquals(0,differencesFromExpected.size(),differencesFromExpected.toString());
    }

    @Then("verify user can filter multicore based on property {string}")
    public void verifyUserCanFilterMulticoreBasedOnProperty(String propertyName) throws IOException, InterruptedException {
        File f = new File("src/test/resources/componentDB/Multicore/MulticoreData.json");
        List<MulticoreComponentDB> dbData = null;
        if(f.exists()) {
            System.out.println("Resuse JSON");
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/Multicore/MulticoreData.json"), new TypeReference<List<MulticoreComponentDB>>(){});
        }
        if(!f.exists()) {
            System.out.println("Scanning UI");
            dbData=  new MulticoreComponentDBPage(context.driver).getMulticoreData();
            ObjectMapper mapper = new ObjectMapper();
            Files.createDirectories(Paths.get("src/test/resources/componentDB/Multicore"));
            mapper.writeValue(new File("src/test/resources/componentDB/Multicore/MulticoreData.json"), dbData);
        }
        MulticoreComponentDB randomMulticoreData = new MulticoreComponentDBPage(context.driver).getRandomMulticoreComponent(dbData);
        List<MulticoreComponentDB> filteredDbData = new ArrayList<>();
        switch(propertyName.toLowerCase()) {
            case "partnumber":
                filteredDbData = dbData.stream().filter(x->x.getPartNumber().equals(randomMulticoreData.getPartNumber())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnPartNumber(randomMulticoreData.getPartNumber());
                break;
            case "description":
                filteredDbData = dbData.stream().filter(x->x.getDescription().equals(randomMulticoreData.getDescription())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnDescription(randomMulticoreData.getDescription());
                break;
            case "family":
                filteredDbData = dbData.stream().filter(x->x.getFamily().equals(randomMulticoreData.getFamily())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnFamily(randomMulticoreData.getFamily());
                break;
            case "status":
                filteredDbData = dbData.stream().filter(x->x.getStatus().equals(randomMulticoreData.getStatus())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnStatus(randomMulticoreData.getStatus());
                break;
            case "usage":
                filteredDbData = dbData.stream().filter(x->x.getUsage().equals(randomMulticoreData.getUsage())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnUsage(randomMulticoreData.getUsage());
                break;
            case "supplier":
                filteredDbData = dbData.stream().filter(x->x.getSupplier().equals(randomMulticoreData.getSupplier())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplier(randomMulticoreData.getSupplier());
                break;
            case "supplierpn":
                filteredDbData = dbData.stream().filter(x->x.getSupplierPN().equals(randomMulticoreData.getSupplierPN())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplierPN(randomMulticoreData.getSupplierPN());
                break;
            case "colour":
                filteredDbData = dbData.stream().filter(x->x.getColour().equals(randomMulticoreData.getColour())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnColour(randomMulticoreData.getColour());
                break;
            case "cabletype":
                filteredDbData = dbData.stream().filter(x->x.getCabletype().equals(randomMulticoreData.getCabletype())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnCableType(randomMulticoreData.getCabletype());
                break;
        }
        List<MulticoreComponentDB> multicoreData = new MulticoreComponentDBPage(context.driver).getMulticoreData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> actualPartNumberList = multicoreData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> differencesFromExpected = expectedPartNumberList.stream()
                .filter(element -> !actualPartNumberList.contains(element))
                .collect(Collectors.toList());
        Assert.assertEquals(0,differencesFromExpected.size(),differencesFromExpected.toString());
    }

    @Then("Verify multicore component data is greater than value {string} for filter {string}")
    public void verifyMulticoreComponentDataIsGreaterThanValueForFilter(String greaterThanValue, String filterName) throws IOException, InterruptedException {
        File f = new File("src/test/resources/componentDB/Multicore/MulticoreData.json");
        List<MulticoreComponentDB> dbData = null;
        if(f.exists()) {
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/Multicore/MulticoreData.json"), new TypeReference<List<MulticoreComponentDB>>(){});
        }
        if(!f.exists()) {
            dbData=  new MulticoreComponentDBPage(context.driver).getMulticoreData();
            ObjectMapper mapper = new ObjectMapper();
            Files.createDirectories(Paths.get("src/test/resources/componentDB/Multicore"));
            mapper.writeValue(new File("src/test/resources/componentDB/Multicore/MulticoreData.json"), dbData);
        }
        List<MulticoreComponentDB> filteredDbData = new ArrayList<>();
        switch(filterName.toLowerCase()) {
            case "numberofwires":
                int numberOfWiresValue = Integer.parseInt(greaterThanValue);
                filteredDbData = dbData.stream()
                        .filter(x->x.getNumberOfWires()>=numberOfWiresValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnNumberOfWiresRange(">="+greaterThanValue);
                break;
        }
        List<MulticoreComponentDB> multicoreData = new MulticoreComponentDBPage(context.driver).getMulticoreData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> actualPartNumberList = multicoreData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> differencesFromExpected = expectedPartNumberList.stream()
                .filter(element -> !actualPartNumberList.contains(element))
                .collect(Collectors.toList());
        Assert.assertEquals(0,differencesFromExpected.size(),differencesFromExpected.toString());
    }

    @Then("Verify multicore component data on the basis of filter {string} with value {string}")
    public void verifyMulticoreComponentDataOnTheBasisOfFilterRange(String filterName, String filterValue) throws IOException, InterruptedException {
        File f = new File("src/test/resources/componentDB/Multicore/MulticoreData.json");
        List<MulticoreComponentDB> dbData = null;
        if(f.exists()) {
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/Multicore/MulticoreData.json"), new TypeReference<List<MulticoreComponentDB>>(){});
        }
        if(!f.exists()) {
            dbData=  new MulticoreComponentDBPage(context.driver).getMulticoreData();
            ObjectMapper mapper = new ObjectMapper();
            Files.createDirectories(Paths.get("src/test/resources/componentDB/Multicore"));
            mapper.writeValue(new File("src/test/resources/componentDB/Multicore/MulticoreData.json"), dbData);
        }
        List<MulticoreComponentDB> filteredDbData = new ArrayList<>();
        switch(filterName.toLowerCase()) {
            case "numberofwires":
                String[] numberRange = filterValue.split("-");
                int initialValue = Integer.parseInt(numberRange[0]);
                int finalValue = Integer.parseInt(numberRange[1]);
                filteredDbData = dbData.stream()
                        .filter(x->x.getNumberOfWires()>=initialValue)
                        .filter(x->x.getNumberOfWires()<=finalValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnNumberOfWiresRange(filterValue);
                break;
        }
        List<MulticoreComponentDB> multicoreData = new MulticoreComponentDBPage(context.driver).getMulticoreData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> actualPartNumberList = multicoreData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> differencesFromExpected = expectedPartNumberList.stream()
                .filter(element -> !actualPartNumberList.contains(element))
                .collect(Collectors.toList());
        Assert.assertEquals(0,differencesFromExpected.size(),differencesFromExpected.toString());

    }

    @Then("verify user can filter applicator based on property {string}")
    public void verifyUserCanFilterApplicatorBasedOnProperty(String propertyName) throws IOException, InterruptedException {
        File f = new File("src/test/resources/componentDB/Applicators/ApplicatorData.json");
        List<ApplicatorsComponentDB> dbData = null;
        if(f.exists()) {
            System.out.println("Resuse JSON");
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/Applicators/ApplicatorData.json"), new TypeReference<List<ApplicatorsComponentDB>>(){});
        }
        if(!f.exists()) {
            System.out.println("Scanning UI");
            dbData=  new ApplicatorsComponentDBPage(context.driver).getApplicatorsData();
            ObjectMapper mapper = new ObjectMapper();
            Files.createDirectories(Paths.get("src/test/resources/componentDB/Applicators"));
            mapper.writeValue(new File("src/test/resources/componentDB/Applicators/ApplicatorData.json"), dbData);
        }
        ApplicatorsComponentDB randomApplicatorData = new ApplicatorsComponentDBPage(context.driver).getRandomApplicatorComponent(dbData);
        List<ApplicatorsComponentDB> filteredDbData = new ArrayList<>();
        switch(propertyName.toLowerCase()) {
            case "partnumber":
                filteredDbData = dbData.stream().filter(x->x.getPartNumber().equals(randomApplicatorData.getPartNumber())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnPartNumber(randomApplicatorData.getPartNumber());
                break;
            case "description":
                filteredDbData = dbData.stream().filter(x->x.getDescription().equals(randomApplicatorData.getDescription())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnDescription(randomApplicatorData.getDescription());
                break;
            case "family":
                filteredDbData = dbData.stream().filter(x->x.getFamily().equals(randomApplicatorData.getFamily())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnFamily(randomApplicatorData.getFamily());
                break;
            case "status":
                filteredDbData = dbData.stream().filter(x->x.getStatus().equals(randomApplicatorData.getStatus())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnStatus(randomApplicatorData.getStatus());
                break;
            case "usage":
                filteredDbData = dbData.stream().filter(x->x.getUsage().equals(randomApplicatorData.getUsage())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnUsage(randomApplicatorData.getUsage());
                break;
            case "supplier":
                filteredDbData = dbData.stream().filter(x->x.getSupplier().equals(randomApplicatorData.getSupplier())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplier(randomApplicatorData.getSupplier());
                break;
            case "supplierpn":
                filteredDbData = dbData.stream().filter(x->x.getSupplierPN().equals(randomApplicatorData.getSupplierPN())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplierPN(randomApplicatorData.getSupplierPN());
                break;
            case "colour":
                filteredDbData = dbData.stream().filter(x->x.getColour().equals(randomApplicatorData.getColour())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnColour(randomApplicatorData.getColour());
                break;
            case "applicatorusage":
                filteredDbData = dbData.stream().filter(x->x.getApplicatorUsage().equals(randomApplicatorData.getApplicatorUsage())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnApplicatorUsage(randomApplicatorData.getApplicatorUsage());
                break;
            case "forsealorterminal":
                filteredDbData = dbData.stream().filter(x->x.getForSealOrTerminal().equals(randomApplicatorData.getForSealOrTerminal())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSealOrTerminal(randomApplicatorData.getForSealOrTerminal());
                break;
            case "inservice":
                filteredDbData = dbData.stream().filter(x->x.getInService().equals(randomApplicatorData.getInService())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnInService(randomApplicatorData.getInService());
                break;
            case "applicatorsite":
                filteredDbData = dbData.stream().filter(x->x.getApplicatorSite().equals(randomApplicatorData.getApplicatorSite())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnApplicatorSite(randomApplicatorData.getApplicatorSite());
                break;
        }
        List<ApplicatorsComponentDB> applicatorsData = new ApplicatorsComponentDBPage(context.driver).getApplicatorsData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> actualPartNumberList = applicatorsData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> differencesFromExpected = expectedPartNumberList.stream()
                .filter(element -> !actualPartNumberList.contains(element))
                .collect(Collectors.toList());
        Assert.assertEquals(0,differencesFromExpected.size(),differencesFromExpected.toString());
    }

    //For component type 'component"
    @Then("verify user can filter component based on property {string}")
    public void verifyUserCanFilterComponentBasedOnProperty(String propertyName) throws IOException, InterruptedException {
        File f = new File("src/test/resources/componentDB/Component/ComponentData.json");
        List<ComponentsDB> dbData = null;
        if(f.exists()) {
            System.out.println("Resuse JSON");
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/Component/ComponentData.json"), new TypeReference<List<ComponentsDB>>(){});
        }
        if(!f.exists()) {
            System.out.println("Scanning UI");
            dbData=  new ComponentsDBPage(context.driver).getComponentsData();
            ObjectMapper mapper = new ObjectMapper();
            Files.createDirectories(Paths.get("src/test/resources/componentDB/Component"));
            mapper.writeValue(new File("src/test/resources/componentDB/Component/ComponentData.json"), dbData);
        }
        ComponentsDB randomComponentData = new ComponentsDBPage(context.driver).getRandomComponent(dbData);
        List<ComponentsDB> filteredDbData = new ArrayList<>();
        switch(propertyName.toLowerCase()) {
            case "partnumber":
                filteredDbData = dbData.stream().filter(x->x.getPartNumber().equals(randomComponentData.getPartNumber())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnPartNumber(randomComponentData.getPartNumber());
                break;
            case "description":
                filteredDbData = dbData.stream().filter(x->x.getDescription().equals(randomComponentData.getDescription())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnDescription(randomComponentData.getDescription());
                break;
            case "family":
                filteredDbData = dbData.stream().filter(x->x.getFamily().equals(randomComponentData.getFamily())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnFamily(randomComponentData.getFamily());
                break;
            case "status":
                filteredDbData = dbData.stream().filter(x->x.getStatus().equals(randomComponentData.getStatus())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnStatus(randomComponentData.getStatus());
                break;
            case "usage":
                filteredDbData = dbData.stream().filter(x->x.getUsage().equals(randomComponentData.getUsage())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnUsage(randomComponentData.getUsage());
                break;
            case "supplier":
                filteredDbData = dbData.stream().filter(x->x.getSupplier().equals(randomComponentData.getSupplier())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplier(randomComponentData.getSupplier());
                break;
            case "supplierpn":
                filteredDbData = dbData.stream().filter(x->x.getSupplierPN().equals(randomComponentData.getSupplierPN())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplierPN(randomComponentData.getSupplierPN());
                break;
        }
        List<ComponentsDB> componentData = new ComponentsDBPage(context.driver).getComponentsData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> actualPartNumberList = componentData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> differencesFromExpected = expectedPartNumberList.stream()
                .filter(element -> !actualPartNumberList.contains(element))
                .collect(Collectors.toList());
        Assert.assertEquals(0,differencesFromExpected.size(),differencesFromExpected.toString());
    }

    @Then("Verify component data on the basis of filter {string} with value {string}")
    public void verifyComponentDataOnTheBasisOfFilterWithValue(String filterName, String filterValue) throws IOException, InterruptedException {
        File f = new File("src/test/resources/componentDB/Component/ComponentData.json");
        List<ComponentsDB> dbData = null;
        if(f.exists()) {
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/Component/ComponentData.json"), new TypeReference<List<ComponentsDB>>(){});
        }
        if(!f.exists()) {
            dbData=  new ComponentsDBPage(context.driver).getComponentsData();
            ObjectMapper mapper = new ObjectMapper();
            Files.createDirectories(Paths.get("src/test/resources/componentDB/Component"));
            mapper.writeValue(new File("src/test/resources/componentDB/Component/ComponentData.json"), dbData);
        }
        List<ComponentsDB> filteredDbData = new ArrayList<>();
        switch(filterName.toLowerCase()) {
            case "numberofcavities":
                String[] numberRange = filterValue.split("-");
                int initialValue = Integer.parseInt(numberRange[0]);
                int finalValue = Integer.parseInt(numberRange[1]);
                filteredDbData = dbData.stream()
                        .filter(x->x.getNumberOfCavities()>=initialValue)
                        .filter(x->x.getNumberOfCavities()<=finalValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnNumberOfCavitiesRange(filterValue);
                break;
        }
        List<ComponentsDB> componentData = new ComponentsDBPage(context.driver).getComponentsData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> actualPartNumberList = componentData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> differencesFromExpected = expectedPartNumberList.stream()
                .filter(element -> !actualPartNumberList.contains(element))
                .collect(Collectors.toList());
        Assert.assertEquals(0,differencesFromExpected.size(),differencesFromExpected.toString());
    }

    @Then("Verify component data is greater than value {string} for filter {string}")
    public void verifyComponentDataIsGreaterThanValue(String greaterThanValue, String filterName) throws IOException, InterruptedException {
        File f = new File("src/test/resources/componentDB/Component/ComponentData.json");
        List<ComponentsDB> dbData = null;
        if(f.exists()) {
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/Component/ComponentData.json"), new TypeReference<List<ComponentsDB>>(){});
        }
        if(!f.exists()) {
            dbData=  new ComponentsDBPage(context.driver).getComponentsData();
            ObjectMapper mapper = new ObjectMapper();
            Files.createDirectories(Paths.get("src/test/resources/componentDB/Component"));
            mapper.writeValue(new File("src/test/resources/componentDB/Component/ComponentData.json"), dbData);
        }
        List<ComponentsDB> filteredDbData = new ArrayList<>();
        switch(filterName.toLowerCase()) {
            case "numberofcavities":
                int numberOfCavitiesValue = Integer.parseInt(greaterThanValue);
                filteredDbData = dbData.stream()
                        .filter(x->x.getNumberOfCavities()>=numberOfCavitiesValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnNumberOfCavitiesRange(">="+greaterThanValue);
                break;
        }
        List<ComponentsDB> componentData = new ComponentsDBPage(context.driver).getComponentsData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> actualPartNumberList = componentData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> differencesFromExpected = expectedPartNumberList.stream()
                .filter(element -> !actualPartNumberList.contains(element))
                .collect(Collectors.toList());
        Assert.assertEquals(0,differencesFromExpected.size(),differencesFromExpected.toString());
    }

    @Then("verify user can filter seals based on property {string}")
    public void verifyUserCanFilterSealsBasedOnPropertySupplierPN(String propertyName) throws IOException, InterruptedException {
        File f = new File("src/test/resources/componentDB/Seal/Seal.json");
        List<SealsComponentDB> dbData = null;
        if(f.exists()) {
            System.out.println("Resuse JSON");
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/Seal/Seal.json"), new TypeReference<List<SealsComponentDB>>(){});
        }
        if(!f.exists()) {
            System.out.println("Scanning UI");
            dbData=  new SealsComponentDBPage(context.driver).getSealData();
            ObjectMapper mapper = new ObjectMapper();
            Files.createDirectories(Paths.get("src/test/resources/componentDB/Seal"));
            mapper.writeValue(new File("src/test/resources/componentDB/Seal/Seal.json"), dbData);
        }
        SealsComponentDB randomSealsData = new SealsComponentDBPage(context.driver).getRandomSealsComponent(dbData);
        List<SealsComponentDB> filteredDbData = new ArrayList<>();
        switch(propertyName.toLowerCase()) {
            case "partnumber":
                filteredDbData = dbData.stream().filter(x->x.getPartNumber().equals(randomSealsData.getPartNumber())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnPartNumber(randomSealsData.getPartNumber());
                break;
            case "description":
                filteredDbData = dbData.stream().filter(x->x.getDescription().equals(randomSealsData.getDescription())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnDescription(randomSealsData.getDescription());
                break;
            case "family":
                filteredDbData = dbData.stream().filter(x->x.getFamily().equals(randomSealsData.getFamily())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnFamily(randomSealsData.getFamily());
                break;
            case "status":
                filteredDbData = dbData.stream().filter(x->x.getStatus().equals(randomSealsData.getStatus())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnStatus(randomSealsData.getStatus());
                break;
            case "usage":
                filteredDbData = dbData.stream().filter(x->x.getUsage().equals(randomSealsData.getUsage())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnUsage(randomSealsData.getUsage());
                break;
            case "supplier":
                filteredDbData = dbData.stream().filter(x->x.getSupplier().equals(randomSealsData.getSupplier())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplier(randomSealsData.getSupplier());
                break;
            case "supplierpn":
                filteredDbData = dbData.stream().filter(x->x.getSupplierPN().equals(randomSealsData.getSupplierPN())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplierPN(randomSealsData.getSupplierPN());
                break;
            case "colour":
                filteredDbData = dbData.stream().filter(x->x.getColour().equals(randomSealsData.getColour())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnColour(randomSealsData.getColour());
                break;
            case "cavity":
                filteredDbData = dbData.stream().filter(x->x.getCavity().equals(randomSealsData.getCavity())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnCavity(randomSealsData.getCavity());
                break;
            case "insulationod":
                filteredDbData = dbData.stream().filter(x->x.getInsulationOD().equals(randomSealsData.getInsulationOD())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnInsulationOD(randomSealsData.getInsulationOD());
                break;
        }
        List<SealsComponentDB> sealsData = new SealsComponentDBPage(context.driver).getSealData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> actualPartNumberList = sealsData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> differencesFromExpected = expectedPartNumberList.stream()
                .filter(element -> !actualPartNumberList.contains(element))
                .collect(Collectors.toList());
        Assert.assertEquals(0,differencesFromExpected.size(),differencesFromExpected.toString());
    }

    @And("User links {string} from componentDB")
    public void userLinksComponentFromComponentDB(String componentName) throws AWTException, InterruptedException {
        switch (componentName.toLowerCase()){
            case "terminal":
                new HeaderPanel(context.driver).invokeFormTabs("Link_Terminals");
                new CommonElements(context.driver).enterLinkPartNumber("7780");
                break;
            case "seal":
                new HeaderPanel(context.driver).invokeFormTabs("Link_Seals");
                new CommonElements(context.driver).enterLinkPartNumber("4526");
                break;
            case "part":
                new HeaderPanel(context.driver).invokeFormTabs("Link_Parts");
                new CommonElements(context.driver).enterLinkPartNumber("12020807");
                break;
        }
        new CommonElements(context.driver).clickUpdateComponent();
        new CommonElements(context.driver).verifyAlertSuccessMessage("Component updated");
    }

    @Then("verify user can filter connector based on property {string}")
    public void verifyUserCanFilterConnectorBasedOnProperty(String propertyName) throws IOException, InterruptedException {
        File f = new File("src/test/resources/componentDB/Connector/ConnectorData.json");
        List<ConnectorDB> dbData = null;
        if(f.exists()) {
            System.out.println("Resuse JSON");
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/Connector/ConnectorData.json"), new TypeReference<List<ConnectorDB>>(){});
        }
        if(!f.exists()) {
            System.out.println("Scanning UI");
            dbData=  new ConnectorsDBPage(context.driver).getConnectorsData();
            ObjectMapper mapper = new ObjectMapper();
            Files.createDirectories(Paths.get("src/test/resources/componentDB/Connector"));
            mapper.writeValue(new File("src/test/resources/componentDB/Connector/ConnectorData.json"), dbData);
        }
        ConnectorDB randomConnectorData = new ConnectorsDBPage(context.driver).getRandomConnectorComponent(dbData);
        List<ConnectorDB> filteredDbData = new ArrayList<>();
        switch(propertyName.toLowerCase()) {
            case "partnumber":
                filteredDbData = dbData.stream().filter(x->x.getPartNumber().equals(randomConnectorData.getPartNumber())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnPartNumber(randomConnectorData.getPartNumber());
                break;
            case "description":
                filteredDbData = dbData.stream().filter(x->x.getDescription().equals(randomConnectorData.getDescription())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnDescription(randomConnectorData.getDescription());
                break;
            case "family":
                filteredDbData = dbData.stream().filter(x->x.getFamily().equals(randomConnectorData.getFamily())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnFamily(randomConnectorData.getFamily());
                break;
            case "status":
                filteredDbData = dbData.stream().filter(x->x.getStatus().equals(randomConnectorData.getStatus())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnStatus(randomConnectorData.getStatus());
                break;
            case "usage":
                filteredDbData = dbData.stream().filter(x->x.getUsage().equals(randomConnectorData.getUsage())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnUsage(randomConnectorData.getUsage());
                break;
            case "supplier":
                filteredDbData = dbData.stream().filter(x->x.getSupplier().equals(randomConnectorData.getSupplier())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplier(randomConnectorData.getSupplier());
                break;
            case "supplierpn":
                filteredDbData = dbData.stream().filter(x->x.getSupplierPN().equals(randomConnectorData.getSupplierPN())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnSupplierPN(randomConnectorData.getSupplierPN());
                break;
            case "colour":
                filteredDbData = dbData.stream().filter(x->x.getColour().equals(randomConnectorData.getColour())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnColour(randomConnectorData.getColour());
                break;
            case "housinggender":
                filteredDbData = dbData.stream().filter(x->x.getHousingGender().equals(randomConnectorData.getHousingGender())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnHousingGender(randomConnectorData.getHousingGender());
                break;
            case "terminalgender":
                filteredDbData = dbData.stream().filter(x->x.getTerminalGender().equals(randomConnectorData.getTerminalGender())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnGender(randomConnectorData.getTerminalGender());
                break;
            case "connectortype":
                filteredDbData = dbData.stream().filter(x->x.getConnectorType().equals(randomConnectorData.getConnectorType())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnConnectorType(randomConnectorData.getConnectorType());
                break;
            case "keyway":
                filteredDbData = dbData.stream().filter(x->x.getKeyway().equals(randomConnectorData.getKeyway())).collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnKeyway(randomConnectorData.getKeyway());
                break;
        }
        List<ConnectorDB> connectorData = new ConnectorsDBPage(context.driver).getConnectorsData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> actualPartNumberList = connectorData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> differencesFromExpected = expectedPartNumberList.stream()
                .filter(element -> !actualPartNumberList.contains(element))
                .collect(Collectors.toList());
        Assert.assertEquals(0,differencesFromExpected.size(),differencesFromExpected.toString());
    }

    @Then("Verify connector data on the basis of filter {string} with value {string}")
    public void verifyConnectorDataOnTheBasisOfFilterRange(String filterName, String filterValue) throws IOException, InterruptedException {
        File f = new File("src/test/resources/componentDB/Connector/ConnectorData.json");
        List<ConnectorDB> dbData = null;
        if(f.exists()) {
            System.out.println("Resuse JSON");
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/Connector/ConnectorData.json"), new TypeReference<List<ConnectorDB>>(){});
        }
        if(!f.exists()) {
            System.out.println("Scanning UI");
            dbData=  new ConnectorsDBPage(context.driver).getConnectorsData();
            ObjectMapper mapper = new ObjectMapper();
            Files.createDirectories(Paths.get("src/test/resources/componentDB/Connector"));
            mapper.writeValue(new File("src/test/resources/componentDB/Connector/ConnectorData.json"), dbData);
        }
        List<ConnectorDB> filteredDbData = new ArrayList<>();
        switch(filterName.toLowerCase()) {
            case "numberofcavities":
                String[] numberRange = filterValue.split("-");
                int initialValue = Integer.parseInt(numberRange[0]);
                int finalValue = Integer.parseInt(numberRange[1]);
                filteredDbData = dbData.stream()
                        .filter(x->x.getNumberOfCavities()>=initialValue)
                        .filter(x->x.getNumberOfCavities()<=finalValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnNumberOfCavitiesRange(filterValue);
                break;
        }
        List<ConnectorDB> componentData = new ConnectorsDBPage(context.driver).getConnectorsData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> actualPartNumberList = componentData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> differencesFromExpected = expectedPartNumberList.stream()
                .filter(element -> !actualPartNumberList.contains(element))
                .collect(Collectors.toList());
        Assert.assertEquals(0,differencesFromExpected.size(),differencesFromExpected.toString());

    }

    @Then("Verify connector component data is greater than value {string} for filter {string}")
    public void verifyConnectorComponentDataIsGreaterThanValueForFilter(String greaterThanValue, String filterName) throws IOException, InterruptedException {
        File f = new File("src/test/resources/componentDB/Connector/ConnectorData.json");
        List<ConnectorDB> dbData = null;
        if(f.exists()) {
            System.out.println("Resuse JSON");
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/Connector/ConnectorData.json"), new TypeReference<List<ConnectorDB>>(){});
        }
        if(!f.exists()) {
            System.out.println("Scanning UI");
            dbData=  new ConnectorsDBPage(context.driver).getConnectorsData();
            ObjectMapper mapper = new ObjectMapper();
            Files.createDirectories(Paths.get("src/test/resources/componentDB/Connector"));
            mapper.writeValue(new File("src/test/resources/componentDB/Connector/ConnectorData.json"), dbData);
        }
        List<ConnectorDB> filteredDbData = new ArrayList<>();
        switch(filterName.toLowerCase()) {
            case "numberofcavities":
                int numberOfCavitiesValue = Integer.parseInt(greaterThanValue);
                filteredDbData = dbData.stream()
                        .filter(x->x.getNumberOfCavities()>=numberOfCavitiesValue)
                        .collect(Collectors.toList());
                new CommonElements(context.driver).filterComponentBasedOnNumberOfCavitiesRange(">="+greaterThanValue);
                break;
        }
        List<ConnectorDB> componentData = new ConnectorsDBPage(context.driver).getConnectorsData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> actualPartNumberList = componentData.stream().map(x->x.getPartNumber()).collect(Collectors.toList());
        List<String> differencesFromExpected = expectedPartNumberList.stream()
                .filter(element -> !actualPartNumberList.contains(element))
                .collect(Collectors.toList());
        Assert.assertEquals(0,differencesFromExpected.size(),differencesFromExpected.toString());
    }
}
