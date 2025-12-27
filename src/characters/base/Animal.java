package characters.base;

import characters.base.Character;
import enums.MentalState;
import enums.Sounds;
import flat_and_rooms.FlatRoom;
import sound.Sound;

public class Animal {
    private String name;
    private String description;
    private FlatRoom room;
    private Sound s;

    public Animal(String name, String description, FlatRoom room) {
        this.name = name;
        this.description = description;
        this.room = room;
        s = new Sound(Sounds.BARK, "лай", room);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void bark() {
        System.out.println(this.name + " гавкает!");
        s.spreadSound(room);

    }
    public void moveTo(FlatRoom room) {
        System.out.println(this.name + " переходит в " + room.toString());
        for (Character a: room.getCharacters()){
            this.see(a);
        }
        this.room.removeAnimal(this);
        this.room = room;
        this.room.addAnimal(this);

    }
    public void see(Character character){
        System.out.println(this.name + " видит " + character.getName());
        if (character.getMentalState().equals(MentalState.UNCONSCIOUS)){
            this.bark();
        }
    }

    public void hear(Sound s){
        System.out.println(this.name + " слышит " + s.getType().getDescription());
        if (s.getType().toString().equals("SHOOT")){
            this.moveTo(s.getLocation());
        }
    }
}
