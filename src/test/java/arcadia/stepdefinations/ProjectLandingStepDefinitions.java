package arcadia.stepdefinations;
import arcadia.constants.EndPoint;
import arcadia.context.TestContext;
import arcadia.pages.ComponentDB.AddNewComponentPage;
import arcadia.pages.ComponentDB.ComponentDBHomePage;
import arcadia.pages.PageFactoryManager;
import arcadia.pages.ProjectLanding;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProjectLandingStepDefinitions {
    private final ProjectLanding projectLanding;
    private final TestContext context;
    public ProjectLandingStepDefinitions(TestContext context){
        this.context = context;
        projectLanding = PageFactoryManager.getProjectLanding(context.driver);
    }

    @And("Created Project {string}")
    public void createdProjectDemo_Integration(String projectName) throws InterruptedException {
        if (!projectLanding.checkProjectExists(projectName)){
            projectLanding.addProject(projectName);
        }
    }


}
