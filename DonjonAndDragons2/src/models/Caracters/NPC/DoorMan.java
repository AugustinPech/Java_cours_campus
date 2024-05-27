package DonjonAndDragons2.src.models.Caracters.NPC;

import java.util.ArrayList;

import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Game.utilities.Stats;
import DonjonAndDragons2.src.models.Game.utilities.damages.Damage;
import DonjonAndDragons2.src.models.items.Item;

public class DoorMan extends Caracter implements NPC {

    public DoorMan() {
        super(1);
        this.setName("doorMan");
        this.setCaracterClass("doorMan");
        this.setSprite("🚪");
        this.setStats(new Stats(
            10, 
            1, 
            5, 
            1,
            5,
            5,
            5
        ));
    }

    @Override
    public ArrayList<Item> randomLoot() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'randomLoot'");
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
