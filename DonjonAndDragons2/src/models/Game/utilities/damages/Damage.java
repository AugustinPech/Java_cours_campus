package DonjonAndDragons2.src.models.Game.utilities.damages;

import DonjonAndDragons2.src.models.Game.utilities.Stats;

public abstract class Damage {
    
    private Stats stats;
    private int piercingRate;

    public Damage(Stats stats, int piercingRate) {
        this.piercingRate = piercingRate % 100;
        this.stats = stats;
    }

    public int getPiercingRate() {
        return piercingRate;
    }

    public void setPiercingRate(int piercingRate) {
        this.piercingRate = piercingRate;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    } 
}
