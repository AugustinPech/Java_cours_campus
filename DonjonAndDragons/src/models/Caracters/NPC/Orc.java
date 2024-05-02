package DonjonAndDragons.src.models.Caracters.NPC;

import DonjonAndDragons.src.models.Game.Game;

public class Orc extends NPC{
    public Orc(String name, Game game, int position) {
        super(
            name, 
            game, 
            game.board.getDungeon()[game.board.getSize()-1].getNPC()[0].getIsOstile(),
            position
        );
        this.setSprite("🟠");
    }
}
