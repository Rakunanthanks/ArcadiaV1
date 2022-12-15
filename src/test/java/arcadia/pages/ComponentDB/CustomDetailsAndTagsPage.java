package arcadia.pages.ComponentDB;

import arcadia.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomDetailsAndTagsPage extends BasePage {
    public CustomDetailsAndTagsPage(WebDriver driver) {
        super(driver);
    }
    //CustomDetails
    @FindBy(css = "textarea[name=\"Custom_Details.customnotes\"]") private WebElement customNotes;
    @FindBy(css = "button[name=\"addcustEmprow\"]") private WebElement buttonAddCustomRow;
    @FindBy(css = "button[value=\"Load Custom Fields\"]") private WebElement buttonLoadCustomFields;
    String fieldType = "input[name=\"Custom_Details_Type\"],select[name=\"Custom_Details_Type\"]";
    String fieldName = "input[name=\"Custom_Details_Key\"]";
    String fieldDescription = "textarea[name=\"Custom_Details_Description\"]";
    String fieldValue = "input[name=\"Custom_Details_Val\"]";
    String buttonDeleteFieldRow = "button[name=\"removeCustRow\"][title=\"Delete\"]";
    //Tags
    String tagForonnector = "input[name=\"Tags.termsused.Tag\"]+div input";
}
