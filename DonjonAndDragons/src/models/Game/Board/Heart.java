package DonjonAndDragons.src.models.Game.Board;

import DonjonAndDragons.src.models.Caracters.NPC.Guardian;
import DonjonAndDragons.src.models.Caracters.NPC.NPC;

public class Heart extends Room {
    public Heart(Board board) {
        this.setName("Heart");
        NPC[] npc = {new Guardian(board)};
        this.setNPC(npc);
        this.setGreatMsg("You have reached the heart of the dungeon, the very core of its existence. \n");
    }
}
