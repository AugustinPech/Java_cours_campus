package DonjonAndDragons.src.models.items;

import DonjonAndDragons.src.models.Stats;

public class Weapon extends Equipable{
    public Weapon(String caracterClass){
        super("Basic weapon", "Weapon");

        switch (caracterClass) {
            case "Warrior" -> {
                this.setName("Sword");
                this.mipple = "🗡";
                this.type = "Weapon";
                this.stats = new Stats(0, 0, 0, 5, 0);
                this.weight = 5;
                this.value = 10;
                this.status = "Good old";
            }
            case "Wizard" -> {
                this.setName("Staff");
                this.type = "Weapon";
                this.mipple = "⚕";
                this.stats = new Stats(0, 0, 0, 10, 1);
                this.weight = 3;
                this.value = 5;
                this.status = "Good old";
            }
        }
    }
    public Weapon(String name, String type, int weight, int value,String status, int damage, int range){
        super(name, type, weight, value, status);
        this.stats.setDamage(damage);
        this.stats.setRange(range);
    }
}
