package DonjonAndDragons.src.models.Caracters.NPC;

import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.models.Game.Board.Board;

public class Dragon extends NPC{
    public Dragon(Board board,int position) {
        super(
            "Dragon", 
            board.getIsOstile(), 
            position
        );
        this.setSprite( "🐉");
    }

}
