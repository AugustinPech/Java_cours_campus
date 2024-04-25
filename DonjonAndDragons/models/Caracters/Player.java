package DonjonAndDragons.models.Caracters;
import DonjonAndDragons.models.items.Item;
public class Player extends Caracter{
    public Player(String name) {
        super(name);
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
        this.equipment[index] = this.inventory[indexOfInventoryItem];
        this.inventory[index] = null;
        System.out.println(this.fullName + " equipped " + this.equipment[index].name);
    }
}
