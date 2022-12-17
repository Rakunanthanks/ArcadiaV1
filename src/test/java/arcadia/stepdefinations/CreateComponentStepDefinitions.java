package arcadia.stepdefinations;

import arcadia.context.FlowContext;
import arcadia.context.TestContext;
import arcadia.domainobjects.*;
import arcadia.pages.BundlePage;
import arcadia.pages.ComponentDB.AddNewComponentPage;
import arcadia.pages.ComponentDB.CommonElements;
import arcadia.pages.ComponentDB.HeaderPanel;
import arcadia.pages.PageFactoryManager;
import arcadia.utils.FormulaCalculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CreateComponentStepDefinitions {
    private final TestContext context;

    public CreateComponentStepDefinitions(TestContext context){
        this.context = context;
    }

    @Given("User opens add component page")
    public void openAddComponentPage(){
        new HeaderPanel(context.driver).openAddNewComponentPage();
    }

    @When("User enters data on Add Component Page")
    public void enterComponentDetails() throws InterruptedException {
        AddComponentForm addComponentForm = new AddComponentForm();
        ComponentDetails componentDetails = new ComponentDetails("testdescription","testfamily","IN REVIEW","","testproprietary","","BLACK","BLUE","BROWN","PVC","NOT SET","");
        addComponentForm.setComponentDetails(componentDetails);
        List<AdditionalReferences> additionalReferencesList = new ArrayList<>();
        AdditionalReferences additionalReferences1 = new AdditionalReferences("1212","Manufacturer","testcompany");
        additionalReferencesList.add(additionalReferences1);
        AdditionalReferences additionalReferences2 = new AdditionalReferences("12123","Supplier","testcompany2");
        additionalReferencesList.add(additionalReferences2);
        addComponentForm.setAdditionalReferences(additionalReferencesList);
        BomDetails bomDetails = new BomDetails(0.0022,"","EACH","GBP","gm","INCLUDED (MATERIAL)");
        addComponentForm.setBomDetails(bomDetails);
        new AddNewComponentPage(context.driver).createComponent(addComponentForm);
    }

    @Then("User submits the component details")
    public void createComponent(){
        new AddNewComponentPage(context.driver).submitComponentDetails();
    }

}

//Add header page
