package DonjonAndDragons.src.models.items;

import DonjonAndDragons.src.models.Stats;

public class Armor extends Item{
    public Armor(String caracterClass){
        switch (caracterClass) {
            case "Warrior" -> {
                this.name = "Leather Armor";
                this.type = "Armor";
                this.mipple = "🧥";
                this.stats= new Stats(0, 5, 0, 0, 0);
                this.weight = 10;
                this.value = 20;
                this.status = "Good old";
            }
            case "Wizard" -> {
                this.name = "Robe";
                this.type = "Armor";
                this.mipple = "👘";
                this.stats= new Stats(0, 1, 0, 0, 0);
                this.weight = 3;
                this.value = 10;
                this.status = "Good old";
            }
        }
    }
    public Armor(String name, String type, int weight, int value,String status, int armor){
        super(name, type, weight, value, status);
        this.stats.setArmor(armor);
    }
}
