package DonjonAndDragons.src.models.Caracters;

import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.models.Game.Room;
import DonjonAndDragons.src.models.items.Corps;
import DonjonAndDragons.src.models.items.Item;
import DonjonAndDragons.src.models.items.Weapon;
public class Caracter {
    public String name;
    public String suffix;
    public String fullName;
    public String type;
    public String caracterClass;
    public int lifePoints;
    public String sprite = "😃";
    public String[] statsView= {
                "  ______________________________________________________________" , //0
                "  |                                                            " ,
                "  |                                                            " ,
                "  |                                                            " ,
                "  |                                                            " ,
                "  |                                                            " ,// 5
                "  |                                                            " ,
                "  |                                                            " ,
                "  |                       NO                                   " ,//8
                "  |                                                            " ,  
                "  |                                                            " ,//10
                "  |                                                            " ,
                "  |                                                            " ,
                "  |                       STATS                                " ,//13
                "  |                                                            " ,
                "  |                                                            " ,//15
                "  |                          SHOWN                             " ,//16
                "  |                                                            " ,
                "  |                                                            " ,
                "  |                               YET                          " ,//19
                "  |                                                            " ,// 20
                "  |                                                            " ,
                "  |                                                            " ,
                "  |____________________________________________________________" ,//23
            };
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
    public int position;
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
        this.pickSuffix();
        this.setFullName();
        this.position=1;
        this.createStatsView();
        // this.position = new int[2];
        // this.position[0] = 0;
        // this.position[1] = 0;
    }
    public void createStatsView() {
            this.statsView[3]= "  |   Name: " + this.fullName;
            this.statsView[5]= "  |   Life Points: " + this.lifePoints ;
            this.statsView[7]= "  |   Armor: " + this.armor + "   Damage: "+ this.damage;
            this.statsView[8]= this.statsView[12];
            this.statsView[9]= "  |   Actions: " + this.actionsLeft + "   Actions(max): "+ this.actions;
            this.statsView[11]= "  |   Position: " + this.position ;
            this.statsView[13]= "  |   Equipement: " ;
            if (this.equipment[0] != null) {
                this.statsView[14]= "  |            (1) " + this.equipment[0].mipple + " " + this.equipment[0].toString();
            } else {
                this.statsView[14]= "  |            (1) " + "📦" + " Empty";
            }
            if (this.equipment[1] != null) {
                this.statsView[15]= "  |            (2) " + this.equipment[1].mipple + " " + this.equipment[1].toString();
            } else {
                this.statsView[15]= "  |            (2) " + "📦" + " Empty";
            }
            this.statsView[16]= this.statsView[12];
            this.statsView[17]= "  |   Class: " + this.caracterClass ;
            this.statsView[19]= this.statsView[12];
    }
    private void pickSuffix(){
        String[] suffixes = {
            "Sultan of Swagger",
            "Captain of Capers",
            "Lord of Laughter",
            "Duke of Droll",
            "King of Comedy",
            "Emperor of Enchantment",
            "Connoisseur of Chaos",
            "Champion of Chuckles",
            "Mistress of Mischief",
            "Baron of Banter",
            "Prince of Pranks",
            "Guru of Giggles",
            "Jester of Jokes",
            "Maven of Merriment",
            "Pharaoh of Fun",
            "Sovereign of Silliness",
            "Tsar of Teasing",
            "Majesty of Mirth",
            "Dictator of Droll",
            "Overlord of Oddities",
            "Monarch of Mirth",
            "Mastermind of Madness",
            "Regent of Ridiculousness",
            "Diva of Ditz",
            "Supreme Sassmaster",
            "Grand Poobah of Puns"
        };
        this.suffix = suffixes[(int)(Math.random()*suffixes.length)];
        this.setFullName();
    }
    public Caracter fight(Caracter otherGuy) {
        return this;
    }
    public void move (String how){
        switch (how) {
            case "forward":
                this.position ++;
                break;
            case "backward":
                this.position --;
                break;
            default:
                System.out.println(this.name + " can not move. \nInvalid action");
                break;
        }
    }
    public void sayHi() {
        System.out.println("Hi, I'm " + this.name + " the " + this.suffix + " " + this.caracterClass);
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
            this.fullName = this.name + " , " + this.suffix;
        } else {
            this.fullName = this.name + " , " + this.suffix + " the " + this.caracterClass;
        }
    }
    public void setAction (int n) {
        this.actionsLeft += n;
    }
    public void setDamage() {
        int equipedDamage = 0;
        for (Item item : this.equipment) {
            if (item ==null) {
                continue;
            } else if (item.getDamage() != 0) {
                equipedDamage += item .getDamage();
                
            }
        }
        this.damage = this.basicDamage + equipedDamage;
    }
    public void setArmor() {
        int equipedArmor = 0;
        for (Item item : this.equipment) {
            if (item ==null) {
                continue;
            } else if (item.getArmor() != 0) {
                equipedArmor += item.getArmor();}
        }
        this.armor = equipedArmor;
    }
    public void die (Room room) {
        for (Item item : this.inventory) {
            room.addItem(item);
        }
        for (Item item : this.equipment) {
            room.addItem(item);
        }
        Corps corps = new Corps(this);
        room.addItem(corps);
    }
}
