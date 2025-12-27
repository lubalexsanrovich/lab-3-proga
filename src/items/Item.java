package items;

import characters.base.Character;
import flat_and_rooms.FlatRoom;

import java.util.Objects;

public class Item {
    protected FlatRoom location;
    protected Character character;

    public Item(FlatRoom location, Character character) {
        this.location = location;
        this.character = character;
    }

    public Item(FlatRoom location) {
        this.location = location;
    }

    public FlatRoom getLocation() {
        return location;
    }

    public void setLocation(FlatRoom location) {
        this.location = location;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }


}
