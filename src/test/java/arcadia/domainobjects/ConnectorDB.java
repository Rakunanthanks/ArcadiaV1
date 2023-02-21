package arcadia.domainobjects;

public class ConnectorDB {

    private String partnumber;
    private String description;
    private String family;
    private String status;
    private String usage;
    private String supplier;
    private String supplierpn;
    private String colour;
    private String housingGender;
    private String gender;
    private String ttype;
    private Integer noofcavity;
    private String keyway;
    public ConnectorDB() {
    }

    public ConnectorDB(String partNumber, String description, String family, String status, String usage, String supplier, String supplierPN, String colour, String housingGender, String terminalGender, String connectorType, Integer numberOfCavities, String keyway) {
        this.partnumber = partNumber;
        this.description = description;
        this.family = family;
        this.status = status;
        this.usage = usage;
        this.supplier = supplier;
        this.supplierpn = supplierPN;
        this.colour = colour;
        this.housingGender = housingGender;
        this.gender = terminalGender;
        this.ttype = connectorType;
        this.noofcavity = numberOfCavities;
        this.keyway = keyway;
    }

    public String getPartnumber() {
        return partnumber;
    }

    public void setPartnumber(String partNumber) {
        this.partnumber = partNumber;
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

    public String getSupplierpn() {
        return supplierpn;
    }

    public void setSupplierpn(String supplierPN) {
        this.supplierpn = supplierPN;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getHousinggender() {
        return housingGender;
    }

    public void setHousinggender(String housingGender) {
        this.housingGender = housingGender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String terminalGender) {
        this.gender = terminalGender;
    }

    public String getTtype() {
        return ttype;
    }

    public void setTtype(String connectorType) {
        this.ttype = connectorType;
    }

    public Integer getNoofcavity() {
        return noofcavity;
    }

    public void setNoofcavity(Integer numberOfCavities) {
        this.noofcavity = numberOfCavities;
    }

    public String getKeyway() {
        return keyway;
    }

    public void setKeyway(String keyway) {
        this.keyway = keyway;
    }
}