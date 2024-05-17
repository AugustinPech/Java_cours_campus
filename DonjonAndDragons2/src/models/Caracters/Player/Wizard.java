package DonjonAndDragons2.src.models.Caracters.Player;

import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Caracters.interfaces.SpellCaster;
import DonjonAndDragons2.src.models.Game.Exception.CaracterIsDeadException;
import DonjonAndDragons2.src.models.Game.Exception.LifeTo0Exception;
import DonjonAndDragons2.src.models.Game.utilities.Stats;
import DonjonAndDragons2.src.models.Game.utilities.damages.Damage;
import DonjonAndDragons2.src.models.Game.utilities.damages.Fire;

public class Wizard extends Playable implements SpellCaster, Player {

    public Wizard(String name) {
            super(name);
        try{
            this.setCaracterClass("Wizard");
            Stats stats = new Stats(-20, 0, -3, +3, +2, -2, 0);
            this.setLevelUpStats(new Stats(10,1,1,2,2,1,0)); 
            this.setStats(this.getStats().merge(stats));
        } catch (LifeTo0Exception e){}
    }

    @Override
    public Damage attack(Caracter Target) {
        //todo : choice of the weapon
        Damage damage = new Fire(this.getStats(), this.getLevel());

        return damage;
    }

    @Override
    public Caracter defend(Damage damage) {
        // TODO
        return null;
    }
   
}
