package DonjonAndDragons.src.models.items;

import DonjonAndDragons.src.models.Caracters.Player.Player;
import DonjonAndDragons.src.models.Game.Exception.PlayerIsDeadException;

public abstract class Usable extends Item{
    public Usable(String name, String type) {
        super(name, type);
    }
    public Usable(String name, String type, int weight, int value, String status) {
        super(name, type, weight, value, status);
    }
    public abstract Item[] use(Player player)  throws PlayerIsDeadException;

}
