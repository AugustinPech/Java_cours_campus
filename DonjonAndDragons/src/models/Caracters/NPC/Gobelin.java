package DonjonAndDragons.src.models.Caracters.NPC;
import DonjonAndDragons.src.models.Stats;
import DonjonAndDragons.src.models.Game.Board.Board;
import DonjonAndDragons.src.models.Game.Exception.PlayerIsDeadException;
import DonjonAndDragons.src.models.items.Weapon;
public class Gobelin extends NPC {
    
    
    public Gobelin(String name, Board board, int position) {
        super(
            name, 
            board.getIsOstile(),
            position
        );
        this.setSprite("🟢");
        this.setLevel((int) (Math.random()*5+1));
        try {
            this.setStats(new Stats (3*this.getLevel(), (int) this.getLevel()/2, 1, this.getLevel(), 0));
        } catch (PlayerIsDeadException e){}
        this.equipment[0] = new Weapon("Gobelin");
        this.equipment[1] = new Weapon("Gobelin");
        this.setInventory(this.randomLoot());
        try {
            this.considerEquipment();
        } catch (PlayerIsDeadException e) {}
    }
        public Gobelin(String name, Board board, int position, int level) {
        super(
            name, 
            board.getIsOstile(),
            position
        );
        this.setSprite("🟢");
        this.setLevel(level);
        try {
            this.setStats(new Stats (2*this.getLevel(), (int) this.getLevel()/2, 1, this.getLevel(), 0));
        } catch (PlayerIsDeadException e){}
        this.equipment[0] = new Weapon("Gobelin");
        this.equipment[1] = new Weapon("Gobelin");
        this.setInventory(this.randomLoot());
        try {
            this.considerEquipment();
        } catch (PlayerIsDeadException e) {}
    }
}
