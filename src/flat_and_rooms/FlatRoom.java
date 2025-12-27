package flat_and_rooms;

import characters.base.Animal;
import enums.Sounds;
import items.Item;
import sound.Sound;

import characters.base.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FlatRoom {
    protected ArrayList <characters.base.Character> characters;
    protected final String description;
    protected Sound sound;
    protected ArrayList<FlatRoom> connectedRooms;
    protected ArrayList<Item> items;
    protected ArrayList<Animal> animals;

    public FlatRoom(ArrayList<characters.base.Character> ch, String des, ArrayList<FlatRoom> r, ArrayList<Animal> a) {
        characters = ch;
        description = des;
        sound = new Sound(Sounds.SILENCE, "В комнате тишина", this);
        connectedRooms = r;
        items = new ArrayList<>();
        animals = a;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<FlatRoom> getConnectedRooms() {
        return connectedRooms;
    }
    public void setConnectedRooms(ArrayList<FlatRoom> connectedRooms) {
        this.connectedRooms = connectedRooms;
    }

    public Sound getSound() {
        return sound;
    }

    public void setSound(Sound sound) {
        this.sound = sound;

        List<Character> charactersCopy = new ArrayList<>(characters);
        for (Character character : charactersCopy) {
            character.hear(sound);
        }

        List<Animal> AnimalCopy = new ArrayList<>(animals);
        for (Animal a : AnimalCopy) {
            a.hear(sound);
        }
    }

    public ArrayList <characters.base.Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList <characters.base.Character> characters) {
        this.characters = characters;
    }

    public void setAnimals(ArrayList<Animal> a){
        this.animals = a;
    }

    public ArrayList<Animal> getAnimals() {
        return this.animals;
    }

    public void addAnimal(Animal a){
        this.animals.add(a);
    }

    public void removeAnimal(Animal a){
        this.animals.remove(a);
    }

    public String getDescription() {
        return description;
    }

    public void addCharacter(Character character) {
        this.characters.add(character);
    }

    public void removeCharacter(Character character) {
        this.characters.remove(character);
    }

    @Override
    public String toString() {
        return this.description;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        FlatRoom room = (FlatRoom) obj;
        return Objects.equals(this.description, room.description) && Objects.equals(this.connectedRooms, room.connectedRooms) && Objects.equals(this.sound, room.sound);
    }

    @Override
    public int hashCode() {
        return (this.description.hashCode() + this.connectedRooms.hashCode());
    }
}
