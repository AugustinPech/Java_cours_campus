package DonjonAndDragons.src.models.Caracters.NPC;

import DonjonAndDragons.src.models.Game.Game;

public class DoorMan extends NPC {
    public DoorMan(Game game) {
        super("DoorMan", game, false, 1);
        this.setSprite( "👮");
    }
}
