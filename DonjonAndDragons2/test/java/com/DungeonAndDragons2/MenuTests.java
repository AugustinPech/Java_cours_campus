package DonjonAndDragons2.test.java.com.DungeonAndDragons2;

import DonjonAndDragons2.src.models.Caracters.Player.Player;
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
    
    @Test
    void testChooseCaracterMenu() {
        InputStream[] in = {
            new ByteArrayInputStream("1".getBytes()),
            new ByteArrayInputStream("2\n3".getBytes()),
            new ByteArrayInputStream("1\n2".getBytes()),
        };
        Player.PlayerType[] ExpectedOut = {
            Player.PlayerType.WARRIOR,
            Player.PlayerType.WIZARD,
            Player.PlayerType.WARRIOR
        };
        for (int i =0 ; i < in.length; i++) {
            Menu menu = new Menu(in[i]);
            Player.PlayerType classRef = menu.chooseCaracterMenu();
            assertEquals(classRef, ExpectedOut[i]);
        }
    }
    @Test
    void testRegexCheck() {
        Menu menu = new Menu(System.in);
        String regex = "^(?:EASY|MEDIUM|HARD)$";
        String answer = "EASY";
        String result = menu.regexCheck(regex, answer);
        assertEquals(result, answer);
    }
    @Test
    void testMainPhaseMenu(){
        InputStream[] in = {
            new ByteArrayInputStream("\n".getBytes()),
            new ByteArrayInputStream("c\n".getBytes()),
            new ByteArrayInputStream("i\n".getBytes()),
            new ByteArrayInputStream("e\n".getBytes()),
            new ByteArrayInputStream("q\n".getBytes()),
        };
        String[] expected = {
            "",
            "C",
            "I",
            "E",
            "Q"
        };
        for (int i =0 ; i < in.length; i++) {
            Menu menu = new Menu(in[i]);
            String result = menu.mainPhaseMenu();
            assertEquals(result, expected[i]);
        }
    }
}