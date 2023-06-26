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
    HARNESSADVANCED("/index.lp?app=generaledit&appoption=3&section=General%20Harness&mainsection=Harness&profilecode=profileName"),
    CONNECTOREDITORSETTING("/index.lp?app=generaledit&appoption=3&section=Connector%20Editor%20Settings&mainsection=Editors&profilecode=profileName"),
    BUNDLEFONTDISPLAY("/index.lp?app=generaledit&appoption=3&section=Font%20Harness&mainsection=Harness&profilecode=profileName"),
    COMPONENTDBLIST("/index.lp?app=componentsv2"),
    SPLICEEDITORSETTING("/index.lp?app=generaledit&appoption=3&section=Splice%20Editor%20Settings&mainsection=Editors&profilecode=profileName"),
    TASKUNITS("/index.lp?app=generaledit&appoption=3&section=Units&mainsection=General&profilecode=profileName"),
    NEWPROJECT("/index.lp?app=projects2&appoption=10&project=29&projName=projectName"),
    LABELVISIBILITY("/index.lp?app=generaledit&appoption=3&section=Label%20Visibility%20Harness&mainsection=Harness&profilecode=profileName"),
    FORMBOARDLABELVISIBILITY("/index.lp?app=generaledit&appoption=3&section=Label%20Visibility%20Formboard&mainsection=Formboard&profilecode=profileName"),
    HARNESSUPDATEFONTS("/index.lp?app=generaledit&appoption=4&suboption=3&section=Font%20Harness&mainsection=Harness&profilecode=profileName"),
    FORMBOARDUPDATFONTS("/index.lp?app=generaledit&appoption=3&section=Font%20Formboard&mainsection=Formboard&profilecode=profileName"),
    PROJECTHOMEPAGE("/index.lp?app=projects2"),
    SCHEMATICWIREPROPERTIES("/index.lp?app=generaledit&appoption=3&section=Signal%20Properties&mainsection=Schematic&profilecode=profileName");
    public final String url;
    EndPoint(String url) {
        this.url = url;
    }
}
