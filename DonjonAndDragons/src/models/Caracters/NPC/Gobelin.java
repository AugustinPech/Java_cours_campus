package DonjonAndDragons.src.models.Caracters.NPC;
import DonjonAndDragons.src.models.Game.Game;
public class Gobelin extends NPC {
    public Gobelin(Game game) {
        Boolean isOstile = game.board.dungeon[game.board.size-1].npcs[0].isOstile;
        super("Gobelin", game, isOstile);
        this.sprite = "🟢";
    }
}
