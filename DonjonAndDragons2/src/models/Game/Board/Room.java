package DonjonAndDragons2.src.models.Game.Board;
import java.util.ArrayList;

import DonjonAndDragons2.src.models.items.Item;
import DonjonAndDragons2.src.models.Caracters.Caracter;

public abstract class Room {
    private String name;
    private String description;
    private int level;
    private ArrayList<Caracter> npcs;
    private ArrayList<Item> items;

    public Room(int level) {
        this.level = level;
    }
    @Override
    public String toString() {
        String str = "";
        if (this.npcs.size() > 0) {
            for (Caracter npc : this.npcs) {
                str += npc.getSprite();
            }
        }
        if (this.items.size() > 0) {
            str += "🪙";
        }
        return super.toString();
    }
    
    public abstract void enterRoom();
    public abstract void leaveRoom();
    public abstract ArrayList<Caracter> getCaracters();

    public ArrayList<Caracter> getNpcs() {
        return npcs;
    }

    public void setNpcs(ArrayList<Caracter> npcs) {
        this.npcs = npcs;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

}
