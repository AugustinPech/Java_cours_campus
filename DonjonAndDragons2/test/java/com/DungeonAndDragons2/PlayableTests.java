package DonjonAndDragons2.test.java.com.DungeonAndDragons2;

import DonjonAndDragons2.src.models.Game.Menu;
import DonjonAndDragons2.src.models.Game.Exception.EquipmentFullException;
import DonjonAndDragons2.src.models.Game.Exception.InventoryFullException;
import DonjonAndDragons2.src.models.Game.Exception.NotEquipableException;
import DonjonAndDragons2.src.models.Game.utilities.status.Status;

import org.junit.jupiter.api.Test;

import DonjonAndDragons2.src.models.items.Item;
import DonjonAndDragons2.src.models.items.equipables.Equipable;
import DonjonAndDragons2.src.models.items.equipables.Weapon.abstractClasses.MagicWeapons;
import DonjonAndDragons2.src.models.items.equipables.Weapon.abstractClasses.PhysicalWeapon;
import DonjonAndDragons2.src.models.items.equipables.Weapon.magical.FireStaff;
import DonjonAndDragons2.src.models.items.equipables.Weapon.physical.Axe;
import DonjonAndDragons2.src.models.Game.utilities.Stats;
import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Caracters.NPC.Gobelin;
import DonjonAndDragons2.src.models.Caracters.Player.Warrior;
import DonjonAndDragons2.src.models.Caracters.Player.Wizard;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

class PlayableTests {
    @Test
    void testPickUp(){
        Item item = new Item("test", 1);
        Warrior warrior = new Warrior("Warrior");
        try {
            warrior.pickUpItem(item);
            ArrayList<Item> inventory = warrior.getInventory();
            assertEquals(inventory.size(), 1);
            warrior.pickUpItem(item);
            inventory = warrior.getInventory();
            assertEquals(inventory.size(), 2);
        } catch (InventoryFullException e){        }
    }
    @Test
    void testDropItem(){
        Item item = new Item("test", 1);
        Warrior warrior = new Warrior("Warrior");
        try {
            warrior.pickUpItem(item);
            ArrayList<Item> inventory = warrior.getInventory();
            assertEquals(inventory.size(), 1);
            warrior.dropItem(item);
            inventory = warrior.getInventory();
            assertEquals(inventory.size(), 0);
        } catch (InventoryFullException e){
        }
    }
    @Test
    void testEquipItem() {
        Item item = new Item("test", 1);
        Warrior warrior = new Warrior("Warrior");
        try {
            warrior.pickUpItem(item);
            ArrayList<Item> inventory = warrior.getInventory();
            assertEquals(inventory.size(), 1);

            warrior.equipItem(item);
            ArrayList<Equipable> equipment = warrior.getEquipment();
            assertEquals(equipment.size(), 1);
        } catch (InventoryFullException e){
        } catch (EquipmentFullException e){
        } catch (NotEquipableException e){
        }
    }
    @Test
    void testUseItem() {
        Item item = new FireStaff("test", 1);
        Wizard wizard = new Wizard ("Wizard");
        
        try {
            wizard.pickUpItem(item);
            ArrayList<Item> inventory = wizard.getInventory();
            assertEquals(inventory.size(), 1);
            wizard.equipItem(item);
            ArrayList<Equipable> equipment = wizard.getEquipment();
            assertEquals(equipment.size(), 1);
            ArrayList<Caracter> caracters = new ArrayList<Caracter>();
            caracters.add(new Gobelin(1));
            caracters.add(wizard);
            MagicWeapons staff  = (MagicWeapons) wizard.getEquipment().get(0);
            staff.use(caracters);
            assertTrue(caracters.get(0).getStatuses().size()==1);
        }catch (InventoryFullException e){
        } catch (EquipmentFullException e){
        } catch (NotEquipableException e){
        }
    }
    @Test
    void testLevelUp() {
        //TODO
    }
    @Test
    void testUnEquipItem() {
        Axe item = new Axe("test", 1);
        Warrior warrior = new Warrior("Warrior");
        try {
            warrior.pickUpItem(item);
            ArrayList<Item> inventory = warrior.getInventory();
            assertEquals(inventory.size(), 1);
            warrior.equipItem(item);
            ArrayList<Equipable> equipment = warrior.getEquipment();
            assertEquals(equipment.size(), 1);
            warrior.unEquipItem((Equipable) item);
            inventory = warrior.getInventory();
            assertEquals(inventory.size(), 1);
            equipment = warrior.getEquipment();
            assertEquals(equipment.size(), 0);
        } catch (InventoryFullException e){
        } catch (EquipmentFullException e){
        } catch (NotEquipableException e){
        }
    }
    @Test
    void testReplaceEquipment() {
        Axe item1 = new Axe("test", 1);
        Axe item2 = new Axe("test", 1);

        Warrior warrior = new Warrior("Warrior");
        try {
            warrior.pickUpItem(item1);
            ArrayList<Item> inventory = warrior.getInventory();
            assertEquals(inventory.size(), 1);
            warrior.pickUpItem(item2);
            inventory = warrior.getInventory();
            assertEquals(inventory.size(), 2);
            warrior.equipItem(item1);
            ArrayList<Equipable> equipment = warrior.getEquipment();
            assertEquals(equipment.size(), 1);
            warrior.replaceEquipment(item1, item2);
            inventory = warrior.getInventory();
            assertEquals(inventory.size(), 1);
            assertEquals(equipment.size(), 1);
            assertTrue(inventory.contains(item1));
            assertTrue(equipment.contains(item2));
        } catch (InventoryFullException | EquipmentFullException | NotEquipableException e){}
    }
    @Test
    void testConsumeItem() {
        //TODO
    }

}
