package DonjonAndDragons2.src.models.Caracters.NPC;

import java.util.ArrayList;

import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Caracters.interfaces.Fighter;
import DonjonAndDragons2.src.models.Game.Board.Board;
import DonjonAndDragons2.src.models.Game.Exception.PlayerIsDeadException;
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
        this.setStats( new Stats(
            10*level, 
            level + 5, 
            level+1, 
            1,
            0,
            2*level,
            level*10
        ));
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
    public void defend(Damage damage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'defend'");
    }
    
}
