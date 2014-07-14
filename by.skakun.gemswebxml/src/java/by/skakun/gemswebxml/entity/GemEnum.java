package by.skakun.gemswebxml.entity;

public enum GemEnum {
    GEM("gem"),
    REALPRECIOUSGEM("realpreciousgem"),
    ARTIFICIALGEM("artificialgem"),
    SEMIPRECIOUSGEM ("semipreciousgem"),
    WEIGHT ("weight"),
    OPACITY("opacity"),
    COLOR("color"),
    NAME("name"),
    COST("cost"),
    SYMBOL("symbol"),
    FIELDORIGIN("fieldOrigin"),
    TOUGHNESS("toughness"),
    CUTMETHOD("cutMethod"),
    ID("id"),
    NECKLACE("necklace"),
    AGE("age");
private String value;

    private GemEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
