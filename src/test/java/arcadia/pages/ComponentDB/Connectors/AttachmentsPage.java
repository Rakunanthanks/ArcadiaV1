package arcadia.pages.ComponentDB.Connectors;

import arcadia.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AttachmentsPage extends BasePage {
    public AttachmentsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "Attachments") private WebElement tableAttachments;
    @FindBy(css = "button[value=\"Select Files to Upload\"]") private WebElement buttonSelectFilesToUpload;
    String buttonDeleteAttachments = "button#btnRemove";
}
