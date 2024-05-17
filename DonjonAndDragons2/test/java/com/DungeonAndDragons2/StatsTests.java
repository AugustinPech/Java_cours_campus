package DonjonAndDragons2.test.java.com.DungeonAndDragons2;

import DonjonAndDragons2.src.models.Game.Menu;
import DonjonAndDragons2.src.models.Game.utilities.status.Status;

import org.junit.jupiter.api.Test;

import DonjonAndDragons2.src.models.Game.utilities.Stats;
import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Caracters.NPC.Gobelin;
import DonjonAndDragons2.src.models.Caracters.Player.Warrior;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

class StatsTests {

    @Test
    void testMerge() {
        Stats stats1 = new Stats(10, 10, 10, 10, 10, 10, 10);
        Stats stats2 = new Stats(10, 10, 10, 10, 10, 10, 10);
        Stats result = stats1.merge(stats2);
        Stats expected = new Stats(20, 20, 20, 20, 20, 20, 20);
        assertEquals(result.getLifePoints(), expected.getLifePoints());
        assertEquals(result.getStaminia(), expected.getStaminia());
        assertEquals(result.getStrength(), expected.getStrength());
        assertEquals(result.getIntel(), expected.getIntel());
        assertEquals(result.getMental(), expected.getMental());
        assertEquals(result.getAgility(), expected.getAgility());
        assertEquals(result.getExperience(), expected.getExperience());
        assertEquals(result.getArmor(), expected.getArmor());
        assertEquals(result.getInitiative(), expected.getInitiative());
    }
    @Test
    void testDetach() {
        Stats stats1 = new Stats(10, 10, 10, 10, 10, 10, 10);
        Stats stats2 = new Stats(10, 10, 10, 10, 10, 10, 10);
        Stats result = stats1.detach(stats2);
        Stats expected = new Stats(0, 0, 0, 0, 0, 0, 10);
        assertEquals(result.getLifePoints(), expected.getLifePoints());
        assertEquals(result.getStaminia(), expected.getStaminia());
        assertEquals(result.getStrength(), expected.getStrength());
        assertEquals(result.getIntel(), expected.getIntel());
        assertEquals(result.getMental(), expected.getMental());
        assertEquals(result.getAgility(), expected.getAgility());
        assertEquals(result.getExperience(), expected.getExperience());
        assertEquals(result.getArmor(), expected.getArmor());
        assertEquals(result.getInitiative(), expected.getInitiative());
    }
}
