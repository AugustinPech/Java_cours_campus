package DonjonAndDragons.src.models.Game.Board;

import DonjonAndDragons.src.models.Caracters.NPC.DoorMan;
import DonjonAndDragons.src.models.Caracters.NPC.NPC;
import DonjonAndDragons.src.models.Game.Game;

public class HallWay extends Room {
    public HallWay(Game game){
        this.name = "Hallway";
        this.npcs = new NPC[1];
        this.npcs[0]=new DoorMan(game);
        this.greatMsg = "Stepping into the murky depths of the dungeon, a chill seeps into your bones as the ancient stone walls loom overhead.\n"+
                        "The air is thick with the scent of moss and decay, and a faint echo of distant whispers fills the corridor. \n"+
                        "Suddenly, a figure emerges from the shadows - the Doorsman, a sentinel of this foreboding realm. \n"+
                        "With a solemn nod, he greets you, his voice a low rumble echoing through the halls. \n"+
                        "       'Welcome, brave adventurer,' he intones, 'to the heart of darkness.'"+
                        "The Doorsman's voice carries a weight of ages past, yet holds a hint of kindness beneath its gruff exterior.\n"+
                        "       'How may I be of service to you, weary traveler?' he asks.";
        
    }
}
