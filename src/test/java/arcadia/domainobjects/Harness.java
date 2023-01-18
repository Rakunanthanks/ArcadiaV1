package arcadia.domainobjects;

public class Harness {
    public Harness(String workTask, String title, String description, String partNumber, String revision,String profile) {
        this.workTask = workTask;
        this.title = title;
        this.description = description;
        this.partNumber = partNumber;
        this.revision = revision;
        this.profile =profile;
        this.componentDB = componentDB;
    }
    private String workTask;
    private String title;
    private String description;
    private String partNumber;
    private String revision;
    private String componentDB;
    private String profile;
    private String editableStatus;
    private String units;
    private String customerPartNumber;
    private String customerName;
    private String frame;
    private String project;
    private String lineFont;
    private String connectorView;
    private String wireNames;
    private String defaultSpiceTechnology;
    private String tableType;
    private String variantGroup;


    public String getWorkTask() {
        return workTask;
    }

    public void setWorkTask(String workTask) {
        this.workTask = workTask;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getProfile(){
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getComponentDB() {
        return componentDB;
    }

    public void setComponentDB(String componentDB) {
        this.componentDB = componentDB;
    }

}
