package DonjonAndDragons.src.models.items;

import DonjonAndDragons.src.models.Stats;
import DonjonAndDragons.src.models.Caracters.Player.Player;
import DonjonAndDragons.src.models.Game.Exception.PlayerIsDeadException;

public class Insides extends Usable{
    public Insides(String name, String type) {
        super(name, type);
        this.stats = new Stats(2,0,0,0,1);
    }
    public Insides(String name, String type, int weight, int value, String status) {
        super(name, type, weight, value, status);
        this.stats = new Stats(2,0,0,0,1);
    }
    public Item[] use(Player player)  throws PlayerIsDeadException{
        player.setStats(this.stats.merge(player.getStats()));
        return null;
    }
}
