package DonjonAndDragons.src.models.Caracters.NPC;

import DonjonAndDragons.src.models.Game.Board.Board;

public class DoorMan extends NPC {
    public DoorMan(Board board) {
        super(
            "DoorMan", 
            board.getIsOstile(), 
            1
        );
        this.setSprite( "👮");
    }
}
