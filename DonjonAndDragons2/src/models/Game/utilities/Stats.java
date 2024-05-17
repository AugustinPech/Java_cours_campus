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
        this.staminia = staminia;
        this.strength = strength;
        this.intel = intel;
        this.mental = mental;
        this.experience = experience;
        this.agility = agility;
        this.lifePoints = lifePoints;
        this.armor = (((int) this.staminia/2) >0 ? (int) this.staminia/2 : 0);
        this.initiative = (this.agility - this.armor) > 0 ? this.agility - this.armor : 0;
    }
    
    public Stats merge (Stats stats){
        Stats result = new Stats(
            (this.lifePoints + stats.lifePoints) > 0 ? this.lifePoints + stats.lifePoints : 0,
            (this.staminia + stats.staminia) > 0 ? this.staminia + stats.staminia : 0,
            (this.strength + stats.strength) > 0 ? this.strength + stats.strength : 0,
            (this.intel + stats.intel) > 0 ? this.intel + stats.intel : 0,
            (this.mental + stats.mental) > 0 ? this.mental + stats.mental : 0,
            (this.agility + stats.agility) > 0 ? this.agility + stats.agility : 0,
            (this.experience + stats.experience) > 0 ? this.experience + stats.experience : 0
        );
        this.armor = (((int) this.staminia/2) >0 ? (int) this.staminia/2 : 0)+stats.getArmor();
        this.initiative = ((this.agility - this.armor) > 0 ? this.agility - this.armor : 0)+stats.getInitiative();
        if (result.experience < 0) {
            result.experience = 0;
        }
        return result;
    }
    public Stats detach(Stats stats){
        Stats result = new Stats(
            (this.lifePoints - stats.lifePoints)>0 ? this.lifePoints - stats.lifePoints : 0,
            (this.staminia - stats.staminia)>0 ? this.staminia - stats.staminia : 0,
            (this.strength - stats.strength)>0 ? this.strength - stats.strength : 0,
            (this.intel - stats.intel)>0 ? this.intel - stats.intel : 0,
            (this.mental - stats.mental)>0 ? this.mental - stats.mental : 0,
            (this.agility - stats.agility)>0 ? this.agility - stats.agility : 0,
            this.experience
        );
        this.armor = (((int) this.staminia/2) >0 ? (int) this.staminia/2 : 0);
        this.initiative = ((this.agility - this.armor) > 0 ? this.agility - this.armor : 0);
        if (result.experience < 0) {
            result.experience = 0;
        }
        return result;
    }
    public void recalculate() {
        this.armor = (((int) this.staminia/2) >0 ? (int) this.staminia/2 : 0);
        this.initiative = (this.agility - this.armor) > 0 ? this.agility - this.armor : 0;
    }
    @Override
    public String toString() {
        String str =""
        +"Life Points: "+this.lifePoints+"\n"
        +"Staminia: "+this.staminia+"\n"
        +"Strength: "+this.strength+"\n"
        +"Intel: "+this.intel+"\n"
        +"Mental: "+this.mental+"\n"
        +"Agility: "+this.agility+"\n"
        +"Experience: "+this.experience+"\n"
        +"Armor: "+this.armor+"\n"
        +"Initiative: "+this.initiative+"\n";
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
        this.setArmor();
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
        this.setInitiative();
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

    public void setArmor() {
        this.armor = (((int) this.staminia/2) >0 ? (int) this.staminia/2 : 0);
    }
    public int getMental() {
        return mental;
    }

    public void setMental(int mental) {
        this.mental = mental;
    }
}
