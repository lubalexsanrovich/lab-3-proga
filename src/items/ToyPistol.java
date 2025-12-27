package items;

import characters.base.Character;
import enums.Sounds;
import flat_and_rooms.FlatRoom;
import sound.Sound;

import java.util.Objects;

public class ToyPistol extends Item {
    private boolean full;
    private Sound shot;

    public ToyPistol(FlatRoom location, Character character, boolean full) {
        super(location, character);
        this.full = full;
    }
    public ToyPistol(FlatRoom location, Character character){
        super(location, character);
        this.full = false;
    }

    public boolean isFull() {
        return full;
    }
    public void addWater() {
        this.full = true;
    }
    public void removeWater() {
        this.full = false;
    }
    public void shootCharacter(Character victim) {
        System.out.println("Успешно выстрелил в " + victim.getName());
        victim.getWet();
        shot = new Sound(Sounds.SHOOT, "a loud, sharp, and sudden blast", this.getCharacter().getRoom());
        shot.spreadSound(character.getRoom());
        this.full = false;
    }


    @Override
    public String toString() {
        return "водяной пистолетик";
    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || this.getClass() != obj.getClass()) return false;
//        Suitcase s = (Suitcase) obj;
//        return Objects.equals(this.name, s.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return (name.hashCode());
//    }
}
