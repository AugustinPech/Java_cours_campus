package DonjonAndDragons.src.models.items;

import DonjonAndDragons.src.models.Stats;
import DonjonAndDragons.src.models.Caracters.Player.Player;

public class Insides extends Usable{
    public Insides(String name, String type) {
        super(name, type);
        this.stats = new Stats(2,0,0,0,0);
    }
    public Insides(String name, String type, int weight, int value, String status) {
        super(name, type, weight, value, status);
    }
    public Item[] use(Player player){
        Stats stats = player.getStats();
        stats.setLifePoints(stats.getLifePoints()+1);
        player.setStats(stats);
        return null;
    }
}
