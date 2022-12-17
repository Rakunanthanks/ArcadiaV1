package arcadia.domainobjects;

import java.util.List;

public class AddComponentForm {
    private ComponentDetails componentDetails;
    private List<AdditionalReferences> additionalReferences;
    private BomDetails bomDetails;

    public ComponentDetails getComponentDetails() {
        return componentDetails;
    }

    public void setComponentDetails(ComponentDetails componentDetails) {
        this.componentDetails = componentDetails;
    }

    public List<AdditionalReferences> getAdditionalReferences() {
        return additionalReferences;
    }

    public void setAdditionalReferences(List<AdditionalReferences> additionalReferences) {
        this.additionalReferences = additionalReferences;
    }

    public BomDetails getBomDetails() {
        return bomDetails;
    }

    public void setBomDetails(BomDetails bomDetails) {
        this.bomDetails = bomDetails;
    }
}
