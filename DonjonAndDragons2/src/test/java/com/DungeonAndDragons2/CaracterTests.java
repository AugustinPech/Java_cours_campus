package DonjonAndDragons2.src.test.java.com.DungeonAndDragons2;

import DonjonAndDragons2.src.models.Game.utilities.status.Status;

import org.junit.jupiter.api.Test;

import DonjonAndDragons2.src.models.Game.Exception.CaracterIsDeadException;
import DonjonAndDragons2.src.models.Game.utilities.Stats;
import DonjonAndDragons2.src.models.Caracters.Caracter;
import DonjonAndDragons2.src.models.Caracters.NPC.Gobelin;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class CaracterTests {
    @Test
    void testApplyStatus(){
        try {
            Caracter caracter = new Gobelin(2);
            ArrayList<Status> statuses = new ArrayList<>();
            Stats stats = new Stats(1, 0, 5, 5, 5, 5, 0);
            
            statuses.add(new Status(stats, 1, "poison"));
            statuses.add(new Status(stats, 0, "poison"));
            statuses.add(new Status(stats, 2, "poison"));

            caracter. setStatuses(statuses);
            for (Status status : statuses) {
                caracter.applyStatuses();
            }
            assertEquals(1, caracter.getStatuses().size());
        } catch (CaracterIsDeadException e) {
            
        }
    }
    @Test
    void testAddStatus(){
        Caracter caracter = new Gobelin(2);
        caracter.addStatus(new Status(new Stats(100, 0, 5, 5, 5, 5, 0), 1, "poison"));

        assertEquals(1, caracter.getStatuses().size());
    }
}
