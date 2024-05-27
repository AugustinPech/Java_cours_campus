package DonjonAndDragons2.src.models.items.equipables.Weapon.magical;

import java.util.ArrayList;

import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Caracters.Player.Playable;
import DonjonAndDragons2.src.models.Game.utilities.Stats;
import DonjonAndDragons2.src.models.Game.utilities.damages.Damage;
import DonjonAndDragons2.src.models.Game.utilities.damages.Fire;
import DonjonAndDragons2.src.models.Game.utilities.status.Status;
import DonjonAndDragons2.src.models.items.equipables.Weapon.abstractClasses.MagicWeapons;

public class FireStaff extends MagicWeapons{

    public FireStaff(String name, int level) {
        super(name, level);
        this.setSprite("🔥");
        //TODO Auto-generated constructor stub
    }

    @Override
    public ArrayList<Caracter> use(ArrayList<Caracter> caracters, int roll) {
        Fire fire = null;
        Stats itemStats = this.getStats();
        Stats burn = new Stats (
            (int) - itemStats.getIntel()/2,
            0,
            0,
            0,
            (int) - itemStats.getIntel()/2,
            0,
            0
        );
        Status burning = new Status(burn, 3, "burning");
        for (Caracter caracter : caracters) {
            if (caracter instanceof Playable) {
                fire = new Fire(itemStats,  this.getLevel());
            }
            caracter.defend(fire, roll);
            caracter.addStatus(burning);
        }
        return caracters;
    }

    @Override
    public Damage hitWith(Caracter caracter) {
        Stats caracterStats = caracter.getStats();
        Fire fire = new Fire(caracterStats,  this.getLevel());
       return fire;
    }
}
