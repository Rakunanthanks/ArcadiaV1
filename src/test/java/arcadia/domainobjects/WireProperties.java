package arcadia.domainobjects;

public class WireProperties {
    public Double getWireOuterDiameter() {
        return wireOuterDiameter;
    }

    public void setWireOuterDiameter(Double wireOuterDiameter) {
        this.wireOuterDiameter = wireOuterDiameter;
    }

    public String getWireColour() {
        return wireColour;
    }

    public void setWireColour(String wireColour) {
        this.wireColour = wireColour;
    }

    private Double wireOuterDiameter;
    private String wireColour;
}
