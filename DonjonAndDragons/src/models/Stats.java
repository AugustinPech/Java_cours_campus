package DonjonAndDragons.src.models;

public class Stats {
    private int lifePoints;
    private int armor;
    private int actions;
    private int damage;
    private int range;

    public Stats(int lifePoints, int armor, int actions, int damage, int range) {
        this.lifePoints = lifePoints;
        this.armor = armor;
        this.actions = actions;
        this.damage = damage;
        this.range = range;
    }
    public Stats merge (Stats stats){
        Stats result = new Stats(this.lifePoints + stats.lifePoints, this.armor + stats.armor, this.actions + stats.actions, this.damage + stats.damage, this.range + stats.range);
        return result;
    }
    public int getLifePoints() {
        return lifePoints;
    }
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }
    public int getArmor() {
        return armor;
    }
    public void setArmor(int armor) {
        this.armor = armor;
    }
    public int getActions() {
        return actions;
    }
    public void setActions(int actions) {
        this.actions = actions;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getRange() {
        return range;
    }
    public void setRange(int range) {
        this.range = range;
    }

}
