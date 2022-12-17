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
    private AddNewComponentPage addComponentPage;
    private HeaderPanel headerPanel;
    private final TestContext context;

    public CreateComponentStepDefinitions(TestContext context){
        this.context = context;
        addComponentPage = PageFactoryManager.getAddNewComponentPage(context.driver);
        headerPanel = PageFactoryManager.getHeaderPanel(context.driver);
    }

    @Given("User opens add component page")
    public void openAddComponentPage(){
        headerPanel.openAddNewComponentPage();
    }

    @When("User enters data on Add Component Page")
    public void enterComponentDetails() throws InterruptedException {
        AddComponentForm addComponentForm = new AddComponentForm();
        ComponentDetails componentDetails = new ComponentDetails("testdescription","testfamily","IN REVIEW","","testproprietary","","BLACK(BK)","BLUE(BL)","BROWN(BR)","PVC (PVC Insulated Thinwall)","NOT SET","");
        addComponentForm.setComponentDetails(componentDetails);
        List<AdditionalReferences> additionalReferencesList = new ArrayList<>();
        AdditionalReferences additionalReferences1 = new AdditionalReferences("1212","Manufacturer","testcompany");
        additionalReferencesList.add(additionalReferences1);
        AdditionalReferences additionalReferences2 = new AdditionalReferences("12123","Supplier","testcompany2");
        additionalReferencesList.add(additionalReferences2);
        addComponentForm.setAdditionalReferences(additionalReferencesList);
        BomDetails bomDetails = new BomDetails(0.0022,"","EACH","GBP","gm","INCLUDED (MATERIAL)");
        addComponentForm.setBomDetails(bomDetails);
        addComponentPage.createComponent(addComponentForm);
    }

    @Then("User submits the component details")
    public void createComponent(){
        addComponentPage.submitComponentDetails();
    }

}

//Add header page
