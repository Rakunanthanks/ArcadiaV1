package arcadia.domainobjects;

public class ComponentDetails {
    private String description;
    private String family;
    private String status;
    private String typecode;
    private String proprietary;
    private String parttype;
    private String primarycolour;
    private String secondarycolour;
    private String tertiarycolour;
    private String materialcode;
    private String usage;
    private String partcategory;

    public ComponentDetails(String description, String family, String status, String typecode, String proprietary, String parttype, String primarycolour, String secondarycolour, String tertiarycolour, String materialcode, String usage, String partcategory) {
        this.description = description;
        this.family = family;
        this.status = status;
        this.typecode = typecode;
        this.proprietary = proprietary;
        this.parttype = parttype;
        this.primarycolour = primarycolour;
        this.secondarycolour = secondarycolour;
        this.tertiarycolour = tertiarycolour;
        this.materialcode = materialcode;
        this.usage = usage;
        this.partcategory = partcategory;
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

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public String getProprietary() {
        return proprietary;
    }

    public void setProprietary(String proprietary) {
        this.proprietary = proprietary;
    }

    public String getParttype() {
        return parttype;
    }

    public void setParttype(String parttype) {
        this.parttype = parttype;
    }

    public String getPrimarycolour() {
        return primarycolour;
    }

    public void setPrimarycolour(String primarycolour) {
        this.primarycolour = primarycolour;
    }

    public String getSecondarycolour() {
        return secondarycolour;
    }

    public void setSecondarycolour(String secondarycolour) {
        this.secondarycolour = secondarycolour;
    }

    public String getTertiarycolour() {
        return tertiarycolour;
    }

    public void setTertiarycolour(String tertiarycolour) {
        this.tertiarycolour = tertiarycolour;
    }

    public String getMaterialcode() {
        return materialcode;
    }

    public void setMaterialcode(String materialcode) {
        this.materialcode = materialcode;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getPartcategory() {
        return partcategory;
    }

    public void setPartcategory(String partcategory) {
        this.partcategory = partcategory;
    }
}
