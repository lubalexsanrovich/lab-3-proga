package exceptions;

public class MovementException extends RuntimeException {
    private final String characterName;

    public MovementException(String characterName) {
        super("Персонаж " + characterName + " без сознания и не может выполнить действие!");
        this.characterName = characterName;
    }

    public MovementException(String characterName, String action) {
        super("Персонаж " + characterName + " без сознания и не может выполнить действие: " + action);
        this.characterName = characterName;
    }

    public String getCharacterName() {
        return characterName;
    }
}