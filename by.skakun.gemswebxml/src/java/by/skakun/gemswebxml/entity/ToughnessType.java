package by.skakun.gemswebxml.entity;

public enum ToughnessType {

    HARD("hard"), MEDIUM("medium"), SOFT("soft");

    private String value;

    private ToughnessType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
