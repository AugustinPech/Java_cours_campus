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
        System.out.println(this.fullName + " received " + item.name + " to his inventory");
    }
    public void equipItem(int indexOfInventoryItem){
        int index = 0;
        while (this.equipment[index] != null) {
            index++;
        }
        if (index >= this.equipment.length) {
            System.out.println(this.fullName + " can't equip more items");
            return;
        }
        this.equipment[index] = this.inventory[indexOfInventoryItem];
        this.inventory[index] = null;
        System.out.println(this.fullName + " equipped " + this.equipment[index].name);
    }
}
