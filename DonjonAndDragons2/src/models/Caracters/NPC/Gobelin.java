package DonjonAndDragons2.src.models.Caracters.NPC;

import java.util.ArrayList;

import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Caracters.interfaces.Fighter;
import DonjonAndDragons2.src.models.Game.Exception.LifeTo0Exception;
import DonjonAndDragons2.src.models.Game.utilities.Stats;
import DonjonAndDragons2.src.models.Game.utilities.damages.Damage;
import DonjonAndDragons2.src.models.items.Item;


    /**
     * Represents a Gobelin character in the game.
     * Inherits from the Character class.
     */
public class Gobelin extends Caracter implements Fighter, NPC{

        
    /**
     * Constructs a new Gobelin object with the specified level.
     * 
     * @param level the level of the Gobelin character
     */
    public Gobelin(int level) {
        super(level);
        this.setName("Gobelin");
        this.setCaracterClass("Gobelin");
        this.setSprite("👺");
        Stats stats =  new Stats(
            10*level, 
            level, 
            level, 
            1,
            0,
            2*level,
            level*10
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
    public Damage attack(Caracter target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attack'");
    }

    @Override
    public Caracter defend(Damage damage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'defend'");
    }
    
}
