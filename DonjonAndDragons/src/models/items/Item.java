package DonjonAndDragons.src.models.items;

import DonjonAndDragons.src.models.Stats;

public class Item {
    private String name;
    public String type;
    public int weight;
    public int value;
    public String status;
    protected Stats stats= new Stats (0,0,0,0,0);
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
        return "["+this.status+"]" + " " + this.name;
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
    public void setStats(Stats stats) {
        this.stats = stats;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMipple() {
        return mipple;
    }
    public void setMipple(String mipple) {
        this.mipple = mipple;
    }
}
