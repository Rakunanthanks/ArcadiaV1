package arcadia.domainobjects;

public class ApplicatorsComponentDB {

    private String partNumber;
    private String description;
    private String family;
    private String status;
    private String usage;
    private String supplier;
    private String supplierPN;
    private String colour;
    private String applicatorUsage;
    private String forSealOrTerminal;
    private String inService;
    private String applicatorSite;
    public ApplicatorsComponentDB() {
    }
    public ApplicatorsComponentDB(String partNumber, String description, String family, String status, String usage, String supplier, String supplierPN, String colour, String applicatorUsage, String forSealOrTerminal, String inService, String applicatorSite) {
        this.partNumber = partNumber;
        this.description = description;
        this.family = family;
        this.status = status;
        this.usage = usage;
        this.supplier = supplier;
        this.supplierPN = supplierPN;
        this.colour = colour;
        this.applicatorUsage = applicatorUsage;
        this.forSealOrTerminal = forSealOrTerminal;
        this.inService = inService;
        this.applicatorSite = applicatorSite;
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

    public String getApplicatorUsage() {
        return applicatorUsage;
    }

    public void setApplicatorUsage(String applicatorUsage) {
        this.applicatorUsage = applicatorUsage;
    }

    public String getForSealOrTerminal() {
        return forSealOrTerminal;
    }

    public void setForSealOrTerminal(String forSealOrTerminal) {
        this.forSealOrTerminal = forSealOrTerminal;
    }

    public String getInService() {
        return inService;
    }

    public void setInService(String inService) {
        this.inService = inService;
    }

    public String getApplicatorSite() {
        return applicatorSite;
    }

    public void setApplicatorSite(String applicatorSite) {
        this.applicatorSite = applicatorSite;
    }
}