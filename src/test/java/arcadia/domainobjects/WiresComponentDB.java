package arcadia.domainobjects;

public class WiresComponentDB {
    private String partnumber;
    private String description;
    private String family;
    private String status;
    private String usage;

    private String manufacturerpartstatus;
    private String supplier;
    private String supplierpn;
    private String colour;
    private String awgsize;
    private String gauge;
    private Double wirecsa;
    private Double outsidedia;
    private String wirematerial;
    private Double minimumbendradius;
    private Double maxcurrent;

    private Double resistance;

    public WiresComponentDB(){

    }

    public WiresComponentDB(String partNumber, String description, String family, String status, String usage,String manufacturerpartstatus, String supplier, String supplierPN, String colour, String awgSize, String gauge, Double wireCSA, Double outsideDia, String material, Double minimumRadius, Double maxcurrent, Double resistance) {
        this.partnumber = partNumber;
        this.description = description;
        this.family = family;
        this.status = status;
        this.usage = usage;
        this.manufacturerpartstatus=manufacturerpartstatus;
        this.supplier = supplier;
        this.supplierpn = supplierPN;
        this.colour = colour;
        this.awgsize = awgSize;
        this.gauge = gauge;
        this.wirecsa = wireCSA;
        this.outsidedia = outsideDia;
        this.wirematerial = material;
        this.minimumbendradius = minimumRadius;
        this.maxcurrent = maxcurrent;
        this.resistance = resistance;
    }

    public String getPartnumber() {
        return partnumber;
    }

    public void setPartnumber(String partNumber) {
        this.partnumber = partNumber;
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

    public void setSupplierpn(String supplierPN) {
        this.supplierpn = supplierPN;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getAwgsize() {
        return awgsize;
    }

    public void setAwgsize(String awgSize) {
        this.awgsize = awgSize;
    }

    public String getGauge() {
        return gauge;
    }

    public void setGauge(String gauge) {
        this.gauge = gauge;
    }

    public Double getWirecsa() {
        return wirecsa;
    }

    public void setWirecsa(Double wireCSA) {
        this.wirecsa = wireCSA;
    }

    public Double getOutsidedia() {
        return outsidedia;
    }

    public void setOutsidedia(Double outsideDia) {
        this.outsidedia = outsideDia;
    }

    public String getWirematerial() {
        return wirematerial;
    }

    public void setWirematerial(String material) {
        this.wirematerial = material;
    }

    public Double getMinimumbendradius() {
        return minimumbendradius;
    }

    public void setMinimumbendradius(Double minimumRadius) {
        this.minimumbendradius = minimumRadius;
    }

    public Double getMaxcurrent() {
        return maxcurrent;
    }

    public void setMaxcurrent(Double maxcurrent) {
        this.maxcurrent = maxcurrent;
    }

    public Double getResistance() {
        return resistance;
    }

    public void setResistance(Double resistance) {
        this.resistance = resistance;
    }
}
