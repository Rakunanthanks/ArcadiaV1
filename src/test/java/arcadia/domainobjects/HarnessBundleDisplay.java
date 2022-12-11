package arcadia.domainobjects;


public class HarnessBundleDisplay {
    private String coveringTypes;
    private Double diameterAddon;
    private Double diameterScales;
    public HarnessBundleDisplay(String coveringType, Double diameterAddon, Double diameterScales) {
        this.coveringTypes = coveringType;
        this.diameterAddon = diameterAddon;
        this.diameterScales = diameterScales;
    }
    public String getCoveringTypes() {
        return coveringTypes;
    }
    public void setCoveringTypes(String coveringTypes) {
        this.coveringTypes = coveringTypes;
    }
    public Double getDiameterAddon() {
        return diameterAddon;
    }
    public void setDiameterAddon(Double diameterAddon) {
        this.diameterAddon = diameterAddon;
    }
    public Double getDiameterScales() {
        return diameterScales;
    }
    public void setDiameterScales(Double diameterScales) {
        this.diameterScales = diameterScales;
    }

}
