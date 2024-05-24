package DonjonAndDragons2.src.models.items.equipables.Weapon.physical;

import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Game.utilities.Stats;
import DonjonAndDragons2.src.models.Game.utilities.damages.Damage;
import DonjonAndDragons2.src.models.Game.utilities.damages.Normal;
import DonjonAndDragons2.src.models.items.equipables.Weapon.abstractClasses.PhysicalWeapon;

public class Sword extends PhysicalWeapon {

    public Sword(String name, int level) {
        super(name, level);
        this.setSprite("🪓");
    }

    @Override
    public Damage hitWith(Caracter caracter) {
        Stats caracterStats = caracter.getStats();
        Normal damage = new Normal(caracterStats, this.getLevel());
        return damage;
    }
    
}
