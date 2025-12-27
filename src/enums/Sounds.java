package enums;

public enum Sounds {
    RING("дверной звонок"),
    SHOOT("выстрел"),
    BARK("лай"),
    COMPLAINT("причитание"),
    SILENCE("тишина");

    private final String description;

    Sounds(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}