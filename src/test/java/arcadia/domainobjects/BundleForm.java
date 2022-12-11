package arcadia.domainobjects;

import java.util.List;

public class BundleForm {
    private String bundleDiameter;

    public List<InsulationParts> getInsulationPartsList() {
        return insulationPartsList;
    }

    public void setInsulationPartsList(List<InsulationParts> insulationPartsList) {
        this.insulationPartsList = insulationPartsList;
    }

    private List<InsulationParts> insulationPartsList;
    private String bundleFormName;
    public String getBundleFormName() {
        return bundleFormName;
    }

    public void setBundleFormName(String bundleFormName) {
        this.bundleFormName = bundleFormName;
    }



    public String getBundleDiameter() {
        return bundleDiameter;
    }

    public void setBundleDiameter(String bundleDiameter) {
        this.bundleDiameter = bundleDiameter;
    }


}
