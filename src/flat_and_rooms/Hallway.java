package flat_and_rooms;

import characters.base.Animal;
import sound.Sound;

import java.util.ArrayList;

public class Hallway extends FlatRoom {
    private HallwayDoor door;
    public Hallway(ArrayList<characters.base.Character> ch, String des, ArrayList<FlatRoom> rooms, ArrayList<Animal> a) {
        super(ch, des, rooms, a);
        this.door = new HallwayDoor(false, this);
    }

    public Hallway(ArrayList<characters.base.Character> ch, String des, ArrayList<FlatRoom> rooms, ArrayList<Animal> a, HallwayDoor door) {
        super(ch, des, rooms, a);
        this.door = door;
    }

    public HallwayDoor getToDoor() {
        return door;
    }

}
