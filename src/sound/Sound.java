package sound;

import enums.Sounds;
import flat_and_rooms.FlatRoom;

public class Sound {
    protected Sounds type;
    protected  String description;
    protected FlatRoom location;

    public Sound(Sounds type, String description, FlatRoom location) {
        this.type = type;
        this.description = description;
        this.location = location;
    }

    public Sounds getType() {
        return type;
    }

    public void setType(Sounds type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void spreadSound(FlatRoom room) {
        room.setSound(this);
        for (FlatRoom r : room.getConnectedRooms()) {
            if (!r.getSound().equals(this))
                r.setSound(this);
        }
    }
    public FlatRoom getLocation() {
        return location;
    }
}
