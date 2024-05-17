package DonjonAndDragons2.src.models.Caracters.NPC;

import java.util.ArrayList;

import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Caracters.interfaces.Monster;
import DonjonAndDragons2.src.models.Game.Game;
import DonjonAndDragons2.src.models.Game.Board.Board;
import DonjonAndDragons2.src.models.Game.Exception.PlayerIsDeadException;
import DonjonAndDragons2.src.models.Game.utilities.Stats;
import DonjonAndDragons2.src.models.Game.utilities.damages.Damage;
import DonjonAndDragons2.src.models.items.Item;

public class Dragon extends Caracter implements Monster{

    public Dragon(int level) {
        super(level);
        this.setName("dragon");
        this.setCaracterClass("dragon");
        this.setSprite("🐉");
        this.setStats( new Stats(
            100*level, 
            10*level, 
            10*level, 
            10*level,
            10*level,
            level,
            level*100
        ));
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
