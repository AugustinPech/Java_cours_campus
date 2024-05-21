package DonjonAndDragons2.test.java.com.DungeonAndDragons2;


import org.junit.jupiter.api.Test;

import DonjonAndDragons2.src.models.Game.Exception.LifeTo0Exception;
import DonjonAndDragons2.src.models.Game.utilities.Stats;


import static org.junit.jupiter.api.Assertions.*;



class StatsTests {
    @Test
    void testMerge() {
        try {
            Stats stats1 = new Stats(10, 10, 10,
                                    10, 10, 10, 10);
            Stats stats2 = new Stats(10, 10, 10,
                                    10, 10, 10, 10);
            Stats result = stats1.merge(stats2);
            assertEquals(result.getLifePoints(), 20);
            assertEquals(result.getStaminia(), 20);
            assertEquals(result.getStrength(), 20);
            assertEquals(result.getIntel(), 20);
            assertEquals(result.getMental(), 20);
            assertEquals(result.getAgility(), 20);
            assertEquals(result.getExperience(), 20);
            assertEquals(result.getArmor(), 10);
            assertEquals(result.getInitiative(), 10);
        } catch (LifeTo0Exception e) {

        }
        
    }
    @Test
    void testDetach() {
        try {
            Stats stats1 = new Stats(11, 10, 10, 10, 10, 10, 10);
            Stats stats2 = new Stats(10, 10, 10, 10, 10, 10, 10);
            Stats result = stats1.detach(stats2);
            assertEquals(result.getLifePoints(), 1);
            assertEquals(result.getStaminia(), 0);
            assertEquals(result.getStrength(), 0);
            assertEquals(result.getIntel(), 0);
            assertEquals(result.getMental(), 0);
            assertEquals(result.getAgility(), 0);
            assertEquals(result.getExperience(), 10);
            assertEquals(result.getArmor(), 0);
            assertEquals(result.getInitiative(), 0);
            stats1 = new Stats(20, 20, 20, 20, 20, 20, 20);
            stats2 = new Stats(10, 10, 10, 10, 10, 10, 10);
            result = stats1.detach(stats2);
            assertEquals(result.getLifePoints(), 10);
            assertEquals(result.getStaminia(), 10);
            assertEquals(result.getStrength(), 10);
            assertEquals(result.getIntel(), 10);
            assertEquals(result.getMental(), 10);
            assertEquals(result.getAgility(), 10);
            assertEquals(result.getExperience(), 20);
            assertEquals(result.getArmor(), 5);
            assertEquals(result.getInitiative(), 5);
        } catch (LifeTo0Exception e) {
            
        }
    }
}
