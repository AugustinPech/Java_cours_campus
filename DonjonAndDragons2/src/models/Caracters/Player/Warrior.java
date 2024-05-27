package DonjonAndDragons2.src.models.Caracters.Player;


import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Caracters.interfaces.Fighter;
import DonjonAndDragons2.src.models.Game.Exception.LifeTo0Exception;
import DonjonAndDragons2.src.models.Game.utilities.Stats;
import DonjonAndDragons2.src.models.Game.utilities.damages.Damage;
import DonjonAndDragons2.src.models.Game.utilities.damages.Normal;

public class Warrior extends Playable implements Fighter {

    public Warrior(String name) {
        super(name);
        try {
            this.setCaracterClass("Warrior");
            Stats stats = new Stats(20, 2, 3, -3, -2, 2, 0);
            this.setLevelUpStats(new Stats(20,2,2,1,1,1,0)); 
            this.setStats(this.getStats().merge(stats));
        } catch (LifeTo0Exception e){}

    }

    @Override
    public Damage attack(Caracter target, int roll) {
        //todo : choice of the weapon
        Damage damage = new Normal(this.getStats(), this.getLevel());
        return damage;
    }

    @Override
    public Caracter defend(Damage damage, int roll) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'defend'");
    }
   
}
