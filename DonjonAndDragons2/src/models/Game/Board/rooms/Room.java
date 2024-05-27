package DonjonAndDragons2.src.models.Game.Board.rooms;
import java.util.ArrayList;

import DonjonAndDragons2.src.models.items.Item;
import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Caracters.Player.Playable;

public abstract class Room {
    private String name;
    private String description;
    private int level;
    private boolean visited = false;
    private ArrayList<Caracter> npcs= new ArrayList<Caracter>();
    private ArrayList<Item> items= new ArrayList<Item>();
    private ArrayList<Caracter> whosThere = new ArrayList<Caracter>();
    public Room(int level) {
        this.level = level;
    }
    
    public abstract void enterRoom();
    public abstract void leaveRoom();
    public abstract ArrayList<Caracter> getCaracters();

    public void addItem (Item item) {
        this.items.add(item);
    }
    public void addNpc (Caracter npc) {
        this.npcs.add(npc);
    }
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
    public ArrayList<Caracter> getWhosThere() {
        return whosThere;
    }

    public void setWhosThere(ArrayList<Caracter> whosThere) {
        for (Caracter caracter : whosThere) {
            if (caracter instanceof Playable) {
                this.setVisited(true);
            }
        }
        this.whosThere = whosThere;
    }
    public boolean getVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    @Override
    public String toString() {
        String str = "";
        str += "------------ "+this.getName()+" ------------\n";
        if (this.getNpcs()!=null && this.getNpcs().size() > 0) {
            for (Caracter npc : this.getNpcs()) {
                str += npc;
            }
            str+="\n";
        }
        if (this.getItems()!=null && this.getItems().size() > 0) {
        for (Item item : this.getItems()) {
                str += item;
            }
        }
        str+="\n";
        str += "---------------------------------------------\n";
        return str;
    }

}
