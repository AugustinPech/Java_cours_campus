package DonjonAndDragons2.src.models.items.consumables;

import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.items.Item;

public abstract class Consumable extends Item {

    public Consumable(String name, int level) {
        super(name, level);
        //TODO Auto-generated constructor stub
    }
    public abstract void consumedBy(Caracter caracter);
    
}
