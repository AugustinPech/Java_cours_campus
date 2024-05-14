package DonjonAndDragons.src.models.Game.Exception;

public class PlayerIsDeadException extends RuntimeException{
    public PlayerIsDeadException(){
        super("You are dead. Game Over.");
    }
}
