package items;
import characters.base.Character;
import flat_and_rooms.FlatRoom;

public class Watercan extends Item{
    private boolean full;

    public Watercan(FlatRoom location, Character character, boolean full) {
        super(location, character);
        this.full = full;
    }
    public Watercan(FlatRoom location, boolean full) {
        super(location);
        this.full = full;
    }
    public Watercan(FlatRoom location) {
        super(location);
        this.full = false;
    }

    public boolean isFull() {
        return full;
    }
    public void pourInWater() {
        this.full = true;
    }
    public void pourOnCharacter(Character ch) {
        System.out.println("успешно полил из лейки " + ch.getName());
        this.full = false;
        ch.getWet();
    }
    @Override
    public String toString() {
        return "лейка";
    }
}
