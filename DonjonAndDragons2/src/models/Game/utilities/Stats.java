package DonjonAndDragons2.src.models.Game.utilities;

import DonjonAndDragons2.src.models.Game.Exception.LifeTo0Exception;

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
        this.setStaminia( staminia);
        this.setStrength(strength);
        this.setIntel(intel);
        this.setMental(mental);
        this.setExperience(experience);
        this.setAgility(agility);
        this.lifePoints=(lifePoints);
        this.recalculate();
    }
    
    public Stats merge (Stats stats) throws LifeTo0Exception {
        Stats result = new Stats(0,0,0,0,0,0,0);

            result.setLifePoints((this.lifePoints + stats.lifePoints) > 0 ? this.lifePoints + stats.lifePoints : 0);
            result.setStaminia((this.staminia + stats.staminia) > 0 ? this.staminia + stats.staminia : 0);
            result.setStrength((this.strength + stats.strength) > 0 ? this.strength + stats.strength : 0);
            result.setIntel((this.intel + stats.intel) > 0 ? this.intel + stats.intel : 0);
            result.setMental((this.mental + stats.mental) > 0 ? this.mental + stats.mental : 0);
            result.setAgility((this.agility + stats.agility) > 0 ? this.agility + stats.agility : 0);
            result.setExperience((this.experience + stats.experience) > 0 ? this.experience + stats.experience : 0);
        
        result.armor = (((int) this.staminia/2) >0 ? (int) this.staminia/2 : 0)+stats.getArmor();
        result.initiative = ((this.agility - this.armor) > 0 ? this.agility - this.armor : 0)+stats.getInitiative();

        if (result.experience < 0) {
            result.experience = 0;
        }
        return result;
    }
    public Stats detach(Stats stats) throws LifeTo0Exception{
        
        Stats result = new Stats(0,0,0,0,0,0,0);

            result.setLifePoints((this.lifePoints - stats.lifePoints) > 0 ? this.lifePoints - stats.lifePoints : 0);
            result.setStaminia((this.staminia - stats.staminia) > 0 ? this.staminia - stats.staminia : 0);
            result.setStrength((this.strength - stats.strength) > 0 ? this.strength - stats.strength : 0);
            result.setIntel((this.intel - stats.intel) > 0 ? this.intel - stats.intel : 0);
            result.setMental((this.mental - stats.mental) > 0 ? this.mental - stats.mental : 0);
            result.setAgility((this.agility - stats.agility) > 0 ? this.agility - stats.agility : 0);
            result.setExperience((this.experience));
        
        result.recalculate();
        if (result.experience < 0) {
            result.experience = 0;
        }
        return result;
    }
    public void recalculate() {
        this.setArmor();
        this.setInitiative();
    }
    @Override
    public String toString() {
        String str =""
        +"      Life Points: "+this.getLifePoints()
        +"      Staminia: "+this.getStaminia()+"\n"
        +"      Strength: "+this.getStrength()
        +"      Intel: "+this.getIntel()+"\n"
        +"      Mental: "+this.getMental()
        +"      Agility: "+this.getAgility()+"\n"
        +"      Experience: "+this.getExperience()
        +"      Armor: "+this.getArmor()+"\n"
        +"      Initiative: "+this.getInitiative();
        return str;
    }
    public int getLifePoints() {
        return lifePoints;
    }
    public void setLifePoints(int lifePoints) throws LifeTo0Exception {
        this.lifePoints = lifePoints;
        if (this.getLifePoints()<=0) {
            throw new LifeTo0Exception();
        }
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
