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
    private ArrayList<Status> statuses;
    private String name;
    private String caracterClass;
    private Stats stats;
    private String sprite = "😃";
    private int position;
    private int level=0;

    public Caracter (int level){
        this.level = level;
        this.statuses = new ArrayList<Status>();
        this.stats = new Stats(100, 0, 5, 5, 5, 5, 0);
    }
    public Caracter (String name){
        this.name = name;
        this.level = 0;
        this.statuses = new ArrayList<Status>();
        this.stats = new Stats(100, 0, 5, 5, 5, 5, 0);
    }

    public void applyStatuses(){
        ArrayList<Status> statuses = this.statuses;
        ArrayList<Status> statusesEnded = new ArrayList<>();
        for (Status st : statuses){
            this.setStats(this.getStats().merge(st.getStats()));
            st.setDuration(st.getDuration()-1);
            if (st.getDuration() <= 0) {
                statusesEnded.add(st);
            }
        }
        for (Status st : statusesEnded){
            statuses.remove(st);
        }
    }
    public void addStatus(Status status){
        this.statuses.add(status);
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
    public ArrayList<Status> getStatuses() {
        return statuses;
    }
    public void setStatuses(ArrayList<Status> statuses) {
        this.statuses = statuses;
    }
}
