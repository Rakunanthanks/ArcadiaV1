package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.domainobjects.AddComponentForm;
import arcadia.domainobjects.AdditionalReferences;
import arcadia.domainobjects.BomDetails;
import arcadia.domainobjects.ComponentDetails;
import arcadia.pages.ComponentDB.AddNewComponentPage;
import arcadia.pages.ComponentDB.HeaderPanel;
import arcadia.utils.StringHelper;
import io.cucumber.java.en.Then;

import java.util.ArrayList;
import java.util.List;

public class ComponentDBStepDefinitions {
    private final TestContext context;
    public ComponentDBStepDefinitions(TestContext context) {
        this.context = context;
    }

    @Then("{string} component with status {string} is created successfully")
    public void component_with_status_is_created_successfully(String componentName, String componentStatus) throws InterruptedException {
        switch(componentName.toLowerCase()) {
            case "wire":
                new HeaderPanel(context.driver).openAddNewComponentPage();
                AddComponentForm addComponentForm = new AddComponentForm();
                ComponentDetails componentDetails = new ComponentDetails(String.format("testdescription-%04d", new StringHelper().generateRandomDigit()),"testfamily",componentStatus,"","testproprietary","","BLACK","BLUE","BROWN","PVC","NOT SET","");
                addComponentForm.setComponentDetails(componentDetails);
                List<AdditionalReferences> additionalReferencesList = new ArrayList<>();
                AdditionalReferences additionalReferences1 = new AdditionalReferences(String.valueOf(new StringHelper().generateRandomDigit()),"Manufacturer","testcompany");
                additionalReferencesList.add(additionalReferences1);
                AdditionalReferences additionalReferences2 = new AdditionalReferences(String.valueOf(new StringHelper().generateRandomDigit()),"Supplier","testcompany2");
                additionalReferencesList.add(additionalReferences2);
                addComponentForm.setAdditionalReferences(additionalReferencesList);
                BomDetails bomDetails = new BomDetails(0.0022,"","EACH","GBP","gm","INCLUDED");
                addComponentForm.setBomDetails(bomDetails);
                new AddNewComponentPage(context.driver).createComponent(addComponentForm);
                new AddNewComponentPage(context.driver).submitComponentDetails();
                Thread.sleep(1000);
                break;
        }
    }
}
