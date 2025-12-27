package flat_and_rooms;

import characters.base.Animal;
import characters.base.Character;
import sound.Sound;

import java.util.ArrayList;

public class Room extends FlatRoom{
    protected Bed bed;

    public Room(ArrayList<characters.base.Character> ch, String des, ArrayList<FlatRoom> r, ArrayList<Animal> a, Bed b) {
        super(ch, des, r, a);
        bed = b;
    }


    public boolean hasBed(){
        return bed != null;
    }

    public Bed getBed(){
        return bed;
    }

}
