package DonjonAndDragons.src.models.Caracters.Player;
import DonjonAndDragons.src.models.Stats;
import DonjonAndDragons.src.models.Caracters.Caracter;
import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.models.Game.Board.Room;
import DonjonAndDragons.src.models.items.Item;
import DonjonAndDragons.src.models.items.Usable;
public abstract class Player extends Caracter{
    public Player(String name, Game game) {
        super(name);
    }
    public Player (int num){//god mode
        super(num);
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
    public void dropItem(int indexOfInventoryItem, Room room){
        Item [] initialInventory = this.getInventory();
        room.addItem(initialInventory[indexOfInventoryItem]);
        initialInventory[indexOfInventoryItem] = null;
        Item [] inventory = new Item[this.getInventory().length];
        for (int i = 0; i < inventory.length; i++) {
            int index = 0;
            if (initialInventory[i] != null){
                inventory[index] = initialInventory[i];
            }else {
                index++;
            }
        }
        this.setInventory(inventory);
        this.considerEquipment();
    }
    public void unEquip(Integer valueOf, Room room) {

        Item [] equipment = this.getEquipment();
        Item [] inventory = this.getInventory();
        
        int index = 0;
        while (inventory[index] != null) {
            index++;
        }
        if (index < inventory.length) {
            inventory[index] = equipment[valueOf];
            equipment[valueOf] = null;
        }
        this.setEquipment(equipment);
        this.setInventory(inventory);
        this.considerEquipment();
    }
    public Item[] useItem(int index, String EqOrIn) {
        Item[] inventory = this.getInventory();
        Item[] equipment = this.getEquipment();
        
        Item[] output= new Item[0];
        Stats stats = this.getStats();
        if (EqOrIn.equals("inventory")) {
            Usable item = (Usable) inventory[index];
            if (item != null) {
                output= item.use(this);
                inventory[index] = null;
            }
        } else if (EqOrIn.equals("equipment")) {
            Usable item = (Usable) equipment[index];
            if (item != null) {
                output= item.use(this);
                equipment[index] = null;
            }
        }

        this.setStats(stats);
        this.setInventory(inventory);
        this.setEquipment(equipment);
        this.considerEquipment();

        return output;
    }
}
