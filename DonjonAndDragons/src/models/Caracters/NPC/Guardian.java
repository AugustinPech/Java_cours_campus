package DonjonAndDragons.src.models.Caracters.NPC;

import DonjonAndDragons.src.models.Game.Game;

public class Guardian extends NPC{
    public Guardian(Game game) {
        super("Guardian", game, false, game.board.getSize()-1);
        this.setSprite("🧙");
    }
}
