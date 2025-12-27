package characters.base;

import enums.MentalState;
import flat_and_rooms.Bed;
import flat_and_rooms.FlatRoom;
import flat_and_rooms.Room;
import interfaces.CharacterState;
import items.Item;
import sound.Sound;


import java.util.ArrayList;
import java.util.Objects;

abstract public class Character {
    protected String name;
    protected String description;
    protected FlatRoom room;
    protected MentalState mentalState;
    protected ArrayList<Item> items;
    protected CharacterState state;
    protected Unconscious uncon;


    protected Character(String n, String des, FlatRoom r, MentalState ms, ArrayList<Item> it) {
        name = n;
        description = des;
        room = r;
        mentalState = ms;
        items = it;
        state = new Conscious(this);
    }

    protected Character(String n, String des, FlatRoom r, MentalState ms) {
        name = n;
        description = des;
        room = r;
        mentalState = ms;
        state = new Conscious(this);
        items = new ArrayList<Item>();
    }

    protected Character(String n, String des, FlatRoom r) {
        name = n;
        description = des;
        room = r;
        mentalState = MentalState.CONSCIOUS;
        state = new Conscious(this);
        items = new ArrayList<Item>();
    }

    protected Character(String n, String des, FlatRoom r, ArrayList<Item> it) {
        name = n;
        description = des;
        room = r;
        items = it;
        state = new Conscious(this);
        mentalState = MentalState.CONSCIOUS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getDescription() {
        System.out.println(description);
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public Item getItem(String name) {
        return this.state.getItem(name);
    }

    public ArrayList<Item> getItems() {
        return this.state.getItems();
    }

    public FlatRoom getRoom() {
        return room;
    }

    public void moveTo(FlatRoom r) {
        this.state.moveTo(r);
    }

    public MentalState getMentalState() {
        return mentalState;
    }

    public void setMentalState(MentalState ms) {
        this.state.setMentalState(ms);
    }

    public CharacterState getState() {
        return state;
    }

    public void dropItem(String item) {
        this.state.dropItem(item);
    }

    public void dropAllItems() {
        this.state.dropAllItems();
    }

    public void pickItem(Item item){
        this.state.pickItem(item);
    }

    public void loseConscious() {
        this.setMentalState(MentalState.UNCONSCIOUS);
        this.dropAllItems();
        this.state = new Unconscious(this);
    }

    public void regainConscious() {
        this.state = new Conscious(this);
        this.setMentalState(MentalState.CONSCIOUS);

    }

    public void getWet() {
        System.out.println(this.name + " теперь мокрый!");
    }

    abstract public void hear(Sound s);
    abstract public void see(Character character);

    public void ring(){
        this.state.toRing();
    }

    public void shoot(Character character){
        this.state.shoot(character);
    }


    public void pourOnCharacter(Character character){
        this.state.pourOnCharacter(character);
    }

    public void getItemFromSuitcase(String itemname, String suitcasename) {
        this.state.getItemFromSuitcase(itemname, suitcasename);
    }

    public void putItemInSuitcase(String item, String suitcasename){
        this.state.putItemInSuitcase(item, suitcasename);
    }

    public void setRoom(FlatRoom room) {
        this.state.setRoom(room);
    }

    public void openHallwayDoor(){
        this.state.openHallwayDoor();
    }

    @Override
    public String toString() {
        return "Character_" + this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Character character = (Character) obj;
        return Objects.equals(this.name, character.name);
    }

    @Override
    public int hashCode() {
        return (name.hashCode());
    }

    public void getToBed(){
        if ((this.getRoom().getClass().getSimpleName() == "Room") && (((Room) this.getRoom()).hasBed())){
            System.out.println(this.name + " лёг на кровать");
            Bed bed = ((Room) this.getRoom()).getBed();
            bed.setWhoIsLying(this);
        }
    }

    public void leaveBed(){
        if ((this.getRoom().getClass().getSimpleName().equals("Room")) && (((Room) this.getRoom()).hasBed())){
            System.out.println(this.name + " встал с кровати");
            Bed bed = ((Room) this.getRoom()).getBed();
            bed.leaveBed();
        }
    }
}
