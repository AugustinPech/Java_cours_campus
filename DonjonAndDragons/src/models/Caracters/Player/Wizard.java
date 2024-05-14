package DonjonAndDragons.src.models.Caracters.Player;
import DonjonAndDragons.src.models.Stats;
import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.models.Game.Exception.EquipmentFullException;
import DonjonAndDragons.src.models.Game.Exception.InventoryFullException;
import DonjonAndDragons.src.models.Game.Exception.NotEquipableException;
import DonjonAndDragons.src.models.Game.Exception.PlayerIsDeadException;
import DonjonAndDragons.src.models.items.*;
public class Wizard extends Player{

    public Wizard(String name, Game game) {
        super(name, game);
        try{
        this.setCaracterClass("Wizard");
        this.setType("spellCaster");
        this.setSprite("🌈");
        this.setStats(new Stats(60,0,1,6, 0));
        this.setFullName();
        this.addItem(new Weapon(this.getCaracterClass()));
            this.equipItem(0);
        this.addItem(new Armor(this.getCaracterClass()));
            this.equipItem(0);
        this.considerEquipment();
        } catch (PlayerIsDeadException e) {
        } catch (NotEquipableException e) {
        } catch (EquipmentFullException e) {
        } catch (InventoryFullException e) {
        }
    }
    public void levelUp() {
        this.setLevel(this.getLevel()+1);
        this.getStats().setLifePoints(this.getStats().getLifePoints()+6);
        this.getStats().setDamage(this.getStats().getDamage()+6);
        this.getStats().setArmor(this.getStats().getArmor()+1);
        this.getStats().setExperience(this.getStats().getExperience()-10);
        if (this.getStats().getExperience() >=10) {
            this.levelUp();
        }
    }
}
