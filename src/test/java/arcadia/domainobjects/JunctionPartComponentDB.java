package arcadia.domainobjects;

public class JunctionPartComponentDB {
    private String partnumber;
    private String description;
    private String family;
    private String status;
    private String usage;
    private String supplier;
    private String supplierpn;
    private String colour;
    private String type;
    private String material;
    private String rec_wall_thickness;
    public JunctionPartComponentDB() {

    }

    public JunctionPartComponentDB(String partnumber, String description, String family, String status, String usage, String supplier, String supplierpn, String colour, String type, String material, String rec_wall_thickness) {
        this.partnumber = partnumber;
        this.description = description;
        this.family = family;
        this.status = status;
        this.usage = usage;
        this.supplier = supplier;
        this.supplierpn = supplierpn;
        this.colour = colour;
        this.type = type;
        this.material = material;
        this.rec_wall_thickness = rec_wall_thickness;
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

    public String getRec_wall_thickness() {
        return rec_wall_thickness;
    }

    public void setRec_wall_thickness(String rec_wall_thickness) {
        this.rec_wall_thickness = rec_wall_thickness;
    }
}