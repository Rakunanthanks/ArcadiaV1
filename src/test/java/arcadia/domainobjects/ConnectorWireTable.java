package arcadia.domainobjects;

public class ConnectorWireTable {
    private String cavityFrom;
    private String cavityTo;
    private String connectFrom;
    private String connectTo;
    private String wireParts;
    public String getConnectFrom() {
        return connectFrom;
    }
    public void setConnectFrom(String connectFrom) {
        this.connectFrom = connectFrom;
    }
    public String getConnectTo() {
        return connectTo;
    }
    public void setConnectTo(String connectTo) {
        this.connectTo = connectTo;
    }
    public String getWireParts() {
        return wireParts;
    }
    public void setWireParts(String wireParts) {
        this.wireParts = wireParts;
    }
    public String getCavityFrom() {
        return cavityFrom;
    }
    public void setCavityFrom(String cavityFrom) {
        this.cavityFrom = cavityFrom;
    }
    public String getCavityTo() {
        return cavityTo;
    }
    public void setCavityTo(String cavityTo) {
        this.cavityTo = cavityTo;
    }
}
