package arcadia.domainobjects;


public class NodeIdentifier {

    private Integer nodeNumber;

    public NodeIdentifier(int nodeNumber, String id) {
        this.nodeNumber = nodeNumber;
        this.nodeElementId = id;
    }

    public Integer getNodeNumber() {
        return nodeNumber;
    }

    public void setNodeNumber(Integer nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public String getNodeElementId() {
        return nodeElementId;
    }

    public void setNodeElementId(String nodeElementId) {
        this.nodeElementId = nodeElementId;
    }

    private String nodeElementId;
}
