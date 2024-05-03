package DonjonAndDragons.src.models.Caracters.Player;
import DonjonAndDragons.src.models.Stats;
import DonjonAndDragons.src.models.Game.Game;
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
        this.setBaseStats(new Stats(60,0,1,6, 0));
        this.setFullName();
        this.addItem(new Weapon(this.getCaracterClass()));
            this.equipItem(0);
        this.addItem(new Armor(this.getCaracterClass()));
            this.equipItem(0);
        this.considerEquipment();
        } catch (PlayerIsDeadException e) {
        } catch (NotEquipableException e) {
        }
    }
}
