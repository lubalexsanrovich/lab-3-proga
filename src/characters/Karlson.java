package characters;

import characters.base.Character;
import enums.MentalState;
import flat_and_rooms.FlatRoom;
import items.Item;
import sound.Sound;

import java.util.ArrayList;

public class Karlson extends Character {

    protected Karlson(String n, String des, FlatRoom r, MentalState ms, ArrayList<Item> it) {
        super(n, des, r, ms, it);
    }

    protected Karlson(String n, String des, FlatRoom r, MentalState ms) {
        super(n, des, r, ms);
    }

    public Karlson(String n, String des, FlatRoom r) {
        super(n, des, r);
    }

    protected Karlson(String n, String des, FlatRoom r, ArrayList<Item> it) {
        super(n, des, r, it);
    }

    public void getSigma(){
        this.setMentalState(MentalState.SIGMA);
        System.out.println(this.name + " " + this.getMentalState().getDescription());
    }

    @Override
    public void hear(Sound s) {
        System.out.println(this.name + " слышит " + s.getType().getDescription() + "!");
    }

    @Override
    public void see(Character character) {
        System.out.println(this.name + " видит " + character.getName() + "!");
        if (character.getMentalState() == MentalState.UNCONSCIOUS) {
            this.getSigma();
        }
    }
}
