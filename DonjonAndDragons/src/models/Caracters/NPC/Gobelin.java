package DonjonAndDragons.src.models.Caracters.NPC;
import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.models.Game.Board.Board;
public class Gobelin extends NPC {
    
    
    public Gobelin(String name, Board board, int position) {
        super(
            name, 
            board.getIsOstile(),
            position
        );
        this.setSprite("🟢");
    }
}
