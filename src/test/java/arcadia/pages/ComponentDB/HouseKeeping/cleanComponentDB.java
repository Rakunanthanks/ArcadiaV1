package arcadia.pages.ComponentDB.HouseKeeping;

import arcadia.pages.BasePage;
import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class cleanComponentDB  extends BasePage {
    public cleanComponentDB(WebDriver driver) {
        super(driver);
    }
    public void deleteRecordsInComponentDB(String componentDBElementName , String searchString ) throws InterruptedException {
        boolean proceedWithDelete = true;
        while (proceedWithDelete) {
            Thread.sleep(3000);
            WebElement element = driver.findElement(By.cssSelector("input[placeholder=\""+componentDBElementName+"\"]"));
            new SeleniumCustomCommand().waitForElementVisibility(driver,element);
            element.sendKeys(searchString);
            Thread.sleep(1000);
            element.sendKeys(Keys.ENTER);
            Thread.sleep(1000);
            boolean noRecordPresentMessageDisplayed = driver.findElements(By.cssSelector("#allcomponents >tbody >tr[class=\"no-records-found\"]")).size() > 0;
            if(noRecordPresentMessageDisplayed){
                proceedWithDelete = false;
            }
            if(proceedWithDelete){
                WebElement selectAll = driver.findElement(By.cssSelector("input[name=\"btSelectAll\"]"));
                selectAll.click();
                WebElement delete = driver.findElement(By.cssSelector("button[name=\"delete\"]"));
                delete.click();
                WebElement deleteConfirm = driver.findElement(By.cssSelector("button[data-bb-handler=\"confirm\"]"));
                new SeleniumCustomCommand().waitForElementVisibility(driver,deleteConfirm);
                deleteConfirm.click();
                Thread.sleep(2000);
                for (int i = 0; i < 50; i++) {
                    boolean isModelPresent = driver.findElements(By.cssSelector("div[class=\"bootbox-body\"]")).size() >0;
                    if(isModelPresent){
                        WebElement deleteSuccessBodyOk = driver.findElement(By.cssSelector("button[data-bb-handler=\"ok\"]"));
                        deleteSuccessBodyOk.click();
                        Thread.sleep(3000);
                        break;
                    }
                    Thread.sleep(3000);
                }
            }
        }
    }
    public void cleanHarness() throws InterruptedException {
        boolean proceedWithDelete = true;
        while (proceedWithDelete) {
            List<WebElement> harnessElement = driver.findElements(By.cssSelector("#tableHAR >tbody >tr"));
            boolean foundRecord = false;
            for (WebElement element: harnessElement) {
                List<WebElement> tdElements = element.findElements(By.cssSelector("td"));
                if(tdElements.get(3).getText().equalsIgnoreCase("Automation team")){
                    foundRecord = true;
                    tdElements.get(13).findElement(By.cssSelector("div >a[title=\"Delete Task\"]")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.cssSelector("button[data-bb-handler=\"confirm\"]")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.cssSelector("button[data-bb-handler=\"ok\"]")).click();
                    driver.navigate().refresh();
                    Thread.sleep(3000);
                    break;
                }
            }
            if(!foundRecord){
                proceedWithDelete = false;
            }
        }
    }

    public void initiateComponentDBHouseKeeping() throws InterruptedException {
        deleteRecordsInComponentDB("Company","testcompany");
        driver.navigate().refresh();
        Thread.sleep(1000);
        deleteRecordsInComponentDB("Description","testdescription-");
    }


}
