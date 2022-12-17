package arcadia.domainobjects;

public class AdditionalReferences {
    private String referencesPartNumber;
    private String referencesType;
    private String referencesCompany;

    public AdditionalReferences(String referencesPartNumber, String referencesType, String referencesCompany) {
        this.referencesPartNumber = referencesPartNumber;
        this.referencesType = referencesType;
        this.referencesCompany = referencesCompany;
    }

    public String getReferencesPartNumber() {
        return referencesPartNumber;
    }

    public void setReferencesPartNumber(String referencesPartNumber) {
        this.referencesPartNumber = referencesPartNumber;
    }

    public String getReferencesType() {
        return referencesType;
    }

    public void setReferencesType(String referencesType) {
        this.referencesType = referencesType;
    }

    public String getReferencesCompany() {
        return referencesCompany;
    }

    public void setReferencesCompany(String referencesCompany) {
        this.referencesCompany = referencesCompany;
    }
}
