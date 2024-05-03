package DonjonAndDragons.src.models.Caracters.Player;
import DonjonAndDragons.src.models.Stats;
import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.models.items.*;
public class Wizard extends Player{

    public Wizard(String name, Game game) {
        super(name, game);
        this.setCaracterClass("Wizard");
        this.setType("spellCaster");
        this.setSprite("🌈");
        this.setBaseStats(new Stats(60,0,1,6, 0));
        this.setFullName();
        this.addItem(new Weapon(this.getCaracterClass()));
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
    }
}
