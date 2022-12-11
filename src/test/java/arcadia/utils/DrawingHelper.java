package arcadia.utils;

import arcadia.context.FlowContext;
import arcadia.domainobjects.ConnectorIdentifier;
import arcadia.domainobjects.ConnectorWireTable;
import arcadia.domainobjects.NodeIdentifier;
import arcadia.mapperObjects.DrawingInstructor;
import arcadia.pages.*;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.openqa.selenium.WebDriver;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.util.List;

public class DrawingHelper {

    public List<DrawingInstructor> getDrawingInstruction(String testIdentifier) throws IOException {
        String filePath = "src/test/resources/drawingboard/drawingboard-"+testIdentifier+".csv";
        Reader reader = new BufferedReader(new FileReader(filePath));
        CsvToBean<DrawingInstructor> csvReader = new CsvToBeanBuilder(reader)
                .withType(DrawingInstructor.class)
                .withSeparator(',')
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        return csvReader.parse();
    }

    public  void drawOrchestrator(List<DrawingInstructor> drawingInstructors, WebDriver driver) throws AWTException, InterruptedException {
        for(DrawingInstructor instructions : drawingInstructors){
            String context = instructions.getContext();
            switch(context.toLowerCase()){
                case "harness":
                    harnessOrchestrator(instructions,driver);
                    break;
                case "frame":
                    frameOrchestrator(instructions, driver);
                    break;
                case "bundle":
                    bundleOrchestrator(instructions,driver);
                    break;
                case "connector":
                    connectorOrchestrator(instructions, driver);
                    break;
                case "wireroute":
                    wireRouteOrchestrator(instructions,driver);
                    break;
                case "updatesleeve":
                    updateSleeveOrchestrator(instructions,driver);
                    break;
            }

        }
    }
    private void harnessOrchestrator(DrawingInstructor instructions,WebDriver driver) throws AWTException, InterruptedException {
        if(instructions.getCommand().contains("Click on")){
            String commandWord  = instructions.getCommand().split("Click on")[1].trim();
            switch (commandWord.toLowerCase()){
                case "frame":
                        new HarnessPage(driver).clickOnFrame();
                    break;
                case "bundle":
                    new HarnessPage(driver).clickOnBundle();
                    break;
                case "wireroute":
                    new HarnessPage(driver).clickOnWireRoute();
                    break;
                case "connector":
                    new HarnessPage(driver).clickOnConnector();
                    break;
                case "sleevetube":
                    new HarnessPage(driver).clickOnGlobalUpdateSleeve();
                    break;
            }
        }
    }
    private void frameOrchestrator(DrawingInstructor instructions, WebDriver driver) throws InterruptedException {
        if(instructions.getCommand().equalsIgnoreCase("Draw Frame") ){
            String frameSize = instructions.getFrameSize().trim();
            new FramePage(driver).chooseFrame(frameSize);
        }
    }
    private void updateSleeveOrchestrator(DrawingInstructor instructions, WebDriver driver) throws InterruptedException {
        if(instructions.getCommand().equalsIgnoreCase("Global Update") ){
            System.out.println("Global Update");
            if(instructions.getComments().equalsIgnoreCase("yes")){
                new GlobalUpdateSleeve(driver).updateGlobalSleeveTube(instructions.getComponentDB(),instructions.getCovering(),instructions.getMaterial(),instructions.getColour(),true);
            }

            if(!instructions.getComments().equalsIgnoreCase("yes")){
                new GlobalUpdateSleeve(driver).updateGlobalSleeveTube(instructions.getComponentDB(),instructions.getCovering(),instructions.getMaterial(),instructions.getColour(),false);
            }
        }
    }
    private void wireRouteOrchestrator(DrawingInstructor instructions, WebDriver driver) throws InterruptedException {
        if(instructions.getCommand().equalsIgnoreCase("Invoke WireRoute") ){
            System.out.println("Invoke WireRoute");
            if(instructions.getComments().equalsIgnoreCase("yes")){
                new WireRoutePage(driver).updateWireRoute(true);
            }
            if(!instructions.getComments().equalsIgnoreCase("yes")){
                new WireRoutePage(driver).updateWireRoute(false);
            }

        }
    }
    private void bundleOrchestrator(DrawingInstructor instructions, WebDriver driver) throws InterruptedException, AWTException {
        if(instructions.getCommand().equalsIgnoreCase("Draw bundle") ){
            new BundlePage(driver).drawBundle(instructions.getBundleCommand().trim());
        }
        if(instructions.getCommand().equalsIgnoreCase("Gather Node Element") ){
            new BundlePage(driver).getNodeElementFromDrawingPage();
        }
        if(instructions.getCommand().equalsIgnoreCase("Add insulation") ){
            new BundlePage(driver).addCoveringRow();
        }
        if(instructions.getCommand().equalsIgnoreCase("Move-DoubleClick") ){
            String xCoordinates = instructions.getCoordinates().split("-")[0];
            String yCoordinates = instructions.getCoordinates().split("-")[1];
            new BundlePage(driver).getBundlePage(xCoordinates,yCoordinates);
        }

        if(instructions.getCommand().equalsIgnoreCase("Gather Bundle Info") ){
            new BundlePage(driver).getValuesFromBundleForm(instructions.getComments().trim());
        }
        if(instructions.getCommand().equalsIgnoreCase("ChooseCovering") ){
            boolean isMultipleCoveringTypePresent = instructions.getMultipleCoveringType()!=null &&!instructions.getMultipleCoveringType().isBlank() && !instructions.getMultipleCoveringType().isEmpty();
            int coveringRowNumber = instructions.getNodeNumber();
            new BundlePage(driver).chooseCovering(instructions.getCovering(),coveringRowNumber,isMultipleCoveringTypePresent);
        }
    }
    private void connectorOrchestrator(DrawingInstructor instructions , WebDriver driver) throws InterruptedException {
        if(instructions.getCommand().equalsIgnoreCase("Add Connector")){
            Integer nodeReference = instructions.getNodeNumber();
            if(!FlowContext.nodeIdentifierList.isEmpty()){
                for( NodeIdentifier item : FlowContext.nodeIdentifierList){
                    if(String.valueOf(item.getNodeNumber()).trim().equals(String.valueOf(nodeReference).trim())){
                        new ConnectorPage(driver).addConnectorToNode(item.getNodeElementId(),instructions.getAddCavity(),instructions.getConnectorPartDescription(), String.valueOf(instructions.getCavityNumber()));
                        break;
                    }
                }
            }
        }
        if(instructions.getCommand().equalsIgnoreCase("Add Wire") ){
            List<ConnectorWireTable> connectorWireTableList = new ArrayList<>();
            String connectFrom = instructions.getConnectFrom();
            String connectTo = instructions.getConnectTo();
            List<String> cavityDetailsList = Arrays.asList(instructions.getCavity().split("~"));
            List<String> wiringDetailsList = Arrays.asList(instructions.getWiringDetails().split("~"));
            for( int i=0; i<cavityDetailsList.size();i++){
                ConnectorWireTable wireTable = new ConnectorWireTable();
                String fromCavity = cavityDetailsList.get(i).split("-")[0];
                String toCavity = cavityDetailsList.get(i).split("-")[1];
                String wiringPart = wiringDetailsList.get(i).split("-")[1];
                wireTable.setConnectFrom(connectFrom);
                wireTable.setConnectTo(connectTo);
                wireTable.setCavityFrom(fromCavity);
                wireTable.setCavityTo(toCavity);
                wireTable.setWireParts(wiringPart);
                connectorWireTableList.add(wireTable);
            }
            for(ConnectorIdentifier item : FlowContext.connectorIdentifierList){
                if(item.getConnectorId().trim().toLowerCase().equals(instructions.getConnectFrom().trim().toLowerCase())){
                    if(instructions.getComments().equalsIgnoreCase("submit connector")){
                        new ConnectorPage(driver).addWire(connectorWireTableList, true);
                    }
                    if(!instructions.getComments().equalsIgnoreCase("submit connector")){
                        new ConnectorPage(driver).addWire(connectorWireTableList, false);
                    }
                    break;
                }
            }
        }
        if(instructions.getCommand().equalsIgnoreCase("Open Connector") ){
            for(ConnectorIdentifier item : FlowContext.connectorIdentifierList){
                if(item.getConnectorId().trim().toLowerCase().equals(instructions.getConnectFrom().trim().toLowerCase())){
                    new ConnectorPage(driver).openConnectorForm(item.getConnectorReferenceNumber());
                    break;
                }
            }
        }
    }
}
