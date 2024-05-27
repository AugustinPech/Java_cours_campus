package DonjonAndDragons2.src.models.Caracters.NPC;

import java.util.ArrayList;

import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Caracters.interfaces.SpellCaster;
import DonjonAndDragons2.src.models.Game.Exception.LifeTo0Exception;
import DonjonAndDragons2.src.models.Game.utilities.Stats;
import DonjonAndDragons2.src.models.Game.utilities.damages.Damage;
import DonjonAndDragons2.src.models.items.Item;

public class Guardian extends Caracter implements SpellCaster, NPC{

    public Guardian(int level) {
        super(level);
        this.setName("Guardian");
        this.setCaracterClass("Guardian");
        this.setSprite("🧙");
        Stats stats =  new Stats(
            50*level, 
            5*level, 
            5*level, 
            10*level,
            10*level,
            2*level,
            level*50
        );
        try{
            this.setStats(this.getStats().merge(stats));
        } catch (LifeTo0Exception e) {}
    }

    @Override
    public ArrayList<Item> randomLoot() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'randomLoot'");
    }

    @Override
    public Caracter defend(Damage damage, int roll) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'defend'");
    }

    @Override
    public Damage attack(Caracter target, int roll) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attack'");
    }
    
}
