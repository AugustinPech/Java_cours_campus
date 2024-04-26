package DonjonAndDragons.src.models.Caracters;
import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.models.items.Item;
public class Player extends Caracter{
    public Player(String name, Game game) {
        super(name);
        game.addPlayer(this);
    }
    public void addItem(Item item) {
        int index = 0;
        while (this.inventory[index] != null) {
            index++;
        }
        this.inventory[index] = item;
    }
    public void equipItem(int indexOfInventoryItem){
        int index = 0;
        while (this.equipment[index] != null) {
            index++;
        }
        if (index >= this.equipment.length) {
            return;
        }
        this.equipment[index] = this.inventory[indexOfInventoryItem];
        this.inventory[index] = null;
    }
}
