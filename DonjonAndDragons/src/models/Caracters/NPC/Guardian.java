package DonjonAndDragons.src.models.Caracters.NPC;

import DonjonAndDragons.src.models.Game.Game;

public class Guardian extends NPC{
    public Guardian(Game game) {
        super("Guardian", game, false);
        this.sprite = "🧙";
    }
}
