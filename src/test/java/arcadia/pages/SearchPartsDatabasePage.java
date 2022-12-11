package arcadia.pages;

import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPartsDatabasePage extends BasePage{
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    @FindBy(xpath = "//span[contains(text(),\"Populate\")]") private WebElement populate;
    @FindBy(css = "input[name=\"nCavities\"]") private WebElement numberOfCavities;
    @FindBy(css = "select[name=\"library\"]") private WebElement partsComponentDB;
    @FindBy(css = "input[name=\"concompntType\"]") private WebElement componentType;
    @FindBy(css = "input[name=\"conPartNumber\"]") private WebElement pnDescription;
    @FindBy(css = "input[name=\"nFamily\"]") private WebElement family;
    @FindBy(css = "input[name=\"nGroupname\"]") private WebElement partType;
    @FindBy(css = "input[name=\"housingGender\"]") private WebElement housingGender;
    @FindBy(css = "input[name=\"gender\"]") private WebElement gender;
    public SearchPartsDatabasePage(WebDriver driver) {
        super(driver);
    }

    public void findInSearchPartDatabase(String description , String cavityCount) throws InterruptedException {
        Thread.sleep(2000);
        customCommand.waitForElementToBeClickable(driver,pnDescription);
        customCommand.enterText(pnDescription,description);
        customCommand.simulateKeyEnterWithValue(numberOfCavities,cavityCount);
    }
    public  void populateParts() throws InterruptedException{
        Thread.sleep(2000);
        customCommand.waitForElementVisibility(driver,populate);
        this.populate.click();
    }
}
