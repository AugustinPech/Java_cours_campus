package DonjonAndDragons2.src.models.Caracters.NPC;

import java.util.ArrayList;

import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Caracters.interfaces.Fighter;
import DonjonAndDragons2.src.models.Game.Board.Board;
import DonjonAndDragons2.src.models.Game.Exception.LifeTo0Exception;
import DonjonAndDragons2.src.models.Game.Exception.PlayerIsDeadException;
import DonjonAndDragons2.src.models.Game.utilities.Stats;
import DonjonAndDragons2.src.models.Game.utilities.damages.Damage;
import DonjonAndDragons2.src.models.items.Item;


public class Orc extends Caracter implements Fighter, NPC{

    public Orc(int level) {
        super(level);
        this.setName("Orc");
        this.setCaracterClass("Orc");
        this.setSprite("⚫");
        Stats stats =  new Stats(
            20*level, 
            2*level, 
            2*level, 
            1,
            5,
            1,
            level*20
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
    public Caracter defend(Damage damage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'defend'");
    }

    @Override
    public Damage attack(Caracter target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attack'");
    }
    
}
