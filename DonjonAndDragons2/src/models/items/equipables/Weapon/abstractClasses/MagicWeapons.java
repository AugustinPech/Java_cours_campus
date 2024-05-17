package DonjonAndDragons2.src.models.items.equipables.Weapon.abstractClasses;

import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Game.utilities.Stats;
import DonjonAndDragons2.src.models.Game.utilities.damages.Damage;
import DonjonAndDragons2.src.models.items.usables.Usable;

public abstract class MagicWeapons extends Weapon implements Usable{
    

    public MagicWeapons(String name, int level) {
        super(name, level);
        this.setSprite("🔮");
    }

    
}
