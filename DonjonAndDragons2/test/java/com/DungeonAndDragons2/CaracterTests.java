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

class CaracterTests {
     @Test
    void testApplyStatus(){
        Caracter caracter = new Gobelin(2);
        ArrayList<Status> statuses = new ArrayList<>();
        Stats stats = new Stats(100, 0, 5, 5, 5, 5, 0);
        
        statuses.add(new Status(stats, 1, "poison"));
        statuses.add(new Status(stats, 0, "poison"));
        statuses.add(new Status(stats, 2, "poison"));

        caracter. setStatuses(statuses);
        for (Status status : statuses) {
            caracter.applyStatuses();
        }
        assertEquals(1, caracter.getStatuses().size());
    }
    @Test
    void testAddStatus(){
        Caracter caracter = new Gobelin(2);
        caracter.addStatus(new Status(new Stats(100, 0, 5, 5, 5, 5, 0), 1, "poison"));

        assertEquals(1, caracter.getStatuses().size());
    }
}
