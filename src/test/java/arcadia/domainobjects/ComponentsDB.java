package arcadia.domainobjects;

public class ComponentsDB {

    private String partnumber;
    private String description;
    private String family;
    private String status;
    private String usage;

    private String manufacturerpartstatus;
    private String supplier;
    private String supplierpn;
    private Integer noofcavity;
    public ComponentsDB() {
    }

    public ComponentsDB(String partNumber, String description, String family, String status, String usage,String manufacturerpartstatus,  String supplier, String supplierPN, Integer numberOfCavities) {
        this.partnumber = partNumber;
        this.description = description;
        this.family = family;
        this.status = status;
        this.usage = usage;
        this.manufacturerpartstatus=manufacturerpartstatus;
        this.supplier = supplier;
        this.supplierpn = supplierPN;
        this.noofcavity = numberOfCavities;
    }

    public String getPartnumber() {
        return partnumber;
    }

    public void setPartnumber(String partnumber) {
        this.partnumber = partnumber;
    }
    public String getManufacturerpartstatus() {
        return manufacturerpartstatus;
    }

    public void setManufacturerpartstatus(String manufacturerpartstatus) {
        this.manufacturerpartstatus = manufacturerpartstatus;
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

    public void setSupplierpn(String supplierpn) {
        this.supplierpn = supplierpn;
    }

    public Integer getNoofcavity() {
        return noofcavity;
    }

    public void setNoofcavity(Integer noofcavity) {
        this.noofcavity = noofcavity;
    }
}