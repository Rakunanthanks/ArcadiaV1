package arcadia.domainobjects;

public class ComponentDB {

    private String partNumber;
    private String description;
    private String family;
    private String status;
    private String supplier;
    private String supplierPN;
    private String colour;
    private String type;
    private String material;
    private Double internalDiameter;
    private Double externalDiameter;
    private Double maximumLength;
    private String splitTube;
    private String defaultLineFont;


    public ComponentDB(String partNumber, String description, String family, String status, String supplier, String supplierPN, String colour, String type, String material, Double internalDiameter, Double externalDiameter, Double maximumLength, String splitTube, String defaultLineFont) {
        this.partNumber = partNumber;
        this.description = description;
        this.family = family;
        this.status = status;
        this.supplier = supplier;
        this.supplierPN = supplierPN;
        this.colour = colour;
        this.type = type;
        this.material = material;
        this.internalDiameter = internalDiameter;
        this.externalDiameter = externalDiameter;
        this.maximumLength = maximumLength;
        this.splitTube = splitTube;
        this.defaultLineFont = defaultLineFont;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getInternalDiameter() {
        return internalDiameter;
    }

    public void setInternalDiameter(Double internalDiameter) {
        this.internalDiameter = internalDiameter;
    }

    public Double getExternalDiameter() {
        return externalDiameter;
    }

    public void setExternalDiameter(Double externalDiameter) {
        this.externalDiameter = externalDiameter;
    }

    public Double getMaximumLength() {
        return maximumLength;
    }

    public void setMaximumLength(Double maximumLength) {
        this.maximumLength = maximumLength;
    }

    public String getSplitTube() {
        return splitTube;
    }

    public void setSplitTube(String splitTube) {
        this.splitTube = splitTube;
    }

    public String getDefaultLineFont() {
        return defaultLineFont;
    }

    public void setDefaultLineFont(String defaultLineFont) {
        this.defaultLineFont = defaultLineFont;
    }
}
