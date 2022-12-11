package arcadia.domainobjects;

public class InsulationParts {
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getInternalDia() {
        return internalDia;
    }

    public void setInternalDia(String internalDia) {
        this.internalDia = internalDia;
    }

    public String getOuterDia() {
        return outerDia;
    }

    public void setOuterDia(String outerDia) {
        this.outerDia = outerDia;
    }


    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public String getDefaultLine() {
        return defaultLine;
    }

    public void setDefaultLine(String defaultLine) {
        this.defaultLine = defaultLine;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getCovering() {
        return covering;
    }

    public void setCovering(String covering) {
        this.covering = covering;
    }

    private String reference;
    private String internalDia;
    private String outerDia;
    private String partNumber;
    private String partDescription;
    private String defaultLine;
    private String colour;
    private String covering;
}
