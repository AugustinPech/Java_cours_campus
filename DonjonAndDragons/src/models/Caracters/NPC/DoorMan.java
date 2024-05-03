package DonjonAndDragons.src.models.Caracters.NPC;

import DonjonAndDragons.src.models.Stats;
import DonjonAndDragons.src.models.Game.Board.Board;
import DonjonAndDragons.src.models.items.Item;

public class DoorMan extends NPC {
    public DoorMan(Board board) {
        super(
            "DoorMan", 
            board.getIsOstile(), 
            1
        );
        this.stats = new Stats(20,0,1,5, 0);
        Item [] inventory = {
            new Item("Key", "Key"),
            new Item("Key", "Key"),
            new Item("Key", "Key"),
            new Item("Key", "Key"),
        };
        this.equipment=inventory;
        this.setSprite( "👮");
    }
}
