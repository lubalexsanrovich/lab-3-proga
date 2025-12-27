package characters;

import characters.base.Character;
import enums.MentalState;
import enums.Sounds;
import flat_and_rooms.FlatRoom;
import items.Item;
import sound.Sound;

import java.util.ArrayList;

public class Kid extends Character {

    protected Kid(String n, String des, FlatRoom r, MentalState ms, ArrayList<Item> it) {
        super(n, des, r, ms, it);
    }

    protected Kid(String n, String des, FlatRoom r, MentalState ms) {
        super(n, des, r, ms);
    }

    public Kid(String n, String des, FlatRoom r) {
        super(n, des, r);
    }

    protected Kid(String n, String des, FlatRoom r, ArrayList<Item> it) {
        super(n, des, r, it);
    }


    public void getSad(){
        this.setMentalState(MentalState.READYTOCRY);
    }
    @Override
    public void hear(Sound s) {
        System.out.println(this.name + " слышит " + s.getType().getDescription() + "!");
        if ((s.getType() == Sounds.RING) && (this.getRoom() != s.getLocation())){
            this.moveTo(s.getLocation());
        }
    }

    @Override
    public void see(Character character) {
        System.out.println(this.name + " видит " + character.getName() + "!");
        if (character.getMentalState() == MentalState.UNCONSCIOUS){
            this.getSad();
        }
    }
}
