package arcadia.domainobjects;

public class OtherPartsComponentDB {
    private String partnumber;
    private String description;
    private String family;
    private String status;
    private String manufacturerpartstatus;
    private String usage;
    private String supplier;
    private String supplierpn;
    private String colour;

    public OtherPartsComponentDB() {

    }

    public OtherPartsComponentDB(String partNumber, String description, String family, String status, String manufacturerPartStatus, String usage, String supplier, String supplierPN, String colour) {
        this.partnumber = partNumber;
        this.description = description;
        this.family = family;
        this.status = status;
        this.manufacturerpartstatus = manufacturerPartStatus;
        this.usage = usage;
        this.supplier = supplier;
        this.supplierpn = supplierPN;
        this.colour = colour;
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
    public String getManufacturerpartstatus() {
        return manufacturerpartstatus;
    }

    public void setManufacturerpartstatus(String manufacturerPartStatus) {
        this.manufacturerpartstatus = manufacturerPartStatus;
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
}