package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.domainobjects.*;
import arcadia.pages.ComponentDB.AddNewComponentPage;
import arcadia.pages.ComponentDB.HeaderPanel;
import arcadia.pages.ComponentDB.Wires.WiresComponentDBPage;
import arcadia.utils.StringHelper;
import io.cucumber.java.en.Then;
import org.apache.commons.collections.ListUtils;
import org.testng.Assert;

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
                new HeaderPanel(context.driver).openAddNewComponentPage();
                addComponentForm = new AddComponentForm();
                componentDetails = new ComponentDetails(String.format("testdescription-%04d", new StringHelper().generateRandomDigit()), "testfamily", componentStatus, "", "testproprietary", "", "", "", "", "PVC", "NOT SET", "", "BLACK");
                addComponentForm.setComponentDetails(componentDetails);
                break;
        }
                additionalReferencesList = new ArrayList<>();
                additionalReferences1 = new AdditionalReferences(String.valueOf(new StringHelper().generateRandomDigit()),"Manufacturer","testcompany");
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
        if(componentName.equalsIgnoreCase("wire")||componentName.equalsIgnoreCase("seal"))
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
        new AddNewComponentPage(context.driver).verifyErrorMessage(errorMessage);
        new AddNewComponentPage(context.driver).closeErrorPopUp();
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

    @Then("Verify component data on the basis of filter {string} with value {string}")
    public void verify_component_data_on_the_basis_of_filter(String filterName, String filterValue) throws InterruptedException {
        new WiresComponentDBPage(context.driver).getFullPagination();
        List<WiresComponentDB> dbData = new WiresComponentDBPage(context.driver).getWiresData();
        List<WiresComponentDB> filteredDbData = new ArrayList<>();
        switch(filterName.toLowerCase()) {
            case "status":
                filteredDbData = dbData.stream().filter(x->x.getStatus().equals(filterValue)).collect(Collectors.toList());
                new WiresComponentDBPage(context.driver).filterWiresBasedOnStatus(filterValue);
                break;
            case "partnumber":
                filteredDbData = dbData.stream().filter(x->x.getPartNumber().equals(filterValue)).collect(Collectors.toList());
                new WiresComponentDBPage(context.driver).filterWiresBasedOnPartNumber(filterValue);
                break;
            case "description":
                filteredDbData = dbData.stream().filter(x->x.getDescription().equals(filterValue)).collect(Collectors.toList());
                new WiresComponentDBPage(context.driver).filterWiresBasedOnDescription(filterValue);
                break;
            case "family":
                filteredDbData = dbData.stream().filter(x->x.getFamily().equals(filterValue)).collect(Collectors.toList());
                new WiresComponentDBPage(context.driver).filterWiresBasedOnFamily(filterValue);
                break;
            case "usage":
                filteredDbData = dbData.stream().filter(x->x.getUsage().equals(filterValue)).collect(Collectors.toList());
                new WiresComponentDBPage(context.driver).filterWiresBasedOnUsage(filterValue);
                break;
            case "supplier":
                filteredDbData = dbData.stream().filter(x->x.getSupplier().equals(filterValue)).collect(Collectors.toList());
                new WiresComponentDBPage(context.driver).filterWiresBasedOnSupplier(filterValue);
                break;
            case "supplierpn":
                filteredDbData = dbData.stream().filter(x->x.getSupplierPN().equals(filterValue)).collect(Collectors.toList());
                new WiresComponentDBPage(context.driver).filterWiresBasedOnSupplierPN(filterValue);
                break;
            case "colour":
                filteredDbData = dbData.stream().filter(x->x.getColour().equals(filterValue)).collect(Collectors.toList());
                new WiresComponentDBPage(context.driver).filterWiresBasedOnColour(filterValue);
                break;
            case "awgsize":
                filteredDbData = dbData.stream().filter(x->x.getAwgSize().equals(filterValue)).collect(Collectors.toList());
                new WiresComponentDBPage(context.driver).filterWiresBasedOnAwgSize(filterValue);
                break;
            case "gauge":
                filteredDbData = dbData.stream()
                        .filter(x->x.getGauge().equals(filterValue))
                        .collect(Collectors.toList());
                new WiresComponentDBPage(context.driver).filterWiresBasedOnGauge(filterValue);
                break;
            case "wirecsa":
                String[] csaRange = filterValue.split("-");
                Double initialCSAValue = Double.valueOf(csaRange[0]);
                Double finalCSAValue = Double.valueOf(csaRange[1]);
                filteredDbData = dbData.stream()
                        .filter(x->x.getWireCSA()>=initialCSAValue)
                        .filter(x->x.getWireCSA()<=finalCSAValue)
                        .collect(Collectors.toList());
                new WiresComponentDBPage(context.driver).filterWiresBasedOnWireCSARange(filterValue);
                break;
            case "outsidedia":
                String[] outDiaRange = filterValue.split("-");
                Double initialDiaValue = Double.valueOf(outDiaRange[0]);
                Double finalDiaValue = Double.valueOf(outDiaRange[1]);
                filteredDbData = dbData.stream()
                        .filter(x->x.getOutsideDia()>=initialDiaValue)
                        .filter(x->x.getOutsideDia()<=finalDiaValue)
                        .collect(Collectors.toList());
                new WiresComponentDBPage(context.driver).filterWiresBasedOnOutsideDiaRange(filterValue);
                break;
            case "material":
                filteredDbData = dbData.stream().filter(x->x.getMaterial().equals(filterValue)).collect(Collectors.toList());
                new WiresComponentDBPage(context.driver).filterWiresBasedOnMaterial(filterValue);
                break;
            case "minimumbendradius":
                String[] bendRadiusRange = filterValue.split("-");
                Double initialRadiusValue = Double.valueOf(bendRadiusRange[0]);
                Double finalRadiusValue = Double.valueOf(bendRadiusRange[1]);
                filteredDbData = dbData.stream()
                        .filter(x->x.getMinimumRadius()>=initialRadiusValue)
                        .filter(x->x.getMinimumRadius()<=finalRadiusValue)
                        .collect(Collectors.toList());
                new WiresComponentDBPage(context.driver).filterWiresBasedOnMinimumBendRadiusRange(filterValue);
                break;
            case "maxcurrent":
                String[] currentRange = filterValue.split("-");
                Double initialCurrentValue = Double.valueOf(currentRange[0]);
                Double finalCurrentValue = Double.valueOf(currentRange[1]);
                filteredDbData = dbData.stream()
                        .filter(x->x.getMaxcurrent()>=initialCurrentValue)
                        .filter(x->x.getMaxcurrent()<=finalCurrentValue)
                        .collect(Collectors.toList());
                new WiresComponentDBPage(context.driver).filterWiresBasedOnMaxCurrentRange(filterValue);
                break;
            case "resistance":
                String[] resistanceRange = filterValue.split("-");
                Double initialResistanceValue = Double.valueOf(resistanceRange[0]);
                Double finalResistanceValue = Double.valueOf(resistanceRange[1]);
                filteredDbData = dbData.stream()
                        .filter(x->x.getResistance()>=initialResistanceValue)
                        .filter(x->x.getResistance()<=finalResistanceValue)
                        .collect(Collectors.toList());
                new WiresComponentDBPage(context.driver).filterWiresBasedOnResistanceRange(filterValue);
                break;
        }
        List<WiresComponentDB> wiresData = new WiresComponentDBPage(context.driver).getWiresData();
        Assert.assertTrue(ListUtils.subtract(filteredDbData,wiresData.stream().toList()).size()==0);
    }

}
