package DonjonAndDragons2.src.models.Caracters.NPC;

import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Caracters.interfaces.Monster;
import DonjonAndDragons2.src.models.Game.Exception.LifeTo0Exception;
import DonjonAndDragons2.src.models.Game.utilities.Stats;
import DonjonAndDragons2.src.models.Game.utilities.damages.Damage;

public class Dragon extends Caracter implements Monster{

    public Dragon(int level) {
        super(level);
        this.setName("dragon");
        this.setCaracterClass("dragon");
        this.setSprite("🐉");
        Stats stats =  new Stats(100*level,10*level,10*level,10*level,10*level,level,level*100);
        try{
            this.setStats(this.getStats().merge(stats));
        } catch (LifeTo0Exception e) {}
    }

    @Override
    public Damage attack(Caracter target, int roll) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attack'");
    }

    @Override
    public Caracter defend(Damage damage, int roll) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'defend'");
    }
}
