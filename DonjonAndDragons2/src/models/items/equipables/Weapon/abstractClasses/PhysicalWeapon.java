package DonjonAndDragons2.src.models.items.equipables.Weapon.abstractClasses;

public abstract class PhysicalWeapon extends Weapon {

    public PhysicalWeapon(String name, int level) {
        super(name, level);
        this.setSprite("⚔️");
    }
    
}
