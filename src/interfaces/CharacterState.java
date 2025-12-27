package interfaces;

import enums.MentalState;
import flat_and_rooms.FlatRoom;
import items.Item;
import sound.Sound;
import characters.base.Character;

import java.util.ArrayList;

public interface CharacterState {
    public void moveTo(FlatRoom room);
    public void setMentalState(MentalState mentalState);
    public void dropItem(String itemName);
    public void pickItem(Item item);
    public Item getItem(String itemName);
    public ArrayList<Item> getItems();
    public void hear(Sound sound);
    public void see(Character character);
    public void toRing();
    public void shoot(Character character);
    public void pourOnCharacter(Character character);
    public void getItemFromSuitcase(String itemname, String suitcase);
    public void getItemFromSuitcase(Item itemname, String suitcasename);
    public void putItemInSuitcase(String itemname, String suitcasename);
    public void putItemInSuitcase(Item itemname, String suitcasename);
    public void setRoom(FlatRoom room);
    public void openHallwayDoor();
    public void dropAllItems();
}
