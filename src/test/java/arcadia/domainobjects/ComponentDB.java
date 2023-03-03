package arcadia.domainobjects;

public class ComponentDB {

    private String partnumber;
    private String description;
    private String family;
    private String status;
    private String supplier;
    private String supplierpn;
    private String colour;
    private String type;
    private String material;
    private Double internaldia;
    private Double externaldia;
    private Double maxlength;
    private String splittube;
    private String defaultlinefont;


    public ComponentDB(String partnumber, String description, String family, String status, String supplier, String supplierpn, String colour, String type, String material, Double internaldia, Double externaldia, Double maxlength, String splittube, String defaultlinefont) {
        this.partnumber = partnumber;
        this.description = description;
        this.family = family;
        this.status = status;
        this.supplier = supplier;
        this.supplierpn = supplierpn;
        this.colour = colour;
        this.type = type;
        this.material = material;
        this.internaldia = internaldia;
        this.externaldia = externaldia;
        this.maxlength = maxlength;
        this.splittube = splittube;
        this.defaultlinefont = defaultlinefont;
    }

    public String getPartnumber() {
        return partnumber;
    }

    public void setPartnumber(String partnumber) {
        this.partnumber = partnumber;
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

    public String getSupplierpn() {
        return supplierpn;
    }

    public void setSupplierpn(String supplierpn) {
        this.supplierpn = supplierpn;
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

    public Double getInternaldia() {
        return internaldia;
    }

    public void setInternaldia(Double internaldia) {
        this.internaldia = internaldia;
    }

    public Double getExternaldia() {
        return externaldia;
    }

    public void setExternaldia(Double externaldia) {
        this.externaldia = externaldia;
    }

    public Double getMaxlength() {
        return maxlength;
    }

    public void setmMxlength(Double maxlength) {
        this.maxlength = maxlength;
    }

    public String getSplittube() {
        return splittube;
    }

    public void setSplittube(String splittube) {
        this.splittube = splittube;
    }

    public String getDefaultlinefont() {
        return defaultlinefont;
    }

    public void setDefaultlinefont(String defaultlinefont) {
        this.defaultlinefont = defaultlinefont;
    }
}
