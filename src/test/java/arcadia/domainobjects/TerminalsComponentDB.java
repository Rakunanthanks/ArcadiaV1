package arcadia.domainobjects;

public class TerminalsComponentDB {
    private String partNumber;
    private String description;
    private String family;
    private String status;
    private String usage;
    private String supplier;
    private String supplierPN;
    private String colour;
    private String gender;
    private String type;
    private String finish;
    private String material;
    private Double stripLength;
    private Double threadDia;
    private String wireInsOD;
    private String wireCSA;

    public TerminalsComponentDB(String partNumber, String description, String family, String status, String usage, String supplier, String supplierPN, String colour, String gender, String type, String finish, String material, Double stripLength, Double threadDia, String wireInsOD, String wireCSA) {
        this.partNumber = partNumber;
        this.description = description;
        this.family = family;
        this.status = status;
        this.usage = usage;
        this.supplier = supplier;
        this.supplierPN = supplierPN;
        this.colour = colour;
        this.gender = gender;
        this.type = type;
        this.finish = finish;
        this.material = material;
        this.stripLength = stripLength;
        this.threadDia = threadDia;
        this.wireInsOD = wireInsOD;
        this.wireCSA = wireCSA;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Double getStripLength() {
        return stripLength;
    }

    public void setStripLength(Double stripLength) {
        this.stripLength = stripLength;
    }

    public Double getThreadDia() {
        return threadDia;
    }

    public void setThreadDia(Double threadDia) {
        this.threadDia = threadDia;
    }

    public String getWireInsOD() {
        return wireInsOD;
    }

    public void setWireInsOD(String wireInsOD) {
        this.wireInsOD = wireInsOD;
    }

    public String getWireCSA() {
        return wireCSA;
    }

    public void setWireCSA(String wireCSA) {
        this.wireCSA = wireCSA;
    }
}
