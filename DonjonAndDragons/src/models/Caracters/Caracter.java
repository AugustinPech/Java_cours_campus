package DonjonAndDragons.src.models.Caracters;

import java.util.HashMap;
import java.util.Map;

import DonjonAndDragons.src.models.Stats;
import DonjonAndDragons.src.models.Caracters.NPC.NPC;
import DonjonAndDragons.src.models.Caracters.Player.Player;

import DonjonAndDragons.src.models.Game.Board.Board;
import DonjonAndDragons.src.models.Game.Board.Room;
import DonjonAndDragons.src.models.Game.Exception.PlayerIsDeadException;
import DonjonAndDragons.src.models.items.Item;
import DonjonAndDragons.src.models.items.equipables.Armor;
import DonjonAndDragons.src.models.items.equipables.Equipable;
import DonjonAndDragons.src.models.items.equipables.Weapon;
import DonjonAndDragons.src.models.items.usables.Corps;
import DonjonAndDragons.src.models.items.usables.Potion;
public abstract class Caracter {
    private String name;
    private String suffix;
    private String fullName;
    private String caracterClass;

    protected Stats stats;

    private String sprite = "😃";
    private Item[] inventory;
    protected Equipable[] equipment;
    private int actionsLeft;
    private int position;
    private int level=0;


    public Caracter(String name) {
        try {
        this.name = name;
        this.stats = new Stats(50,0,1,5,1,0);
        this.inventory = new Item[10];
        this.equipment = new Equipable[2];
        this.position=0;
        this.pickSuffix();
        this.setFullName();
        this.considerEquipment();
        } catch (PlayerIsDeadException e) {
        }

    }
    public Caracter (int num ) {// god mode
        try {
        this.name = "God";
        this.stats = new Stats(1000,1000,1000,1000,1000, 1000);
        this.inventory = new Item[10];
        this.equipment = new Equipable[2];
        this.equipment[0] = new Weapon("God");
        this.equipment[1] = new Armor("God");
        this.inventory[0] = new Potion("Heal Potion", "Health");
        this.inventory[1] = new Potion("Heal Potion", "Health");
        this.inventory[2] = new Potion("Protection Potion", "Protection");
        this.inventory[3] = new Potion("Protection Potion", "Protection");
        this.inventory[4] = new Potion("Protection Potion", "Protection");
        this.inventory[5] = new Potion("Protection Potion", "Protection");
        this.inventory[6] = new Potion("Protection Potion", "Protection");
        this.inventory[7] = new Potion("Protection Potion", "Protection");
        this.inventory[8] = new Potion("Protection Potion", "Protection");
        this.inventory[9] = new Potion("Protection Potion", "Protection");
        this.position=0;
        this.setCaracterClass("God");
        this.pickSuffix();
        this.setFullName();
        this.considerEquipment();
        } catch (PlayerIsDeadException e) {
        }
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

    public Map attack (Caracter target, Board board) {
        int damage = this.stats.getDamage();
        
        Map fightOuput = target.takeDamage(damage,false);
        fightOuput.put ( "attacking caracter", this.fullName);
        board.nPCAreOstile();
        return fightOuput;
    }

    public Map takeDamage(int damage, boolean isMagic) {
        int armor = this.stats.getArmor();
        int lifePoints = this.stats.getLifePoints();
        int magic = this.stats.getMagic();
        Map<String , String> fightOuput = new HashMap<>();
            fightOuput. put ("armor", String.valueOf(armor));
            fightOuput. put ("initial life points",String.valueOf(lifePoints));
            fightOuput.put ("defending caracter", this.fullName);
            fightOuput.put ("magic", String.valueOf(magic));
        if (isMagic){
            fightOuput.put ("damage inflicted", String.valueOf(damage));
            fightOuput.put ("resulting life points", String.valueOf(lifePoints-damage));
            if (magic < damage) {
                damage -= magic;
            } else {
                damage = 0;
            }
            fightOuput.put ("damage taken", String.valueOf(damage));
        } else {
            fightOuput. put ("damage inflicted", String.valueOf(damage));
            fightOuput.put ("resulting life points", String.valueOf(lifePoints-damage));
            if (armor < damage) {
                damage -= armor;
            } else {
                damage = 0;
            }
            fightOuput. put ("damage taken", String.valueOf(damage));
        }
        int newLifePoints = lifePoints - damage;
        this.stats.setLifePoints(newLifePoints);
        this.stats.setLifePoints(this.stats.getLifePoints()-damage);
        return fightOuput;

    };

    public void move (String how, int roll){
        switch (how) {
            case "forward":
                this.position += roll;
                break;
            case "backward":
                this.position -= roll;
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
    public void considerEquipment() throws PlayerIsDeadException {
        Stats previousStats = this.getStats();
        for (Equipable item : this.equipment) {
            if (item != null && item.getIsEquiped()) {
                item.setIsEquiped(false);
                Stats itemStats = item.getStats();
                previousStats = previousStats.detach(itemStats);
            }
        }
        Stats stats = previousStats;
        for (Equipable item : this.equipment) {
            if (item != null) {
                item.setIsEquiped(true);
                Stats itemStats = item.getStats();
                itemStats.setExperience(0);
                stats=stats.merge(itemStats);
            }
        }
        this.setStats(stats);
    }
    
    public void die (Room room, Player player) {
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
            Stats stats = player.getStats();
            stats.setExperience(stats.getExperience()+((NPC)this).getLevel());
            player.setStats(stats);
        }
    }
    public String getName() {
        return this.name;
    }
    public String getFullName() {
        return this.fullName;
    }

    public String getCaracterClass() {
        return this.caracterClass;
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
    public Equipable[] getEquipment() {
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
    public void setEquipment(Equipable[] equipment) {
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
    public void setStats(Stats stats2) throws PlayerIsDeadException{
        if (stats2.getLifePoints() <=0) {
            throw new PlayerIsDeadException();
        }
        this.stats = stats2;
    }
    public Stats getStats() {
        return this.stats;
    }   
    public void setLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return this.level;
    }

}
