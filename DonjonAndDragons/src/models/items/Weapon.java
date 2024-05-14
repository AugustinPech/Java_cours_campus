package DonjonAndDragons.src.models.items;

import DonjonAndDragons.src.models.Stats;

public class Weapon extends Equipable{
    public Weapon(String caracterClass){
        super("Basic weapon", "Weapon");
        this.mipple = "🗡";

        switch (caracterClass) {
            case "Warrior" -> {
                this.setName("Sword");
                this.type = "Weapon";
                this.stats = new Stats(0, 0, 0, 5,0, 0);
                this.weight = 5;
                this.value = 10;
                this.status = "Good old";
            }
            case "Wizard" -> {
                this.setName("Staff");
                this.type = "Weapon";
                this.mipple = "⚕";
                this.stats = new Stats(0, 0, 0, 3, 10, 1);
                this.weight = 3;
                this.value = 5;
                this.status = "Good old";
            }
            case "God" -> {
                this.setName("Protectress of Heaven");
                this.type = "Weapon";
                this.mipple = "🌟";
                this.stats = new Stats(0, 0, 0, 100,100,0);
                this.weight = 0;
                this.value = 1000;
                this.status = "Divine";
            }
            case "Gobelin"-> {
                this.setName("Gobelin's dagger");
                this.type = "Weapon";
                this.mipple = "🔪";
                this.stats = new Stats(0, 0, 0, 2,0, 0);
                this.weight = 1;
                this.value = 2;
                this.status = "Rusty";
            }
            case "Orc"-> {
                this.setName("Orc's axe");
                this.type = "Weapon";
                this.mipple = "🪓";
                this.stats = new Stats(0, 0, 0, 10, 0,0);
                this.weight = 10;
                this.value = 20;
                this.status = "Rusty";
            }
            case "Guardian" -> {
                this.setName("Guardian's staff");
                this.type = "Weapon";
                this.stats = new Stats(10, 10, 0, 30,30, 0);
                this.weight = 5;
                this.value = 10;
                this.status = "Good old";
            
            }
        }
    }
    public Weapon(String name, String type, int weight, int value,String status, int damage, int exp){
        super(name, type, weight, value, status);
        this.stats.setDamage(damage);
        this.stats.setExperience(exp);
    }
    public Weapon(int roll, int level) {
        super (roll, level);
        this.setName(this.fakeName(roll, level));
        int points = (int) level+roll/5;
        Stats stats = new Stats(0,0,0,2,0,0);
        for (int i = 0; i <= points; i++) {
            int pick = (int) (Math.random()*6);
            switch (pick) {
                case 0 -> stats.setDamage(stats.getDamage()+1);
                case 1 -> stats.setLifePoints(stats.getLifePoints()+1);
                case 2 -> stats.setArmor(stats.getArmor()+1);
                case 3 -> stats.setDamage(stats.getDamage()+1);
                case 4 -> stats.setExperience(stats.getExperience()+1);
                case 5 -> stats.setMagic(stats.getMagic()+1);
            }
            this.setStats(stats);
        }
    }
    private String fakeName(int roll, int level){
        String[] weaponNames = {
            "Rusty Stick",
            "Cracked Blade",
            "Chipped Hilt",
            "Dull Shaft",
            "Old Pole",
            "Battered Rod",
            "Broken Stave",
            "Common Sword",
            "Simple Axe",
            "Plain Mace",
            "Standard Spear",
            "Average Staff",
            "Unremarkable Halberd",
            "Mediocre Crossbow",
            "Enchanted Dagger",
            "Enchanted Axe",
            "Enchanted Mace",
            "Enchanted Hammer",
            "Enchanted Spear",
            "Enchanted Staff",
            "Legendary Blade",
            "Legendary Dagger",
            "Legendary Axe",
            "Legendary Mace",
            "Legendary Hammer",
            "Legendary Spear",
        };
        int index = (int) (roll/5 + level) % weaponNames.length;
        String str = weaponNames[index];
        return str;
    }
}
