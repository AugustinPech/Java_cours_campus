package DonjonAndDragons.src.models.Game.Exception;

public class InventoryFullException extends Exception{
    public InventoryFullException(){
        super("You can't pick up this item, your inventory is full.");
    }

}
