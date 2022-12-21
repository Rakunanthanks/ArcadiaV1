package arcadia.constants;

public enum EndPoint {
    TRAINING("mercury1_21_1/"),
<<<<<<< HEAD
    PROJECT("/index.lp?app=projects2&appoption=10&project=2&projName=quickstart"),
    PROFILE("/index.lp??app=generaledit&profilecode=profileName"),
    SLEEVETUBE("/index.lp?app=componentsv2&form=sleevetube&company=CADONIX&database=quickstart"),
    HARNESSBUNDLEDISPLAY("/index.lp?app=generaledit&appoption=3&section=Bundle%20Default%20Display&mainsection=Harness&profilecode=quickstart"),

    SETTINGS("/index.lp?menu=settings"),

    COMPONENTDB("/index.lp?app=componentsv2&database=componentDB"),

    AutomationCompanyProfile("/index.lp?app=generaledit&profilecode=Automation"),

    BUNDLEDEFAULTDISPLAY("/index.lp?app=generaledit&appoption=3&section=Bundle%20Default%20Display&mainsection=Harness&profilecode=Automation"),
    TEST("/arcadia.lua?projectID=2&mode=0&taskID=HAR34&appmode=init&profile=Automation&newSession=TP0ShzKFZEHl&userName=ragu#{\"id\":\"1671551143277\",\"sheetID\":\"9d4bfa6c7bce11ed908802de8e05bcf8\"}");
=======
    PROJECT("mercury1_21_1/index.lp?app=projects2&appoption=10&project=2&projName=quickstart"),
    SLEEVETUBE("mercury1_21_1/index.lp?app=componentsv2&form=sleevetube&company=CADONIX&database=quickstart"),
    HARNESSBUNDLEDISPLAY("mercury1_21_1/index.lp?app=generaledit&appoption=3&section=Bundle%20Default%20Display&mainsection=Harness&profilecode=quickstart"),

    SETTINGS("mercury1_21_1/index.lp?menu=settings"),

    COMPONENTDB("mercury1_21_1/index.lp?app=componentsv2&database=componentDB"),

    AutomationCompanyProfile("/mercury1_21_1/index.lp?app=generaledit&profilecode=Automation"),

    BUNDLEDEFAULTDISPLAY("mercury1_21_1/index.lp?app=generaledit&appoption=3&section=Bundle%20Default%20Display&mainsection=Harness&profilecode=Automation"),
    TEST("mercury1_21_1/arcadia.lua?projectID=2&mode=0&taskID=HAR34&appmode=init&profile=Automation&newSession=TP0ShzKFZEHl&userName=ragu#{\"id\":\"1671551143277\",\"sheetID\":\"9d4bfa6c7bce11ed908802de8e05bcf8\"}");
>>>>>>> 445fded (Created Test Scenario for Bundle Tolerance)
    public final String url;

    EndPoint(String url) {
        this.url = url;
    }
}
