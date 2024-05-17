package DonjonAndDragons.src.models.Caracters.Player;
import DonjonAndDragons.src.models.Stats;
import DonjonAndDragons.src.models.Caracters.Caracter;
import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.models.Game.Board.Room;
import DonjonAndDragons.src.models.Game.Exception.EquipmentFullException;
import DonjonAndDragons.src.models.Game.Exception.InventoryFullException;
import DonjonAndDragons.src.models.Game.Exception.NotEquipableException;
import DonjonAndDragons.src.models.Game.Exception.NotUseAbleException;
import DonjonAndDragons.src.models.Game.Exception.PlayerIsDeadException;
import DonjonAndDragons.src.models.items.Item;
import DonjonAndDragons.src.models.items.equipables.Equipable;
import DonjonAndDragons.src.models.items.usables.Usable;
public abstract class Player extends Caracter{
    public Player(String name, Game game) {
        super(name);
    }
    public Player (int num){//god mode
        super(num);
    }
    public void addItem(Item item) throws InventoryFullException{
        try {
            int index = 0;
            Item [] inventory = this.getInventory();
            while (inventory[index] != null) {
                index++;
            }
            if (index < inventory.length) {
                inventory[index] = item;
                this.setInventory(inventory);
            }
        } catch (Exception e) {
            throw new InventoryFullException();
        }
    }

    public void equipItem(int indexOfInventoryItem) throws NotEquipableException, PlayerIsDeadException, EquipmentFullException {
        Equipable [] equipment = this.getEquipment();
        Item [] inventory = this.getInventory();
        if (!(inventory[indexOfInventoryItem] instanceof Equipable)) {
            throw new NotEquipableException();
        }
        int index = 0;
        while (equipment[index] != null) {
            index++;
            if (index >= equipment.length) {
                throw new EquipmentFullException();
            }
        }
        if (index <= equipment.length) {
        equipment[index] = (Equipable) inventory[indexOfInventoryItem];
        inventory[indexOfInventoryItem] = null;
        }
        this.setEquipment(equipment);
        this.setInventory(inventory);
        this.considerEquipment();
    }
    public void dropItem(int indexOfInventoryItem, Room room) throws PlayerIsDeadException {
        Item [] initialInventory = this.getInventory();
        if (initialInventory[indexOfInventoryItem] instanceof Equipable){
            Equipable item = (Equipable) initialInventory[indexOfInventoryItem];
            if (item.getIsEquiped()){
                item.setIsEquiped(false);
            }
        }
        room.addItem(initialInventory[indexOfInventoryItem]);
        initialInventory[indexOfInventoryItem] = null;
        Item [] inventory = initialInventory;
        this.setInventory(inventory);
        this.considerEquipment();
    }
    public void unEquip(Integer valueOf, Room room) throws PlayerIsDeadException, InventoryFullException {
        try {
            Equipable [] equipment = this.getEquipment();
            Item [] inventory = this.getInventory();
            Equipable item = equipment[valueOf];
            int index = 0;
            while (inventory[index] != null) {
                index++;
            }
            if (index < inventory.length) {
                equipment[valueOf].setIsEquiped(false);
                inventory[index] = equipment[valueOf];
                equipment[valueOf] = null;
            }
            this.setStats(this.getStats().detach(item.getStats())); 
            this.setEquipment(equipment);
            this.setInventory(inventory);
        } catch (Exception e) {
            throw new InventoryFullException();
        }
    }
    public Item[] useItem(int index) throws NotUseAbleException, PlayerIsDeadException{
            Item[] inventory = this.getInventory();
            Item[] output= new Item[0];
            Stats stats = this.getStats();
            Item item = (Item) inventory[index];
            if (!(item instanceof Usable)) {
                throw new NotUseAbleException();
            }
            Usable usable = (Usable) item;
            stats = (stats.merge(item.getStats()));
            output = usable.use(this);
            inventory[index] = null;
            this.setStats(stats);
            this.setInventory(inventory);
            this.considerEquipment();
            return output;
    }
    abstract public void levelUp();
}
