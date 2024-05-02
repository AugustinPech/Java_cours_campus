package DonjonAndDragons.src.models.Caracters;

import DonjonAndDragons.src.models.Stats;
import DonjonAndDragons.src.models.Caracters.NPC.NPC;
import DonjonAndDragons.src.models.Caracters.Player.Player;
import DonjonAndDragons.src.models.Game.Game;
import DonjonAndDragons.src.models.Game.Board.Board;
import DonjonAndDragons.src.models.Game.Board.Room;
import DonjonAndDragons.src.models.items.Corps;
import DonjonAndDragons.src.models.items.Item;
public abstract class Caracter {
    private String name;
    private String suffix;
    private String fullName;
    private String type;
    private String caracterClass;

    private Stats stats;
    // private int lifePoints;
    // private int armor;
    // private int actions;
    // private int damage;
    private Stats baseStats;
    private String sprite = "😃";
    private Item[] inventory;
    private Item[] equipment;
    private int actionsLeft;
    private int position;
    // public int level;
    // public int education;
    // public int agility;
    // public int withdom;
    // public int strength;
    // protected int experience;
    // public int stamina;
    // public int gold;
    // public String[] status;
    //public Status[] status;
    // public int speed;
    // public int[] position;

    public Caracter(String name) {
        this.name = name;
        this.baseStats = new Stats(50,0,1,5, 0);
        this.stats=this.baseStats;
        this.inventory = new Item[10];
        this.equipment = new Item[2];
        this.position=0;
        this.pickSuffix();
        this.setFullName();
        this.considerEquipment();
        // this.level = 1;
        // this.experience = 0;
        // this.education = 5;
        // this.agility = 5;
        // this.withdom = 5;
        // this.strength = 5;
        // this.stamina = 5;
        // this.gold = 0;
        // this.status = new String[0];
        // this.speed = 5;
    }
    public Caracter (int num ) {// god mode
        this.name = "God";
        this.baseStats = new Stats(1000,1000,1000,1000, 1000);
        this.stats=this.baseStats;
        this.inventory = new Item[10];
        this.equipment = new Item[2];
        this.position=0;
        this.pickSuffix();
        this.setFullName();
        this.considerEquipment();
    }
    
    private void pickSuffix(){
        String[] suffixes = {
            "Sultan of Swagger",
            "Duke of Droll",
            "King of Comedy",
            "Emperor of Wikness",
            "Connoisseur of Chaos",
            "Champion of Chuckles",
            "Mistress of Mischief",
            "Archmage of Wikimancia",
            "Prince of Pranks",
            "Guru of Giggles",
            "Jester of Jokes",
            "Maven of Java",
            "Pharaoh of Fun",
            "Sovereign of Silliness",
            "Tsar of Teasing",
            "Majesty of Mirth",
            "Dictator of Droll",
            "Overlord of Oddities",
            "Monarch of Python",
            "Console of Madness",
            "Regent of Ridiculousness"
        };
        this.suffix = suffixes[(int)(Math.random()*suffixes.length)];
        this.setFullName();
    }

    public void attack (Caracter target, Board board) {
        int damage = this.stats.getDamage();
        target.takeDamage(damage);
        if (this instanceof Player){
            board.nPCAreOstile();
        }
    }

    public void takeDamage(int damage ) {
        int armor = this.stats.getArmor();
        int lifePoints = this.stats.getLifePoints();
        if (armor < damage) {
            damage -= armor;
        } else {
            damage = 0;
        }
        int newLifePoints = lifePoints - damage;
        this.stats.setLifePoints(newLifePoints);

    };

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
    public void considerEquipment() {
        Stats baseStats = this.getBaseStats(); 
        this.setStats(baseStats);
        Stats stats = baseStats;
        for (Item item : this.equipment) {
            if (item != null) {
                Stats itemStats = item.getStats();

                stats=stats.merge(itemStats);
            }
        }
        this.setStats(stats);
    }
    public void useItem(int index, Game game) {
        Item item = this.inventory[index];
        if (item != null) {
            Stats itemStats = item.getStats();
            this.stats = this.stats.merge(itemStats);
            this.inventory[index] = null;
            this.considerEquipment();
        }
    }
    public void die (Game game) {
        Room room = game.board.getDungeon()[this.position];
        for (Item item : this.inventory) {
            if (item !=null) {
                room.addItem(item);
            }
        }
        for (Item item : this.equipment) {
            if (item !=null) {
                room.addItem(item);
            }
        }
        Corps corps = new Corps(this);
        room.addItem(corps);
        if (this instanceof NPC) {   
            room.removeNPC((NPC) this);
        }
    }
    public String getName() {
        return this.name;
    }
    public String getFullName() {
        return this.fullName;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getCaracterClass() {
        return this.caracterClass;
    }
    public String getType() {
        return this.type;
    }
    public String getSprite() {
        return this.sprite;
    }
    public int getActionsLeft() {
        return this.actionsLeft;
    }
    public int getPosition() {
        return this.position;
    }
    public Item[] getInventory() {
        return this.inventory;
    }
    public Item[] getEquipment() {
        return this.equipment;
    }
    public void setActionsLeft(int actionsLeft) {
        this.actionsLeft = actionsLeft;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    public void setInventory(Item[] inventory) {
        this.inventory = inventory;
    }
    public void setEquipment(Item[] equipment) {
        this.equipment = equipment;
    }
    public void setCaracterClass(String caracterClass) {
        this.caracterClass = caracterClass;
    }
    public void setSprite(String sprite) {
        this.sprite = sprite;
    }
    public void setName(String name) {
        this.name = name;
    } 
    public void setStats(Stats stats) {
        this.stats = stats;
    }
    public Stats getStats() {
        return this.stats;
    }   
    public void setBaseStats(Stats baseStats) {
        this.baseStats = baseStats;
    }
    public Stats getBaseStats() {
        return this.baseStats;
    }
}
