package DonjonAndDragons.src.models.Game.Board;
import DonjonAndDragons.src.models.Caracters.Caracter;
import DonjonAndDragons.src.models.Caracters.NPC.NPC;
import DonjonAndDragons.src.models.Caracters.Player.Player;
import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.models.items.Item;
public class Room {
    public NPC[] npcs;
    public String [] ascii;
    public Item[] items;
    public String name;
    public String greatMsg;
    public Room(){
        // make a method to pick random preconfigurated room
        this.npcs = new NPC[0]; 
        this.items = new Item[0];
        this.fakeName();
        this.greatMsg="You entered the " + this.name;
    }
    public Room(String name, Game game){

        this.npcs = new NPC[0];
        this.items = new Item[0];
        this.name = name;
    }
    public void fakeName(){
        String[] seriousRoomNames = {
            "Chamber of the Ancients",
            "Hall of Elders",
            "Corridor of Shadows",
            "Catacombs of the Fallen",
            "Gallery of Relics",
            "Den of the Undying",
            "Vault of Legends",
            "Labyrinth of Lost Souls",
            "Cavern of Echoes",
            "Tunnel of Whispers",
            "Chateau of Echoing Mysteries",
            "Grotto of Forgotten Lore",
            "Maze of Enigma",
            "Pit of Destiny",
            "Gangway of Fate",
            "Crypt of Secrets",
            "Aisle of Antiquity",
            "Passageway of Prophecy",
            "Dungeon of Desolation",
            "Arcade of Arcana",
            "Rampart of Ruin",
            "Vault of Valor",
            "Sanctum of Sorcery",
            "Chapel of Shadows",
            "Terrace of Timeless Wisdom",
            "Coliseum of Conquest",
            "Tower of Titans",
            "Platform of Power",
            "Corral of Celestial Guardians"
        };
        this.name = seriousRoomNames[(int)(Math.random()*seriousRoomNames.length)];
    }
    
    public String great(){
        return (this.greatMsg);
    }
    public void addNPC(NPC npc, Game game){
        NPC[] newNPCs = new NPC[this.npcs.length+1];
        for (int i = 0; i < this.npcs.length; i++) {
            newNPCs[i] = this.npcs[i];
        }
        newNPCs[this.npcs.length] = npc;
        this.npcs = newNPCs;
    }
    public void removeNPC(NPC npc){
        NPC[] newNPCs = new NPC[this.npcs.length-1];
        int j = 0;
        for (int i = 0; i < this.npcs.length; i++) {
            if (this.npcs[i] != npc) {
                newNPCs[j] = this.npcs[i];
                j++;
            }
        }
        this.npcs = newNPCs;
    }
    public void addItem(Item item){
        Item[] newItems = new Item[this.items.length+1];
        for (int i = 0; i < this.items.length; i++) {
            newItems[i] = this.items[i];
        }
        newItems[this.items.length] = item;
        this.items = newItems;
    }
    public void removeItem(Item item){
        Item[] newItems = new Item[this.items.length-1];
        int j = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != item) {
                newItems[j] = this.items[i];
                j++;
            }
        }
        this.items = newItems;
    }

    @Override
    public String toString() {
        String str = "";
        if (this.npcs== null) {
            return "-";
        }
        for (NPC npc : this.npcs){
            str += npc.sprite;
        }
        return str;
    }
}