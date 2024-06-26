package DonjonAndDragons.src.models.Caracters.NPC;

import DonjonAndDragons.src.models.Stats;
import DonjonAndDragons.src.models.Caracters.interfaces.Fighter;
import DonjonAndDragons.src.models.Game.Board.Board;
import DonjonAndDragons.src.models.Game.Exception.PlayerIsDeadException;
import DonjonAndDragons.src.models.items.equipables.Armor;
import DonjonAndDragons.src.models.items.equipables.Weapon;

public class Orc extends NPC implements Fighter{
    public Orc(String name, Board board, int position) {
        super(
            name, 
            board.getIsOstile(),
            position
        );
        this.setSprite("🟠");
        this.setLevel((int) (Math.random()*10+3));
        try {
            this.setStats(new Stats (5*this.getLevel(), this.getLevel(), 1, this.getLevel() + 2,1, 0));
        } catch (PlayerIsDeadException e){}
        this.equipment[0] = new Weapon("Orc");
        this.equipment[1] = new Armor("Orc");
        this.setInventory(this.randomLoot());
        try {
            this.considerEquipment();
        } catch (PlayerIsDeadException e) {}
    }
        public Orc(String name, Board board, int position, int level) {
        super(
            name, 
            board.getIsOstile(),
            position
        );
        this.setSprite("🟠");
        this.setLevel(level);
                try {
            this.setStats(new Stats (5*this.getLevel(), this.getLevel(), 1, this.getLevel() + 2,1, 0));
        } catch (PlayerIsDeadException e){}
        this.equipment[0] = new Weapon("Orc");
        this.equipment[1] = new Armor("Orc");
        this.setInventory(this.randomLoot());
        try {
            this.considerEquipment();
        } catch (PlayerIsDeadException e) {}
    }
}
