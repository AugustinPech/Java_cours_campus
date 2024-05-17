package DonjonAndDragons2.src.models.Game.Exception;

public class InventoryFullException extends Exception{
    public InventoryFullException(String context){
        super("You can't "+context+" this item, your inventory is full.");
    }

}
