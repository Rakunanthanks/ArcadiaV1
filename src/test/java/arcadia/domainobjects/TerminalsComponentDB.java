package arcadia.domainobjects;

public class TerminalsComponentDB {
    private String partnumber;
    private String description;
    private String family;
    private String status;
    private String usage;

    private String manufacturerpartstatus;
    private String supplier;
    private String supplierpn;
    private String colour;
    private String gender;
    private String terminaltype;
    private String finish;
    private String material;
    private Double striplength;
    private Double threaddia;
    private String wireinsod;
    private String wirecsa;

    public TerminalsComponentDB(){

    }

    public TerminalsComponentDB(String partNumber, String description, String family, String status, String usage,String manufacturerpartstatus, String supplier, String supplierPN, String colour, String gender, String type, String finish, String material, Double stripLength, Double threadDia, String insOD, String csa) {
        this.partnumber = partNumber;
        this.description = description;
        this.family = family;
        this.status = status;
        this.usage = usage;
        this.manufacturerpartstatus=manufacturerpartstatus;
        this.supplier = supplier;
        this.supplierpn = supplierPN;
        this.colour = colour;
        this.gender = gender;
        this.terminaltype = type;
        this.finish = finish;
        this.material = material;
        this.striplength = stripLength;
        this.threaddia = threadDia;
        this.wireinsod = insOD;
        this.wirecsa = csa;
    }

    public String getPartnumber() {
        return partnumber;
    }

    public void setPartNumber(String partNumber) {
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

    public void setManufacturerpartstatus(String manufacturerpartstatus) {
        this.manufacturerpartstatus = manufacturerpartstatus;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTerminaltype() {
        return terminaltype;
    }

    public void setTerminaltype(String type) {
        this.terminaltype = type;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getStriplength() {
        return striplength;
    }

    public void setStriplength(Double stripLength) {
        this.striplength = stripLength;
    }

    public Double getThreaddia() {
        return threaddia;
    }

    public void setThreaddia(Double threadDia) {
        this.threaddia = threadDia;
    }

    public String getWireinsod() {
        return wireinsod;
    }

    public void setWireinsod(String insOD) {
        this.wireinsod = insOD;
    }

    public String getWirecsa() {
        return wirecsa;
    }

    public void setWirecsa(String csa) {
        this.wirecsa = csa;
    }
}
