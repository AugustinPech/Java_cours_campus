package DonjonAndDragons.src.models.Caracters.NPC;

import DonjonAndDragons.src.models.Stats;
import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.models.Game.Board.Board;
import DonjonAndDragons.src.models.Game.Exception.PlayerIsDeadException;

public class Dragon extends NPC{
    public Dragon(Board board,int position) {
        super(
            "Dragon", 
            board.getIsOstile(), 
            position
        );
        this.setSprite( "🐉");
                this.setLevel((int) (Math.random()*10+20));
        try {
            this.setStats(new Stats (10*this.getLevel()+1, (int) this.getLevel()/2, 1, this.getLevel()+10, 0));
        } catch (PlayerIsDeadException e){}
    }
    public Dragon (Board board , int position, int level){
        super(
            "Dragon", 
            board.getIsOstile(), 
            position
        );
        this.setSprite( "🐉");
        this.setLevel(level);
        try {
            this.setStats(new Stats (10*this.getLevel()+1, (int) this.getLevel()/2, 1, this.getLevel()+10, 0));
        } catch (PlayerIsDeadException e){}
    }
}
