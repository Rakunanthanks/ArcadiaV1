package arcadia.domainobjects;

public class BundleIdentifier {

    private String bundleId;

    public BundleIdentifier(String bundleId) {
        this.bundleId =bundleId;
    }

    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }
}
