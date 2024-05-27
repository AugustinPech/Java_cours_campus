package DonjonAndDragons2.src.models.Caracters.Player;

import java.util.ArrayList;

import DonjonAndDragons2.src.models.Game.Exception.NotEquipableException;
import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Game.Exception.CaracterIsDeadException;
import DonjonAndDragons2.src.models.Game.Exception.EquipmentFullException;
import DonjonAndDragons2.src.models.Game.Exception.InventoryFullException;
import DonjonAndDragons2.src.models.Game.Exception.LifeTo0Exception;
import DonjonAndDragons2.src.models.Game.Exception.NotConsumableException;
import DonjonAndDragons2.src.models.Game.Exception.PlayerIsDeadException;
import DonjonAndDragons2.src.models.Game.utilities.Stats;
import DonjonAndDragons2.src.models.items.Item;
import DonjonAndDragons2.src.models.items.consumables.Consumable;
import DonjonAndDragons2.src.models.items.equipables.Equipable;

public abstract class Playable extends Caracter{
    private Stats levelUpStats;

    public Playable(String name) {
        super(name);
        //TODO Auto-generated constructor stub
    }

    public ArrayList<Item> pickUpItem(Item item) throws InventoryFullException{
        ArrayList<Item> inventory = this.getInventory();
        if(inventory.size() >= this.getStats().getStaminia()*2-1){
            throw new InventoryFullException("pick up");
        } else {
            inventory.add(item);
            this.setInventory(inventory);
            return inventory;
        }
    };
    
    public Item dropItem(Item item) throws PlayerIsDeadException{
        try{
            ArrayList<Item> inventory = this.getInventory();
            ArrayList<Equipable> equipment = this.getEquipment();
            if (equipment.contains(item)){
                equipment.remove(item);
                this.setEquipment(equipment);
            } else {
                inventory.remove(item);
                this.setInventory(inventory);
            }
            return item;
        } catch (CaracterIsDeadException e) {
            throw new PlayerIsDeadException();
        }
    };
    public Playable equipItem(Item item) throws EquipmentFullException, PlayerIsDeadException, NotEquipableException{
        try {
            if (item instanceof Equipable == false){
                throw new NotEquipableException();
            } else {
                ArrayList<Item> inventory = this.getInventory();
                ArrayList<Equipable> equipment = this.getEquipment();
                if (equipment.size() >= 2){
                    throw new EquipmentFullException();
                } else {
                    inventory.remove(item);
                    equipment.add((Equipable) item);
                    this.setInventory(inventory);
                    this.setEquipment(equipment);
                    return this;
                }
            }
        } catch (CaracterIsDeadException e) {
            throw new PlayerIsDeadException();
        }
    };
    public  ArrayList<Item> unEquipItem(Item item) throws InventoryFullException, PlayerIsDeadException{
        try{
            ArrayList<Item> inventory = this.getInventory();
            ArrayList<Equipable> equipment = this.getEquipment();
            if (inventory.size() >= this.getStats().getStaminia()*2-1){
                throw new InventoryFullException("unEquip");
            } else {
                inventory.add(item);
                equipment.remove(item);
                this.setInventory(inventory);
                this.setEquipment(equipment);
            }
            return inventory;
        } catch (CaracterIsDeadException e) {
            throw new PlayerIsDeadException();
        }
    };
    public ArrayList<Item> replaceEquipment(Item item1, Item item2) throws PlayerIsDeadException, NotEquipableException {
        try {
            this.unEquipItem(item1);
            this.equipItem(item2);
            return this.getInventory();
        } catch (InventoryFullException | EquipmentFullException e) {
            ArrayList<Equipable> equipment = this.getEquipment();
            ArrayList<Item> inventory = this.getInventory();
            int index = equipment.indexOf(item1);
            equipment.set(index, (Equipable) item2);
            index = inventory.indexOf(item2);
            inventory.set(index, item1);
            try{
                this.setEquipment(equipment);
            } catch (CaracterIsDeadException ex) {
            throw new PlayerIsDeadException();
            }
            this.setInventory(inventory);
            return this.getInventory();
        }
    }
    public Playable consumeItem(Item item) throws NotConsumableException{
        if (item instanceof Consumable) {
            Consumable consumable = (Consumable) item;
            consumable.consumedBy(this);
        } else {
            throw new NotConsumableException(item);
        }
        return this;
    };
    public void levelUp() {
        try {
            this.getStats().merge(this.levelUpStats);
            this.setLevel(this.getLevel()+1);
        } catch (LifeTo0Exception e){}
    };

    public Stats getLevelUpStats() {
        return levelUpStats;
    }

    public void setLevelUpStats(Stats levelUpStats) {
        this.levelUpStats = levelUpStats;
    }
    public void move(String direction) {
        switch (direction){
            case "forward":
                this.setPosition(this.getPosition()+1);
                break;
            case "backward":
                this.setPosition(this.getPosition()-1);
                break;
        }
    }
}
