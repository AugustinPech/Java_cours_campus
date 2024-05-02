package DonjonAndDragons.src.models.Caracters.Player;
import DonjonAndDragons.src.models.Caracters.Caracter;
import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.models.items.Item;
public abstract class Player extends Caracter{
    public Player(String name, Game game) {
        super(name);
    }
    public void addItem(Item item) {
        int index = 0;
        Item [] inventory = this.getInventory();
        while (inventory[index] != null) {
            index++;
        }
        if (index < inventory.length) {
            inventory[index] = item;
            this.setInventory(inventory);
        }
    }
    public void equipItem(int indexOfInventoryItem){
        int index = 0;
        Item [] equipment = this.getEquipment();
        Item [] inventory = this.getInventory();
        while (equipment[index] != null) {
            index++;
        }
        if (index <= equipment.length) {
        equipment[index] = inventory[indexOfInventoryItem];
        inventory [indexOfInventoryItem] = null;
        }
        this.setEquipment(equipment);
        this.setInventory(inventory);
        
        this.considerEquipment();
    }
}
