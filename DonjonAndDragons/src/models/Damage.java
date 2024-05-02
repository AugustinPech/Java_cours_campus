package DonjonAndDragons.src.models;

public class Damage {
    private int fire;
    private int water;
    private int energy;
    private int physical;
    public Damage(int fire, int water, int energy, int physical) {
        this.fire = fire;
        this.water = water;
        this.energy = energy;
        this.physical = physical;
    }
    public Damage merge (Damage damage){
        return new Damage(this.fire + damage.fire, this.water + damage.water, this.energy + damage.energy, this.physical + damage.physical);
    }
    public int getFire() {
        return fire;
    }
    public void setFire(int fire) {
        this.fire = fire;
    }
    public int getWater() {
        return water;
    }
    public void setWater(int water) {
        this.water = water;
    }
    public int getEnergy() {
        return energy;
    }
    public void setEnergy(int energy) {
        this.energy = energy;
    }
    public int getPhysical() {
        return physical;
    }
    public void setPhysical(int physical) {
        this.physical = physical;
    }
    
}
