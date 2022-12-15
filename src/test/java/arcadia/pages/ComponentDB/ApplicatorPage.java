package arcadia.pages.ComponentDB;

import arcadia.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplicatorPage extends BasePage {
    public ApplicatorPage(WebDriver driver) {
        super(driver);
    }
    String applicatorsPartNumber = "table#Applicator_termsused input[rel=\"description\"]";
    String applicatorsPartDescription="table#Applicator_termsused [rel=\"PartNumber\"]+div input";
}
