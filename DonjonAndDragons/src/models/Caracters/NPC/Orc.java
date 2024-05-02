package DonjonAndDragons.src.models.Caracters.NPC;

import DonjonAndDragons.src.models.Game.Board.Board;

public class Orc extends NPC{
    public Orc(String name, Board board, int position) {
        super(
            name, 
            board.getIsOstile(),
            position
        );
        this.setSprite("🟠");
    }
}
