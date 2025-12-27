package flat_and_rooms;

import characters.base.Character;

import java.util.Objects;

public class Bed {
    protected boolean isOccupied;
    protected characters.base.Character whoIsLying;

    public Bed(boolean isOccupied, characters.base.Character whoIsLying) {
        this.isOccupied = isOccupied;
        this.whoIsLying = whoIsLying;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public characters.base.Character getWhoIsLying() {
        return whoIsLying;
    }

    public void setWhoIsLying(characters.base.Character whoIsLying) {
        this.whoIsLying = whoIsLying;
        if (whoIsLying != null){
            this.isOccupied = true;
        }
    }

    public void leaveBed(){
        isOccupied = false;
        whoIsLying = null;
    }

    @Override
    public String toString() {
        return "Bed_" + this.whoIsLying;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Bed bed = (Bed) obj;
        return this.isOccupied == ((Bed) obj).isOccupied && Objects.equals(this.whoIsLying, bed.whoIsLying);
    }

    @Override
    public int hashCode() {
        return Objects.hash(whoIsLying, isOccupied);
    }
}
