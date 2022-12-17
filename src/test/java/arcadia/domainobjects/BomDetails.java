package arcadia.domainobjects;

public class BomDetails {
    private Double bomPrice;
    private String bomWeight;
    private String bomMeasure;
    private String bomCurrency;
    private String bomUnits;
    private String bomBillType;

    public BomDetails(Double bomPrice, String bomWeight, String bomMeasure, String bomCurrency, String bomUnits, String bomBillType) {
        this.bomPrice = bomPrice;
        this.bomWeight = bomWeight;
        this.bomMeasure = bomMeasure;
        this.bomCurrency = bomCurrency;
        this.bomUnits = bomUnits;
        this.bomBillType = bomBillType;
    }

    public Double getBomPrice() {
        return bomPrice;
    }

    public void setBomPrice(Double bomPrice) {
        this.bomPrice = bomPrice;
    }

    public String getBomWeight() {
        return bomWeight;
    }

    public void setBomWeight(String bomWeight) {
        this.bomWeight = bomWeight;
    }

    public String getBomMeasure() {
        return bomMeasure;
    }

    public void setBomMeasure(String bomMeasure) {
        this.bomMeasure = bomMeasure;
    }

    public String getBomCurrency() {
        return bomCurrency;
    }

    public void setBomCurrency(String bomCurrency) {
        this.bomCurrency = bomCurrency;
    }

    public String getBomUnits() {
        return bomUnits;
    }

    public void setBomUnits(String bomUnits) {
        this.bomUnits = bomUnits;
    }

    public String getBomBillType() {
        return bomBillType;
    }

    public void setBomBillType(String bomBillType) {
        this.bomBillType = bomBillType;
    }
}
