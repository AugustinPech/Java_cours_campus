package DonjonAndDragons2.src.models.items.equipables.Weapon.abstractClasses;

import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Game.utilities.Stats;
import DonjonAndDragons2.src.models.Game.utilities.damages.Damage;
import DonjonAndDragons2.src.models.items.equipables.Equipable;

public abstract class Weapon extends Equipable {
    public Weapon(String name, int level) {
        super(name, level);
        this.setSprite("⚔️");
    }

    public abstract Damage hitWith(Caracter caracter);
      
}
