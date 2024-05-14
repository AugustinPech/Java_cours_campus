package DonjonAndDragons.src.models.Game.Board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import DonjonAndDragons.src.models.Caracters.NPC.Gobelin;
import DonjonAndDragons.src.models.Caracters.NPC.NPC;
import DonjonAndDragons.src.models.Caracters.NPC.Orc;
import DonjonAndDragons.src.models.Caracters.Player.Player;
import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.models.items.Armor;
import DonjonAndDragons.src.models.items.Item;
import DonjonAndDragons.src.models.items.Potion;
import DonjonAndDragons.src.models.items.Weapon;

public class Board {
    private int size;
    private Room[] dungeon;
    private Boolean isOstile = false;

    public Board(int size){
        this.size = size;
        this.dungeon = new Room[this.size];
        
        for (int i = 0; i < this.size; i++) {
                    this.dungeon[i] = new Room();
        }
    }


    public void setDungeon(){
        int heart = size-1;
        int boss = size-2;
        this.dungeon[0] = new DoorStep (this);
        this.dungeon[1] = new HallWay (this);
        this.dungeon[boss] = new BossRoom (this);
        this.dungeon[heart] = new Heart (this);
    }
    public int getSize(){
        return this.size;
    }
    public Room[] getDungeon(){
        return this.dungeon;
    }

    public void nPCAreOstile (){
        this.setIsOstile(true);
            this.dungeon[1].setGreatMsg(
                            "As you step into the murky depths of the dungeon, a sense of foreboding settles over you \n"+
                            "like a heavy cloak. The air is thick with the stench of decay, and the oppressive darkness \n"+
                            "seems to press in from all sides, suffocating and claustrophobic.\n"+
                            "Suddenly, from the shadows, a figure emerges - the Doorsman, his eyes glinting with malice \n"+
                            "and his stance aggressive.\n"+
                            "With a sneer, he blocks your path, his voice dripping with hostility as he snarls, \n"+
                            "       'What business do you have here, intruder?'\n"+
                            "The Doorsman's voice reverberates through the corridor like a warning bell, sending shivers \n"+
                            " down your spine and setting your nerves on edge.\n"+
                            "       'You dare to trespass in this domain without knocking the door,' he growls, \n"+
                            "       'Prepare to face the consequences of your folly.'\n"+
                            "With a menacing glare, he raises his fists, ready to strike at any moment.");
        for (int i = 0; i < this.size; i++) {
            if (this.dungeon[i].getNPC() != null){
                for (int j = 0; j < this.dungeon[i].getNPC().length; j++) {
                    if (this.dungeon[i].getNPC()[j] != null){
                        NPC[] npcs = this.dungeon[i].getNPC();
                        npcs [j].setIsOstile(true);
                        this.dungeon[i].setNPC(npcs);
                    }
                }
            }
        }
    }

    public void generateRoomContent(Player player, int roll) {
        int position = player.getPosition();
        Room nextRoom = this.dungeon[position+1];
        ArrayList<NPC> npcs = new ArrayList<NPC>();
        ArrayList<Item> items = new ArrayList<Item>();
        if (position < this.size-2){
            if (roll <25){
                npcs.add(new Gobelin("Gobelin", this, position+1));
            } else if (roll <50){
                npcs.add(new Orc("Orc", this, position+1));
            } else if (roll <75){
                items.add(new Potion("Potion of Healing", "Health"));
                items.add(new Potion("Elixir of Protection", "Protection"));
            } else {
                for (int i = 0 ; i < player.getLevel()+1; i++){
                    Weapon weapon = new Weapon (roll, player.getLevel()+2);
                    Armor armor = new Armor (roll, player.getLevel()+2);
                    Potion potion = new Potion (roll, player.getLevel()+2);
                    if (roll%3==0) {
                        items.add(weapon);
                    } else if (roll%3==1) {
                        items.add(armor);
                    } else {
                        items.add(potion);
                    }
                }
            }
            for (Item item : items) {
                nextRoom.addItem(item);
            }
            for (NPC npc : npcs) {
                nextRoom.addNPC(npc);
            }
        }
    }

    public boolean getIsOstile(){
        return this.isOstile;
    }
    public void setIsOstile(Boolean isOstile){
        this.isOstile = isOstile;
    }
}
