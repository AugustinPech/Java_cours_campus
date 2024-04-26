package DonjonAndDragons.src.models.Game;
import DonjonAndDragons.src.models.Caracters.Caracter;
import DonjonAndDragons.src.models.items.Item;
public class Room {
    public Caracter[] caracters;
    public Item[] items;
    public String name;
    public Room(){
        this.caracters = new Caracter[0];
        this.items = new Item[0];
        this.fakeName();
    }
    public Room(String name){
        this.caracters = new Caracter[0];
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
    public void great(){
        System.out.println("You are in the "+this.name);
    }
    public void addCaracter(Caracter caracter){
        Caracter[] newCaracters = new Caracter[this.caracters.length+1];
        for (int i = 0; i < this.caracters.length; i++) {
            newCaracters[i] = this.caracters[i];
        }
        newCaracters[this.caracters.length] = caracter;
        this.caracters = newCaracters;
    }
    public void removeCaracter(Caracter caracter){
        Caracter[] newCaracters = new Caracter[this.caracters.length-1];
        int j = 0;
        for (int i = 0; i < this.caracters.length; i++) {
            if (this.caracters[i] != caracter) {
                newCaracters[j] = this.caracters[i];
                j++;
            }
        }
        this.caracters = newCaracters;
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
}
