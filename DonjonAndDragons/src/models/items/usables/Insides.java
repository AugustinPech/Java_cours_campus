package DonjonAndDragons.src.models.items.usables;

import DonjonAndDragons.src.models.Stats;
import DonjonAndDragons.src.models.Caracters.Player.Player;
import DonjonAndDragons.src.models.Game.Exception.PlayerIsDeadException;
import DonjonAndDragons.src.models.items.Item;

public class Insides extends Usable{
    public Insides(String name, String type) {
        super(name, type);
        this.mipple="🧠";
        this.stats = new Stats(2,0,0,0,0,1);
    }
    public Insides(String name, String type, int weight, int value, String status) {
        super(name, type, weight, value, status);
        this.mipple="🧠";
        this.stats = new Stats(2,0,0,0,0,1);
    }
    public Insides (Corps corps, String type){
        super(corps.getName()+"'s "+type, type);
        this.mipple="🧠";
        this.stats = new Stats(2,0,0,0,0,corps.getLevel()+1);
        for (int i = 0; i <= corps.getLevel(); i++) {
            int pick = (int) (Math.random()*4);
            switch (pick) {
                case 0 -> this.stats.setArmor(this.stats.getArmor()+1);
                case 1 -> this.stats.setLifePoints(this.stats.getLifePoints()+1);
                case 2 -> this.stats.setDamage(this.stats.getDamage()+1);
                case 3 -> this.stats.setMagic(this.stats.getMagic()+1);
            }
        }
    }
    public Item[] use(Player player)  throws PlayerIsDeadException{
        player.setStats(this.stats.merge(player.getStats()));
        return null;
    }
}
