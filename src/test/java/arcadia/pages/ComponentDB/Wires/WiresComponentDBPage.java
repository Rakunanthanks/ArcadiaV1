package arcadia.pages.ComponentDB.Wires;

import arcadia.domainobjects.WiresComponentDB;
import arcadia.pages.BasePage;
import arcadia.pages.ComponentDB.CommonElements;
import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class WiresComponentDBPage extends BasePage {
    public WiresComponentDBPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#grid >.bootstrap-table >.fixed-table-container >.fixed-table-pagination >.pull-left.pagination-detail >.page-list >.btn-group.dropup >button >.caret") private WebElement paginationDropdown;
    @FindBy(css = "#grid >.bootstrap-table >.fixed-table-container >.fixed-table-pagination >.pull-left.pagination-detail >.page-list >.btn-group.dropup >.dropdown-menu>li:last-child >a") private WebElement paginationAll;
    String tableWireRows = "#tblwire > tbody > tr";
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();

    public List<WiresComponentDB> getWiresData() throws InterruptedException {
        new CommonElements(driver).getFullPagination();
        List<WiresComponentDB> componentDbData = new ArrayList<>();
        List<WebElement> componentDbElement = driver.findElements(By.cssSelector(tableWireRows));
        int i = 0;
        for( WebElement element : componentDbElement){
            i++;
            List<WebElement> tdElements = element.findElements(By.cssSelector("td"));
            String partNumber = tdElements.get(1).getText();
            String description= tdElements.get(2).getText();
            String family= tdElements.get(3).getText();
            String status= tdElements.get(5).getText();
            String usage= tdElements.get(6).getText();
            String supplier= tdElements.get(7).getText();
            String supplierPN= tdElements.get(8).getText();
            String colour= tdElements.get(9).getText();
            String awgSize= tdElements.get(10).getText();
            String gauge= tdElements.get(11).getText();
            Double wireCSA= Double.valueOf(tdElements.get(12).getText());
            Double outsideDia= Double.valueOf(tdElements.get(13).getText());
            String material= tdElements.get(14).getText();
            Double minimumRadius= Double.valueOf(tdElements.get(15).getText());
            Double maxcurrent= Double.valueOf(tdElements.get(16).getText());
            Double resistance= Double.valueOf(tdElements.get(17).getText());

            componentDbData.add(new WiresComponentDB(partNumber,description,family,status,usage,supplier,supplierPN,colour,awgSize,gauge,wireCSA,outsideDia,material,minimumRadius,maxcurrent,resistance));
        }
        return componentDbData;
    }

    public WiresComponentDB getRandomWireComponent(List<WiresComponentDB> wiresComponentDBList){
        Random rand = new Random();
        return wiresComponentDBList
            .get(rand.nextInt(wiresComponentDBList.size()));
    }

}
