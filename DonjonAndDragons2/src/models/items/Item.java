package DonjonAndDragons2.src.models.items;

import DonjonAndDragons2.src.models.Game.utilities.Stats;

public class Item {
    private String name;
    private String description;
    private Stats stats= new Stats(0,0,0,0,0,0,0); //TOFIX
    private int level;
    private String sprite = "📦";

    public Item(String name, int level) {
        this.name = name;
        this.level=level;
    }
    @Override
    public String toString() {
        String str = this.getSprite() + " " + this.getName() +" LvL :" + this.getLevel();
        return str;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    public void setDescritpion(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }
}
