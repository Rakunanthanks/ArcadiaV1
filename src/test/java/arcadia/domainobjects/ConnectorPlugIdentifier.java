package arcadia.domainobjects;

public class ConnectorPlugIdentifier {

    private String connectorId;

    public ConnectorPlugIdentifier(String connectorId) {
        this.connectorId =connectorId;
    }

    public String getConnectorId() {
        return connectorId;
    }

    public void setConnectorId(String connectorId) {
        this.connectorId = connectorId;
    }
}
