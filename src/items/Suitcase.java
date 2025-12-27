package items;

import characters.base.Character;
import flat_and_rooms.FlatRoom;

import java.util.ArrayList;
import java.util.Objects;

public class Suitcase extends Item{
    protected ArrayList<Item> items;
    protected final String name;

    public Suitcase(FlatRoom location, Character character, ArrayList<Item> item, String name) {
        super(location, character);
        this.items = items;
        this.name = name;
    }
    public Suitcase(FlatRoom location, ArrayList<Item> items, String name) {
        super(location);
        this.items = items;
        this.name = name;
    }
    public Suitcase(FlatRoom location, String name) {
        super(location);
        this.items = new ArrayList<Item>();
        this.name = name;
    }
    public Item getItem(String itemName) {
        for (Item item : items) {
            if (item.getClass().getSimpleName().equals(itemName)) {
                items.remove(item);
                return item;
            }
        }
        System.out.println("There is no " + itemName + " in the suitcase");
        return null;
    }

    public Item getItem(Item itemname) {
        for (Item item : items) {
            if (item == itemname) {
                items.remove(item);
                return item;
            }
        }
        System.out.println("There is no " + itemname + " in the suitcase");
        return null;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void putItem(Item item) {
        items.add(item);
    }

    public String getSuitcaseName() {
        return name;
    }


    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Suitcase s = (Suitcase) obj;
        return Objects.equals(this.name, s.name);
    }

    @Override
    public int hashCode() {
        return (name.hashCode());
    }

}
