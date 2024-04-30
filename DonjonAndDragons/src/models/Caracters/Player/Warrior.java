package DonjonAndDragons.src.models.Caracters.Player;
import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.models.items.Armor;
import DonjonAndDragons.src.models.items.Weapon;
public class Warrior extends Player{
    public Warrior(String name, Game game) {
        super(name, game);
        this.caracterClass = "Warrior";
        this.type = "fighter";
        this.sprite="🔪";
        this.setFullName();
        this.addItem(new Weapon(this.caracterClass));
        this.equipItem(0);
        this.addItem(new Armor(this.caracterClass));
        this.equipItem(0);
        this.setDamage();
        this.setArmor();
    }
}
