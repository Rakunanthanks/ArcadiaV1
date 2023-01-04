package arcadia.datasources;

import arcadia.domainobjects.AdditionalReferences;
import arcadia.domainobjects.BomDetails;
import arcadia.domainobjects.ComponentDetails;

import java.sql.SQLException;
import java.sql.*;

public class ComponentDataJDBC {

    public ComponentDetails getComponentDetails(String csvDirectorypath, String csvquery) throws SQLException, ClassNotFoundException {
        Class.forName("org.relique.jdbc.csv.CsvDriver");
        Connection conn = DriverManager.getConnection("jdbc:relique:csv:" + csvDirectorypath);
        Statement statement = conn.createStatement();
        ResultSet results = statement.executeQuery(csvquery);
        ComponentDetails componentDetails = null;
        while (results.next()) {
            componentDetails = new ComponentDetails();
            componentDetails.setDescription(results.getString("description"));
            componentDetails.setFamily(results.getString("family"));
            componentDetails.setStatus(results.getString("status"));
            componentDetails.setTypecode(results.getString("typecode"));
            componentDetails.setProprietary(results.getString("proprietary"));
            componentDetails.setParttype(results.getString("parttype"));
            componentDetails.setPrimarycolour(results.getString("primarycolour"));
            componentDetails.setSecondarycolour(results.getString("secondarycolour"));
            componentDetails.setTertiarycolour(results.getString("tertiarycolour"));
            componentDetails.setMaterialcode(results.getString("materialcode"));
            componentDetails.setUsage(results.getString("usage"));
            componentDetails.setPartcategory(results.getString("partcategory"));
            componentDetails.setColour(results.getString("colour"));
        }
        conn.close();
        return componentDetails;
    }

    public BomDetails getBomDetails(String csvDirectorypath, String csvquery) throws SQLException, ClassNotFoundException {
        Class.forName("org.relique.jdbc.csv.CsvDriver");
        Connection conn = DriverManager.getConnection("jdbc:relique:csv:" + csvDirectorypath);
        Statement statement = conn.createStatement();
        ResultSet results = statement.executeQuery(csvquery);
        BomDetails bomDetails = null;
        while (results.next()) {
            bomDetails = new BomDetails();
            bomDetails.setBomPrice(Double.valueOf(results.getString("bomPrice")));
            bomDetails.setBomWeight(results.getString("bomWeight"));
            bomDetails.setBomMeasure(results.getString("bomMeasure"));
            bomDetails.setBomCurrency(results.getString("bomCurrency"));
            bomDetails.setBomUnits(results.getString("bomUnits"));
            bomDetails.setBomBillType(results.getString("bomBillType"));
        }
        conn.close();
        return bomDetails;
    }

    public AdditionalReferences getAdditionalReferenceDetails(String csvDirectorypath, String csvquery) throws SQLException, ClassNotFoundException {
        Class.forName("org.relique.jdbc.csv.CsvDriver");
        Connection conn = DriverManager.getConnection("jdbc:relique:csv:" + csvDirectorypath);
        Statement statement = conn.createStatement();
        ResultSet results = statement.executeQuery(csvquery);
        AdditionalReferences additionalReferences = null;
        while (results.next()) {
            additionalReferences = new AdditionalReferences();
            additionalReferences.setReferencesPartNumber(results.getString("referencesPartNumber"));
            additionalReferences.setReferencesType(results.getString("referencesType"));
            additionalReferences.setReferencesCompany(results.getString("referencesCompany"));
        }
        conn.close();
        return additionalReferences;
    }
}
