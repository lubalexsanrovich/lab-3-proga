package characters;

import characters.base.Character;
import enums.MentalState;
import flat_and_rooms.FlatRoom;
import items.Item;
import sound.Sound;

import java.util.ArrayList;

public class UncleJulius extends Character {

    protected UncleJulius(String n, String des, FlatRoom r, MentalState ms, ArrayList<Item> it) {
        super(n, des, r, ms, it);
    }

    protected UncleJulius(String n, String des, FlatRoom r, MentalState ms) {
        super(n, des, r, ms);
    }

    public UncleJulius(String n, String des, FlatRoom r) {
        super(n, des, r);
    }

    protected UncleJulius(String n, String des, FlatRoom r, ArrayList<Item> it) {
        super(n, des, r, it);
    }

    @Override
    public void hear(Sound s) {
        System.out.println(this.name + " слышит " + s.getType().getDescription() + "!");
    }

    @Override
    public void see(Character character) {
        System.out.println(this.name + " видит " + character.getName() + "!");
    }
}
