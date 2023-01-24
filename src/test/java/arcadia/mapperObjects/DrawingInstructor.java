package arcadia.mapperObjects;

import com.opencsv.bean.CsvBindByName;

public class DrawingInstructor {
    public String getContext() {
        return Context;
    }

    public void setContext(String context) {
        this.Context = context;
    }

    public String getSubContext() {
        return SubContext;
    }

    public void setSubContext(String subContext) {
        this.SubContext = subContext;
    }

    public String getCommand() {
        return Command;
    }

    public void setCommand(String command) {
        this.Command = command;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        this.Comments = comments;
    }


    public String getConnectorPartDescription() {
        return ConnectorPartDescription;
    }

    public void setConnectorPartDescription(String connectorPartDescription) {
        ConnectorPartDescription = connectorPartDescription;
    }

    public Integer getCavityNumber() {
        return CavityNumber;
    }

    public void setCavityNumber(Integer cavityNumber) {
        this.CavityNumber = cavityNumber;
    }

    public Integer getAddCavity() {
        return AddCavity;
    }

    public void setAddCavity(Integer addCavity) {
        this.AddCavity = addCavity;
    }

    public String getConnectTo() {
        return ConnectTo;
    }

    public void setConnectTo(String connectTo) {
        this.ConnectTo = connectTo;
    }

    public String getWireParts() {
        return WireParts;
    }

    public void setWireParts(String wireParts) {
        this.WireParts = wireParts;
    }
    @CsvBindByName
    private String Context;
    @CsvBindByName
    private String SubContext;
    @CsvBindByName
    private String Command;
    @CsvBindByName
    private String Comments;

    public Integer getNodeNumber() {
        return NodeNumber;
    }

    public void setNodeNumber(Integer nodeNumber) {
        this.NodeNumber = nodeNumber;
    }
    @CsvBindByName
    private Integer NodeNumber;
    @CsvBindByName
    private String ConnectorPartDescription;
    @CsvBindByName
    private Integer CavityNumber;
    @CsvBindByName
    private Integer AddCavity;
    @CsvBindByName
    private String ConnectTo;
    @CsvBindByName
    private String WireParts;
    @CsvBindByName
    private String FrameSize;

    public String getComponentDB() {
        return componentDB;
    }

    public void setComponentDB(String componentDB) {
        this.componentDB = componentDB;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @CsvBindByName
    private String componentDB;
    @CsvBindByName
    private String material;
    @CsvBindByName
    private String colour;

    public String getMultipleCoveringType() {
        return multipleCoveringType;
    }

    public void setMultipleCoveringType(String multipleCoveringType) {
        this.multipleCoveringType = multipleCoveringType;
    }

    @CsvBindByName
    private String multipleCoveringType;
    public String getCovering() {
        return covering;
    }

    public void setCovering(String covering) {
        this.covering = covering;
    }

    @CsvBindByName
    private String covering;
    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    @CsvBindByName
    private String coordinates;
    public String getConnectFrom() {
        return ConnectFrom;
    }

    public void setConnectFrom(String connectFrom) {
        this.ConnectFrom = connectFrom;
    }

    public String getWiringDetails() {
        return WiringDetails;
    }

    public void setWiringDetails(String wiringDetails) {
        this.WiringDetails = wiringDetails;
    }

    public String getCavity() {
        return Cavity;
    }

    public void setCavity(String cavity) {
        this.Cavity = cavity;
    }

    @CsvBindByName
    private String ConnectFrom;
    @CsvBindByName
    private String WiringDetails;
    @CsvBindByName
    private String Cavity;

    public String getBundleCommand() {
        return BundleCommand;
    }

    public void setBundleCommand(String bundleCommand) {
        this.BundleCommand = bundleCommand;
    }

    @CsvBindByName
    private String BundleCommand;
    public String getFrameSize() {
        return FrameSize;
    }

    public void setFrameSize(String frameSize) {
        this.FrameSize = frameSize;
    }



    public String getDraw() {
        return Draw;
    }

    public void setDraw(String draw) {
        this.Draw = draw;
    }

    @CsvBindByName
    private String Draw;

    public String getWireod() { return wireod;}
    public  void setWireod(String wireod){this.wireod=wireod;}

    @CsvBindByName
    private String wireod;

    public String getFamily() { return family;}
    public  void setFamily(String family){this.family=family;}

    @CsvBindByName
    private String family;

    public String getType() { return type;}
    public  void setType(String type){this.type=type;}

    @CsvBindByName
    private String type;

    public String getFinish() { return finish;}
    public  void setFinish(String finish){this.finish=finish;}

    @CsvBindByName
    private String finish;

    public String getCmaterial() { return cmaterial;}
    public  void setCmaterial(String material){this.cmaterial=cmaterial;}

    @CsvBindByName
    private String cmaterial;

    public String getGender() { return gender;}
    public  void setGender(String gender){this.gender=gender;}

    @CsvBindByName
    private String gender;

}
