package enums;

public enum MentalState {
    CONSCIOUS("в сознании"),
    UNCONSCIOUS("без сознания"),
    READYTOCRY("готов заплакать"),
    COMPLAINING("причитает"),
    SIGMA("невозмутим");

    private final String description;

    MentalState(String description) {
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }

    @Override
    public String toString() {
        return description;
    }
}