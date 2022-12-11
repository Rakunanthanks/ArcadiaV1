package arcadia.mapperObjects;

public class TestMapper {
    private String testName;
    public CreateHarness CreateHarness;
    public SearchParts SearchParts;
    public WireTable WireTable;
    public Bundle Bundle;
    public DBCheck DBCheck;

    public DBCheck getDBCheck() {
        return DBCheck;
    }
    public void setDBCheck(DBCheck DBCheck) {
        this.DBCheck = DBCheck;
    }
    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public CreateHarness getCreateHarness() {
        return CreateHarness;
    }

    public void setCreateHarness(CreateHarness CreateHarness) {
        this.CreateHarness = CreateHarness;
    }

    public SearchParts getSearchParts() {
        return SearchParts;
    }

    public void setSearchParts(SearchParts searchParts) {
        SearchParts = searchParts;
    }

    public arcadia.mapperObjects.WireTable getWireTable() {
        return WireTable;
    }

    public void setWireTable(arcadia.mapperObjects.WireTable wireTable) {
        WireTable = wireTable;
    }

    public arcadia.mapperObjects.Bundle getBundle() {
        return Bundle;
    }

    public void setBundle(arcadia.mapperObjects.Bundle bundle) {
        Bundle = bundle;
    }
}
