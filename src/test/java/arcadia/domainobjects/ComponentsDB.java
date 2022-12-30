package arcadia.domainobjects;

public class ComponentsDB {

    private String partNumber;
    private String description;
    private String family;
    private String status;
    private String usage;
    private String supplier;
    private String supplierPN;
    private Integer numberOfCavities;
    public ComponentsDB() {
    }

    public ComponentsDB(String partNumber, String description, String family, String status, String usage, String supplier, String supplierPN, Integer numberOfCavities) {
        this.partNumber = partNumber;
        this.description = description;
        this.family = family;
        this.status = status;
        this.usage = usage;
        this.supplier = supplier;
        this.supplierPN = supplierPN;
        this.numberOfCavities = numberOfCavities;
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

    public Integer getNumberOfCavities() {
        return numberOfCavities;
    }

    public void setNumberOfCavities(Integer numberOfCavities) {
        this.numberOfCavities = numberOfCavities;
    }
}