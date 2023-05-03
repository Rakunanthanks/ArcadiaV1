package arcadia.domainobjects;

public class ApplicatorsComponentDB {

    private String partnumber;
    private String description;
    private String family;
    private String status;
    private String manufacturerpartstatus;
    private String usage;
    private String supplier;
    private String supplierpn;
    private String colour;
    private String applicatorusage;
    private String forsealorterminal;
    private String applicatorinservice;
    private String applicatorsite;
    public ApplicatorsComponentDB() {
    }
    public ApplicatorsComponentDB(String partNumber, String description, String family, String status, String manufacturerPartStatus, String usage, String supplier, String supplierPN, String colour, String applicatorUsage, String forSealOrTerminal, String inService, String applicatorSite) {
        this.partnumber = partNumber;
        this.description = description;
        this.family = family;
        this.status = status;
        this.manufacturerpartstatus = manufacturerPartStatus;
        this.usage = usage;
        this.supplier = supplier;
        this.supplierpn = supplierPN;
        this.colour = colour;
        this.applicatorusage = applicatorUsage;
        this.forsealorterminal = forSealOrTerminal;
        this.applicatorinservice = inService;
        this.applicatorsite = applicatorSite;
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

    public String getApplicatorusage() {
        return applicatorusage;
    }

    public void setApplicatorusage(String applicatorUsage) {
        this.applicatorusage = applicatorUsage;
    }

    public String getForsealorterminal() {
        return forsealorterminal;
    }

    public void setForsealorterminal(String forSealOrTerminal) {
        this.forsealorterminal = forSealOrTerminal;
    }

    public String getApplicatorinservice() {
        return applicatorinservice;
    }

    public void setApplicatorinservice(String inService) {
        this.applicatorinservice = inService;
    }

    public String getApplicatorsite() {
        return applicatorsite;
    }

    public void setApplicatorsite(String applicatorSite) {
        this.applicatorsite = applicatorSite;
    }
}