package DonjonAndDragons.src.models.Caracters.NPC;

import DonjonAndDragons.src.models.Game.Game;

public class Dragon extends NPC{
    public Dragon(Game game) {
        super("Dragon", game, false, game.board.getSize()-2);
        this.setSprite( "🐉");
    }

}
