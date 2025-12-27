package characters.base;

import enums.MentalState;
import exceptions.MovementException;
import flat_and_rooms.FlatRoom;
import flat_and_rooms.Hallway;
import interfaces.CharacterState;
import items.Item;
import items.Watercan;
import sound.Sound;

import java.util.ArrayList;

public class Unconscious implements CharacterState {
    characters.base.Character character;
    public Unconscious(Character character){
        this.character = character;
    }

    @Override
    public void moveTo(FlatRoom room) {
        throw new MovementException(character.name, "перемещение");
    }

    @Override
    public void setMentalState(MentalState ms) {
        throw new MovementException(character.name, "изменение психического состояния");
    }

    @Override
    public void dropItem(String itemName) {
        throw new MovementException(character.name, "бросание предмета");
    }

    @Override
    public void pickItem(Item item) {
        throw new MovementException(character.name, "поднятие предмета");
    }

    @Override
    public void hear(Sound sound) {
        System.out.println(character.name + " без сознания и не слышит " + sound);
    }

    @Override
    public void see(characters.base.Character character) {
        System.out.println(character.name + " без сознания и не видит " + character.name);
    }

    @Override
    public void shoot(characters.base.Character ch){
        throw new MovementException(character.name, "стрельба");
    }

    @Override
    public void pourOnCharacter(Character ch){
        throw new MovementException(character.name, "поливание жидкостью");
    }

    @Override
    public void getItemFromSuitcase(String itemname, String suitcasename) {
        throw new MovementException(character.name, "взятие предмета из чемодана");
    }

    @Override
    public void getItemFromSuitcase(Item itemname, String suitcasename) {
        throw new MovementException(character.name, "взятие предмета из чемодана");
    }

    @Override
    public void putItemInSuitcase(String itemname, String suitcasename) {
        throw new MovementException(character.name, "положение предмета в чемодан");
    }

    @Override
    public void putItemInSuitcase(Item itemname, String suitcasename) {
        throw new MovementException(character.name, "положение предмета в чемодан");
    }

    @Override
    public Item getItem(String itemname) {
        throw new MovementException(character.name, "получение предмета");
    }

    @Override
    public ArrayList<Item> getItems() {
        throw new MovementException(character.name, "получение списка предметов");
    }

    @Override
    public void toRing(){
        throw new MovementException(character.name, "звонок");
    }

    @Override
    public void setRoom(FlatRoom r){
        throw new MovementException(character.name, "изменение комнаты");
    }
    @Override
    public void openHallwayDoor(){
        throw new MovementException(character.name, "изменение комнаты");
    }

    @Override
    public void dropAllItems(){
        throw new MovementException(character.name, "выброс всех предметов");
    }

}