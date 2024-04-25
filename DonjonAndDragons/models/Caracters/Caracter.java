package DonjonAndDragons.models.Caracters;

import DonjonAndDragons.models.items.Item;
import DonjonAndDragons.models.Caracters.Warrior;
import DonjonAndDragons.models.Caracters.Wizard;
public class Caracter {
    public String name;
    public String suffix;
    public String fullName;
    public String type;
    public String caracterClass;
    public int lifePoints;
    // public int level;
    // public int education;
    // public int agility;
    // public int withdom;
    // public int strength;
    // protected int experience;
    // public int stamina;
    public Item[] inventory;
    public Item[] equipment;
    // public int gold;
    // public String[] status;
    //public Status[] status;
    public int armor;
    // public int speed;
    public int actions;
    public int actionsLeft;
    protected int basicDamage;
    public int damage;
    // public int[] position;
    public Caracter(String name) {
        this.name = name;
        // this.level = 1;
        // this.experience = 0;
        this.lifePoints = 100;
        // this.education = 5;
        // this.agility = 5;
        // this.withdom = 5;
        // this.strength = 5;
        // this.stamina = 5;
        // this.gold = 0;
        // this.status = new String[0];
        this.armor = 0;
        // this.speed = 5;
        this.actions = 1;
        this.basicDamage = 5;
        this.inventory = new Item[10];
        this.equipment = new Item[2];
        this.setDamage();
        this.setFullName();
        // this.position = new int[2];
        // this.position[0] = 0;
        // this.position[1] = 0;
    }
    public Caracter fight(Caracter otherGuy) {
        System.out.println(this.name + " is fighting " + otherGuy.name);
        return this;
    }
    public Caracter walk(String direction) {
        System.out.println(this.name + " tries to walk");

        // switch (direction) {
        //     case "up":
        //         this.position[1] += 1;
        //         break;
        //     case "down":
        //         this.position[1] -= 1;
        //         break;
        //     case "left":
        //         this.position[0] -= 1;
        //         break;
        //     case "right":
        //         this.position[0] += 1;
        //         break;
        //     default:
        //         System.out.println(this.name +" can not walk. \nInvalid direction");
        //         break;
        // }
        this.setAction(-1);
        return this;
    }
    public void sayHi() {
        System.out.println("Hi, I'm " + this.name + " the " + this.suffix + " " + this.caracterClass);
    }
    public void encounterMe(){
        System.out.println("You encountered " + this.name + " the " + this.suffix + " " + this.caracterClass);
    }
    public void setSuffix(String suffix){
        this.suffix = suffix;
    }
    public void setFullName(){
        if (this.suffix == null) {
            this.fullName = this.name + " the " + this.caracterClass;
            if (this.caracterClass==null) {
            this.fullName = this.name;
            }
        } else if (this.caracterClass==null) {
            this.fullName = this.name + " the " + this.suffix;
        } else {
            this.fullName = this.name + " the " + this.suffix + " " + this.caracterClass;
        }
    }
    public void setAction (int n) {
        this.actions += n;
    }
    public void setDamage() {
        int equipedDamage = 0;
        for (Item item : this.equipment) {
            if (item ==null) {
                continue;
            } else if (item.type == "Weapon") {
                System.out.println( item);
            }
        }
        this.damage = this.basicDamage + equipedDamage;
    }
}
