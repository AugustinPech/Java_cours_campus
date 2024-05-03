package DonjonAndDragons.src.models.Game.Exception;

public class PlayerIsDeadException extends Exception{
    public PlayerIsDeadException(){
        super("You are dead. Game Over.");
    }
}
