package arcadia.domainobjects;

public class SealsComponentDB {
    private String partnumber;
    private String description;
    private String family;
    private String status;
    private String usage;
    private String supplier;
    private String supplierpn;
    private String colour;
    private String cavityplug;
    private String insulationod;

    public SealsComponentDB() {
    }

    public SealsComponentDB(String partNumber, String description, String family, String status, String usage, String supplier, String supplierPN, String colour, String cavity, String insulationOD) {
        this.partnumber = partNumber;
        this.description = description;
        this.family = family;
        this.status = status;
        this.usage = usage;
        this.supplier = supplier;
        this.supplierpn = supplier;
        this.colour = colour;
        this.cavityplug = cavity;
        this.insulationod = insulationOD;
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

    public String getCavityplug() {
        return cavityplug   ;
    }

    public void setCavityplug(String cavity) {
        this.cavityplug = cavity;
    }

    public String getInsulationod() {
        return insulationod;
    }

    public void setInsulationod(String insulationod) {
        this.insulationod = insulationod;
    }
}
