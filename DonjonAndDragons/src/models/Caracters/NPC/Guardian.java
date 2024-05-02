package DonjonAndDragons.src.models.Caracters.NPC;

import DonjonAndDragons.src.models.Game.Board.Board;

public class Guardian extends NPC{
    public Guardian(Board board) {
        super(
            "Guardian", 
            board.getIsOstile(), 
            board.getSize()-1
        );
        this.setSprite("🧙");
    }
}
