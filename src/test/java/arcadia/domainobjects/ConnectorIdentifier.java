package arcadia.domainobjects;

public class ConnectorIdentifier {

    private String connectorId;

    public ConnectorIdentifier(String connectorId, String connectorReference) {
        this.connectorId =connectorId;
        this.connectorReferenceNumber = connectorReference;
    }

    public String getConnectorId() {
        return connectorId;
    }

    public void setConnectorId(String connectorId) {
        this.connectorId = connectorId;
    }

    public String getConnectorReferenceNumber() {
        return connectorReferenceNumber;
    }

    public void setConnectorReferenceNumber(String connectorReferenceNumber) {
        this.connectorReferenceNumber = connectorReferenceNumber;
    }

    private String connectorReferenceNumber;
}
