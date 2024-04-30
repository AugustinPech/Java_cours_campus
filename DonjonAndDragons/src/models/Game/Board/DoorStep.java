package DonjonAndDragons.src.models.Game.Board;

import DonjonAndDragons.src.models.Caracters.NPC.NPC;
import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.views.Ascii;

public class DoorStep extends Room {
    
public DoorStep(Game game) {
        this.name = "DoorStep";
        this.ascii = Ascii.doorStep();
        this.npcs = new NPC[0];
        this.greatMsg="You stand at the threshold of the dungeon, the heavy wooden door stands before you.";
    }
}   
