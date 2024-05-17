package DonjonAndDragons.src.models.Game.Board;

import DonjonAndDragons.src.models.items.usables.Potion;

public class PotionRoom extends Room {
    public PotionRoom(Board board, int level) {
        super();
        int roll = (int) Math.floor((Math.random()*50));
        this.addItem(new Potion(roll, level));
    }
}
