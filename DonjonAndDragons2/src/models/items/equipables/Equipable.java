package DonjonAndDragons2.src.models.items.equipables;

import DonjonAndDragons2.src.models.Game.utilities.Stats;
import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.items.Item;
import DonjonAndDragons2.src.models.Game.utilities.damages.Damage;

public abstract class Equipable extends Item {
    public Equipable (String name , int level) {
        super(name, level);
    }
}
