package DonjonAndDragons2.src.models.Game.Exception;

public class NotUseAbleException extends Exception{
    public NotUseAbleException(){
        super("This Item can't be used. \nYou may want to equip it instead.");
    }
}
