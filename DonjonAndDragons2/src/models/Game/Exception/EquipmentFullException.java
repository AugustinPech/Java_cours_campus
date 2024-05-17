package DonjonAndDragons2.src.models.Game.Exception;

public class EquipmentFullException extends Exception{
    public EquipmentFullException(){
        super("You can't equip this item, your equipment is full.");
    }

}
