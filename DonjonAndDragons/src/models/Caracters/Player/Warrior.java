package DonjonAndDragons.src.models.Caracters.Player;
import DonjonAndDragons.src.models.Stats;
import DonjonAndDragons.src.models.Caracters.interfaces.Fighter;
import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.models.Game.Exception.InventoryFullException;
import DonjonAndDragons.src.models.Game.Exception.PlayerIsDeadException;
import DonjonAndDragons.src.models.items.Armor;
import DonjonAndDragons.src.models.items.Weapon;
public class Warrior extends Player implements Fighter{
    public Warrior(String name, Game game) {
        super(name, game);
        try{
        this.setCaracterClass("Warrior");
        this.setStats(new Stats(100,1,1,5,0, 0));
        this.setSprite("🔪");
        this.setFullName();
        Weapon weapon = new Weapon(this.getCaracterClass());
        this.addItem(weapon);
        try{
            this.equipItem(0);
        }catch (Exception e){
        }
        this.addItem(new Armor(this.getCaracterClass()));
        try{
            this.equipItem(0);
        }catch (Exception e){
        }
        this.considerEquipment();
        } catch (PlayerIsDeadException e) {
        }catch (InventoryFullException e){
        }
    }
    public Warrior(int num) {//god mode
    super (num);
    this.setCaracterClass("Warrior");
    }
    public void levelUp() {
        this.setLevel(this.getLevel()+1);
        this.getStats().setLifePoints(this.getStats().getLifePoints()+10);
        this.getStats().setDamage(this.getStats().getDamage()+1);
        this.getStats().setArmor(this.getStats().getArmor()+2);
        this.getStats().setExperience(this.getStats().getExperience()-10);
        if (this.getStats().getExperience() >=10) {
            this.levelUp();
        }
    }
}
