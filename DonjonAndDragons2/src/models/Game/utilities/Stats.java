package DonjonAndDragons2.src.models.Game.utilities;

public class Stats {
    private int lifePoints;
    private int staminia;
    private int armor;
    private int strength;
    private int experience;
    private int intel;
    private int mental;

    private int agility;
    private int initiative;



    public Stats(
            int lifePoints,
            int staminia,
            int strength,
            int intel,
            int mental,
            int agility,
            int experience
        ) {
        this.lifePoints = lifePoints;
        this.staminia = staminia;
        this.strength = strength;
        this.intel = intel;
        this.mental = mental;
        this.experience = experience;
        this.agility = agility;
        this.armor = ((int) this.staminia/2) >0 ? (int) this.staminia/2 : 0;
        this.initiative = (this.agility - this.armor) > 0 ? this.agility - this.armor : 0;
    }
    
    public Stats merge (Stats stats){
        Stats result = new Stats(
            this.lifePoints + stats.lifePoints,
            this.staminia + stats.staminia,
            this.strength + stats.strength,
            this.intel + stats.intel,
            this.mental + stats.mental,
            this.agility + stats.agility,
            this.experience + stats.experience
        );
        this.armor = ((int) this.staminia/2) >0 ? (int) this.staminia/2 : 0;
        this.initiative = (this.agility - this.armor) > 0 ? this.agility - this.armor : 0;
        if (result.experience < 0) {
            result.experience = 0;
        }
        return result;
    }
    public Stats detach(Stats stats){
        Stats result = new Stats(
            this.lifePoints - stats.lifePoints,
            this.staminia - stats.staminia,
            this.strength - stats.strength,
            this.intel - stats.intel,
            this.mental - stats.mental,
            this.agility - stats.agility,
            this.experience
        );
        this.armor = ((int) this.staminia/2) >0 ? (int) this.staminia/2 : 0;
        this.initiative = (this.agility - this.armor) > 0 ? this.agility - this.armor : 0;
        if (result.experience < 0) {
            result.experience = 0;
        }
        return result;
    }
    @Override
    public String toString() {
        String str = 
            "    Life Points: "+this.lifePoints+"    Staminia: "+this.staminia+"    Intel: "+this.intel+
            "    Strength: "+this.strength+"    Experience: "+this.experience+"\n";
        return str;
    }
    public int getLifePoints() {
        return lifePoints;
    }
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }
    public int getStaminia() {
        return staminia;
    }
    public void setStaminia(int staminia) {
        this.staminia = staminia;
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public int getIntel() {
        return intel;
    }
    public void setIntel(int intel) {
        this.intel = intel;
    }
    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }
    public int getInitiative() {
        return initiative;
    }

    public void setInitiative() {
        this.initiative = (this.agility - this.armor) > 0 ? this.agility - this.armor : 0;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
    public int getMental() {
        return mental;
    }

    public void setMental(int mental) {
        this.mental = mental;
    }
}
