package arcadia.mapperObjects;

public class CreateSchematic {
    private String workTask;
    private String title;
    private String description;
    private String partNumber;
    private String revision;
    private String componentDB;
    private String profile;

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

    public String getComponentDB() {
        return componentDB;
    }
    public String getProfile() {
        return profile;
    }

    public void setComponentDB(String componentDB) {
        this.componentDB = componentDB;
    }
    public void setProfile(String profile)
    {
        this.profile =profile;
    }
}
