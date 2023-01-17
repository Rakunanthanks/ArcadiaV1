package arcadia.constants;

public enum EndPoint {
    TRAINING("mercury1_21/"),
    PROJECT("/index.lp?app=projects2&appoption=10&project=2&projName=projectName"),
    PROFILE("/index.lp??app=generaledit&profilecode=profileName"),
    COMPONENTDB("/index.lp?app=componentsv2&database=databaseName"),
    SLEEVETUBE("/index.lp?app=componentsv2&form=sleevetube&company=CADONIX&database=databaseName"),
    HARNESSBUNDLEDISPLAY("/index.lp?app=generaledit&appoption=3&section=Bundle%20Default%20Display&mainsection=Harness&profilecode=profileName"),

    GENERALMACROS("/index.lp?app=generaledit&appoption=3&section=Macros&mainsection=General&profilecode=quickstart");
    public final String url;

    EndPoint(String url) {
        this.url = url;
    }
}
