package arcadia.domainobjects;

public class WireProperties {
    public String getWireOuterDiameter() {
        return wireOuterDiameter;
    }

    public void setWireOuterDiameter(String wireOuterDiameter) {
        this.wireOuterDiameter = wireOuterDiameter;
    }

    public String getWireColour() {
        return wireColour;
    }

    public void setWireColour(String wireColour) {
        this.wireColour = wireColour;
    }

    private String wireOuterDiameter;
    private String wireColour;
}
