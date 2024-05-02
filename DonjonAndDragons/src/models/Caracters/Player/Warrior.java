package DonjonAndDragons.src.models.Caracters.Player;
import DonjonAndDragons.src.models.Stats;
import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.models.items.Armor;
import DonjonAndDragons.src.models.items.Weapon;
public class Warrior extends Player{
    public Warrior(String name, Game game) {
        super(name, game);
        this.setCaracterClass("Warrior");
        this.setBaseStats(new Stats(100,1,1,5, 0));
        this.setType("fighter");
        this.setSprite("🔪");
        this.setFullName();
        Weapon weapon = new Weapon(this.getCaracterClass());
        this.addItem(weapon);
        this.equipItem(0);
        this.addItem(new Armor(this.getCaracterClass()));
        this.equipItem(0);
        this.considerEquipment();
    }
    public Warrior(int num) {//god mode
    super (num);
    this.setCaracterClass("Warrior");
    }
}
