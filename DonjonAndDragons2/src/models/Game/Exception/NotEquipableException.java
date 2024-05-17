package DonjonAndDragons2.src.models.Game.Exception;

public class NotEquipableException extends Exception {
    public NotEquipableException(){
        super("This Item can't be equipped. \nYou may want to use it instead.");
    }
}
