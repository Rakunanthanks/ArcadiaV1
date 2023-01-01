package arcadia.domainobjects;

public class ConnectorDB {

    private String partNumber;
    private String description;
    private String family;
    private String status;
    private String usage;
    private String supplier;
    private String supplierPN;
    private String colour;
    private String housingGender;
    private String terminalGender;
    private String connectorType;
    private Integer numberOfCavities;
    private String keyway;
    public ConnectorDB() {
    }

    public ConnectorDB(String partNumber, String description, String family, String status, String usage, String supplier, String supplierPN, String colour, String housingGender, String terminalGender, String connectorType, Integer numberOfCavities, String keyway) {
        this.partNumber = partNumber;
        this.description = description;
        this.family = family;
        this.status = status;
        this.usage = usage;
        this.supplier = supplier;
        this.supplierPN = supplierPN;
        this.colour = colour;
        this.housingGender = housingGender;
        this.terminalGender = terminalGender;
        this.connectorType = connectorType;
        this.numberOfCavities = numberOfCavities;
        this.keyway = keyway;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplierPN() {
        return supplierPN;
    }

    public void setSupplierPN(String supplierPN) {
        this.supplierPN = supplierPN;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getHousingGender() {
        return housingGender;
    }

    public void setHousingGender(String housingGender) {
        this.housingGender = housingGender;
    }

    public String getTerminalGender() {
        return terminalGender;
    }

    public void setTerminalGender(String terminalGender) {
        this.terminalGender = terminalGender;
    }

    public String getConnectorType() {
        return connectorType;
    }

    public void setConnectorType(String connectorType) {
        this.connectorType = connectorType;
    }

    public Integer getNumberOfCavities() {
        return numberOfCavities;
    }

    public void setNumberOfCavities(Integer numberOfCavities) {
        this.numberOfCavities = numberOfCavities;
    }

    public String getKeyway() {
        return keyway;
    }

    public void setKeyway(String keyway) {
        this.keyway = keyway;
    }
}