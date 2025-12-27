package characters;

import characters.base.Character;
import enums.MentalState;
import enums.Sounds;
import flat_and_rooms.FlatRoom;
import items.Item;
import sound.Sound;

import java.util.ArrayList;

public class FrekenBok extends Character {
    public FrekenBok(String n, String des, FlatRoom r, MentalState ms, ArrayList<Item> it) {
        super(n, des, r, ms, it);
    }

    public FrekenBok(String n, String des, FlatRoom r, MentalState ms) {
        super(n, des, r, ms);
    }

    public FrekenBok(String n, String des, FlatRoom r) {
        super(n, des, r);
    }

    public FrekenBok(String n, String des, FlatRoom r, ArrayList<Item> it) {
        super(n, des, r, it);
    }


    public void getAngry(){
        this.setMentalState(MentalState.COMPLAINING);
        System.out.println(this.name + " " + this.getMentalState().getDescription());
    }

    @Override
    public void hear(Sound s) {
        System.out.println(this.name + " слышит " + s.getType().getDescription() + "!");
        if (s.getType() == Sounds.SHOOT){
            this.moveTo(s.getLocation());
        }
    }

    @Override
    public void see(Character character) {
        System.out.println(this.name + " видит " + character.getName() + "!");
        if (character.getMentalState() == MentalState.UNCONSCIOUS){
            this.setMentalState(MentalState.COMPLAINING);
            Sound s = new Sound(Sounds.COMPLAINT, "ругается", room);
            s.spreadSound(room);
        }
    }
}
