package arcadia.domainobjects;

public class WiresComponentDB {
    private String partNumber;
    private String description;
    private String family;
    private String status;
    private String usage;
    private String supplier;
    private String supplierPN;
    private String colour;
    private String awgSize;
    private String gauge;
    private Double wireCSA;
    private Double outsideDia;
    private String material;
    private Double minimumRadius;
    private Double maxcurrent;

    private Double resistance;

    public WiresComponentDB(String partNumber, String description, String family, String status, String usage, String supplier, String supplierPN, String colour, String awgSize, String gauge, Double wireCSA, Double outsideDia, String material, Double minimumRadius, Double maxcurrent, Double resistance) {
        this.partNumber = partNumber;
        this.description = description;
        this.family = family;
        this.status = status;
        this.usage = usage;
        this.supplier = supplier;
        this.supplierPN = supplierPN;
        this.colour = colour;
        this.awgSize = awgSize;
        this.gauge = gauge;
        this.wireCSA = wireCSA;
        this.outsideDia = outsideDia;
        this.material = material;
        this.minimumRadius = minimumRadius;
        this.maxcurrent = maxcurrent;
        this.resistance = resistance;
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

    public String getAwgSize() {
        return awgSize;
    }

    public void setAwgSize(String awgSize) {
        this.awgSize = awgSize;
    }

    public String getGauge() {
        return gauge;
    }

    public void setGauge(String gauge) {
        this.gauge = gauge;
    }

    public Double getWireCSA() {
        return wireCSA;
    }

    public void setWireCSA(Double wireCSA) {
        this.wireCSA = wireCSA;
    }

    public Double getOutsideDia() {
        return outsideDia;
    }

    public void setOutsideDia(Double outsideDia) {
        this.outsideDia = outsideDia;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getMinimumRadius() {
        return minimumRadius;
    }

    public void setMinimumRadius(Double minimumRadius) {
        this.minimumRadius = minimumRadius;
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
