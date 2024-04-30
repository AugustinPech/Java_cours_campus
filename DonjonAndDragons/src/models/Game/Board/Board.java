package DonjonAndDragons.src.models.Game.Board;

import java.util.Collections;
import java.util.List;

import DonjonAndDragons.src.models.Caracters.NPC.Gobelin;
import DonjonAndDragons.src.models.Caracters.NPC.NPC;
import DonjonAndDragons.src.models.Caracters.NPC.Orc;
import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.models.items.Item;

public class Board {
    public int size;
    public Room[] dungeon;

    public Board(int size, Game game){
        this.size = size;
        int heart = size-1;
        int boss = size-2;
        this.dungeon = new Room[this.size];
        
        for (int i = 0; i < this.size; i++) {
                    this.dungeon[i] = new Room();
        }
        this.dungeon[0] = new DoorStep(game);
        this.dungeon[1] = new HallWay(game);
        this.dungeon[boss] = new BossRoom( game);
        this.dungeon[heart] = new Heart (game);
    }

    public void nPCAreOstile (){
        for (int i = 0; i < this.size; i++) {
            this.dungeon[i].greatMsg=
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
                            "With a menacing glare, he raises his fists, ready to strike at any moment.";
            if (this.dungeon[i].npcs != null){
                for (int j = 0; j < this.dungeon[i].npcs.length; j++) {
                    if (this.dungeon[i].npcs[j] != null){
                        this.dungeon[i].npcs[j].setIsOstile(true);
                    }
                }
            }
        }
    }

    public void generateRoomContent(Game game, int role) {
        int position = game.player.position;
        Room nextRoom = this.dungeon[position+1];
        if (position < this.size-2){
            if (role <50){
                nextRoom.npcs= new NPC[1];
                nextRoom.npcs[0]= new Gobelin(game);
            }
            if (role >=50 && role <75){
                nextRoom.npcs= new NPC[1];
                nextRoom.npcs[0]= new Orc(game);
            }
            if (role >=75){
                nextRoom.items= new Item[1];
                nextRoom.items[0]= new Potion();
            }
        }
    }
    
}
