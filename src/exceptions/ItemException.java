package exceptions;

import items.Item;

public class ItemException extends RuntimeException {
    private final String characterName;

    public ItemException(String characterName) {
        super("Персонаж " + characterName + " не имеет такого предмета!");
        this.characterName = characterName;
    }

    public ItemException(String characterName, Item item) {
        super("Персонаж " + characterName + " не имеет: " + item.toString());
        this.characterName = characterName;
    }

    public String getCharacterName() {
        return characterName;
    }
}
