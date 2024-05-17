package DonjonAndDragons.src.models.items.usables;

import DonjonAndDragons.src.models.Caracters.Player.Player;
import DonjonAndDragons.src.models.Game.Exception.PlayerIsDeadException;
import DonjonAndDragons.src.models.items.Item;

public abstract class Usable extends Item{
    public Usable(String name, String type) {
        super(name, type);
    }
    public Usable(String name, String type, int weight, int value, String status) {
        super(name, type, weight, value, status);
    }
    public abstract Item[] use(Player player)  throws PlayerIsDeadException;

}
