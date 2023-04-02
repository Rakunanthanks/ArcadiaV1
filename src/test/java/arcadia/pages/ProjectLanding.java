package arcadia.pages;

import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ProjectLanding extends BasePage {
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    public ProjectLanding(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "a[title=\"Create Harness\"]") private WebElement createHarness;
    @FindBy(css = "a[title=\"Create Schematic\"]") private WebElement createSchematic;

    //Add project
     @FindBy(css = "button#addProject") private WebElement buttonAddProject;
    @FindBy(css = "input[name=\"projectName\"]") private WebElement inputProjectName;
    @FindBy(css = "input[name=\"data.description\"]") private WebElement inputProjectDescription;
    @FindBy(css = "input[name=\"data.tags\"]") private WebElement inputProjectTags;
    @FindBy(css = "select[name=\"data.editableStatus\"]") private WebElement selectProjectEditableStatus;
    @FindBy(css = "select[name=\"data.profile\"]") private WebElement selectProjectProfile;
    @FindBy(css = "div[aria-labelledby=\"addProject\"] button#formSubmit") private WebElement buttonSubmitAddProject;
    public void invokeCreateHarness(){
        customCommand.waitForElementToBeClickable(driver,createHarness);
        createHarness.click();
    }
    public void invokeCreateSchematic(){
        customCommand.waitForElementToBeClickable(driver,createSchematic);
        createSchematic.click();
    }

    public void verifyProjectsPageOpened(){
        customCommand.waitForElementVisibility(driver,buttonAddProject);
        Assert.assertTrue(buttonAddProject.isDisplayed());
    }

    public Boolean checkProjectExists(String projectName){
        List<WebElement> listOfElements = driver.findElements(By.xpath("//div[@id=\"example-tables\"]//div[@tabulator-field=\"projectname\" and contains(text(),\""+projectName+"\")]"));
        if (listOfElements.size()==1){
            return true;
        }
        else {
            return false;
        }
    }

    public void addProject(String projectName) throws InterruptedException {
        customCommand.waitForElementToBeClickable(driver,buttonAddProject);
        buttonAddProject.click();
        customCommand.waitForElementVisibility(driver,inputProjectName);
        customCommand.clearAndEnterText(inputProjectName,projectName);
        customCommand.clearAndEnterText(inputProjectDescription,projectName);
        customCommand.selectDropDownByValue(selectProjectProfile,System.getProperty("profileName"));
        buttonSubmitAddProject.click();
        customCommand.waitForElementToBeClickable(driver,buttonAddProject);
        Assert.assertTrue(checkProjectExists(projectName), "Project could not be created");
    }

}
