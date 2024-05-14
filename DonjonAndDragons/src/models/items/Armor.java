package DonjonAndDragons.src.models.items;

import DonjonAndDragons.src.models.Stats;

public class Armor extends Equipable{
    public Armor(String name, String type, int weight, int value,String status, int armor){
        super(name, type, weight, value, status);
        this.stats.setArmor(armor);
    }
    public Armor(String caracterClass){
        super("Basic Armor", "Armor");
        this.mipple = "🛡";

        switch (caracterClass) {
            case "Warrior" -> {
                this.setName("Leather Armor");
                this.type = "Armor";
                this.mipple = "🧥";
                this.stats= new Stats(0, 5, 0, 0, 1, 0);
                this.weight = 10;
                this.value = 20;
                this.status = "Good old";
            }
            case "Wizard" -> {
                this.setName("Robe");
                this.type = "Armor";
                this.mipple = "👘";
                this.stats= new Stats(0, 1, 0, 0, 1, 0);
                this.weight = 3;
                this.value = 10;
                this.status = "Good old";
            }
            case "God" -> {
                this.setName("Armor of the divine being");
                this.type = "Armor";
                this.mipple = "🌟";
                this.stats= new Stats(0, 100, 0, 0, 100, 0);
                this.weight = 0;
                this.value = 1000;
                this.status = "Divine";
            }
            case "Gobelin"-> {
                this.setName("Gobelin's rags");
                this.type = "Armor";
                this.mipple = "👕";
                this.stats= new Stats(0, 2, 0, 0, 0, 0);
                this.weight = 1;
                this.value = 2;
                this.status = "Rusty";
            }
            case "Orc"-> {
                this.setName("Orc's armor");
                this.type = "Armor";
                this.stats= new Stats(0, 10, 0, 0, 0, 0);
                this.weight = 10;
                this.value = 20;
                this.status = "Rusty";
            }
            case "Guardian" -> {
                this.setName("Guardian's armor");
                this.type = "Armor";
                this.stats= new Stats(30, 30, 0, 0,30, 0);
                this.weight = 5;
                this.value = 50;
                this.status = "Good old";
            }
        }
    }
    public Armor(int roll, int level) {
        super (roll);
        this.setName(this.fakeName(roll, level));
        int points = (int) level+roll/5;
        Stats stats = new Stats(0,0,0,2,0,0);
        for (int i = 0; i <= points; i++) {
            int pick = (int) (Math.random()*6);
            switch (pick) {
                case 0 -> stats.setArmor(stats.getArmor()+1);
                case 1 -> stats.setLifePoints(stats.getLifePoints()+1);
                case 2 -> stats.setDamage(stats.getDamage()+1);
                case 3 -> stats.setArmor(stats.getArmor()+1);
                case 4 -> stats.setExperience(stats.getExperience()+1);
                case 5 -> stats.setMagic(stats.getMagic()+1);
            }
            this.setStats(stats);
        }
    }
    private String fakeName(int roll, int level){
        String[] armorNames = {
            "Tattered Tunic",
            "Worn Cloak",
            "Rusty Chainmail",
            "Chipped Plate",
            "Dull Helm",
            "Frayed Robe",
            "Tarnished Gauntlets",
            "Old Greaves",
            "Battered Shield",
            "Broken Belt",
            "Leather Jerkin",
            "Sturdy Jerkin",
            "Reinforced Leather",
            "Steel Plate",
            "Iron Helm",
            "Bronze Greaves",
            "Silver Chainmail",
            "Gold Helm",
            "Obsidian Shield",
            "Crystal Armor",
            "Enchanted Robe",
            "Adamantine Plate",
            "Mithril Gauntlets",
            "Dragonhide Cloak",
            "Legendary Armor"
        };
        int index = (int) (roll/5 + level) % armorNames.length;
        String str = armorNames[index];
        return str;
    }
}
