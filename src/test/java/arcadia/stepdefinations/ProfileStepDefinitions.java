package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.domainobjects.SealsComponentDB;
import arcadia.pages.ComponentDB.Seals.SealsComponentDBPage;
import arcadia.pages.PageFactoryManager;
import arcadia.pages.ProfilePage;
import arcadia.utils.PropertyUtils;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import arcadia.domainobjects.ComponentPrefix;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author vipula
 * @date 10-01-2023
 */
public class ProfileStepDefinitions {
    private final TestContext context;
    private final ProfilePage profilePage;

    public ProfileStepDefinitions(TestContext context) {
        this.context = context;
        profilePage = PageFactoryManager.getProfilePage(context.driver);
    }

    @And("User selected {string} from General panel")
    public void userSelectedCOMPONENTPREFIXEDITORFromGeneralPanel(String menuName) throws InterruptedException {
        profilePage.clickMenuFromLeftPanel();
        Thread.sleep(2000);
    }

    @Then("User capture the Identifier and Prefix from the UI")
    public void userCaptureTheIdentifierAndPrefixFromTheUI() throws IOException, InterruptedException {
        File f = new File("src/test/resources/ProfileData/prefix.json");
        List<ComponentPrefix> dbData = null;
        if (f.exists()) {
            System.out.println("Reuse JSON");
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/ProfileData/prefix.json"), new TypeReference<List<ComponentPrefix>>() {
            });
        }
        if (!f.exists()) {
            System.out.println("Scanning UI");
            dbData = new ProfilePage(context.driver).getPrefixData();
            ObjectMapper mapper = new ObjectMapper();
            Files.createDirectories(Paths.get("src/test/resources/ProfileData"));
            mapper.writeValue(new File("src/test/resources/ProfileData/prefix.json"), dbData);
        }
    }

    @And("click on Edit button to edit the Identifier {string} and Prefix {string}")
    public void clickOnEditButtonToEditThePrefixForIdentifier(String Identifier, String prefix) throws InterruptedException {
        ExtentCucumberAdapter.addTestStepLog(String.format("Identifier is "+Identifier+" and Prefix is "+prefix));
        profilePage.clickEditButtonForIdentifier(Identifier);
       String updatedPrefix= profilePage.editPrefixAndSave();
        boolean flag=profilePage.validateUpdatedPrefix(Identifier,updatedPrefix);
        if(flag)
        {
            ExtentCucumberAdapter.addTestStepLog(String.format("Prefix for Identifier "+Identifier+" is updated to "+updatedPrefix));
        }
        else{
            ExtentCucumberAdapter.addTestStepLog(String.format("Failed to update the Prefix for "+Identifier));

        }

    }
}
