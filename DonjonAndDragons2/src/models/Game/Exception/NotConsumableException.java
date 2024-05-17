package DonjonAndDragons2.src.models.Game.Exception;

import DonjonAndDragons2.src.models.items.Item;

public class NotConsumableException extends Exception{
    public NotConsumableException(Item item) {
        super(item.toString() + " is not consumable");
    }

}
