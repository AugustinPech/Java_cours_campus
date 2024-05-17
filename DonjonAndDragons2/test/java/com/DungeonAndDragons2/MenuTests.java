package DonjonAndDragons2.test.java.com.DungeonAndDragons2;

import DonjonAndDragons2.src.models.Game.Menu;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class MenuTests {

    @Test
    void testGetDifficulty() {
        InputStream[] in = {
            new ByteArrayInputStream("easy".getBytes()),
            new ByteArrayInputStream("medium".getBytes()),
            new ByteArrayInputStream("hard".getBytes()),
            new ByteArrayInputStream("EAS\neasy".getBytes()),
        };
        String[] ExpectedOut = {
            "EASY",
            "MEDIUM",
            "HARD",
            "EASY"
        };
        for (int i =0 ; i < in.length; i++) {
            Menu menu = new Menu(in[i]);
            String difficulty = menu.getDifficulty();
            assertEquals(difficulty, ExpectedOut[i]);
        }
    }
    
}