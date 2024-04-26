package DonjonAndDragons.src.models.Caracters;

import DonjonAndDragons.src.models.Game.Game;

public class NPC extends Caracter {
    public NPC(String name, Game game) {
        super(name);
        game.addNPC(this);
    }
}
