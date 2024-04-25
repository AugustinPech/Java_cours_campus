package DonjonAndDragons.models.items;

public class Weapon extends Item{
    public int damage;
    public int range;
    public Weapon(String caracterClass){
        switch (caracterClass) {
            case "Warrior" -> {
                this.name = "Sword";
                this.type = "Weapon";
                this.damage = 5;
                this.range = 1;
                this.weight = 5;
                this.value = 10;
                this.status = "Good old";
            }
            case "Wizard" -> {
                this.name = "Staff";
                this.type = "Weapon";
                this.damage = 3;
                this.range = 2;
                this.weight = 3;
                this.value = 5;
                this.status = "Good old";
            }
        }
    }
    public Weapon(String name, String type, int weight, int value,String status, int damage, int range){
        super(name, type, weight, value, status);
        this.damage = damage;
        this.range = range;
    }
}
