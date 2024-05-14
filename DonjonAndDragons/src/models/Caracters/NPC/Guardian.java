package DonjonAndDragons.src.models.Caracters.NPC;

import DonjonAndDragons.src.models.Stats;
import DonjonAndDragons.src.models.Game.Board.Board;
import DonjonAndDragons.src.models.Game.Exception.PlayerIsDeadException;
import DonjonAndDragons.src.models.items.Armor;
import DonjonAndDragons.src.models.items.Weapon;

public class Guardian extends NPC{
    public Guardian(Board board) {
        super(
            "Guardian", 
            board.getIsOstile(), 
            board.getSize()-1
        );
        this.setSprite("🧙");
        this.setLevel((int) (Math.random()*10+10));
                        try {
            this.setStats(new Stats (10*this.getLevel(), (int) this.getLevel()/2, 1, this.getLevel(), 0));
        } catch (PlayerIsDeadException e){}
        this.equipment[0] = new Weapon("Guardian");
        this.equipment[1] = new Armor("Guardian");
        this.setInventory(this.randomLoot());
        try {
            this.considerEquipment();
        } catch (PlayerIsDeadException e) {}
    }
        public Guardian(Board board, int level) {
        super(
            "Guardian", 
            board.getIsOstile(), 
            board.getSize()-1
        );
        this.setSprite("🧙");
        this.setLevel(level);
                        try {
            this.setStats(new Stats (10*this.getLevel(), (int) this.getLevel()/2, 1, this.getLevel(), 0));
        } catch (PlayerIsDeadException e){}
        this.equipment[0] = new Weapon("Guardian");
        this.equipment[1] = new Armor("Guardian");
        this.setInventory(this.randomLoot());
        try {
            this.considerEquipment();
        } catch (PlayerIsDeadException e) {}
    }
}
