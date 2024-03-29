package arcadia.utils;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.python.antlr.ast.Str;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.net.URI;
import java.net.URISyntaxException;

public class SeleniumCustomCommand {
    public void enterText(WebElement element , String value){
        if (value != null || !value.isEmpty() || !value.trim().isEmpty()){
            element.sendKeys(value);
        }

    }
    public void selectDropDownByValue(WebElement element ,String value) throws InterruptedException {
        if (value != null || !value.isEmpty() || !value.trim().isEmpty()){
            Select dropDownElement = new Select(element);
            dropDownElement.selectByValue(value);
            Thread.sleep(2000);
        }
    }
    public void selectDropDownByVisibleText(WebElement element ,String value) throws InterruptedException {
        if (value != null || !value.isEmpty() || !value.trim().isEmpty()){
            Select dropDownElement = new Select(element);
            dropDownElement.selectByVisibleText(value);
            Thread.sleep(2000);
        }
    }

    public void selectDropDownByContainsText(WebElement element ,String value) throws InterruptedException {
        if (value != null || !value.isEmpty() || !value.trim().isEmpty()){
            Select dropDownElement = new Select(element);
            dropDownElement.getOptions().parallelStream().filter(option -> option.getText().toLowerCase().contains(value.toLowerCase()))
                    .findFirst().ifPresent(option -> dropDownElement.selectByVisibleText(option.getText()));
            Thread.sleep(2000);
        }
    }

    public void waitForElementVisibility(WebDriver driver , WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.visibilityOf(element));
    }
    public void LongWaitForElementVisibility(WebDriver driver , WebElement element){
        new WebDriverWait(driver, Duration.ofMinutes(1)).until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementToBeClickable(WebDriver driver , WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.elementToBeClickable(element));
    }
    public void longWaitForElementToBeClickable(WebDriver driver , WebElement element){
        new WebDriverWait(driver, Duration.ofMinutes(1)).until(ExpectedConditions.elementToBeClickable(element));
    }
    public void simulateKeyEnterWithValue(WebElement element , String value){
        if (value != null || !value.isEmpty() || !value.trim().isEmpty()){
            element.sendKeys(value);
            element.sendKeys(Keys.ENTER);
        }
    }
    public void scrollIntoView(WebDriver driver , WebElement element) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000);
    }

    public void javaScriptClick(WebDriver driver , WebElement element) throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
        Thread.sleep(1000);
    }

    public void javaScriptClickAndEnterValue(WebDriver driver , WebElement element,String value) throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
        ((JavascriptExecutor)driver).executeScript("arguments[0].value='';", element);
        ((JavascriptExecutor)driver).executeScript("arguments[0].value='"+value+"'", element);
        Thread.sleep(1000);
    }

    public String javaScriptGetValueOfElement(WebDriver driver, WebElement element)
    {
        String value= String.valueOf(((JavascriptExecutor)driver).executeScript("return arguments[0].value", element));
        return value;
    }

    public void movePointerAndDoubleClick(int xCoordinates , int yCoordinates) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        robot.mouseMove(xCoordinates, yCoordinates);
        Thread.sleep(2000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);
    }

    public void movePointerAndClick(int xCoordinates , int yCoordinates) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        robot.mouseMove(xCoordinates, yCoordinates);
        Thread.sleep(2000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);
    }


    public String getValueByJavascriptExecutor(WebDriver driver , WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String elementValue = (String) jse.executeScript("return arguments[0].value", element);
        return  elementValue;
    }

    public void mouseHover(WebDriver driver , WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void waitClick(WebElement element) throws InterruptedException {
        long endTime = System.nanoTime() + TimeUnit.NANOSECONDS.convert(1L, TimeUnit.MINUTES);
        boolean elementVisible = false;
        while (!elementVisible && System.nanoTime() < endTime) {
            try {
                element.click();
                elementVisible = true;
            }
            catch(Exception e) {
                elementVisible = false;
                Thread.sleep(1000);
            }

        }

    }
    public void simulateKeyEnter() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(200);
    }

    public void rightClick(WebDriver driver,WebElement ele)
    {
        Actions a = new Actions(driver);
        a.moveToElement(ele).contextClick().build().perform();
    }

    public void doubleClick(WebDriver driver , WebElement element){
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public void clearAndEnterText(WebElement ele, String value) {
     ele.clear();
     if (value != null || !value.isEmpty() || !value.trim().isEmpty()){
     ele.sendKeys(value);
    }
    }


    public String getSelectedValueFromSelectDropDown(WebElement element) {
        Select select = new Select(element);
        WebElement option = select.getFirstSelectedOption();
        String selectedvalue = option.getText();
        return selectedvalue;
    }

    public File[] getAllFilesInAFolder(String path)
    {
        File fObj = new File(path);
        File files[] = fObj.listFiles();
        return files;
    }

    public void moveToElementAndClick(WebDriver driver , WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    public void moveToElementAndDoubleClick(WebDriver driver , WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).doubleClick().perform();
    }

    public void tabKey( ) throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.delay(200);
    }
    public void moveRightOfElementAndContextClick(WebDriver driver , WebElement element, int offsetRight){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).moveByOffset(offsetRight,0).contextClick().build().perform();
    }
    public void moveRightOfElementAndClick(WebDriver driver , WebElement element, int offsetRight){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).moveByOffset(offsetRight,0).click().build().perform();
    }

    public void moveElementByOffset(WebDriver driver,WebElement element, int x, int y)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        js.executeScript("window.scrollBy(arguments[1], arguments[2]);", element, x, y);
        js.executeScript("arguments[0].click();", element);
    }

    public void moveByOffsetOfElementAndClick(WebDriver driver , WebElement element, int offsetX, int offsetY){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).moveByOffset(offsetX,offsetY).click().build().perform();
    }

    public void moveByOffsetAndClick(WebDriver driver, int offsetX, int offsetY){
        Actions actions = new Actions(driver);
        actions.moveByOffset(offsetX,offsetY).click().perform();
    }
    public void moveToElementAndContextClick(WebDriver driver , WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).contextClick().build().perform();
    }

    public void scrollToElement(WebDriver driver,WebElement ele)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollBy(50,0);", ele);
    }

    public void scrollToBottom(WebDriver driver)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void pressKey(WebDriver driver,String keyName) throws AWTException {
        String key="";
        switch (keyName.toLowerCase()){
            case "escape":
                key = String.valueOf(Keys.ESCAPE);
                break;
            case "tab":
                key = String.valueOf(Keys.TAB);
                break;
            case "down":
                key=String.valueOf(Keys.DOWN);
                break;
            case "enter":
                key =String.valueOf(Keys.ENTER);
                break;
        }
        Actions actions = new Actions(driver);
        actions.sendKeys(key).perform();
    }

    public void dragAndDropByOffset(WebDriver driver,WebElement source,int xOffset,int yOffset)
    {
        Actions actions = new Actions(driver);
        Action dragAndDrop = actions.clickAndHold(source)
                .moveByOffset(xOffset, yOffset)
                .release()
                .build();
        dragAndDrop.perform();
    }

    public String extractTaskID(String url) {
        String[] queryParams = url.split("&");
        for (String param : queryParams) {
            if (param.startsWith("taskID=")) {
                return param.substring("taskID=".length());
            }
        }
        return null;
    }

    public void clickAtLocation(WebDriver driver,int x, int y)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "document.elementFromPoint(" + x + ", " + y + ").click();";
        js.executeScript(script);
    }

    public void clearFolder(String folderPath) {
        File folder = new File(folderPath);

        // Check if the folder exists
        if (folder.exists() && folder.isDirectory()) {
            // Get all files in the folder
            File[] files = folder.listFiles();

            // Iterate over the files and delete them
            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }

            System.out.println("Folder cleared successfully.");
        } else {
            System.out.println("Folder does not exist or is not a directory.");
        }
    }

    public void updateCSVColumn(String inputFilePath,String outputFilePath,String oldValue,String newValue)
    {

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                for (int i = 0; i < values.length; i++) {
                    if (values[i].equals(oldValue)) {
                        values[i] = newValue;
                    }
                }
                String updatedLine = String.join(",", values);
                writer.write(updatedLine);
                writer.newLine();
            }

            System.out.println("New CSV file created successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}