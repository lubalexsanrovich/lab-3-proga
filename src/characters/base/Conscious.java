package characters.base;

import enums.MentalState;
import exceptions.ItemException;
import exceptions.RoomException;
import flat_and_rooms.FlatRoom;
import flat_and_rooms.Hallway;
import interfaces.CharacterState;
import items.Item;
import items.Suitcase;
import items.ToyPistol;
import items.Watercan;
import sound.Sound;
import characters.base.Character;

import java.util.ArrayList;

public class Conscious implements CharacterState {
    Character character;
    private Unconscious uncon = new Unconscious(character);
    public Conscious(Character ch){
        character = ch;
    }

    @Override
    public void moveTo(FlatRoom room) {
        System.out.println(character.name + " переходит в " + room.toString());
        for (characters.base.Character ch : room.getCharacters()){
            character.see(ch);
        }
        character.getRoom().removeCharacter(character);
        character.setRoom(room);
        character.getRoom().addCharacter(character);

    }


    @Override
    public void setMentalState(MentalState ms) {
        System.out.println(character.name + " теперь " + ms.getDescription());
        character.mentalState = ms;
    }

    @Override
    public Item getItem(String name){
        for (Item item : character.items) {
            if (item.getClass().getSimpleName().equals(name)) {
                System.out.println(character.name + " достал " + item.toString());
                character.items.remove(item);
                return item;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Item> getItems(){
        return character.items;
    }

    @Override
    public void dropItem(String itemName) {
        for (Item item : character.items) {
            if (item.getClass().getSimpleName().equals(itemName)) {
                System.out.println(character.name + " выбросил " + item.toString());
                character.items.remove(item);
                break;
            }
        }
        throw new ItemException(character.name);
    }

    @Override
    public void pickItem(Item item) {
        System.out.println(character.name + " подобрал " + item.toString());
        character.items.add(item);
    }


    @Override
    public void hear(Sound sound) {
    }

    @Override
    public void see(Character character) {
    }

    @Override
    public void shoot(Character ch){
        for (Item item : character.items) {
            if (item instanceof ToyPistol){
                System.out.println(character.name + " попытался выстрелить в " + ch.getName());
                ((ToyPistol) item).shootCharacter(ch);
            }
            return;
        }
        throw new ItemException(character.name);
    }


    @Override
    public void pourOnCharacter(Character ch){
        for (Item item : character.items) {
            if (item instanceof Watercan){
                System.out.println(character.name + " попытался вылить воду из лейки на " + ch.getName());
                ((Watercan) item).pourOnCharacter(ch);
                return;
            }

        }
        throw new ItemException(character.name);
    }


    @Override
    public void getItemFromSuitcase(String itemname, String suitcasename){
        for (Item item : character.items) {
            if ((item instanceof Suitcase) && (((Suitcase) item).getSuitcaseName().equals(suitcasename))){
                System.out.println(character.name + " достал из чемодана " + item.toString());
                character.items.add(((Suitcase) item).getItem(itemname));
            }
            return;
        }
        throw new ItemException(character.name);
    }

    @Override
    public void getItemFromSuitcase(Item itemname, String suitcasename){
        for (Item item : character.items) {
            if ((item instanceof Suitcase) && (((Suitcase) item).getSuitcaseName().equals(suitcasename))) {
                System.out.println(character.name + " достал из чемодана " + item.toString());
                character.items.add(((Suitcase) item).getItem(itemname));
            }
            return;
        }
        throw new ItemException(character.name);
    }

    @Override
    public void putItemInSuitcase(String itemname, String suitcasename){
        Suitcase suitcase = null;
        Item sh = null;
        for (Item it : character.items) {
            if ((it instanceof Suitcase) && (((Suitcase) it).getSuitcaseName()).equals(suitcasename)) {
                suitcase = (Suitcase) it;
            }
            else if (it.getClass().getSimpleName().equals(itemname)){
                sh = it;
            }
            else if ((suitcase != null) && (sh != null)) {
                System.out.println(character.name + " положил в чемодан " + suitcase.toString());
                character.items.remove(sh);
                suitcase.putItem(sh);
                return;
            }
        }
        throw new ItemException(character.name);
    }

    @Override
    public void putItemInSuitcase(Item itemname, String suitcasename){
        Suitcase suitcase = null;
        Item sh = null;
        for (Item it : character.items) {
            if ((it instanceof Suitcase) && (((Suitcase) it).getSuitcaseName()).equals(suitcasename)) {
                suitcase = (Suitcase) it;
            }
            else if (it.getClass().getSimpleName().equals(itemname)){
                sh = it;
            }
            else if ((suitcase != null) && (sh != null)) {
                System.out.println(character.name + " положил в чемодан " + suitcase.toString());
                character.items.remove(sh);
                suitcase.putItem(sh);
                return;
            }
        }
        throw new ItemException(character.name);
    }

    @Override
    public void openHallwayDoor(){
        if (character.getRoom().getClass().getSimpleName().equals("Hallway")){
            FlatRoom hallway = character.getRoom();
            ((Hallway) hallway).getToDoor().toOpen();
            System.out.println(character.name + " открыл входную дверь");
            for (FlatRoom room: hallway.getConnectedRooms()){
                if (room.equals(hallway)){
                    room.getCharacters().addAll(hallway.getCharacters());
                    hallway.getCharacters().addAll(room.getCharacters());
                    return;
                }
            }
        }
        else{
            throw new RoomException(character.name);
        }
    }

    @Override
    public void toRing(){
        if (character.room instanceof Hallway){
            System.out.println(character.name + " позвонил в входную дверь");
            ((Hallway) character.room).getToDoor().toRing();
        }
        else{
            throw new RoomException(character.name);
        }
    }

    @Override
    public void setRoom(FlatRoom r){
        character.room = r;
    }

    @Override
    public void dropAllItems(){
        System.out.println(character.name + " бросил все свои вещи");
        character.getRoom().getItems().addAll(character.items);
        character.items.clear();
    }

}

