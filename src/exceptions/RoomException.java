package exceptions;


import flat_and_rooms.FlatRoom;

public class RoomException extends RuntimeException {
    private final String characterName;

    public RoomException(String characterName) {
        super("Персонаж " + characterName + " не в нужной комнате!");
        this.characterName = characterName;
    }

    public RoomException(String characterName, FlatRoom room) {
        super("Персонаж " + characterName + " не в комнате: " + room.toString());
        this.characterName = characterName;
    }

    public String getCharacterName() {
        return characterName;
    }
}
