package DonjonAndDragons.src.models.Caracters.Player;
import java.util.Map;

import DonjonAndDragons.src.models.Stats;
import DonjonAndDragons.src.models.Caracters.Caracter;
import DonjonAndDragons.src.models.Caracters.interfaces.SpellCaster;
import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.models.Game.Board.Board;
import DonjonAndDragons.src.models.Game.Exception.EquipmentFullException;
import DonjonAndDragons.src.models.Game.Exception.InventoryFullException;
import DonjonAndDragons.src.models.Game.Exception.NotEquipableException;
import DonjonAndDragons.src.models.items.*;
import DonjonAndDragons.src.models.items.equipables.Armor;
import DonjonAndDragons.src.models.items.equipables.Weapon;
public class Wizard extends Player implements SpellCaster{

    public Wizard(String name, Game game) {
        super(name, game);
        try{
            this.setCaracterClass("Wizard");
            this.setSprite("🌈");
            this.setFullName();

            this.setStats(new Stats(60,0,1,2,6, 0));
            this.addItem(new Weapon(this.getCaracterClass()));
            this.equipItem(0);
            this.addItem(new Armor(this.getCaracterClass()));
            this.equipItem(0);
            this.considerEquipment();
        } catch (NotEquipableException e) {
        } catch (EquipmentFullException e) {
        } catch (InventoryFullException e) {
        }
    }
    public void levelUp() {
        this.setLevel(this.getLevel()+1);
        this.getStats().setLifePoints(this.getStats().getLifePoints()+6);
        this.getStats().setDamage(this.getStats().getDamage()+1);
        this.getStats().setArmor(this.getStats().getArmor()+1);
        this.getStats().setMagic(this.getStats().getMagic()+4);
        this.getStats().setExperience(this.getStats().getExperience()-10);
        if (this.getStats().getExperience() >=10) {
            this.levelUp();
        }
    }
    @Override
    public int castSpell(Caracter target) {
        int damage = this.getStats().getMagic();
        return damage;

    }
    @Override
    public Map attack (Caracter target, Board board) {
        int damage = this.castSpell(target);
        Map fightOuput = target.takeDamage(damage,true);
        fightOuput.put ( "attacking caracter", this.getFullName());
        board.nPCAreOstile();
        return fightOuput;
    }
    @Override
    public void castHealingSpell() {
    }
}
