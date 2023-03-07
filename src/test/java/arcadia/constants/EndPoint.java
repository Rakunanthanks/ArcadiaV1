package arcadia.constants;

public enum EndPoint {
    TRAINING("mercury1_21_1/"),
    PROJECT("/index.lp?app=projects2&appoption=10&project="+System.getProperty("projectID")+"&projName=projectName"),
    PROFILE("/index.lp?app=generaledit&profilecode=profileName"),
    SLEEVETUBE("/index.lp?app=componentsv2&form=sleevetube&company=CADONIX&database=databaseName"),
    HARNESSBUNDLEDISPLAY("/index.lp?app=generaledit&appoption=3&section=Bundle%20Default%20Display&mainsection=Harness&profilecode=profileName"),
    GENERALMACROS("/index.lp?app=generaledit&appoption=3&section=Macros&mainsection=General&profilecode=quickstart"),
    SETTINGS("/index.lp?menu=settings"),
    COMPONENTDB("/index.lp?app=componentsv2&database=databaseName"),
    AutomationCompanyProfile("/index.lp?app=generaledit&profilecode=profileName"),
    FontSettingsURL("/index.lp?section=Font%20Harness&appoption=3&app=generaledit&mainsection=Harness&profilecode=profileName"),
    BUNDLEDEFAULTDISPLAY("/index.lp?app=generaledit&appoption=3&section=Bundle%20Default%20Display&mainsection=Harness&profilecode=profileName"),
    BUNDLEFONTDISPLAY("/index.lp?app=generaledit&appoption=3&section=Font%20Harness&mainsection=Harness&profilecode=profileName"),
    TASKUNITS("/index.lp?app=generaledit&appoption=3&section=Units&mainsection=General&profilecode=profileName"),
    NEWPROJECT("/index.lp?app=projects2&appoption=10&project=181&projName=projectName");
    public final String url;
    EndPoint(String url) {
        this.url = url;
    }
}
