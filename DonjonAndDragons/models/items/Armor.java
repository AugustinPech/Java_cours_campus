package DonjonAndDragons.models.items;

public class Armor extends Item{
    public int armor;
    public Armor(String caracterClass){
        switch (caracterClass) {
            case "Warrior" -> {
                this.name = "Leather Armor";
                this.type = "Armor";
                this.armor = 5;
                this.weight = 10;
                this.value = 20;
                this.status = "Good old";
            }
            case "Wizard" -> {
                this.name = "Robe";
                this.type = "Armor";
                this.armor = 3;
                this.weight = 3;
                this.value = 10;
                this.status = "Good old";
            }
        }
    }
    public Armor(String name, String type, int weight, int value,String status, int armor){
        super(name, type, weight, value, status);
        this.armor = armor;
    }
}
