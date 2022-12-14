package arcadia.pages.ComponentDB;

import arcadia.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonElements extends BasePage {
    public CommonElements(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "idaddrow") private WebElement buttonAddRow;
    @FindBy(id = "loadDataDb") private WebElement buttonLoadDataDB;
    @FindBy(css = "button[value=\"Update Component\"]") private WebElement updateComponent;
    String buttonMoveUp = "button[title=\"Move Up\"]";
    String buttonMoveDown = "button[title=\"Move Down\"]";
    String buttonDelete = "button[title=\"Delete\"]";
}
