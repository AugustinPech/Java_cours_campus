package DonjonAndDragons2.src.models.items.equipables.Weapon.physical;

import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Game.utilities.Stats;
import DonjonAndDragons2.src.models.Game.utilities.damages.Damage;
import DonjonAndDragons2.src.models.Game.utilities.damages.Normal;
import DonjonAndDragons2.src.models.items.equipables.Weapon.abstractClasses.PhysicalWeapon;

public class Axe extends PhysicalWeapon {

    public Axe(String name, int level) {
        super(name, level);
    }

    @Override
    public Damage hitWith(Caracter caracter) {
        Stats caracterStats = caracter.getStats();
        Stats itemStats = this.getStats();
        Normal damage = new Normal(caracterStats.merge(itemStats), this.getLevel());
        return damage;
    }
    
}
