package DonjonAndDragons.src.models.Game.Board;

import DonjonAndDragons.src.models.Caracters.NPC.Guardian;
import DonjonAndDragons.src.models.Caracters.NPC.NPC;
import DonjonAndDragons.src.models.Game.Game;

public class Heart extends Room {
    public Heart(Game game) {
        this.setName("Heart");
        NPC[] npc = {new Guardian(game)};
        this.setNPC(npc);
        this.setGreatMsg("You have reached the heart of the dungeon, the very core of its existence. \n");
    }
}
