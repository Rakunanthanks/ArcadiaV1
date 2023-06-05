package arcadia.domainobjects;

public class BomTableIdentifier {
    private String bomTableId;

    public BomTableIdentifier(String bomTableId) {
        this.bomTableId =bomTableId;
    }

    public String getBomTableId() {
        return bomTableId;
    }

    public void setBomTableId(String bomTableId) {
        this.bomTableId = bomTableId;
    }
}
