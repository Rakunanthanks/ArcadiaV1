package arcadia.pages.ComponentDB;

import arcadia.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class HeaderPanel extends BasePage {
    public HeaderPanel(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "button[value=\"Add New Component\"]") private WebElement addNewComponent;
    @FindBy(id = "btnImport") private WebElement importCsv;
    @FindBy(id = "idexport") private WebElement exportCsv;
    @FindBy(id = "dataexport") private WebElement exportData;
    @FindBy(id = "customExport") private WebElement exportCustomFields;
    @FindBy(id = "btnaddsimilar") private WebElement addSimilar;
    @FindBy(id = "btnmove") private WebElement btnCopy;
    @FindBy(id = "btnDelete") private WebElement btnHeaderDelete;
    @FindBy(css = "select[name=\"company\"]") private WebElement selectBoxCompany;

    public void openAddNewComponentPage(){
        addNewComponent.click();
    }

    public void invokeMainMenu(String menuName){
        List<WebElement> maninMenuElements = driver.findElements(By.cssSelector(".nav.navbar-nav.pull-right >li >a"));
        for(WebElement element : maninMenuElements){
            if(element.getAttribute("href").contains(menuName)){
                element.click();
                break;
            }
        }
    }

}
