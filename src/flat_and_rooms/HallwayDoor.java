package flat_and_rooms;

import characters.base.Character;
import enums.Sounds;
import sound.Sound;

import java.util.Objects;

import static enums.Sounds.*;

public class HallwayDoor {
    protected boolean isOpen;
    protected final Hallway hallway;
    protected final Sound ring;

    HallwayDoor(boolean isOpen, Hallway hallway) {
        this.isOpen = isOpen;
        this.hallway = hallway;
        ring = new Sound(Sounds.RING, "And the doorbell rings.", hallway);
    }

    public boolean isOpen() {
        return isOpen;
    }
    public void toOpen() {
        if (isOpen) {
            System.out.println("The door is already open!");
        }
        else {
            this.isOpen = true;
        }
    }
    public void toClose() {
        if (isOpen) {
            this.isOpen = false;
        }
        else {
            System.out.println("The door is already closed!");
        }
    }

    public void toRing() {
        ring.spreadSound(hallway);
    }

    @Override
    public String toString() {
        return "HallwayDoor_" + this.hallway;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        HallwayDoor door = (HallwayDoor) obj;
        return Objects.equals(this.hallway, door.hallway);
    }

    @Override
    public int hashCode() {
        return this.hallway.hashCode();
    }
}
