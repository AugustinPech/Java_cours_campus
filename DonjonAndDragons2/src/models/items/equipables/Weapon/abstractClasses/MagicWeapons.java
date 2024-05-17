package DonjonAndDragons2.src.models.items.equipables.Weapon.abstractClasses;

import DonjonAndDragons2.src.models.items.interfaces.Usable;

public abstract class MagicWeapons extends Weapon implements Usable{
    

    public MagicWeapons(String name, int level) {
        super(name, level);
        this.setSprite("🔮");
    }

    
}
