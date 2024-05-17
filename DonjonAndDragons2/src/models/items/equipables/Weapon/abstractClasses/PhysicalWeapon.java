package DonjonAndDragons2.src.models.items.equipables.Weapon.abstractClasses;

import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Game.utilities.Stats;
import DonjonAndDragons2.src.models.Game.utilities.damages.Damage;

public abstract class PhysicalWeapon extends Weapon {

    public PhysicalWeapon(String name, int level) {
        super(name, level);
        this.setSprite("⚔️");
    }
    
}
