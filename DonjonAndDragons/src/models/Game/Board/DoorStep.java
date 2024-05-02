package DonjonAndDragons.src.models.Game.Board;

import DonjonAndDragons.src.models.Caracters.NPC.NPC;
import DonjonAndDragons.src.views.Ascii;

public class DoorStep extends Room {
    
public DoorStep(Board board) {
        this.setName("DoorStep");
        this.setAscii( Ascii.doorStep());
        
        this.setNPC(new NPC[0]);
        this.setGreatMsg("You stand at the threshold of the dungeon, the heavy wooden door stands before you.");
    }
}   
