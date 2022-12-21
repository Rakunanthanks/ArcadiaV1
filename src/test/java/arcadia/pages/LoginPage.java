package arcadia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{
    @FindBy(id = "username") private WebElement userName;
    @FindBy(id = "password") private WebElement passWord;
    @FindBy(css = ".btn.btn-success") private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public  void Login(){
        new WebDriverWait(driver, Duration.ofSeconds(2000)).until(ExpectedConditions.elementToBeClickable(userName));
<<<<<<< HEAD
        System.out.println("component is " + System.getProperty("componentDB"));
        userName.sendKeys(System.getProperty("userName"));
        passWord.sendKeys(System.getProperty("password"));
=======
        userName.sendKeys("ragu");
        passWord.sendKeys("vQ3hZ0zQ2w@");
>>>>>>> 445fded (Created Test Scenario for Bundle Tolerance)
        submitButton.click();
    }

}
