package DonjonAndDragons.src.models.items;

import DonjonAndDragons.src.models.Stats;

public class Item {
    public String name;
    public String type;
    public int weight;
    public int value;
    public String status;
    protected Stats stats;
    public String mipple = "📦";
    public Item (){
        // Works with subClasses
    }
    public Item(String name, String type){
        this.name = name;
        this.type = type;
        this.status="Brand new";
        this.value = (int) (Math.random()*10);
    }
    public Item(String name, String type, int weight, int value,String status){
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.value = value;
        this.status = status;
    }
    public String toString(){
        return this.status + " " + this.name;
    }
    public int getArmor(){
        return this.stats.getArmor();
    }
    public int getDamage(){
        return this.stats.getDamage();
    }
    public Stats getStats() {
        return stats;
    }
}
