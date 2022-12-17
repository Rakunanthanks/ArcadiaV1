package arcadia.pages.ComponentDB;

import arcadia.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonElements extends BasePage {
    public CommonElements(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "idaddrow") WebElement buttonAddRow;
    @FindBy(id = "loadDataDb") WebElement buttonLoadDataDB;
    @FindBy(css = "button[value=\"Update Component\"]") WebElement updateComponent;
    String buttonMoveUp = "button[title=\"Move Up\"]";
    String buttonMoveDown = "button[title=\"Move Down\"]";
    String buttonDelete = "button[title=\"Delete\"]";
    @FindBy(id = "btnReset") WebElement resetButton;
}
