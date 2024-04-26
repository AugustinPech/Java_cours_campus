package DonjonAndDragons.src.models.Caracters;
import DonjonAndDragons.src.models.Caracters.Caracter;
import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.models.items.Armor;
import DonjonAndDragons.src.models.items.Item;
import DonjonAndDragons.src.models.items.Weapon;
import DonjonAndDragons.src.views.Ascii;
public class Warrior extends Player{
    public Warrior(String name, Game game) {
        super(name, game);
        this.caracterClass = "Warrior";
        this.type = "fighter";
        this.sprite=Ascii.warriorSprite();
        this.mipple="🛡️";
        this.setFullName();
        this.addItem(new Weapon(this.caracterClass));
        this.equipItem(0);
        this.addItem(new Armor(this.caracterClass));
        this.equipItem(0);
        this.setDamage();
        this.setArmor();
        this.createStatsView();
    }
}
