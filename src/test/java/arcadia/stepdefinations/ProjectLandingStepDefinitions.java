package arcadia.stepdefinations;
import arcadia.constants.EndPoint;
import arcadia.context.TestContext;
import arcadia.pages.PageFactoryManager;
import arcadia.pages.ProjectLanding;
import io.cucumber.java.en.And;

public class ProjectLandingStepDefinitions {
    private final ProjectLanding projectLanding;
    private final TestContext context;
    public ProjectLandingStepDefinitions(TestContext context){
        this.context = context;
        projectLanding = PageFactoryManager.getProjectLanding(context.driver);
    }
//    @And("Navigated to quickstart project")
//    public void navigateToProjectQuickStart(){
//        projectLanding.load(EndPoint.PROJECT.url);
//    }
}
