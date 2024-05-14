package DonjonAndDragons.src.models.Game.Board;

import DonjonAndDragons.src.models.items.Armor;
import DonjonAndDragons.src.models.items.Item;
import DonjonAndDragons.src.models.items.Potion;
import DonjonAndDragons.src.models.items.Weapon;

public class TresoreRoom extends Room {
    public TresoreRoom (Board board, int level) {
        super();
        int roll = (int) Math.floor((Math.random()*50));
        for (int i = 0; i < level+1; i++) {
            if (roll%3==0) {
                this.addItem(new Weapon (roll, level));
            } else if (roll%3==1) {
                this.addItem( new Armor (roll, level));
            } else {
                this.addItem( new Potion (roll, level));
            }
        }
    }
}
