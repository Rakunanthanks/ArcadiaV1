package arcadia.domainobjects;

/**
 * @author vipula
 * @date 10-01-2023
 */
public class ComponentPrefix
{
    private String Identifier;
    private String IdentifierType;
    private String Prefix;
    private String Location;
    private String UseSeperator;

    public ComponentPrefix() {
    }
    public ComponentPrefix(String Identifier, String IdentifierType,String Prefix, String Location, String UseSeperator)
    {
        this.Identifier=Identifier;
        this.IdentifierType=IdentifierType;
        this.Prefix=Prefix;
        this.Location=Location;
        this.UseSeperator=UseSeperator;
    }



    public String getPrefix() {
        return Prefix;
    }

    public void setPrefix(String prefix) {
        Prefix = prefix;
    }

    public String getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(String identifier) {
        Identifier = identifier;
    }

    public String getIdentifierType() {
        return IdentifierType;
    }

    public void setIdentifierType(String identifierType) {
        IdentifierType = identifierType;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getUseSeperator() {
        return UseSeperator;
    }

    public void setUseSeperator(String useSeperator) {
        UseSeperator = useSeperator;
    }


}
