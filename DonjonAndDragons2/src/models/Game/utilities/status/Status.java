package DonjonAndDragons2.src.models.Game.utilities.status;

import DonjonAndDragons2.src.models.Game.utilities.Stats;

public class Status {
    private Stats stats;
    private String name;
    private int duration;
    
    public Status(Stats stats2, int duration, String name) {
        this.stats = stats2;
        this.duration = duration;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }
    
    public Stats getStats() {
        return stats;
    }
    
}
