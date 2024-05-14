package DonjonAndDragons.src.models.items;

import DonjonAndDragons.src.models.Stats;
import DonjonAndDragons.src.models.Caracters.Player.Player;
import DonjonAndDragons.src.models.Game.Exception.PlayerIsDeadException;

public class Potion extends Usable {
    public Potion(String name, String potionType) {
        super(name, "Potion");
        switch (potionType) {
            case "Health" -> {
                int heal = (int) (Math.random()*10 + 10);
                this.setName("Heal Potion");
                this.mipple = "♡";
                this.stats= new Stats(heal , 0, 0, 0, 0);
            }
            case "Protection" -> {
                this.setName("Protection Potion");
                this.mipple = "🧪";
                int armor = (int) (Math.random()*10+5);
                this.stats= new Stats(0 , armor, 0, 0, 0);
            }
            default -> {
                this.setName("Potion");
                this.mipple = "🧪";
                this.stats= new Stats(0 , 0, 0, 0, 0);
            }
        }
    }
    public Potion(int roll, int level) {
        super ("Potion", "Potion");
        this.setName(this.fakeName(roll, level));
        int points = (int) level+roll/5;
        Stats stats = new Stats(0,0,0,2,0);
        for (int i = 0; i <= points; i++) {
            int pick = (int) (Math.random()*4);
            switch (pick) {
                case 0 -> stats.setArmor(stats.getArmor()+1);
                case 1 -> stats.setLifePoints(stats.getLifePoints()+1);
                case 2 -> stats.setDamage(stats.getDamage()+1);
                case 3 -> stats.setExperience(stats.getExperience()+1);
            }
            this.setStats(stats);
        }
    }
    private String fakeName(int roll, int level){
        String[] usableItemNames = {
        "Healing Potion",
        "Mana Potion",
        "Antidote",
        "Elixir of Strength",
        "Elixir of Agility",
        "Elixir of Intellect",
        "Elixir of Vitality",
        "Elixir of Speed",
        "Elixir of Endurance",
        "Elixir of Wisdom",
        "Elixir of Fortune",
        "Stamina Potion",
        "Invisibility Potion",
        "Fire Resistance Potion",
        "Ice Resistance Potion",
        "Poison Resistance Potion",
        "Energy Drink",
        "Mystery Meat",
        "Bread",
        "Cheese",
        "Fruit",
        "Vegetable Soup",
        "Roast Chicken",
        "Fisherman's Stew",
        "Ambrosia"
    };
        int index = (int) (roll/5 + level) % usableItemNames.length;
        String str = usableItemNames[index];
        return str;
    }
    public Item[] use(Player player)  throws PlayerIsDeadException{
        return null;
    }
}
