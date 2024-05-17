package DonjonAndDragons2.src.models.Caracters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import DonjonAndDragons2.src.models.Game.utilities.Stats;
import DonjonAndDragons2.src.models.Game.utilities.damages.Damage;
import DonjonAndDragons2.src.models.Game.utilities.status.Status;


public abstract class Caracter {
    // private Item[] inventory;
    // protected Equipable[] equipment;
    private ArrayList<Status> status;
    private String name;
    private String caracterClass;
    private Stats stats;
    private String sprite = "😃";
    private int position;
    private int level=0;

    public Caracter (int level){
        this.level = level;
        this.status = new ArrayList<Status>();
        this.stats = new Stats(100, 0, 5, 5, 5, 5, 0);
    }
    public Caracter (String name){
        this.name = name;
        this.level = 0;
        this.status = new ArrayList<Status>();
        this.stats = new Stats(100, 0, 5, 5, 5, 5, 0);
    }

    public void applyStatus(Status status){
        ArrayList<Status> statuses = this.status;
        for (Status st : statuses){
            statuses.remove(st);
            this.setStats(this.getStats().merge(st.getStats()));
            st.setDuration(st.getDuration()-1);
            //todo : add a way to remove status when duration is 0
            statuses.add(st);
        }
    }
    public abstract Damage attack(Caracter target);

    public abstract void defend(Damage damage);
    
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
    public String getCaracterClass() {
        return caracterClass;
    }
    public void setCaracterClass(String caracterClass) {
        this.caracterClass = caracterClass;
    }
    public String getSprite() {
        return sprite;
    }
    public void setSprite(String sprite) {
        this.sprite = sprite;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }

    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public ArrayList<Status> getStatus() {
        return status;
    }
    public void setStatus(ArrayList<Status> status) {
        this.status = status;
    }
}
