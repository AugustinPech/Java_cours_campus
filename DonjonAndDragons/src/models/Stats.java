package DonjonAndDragons.src.models;

public class Stats {
    private int lifePoints;
    private int armor;
    private int actions;
    private int damage;
    private int experience;
    private int magic;

    public Stats(int lifePoints, int armor, int actions, int damage, int magic, int experience) {
        this.lifePoints = lifePoints;
        this.armor = armor;
        this.actions = actions;
        this.damage = damage;
        this.experience = experience;
        this.magic = magic;
    }
    public Stats merge (Stats stats){
        Stats result = new Stats(
            this.lifePoints + stats.lifePoints,
            this.armor + stats.armor,
            this.actions + stats.actions,
            this.damage + stats.damage,
            this.magic + stats.magic,
            this.experience + stats.experience
        );
        if (result.experience < 0) {
            result.experience = 0;
        }
        return result;
    }
    public Stats detach(Stats stats){
        Stats result = new Stats(
            this.lifePoints - stats.lifePoints,
            this.armor - stats.armor,
            this.actions - stats.actions,
            this.damage - stats.damage,
            this.magic - stats.magic,
            this.experience
        );
        if (result.experience < 0) {
            result.experience = 0;
        }
        return result;
    }
    @Override
    public String toString() {
        String str = 
            "    Life Points: "+this.lifePoints+"    Armor: "+this.armor+"    Actions: "+this.actions+"\n"+
            "    Damage: "+this.damage+"    Experience: "+this.experience+"\n";
        return str;
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
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public int getMagic() {
        return magic;
    }
    public void setMagic(int magic) {
        this.magic = magic;
    }

}
