package DonjonAndDragons.src.models.Game;
import DonjonAndDragons.src.models.Caracters.Caracter;
import DonjonAndDragons.src.models.Caracters.NPC;
import DonjonAndDragons.src.models.Caracters.Player;
import DonjonAndDragons.src.models.items.Item;
public class Room {
    public Caracter[] caracters;
    public Item[] items;
    public String name;
    public String greatMsg;
    public Room(){
        // make a method to pick random preconfigurated room
        this.caracters = new Caracter[0]; 
        this.items = new Item[0];
        this.fakeName();
        this.greatMsg="You entered the " + this.name;
    }
    public Room(String name, Game game){
        switch (name) {
            case "Hallway" :
                this.caracters = new Caracter[1];
                this.caracters[0]=new NPC("Doorsman", game);
                this.greatMsg = "Stepping into the murky depths of the dungeon, a chill seeps into your bones as the ancient stone walls loom overhead.\n"+
                                "The air is thick with the scent of moss and decay, and a faint echo of distant whispers fills the corridor. \n"+
                                "Suddenly, a figure emerges from the shadows - the Doorsman, a sentinel of this foreboding realm. \n"+
                                "With a solemn nod, he greets you, his voice a low rumble echoing through the halls. \n"+
                                "       'Welcome, brave adventurer,' he intones, 'to the heart of darkness.'"+
                                "The Doorsman's voice carries a weight of ages past, yet holds a hint of kindness beneath its gruff exterior.\n"+
                                "       'How may I be of service to you, weary traveler?' he asks.";
                break;
            case "Doorstep" :
                this.caracters = new Caracter[0];
                this.greatMsg="You stand at the threshold of the dungeon, the heavy wooden door stands before you.";
                break;
            default :
            this.caracters = new Caracter[0];
        }
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
    public void encounter(Player player, Game game) {
        // this is the encounter method
        this.great();
    }
}
